package com.example.app.dataSource;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/*作用于类上
 * 表名这个类可以理解为一个XML配置文件
 * */
@Configuration
/*
 * 读取配置文件
 */
/*@PropertySource("classpath:database.properties")*/
public class DataSourceConfig {
	@Bean(name="dataSource")
	@Primary//用@Primary区分主数据源
	@ConfigurationProperties(prefix="c3p0")//指定配置文件中，前缀为c3p0的属性值
	public DataSource dataSource(){
		return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
	}
	 /**
	    *返回sqlSessionFactory
	    */
	    @Bean
	    public SqlSessionFactoryBean sqlSessionFactoryBean(){
	        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
	        sqlSessionFactory.setDataSource(dataSource());
	        return sqlSessionFactory;
	    }
}
