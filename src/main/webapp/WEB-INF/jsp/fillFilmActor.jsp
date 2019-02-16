<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<%
		request.getAttribute("codFilm");
		request.getAttribute("codActor");
	%>

	<form action="/insertFilmActor?codFilm=${codFilm}&codActor=${codActor}"
		method="post">
		<span>Character:</span><input type="text" name="character"> <br />
		<span>Cache:</span> <input type="text" name="cache"> <br />
		<input type="submit" value="Submit">
	</form>
	<div>
		<a href="index.jsp">Return index</a>
	</div>
</body>
</html>