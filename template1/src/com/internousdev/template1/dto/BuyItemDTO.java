package com.internousdev.template1.dto;

public class BuyItemDTO {
	private int Id;
	private String itemName;
	private String itemPrice;
	private int itemstock;
	private String inseertbyid;
	private String comment;
	private String imagename;
	private String imagepath;

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}
	public int getId(){
		return Id;
	}
	public void setId(int Id){
		this.Id=Id;
	}
	public int getItemstock() {
		return itemstock;
	}
	public void setItemstock(int itemstock) {
		this.itemstock = itemstock;
	}
	public String getInseertbyid() {
		return inseertbyid;
	}
	public void setInseertbyid(String inseertbyid) {
		this.inseertbyid = inseertbyid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

}