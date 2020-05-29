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
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.example.manydatasource.business.mapper.test1",sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterRepositoryConfig {

    static final String MASTER_PACKAGE = "com.example.manydatasource.business.mapper.test1";

    @Value("${spring.datasource.dynamic.datasource.master.url}")
    private   String url;
    @Value("${spring.datasource.dynamic.datasource.master.username}")
    public  String username;
    @Value("${spring.datasource.dynamic.datasource.master.password}")
    public  String password;
    @Value("${spring.datasource.dynamic.datasource.master.driver-class-name}")
    public  String driverclassname;

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource masterDataSource() {
        Properties p = new Properties();
        p.setProperty("url", url);
        p.setProperty("user", username);
        p.setProperty("password", password);

        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setUniqueResourceName("masterDataSource");
        ds.setXaDataSourceClassName(driverclassname);
        ds.setXaProperties(p);
        ds.setPoolSize(5);
        return ds;
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setTypeAliasesPackage(MASTER_PACKAGE);
        fb.setDataSource(dataSource);
        return fb.getObject();
    }


    @Bean(name = "masterSqlSessionTemplate")
     @Primary
     public SqlSessionTemplate sqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
       SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
       return sqlSessionTemplate;
    }
}
