package org.fade.demo.mybatis.nat5.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p>动态数据源</p>
 * @author fade
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }

}
