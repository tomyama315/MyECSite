package com.internousdev.template1.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CertificationAction extends ActionSupport implements SessionAware{
	private String name;
	private int price;
	private int stock;
	private String comment;
	public Map<String,Object> session;
	public String execute(){
		String result=SUCCESS;
		session.put("name", name);
		session.put("price", price);
		session.put("stock", stock);
		session.put("comment", comment);

		return result;
	}


	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public String getComment() {
		return comment;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
