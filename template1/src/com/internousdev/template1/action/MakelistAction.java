package com.internousdev.template1.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.MakelistDAO;
import com.internousdev.template1.dto.MakelistDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MakelistAction extends ActionSupport implements SessionAware{
	private String IdentifyTable;
	private String IdentifyID;
	private String result;
	public Map<String,Object> session;
	MakelistDAO dao=new MakelistDAO();
	ArrayList<MakelistDTO> list=new ArrayList<>();

	public String execute(){
		result=ERROR;
		IdentifyTable=session.get("IDT").toString();
		//System.out.println(IdentifyTable);
		IdentifyID=session.get("login_user_id").toString();
		list=dao.Select(IdentifyTable,IdentifyID);
		/*for(MakelistDTO dto :list){
			System.out.print(dto.getSHARENAME());
		}*/
		if(IdentifyTable.equals("login_user_transaction")){
			result="SelectUser";
			session.remove("login_user_transaction");
		}
		if(IdentifyTable.equals("item_info_transaction")){
			result="SelectItem";
			session.remove("item_info_transaction");
		}

	return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;

	}

	public ArrayList<MakelistDTO> getList() {
		return list;
	}

	public void setList(ArrayList<MakelistDTO> list) {
		this.list = list;
	}

}

