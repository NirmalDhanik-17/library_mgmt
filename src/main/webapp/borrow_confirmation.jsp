<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Borrowing A Book</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	text-align: center;
}

.container {
	background-color: #fff;
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
	max-width: 600px;
	width: 100%;
}

h2 {
	color: #333;
	font-size: 2em;
	margin-bottom: 20px;
}

ul {
	list-style-type: none;
	padding: 0;
	text-align: left;
	margin-bottom: 20px;
}

ul li {
	font-size: 1.2em;
	color: #333;
	margin-bottom: 10px;
}

ul li strong {
	color: #6A5ACD;
}

input[type="submit"] {
	background-color: #6A5ACD;
	color: white;
	border: none;
	padding: 10px 20px;
	font-size: 1em;
	cursor: pointer;
	border-radius: 5px;
	transition: background-color 0.3s, transform 0.3s;
}

input[type="submit"]:hover {
	background-color: #5a4bce;
}

input[type="submit"]:active {
	background-color: #6A5ACD;
	transform: scale(0.95);
}

#confirmationMessage {
	color: green;
	margin-top: 20px;
	font-size: 1.1em;
}
</style>

<script>
	function showConfirmationAndRedirect(event) {
		event.preventDefault(); // Prevent the form from submitting immediately

		// Get the form data
		var formData = new FormData(document.getElementById("borrowForm"));

		// Send the form data via AJAX
		var xhr = new XMLHttpRequest();
		xhr.open("POST", "borrow_book_servlet", true);

		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4 && xhr.status === 200) {
				// Show a confirmation message
				document.getElementById("confirmationMessage").innerHTML = "Book borrowed successfully!";

				// Redirect to the home page after 2 seconds
				setTimeout(function() {
					window.location.href = "home.jsp"; // Change this to your actual home page URL
				}, 2000);
			}
		};
		xhr.send(formData);
	}
</script>
</head>
<body>
	<div class="container">
		<h2>Borrowing A Book</h2>
		<form id="borrowForm" onsubmit="showConfirmationAndRedirect(event)">
			<ul>
				<li><strong>Book ID:</strong> ${sessionScope.book_id}</li>
				<li><strong>Title:</strong> ${sessionScope.title}</li>
				<li><strong>Author ID:</strong> ${sessionScope.author_id}</li>
				<li><strong>ISBN:</strong> ${sessionScope.isbn}</li>
				<li><strong>Publication Year:</strong>
					${sessionScope.publication_year}</li>
				<li><strong>Checkout Date:</strong> ${checkoutDate}</li>
				<li><strong>Return Date:</strong> ${returnDate}</li>
			</ul>
			<input type="submit" value="Borrow">
		</form>
		<div id="confirmationMessage"></div>
	</div>
</body>
</html>
