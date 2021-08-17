package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;

/**
 * Servlet implementation class addManager
 */
public class addManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username=request.getParameter("username");
		String theater_location=request.getParameter("location");
		String password=request.getParameter("password");
		DAO d=new DAO();
		PrintWriter pw=response.getWriter();
		try {
			if(d.insertManager(username, theater_location, password)>0)
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("adminHome.html");
				rd.include(request, response);
				pw.print("<br>Manager "+username+" added Successfully");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("addManager.html");
				rd.include(request, response);
				pw.print("Something error occured");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
