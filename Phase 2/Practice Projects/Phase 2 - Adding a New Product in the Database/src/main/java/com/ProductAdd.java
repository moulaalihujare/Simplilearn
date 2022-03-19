package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductAdd {

	private String dbUrl = "jdbc:mysql://localhost:3306/moulaali_db";
	private String dbUname = "root";
	private String dbPassword = "Aashiyana@11";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";

	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}


	public String insert(Product member)
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data Insert Successfully";
		String sql = "insert into addprodut values(?,?,?,?)";

		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getid());
		ps.setString(2, member.getname());
		ps.setString(3, member.getcost());
		ps.setString(4, member.getquantity());
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data insertion failed";
		}
		return result;
	}

}