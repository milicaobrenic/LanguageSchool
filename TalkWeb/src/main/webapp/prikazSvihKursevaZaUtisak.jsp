<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz utisaka kursa</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<h2 class="mb-3 display-4 text-center">Prikaz utisaka kursa</h2>
	
	<div class="content py-5">
		<form action="/Talk/korisnikController/getKursevUtisak" method="get">
			<c:if test="${!empty utisak}">
				<select name="idKurs">
					<c:forEach items="${utisak}" var="u">
						<option value="${u.idKurs}">${u.naziv}</option>
					</c:forEach>
				</select>
				<br>
				<br>
				<input type="submit" class="btn btn-primary" value="Prikazi utisak kursa"><br><br>
				<br>
			</c:if>
			<c:if test="${!empty k}">
				<table border="1">
					<tr>	
						<th>Utisak kursa</th>
					</tr>
					<c:forEach var="k" items="${kursic}">
						<tr>
							<td>${k}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</form>
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>

