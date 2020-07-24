<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Skola stranih jezika "Talk"</title>
	<style type="text/css">
		.main {
		  max-width: 500px;
		  margin: auto;
		  padding: 10px;
		}
	</style>
</head>	
<body>
	<%@ include file="header.jsp" %>

	<div class="container text-center py-5">
		<form class="text-center p-5" action="${pageContext.request.contextPath}/login" method="post">
		
		    <h2 class="mb-3 display-4 text-center">Unesite podatke</h2>
		
		    <!-- Username -->
		    <input type="text" name = "username" id="defaultLoginFormUsername" class="form-control mb-4" placeholder="Username">
		
		    <!-- Password -->
		    <input type="password" name = "password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password">
		
		    <!-- Sign in button -->
		    <input type = "submit" class="btn btn-primary" value="Uloguj se">
		
		</form>
	</div>	
</body>
</html>