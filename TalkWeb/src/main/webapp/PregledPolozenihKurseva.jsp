<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled polozenih kurseva</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h2 class="mb-3 display-4 text-center">Pregled polozenih kurseva</h2>
	
	<div class="content">
		<form action="/Talk/polaznikController/prikazPolozenihKurseva" method="get">
			Pregled polozenih kurseva za polaznika: ${polaznik.username }<br><br>
			<c:if test="${!empty kursevi}">
				<table border="1">
					<tr>
						<th>Naziv kursa</th>
					</tr>
					<c:forEach items="${kursevi}" var="k">
						<tr>
							<td>${k.naziv }</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</form>
		${poruka }
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>