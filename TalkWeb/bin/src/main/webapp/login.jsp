<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Skola stranih jezika "Talk"</title>
</head>
<body>

<%@ include file="header.jsp" %>

<div class="main" style="width:500px; align:center;" >
	<!-- Default form login -->
<form class="text-center border border-light p-5" action="${pageContext.request.contextPath}/login" method="post">

    <p class="h4 mb-4">Sign in</p>

    <!-- Username -->
    <input type="text" name = "username" id="defaultLoginFormUsername" class="form-control mb-4" placeholder="Username">

    <!-- Password -->
    <input type="password" name = "password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password">

    <!-- Sign in button -->
    <input type = "submit" class="btn btn-info btn-block my-4" value="Sign in">

    <!-- Register -->
    <p>Not a member?
        <a href="">Register</a>
    </p>

</form>
<!-- Default form login -->
	
</div>

</body>
</html>