<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje odgovora</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Dodavanje novog odgovora</h2>
	
	<div class="content">
		Izaberite formu odgovora: <br><br>
		
		1)<a href="/Talk/predavacController/getPitanja">Tekst</a><br><br>
		2)<a href="/Talk/predavacController/getSvaPitanja">Jedna opcija</a><br><br>
		3)<a href="/Talk/predavacController/getSvaPitanja">Vise opcija</a><br><br>
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>