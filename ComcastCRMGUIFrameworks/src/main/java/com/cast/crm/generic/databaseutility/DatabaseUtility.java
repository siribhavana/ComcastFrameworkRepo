package com.cast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	Connection conn;
	public void getDbconnection(String url,String username,String password) throws Exception
	{
		try
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
		}
	}
	public void getDbconnection()
	{
		try
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/m16_advance_java","root","root");
		}
		catch(Exception e)
		{
			
		}
	}
	public void closeDbconnection() throws Exception
	{
		try
		{
			conn.close();
		}
		catch(Exception e)
		{
		}
	}
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet resultset=null;
		try
		{
			Statement statement=conn.createStatement();
			resultset=statement.executeQuery(query);
		}
		catch(Exception e)
		{
		}
		return resultset;
	}
	public int executeNonSelectQuery(String query)
	{
		int resultset=0;
		try
		{
			Statement statement=conn.createStatement();
			resultset=statement.executeUpdate(query);
		}
		catch(Exception e)
		{
		}
		return resultset;
	}
}
