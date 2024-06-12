<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	text-align: center;
	background-color: #fff;
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #4CAF50;
}

p {
	font-size: 18px;
	color: #333;
}

a {
	display: inline-block;
	margin: 10px;
	padding: 10px 20px;
	font-size: 16px;
	color: #fff;
	background-color: #4CAF50;
	text-decoration: none;
	border-radius: 5px;
	transition: background-color 0.3s ease;
}

a:hover {
	background-color: #45a049;
}
</style>

</head>
<body>

	<center>

		<div class="container">
			<h1>Return Confirmation</h1>
			<p>The book has been successfully returned.</p>
			<a href="returnBook.jsp">Return Another Book</a> <a href="home.jsp">Return
				to Home Page</a>
		</div>
	</center>
</body>
</html>