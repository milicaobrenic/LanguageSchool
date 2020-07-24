<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<form action="/Talk/predavacController/dodajPitanja" method="post">
		Unesite pitanje:<input type="text" name="tekst"> <br> <br>
		Izaberite naslov testa za koji se dodaje zeljeno pitanje: <br><br>
		<select name="idTest">
			<c:forEach  var="t" items="${test}"  >
				<option value="${t.idTest}">${t.naslov}</option>
			</c:forEach>
		</select> <br><br>
		
		<br> <input type="submit" value="Sacuvaj">


	</form>
	${porukaPitanje}


</body>
</html>