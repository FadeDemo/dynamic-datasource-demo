package org.fade.demo.mybatis.nat5.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>数据源配置</p>
 * @author fade
 */
@Configuration
public class DataSourceConfiguration implements BeanFactoryAware {

    private ListableBeanFactory beanFactory;

    @Bean(DataSourceKey.SOURCE)
    @ConfigurationProperties("spring.datasource.source")
    public DataSource source() {
        return DataSourceBuilder.create().build();
    }

    @Bean(DataSourceKey.REPLICA)
    @ConfigurationProperties("spring.datasource.replica")
    public DataSource replica() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSource dynamic() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<String, DataSource> beans = beanFactory.getBeansOfType(DataSource.class);
        var targetDataSources = new HashMap<Object, Object>(beans);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if (beanFactory instanceof ListableBeanFactory listableBeanFactory) {
            this.beanFactory = listableBeanFactory;
        } else {
            throw new RuntimeException("BeanFactory is wrong!");
        }
    }

    /**
     * <p>创建事务管理器，注入动态数据源</p>
     * */
    @Bean
    public PlatformTransactionManager platformTransactionManager(@Qualifier("dynamic") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * <p>创建{@link SqlSessionFactory}，注入动态数据源</p>
     * @see org.mybatis.spring.SqlSessionFactoryBean
     * */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamic") DataSource dataSource) throws Exception {
        var sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

}
