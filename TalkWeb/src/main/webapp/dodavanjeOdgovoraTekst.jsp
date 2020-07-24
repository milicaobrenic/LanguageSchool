<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje odgovora - tekst</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Dodavanje novog odgovora - tekst</h2>
	
	<div class="content">
		<form action="/Talk/predavacController/dodajOdgovorTekst" method="post">
			Unesite naziv testa za koji dodajete pitanje: <input type="text" name="testIme"><br><br>
			Odaberite pitanje za koje dodajete odgovor:<br>
			<select name="idPitanje">
				<c:forEach items="${pitanja}" var="i" >
						<option value="${i.idPitanje}">${i.tekst}</option>
					</c:forEach>
			</select><br><br>
			Unesite tekst odgovora: <input type="text" name="odgovorTekst"><br><br>
			
			<input type="submit" class="btn btn-primary" value="Dodaj odgovor">
		</form>
		${porukaO}
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>