package com.internousdev.template1.dto;

public class LoginDTO {
	private String loginId;
	private String loginPassword;
	private String userName;
	private int root;

	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	private boolean loginFlg=false;

	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId=loginId;
	}
	public String getLoginPssword(){
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
	public boolean getLoginFlg(){
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg){
		this.loginFlg=loginFlg;
	}

}
