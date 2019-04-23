package com.internousdev.template1.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.BuyItemCompleteDAO;
import com.internousdev.template1.dao.StockAdjustmentDAO;
import com.internousdev.template1.dto.AddCartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private ArrayList<AddCartDTO> list=new ArrayList<>();
	private String pay;
	StockAdjustmentDAO adjust=new StockAdjustmentDAO();

	public String execute()throws SQLException{
		list=(ArrayList<AddCartDTO>)session.get("StaticList");
		if(pay.equals("1")){
			String payment="現金";
			session.put("pay",payment);
		}else{
			String payment="クレジット";
			session.put("pay",payment);
		}
		for(AddCartDTO dto:list){
				 StockAdjustmentDAO dao=new StockAdjustmentDAO();
				 int i=dao.AdjustmentStock(dto.getId(),dto.getCount());
				 if(i==0){
					 session.put("Error", "error");
					 session.put("Erroritemname", dto.getItemName());
					 session.put("Erroritemid", dto.getId());
					 String result="STAY";
						return result;
				 }
		BuyItemCompleteDAO buyItemCompleteDAO=new BuyItemCompleteDAO();
		buyItemCompleteDAO.BuyItemInfo(dto.getId(),session.get("login_user_id").toString(),dto.getItemPrice(),dto.getCount(),session.get("pay").toString(),dto.getInsertbyid(),dto.getItemName());
		}
		session.remove("StaticList");
		String result=SUCCESS;
		return result;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public ArrayList<AddCartDTO> getList() {
		return list;
	}
	public void setList(ArrayList<AddCartDTO> list) {
		this.list = list;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
}
