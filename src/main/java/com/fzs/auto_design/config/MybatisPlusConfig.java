package com.fzs.auto_design.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.fzs.auto_design.mapper*", sqlSessionFactoryRef = "SqlSessionFactory")
public class MybatisPlusConfig {

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean(name = "druid")
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSource() {
        return DruidDataSourceBuilder
                .create()
                .build();
    }

    @Bean(name = "globalConfig")
    @ConfigurationProperties("mybatis-plus")
    public GlobalConfiguration globalConfig() {
        return new GlobalConfiguration();
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "druid") DataSource dataSource,
                                               PaginationInterceptor paginationInterceptor,
                                               @Qualifier(value = "globalConfig") GlobalConfiguration globalConfig)
            throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/com/fzs/*/mapper/*Mapper.xml"));
        bean.setPlugins(new Interceptor[]{paginationInterceptor});
        bean.setGlobalConfig(globalConfig);
        return bean.getObject();
    }
}
