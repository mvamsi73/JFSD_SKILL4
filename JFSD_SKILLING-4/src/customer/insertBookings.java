package customer;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;
/**
 * Servlet implementation class insertBookings
 */
public class insertBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertBookings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String moviename=request.getParameter("moviename");
		String theaterlocation=request.getParameter("theaterlocation");
		int price=Integer.parseInt(request.getParameter("price"));
		int num_of_tickets=Integer.parseInt(request.getParameter("num_of_tickets"));
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate date=LocalDate.now();
		String movie_date=String.valueOf(date);
		HttpSession ht=request.getSession();
		String username=String.valueOf(ht.getAttribute("username"));
		DAO d=new DAO();
		try {
			if(d.insertbooking(moviename, theaterlocation, price, num_of_tickets, movie_date, username)>0)
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
