<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz lekcije</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Prikaz lekcije</h2>
	
	<div class="content">
		<c:out value="${lekcija.naslov}"></c:out><br><br>
		<c:if test="${not empty lekcija.tekst }">
			<c:out value="${lekcija.tekst }"></c:out>
		</c:if><br><br>
		<c:if test="${not empty lekcija.fajl }">
			<img src="/Talk/polaznikController/prikazFajla?idLekcija=${lekcija.idLekcija}"/>
		</c:if>
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>