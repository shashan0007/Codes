package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDependencyManagementApplication {

	@Bean
	public MyBean getBean() {
		return new MyBean();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootDependencyManagementApplication.class, args);
		MyBean bean = ctx.getBean(MyBean.class);
		bean.runMethod();
	}
	
	private static class MyBean {
		public void runMethod() {
			System.out.println("Here!!");
		}
		
	}

}
