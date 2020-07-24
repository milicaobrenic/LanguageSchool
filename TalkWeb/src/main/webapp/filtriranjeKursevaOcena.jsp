<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filtriranje kurseva - ocena</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Filtriranje kurseva po broju oceni</h2>
	
	<div class="content">
		<form action="/Talk/korisnikController/filtriranjeOcena" method="get">
		
			Unesite ocenu: <input type="text" name="ocenaK"><br><br>
			
			<input type="submit" class="btn btn-primary" value="Potvrdi"><br><br><br>
		
		</form>
		
		<form action="/Talk/korisnikController/filtriranjeOcena" method="get">
			<table border="1">
				<tr><th>Naziv kursa</th></tr>
				<c:forEach items="${filtriraniKOcena }" var="f">
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