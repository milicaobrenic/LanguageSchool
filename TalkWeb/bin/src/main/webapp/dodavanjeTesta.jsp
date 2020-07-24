<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje testa</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<form action="/Talk/predavacController/saveTest" method="post">
	
		Unesite naslov testa: <input type="text" name="naslovT"><br><br>
	
		Unesite broj poena:<input type = "text" name = "brojPoena"><br><br>
	
		
		<input type="submit" value="Dodaj novi test"> <br><br>
	
		${porukaT}
		
		<br><br>

	</form>
</body>
</html>