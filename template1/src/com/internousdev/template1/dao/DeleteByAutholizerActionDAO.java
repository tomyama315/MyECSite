package com.internousdev.template1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.internousdev.template1.util.DBConnector;

public class DeleteByAutholizerActionDAO{
	int rs=0;
	public int DeleteIdentify(String id){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql="delete from login_user_transaction where id=? ";
		try{
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
}
	public int DeleteItemsIdentify(String id){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql="delete from item_info_transaction where id=? ";
		try{
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
}
}
