package com.romedawg.rome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class RomeApplication extends SpringBootServletInitializer {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

	public static void main(String[] args) {
		SpringApplication.run(RomeApplication.class, args);
	}

}

