<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ocena kursa</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Ocenjivanje kursa</h2>
	
	<div class="content">
		<form action = "/Talk/polaznikController/dodajOcenuKursu" method="post">
			<select name="kursO">
					<c:forEach items="${kursevi}" var="k" >
						<option value="${k.idKurs}">${k.naziv}</option>
					</c:forEach>			
				</select><br><br>
			Ocena izabranog kursa: <input type="text" name="ocenaKursa"> <br><br>
			Datum: <input type="date" name="datumOcene"> <br><br>
			<input type="submit" class="btn btn-primary" value="Dodaj ocenu kursa"><br><br>	
		</form>
		${porukaK}
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>