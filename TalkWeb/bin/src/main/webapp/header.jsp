<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="/Talk/js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="/Talk/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="/Talk/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="/Talk/js/mdb.min.js"></script>
<meta charset="UTF-8">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="/Talk/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="/Talk/css/mdb.min.css" rel="stylesheet">
<!-- Your custom styles (optional) -->
<link href="/Talk/css/style.css" rel="stylesheet">
</head>
<body>

</body>
<nav class="navbar navbar-expand-lg navbar-dark primary-color">
	<a class="navbar-brand" href="#">Skola stranih jezika "Talk"</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<sec:authorize access="!isAuthenticated()">
				<li class="nav-item"><a class="nav-link"
					href="/Talk/login.jsp">Uloguj se</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/Talk/register.jsp">Napravi nalog</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Odjava</a></li>
				 <sec:authorize access="hasRole('POLAZNIK')">
				 	<li class="nav-item"><a class="nav-link" href="/Talk/polaznikController/getKurs">Dodaj ocenu</a></li>
				 	
				</sec:authorize>
				<sec:authorize access="hasRole('PREDAVAC')">
					<li class="nav-item"><a class="nav-link" href="/Talk/dodavanjeKursa.jsp">Kreiranje kursa</a></li>
					<li class="nav-item"><a class="nav-link" href="/Talk/dodavanjeLekcije.jsp">Dodavanje lekcije</a></li>
					<li class="nav-item"><a class="nav-link" href="/Talk/predavacController/getLekcije">Prikaz lekcija</a></li>
					<li class="nav-item"><a class="nav-link" href="/Talk/predavacController/getTest">Dodaj pitanje</a></li>		
				</sec:authorize>
			</sec:authorize>
		</ul>
	</div>
</nav>


</html>