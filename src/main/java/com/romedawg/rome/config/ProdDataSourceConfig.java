package com.romedawg.rome.config;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties("spring.datasource")
@Profile("prod")
public class ProdDataSourceConfig {

//    @Bean
//    public DataSource dataSource(){
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .build();
//    }
//
//@Bean
//public DataSource getDataSource() {
//    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//    dataSourceBuilder.driverClassName("org.h2.Driver");
//    dataSourceBuilder.url("jdbc:h2:mem:test");
//    dataSourceBuilder.username("SA");
//    dataSourceBuilder.password("");
//    return dataSourceBuilder.build();
//}

//    @PostConstruct
//    public void postConstruct() {
//        System.out.println("Started after Spring boot application !");
//
//    }
}
