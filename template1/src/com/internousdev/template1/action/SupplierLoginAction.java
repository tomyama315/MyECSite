package com.internousdev.template1.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.BuyItemDAO;
import com.internousdev.template1.dao.SupplierLoginDAO;
import com.internousdev.template1.dto.SupplierLoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SupplierLoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String result;
	private Map<String,Object> session;
	private SupplierLoginDAO loginDAO=new SupplierLoginDAO();
	private SupplierLoginDTO loginDTO=new SupplierLoginDTO();
	private BuyItemDAO buyItemDAO=new BuyItemDAO();

	public String execute(){
		result=ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		if(((SupplierLoginDTO)session.get("loginUser")).getLoginFlg()){
			result=SUCCESS;

			session.put("login_user_id", loginDTO.getLoginId());
			return result;

		}
		return result;
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
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}
