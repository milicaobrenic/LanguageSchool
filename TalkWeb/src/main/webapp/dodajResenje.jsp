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
	
	<h2 class="mb-3 display-4 text-center">Dodavanje resenja za test</h2>
	
	<div class="content py-5">
		<form action = "/Talk/predavacController/getDodajResenje" method ="post">
			Izaberite pitanje za koje dodajete resenje:<br><br>
			<select name="idPitanja">
				<c:forEach  var="p" items="${pitanja}"  >
					<option value="${p.idPitanje}">${p.tekst}</option>
				</c:forEach>
			</select> <br><br>
			Unesite resenje izabranog pitanja: <input type = "text" name ="tekst">
			<br>
			<br>
			<input type = "submit" class="btn btn-primary" value = "Unesi resenje pitanja">
		</form>
		${porukaResenje}
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>