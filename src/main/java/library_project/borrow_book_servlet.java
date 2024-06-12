package library_project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @WebServlet("/borrow_book_servlet")
public class borrow_book_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public borrow_book_servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		Integer bookId = (Integer) session.getAttribute("book_id");
		String username = (String) session.getAttribute("username"); // Assuming user_id is set in session after login

		if (bookId == null && username == null) {
			response.getWriter().write("Invalid session attributes: book_id or user_id");
			return;
		}

		// Get the current date
		LocalDate checkoutDate = LocalDate.now();

		// Calculate the return date as two weeks from the current date
		LocalDate returnDate = checkoutDate.plusWeeks(2);

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");

			String useridQuery = "SELECT user_id from users WHERE username = ?";
			pstmt = con.prepareStatement(useridQuery);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			Integer userId = null;
			
			if (rs.next()) {
				userId = rs.getInt("user_id");
				//session.setAttribute("user_id", userId);
			}
			rs.close();
			pstmt.close();
			
			String strQuery = "INSERT INTO transactions (user_id, book_id, checkout_date, return_date) values (?,?,?,?)";
			// Insert into transactions table
			pstmt = con.prepareStatement(strQuery);

			pstmt.setInt(1, userId);
			pstmt.setInt(2, bookId);
			pstmt.setDate(3, java.sql.Date.valueOf(checkoutDate));
			pstmt.setDate(4, java.sql.Date.valueOf(returnDate));
			pstmt.executeUpdate();

			ResultSet rs1 = pstmt.executeQuery("Select * from transactions");

			if (rs1.next()) {
				session.setAttribute("userId", userId);
				session.setAttribute("bookId", bookId);
				session.setAttribute("checkoutDate", checkoutDate.toString());
				session.setAttribute("returnDate", returnDate.toString());

				RequestDispatcher rd = request.getRequestDispatcher("borrow_confirmation.jsp");
				rd.forward(request, response);
			}

			else {
				RequestDispatcher rd = request.getRequestDispatcher("/searchBooks.jsp");
				rd.include(request, response);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
