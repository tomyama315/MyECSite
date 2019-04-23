package com.internousdev.template1.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.DeleteByAutholizerActionDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteByAutholizerAction extends ActionSupport implements SessionAware{
	private  String[] index;
	public Map<String,Object> session;
	DeleteByAutholizerActionDAO dao=new DeleteByAutholizerActionDAO();
	public String execute(){
		String result=SUCCESS;
		//System.out.println(index);
		if(index!=null){
			for(String s: index){
			//System.out.println(s);
			int a=dao.DeleteIdentify(s);
			if(a==0){
				result=ERROR;
				return result;
			}
		}
		}else{
			result=ERROR;
			return result;
		}
		return result;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
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

}
