<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction History</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<h1> Transaction History</h1>
	<table class="table">
		<tr>
			<th scope="col">Movie</th>
			<th scope="col">ReleaseDate</th>
			<th scope="col">ShowCycle</th>
			<th scope="col">SeatNo</th>
			<th scope="col">Status</th>
		</tr>
		<c:forEach items="${hp}" var="game">
			<tr>
				<td>${game.title}</td>
				<td>${game.releaseDate}</td>
				
				<td>${game.showCycle}</td>
				<td>${game.seatNo}</td>
				<td>${game.status}</td>
		</c:forEach>
	</table>
<form action="/homepage" method="get">
<input type="submit" class="btn btn-primary" value="Go to HomePage" style="margin-left: 40%">
</form>
</body>
</html>