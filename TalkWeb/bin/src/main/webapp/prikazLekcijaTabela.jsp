<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz lekcija</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<form action="/Talk/predavacController/getLekcije" method="get">
		<c:if test="${!empty lekcije}">
			<table border="1">
				<tr>
					<th>Naziv kursa</th>
					<th>Naziv lekcije</th>
					<th>Dodavanje testa</th>
				</tr>
				
				<c:forEach var="i" items="${lekcije}">
					<tr>
						<td>${i.kur.naziv }</td>
						<td>${i.naslov }</td>
						<td><a href="/Talk/predavacController/getKurseviTest?idKurs=${i.kur.idKurs}">Dodaj test</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form>
</body>
</html>