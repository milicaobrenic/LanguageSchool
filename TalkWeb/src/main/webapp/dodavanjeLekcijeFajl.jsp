<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje lekcije - fajl</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Dodavanje nove lekcije - fajl </h2>
	
	<div class="content">
		<form:form modelAttribute="lekcijaF"  action="/Talk/predavacController/dodajLekcijuFajl" method="post" enctype="multipart/form-data">
			Unesite naslov lekcije: <br><input type="text" name="naslovF"><br><br>
			Unesite opis/tekst u vezi sa fajlom:<br><input type="text" name="tekstF"><br><br>
			Odaberite fajl: <br> <input type="file" name="fajl"><br><br>
			Unesite naziv kursa za koji dodajete lekciju: <br><input type="text" name="nazivKursaF">
			<br><br>
			<input type="submit" class="btn btn-primary" value="Dodaj novu lekciju">
		</form:form>
		${porukaF }
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>