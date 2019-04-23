package com.internousdev.template1.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.AddCartDAO;
import com.internousdev.template1.dto.AddCartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ShowDetailAction extends ActionSupport implements SessionAware{
	private String id;
	public Map<String,Object> session;
	AddCartDAO dao=new AddCartDAO();
	public String execute(){
		try{
			AddCartDTO dto=dao.SearchAddItem(Integer.parseInt(id));
			session.put("adcdto", dto);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
