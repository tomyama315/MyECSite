package com.internousdev.template1.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.BuyItemDAO;
import com.internousdev.template1.dao.HistoryofboughtDAO;
import com.internousdev.template1.dao.LoginDAO;
import com.internousdev.template1.dto.BuyItemDTO;
import com.internousdev.template1.dto.HistoryofboughtDTO;
import com.internousdev.template1.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String result;
	private Map<String,Object> session;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();
	private BuyItemDAO buyItemDAO=new BuyItemDAO();
	private ArrayList<BuyItemDTO> BIList=new ArrayList<>();
	private ArrayList<HistoryofboughtDTO> HBList=new ArrayList<>();

	public void setBIList(ArrayList<BuyItemDTO> bIList) {
		BIList = bIList;
	}

	public ArrayList<BuyItemDTO> getBIList() {
		return BIList;
	}

	public String execute(){ //アイテム情報はBIListに入れてからセッションBILISTへ
		result=ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		if(session.get("login_user_id")!=null){ //add
			result=SUCCESS;
			BIList=buyItemDAO.getBuyItemInfo();
			session.remove("Key");
		}
		session.put("loginUser", loginDTO);
		session.put("username", loginDTO.getUserName());
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result=SUCCESS;
			session.put("login_user_id", loginDTO.getLoginId());
			if(((LoginDTO)session.get("loginUser")).getRoot()==1){
				session.put("root",1);
				HistoryofboughtDAO dao=new HistoryofboughtDAO();
				HBList=dao.getHOB(session.get("login_user_id").toString());
				result="root";
			}
			BIList=buyItemDAO.getBuyItemInfo();
			session.remove("Key");

			/*for(BuyItemDTO dto:BIList){
				System.out.println(dto.getItemName());
			}*/

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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	public BuyItemDAO getBuyItemDAO() {
		return buyItemDAO;
	}

	public void setBuyItemDAO(BuyItemDAO buyItemDAO) {
		this.buyItemDAO = buyItemDAO;
	}

	public ArrayList<HistoryofboughtDTO> getHBList() {
		return HBList;
	}

	public void setHBList(ArrayList<HistoryofboughtDTO> hBList) {
		HBList = hBList;
	}
}
