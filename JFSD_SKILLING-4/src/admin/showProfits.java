package admin;

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
 * Servlet implementation class showProfits
 */
public class showProfits extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DAO d=new DAO();
		PrintWriter pw=response.getWriter();
		ResultSet rst;
		try {
			rst = d.getStats();
			try {
				while(rst.next())
				{
				pw.print("<h1 align=center>Number of Tickets Booked</h1><br>");
				pw.print("<h3 align=center>"+String.valueOf(rst.getInt(1))+"</h3>");
				pw.print("<h1 align=center>Number of Tickets Booked</h1><br>");
				pw.print("<h3 align=center>"+String.valueOf(rst.getInt(2))+"</h3>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
