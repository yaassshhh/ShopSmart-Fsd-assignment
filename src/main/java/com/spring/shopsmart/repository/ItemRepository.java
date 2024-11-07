package com.spring.shopsmart.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.shopsmart.model.Items;



@Repository
public class ItemRepository {

	@Autowired
	private JdbcTemplate jdbc; 
	
	public List<Items> fetchAllItems() {
		//prepare the statement 
		String sql="select * from items i where i.is_active=?";
		
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt =  con.prepareStatement(sql);
  				pstmt.setBoolean(1, true);
				return pstmt;
			}
			
		};
		
		RowMapper<Items> rowMapper = new RowMapper<Items>() {

			@Override
			public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
				Items item = new Items(); 
				int itemId = rs.getInt("id");
				String itemName = rs.getString("item_name");
				String category = rs.getString("category");
				String price = rs.getString("price");

				
				
				
				item.setId(itemId);
				item.setItemName(itemName);
				item.setCategory(category);
				item.setPrice(price);

				
				
				
				return item;
			}
			
		};
		
		List <Items> list = jdbc.query(psc, rowMapper);
		 
		return list;
	}


	public void softDelete(int iid) {
		String sql="update items set is_active=false where id=?";
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt =  con.prepareStatement(sql);
				pstmt.setInt(1, iid);
				return pstmt;
			}
			
		};
		jdbc.update(psc);
	}

}
