package com.example.manydatasource.business.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.example.manydatasource.business.mapper.test2",sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SlaveRepositoryConfig {

    static final String SLAVE_PACKAGE = "com.example.manydatasource.business.mapper.test2";
    @Value("${spring.datasource.dynamic.datasource.slave.url}")
    private   String url;
    @Value("${spring.datasource.dynamic.datasource.slave.username}")
    public  String username;
    @Value("${spring.datasource.dynamic.datasource.slave.password}")
    public  String password;
    @Value("${spring.datasource.dynamic.datasource.slave.driver-class-name}")
    public  String driverclassname;

    @Bean(name = "slaveDataSource")
    public DataSource slaveDataSource() {
        Properties p = new Properties();
        p.setProperty("url", url);
        p.setProperty("user", username);
        p.setProperty("password", password);

        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setUniqueResourceName("slaveDataSource");
        ds.setXaDataSourceClassName(driverclassname);
        ds.setXaProperties(p);
        ds.setPoolSize(5);
        return ds;
    }

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setTypeAliasesPackage(SLAVE_PACKAGE);
        fb.setDataSource(dataSource);
        return fb.getObject();
    }


    @Bean(name = "slaveSqlSessionTemplate")
     public SqlSessionTemplate sqlSessionTemplate(@Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
       SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
       return sqlSessionTemplate;
    }
}
