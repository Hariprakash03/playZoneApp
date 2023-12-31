package com.playapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.playapp.util.Queries;

public class DbConnection {
static Connection connection;
	
	public static Connection openConnection() {
		String url="jdbc:mysql://localhost:3306/doctordb";
		String user="root";
		String password="admin@123";
		
		try {
			connection = DriverManager.getConnection(url,user,password);
			PreparedStatement statement = connection.prepareStatement(Queries.CREATEQUERY);
			PreparedStatement statement1 = connection.prepareStatement(Queries.BOOKINGTABLE);
			statement.execute();
			statement1.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
