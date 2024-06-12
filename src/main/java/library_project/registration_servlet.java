package library_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

   //@WebServlet("/registration_servlet")
public class registration_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public registration_servlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String first_name = request.getParameter("fname");
		String last_name = request.getParameter("lname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		try 
		{
			    Class.forName("com.mysql.cj.jdbc.Driver"); 
				System.out.println("Driver registration ");  
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","password");
				System.out.println("Connection successfull :");
				
				PreparedStatement stmt = con.prepareStatement("Insert into users (first_name,last_name,username,passwrd,email) values(?,?,?,?,?)");
				
				stmt.setString(1, first_name);
				stmt.setString(2, last_name);
				stmt.setString(3, username);
				stmt.setString(4, password);
				stmt.setString(5, email);
				
				int i = stmt.executeUpdate();
				
				if(i>0)
				{
					out.println("Registration Successfull");
					response.sendRedirect("login.html");
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("/registration.html");
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
