<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kursevi polaznika</title>
</head>
<body>
	
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Kursevi odredjenog polaznika</h2>
	
	<div class="content">
		<form action="/Talk/polaznikController/prikazLekcijaKursa" method="get">
			<c:if test="${!empty kurseviPol}">
				<select name="idKurs">
					<c:forEach items="${kurseviPol}" var="k" >
						<option value="${k.idKurs}">${k.naziv}</option>
					</c:forEach>			
				</select><br><br>
				<input type="submit" class="btn btn-primary" value="Prikazi lekcije kursa"><br><br>
			</c:if>
			
			<c:if test="${!empty lekcijaK}">
				<table border="1">
					<tr>
						<th>Naziv lekcije</th>
						<th>Prikaz lekcije</th>
					</tr>
					
					<c:forEach var="i" items="${lekcijaK}">
						<tr>
							<td>${i.naslov }</td>
							<td><a href="/Talk/polaznikController/prikazLekcije?idLekcija=${i.idLekcija}">Prikazi</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</form>
		${poruka}
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>