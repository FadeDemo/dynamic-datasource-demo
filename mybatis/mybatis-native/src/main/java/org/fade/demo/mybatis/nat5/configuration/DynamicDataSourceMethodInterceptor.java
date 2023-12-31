package org.fade.demo.mybatis.nat5.configuration;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Objects;

/**
 * <p>动态数据源方法拦截器</p>
 * @author fade
 */
public class DynamicDataSourceMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Ds annotation = invocation.getMethod().getAnnotation(Ds.class);
        Objects.requireNonNull(annotation);
        String key = annotation.value();
        DynamicDataSourceContextHolder.addContextKey(key);
        return invocation.proceed();
    }

}
