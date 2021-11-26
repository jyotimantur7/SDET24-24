package com.crm.genericfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
static Driver driver;
static Connection connection;
static ResultSet result;
static int result1;
/**
 * This will perform mysql db connection
 */
public void connectToDB()
{
	try {
		driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		}catch (SQLException e) {
			e.printStackTrace();
		}
}
/*execute the query*/
public  ResultSet executeQuery(String query) throws SQLException
{
		try {
			result=connection.createStatement().executeQuery(query);
			return result;
		}catch(SQLException e)
		{
			
			e.printStackTrace();
	}
		return result;
}

public int executeUpadate(String query1)
{

	try {
		result1=connection.createStatement().executeUpdate(query1);
		}catch(SQLException e)
	   {
			e.printStackTrace();
		}
	return result1;
}


/*close the connection*/
	public void closeDB() throws SQLException {
		connection.close();
	}
}
