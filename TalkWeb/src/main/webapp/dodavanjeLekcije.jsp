<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje lekcije</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Dodavanje nove lekcije</h2>
	
	<div class="content">
		Izaberite formu lekcije: <br><br>
	
		1)<a href="/Talk/predavacController/getKursevi">Tekst</a><br><br>
		2)<a href="/Talk/predavacController/dodajLekcijuFajlInit">Slika</a><br><br>
		3)<a href="/Talk/predavacController/getSviKursevi">Video</a><br><br>
	</div>
	
	<%@ include file="footer.jsp"%>	
</body>
</html>