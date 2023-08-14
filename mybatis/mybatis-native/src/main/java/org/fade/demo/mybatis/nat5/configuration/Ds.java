package org.fade.demo.mybatis.nat5.configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>动态数据源注解</p>
 * @author fade
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Ds {

    /**
     * <p>数据源key</p>
     * */
    String value() default DataSourceKey.REPLICA;

}
