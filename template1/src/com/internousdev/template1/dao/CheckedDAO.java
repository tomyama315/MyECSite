package com.internousdev.template1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;

import com.internousdev.template1.dto.AddCartDTO;
import com.internousdev.template1.util.DBConnector;

public class CheckedDAO {
	public void checkeditem(String insertbyid, int index) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		AddCartDTO dto = new AddCartDTO();

		String sql = "select*from supplierhistory where insertbyid=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, insertbyid);
			ResultSet rs = ps.executeQuery();
			Consumer<ResultSet> setdone = (ResultSet target) -> {
				try {
					target.absolute(index+1);
					target.updateInt(11, 1);
					target.updateRow();
				} catch (SQLException e) {
					System.out.println("CHECKEDDAO:ERROR");
					e.printStackTrace();
				}
			};
			setdone.accept(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}