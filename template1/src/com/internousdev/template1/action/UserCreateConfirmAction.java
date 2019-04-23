package com.internousdev.template1.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String,Object> session;
	private String errorMessage;
	private int aut;

	public String execute(){
		String result=SUCCESS;
		//System.out.println(aut);
			if(!(loginUserId.equals(""))&&!(loginPassword.equals(""))&&!(userName.equals(""))&&!(aut==0)){
				session.put("loginUserId",loginUserId);
				session.put("loginPassword", loginPassword);
				session.put("userName",userName);
				session.put("autholization", aut);
				return result;
			}
		if(!(loginUserId.equals(""))&&!(loginPassword.equals(""))&&!(userName.equals("")&&(aut==0))){
			session.put("loginUserId",loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName",userName);
			session.put("autholization", aut);
		}else{
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
		return result;
	}
	public int getAut() {
		return aut;
	}
	public void setAut(int aut) {
		this.aut = aut;
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
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}

}
