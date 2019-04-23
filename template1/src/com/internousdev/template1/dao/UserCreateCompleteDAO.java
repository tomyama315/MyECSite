package com.internousdev.template1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template1.util.DBConnector;
import com.internousdev.template1.util.DateUtil;

public class UserCreateCompleteDAO {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private DateUtil dateUtil=new DateUtil();
	private String sql="INSERT INTO login_user_transaction(login_id,login_pass,user_name,insertbyid,insert_date)VALUES(?,?,?,?,?)";
	public void createUser(String loginUserId,String loginUserPassword,String userName,String insertbyid)throws SQLException{
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, insertbyid);
			preparedStatement.setString(5, dateUtil.getDate());
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
	public void createAndautholizeUser(String loginUserId,String loginUserPassword,String userName,String insertbyid,String autholization)throws SQLException{
		String sql="INSERT INTO login_user_transaction(login_id,login_pass,user_name,insertbyid,root,insert_date)VALUES(?,?,?,?,?,?)";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, insertbyid);
			preparedStatement.setString(5, autholization);
			preparedStatement.setString(6, dateUtil.getDate());
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

	public void createUserByNewUser(String loginUserId,String loginUserPassword,String userName)throws SQLException{
		String sql="INSERT INTO login_user_transaction(login_id,login_pass,user_name,insert_date)VALUES(?,?,?,?)";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateUtil.getDate());
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

}
