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

//@WebServlet("/search_book")
public class search_book extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public search_book() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = request.getParameter("title");

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");

			PreparedStatement pstmt = con.prepareStatement("select * from books where title like ? ");			
			
			pstmt.setString(1, "%"+title+"%");

			ResultSet rs = pstmt.executeQuery();	
			
			 if(rs.next())
				{	
		        	HttpSession session = request.getSession();
		        	String title1 = rs.getString(2);
		            session.setAttribute("title", title1);
		            out.println("<center><h3>" +title1+ "</h3></center>" );
		            
		            session.setAttribute("book_id", rs.getInt("book_id"));
		            session.setAttribute("title", rs.getString("title"));
		            session.setAttribute("author_id", rs.getInt("author_id"));
		            session.setAttribute("isbn", rs.getString("isbn"));
		            session.setAttribute("publication_year", rs.getInt("publication_year"));
		            //session.setAttribute("available", rs.getBoolean("available"));
		            
		            
		           response.sendRedirect("search_book_result.jsp");	
				}
				else
				{					
					RequestDispatcher rd = request.getRequestDispatcher("searchBooks.jsp");
					rd.include(request, response);
					out.println("<center><h3>Book Not Found...Please Enter Correct Book Name!!!!</h3></center>");
				}
				con.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
