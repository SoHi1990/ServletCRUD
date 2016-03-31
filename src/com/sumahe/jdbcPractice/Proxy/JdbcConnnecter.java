package com.sumahe.jdbcPractice.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnnecter {
	Connection connection = null;
	
	private Connection getConnection() throws SQLException{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String url = "jdbc:sqlserver://192.168.70.158:1433;DataBaseName=jdbc";
		String user = "sa";
		String password = "123";
		return DriverManager.getConnection(url, user, password);
	}
	
	private void closeConnect() throws SQLException{
		connection.close();
	}
	
	public ResultSet getTable(String sqlString) throws SQLException{
		if (connection == null) {
			connection = this.getConnection();
		}
		Statement sql = connection.createStatement();
		ResultSet resultSet = sql.executeQuery(sqlString);
		this.closeConnect();
		return resultSet;
	}
	
	/**
	 * 
	 * @param sqlString
	 * @throws SQLException
	 */
	public void executeSql(String sqlString) throws SQLException {
		if (connection == null) {
			connection = this.getConnection();
		}
		Statement sql = connection.createStatement();
		int executeResult = sql.executeUpdate(sqlString);
		this.closeConnect();
	}
	
	
}
