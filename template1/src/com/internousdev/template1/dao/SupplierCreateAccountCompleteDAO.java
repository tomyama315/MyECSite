package com.internousdev.template1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template1.util.DBConnector;
import com.internousdev.template1.util.DateUtil;

public class SupplierCreateAccountCompleteDAO {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private DateUtil dateUtil=new DateUtil();
	private String sql="INSERT INTO Supplier(password,name,insert_date)VALUES(?,?,?)";
	public void createAccount(String password,String name)throws SQLException{
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, dateUtil.getDate());
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
}