package com.hjx.webmaker.modules.base.intercept;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 脱敏注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Desensitization {
    /**
     * 脱敏规则类型
     *
     * @return
     */
    DesensitionType type();

    /**
     * 表名
     * @return
     */
    String tableName() default "";

    /**
     * 域名
     * @return
     */
    String fieldName() default "";
    /**
     * 附加值, 自定义正则表达式等
     *
     * @return
     */
    String[] attach() default "";
}