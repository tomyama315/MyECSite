package com.internousdev.template1.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.BuyItemDAO;
import com.internousdev.template1.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {
	private int count;
	private String pay;
	public Map<String,Object> session;
	private String result;
	BuyItemDTO dto=new BuyItemDTO();

	public String execute(){
		result=SUCCESS;
		ArrayList<BuyItemDTO> list=new ArrayList<>();
		list=new BuyItemDAO().getBuyItemInfo();
		session.put("list",list);
		System.out.print(list.size());
		session.put("count",count);
		/*int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price", intCount*intPrice);
		String payment;
		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay", payment);
		}else{
			payment="クレジットカード";
			session.put("pay", payment);
		}*/
		return result;
	}
	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count=count;
	}
	public String getPay(){
		return pay;
	}
	public void setPay(String pay){
		this.pay=pay;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
