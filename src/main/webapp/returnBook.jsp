<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Return Book</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

nav {
	background-color: #333;
	display: flex;
	justify-content: center;
	padding: 10px 0;
}

nav a {
	color: white;
	text-align: center;
	padding: 14px 20px;
	text-decoration: none;
	transition: background-color 0.3s;
	margin: 0 10px;
}

nav a:hover {
	background-color: #ddd;
	color: black;
}

.container {
	text-align: center;
	background-color: #fff;
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	max-width: 500px;
	margin: 50px auto;
}

h2 {
	color: #4CAF50;
	margin-bottom: 20px;
}

label {
	font-size: 18px;
	color: #333;
	display: block;
	margin-bottom: 5px;
}

input[type="text"] {
	width: calc(100% - 22px);
	padding: 10px;
	margin: 10px 0;
	box-sizing: border-box;
	border: 2px solid #ddd;
	border-radius: 5px;
	font-size: 16px;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	margin-top: 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 18px;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.form-group {
	margin-bottom: 20px;
	text-align: left;
}
</style>


</head>
<body>
	<center>

		<nav>
			<a href="home.jsp">Home
			</a> <a href="searchBooks.jsp">Search Books</a>
			 <a href="returnBook.jsp">Return Books</a>
			  <a href="viewFines.jsp">Manage Fines</a> 
			  <a href="logout.html">Logout</a>
		</nav>
	</center>


	<div class="container">
    <h2>Return Book</h2>
    <form action="returnBookServlet" method="post">
        <label for="bookTitle">Book Title:</label>
        <input type="text" id="bookTitle" name="book_title" required><br><br>
        
      
        
        <input type="submit" value="Return Book">
    </form>
	</div>

</body>
</html>
