package org.fade.demo.mybatis.nat5.configuration;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;

/**
 * <p>动态数据源切点</p>
 * @author fade
 */
public class DynamicDataSourcePointcut extends StaticMethodMatcherPointcut {


    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return ObjectUtils.isEmpty(method.getAnnotation(Ds.class));
    }

}
