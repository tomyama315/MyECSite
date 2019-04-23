package com.internousdev.template1.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.FindIdDAO;
import com.internousdev.template1.dao.SupplierCreateAccountCompleteDAO;
import com.internousdev.template1.dto.SupplierLoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SupplierCreateAccountCompleteAction extends ActionSupport implements SessionAware{
	private String id;
	private String password;
	private String name;
	private Map<String,Object>session;
	private SupplierCreateAccountCompleteDAO DAO=new SupplierCreateAccountCompleteDAO();

	public String execute() throws SQLException{
		DAO.createAccount(session.get("Password").toString(), session.get("Name").toString());
		FindIdDAO find=new FindIdDAO();
		SupplierLoginDTO found=find.getNewUserId(session.get("Password").toString(), session.get("Name").toString());
		session.put("Id",found.getLoginId());
		//System.out.print(found.getLoginId());
		String result=SUCCESS;
		return result;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
