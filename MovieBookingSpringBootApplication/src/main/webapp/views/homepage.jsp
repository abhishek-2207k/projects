<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
	<h1>Movie Lists</h1>
	<table class="table">
		<tr>
			<th scope="col">Movie</th>
			<th scope="col">ReleaseDate</th>
			<th scope="col">ShowCycle</th>
			<th scope="col">ScreenType</th>
			<th scope="col">Seat Availability</th>
			<th scope="col">ToBook(Press)</th>
			
		</tr>
		<c:forEach items="${ml}" var="game">
			<tr>
				<td>${game.title}</td>
				<td>${game.releaseDate}</td>
				<!-- "<c:url value='/bookMovie/${game.title}' />" -->
				<td>${game.showCycle}</td>
				<td>Inox</td>
				<td>${game.seats}</td>
				<td><button onclick="sendData('${game.title}','${game.releaseDate}','${game.showCycle}','${game.seats}');"
					 class="btn btn-success">Book</button></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<form action="/bookings" method="get">
<input type="submit" class="btn btn-warning" value="MyBookings" style="margin-left: 40%">
</form>
<br>
<br>

<form action="/History" method="get">
<input type="submit" class="btn btn-danger" value="Transaction History" style="margin-left: 39%">
</form>
	<script>
function sendData(t,r,s,k){
	$.ajax({
        url: 'http://localhost:8080/bookMovie/' + t + '/' + r + '/' + s,
        type: 'POST',
        data: {},
        headers: {
            'Content-Type': 'application/json'
        },
        success: function (response) {
            if(k==0) 
            	{
            	alert("HOUSEFULL !!!");
            	}
            else
            	{
            alert("booking done Sucessfully");
            alert("Please visit My bookings to view your bookings!!");
            	}
            
        },
        error: function (response) {
            error_text = JSON.parse(response.responseText).message;
            alert(error_text);
        }
    });
	}
</script>


</body>



</html>