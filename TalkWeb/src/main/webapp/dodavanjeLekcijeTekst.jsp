<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje tekstualne lekcije </title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Dodavanje nove lekcije - tekst</h2>
	
	<div class="content">
		<form action="/Talk/predavacController/dodajLekcijuTekst" method="post">
			
			Unesite naslov lekcije: <input type="text" name="naslovL"> <br><br>
			Unesite tekst lekcije: <input type="text" name="tekstL"> <br><br>
			Izaberite kurs za koji dodajete lekciju: <br>
			<select name="idKurs">
				<c:forEach items="${kursevi}" var="k" >
					<option value="${k.idKurs}">${k.naziv}</option>
				</c:forEach>			
			</select><br><br>
			
			<input type="submit" class="btn btn-primary" value="Dodaj novu lekciju">
		</form>
		${porukaL}
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>