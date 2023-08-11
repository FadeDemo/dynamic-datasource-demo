package org.fade.demo.mybatis.nat5.configuration;

import org.springframework.util.ObjectUtils;

/**
 * <p>动态数据源线程上下文</p>
 * @author fade
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> CONTEXT = new ThreadLocal<>();

    public static void addContextKey(DataSourceKey key) {
        CONTEXT.set(key.name());
    }

    public static String getContextKey() {
        String key = CONTEXT.get();
        return ObjectUtils.isEmpty(key) ? DataSourceKey.REPLICA.name() : key;
    }

    public static void removeContextKey() {
        // 预防内存泄露
        CONTEXT.remove();
    }

}
