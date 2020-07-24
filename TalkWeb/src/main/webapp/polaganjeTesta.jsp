<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Polaganje testa</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Polaganje testa</h2>
	
	<div class="content">
		<form action="/Talk/polaznikController/testDetalji" method="post">
			Izaberite test koji zelite da polazete:<br>
			<select name="idTestPol">
				<c:forEach items="${testoviPol }" var="t">
					<option value="${t.idTest}">${t.naslov}</option>
				</c:forEach>
			</select><br><br>
			<input type="submit" class="btn btn-primary" value="Potvrdi">
		</form>
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>