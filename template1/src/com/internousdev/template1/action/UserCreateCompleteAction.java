package com.internousdev.template1.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String,Object>session;
	private UserCreateCompleteDAO userCreateCompleteDAO=new UserCreateCompleteDAO();

	public String execute() throws SQLException{
		String result=SUCCESS;
		//System.out.print(session.get("autholization"));

		if(Integer.parseInt(session.get("autholization").toString())==1){
			userCreateCompleteDAO.createAndautholizeUser(session.get("loginUserId").toString(), session.get("loginPassword").toString(), session.get("userName").toString(),session.get("login_user_id").toString(),session.get("autholization").toString());
			return result;
		}else if(session.containsKey("login_user_id")){
		userCreateCompleteDAO.createUser(session.get("loginUserId").toString(), session.get("loginPassword").toString(), session.get("userName").toString(),session.get("login_user_id").toString());
		return result;
		}else{
			userCreateCompleteDAO.createUserByNewUser(session.get("loginUserId").toString(), session.get("loginPassword").toString(), session.get("userName").toString());
			return result;
		}
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
