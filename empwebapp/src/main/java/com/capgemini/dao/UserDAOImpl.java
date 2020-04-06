package com.capgemini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.bean.User;
import com.capgemini.util.DBConnectionUtil;

public class UserDAOImpl implements UserDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	@Override
	public List<User> get() {
	
		// Create reference variables
		 List<User> list  = null;
		 User user = null;
		 try {
			 
			 list = new ArrayList<User>();
			 
			// Create a sql query
				String sql = "SELECT * FROM user_employee";
				//Get the database connection
				
			connection =	DBConnectionUtil.openConnection();
				
				// Create a statement
			statement  = connection.createStatement();
				
				//Execute the sql query
				resultSet = statement.executeQuery(sql);
				//process the resultset
				while(resultSet.next()) {
					user = new User();
					user.setId(resultSet.getInt("id"));
					user.setName(resultSet.getString("name"));
					user.setPassword(resultSet.getString("password"));
					user.setEmail(resultSet.getString("email"));
					user.setSex(resultSet.getString("sex"));
					user.setCountry(resultSet.getString("country"));
					//Add employee to list
					list.add(user);
				
				}
				
				
				
		} catch (Exception e) {
		     e.printStackTrace();
		}
		//return the list
		 return list;  
		
	}


	@Override
	public boolean save(User e) {
		boolean flag = false;
		
		try {
			String sql ="INSERT INTO user_employee(name, password, email, sex, country)VALUES('"+e.getName()+"', '"+e.getPassword()+"', '"+e.getEmail()+"', '"+e.getSex()+"', '"+e.getCountry()+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
			} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return flag;
	}


	@Override
	public User get(int id) {
		
		User user = null;
		try {
			user = new User();
			String sql = "SELECT * FROM user_employee WHERE id="+id;
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
			     
			     
			        user.setId(resultSet.getInt("id"));
					user.setName(resultSet.getString("name"));
					user.setPassword(resultSet.getString("password"));
					user.setEmail(resultSet.getString("email"));
					user.setSex(resultSet.getString("sex"));
					user.setCountry(resultSet.getString("country"));
			}
			     
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		System.out.println("Employee name:"+user.getName()+" Employee dob:"+user.getPassword()+"Employee department: "+user.getSex());
		return user;
	
	}


	@Override
	public boolean update(User e) {
		boolean flag = false;
		try {
			String sql = "UPDATE user_employee SET name='"+e.getName()+"', password='"+e.getPassword()+"', email='"+e.getEmail()+"', sex='"+e.getSex()+"', country='"+e.getCountry()+"' where id="+e.getId();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (Exception ep) {
			ep.printStackTrace();
		}
		return flag;	
	}


	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM user_employee WHERE id="+id;
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException es) {
			es.printStackTrace();
		}
		return flag;	
	}

}
