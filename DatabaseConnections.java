package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
//private static	String url ="jdbc:mysql://localhost:3306/InvoiceDB";
	private static	String url ="jdbc:mysql://localhost:3306/test";
private static String username= "root";
private static String password= "1234";

	public Connection createConnection() {
		//System.out.println("connecting ..");
//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		//Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("connecting....");
		//String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + "F:\\Cloud Application Services\\CabInvoiceGenerator\\cab_invoice.accdb";
		//Connection con = DriverManager.getConnection(url,username,password);
		//System.out.println("connecting");
		//return con;

		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return null;

		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url,username, password);


		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return connection;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			return connection;

		}
		else {
			System.out.println("Failed to make connection!");
			return connection;
		}

	  }

	public void closeConnection(Connection con) throws SQLException{
		con.close();
	}
	public ResultSet selectStatement(Connection con,String sqlStatement) throws SQLException{
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sqlStatement);
		return rs;


	}

}
