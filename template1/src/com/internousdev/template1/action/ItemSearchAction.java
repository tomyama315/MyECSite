package com.internousdev.template1.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.ItemSearchDAO;
import com.internousdev.template1.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemSearchAction extends ActionSupport implements SessionAware{
	private String Key;
	private Map<String,Object> session;
	private ArrayList<BuyItemDTO> BIlist=new ArrayList<>();
	ItemSearchDAO dao=new ItemSearchDAO();
	public String execute(){
		String result=SUCCESS;
		session.put("Key", Key);
		try{
			BIlist=dao.SearchAddItem(Key);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<BuyItemDTO> getBIList() {
		return BIlist;
	}
	public void setBIList(ArrayList<BuyItemDTO> list) {
		this.BIlist = list;
	}

}