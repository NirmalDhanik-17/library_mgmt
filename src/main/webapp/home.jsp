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
            text-align: center;
        }

        header {
            background-color: #6A5ACD; /* Slate blue color */
            color: white;
            padding: 20px 0;
            margin-bottom: 20px;
        }

        header h1 {
            margin: 0;
            font-size: 2.5em;
        }

        header h2 {
            margin: 0;
            font-size: 1.5em;
        }

        nav {
            background-color: #333;
            padding: 10px 0;
        }

        nav .nav-container {
            display: flex;
            justify-content: center;
            gap: 15px; /* Spacing between links */
        }

        nav a {
            color: white;
            text-decoration: none;
            padding: 10px 20px;
            font-size: 1.1em;
            transition: background-color 0.3s, color 0.3s;
            border-radius: 5px;
        }

        nav a:hover {
            background-color: #ddd;
            color: black;
        }

        nav a:active {
            background-color: #6A5ACD;
            color: white;
        }
    </style>
</head>

</head>

<body>
<center>
		<header>
        <h1>Welcome to the Library Management System</h1>
        <h2>Hello, <%= session.getAttribute("username") %>!</h2>
         <!-- Display user's name -->
    </header>
    <nav>
    <div class="nav-container">
        <a href="searchBooks.jsp">Search Books</a>
       
        <a href="returnBook.jsp">Return Books</a>
        
        <a href="fine.jsp">Manage Fines</a>
        
        <!-- Add more links as needed -->
        <a href="logout.html">Logout</a>
        
        </div>
    </nav>

    </center>
</body>
</html>