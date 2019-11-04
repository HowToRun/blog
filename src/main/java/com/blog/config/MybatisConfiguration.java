package com.blog.config;

import com.blog.interceptor.SqlPrintInterceptor;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;


/**
 * @Author: yihan.hu
 * @Date: 2018/10/27
 * @Description:
 */
@Configuration
public class MybatisConfiguration implements TransactionManagementConfigurer{
    private static Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);


    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;



    @javax.annotation.Resource
    private DataSource dataSource;


    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    /**
     * 事物管理
     * @return
     */
    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    //将要执行的sql进行日志打印(不想拦截，就把这方法注释掉)
    @Bean
    public SqlPrintInterceptor sqlPrintInterceptor() {
        return new SqlPrintInterceptor();
    }


    /**
     * 分页插件
     */
    public PageHelper pageHelper(){

        PageHelper pageHelper  = new PageHelper();
        Properties  p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("returnPageInfo", "check");
        p.setProperty("params", "count=countSql");
        pageHelper.setProperties(p);
        return pageHelper;

    }
}
