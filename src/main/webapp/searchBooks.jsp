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
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
        }

        h1 {
            color: #333;
            font-size: 2.5em;
            margin-bottom: 20px;
        }

        form {
            display: inline-block;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            font-size: 1.2em;
            color: #333;
            margin-right: 10px;
        }

        input[type="text"] {
            padding: 10px;
            font-size: 1em;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-right: 10px;
            width: 200px;
        }

        input[type="submit"] {
            background-color: #6A5ACD; /* Slate blue color */
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
    </style>

</head>
<body>
	<center>
		<h1>Search Books</h1>
		<form action="search_book" method="post">
			<label for="title">Title:</label> <input type="text" id="title"
				name="title"> <input type="submit" value="Search">
		</form>
	</center>
	
	
</body>
</html>