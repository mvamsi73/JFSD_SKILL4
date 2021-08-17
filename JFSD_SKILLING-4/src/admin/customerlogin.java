package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;

/**
 * Servlet implementation class customerlogin
 */
public class customerlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		DAO d=new DAO();
		try {
			if(d.validate_customer(username, password))
			{
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("customerHome.html");
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("customerlogin.html");
				rd.include(request, response);
				pw.print("<p align=center style='color :red;'>Wrong Credentials</p>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
