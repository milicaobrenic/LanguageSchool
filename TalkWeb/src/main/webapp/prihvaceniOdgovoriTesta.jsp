<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prihvaceni odgovori testa</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<h2 class="mb-3 display-4 text-center">Prihvaceni odgovori testa</h2>

	<div class="content">
		${porukaPol}
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>