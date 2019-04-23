package com.internousdev.template1.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ThrowSelectUserAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	public String execute(){
		String result=SUCCESS;
		session.remove("IDT");
		session.put("IDT", "login_user_transaction");
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;

	}

}