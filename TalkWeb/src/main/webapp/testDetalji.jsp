<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalji testa</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<h2 class="mb-3 display-4 text-center">Prikaz testa</h2>

	<div class="content">
		<form action="/Talk/polaznikController/prihvatiOdgovoreTesta" method="post">
			<ol type="1">
				<c:forEach var="p" items="${pitanjaT }">
					<li>
						${p.tekst }
						<input type="hidden" name="pitanjeId" value="${p.idPitanje}">
						<ol type="a">
							<c:forEach var="o" items="${p.odgovors}">
								<c:if test="${empty o.oznakaPolaznik }">
									<c:if test="${not empty o.tekst}">
									<li>
										<input type="text" name="tekstOdg"><br><br>
									</li>
								</c:if>
								<c:if test="${not empty o.opcija1}">
									<c:if test="${(o.tacnostOpcije1 == 1 and o.tacnostOpcije2 == 0 and o.tacnostOpcije3 == 0) or
									 (o.tacnostOpcije1 == 0 and o.tacnostOpcije2 == 1 and o.tacnostOpcije3 == 0)  or
									 (o.tacnostOpcije1 == 0 and o.tacnostOpcije2 == 0 and o.tacnostOpcije3 == 1)}">
										<li>
											<input type="radio" name="opcije" value="${o.opcija1 }">${o.opcija1 }<br>
											<input type="radio" name="opcije" value="${o.opcija2 }">${o.opcija2 }<br>
											<input type="radio" name="opcije" value="${o.opcija3 }">${o.opcija3 }<br>
										</li>
									</c:if>
									<c:if test="${(o.tacnostOpcije1 == 1 and o.tacnostOpcije2 == 1 and o.tacnostOpcije3 == 0) or
									 (o.tacnostOpcije1 == 0 and o.tacnostOpcije2 == 1 and o.tacnostOpcije3 == 1)  or
									 (o.tacnostOpcije1 == 1 and o.tacnostOpcije2 == 0 and o.tacnostOpcije3 == 1) or 
									  (o.tacnostOpcije1 == 1 and o.tacnostOpcije2 == 1 and o.tacnostOpcije3 == 1)}">
										<li>
											<input type="checkbox" name="checkb1" value="${o.opcija1 }">${o.opcija1 }<br>
											<input type="checkbox" name="checkb2" value="${o.opcija2 }">${o.opcija2 }<br>
											<input type="checkbox" name="checkb3" value="${o.opcija3 }">${o.opcija3 }<br>
										</li>
									</c:if>
								</c:if>
								</c:if>
							</c:forEach>
						</ol>
					</li>
				</c:forEach>
			</ol><br><br>
			<input type="submit" class="btn btn-primary" value="Potvrdi">
		</form>
	</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>