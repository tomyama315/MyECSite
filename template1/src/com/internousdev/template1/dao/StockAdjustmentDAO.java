package com.internousdev.template1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template1.util.DBConnector;

public class StockAdjustmentDAO {
	public synchronized int AdjustmentStock(int id,int ConsumeStock){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		int left=0;
		int rs=0;

		String sql="SELECT * FROM item_info_transaction where id=?";
			try{
				PreparedStatement ps1=connection.prepareStatement(sql);
			ps1.setInt(1, id);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
			left=rs1.getInt("item_stock");
			}
			int AjustmentStock=left-ConsumeStock;
			if(AjustmentStock>=0){
				String localsql="UPDATE item_info_transaction SET item_stock=? WHERE  id= ?";
				PreparedStatement ps2=connection.prepareStatement(localsql);
				ps2.setInt(1,AjustmentStock);
				ps2.setInt(2, id);
				rs=ps2.executeUpdate();
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
			return rs;
	}
}

