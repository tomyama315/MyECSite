package com.internousdev.template1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.template1.dto.BuyItemDTO;
import com.internousdev.template1.util.DBConnector;

public class BuyItemDAO {
	public ArrayList<BuyItemDTO> getBuyItemInfo(){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		ArrayList<BuyItemDTO> list=new ArrayList<BuyItemDTO>();

		String sql="SELECT * FROM item_info_transaction";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()){
				BuyItemDTO dto=new BuyItemDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemstock(Integer.parseInt(resultSet.getString("item_stock")));
				dto.setInseertbyid(resultSet.getString("insertbyid"));
				dto.setImagename(resultSet.getString("image_name"));
				list.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	/*public BuyItemDTO getBuyItemInfo(){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		BuyItemDTO dto=new BuyItemDTO();

		String sql="SELECT id,item_name,item_price FROM item_info_transaction";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();

			if(resultSet.next()){
				dto.setId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dto;
	}*/

}