package library_project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class returnBookServlet
 */
// @WebServlet("/returnBookServlet")
public class returnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public returnBookServlet() {
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

		String bookTitle = request.getParameter("book_title");
		//String userId = request.getParameter("user_id");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		try {
			// Load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");

			// Fetch book ID using the book title
			String fetchBookIdQuery = "SELECT book_id FROM books WHERE  title = ?";
			PreparedStatement fetchBookIdStmt = con.prepareStatement(fetchBookIdQuery);
			fetchBookIdStmt.setString(1, bookTitle);
			ResultSet rs = fetchBookIdStmt.executeQuery();

			// Check if book with title exists
			if (rs.next()) {
				int bookId = rs.getInt("book_id");

				// Check if the book is checked out by the user
				String fetchTransactionQuery = "SELECT checkout_date, returned FROM transactions WHERE book_id = ? AND returned = FALSE";
				PreparedStatement fetchTransactionStmt = con.prepareStatement(fetchTransactionQuery);
				fetchTransactionStmt.setInt(1, bookId);
//				fetchTransactionStmt.setInt(2, Integer.parseInt(userId));
				ResultSet transactionRs = fetchTransactionStmt.executeQuery();

				if (transactionRs.next()) {
					LocalDate checkoutDate = transactionRs.getDate("checkout_date").toLocalDate();
					boolean returned = transactionRs.getBoolean("returned");

					LocalDate currentDate = LocalDate.now();
					long daysBetween = ChronoUnit.DAYS.between(checkoutDate, currentDate);

					if (!returned && daysBetween <= 14) {
						// Process the return
						String updateQuery = "UPDATE transactions SET returned = TRUE WHERE book_id = ?";
						PreparedStatement updateStmt = con.prepareStatement(updateQuery);
						updateStmt.setInt(1, bookId);
//						updateStmt.setInt(2, Integer.parseInt(userId));
						updateStmt.executeUpdate();
						updateStmt.close();

						// Set attributes for confirmation page
						request.setAttribute("bookTitle", bookTitle);
						request.setAttribute("checkoutDate", currentDate.toString());

						// Forward to confirmation page
						request.getRequestDispatcher("returnConfirmation.jsp").forward(request, response);

					}
					else 
					  {
						double FINE_PER_DAY = 5.0;
						long lateDays = daysBetween - 14;
                        double fineAmount = lateDays * FINE_PER_DAY;
                        Integer userId = null;
            			String useridQuery = "Select user_id from users WHERE username = ?";
            			PreparedStatement pstmt = con.prepareStatement(useridQuery);
            			pstmt.setString(1, username);
            			rs = pstmt.executeQuery();
            			
            			
            			if (rs.next()) {
            				userId = rs.getInt("user_id");
            				//session.setAttribute("user_id", userId);
            			}
            		

                        String insertFineQuery = "INSERT INTO fines (user_id, amount, reason, paid) VALUES (?, ?, ?, FALSE)";
                        PreparedStatement insertFineStmt = con.prepareStatement(insertFineQuery);
                        
                        insertFineStmt.setInt(1, userId);
                        insertFineStmt.setDouble(2, fineAmount);
                        insertFineStmt.setString(3, "Due To late returning of Book.");
                        insertFineStmt.executeUpdate();
                        
                        ResultSet fineSet = pstmt.executeQuery("Select * from fines");

                        if(fineSet.next())
                        {
                        // Set attributes for fine page
                        request.setAttribute("bookTitle", bookTitle);
                        request.setAttribute("fineAmount", fineAmount);
                        request.setAttribute("lateDays", lateDays);
                        request.setAttribute("reason", "Due To late returning of Book.");
                        
                        request.getRequestDispatcher("fine.jsp").forward(request, response);
                        }
					  }
				} else {
					// Book not checked out by the user
					response.getWriter().println("Error: The book with title " + bookTitle + " is not issued by you.");
				}

				// Close resources
				transactionRs.close();
				fetchTransactionStmt.close();
				rs.close();
				fetchBookIdStmt.close();
				con.close();
			} else 
			{
				// Book with title not found
				response.getWriter().println("Error: Book with title " + bookTitle + " not found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error: " + e.getMessage());
		}
	}
}
