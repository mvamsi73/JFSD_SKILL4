package dbunit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection 
{
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_skilling4","root","root");
			return con;
	}

}
