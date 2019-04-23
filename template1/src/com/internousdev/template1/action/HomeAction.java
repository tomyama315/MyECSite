package com.internousdev.template1.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.BuyItemDAO;
import com.internousdev.template1.dao.HistoryofboughtDAO;
import com.internousdev.template1.dto.BuyItemDTO;
import com.internousdev.template1.dto.HistoryofboughtDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private ArrayList<BuyItemDTO> list=new ArrayList<>();
	private BuyItemDAO buyItemDAO=new BuyItemDAO();
	private ArrayList<BuyItemDTO> BIList=new ArrayList<>();
	private ArrayList<HistoryofboughtDTO> HBList=new ArrayList<>();

	public String execute(){ //アイテムリスト(BuyItemDTO)をlistへ、それをHALISTへ
		String result="login";
		session.remove("Key");
		if(session.containsKey("login_user_id")){
			if(session.containsKey("root")){
				result="root";
				HistoryofboughtDAO dao=new HistoryofboughtDAO();
				HBList=dao.getHOB(session.get("login_user_id").toString());
				return result;
			}
			BuyItemDAO buyItemDAO=new BuyItemDAO();
			list=buyItemDAO.getBuyItemInfo();
			session.put("HALIST",list);
			BIList=buyItemDAO.getBuyItemInfo();
			 result=SUCCESS;
		}
		return result;
	}
	public ArrayList<BuyItemDTO> getBIList() {
		return BIList;
	}
	public void setBIList(ArrayList<BuyItemDTO> bIList) {
		BIList = bIList;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
	public ArrayList<BuyItemDTO> getList() {
		return list;
	}
	public void setList(ArrayList<BuyItemDTO> list) {
		this.list = list;
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
