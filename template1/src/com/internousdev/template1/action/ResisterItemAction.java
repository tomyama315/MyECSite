package com.internousdev.template1.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template1.dao.ResisterItemDAO;
import com.internousdev.template1.dto.InsertItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResisterItemAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;

	public String execute()throws SQLException{
	String result=ERROR;
	ResisterItemDAO dao=new ResisterItemDAO();
	InsertItemDTO dto = new InsertItemDTO();
	dto=(InsertItemDTO)session.get("InsertItem");
	int rs=dao.ResisterItem(dto.getItemname(),Integer.parseInt(dto.getPrice()),Integer.parseInt(dto.getStock()),dto.getComment(),session.get("login_user_id").toString(),dto.getImagepath(),dto.getImagename()); //name,price,stock,comment
	if(rs>0){
		result=SUCCESS;

		return result;
	}
	return result;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
