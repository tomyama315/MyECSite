package com.internousdev.template1.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dto.AddCartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private ArrayList<AddCartDTO> list=new ArrayList<>();
	private int totalprice;

	public String execute(){
		String result=SUCCESS;
		totalprice=0;
		list=(ArrayList<AddCartDTO>)session.get("StaticList");
		for(AddCartDTO goods : list){
			totalprice+=goods.getItemPrice();
		}
		session.put("totalprice", totalprice);
		return result;
	}


	public ArrayList<AddCartDTO> getList() {
		return list;
	}
	public void setList(ArrayList<AddCartDTO> list) {
		this.list = list;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
