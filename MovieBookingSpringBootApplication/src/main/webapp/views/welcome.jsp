<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Welcome ${UserName}!!!!!</h1>
<form action="/homepage" method="get">
<input type="submit"  class="btn btn-primary btn-lg btn-block" value="Movies">
</form>			
</body>
</html>