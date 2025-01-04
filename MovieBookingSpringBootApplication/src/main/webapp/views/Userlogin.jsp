<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MoviebookingApplication</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<h1 style="margin-left: 35%" style="color:Purple;">Welcome to Movie Booking Application</h1>
<br>
<br>
<form class="form-group" action="/login" method="post" style="margin-left: 40%">

  <label for="id">UserName:</label>
  <input type="text" id="id" name="userName" placeholder="admin" value=""><br><br>
  <label for="password">Password</label>
  <input type="text" id="password" name="password" placeholder="admin" value=""><br><br>
  <input type="submit" class="btn btn-primary btn-lg" value="Login" style="margin-left: 10%">
  <h1>${error}</h1>
</form>

</body>
</html>