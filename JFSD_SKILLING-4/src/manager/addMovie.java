package manager;

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
 * Servlet implementation class addMovie
 */
public class addMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String moviename=request.getParameter("moviename");
		String theaterlocation=request.getParameter("theaterlocation");
		int price=Integer.parseInt(request.getParameter("price"));
		DAO d=new DAO();
		PrintWriter pw=response.getWriter();
		try {
			if(d.insertMovie(moviename, theaterlocation, price)>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("managerHome.html");
				rd.include(request, response);
				pw.print("Movie "+moviename+" added successfully");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("addMovie.html");
				rd.include(request, response);
				pw.print("Something went wrong");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
