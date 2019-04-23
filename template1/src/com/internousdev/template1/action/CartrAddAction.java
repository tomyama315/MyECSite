package com.internousdev.template1.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.AddCartDAO;
import com.internousdev.template1.dto.AddCartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartrAddAction extends ActionSupport implements SessionAware{
	private int id;
	private String itemName;
	private int itemPrice;
	private  int count;
	private int pay;
	private Map<String,Object> session;
	private ArrayList<AddCartDTO> list=new ArrayList<>();

	public String execute() throws SQLException{
		String result=SUCCESS;
		//this.setList((ArrayList<AddCartDTO>)session.get("StaticList"));
		AddCartDTO dto=(AddCartDTO)session.get("adcdto");
		id=dto.getId();
		itemName=dto.getItemName();
		itemPrice=dto.getItemPrice();
		if(session.get("StaticList")!=null){
			list=(ArrayList<AddCartDTO>)session.get("StaticList");
			for(AddCartDTO ex:list){
				if(ex.getId()==id){
					ex.setItemPrice(itemPrice*count+ex.getItemPrice());
					ex.setCount(count+ex.getCount());
					//System.out.println("Price object has"+ex.getItemPrice());
					//System.out.println("Price jsp sends"+itemPrice);
					return result;
				}
			}
		}
		//System.out.print(id);
		AddCartDTO dto2=new AddCartDAO().SearchAddItem(id);
		//System.out.print(dto.getItemName());
		dto2.setItemPrice(itemPrice*count);
		dto2.setCount(count);
		list.add(dto2);
		session.put("StaticList", list);
		return result;
	}


	public int getId() {
		return id;
	}
	public ArrayList<AddCartDTO> getList() {
		return list;
	}
	public void setList(ArrayList<AddCartDTO> list) {
		this.list = list;
	}
	public String getItemName() {
		return itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public int getCount() {
		return count;
	}
	public int getPay() {
		return pay;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
