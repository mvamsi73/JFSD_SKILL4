package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;

/**
 * Servlet implementation class viewbookings
 */
public class viewbookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		DAO d=new DAO();
		ResultSet rst;
		try {
			rst = d.getBookings(String.valueOf(session.getAttribute("username")));
			pw.print("<h1 align=center>Bookings</h1>");
		pw.print("<table align=center border=1>");
		pw.print("<tr><td>Username</td><td>Movie Name</td><td>Theater Location</td><td>Movie Date</td><td>Number of Tickets</td><td>Price</td><td>Update NUM_OF_TICKETS</td><td>Cancle</td></tr>");
		try {
			while(rst.next())
			{
			pw.print("<form action=./deleteBooking method=post>");
			try {
				pw.print("<tr><td><input type=text name=username value='"+rst.getString(6)+"'hidden>"+rst.getString(6)+"</td><td>"+rst.getString(1)+"</td><td>"+rst.getString(2)+"</td><td>"+rst.getString(3)+"</td><td>"+rst.getInt(4)+"</td><td>"+rst.getInt(5)+"</td><td><a href=updateNumoftickets.html>Update NUM_OF_TICKETS</a></td><td><input type=submit value=Cancle></td></tr>");
				pw.print("</form>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			pw.print("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}


}
