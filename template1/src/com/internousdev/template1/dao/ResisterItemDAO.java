package com.internousdev.template1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template1.util.DBConnector;
import com.internousdev.template1.util.DateUtil;

public class ResisterItemDAO {
	private DateUtil dateUtil=new DateUtil();
	public int ResisterItem(String name,int price,int stock,String comment,String login_user_id,String imagepath,String imagename)throws SQLException{
		int result=0;
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql="insert into item_info_transaction(item_name,item_price,item_stock,item_comment,insertbyid,insert_date,image_path,image_name) VALUES(?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1,name);
			ps.setInt(2, price);
			ps.setInt(3, stock);
			ps.setString(4, comment);
			ps.setString(5,login_user_id);
			ps.setString(6, dateUtil.getDate());
			ps.setString(7, imagepath);
			ps.setString(8, imagename);
			result=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
				connection.close();
		}
		return result;
	}
}
