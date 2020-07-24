<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dodavanje novog kursa</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Dodavanje novog kursa</h2>
	
	<div class="content py-5">
	
		<form action="/Talk/predavacController/dodajKurs" method="post">
	        Unesite naziv kursa: <input type="text" name="naziv"><br><br>
	        Unesite opis kursa: <input type="text" name="opis"><br><br>
	        Unesite ocekivani ishod kursa: <input type="text" name="ishod"><br><br>
	        <input class="btn btn-primary" type="submit" value="Sacuvaj"><br><br>       
	    </form>
	    ${poruka }
    </div>
    
    <%@ include file="footer.jsp"%>
</body>
</html>