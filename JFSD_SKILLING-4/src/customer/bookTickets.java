package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;

/**
 * Servlet implementation class bookTickets
 */
public class bookTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DAO d=new DAO();
		ResultSet rst;
		try {
			rst = d.getMovies();
		
		PrintWriter pw=response.getWriter();
		pw.write("<table align=center border=1>");
		pw.write("<tr><td>Movie Name</td><td>Theater Location</td><td>Price</td><td>Number of Tickets</td><td>Book Ticket</td></tr>");
		try {
			while(rst.next())
			{
				pw.print("<form action=./insertBookings method=post>");
				pw.write("<tr><td><input type=text name=moviename value='"+rst.getString(1)+"'readonly></td>"+"<td><input type=text name=theaterlocation value='"+rst.getString(2)+"'readonly></td>"+"<td><input type=text name=price value='"+rst.getString(3)+"'readonly></td><td><input type=text name=num_of_tickets ></td><td><input type=submit value=Book></td></tr>");
				pw.print("</form>");
			}
			pw.print("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}


}
