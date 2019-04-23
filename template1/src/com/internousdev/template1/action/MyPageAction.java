package com.internousdev.template1.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.MyPageDAO;
import com.internousdev.template1.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MyPageAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	public String deleteFlg;
	private String result;
	private String message;
	private ArrayList<MyPageDTO> myPageList=new ArrayList<MyPageDTO>();
	private MyPageDAO myPageDAO=new MyPageDAO();

	public String execute() throws SQLException{
		if(!session.containsKey("login_user_id")){
			return ERROR;
		}
		if(deleteFlg==null){
			String user_master_id=session.get("login_user_id").toString();
			myPageList=myPageDAO.getMyPageUserInfo(user_master_id);
		}else if(deleteFlg.equals("1")){
			delete();
		}
		result=SUCCESS;
		return result;
	}

	public void delete() throws SQLException{
		String user_master_id=session.get("login_user_id").toString();
		int res=myPageDAO.buyItemHistoryDelete(user_master_id);
		if(res>0){
			myPageList.removeAll(myPageList);
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}
	public String getDeleteFlg(){
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}
	public void setSession(Map<String,Object> loginSessionMap){
		this.session=loginSessionMap;
	}
	public ArrayList<MyPageDTO> getMyPageList(){
		return this.myPageList;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message=message;
	}

}
