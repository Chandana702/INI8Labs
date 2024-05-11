package com.ini8labs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	public static Connection requestConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/ini8labs";
		String user = "root";
		String password = "tiger";
		con = DriverManager.getConnection(url, user, password);
		return con;
	}
}
