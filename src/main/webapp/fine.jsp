<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Fine Details</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 20px;
	background-color: #f4f4f4;
}

.container {
	max-width: 600px;
	margin: auto;
	background: white;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #333;
}

p {
	font-size: 1.2em;
	color: #666;
}

a {
	display: inline-block;
	margin-top: 20px;
	padding: 10px 20px;
	background-color: #007BFF;
	color: white;
	text-decoration: none;
	border-radius: 5px;
}

a:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Fine Detail</h1>
		<p>
			<strong>Book Title:</strong> ${bookTitle}
		</p>
		<p>
			<strong>Fine Amount:</strong> ${fineAmount}
		</p>
		<p>
			<strong>Reason:</strong> ${reason}
		</p>
		<p>
			<strong>Late by:</strong> ${lateDays} days
		</p>
		<a href="returnBook.jsp">Return another book</a>
		<a href="home.jsp">Return to home page</a>
	</div>
</body>
</html>
