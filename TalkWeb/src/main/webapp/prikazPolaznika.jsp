<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz polaznika</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<h2 class="mb-3 display-4 text-center">Prikaz polaznika kursa</h2>
	
	<div class="content">
		<form action="/Talk/predavacController/getPolaznikovTest" method="get">
			 <select name="idPrijavljeniPolaznik">
				<c:forEach var="p" items="${polaznici }">
					<option value="${p.idPrijavljeniPolaznik}">${p.ime}  ${p.prezime}</option>
				</c:forEach>
			</select><br><br> 
			<input type="submit" class="btn btn-primary" value="Prikaz testa za izabranog polaznika">
		</form>
	</div>	
	
	<%@ include file="footer.jsp"%>
</body>
</html>