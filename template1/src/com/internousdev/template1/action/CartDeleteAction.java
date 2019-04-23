package com.internousdev.template1.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dto.AddCartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartDeleteAction extends ActionSupport implements SessionAware{
	private int index;
	public Map<String,Object> session;
	ArrayList<AddCartDTO> deleteobject;
	ArrayList<AddCartDTO> list;
	public String execute(){
		String result=SUCCESS;
		//System.out.print(index);
		list=(ArrayList<AddCartDTO>)session.get("StaticList");
		list.remove(index);
		session.put("StaticList", list);
		return result;
	}
	public ArrayList<AddCartDTO> getList() {
		return list;
	}
	public void setList(ArrayList<AddCartDTO> list) {
		this.list = list;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public void setDeleteobject(ArrayList<AddCartDTO> deleteobject) {
		this.deleteobject = deleteobject;
	}
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public int getIndex() {
		return index;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public ArrayList<AddCartDTO> getDeleteobject() {
		return deleteobject;
	}

}
