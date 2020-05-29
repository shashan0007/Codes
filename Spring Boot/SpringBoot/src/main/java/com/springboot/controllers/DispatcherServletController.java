package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.beans.Bean1;
import com.springboot.beans.Bean2;
import com.springboot.beans.Bean3;

@Controller
public class DispatcherServletController {
	
	@Autowired
	private Bean1 bean1;
	
	@Autowired
	private Bean2 bean2;
	
	@Autowired
	private Bean3 bean3;
	
	@RequestMapping("/")
	@ResponseBody
	public String getMessage() {
		return "<h1>Hello</h1>";
	}
	
	@RequestMapping("/bean1")
	@ResponseBody
	public String getBean1Message() {
		return bean1.printBean1();
	}
	
	@RequestMapping("/bean2")
	@ResponseBody
	public String getBean2Message() {
		return bean2.print();
	}
	
	@RequestMapping("/bean3")
	@ResponseBody
	public String getBean3Message() {
		return bean3.print();
	}
}
