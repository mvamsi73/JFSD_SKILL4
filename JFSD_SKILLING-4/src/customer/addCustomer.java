package customer;

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
 * Servlet implementation class addCustomer
 */
public class addCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		long phone=Long.parseLong(request.getParameter("phone"));
		String password=request.getParameter("password");
		DAO d=new DAO();
		PrintWriter pw=response.getWriter();
		try {
			if(d.insertCustomer(username, email, phone, password)>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
				pw.print("<h3 align=center>Registration Successful</h3>");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("customerregistration.html");
				rd.include(request, response);
				pw.print("<p align=center>something went wrong</p>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
