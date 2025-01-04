<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
	<h1> Lists of Bookings</h1>
	<table class="table">
		<tr>
			<th scope="col">Movie</th>
			<th scope="col">ReleaseDate</th>
			<th scope="col">ShowCycle</th>
			<th scope="col">ScreenType</th>
			<th scope="col">Seat Number</th>
			<th scope="col">Cancel Booking</th>
		</tr>
		<c:forEach items="${ml}" var="game">
			<tr>
				<td>${game.title}</td>
				<td>${game.releaseDate}</td>
				
				<td>${game.showCycle}</td>
				<td>Inox</td>
				<td>${game.seatNo}</td>
				<td><button onclick="sendData('${game.title}','${game.releaseDate}','${game.showCycle}');"
					 class="btn btn-danger">Cancel</button></td>
			</tr>
		</c:forEach>
	</table>
	
	<form action="/homepage" method="get">
<input type="submit" class="btn btn-primary" value="Go to HomePage" style="margin-left: 40%">
</form>
	<script>
	function sendData(t,r,s){
	$.ajax({
        url: 'http://localhost:8080/deletebookings/' + t + '/' + r + '/' + s,
        type: 'DELETE',
        data: {},
        headers: {
            'Content-Type': 'application/json'
        },
        success: function (response) {
            console.log("data uploaded successfully");
            alert("Booking deleted Sucessfully! Please refresh the page.");
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