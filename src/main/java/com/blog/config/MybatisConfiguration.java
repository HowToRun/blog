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

    //  配置类型别名
    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    //  加载全局的配置文件
    @Value("${mybatis.configLocation}")
    private String configLocation;

    @javax.annotation.Resource
    private DataSource dataSource;


   @Bean
   public SqlSessionFactory sqlSessionFactory(){
        try{
            SqlSessionFactoryBean sessionFactoryBean  = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource);
            sessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);

            //Resource[] resources = new PathMatchingResourcePatternResolver().getResources(mapperLocations);
            //sessionFactoryBean.setMapperLocations(resources);

            //添加插件
            Interceptor[] plugins = new Interceptor[]{pageHelper(),sqlPrintInterceptor()};

            sessionFactoryBean.setPlugins(plugins);
            return sessionFactoryBean.getObject();
        }catch (IOException e){
            e.printStackTrace();
            logger.error("mybatis resolver mapper*xml is error", e);
            return null;
        }catch (Exception e1){
            e1.printStackTrace();
            logger.error("mybatis sqlSessionFactoryBean create error", e1);
            return null;
        }

    }

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
