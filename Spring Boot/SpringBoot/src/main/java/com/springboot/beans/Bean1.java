package com.springboot.beans;

public class Bean1 {

	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String printBean1() {
		return(this.getId() + ":" + this.getName());
	}
}
