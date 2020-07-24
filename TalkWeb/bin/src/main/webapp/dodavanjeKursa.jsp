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
	
	<form action="/Talk/predavacController/dodajKurs" method="post">
        Unesite naziv kursa: <input type="text" name="naziv"><br><br>
        Unesite opis kursa: <input type="text" name="opis"><br><br>
        Unesite ocekivani ishod kursa: <input type="text" name="ishod"><br><br>
        <input type="submit" value="Sacuvaj"><br><br>        
    </form>
    ${poruka }
</body>
</html>