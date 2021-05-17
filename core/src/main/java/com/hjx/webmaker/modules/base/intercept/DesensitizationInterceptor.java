package com.hjx.webmaker.modules.base.intercept;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.util.*;
import java.util.regex.Matcher;

/**
 * mybatis脱敏处理
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),})
public class DesensitizationInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(DesensitizationInterceptor.class);
    private boolean desensitization = true;//脱敏
    private String schema;
    private String host;
    private String port;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object result = invocation.proceed();

        //如果需要对结果脱敏，则执行
        if (desensitization) {
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            //0.sql参数获取
            Object parameter = null;
            if (invocation.getArgs().length > 1) {
                parameter = invocation.getArgs()[1];
            }
            //1.获取sqlId
            String sqlId = mappedStatement.getId();
            BoundSql boundSql = mappedStatement.getBoundSql(parameter);
            Configuration configuration = mappedStatement.getConfiguration();
/*            Connection connection = configuration.getEnvironment().getDataSource().getConnection();
            connection.getClientInfo();
            String schema = configuration.getDatabaseId();
            System.out.println(schema);*/
            //获取真实的sql语句
            String sql = getSql(configuration, boundSql, sqlId, 0);

            logger.info("本次运行的SQL语句是：{}", sql);
            if (sql.trim().toLowerCase().startsWith("select")) {
                String sql2 = sql.trim().toLowerCase();
                int selectIndex = sql2.indexOf("select");
                int fromIndex = sql2.indexOf("from");
                String fieldsStr = sql2.substring(selectIndex + "select".length(), fromIndex);
                logger.info("字段是：{}", fieldsStr);
                String[] fieldsArr = fieldsStr.split(",");
                for (String f: fieldsArr) {
                    f = f.trim();
                    // 空格
                    int trimIndex = f.indexOf(" ");
                    if(trimIndex != -1){
                        // --- 有别名的处理情况。
                        f = f.substring(0,trimIndex);
                    }
                    int dotIndex = f.indexOf(".");
                    if(dotIndex != -1){
                        f= f.substring(dotIndex+1,f.length());
                    }
                    logger.info("筛选后的数据库字段是：{}",f);
                }
            }

            if (result instanceof ArrayList<?>) {
                List<?> list = (ArrayList<?>) result;
                return this.desensitization(list);
            } else {
                return this.desensitization(result);
            }
        }

        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    /**
     * 对返回结果脱敏
     *
     * @param list
     * @return
     */
    private List desensitization(List list) {
        Class cls = null;
        Field[] objFields = null;
        if (list != null && list.size() > 0) {
            for (Object o : list) {
                if (cls == null) {
                    cls = o.getClass();
                    cls.getSuperclass();
                    objFields = cls.getDeclaredFields();
                    //
//                    objFields = cls.getSuperclass().getDeclaredFields();
                }

                if (objFields != null) {
                    for (Field field : objFields) {
                        Desensitization desensitization;

                        if ("serialVersionUID".equals(field.getName())) {
                            continue;
                        }

                        if (String.class != field.getType() || (desensitization = field.getAnnotation(Desensitization.class)) == null) {
                            continue;
                        }

                        logger.info("匹配到表名：" + desensitization.tableName() + ",字段名：" + desensitization.fieldName() + "映射的Java Bean属性名：" + field.getName());
                        field.setAccessible(true);
                        String value = null;
                        try {
                            value = field.get(o) != null ? field.get(o).toString() : null;
                        } catch (IllegalArgumentException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                        if (value == null) {
                            continue;
                        }

                        List<String> regular;
                        DesensitionType type = desensitization.type();
                        switch (type) {
                            case CUSTOM:
                                regular = Arrays.asList(desensitization.attach());
                                break;
                            case TRUNCATE:
                                regular = truncateRender(desensitization.attach());
                                break;
                            default:
                                regular = Arrays.asList(type.getRegular());
                        }
                        if (regular.size() > 1) {
                            String match = regular.get(0);
                            String result = regular.get(1);
                            if (null != match && result != null && match.length() > 0) {
                                value = ((String) value).replaceAll(match, result);

                                try {
                                    field.set(o, value);
                                } catch (IllegalArgumentException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }


        return list;
    }

    private Object desensitization(Object obj) {
        Class cls = null;
        Field[] objFields = null;
        if (obj != null) {

            if (cls == null) {
                cls = obj.getClass();
                objFields = cls.getDeclaredFields();

                if (objFields != null) {
                    for (Field field : objFields) {
                        Desensitization desensitization;

                        if ("serialVersionUID".equals(field.getName())) {
                            continue;
                        }

                        if (String.class != field.getType() || (desensitization = field.getAnnotation(Desensitization.class)) == null) {
                            continue;
                        }
                        field.setAccessible(true);
                        String value = null;
                        try {
                            value = field.get(obj) != null ? field.get(obj).toString() : null;
                        } catch (IllegalArgumentException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                        if (value == null) {
                            continue;
                        }

                        List<String> regular;
                        DesensitionType type = desensitization.type();
                        switch (type) {
                            case CUSTOM:
                                regular = Arrays.asList(desensitization.attach());
                                break;
                            case TRUNCATE:
                                regular = truncateRender(desensitization.attach());
                                break;
                            default:
                                regular = Arrays.asList(type.getRegular());
                        }
                        if (regular.size() > 1) {
                            String match = regular.get(0);
                            String result = regular.get(1);
                            if (null != match && result != null && match.length() > 0) {
                                value = ((String) value).replaceAll(match, result);

                                try {
                                    field.set(obj, value);
                                } catch (IllegalArgumentException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }

        }


        return obj;
    }

    private List<String> truncateRender(String[] attachs) {
        List<String> regular = new ArrayList<>();
        if (null != attachs && attachs.length > 1) {
            String rule = attachs[0];
            String size = attachs[1];
            String template, result;
            if ("0".equals(rule)) {
                template = "^(\\S{%s})(\\S+)$";
                result = "$1";
            } else if ("1".equals(rule)) {
                template = "^(\\S+)(\\S{%s})$";
                result = "$2";
            } else {
                return regular;
            }
            try {
                if (Integer.parseInt(size) > 0) {
                    regular.add(0, String.format(template, size));
                    regular.add(1, result);
                }
            } catch (Exception e) {
                logger.warn("ValueDesensitizeFilter truncateRender size {} exception", size);
            }
        }
        return regular;
    }

    public boolean isDesensitization() {
        return desensitization;
    }

    public void setDesensitization(boolean desensitization) {
        this.desensitization = desensitization;
    }

    private static String getSql(Configuration configuration, BoundSql boundSql,
                                 String sqlId, long time) {
        String sql = showSql(configuration, boundSql);
        StringBuilder str = new StringBuilder(100);
//        str.append(sqlId);
//        str.append(":");
        str.append(sql);
        return str.toString();
    }

    private static String getParameterValue(Object obj) {
        String value = null;
        if (obj instanceof String) {
            value = "'" + obj.toString() + "'";
        } else if (obj instanceof Date) {
            DateFormat formatter = DateFormat.getDateTimeInstance(
                    DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
            value = "'" + formatter.format(new Date()) + "'";
        } else {
            if (obj != null) {
                value = obj.toString();
            } else {
                value = "";
            }

        }
        return value;
    }

    private static String showSql(Configuration configuration, BoundSql boundSql) {
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
        if (!parameterMappings.isEmpty() && parameterObject != null) {
            TypeHandlerRegistry typeHandlerRegistry = configuration
                    .getTypeHandlerRegistry();
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                sql = sql.replaceFirst("\\?",
                        Matcher.quoteReplacement(getParameterValue(parameterObject)));

            } else {
                MetaObject metaObject = configuration
                        .newMetaObject(parameterObject);
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        Object obj = boundSql
                                .getAdditionalParameter(propertyName);
                        sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
                    } else {
                        sql = sql.replaceFirst("\\?", "缺失");
                    }//打印出缺失，提醒该参数缺失并防止错位
                }
            }
        }
        return sql;
    }
}