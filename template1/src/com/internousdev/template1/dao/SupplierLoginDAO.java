package com.internousdev.template1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template1.dto.SupplierLoginDTO;
import com.internousdev.template1.util.DBConnector;

public class SupplierLoginDAO {
	public SupplierLoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		SupplierLoginDTO loginDTO=new SupplierLoginDTO();
		String sql="SELECT*FROM Supplier where id=? AND password=?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2,loginPassword);

			ResultSet resultSet=preparedStatement.executeQuery();

			if(resultSet.next()){
				loginDTO.setLoginId(resultSet.getString("id"));
				loginDTO.setLoginPassword(resultSet.getString("password"));
				loginDTO.setUserName(resultSet.getString("name"));
				if(!(resultSet.getString("id").equals(null))){
					loginDTO.setLoginFlg(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return loginDTO;
	}
}
