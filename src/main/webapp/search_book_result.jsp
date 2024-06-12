<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="library_project.books"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
        }

        ul li {
            font-size: 1.2em;
            color: #333;
            margin-bottom: 10px;
        }

        ul li strong {
            color: #6A5ACD;
        }

        form {
            margin-top: 20px;
        }

        a {
            display: inline-block;
            background-color: #6A5ACD;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            font-size: 1.1em;
            border-radius: 5px;
            transition: background-color 0.3s, transform 0.3s;
        }

        a:hover {
            background-color: #5a4bce;
        }

        a:active {
            background-color: #6A5ACD;
            transform: scale(0.95);
        }
    </style>


</head>
<body>
	<center>

		<!-- Display search results -->

		<h2>Search Results</h2>
		<ul>
			<li><strong>Book ID:</strong> ${sessionScope.book_id}</li>
			<br>
			<li><strong>Title:</strong> ${sessionScope.title}</li>
			<br>
			<li><strong>Author ID:</strong> ${sessionScope.author_id}</li>
			<br>
			<li><strong>ISBN:</strong> ${sessionScope.isbn}</li>
			<br>
			<li><strong>Publication Year:</strong>
				${sessionScope.publication_year}</li>
			<br>
		</ul>
		<form id="borrowForm" action="borrow_book_servlet" method="post">
			<input type="hidden" name="bookId" value=${book.book_id}> <a
				href="javascript:{}"
				onclick="document.getElementById('borrowForm').submit();">Borrow
				This Book</a>
		</form>
	</center>

</body>
</html>