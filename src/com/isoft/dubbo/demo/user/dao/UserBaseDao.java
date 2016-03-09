package com.isoft.dubbo.demo.user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import com.isoft.dubbo.demo.user.bean.User;

@Component
public class UserBaseDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User getUser(String name) {
		if (null == name || name.isEmpty()) {
			return null;
		}
		User user = new User();
		
		jdbcTemplate.query("select * from user where name = ?" , new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setCity(rs.getString("city"));
				user.setName(name);
				user.setPhone(rs.getString("phone"));
				
			}
		}, new Object[]{name});
		
		return user;
	}
	
	public boolean delUser(String name) {
		if (null == name || name.isEmpty()) {
			return false;
		}
		int count = jdbcTemplate.update("delete from user where name = ?", new Object[]{name});
		
		if (count <= 0) {
			return false;
		}
		return true;
	}

	
	public boolean saveUser(User user) {
		if (null == user) {
			return false;
		}
		int count = jdbcTemplate.update("insert into user values(?,?,?)", new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getName());
				ps.setString(2, user.getCity());
				ps.setString(3, user.getPhone());
			}
		});
		
		if (count <= 0) {
			return false;
		}
		return true;
	}
}
