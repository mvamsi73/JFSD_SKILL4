package customer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;

/**
 * Servlet implementation class updateNumOfTickets
 */
public class updateNumOfTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int num_of_tickets=Integer.parseInt(request.getParameter("num_of_tickets"));
		HttpSession ht=request.getSession();
		String username=String.valueOf(ht.getAttribute("username"));
		DAO d=new DAO();
		try {
			if(d.updateNumOfTickets(num_of_tickets, username)>0)
			{
				response.sendRedirect("customerHome.html");
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
