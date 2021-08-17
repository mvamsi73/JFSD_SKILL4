package manager;

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
 * Servlet implementation class viewMovies
 */
public class viewMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DAO d=new DAO();
		ResultSet rst;
		try {
			rst = d.getMovies();
		
		PrintWriter pw=response.getWriter();
		pw.write("<table align=center border=1>");
		pw.write("<tr><td>Movie Name</td><td>Theater Location</td><td>Price</td></tr>");
		try {
			while(rst.next())
			{
				pw.write("<tr><td>"+rst.getString(1)+"</td>"+"<td>"+rst.getString(2)+"</td>"+"<td>"+rst.getString(3)+"</td>");
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
