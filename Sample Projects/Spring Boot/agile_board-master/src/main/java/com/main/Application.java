package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main application to run boot application.
 * 
 * @author Shweta
 * @version 1.0
 */
@SpringBootConfiguration
@SpringBootApplication
@ComponentScan(basePackages="com")
public class Application {
	
    public static void main(String[] args) throws Exception {       
        SpringApplication.run(Application.class, args);
    }
    
}