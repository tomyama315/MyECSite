package com.internousdev.template1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template1.dto.BuyItemDTO;
import com.internousdev.template1.util.DBConnector;

public class ItemSearchDAO{
	private ArrayList<BuyItemDTO> list=new ArrayList<>();
	public ArrayList<BuyItemDTO> SearchAddItem(String Key) throws SQLException{
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		String sql="SELECT * FROM item_info_transaction where item_name REGEXP ?";
		try{
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, Key);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				BuyItemDTO dto=new BuyItemDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemstock(Integer.parseInt(rs.getString("item_stock")));
				dto.setImagename(rs.getString("image_name"));
				list.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return list;
}
}
