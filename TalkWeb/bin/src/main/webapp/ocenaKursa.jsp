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
	<form action = "/Talk/polaznikController/dodajOcenuKursu" method="post">
		
			<select name="kursO">
				<c:forEach items="${kursevi}" var="k" >
					<option value="${k.idKurs}">${k.naziv}</option>
				</c:forEach>			
			</select><br><br>
		Ocena izabranog kursa: <input type="text" name="ocenaKursa"> <br><br>
	
		<input type="submit" value="Dodaj ocenu kursa">
	
		<br><br>
		
	</form>
	${porukaK}

</body>
</html>