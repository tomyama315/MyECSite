package com.internousdev.template1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.template1.dto.MakelistDTO;
import com.internousdev.template1.util.DBConnector;

public class MakelistDAO {
	public ArrayList<MakelistDTO> Select(String IdentifyTable,String IdentifyID){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		ArrayList<MakelistDTO> list=new ArrayList<>();
		String sql=null;
		try{
			if(IdentifyTable.equals("login_user_transaction")){
				sql="SELECT * FROM login_user_transaction where insertbyid=?";
			}
			if(IdentifyTable.equals("item_info_transaction")){
				sql="SELECT * FROM item_info_transaction where insertbyid=?";
			}
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1,IdentifyID);
			ResultSet rs=ps.executeQuery();
			if(IdentifyTable.equals("login_user_transaction")){
				rs.beforeFirst();
				while(rs.next()){
					MakelistDTO dto=new MakelistDTO();
					dto.setSHAREID(rs.getString("id"));
					dto.setSHARENAME(rs.getString("user_name"));
					dto.setUSERLOGINID(rs.getString("login_id"));
					if(rs.getString("root")!=null){
						dto.setUSERAUTHOLIZATION("AutholizedUser");
					}else{
						dto.setUSERAUTHOLIZATION("NoAutholization");
					}
					dto.setSHAREINSERTDAY(rs.getString("insert_date"));
					dto.setSHAREUPDATEDAY(rs.getString("update_date"));
					list.add(dto);
				}
				return list;
			}
			if(IdentifyTable.equals("item_info_transaction")){
				rs.beforeFirst();
				while(rs.next()){
					MakelistDTO dto=new MakelistDTO();
					dto.setSHAREID(rs.getString("id"));
					dto.setSHARENAME(rs.getString("item_name"));
					dto.setITEMPRICE(rs.getString("item_price"));
					dto.setITEMSTOCK(rs.getString("item_stock"));
					dto.setITEMCOMMENT(rs.getString("item_comment"));
					dto.setSHAREINSERTDAY(rs.getString("insert_date"));
					dto.setSHAREUPDATEDAY(rs.getString("update_date"));
					list.add(dto);
				}
				return list;
			}
			}catch(Exception e){
				e.printStackTrace();
				}
		return list;
		}
	}
