package com.internousdev.template1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;

import com.internousdev.template1.util.DBConnector;
import com.internousdev.template1.util.DateUtil;

public class BuyItemCompleteDAO {
	private DateUtil dateUtil = new DateUtil();
	private String sql = "select * from SupplierHistory";
	private String testsql = "select * from user_buy_item_transaction";

	public void BuyItemInfo(int item_transaction_id, String user_master_id, int total_price, int count, String pay,
			String insertbyid, String itemname) throws SQLException {
		try {
			Thread threadA = new Thread(() -> {
				try {
					DBConnector dbConnector = new DBConnector();
					Connection connection = dbConnector.getConnection();
					Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					ResultSet rs = stmt.executeQuery(testsql);
					Consumer<ResultSet> in = (ResultSet rsin) -> {
						try {
							rsin.moveToInsertRow();
							rsin.updateInt(2, item_transaction_id);
							rsin.updateString(5, user_master_id);
							rsin.updateInt(3, total_price);
							rsin.updateInt(4, count);
							rsin.updateString(6, pay);
							rsin.updateString(8, dateUtil.getDate());
							rsin.insertRow();
						} catch (SQLException e) {
							System.out.println("rsin ERROR");
							e.printStackTrace();
						}
					};
					in.accept(rs);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
			threadA.start();

			Thread threadB = new Thread(() -> {
				try {
					DBConnector dbConnector = new DBConnector();
					Connection connection = dbConnector.getConnection();
					Statement stmt2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					ResultSet rs2 = stmt2.executeQuery(sql);
					Consumer<ResultSet> inSup = (ResultSet Suprs) -> {
						try {
							Suprs.moveToInsertRow();
							Suprs.updateInt(2, item_transaction_id);
							Suprs.updateString(5, user_master_id);
							Suprs.updateInt(3, total_price);
							Suprs.updateInt(4, count);
							Suprs.updateString(6, pay);
							Suprs.updateString(7, insertbyid);
							Suprs.updateString(8, dateUtil.getDate());
							Suprs.updateString(10, itemname);
							Suprs.updateInt(11, 0);
							Suprs.insertRow();
						} catch (SQLException e) {
							System.out.println("Suprs ERROR");
							e.printStackTrace();
						}
					};
					inSup.accept(rs2);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
			threadB.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
