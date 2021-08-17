package admin;
import DAO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class displayManagers
 */
public class displayManagers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DAO d=new DAO();
		PrintWriter pw=response.getWriter();
		try {
			ResultSet rst=d.getManagers();
			pw.print("<h1 align=center>Managers</h1>");
			pw.print(" <table align=center border=1>");
			pw.print("<tr><td>User Name</td><td>Theater Location</td><tr>");
			while(rst.next())
			{
				pw.print("<tr><td>"+rst.getString(1)+"</td><td>"+rst.getString(2)+"</td><tr>");
			}
			pw.print("</table>");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
