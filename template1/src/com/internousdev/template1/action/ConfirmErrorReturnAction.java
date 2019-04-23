package com.internousdev.template1.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dto.AddCartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmErrorReturnAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private ArrayList<AddCartDTO> list=new ArrayList<>();
	public String execute(){
		list=(ArrayList<AddCartDTO>)session.get("StaticList");
		int count=0;
		for(AddCartDTO a:list){
		if(a.getId()==(Integer.parseInt(session.get("Erroritemid").toString()))){
			list.remove(count);
			session.remove("Error");
			break;
		}
		count+=1;
		}
		return SUCCESS;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
	public ArrayList<AddCartDTO> getList() {
		return list;
	}
	public void setList(ArrayList<AddCartDTO> list) {
		this.list = list;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
