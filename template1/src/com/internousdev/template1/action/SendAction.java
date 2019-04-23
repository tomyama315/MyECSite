package com.internousdev.template1.action;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.CheckedDAO;
import com.internousdev.template1.dao.HistoryofboughtDAO;
import com.internousdev.template1.dto.HistoryofboughtDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SendAction extends ActionSupport implements SessionAware{
	private String[] index;
	public Map<String,Object> session;
	private ArrayList<HistoryofboughtDTO> HBList=new ArrayList<>();
	public String execute(){
		CheckedDAO dao=new CheckedDAO();
		String result=SUCCESS;
		Stream<String> target=Stream.of(index).sorted(Comparator.reverseOrder());
		target.forEach(s->dao.checkeditem(session.get("login_user_id").toString(),Integer.parseInt(s.toString())));
		HistoryofboughtDAO HBdao=new HistoryofboughtDAO();
		HBList=HBdao.getHOB(session.get("login_user_id").toString());
		return result;
	}
	public String[] getIndex() {
		return index;
	}
	public void setIndex(String[] index) {
		this.index = index;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<HistoryofboughtDTO> getHBList() {
		return HBList;
	}
	public void setHBList(ArrayList<HistoryofboughtDTO> hBList) {
		HBList = hBList;
	}

}
