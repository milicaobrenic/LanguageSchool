<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled kurseva</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Pregled kurseva</h2>
	
	<div class="content">
		<form action="/Talk/polaznikController/savePolaznik" method="post">
			Izaberite kurs na koji zelite da se prijavite: <br><br>
			
			<select name="idKurs">
				<c:forEach items="${kurseviP}" var="k" >
						<option value="${k.idKurs}">${k.naziv}</option>
					</c:forEach>
			</select> <br><br>
			<input type="submit" class="btn btn-primary" value="Prijavi se"><br><br>	
		</form>
		 ${porukaP}
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>