package library_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

   //@WebServlet("/login_page")
public class login_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public login_page() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try 
		{
			    Class.forName("com.mysql.cj.jdbc.Driver");   
				System.out.println("Driver registration ");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","password");
				System.out.println("Connection successfull :");
				
				PreparedStatement stmt = con.prepareStatement("select * from users where username=? and passwrd=? ");
				
				stmt.setString(1,username);
				stmt.setString(2, password);
				
				ResultSet rs = stmt.executeQuery();
		        
		        if(rs.next())
				{	
		        	HttpSession session = request.getSession();
		        	String username1 = rs.getString(2);
		            session.setAttribute("username", username1);
		            	
		            // Redirect to the home.jsp page
		            response.sendRedirect("home.jsp");	
		            //	request.getRequestDispatcher("home.jsp").forward(request, response);
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("/login_page.html");
					rd.include(request, response);
				}
				con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
