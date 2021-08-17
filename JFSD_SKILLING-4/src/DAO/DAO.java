package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbunit.*;
public class DAO 
{
	public boolean validate_manager(String username,String password) throws ClassNotFoundException, SQLException
	{
		dbconnection db=new dbconnection();
		Connection con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from manager");
		ResultSet rst=ps.executeQuery();
		while(rst.next())
		{
			if(rst.getString(1).equals(username) && rst.getString(3).equals(password))
			{
				con.close();
				return true;
			}
		}
		con.close();
		return false;
	}
	public boolean validate_customer(String username,String password) throws ClassNotFoundException, SQLException
	{
		dbconnection db=new dbconnection();
		Connection con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from customer");
		ResultSet rst=ps.executeQuery();
		while(rst.next())
		{
			if(rst.getString(1).equals(username) && rst.getString(4).equals(password))
			{
				con.close();
				return true;
			}
		}
		con.close();
		return false;
	}
	public ResultSet getManagers() throws ClassNotFoundException, SQLException
	{
		dbconnection db=new dbconnection();
		Connection con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from manager");
		ResultSet rst=ps.executeQuery();
		return rst;
	}
	
	public int insertManager(String username,String location,String password) throws SQLException, ClassNotFoundException
	{
		dbconnection db=new dbconnection();
		Connection con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into manager values(?,?,?)");
		ps.setString(1, username);
		ps.setString(2, location);
		ps.setString(3, password);
		int i=ps.executeUpdate();
		return i;
	}
	public ResultSet getStats() throws ClassNotFoundException, SQLException
	{
		dbconnection db=new dbconnection();
		Connection con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from superadmin");
		ResultSet rst=ps.executeQuery();
		return rst;
	}
	public ResultSet getMovies() throws ClassNotFoundException, SQLException
	{
		dbconnection db=new dbconnection();
		Connection con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from movies");
		ResultSet rst=ps.executeQuery();
		return rst;
	}
	public int insertMovie(String moviename,String theaterlocation,int price) throws ClassNotFoundException, SQLException
	{
		dbconnection db=new dbconnection();
		Connection con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into movies values(?,?,?)");
		ps.setString(1, moviename);
		ps.setString(2, theaterlocation);
		ps.setInt(3, price);
		int i=ps.executeUpdate();
		return i;
	}
	public int insertCustomer(String username,String email,long phone,String password) throws ClassNotFoundException, SQLException
	{
		dbconnection db=new dbconnection();
		Connection con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?)");
		ps.setString(1, username);
		ps.setString(2, email);
		ps.setLong(3, phone);
		ps.setString(4,password);
		int i=ps.executeUpdate();
		return i;
	}
	public ResultSet getBookings(String username) throws ClassNotFoundException, SQLException
	{
		dbconnection db=new dbconnection();
		Connection con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from bookings where username=?");
		ps.setString(1, username);
		ResultSet rst=ps.executeQuery();
		return rst;
	}
	public int deleteBooking(String username) throws ClassNotFoundException, SQLException
	{
		dbconnection db=new dbconnection();
		Connection con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from bookings where username=?");
		ps.setString(1, username);
		int i=ps.executeUpdate();
		return i;
	}
	public int insertbooking(String moviename,String theaterlocation,int price,int num_of_tickets,String moviedate,String username) throws ClassNotFoundException, SQLException
	{
		dbconnection db=new dbconnection();
		Connection con=db.getConnection();
		PreparedStatement ps1=con.prepareStatement("insert into bookings values(?,?,?,?,?,?)");
		ps1.setString(1, moviename);
		ps1.setString(2, theaterlocation);
		ps1.setString(3, moviedate);
		ps1.setInt(4, num_of_tickets);
		ps1.setInt(5, num_of_tickets*price);
		ps1.setString(6, username);
		int i=0;
		i=ps1.executeUpdate();
		PreparedStatement ps2=con.prepareStatement("update superadmin set num_of_tickets=num_of_tickets+?");
		ps2.setInt(1, num_of_tickets);
		i=ps2.executeUpdate();
		PreparedStatement ps3=con.prepareStatement("update superadmin set earnings=earnings+?");
		ps3.setInt(1, price);
		i=ps3.executeUpdate();
		return i;
	}
	public int updateNumOfTickets(int tickets,String username) throws ClassNotFoundException, SQLException
	{
		dbconnection db=new dbconnection();
		Connection con=db.getConnection();
		PreparedStatement ps1=con.prepareStatement("update bookings set num_of_tickets=? where username=?");
		ps1.setInt(1, tickets);
		ps1.setString(2, username);
		int i=ps1.executeUpdate();
		return i;
	}

}
