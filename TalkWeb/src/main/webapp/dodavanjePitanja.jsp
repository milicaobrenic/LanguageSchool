<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje pitanja</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<h2 class="mb-3 display-4 text-center">Dodavanje novog pitanja</h2>
	
	<div class="content">
		<form action="/Talk/predavacController/dodajPitanja" method="post">
			Izaberite naslov testa za koji se dodaje zeljeno pitanje: <br><br>
			<select name="idTest">
				<c:forEach  var="t" items="${test}"  >
					<option value="${t.idTest}">${t.naslov}</option>
				</c:forEach>
			</select> <br><br>
			Unesite pitanje: <input type="text" name="tekst"> <br><br>	
			Unesite broj poena za pitanje: <input type="text" name="brojPoena"> <br><br>
			<input type="submit" class="btn btn-primary" value="Sacuvaj">
		</form>
		${porukaPitanje}
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>