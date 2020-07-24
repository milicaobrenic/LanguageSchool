<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filtriranje kurseva - rec</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Filtriranje kurseva po reci</h2>
	
	<div class="content">
		<form action="/Talk/korisnikController/filtriranjeRec" method="get">
			Unesite rec: <input type="text" name="rec"><br><br>
			<input type="submit" class="btn btn-primary" value="Potvrdi"><br><br><br>
		</form>
		
		<form action="/Talk/korisnikController/filtriranjeRec" method="get">
			<table border="1">
				<tr><th>Naziv kursa</th></tr>
				<c:forEach items="${filtriraniKRec }" var="f">
					<tr>
						<td>${f.naziv }</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>