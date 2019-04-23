package com.internousdev.template1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template1.dto.AddCartDTO;
import com.internousdev.template1.util.DBConnector;

public class AddCartDAO {
	public AddCartDTO SearchAddItem(int id) throws SQLException{
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		AddCartDTO dto=new AddCartDTO();

		String sql="SELECT * FROM item_info_transaction where id=?";
		try{
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(Integer.parseInt(rs.getString("item_price")));
				dto.setItemStock(Integer.parseInt(rs.getString("item_stock")));
				dto.setInsertbyid(rs.getString("insertbyid"));
				dto.setComment(rs.getString("item_comment"));
				dto.setImagename(rs.getString("image_name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return dto;
}
}
