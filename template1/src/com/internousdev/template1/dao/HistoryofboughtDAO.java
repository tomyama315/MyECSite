package com.internousdev.template1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.template1.dto.HistoryofboughtDTO;
import com.internousdev.template1.util.DBConnector;

public class HistoryofboughtDAO{
	public ArrayList<HistoryofboughtDTO> getHOB(String adminid){ //=login_user_id
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		ArrayList<HistoryofboughtDTO> list=new ArrayList<>();
		String sql="SELECT*FROM Supplierhistory where insertbyid=?";
		try{

			PreparedStatement preparedStatement=connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			preparedStatement.setString(1, adminid);
			ResultSet rs=preparedStatement.executeQuery();

		while(rs.next()){
			HistoryofboughtDTO dto=new HistoryofboughtDTO();
			dto.setItemName(rs.getString("item_name"));
			dto.setItemPrice(rs.getInt("total_price"));
			dto.setCount(rs.getInt("total_count"));
			dto.setBoughtbyid(rs.getString("user_master_id"));
			dto.setPay(rs.getString("pay"));
			dto.setDone(rs.getInt("done"));
			list.add(dto);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return list;
}
}
