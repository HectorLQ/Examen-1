<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Director page</title>
</head>
<body>
	<form action="/director" method="post">
		<span>Name:</span> <input type="text" name="name"> <br /> <input
			type="submit" value="Submit">
	</form>
	<br>
	<table border="1">
		<thead>
			<tr>
				<td>Cod</td>
				<td>Title</td>
				<td>codDirector</td>
				<td>Delete</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="director" items="${listAllDirectors}">
				<tr>
					<td><c:out value="${director.cod}" /></td>
					<td><c:out value="${director.name}" /></td>
					<td><a href="/director?cod=${director.cod}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<div>
		<a href="index.jsp">Return index</a>
	</div>	
</body>
</html>