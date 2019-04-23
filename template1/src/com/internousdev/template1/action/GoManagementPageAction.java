package com.internousdev.template1.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.HistoryofboughtDAO;
import com.internousdev.template1.dto.HistoryofboughtDTO;
import com.opensymphony.xwork2.ActionSupport;


public class GoManagementPageAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private ArrayList<HistoryofboughtDTO> HBList=new ArrayList<>();
	public String execute(){
		HistoryofboughtDAO dao=new HistoryofboughtDAO();
		HBList=dao.getHOB(session.get("login_user_id").toString());
		return SUCCESS;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public ArrayList<HistoryofboughtDTO> getHBList() {
		return HBList;
	}
	public void setHBList(ArrayList<HistoryofboughtDTO> hBList) {
		HBList = hBList;
	}


}