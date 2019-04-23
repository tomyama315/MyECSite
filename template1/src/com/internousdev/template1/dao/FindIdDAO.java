package com.internousdev.template1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template1.dto.SupplierLoginDTO;
import com.internousdev.template1.util.DBConnector;

public class FindIdDAO{
	public SupplierLoginDTO getNewUserId(String password,String name){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		SupplierLoginDTO loginDTO=new SupplierLoginDTO();
		String sql="SELECT*FROM Supplier where password=? AND name=?";
		try{

			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2,name);

			ResultSet resultSet=preparedStatement.executeQuery();

		if(resultSet.next()){
			loginDTO.setLoginId(resultSet.getString("id"));
			loginDTO.setLoginPassword(resultSet.getString("password"));
			loginDTO.setUserName(resultSet.getString("name"));
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return loginDTO;
}
}
