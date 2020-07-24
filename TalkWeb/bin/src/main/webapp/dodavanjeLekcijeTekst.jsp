<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<form action="/Talk/predavacController/dodajLekcijuTekst" method="post">
		
		Unesite naslov lekcije: <input type="text" name="naslovL"> <br><br>
		Unesite tekst lekcije: <input type="text" name="tekstL"> <br><br>
		Izaberite kurs za koji dodajete lekciju: <br>
			<select name="idKurs">
				<c:forEach items="${kursevi}" var="k" >
					<option value="${k.idKurs}">${k.naziv}</option>
				</c:forEach>			
			</select><br><br>
		
		<input type="submit" value="Dodaj novu lekciju">
	</form>
	${porukaL}
</body>
</html>