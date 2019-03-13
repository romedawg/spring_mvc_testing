package com.romedawg.rome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class RomeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RomeApplication.class, args);
	}

	@Autowired
    JdbcTemplate jdbcTemplate;

    public void run(String...strings) throws Exception{
        logger.info("Creating Tables");
    }


}

