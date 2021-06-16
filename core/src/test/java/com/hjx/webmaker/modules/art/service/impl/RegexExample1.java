package com.hjx.webmaker.modules.art.service.impl;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class RegexExample1 {
    private static final Pattern CHINA_PATTERN = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");

    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        Matcher m = CHINA_PATTERN.matcher(str);
        return m.matches();
    }

    public static void main(String[] args) {
     /* String content = "I am noob from runoob.com.";
      String pattern = ".*runoob.*";
      boolean isMatch = Pattern.matches(pattern, content);
      System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);

      content = "13926205227";
      pattern = "^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\\\d{8}$";
      Pattern p = Pattern.compile(pattern);
      Matcher m = p.matcher(content);
      boolean macth = isChinaPhoneLegal(content);

      System.out.println("是否命中了规则：" + macth);*/

        String mysqlDriver = "com.mysql.cj.jdbc.Driver";
        String schema = "sec_schema";
        String url = "jdbc:mysql://localhost:3306/"+schema;

        String webMakerUrl = "jdbc:mysql://localhost:3306/webmaker";
        String username = "root";
        String password = "root";
        Connection conn = null;
        QueryRunner runner = null;

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sec_schema");
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        /*try {
            Class.forName(mysqlDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Statement statement = null;
        String sec_rules_sql = "select * from sec_rule order by create_time desc ";
        ResultSet resultSet = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn.getSchema());
            *//*if (conn != null) {
                statement = conn.createStatement();
            }

            resultSet = statement.executeQuery(sec_rules_sql);*//*
            // 查询出来规则对象，遍历它们。
            List<Object> list = runner.query(conn, sec_rules_sql, new BeanListHandler<Object>(Object.class));
            System.out.println(list.size());
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
         *//*if(conn!=null){
            try{
               conn.close();
            }catch (SQLException e){
               e.printStackTrace();
            }

         }*//*
        }*/

        // --- 数据库元对象信息。
        DatabaseMetaData dbMetaDate = null;
        ResultSet rsTables = null;
        ResultSet rsColimns = null;
        conn = null;
        List<String> tables = new ArrayList<String>();


        try {
            conn = dataSource.getConnection();
            runner = new QueryRunner();

            //------- 获取表
            String useDatabasesSql = "show tables";
            List<Object[]> ts = runner.query(conn, useDatabasesSql, new ArrayListHandler());
            for (Object[] objs : ts) {
                for (Object obj : objs) {
                    tables.add(obj.toString());
                }
            }

            for (String table : tables) {
                String selectColSql = "select column_name from information_schema.columns where table_name=?";
                List<Object[]> columns = runner.query(conn, selectColSql, new ArrayListHandler(), table);
                for (Object[] objs : columns) {
                    for (Object obj : objs) {
                        String colName = obj.toString();
                        String select_column_sql = "select " + colName + " from " + table + " order by " + colName + " desc LIMIT 0,1000";
                        List<Object[]> colContent = runner.query(conn, select_column_sql, new ArrayListHandler());
                        if (colContent != null) {
                            for (Object[] colContentObjs : colContent) {
                                if (colContentObjs != null) {
                                    for (Object colContentObj : colContentObjs) {
                                        if (colContentObj != null) {
                                            System.out.println("数据库："+schema+",表："+table+",字段:"+colName+",内容："+colContentObj.toString());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            dbMetaDate = conn.getMetaData();
            String showDatabasesSql = "show databases";
            List<Object[]> databases = runner.query(conn, showDatabasesSql, new ArrayListHandler());
            for (Object[] objs : databases) {
                for (Object obj : objs) {
                    System.out.print(obj + "  ");
                }
                System.out.println();
            }



            /*rsTables = dbMetaDate.getTables(null, null, "%", new String[]{"TABLE"});
            while (rsTables.next()) {
                String tableName = rsTables.getString("TABLE_NAME");
                System.out.println("表名：" + tableName);
                tables.add(tableName);
                rsColimns = dbMetaDate.getColumns(null, "schema", tableName, "%");
                while (rsColimns.next()) {
                    String columnName = rsColimns.getString("COLUMN_NAME");
                    System.out.println("数据库名称：" + conn.getSchema() + "---------" + "表名：" + tableName + "------" + "字段名:" + rsColimns.getString("COLUMN_NAME") + "-------" + "类型:" + rsColimns.getString("TYPE_NAME") +
                            "------" + "长度：" + rsColimns.getString("COLUMN_SIZE") + "-----" + "备注：" + rsColimns.getString("REMARKS"));
                    System.out.println("-----------------------------------------");
                    String selectColumnSql = "select " + columnName + " from " + tableName + " order by " + columnName + " desc LIMIT 0,1000";
                    System.out.println(selectColumnSql);
                    List<Object[]> result = runner.query(conn, selectColumnSql, new ArrayListHandler());
                    for (Object[] objs : result) {
                        for (Object obj : objs) {
                            System.out.print(obj + "  ");
                        }
                        System.out.println();
                    }
                    System.out.println("-----------------------------------------");
                }
            }*/


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

}