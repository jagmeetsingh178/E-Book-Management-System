<%@page import="java.util.List"%>
<%@page import="com.jspider.jdbc_prepared_statement_crud_operation.dao.BookDao"%>
<%@page import="com.jspider.jdbc_prepared_statement_crud_operation.dto.Book"%>
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
    background-color: #f0f0f0;
    margin: 0;
    padding: 0;
}

.container {
    width: 80%;
    margin: auto;
    overflow: hidden;
}

h1 {
    text-align: center;
    color: #333;
}

nav {
    text-align: center;
    margin: 20px 0;
}

nav a {
    text-decoration: none;
    color: #0066cc;
    margin: 0 10px;
    font-size: 18px;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 18px;
    text-align: left;
    border: 1px solid black;
}

table caption {
    font-size: 24px;
    margin-bottom: 10px;
    text-align: left;
}

th, td {
    padding: 12px 15px;
    border: 1px solid #ddd;
}

th {
    background-color: #f2f2f2;
}

tr:nth-child(even) {
    background-color: #f9f9f9;
}

tr:hover {
    background-color: #f1f1f1;
}

a {
    text-decoration: none;
    color: #0066cc;
}

a:hover {
    text-decoration: underline;
}


</style>
</head>
<body>

	
		<%
			BookDao dao = new BookDao();
			List<Book> books = dao.displayAllBookDataDao();
		%>
		
		
	<div class="container">
        <h1>Books Management</h1>
        <nav>
            <a href="book-register.jsp" target="_blank">
                <button type="submit">Add New Book</button>
            </a>
            <a href="book-management.jsp" target="_blank"><button type="submit">
                List All Books
            </button></a>
        </nav>
        <table>
            <caption>List of Books</caption>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Price</th>
                    <th>Actions</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
           <% for(Book book: books){ %>
			<tbody>
				<tr>
					<td><%=book.getId()%></td>
					<td><%=book.getTitle()%></td>
					<td><%=book.getAuthor()%></td>
					<td><%=book.getPrice() %></td>
					<td> <a href="delete?id=<%=book.getId()%>" target="_blank"><button>DELETE</button></a> </td>
					<td> <a href="book-update.jsp?id=<%=book.getId()%>" target="_blank"><button>UPDATE</button></a></td>
				</tr>
			</tbody>
			<%}%>
        </table>
    </div>
</body>
</html>