package org.fade.demo.mybatis.nat5.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;

/**
 * <p>数据源配置</p>
 * @author fade
 */
@Configuration
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.source")
    public DataSource source() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.replica")
    public DataSource replica() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSource dynamic(List<DataSource> dataSources) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        return dynamicDataSource;
    }

}
