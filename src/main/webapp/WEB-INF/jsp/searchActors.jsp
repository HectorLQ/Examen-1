<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<%
		Director listFilterDirectors = (Director) request.getAttribute("listFilterDirectors");
	%>

	<form action="/searchActor" method="post">
		<span>Search Actor/Actress:<input type="text" name="name"></span> <br />
		<input type="submit" value="Submit">
	</form>
	<br />

	<table border="1">
		<thead>
			<tr>
				<td>Director:</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="name" items="${listFilterDirectors.name}">
					<tr>
						<td><c:out value="${name}" /></td>
					</tr>
				</c:forEach>
			</tr>
		</tbody>
	</table>
	<div>
		<a href="index.jsp">Return index</a>
	</div>
</body>
</html>