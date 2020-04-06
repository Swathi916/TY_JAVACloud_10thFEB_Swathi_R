package com.capgemini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.capgemini.bean.Login;
import com.capgemini.util.DBConnectionUtil;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public String authenticate(Login login) {
		String sql = "select * from tbl_login where email=? and password=?";
		
		try {
			Connection connection = DBConnectionUtil.openConnection();
			PreparedStatement preparedStatement  = connection.prepareStatement(sql);
			preparedStatement.setString(1, login.getEmail());
			preparedStatement.setString(2, login.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				return "true";
			}else {
				return "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

}
