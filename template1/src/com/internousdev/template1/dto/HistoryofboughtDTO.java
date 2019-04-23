package com.internousdev.template1.dto;

public class HistoryofboughtDTO {
	private String itemName;
	private int itemPrice;
	private  int count;
	private String boughtbyid;
	private String pay;
	private int done;

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBoughtbyid() {
		return boughtbyid;
	}
	public void setBoughtbyid(String boughtbyid) {
		this.boughtbyid = boughtbyid;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public int getDone() {
		return done;
	}
	public void setDone(int done) {
		this.done = done;
	}

}
