<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filtriranje kurseva</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Filtriranje kurseva</h2>
	
	<div class="content">
		Izaberite kriterijum po kojem zelite da filtrirate kurseve:<br><br>
			1)<a href="/Talk/filtriranjeKursevaLekcije.jsp">Po odredjenom broju lekcija</a><br><br>
			2)<a href="/Talk/filtriranjeKursevaOcena.jsp">Po odredjenoj oceni</a><br><br>
			3)<a href="/Talk/filtriranjeKursevaRec.jsp">Po odredjenoj reci</a><br><br>
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>