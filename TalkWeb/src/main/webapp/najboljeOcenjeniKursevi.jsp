<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Najbolje ocenjeni kursevi</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Najbolje ocenjeni kursevi</h2>
	
	<div class="content">
		<form action="/Talk/korisnikController/getNajboljiKursevi" method="get">
				<table border="1">
					<tr>
						<th>Naziv kursa</th>
						<th>Komentar</th>
						<th>Ocena</th>
					</tr>
					
					<c:forEach var="k" items="${najboljiKursevi}">
						<tr>
							<td>${k.naziv}</td>
							<td>${k.komentar}</td>
							<td>${k.ocena}</td>
						</tr>
					</c:forEach>
				</table>
		</form>
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>