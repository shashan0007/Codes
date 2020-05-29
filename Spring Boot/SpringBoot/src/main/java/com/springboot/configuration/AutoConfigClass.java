package com.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.beans.Bean1;
import com.springboot.beans.Bean2;

@Configuration
public class AutoConfigClass {
	
	@Bean
	public Bean1 getBean1() {
		Bean1 obj = new Bean1();
		obj.setId(1);
		obj.setName("Ashish");
		return obj;
	}
	
	@Bean
	public Bean2 getBean2() {
		Bean2 obj = new Bean2();
		return obj;
	}
}
