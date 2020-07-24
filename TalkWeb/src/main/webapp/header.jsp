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
	<meta charset="UTF-8">
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Skola jezika "Talk"</title>
	<base href="/">
	<link rel="stylesheet" 
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<link href="/Talk/css/style.css" type="text/css" rel="stylesheet">

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
	<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
	<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
	
	
</head>
<body>

</body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand" href="/Talk/index.jsp">Skola jezika "Talk"</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<sec:authorize access="!isAuthenticated()">
						<li class="nav-item">
							<a class="nav-link" href="/Talk/login.jsp">Uloguj se</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/Talk/register.jsp">Napravi nalog</a>
						</li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						
						<sec:authorize access="hasRole('POLAZNIK')">
							<div class="collapse navbar-collapse" id="navbarNavDropdown">
								<ul class="navbar-nav">
									<li class="nav-item dropdown">
										<a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
											role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Moji kursevi </a>
										<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
											<a class="dropdown-item" href="/Talk/polaznikController/getKurseviPrijava">Prijava na kurs</a> 
											<a class="dropdown-item"href="/Talk/polaznikController/getKurseviPolaznik">Prijavljeni kursevi</a> 
											<a class="dropdown-item" href="/Talk/polaznikController/getKurs">Ocenjivanje kursa</a> 
											<a class="dropdown-item" href="/Talk/polaznikController/getKurseviUtisak">Dodavanje utisaka kursa</a> 
											<a class="dropdown-item" href="/Talk/polaznikController/prikazPolozenihKurseva">Polozeni kursevi</a>
										</div>
									</li>
									<li class="nav-item dropdown">
										<a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
											role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Opcije kurseva </a>
										<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
											<a class="dropdown-item" href="/Talk/korisnikController/getSviKurseviUtisak">Pregled utisaka kursa</a>
											<a class="dropdown-item" href="/Talk/korisnikController/getNajboljiKursevi">Najbolje ocenjeni kursevi</a>
											<a class="dropdown-item" href="/Talk/filtriranjeKurseva.jsp">Filtriranje kurseva</a>
										</div>
									</li>
									<li class="nav-item dropdown">
										<a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
											role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Opcije testova </a>
										<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
											<a class="dropdown-item" href="/Talk/polaznikController/getTestove">Polaganje testa</a>
										</div>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="${pageContext.request.contextPath}/logout">Odjava</a>
									</li>
								</ul>
							</div>
						</sec:authorize>
						
						<sec:authorize access="hasRole('PREDAVAC')">
							<div class="collapse navbar-collapse" id="navbarNavDropdown">
								<ul class="navbar-nav">
									<li class="nav-item dropdown">
										<a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
											role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Opcije kurseva </a>
										<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
											<a class="dropdown-item" href="/Talk/dodavanjeKursa.jsp">Dodavanje kursa</a> <a class="dropdown-item" href="/Talk/dodavanjeLekcije.jsp">Dodavanje lekcije</a> 
											<a class="dropdown-item" href="/Talk/filtriranjeKurseva.jsp">Filtriranje kurseva</a> 
											<a class="dropdown-item" href="/Talk/korisnikController/getSviKurseviUtisak">Pregled utisaka kursa</a> 
											<a class="dropdown-item" href="/Talk/korisnikController/getNajboljiKursevi">Najbolje ocenjeni kursevi</a>
										</div>
									</li>
									<li class="nav-item dropdown">
										<a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
											role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Opcije testova </a>
										<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
											<a class="dropdown-item" href="/Talk/predavacController/getLekcije">Dodavanje testa</a>
											<a class="dropdown-item" href="/Talk/predavacController/getTest">Dodavanje pitanja</a>
											<a class="dropdown-item" href="/Talk/dodavanjeOdgovora.jsp">Dodavanje odgovora</a> 
											<a class="dropdown-item" href="/Talk/predavacController/getSviPolaznici">Pregled testova</a>
											<a class="dropdown-item" href="/Talk/predavacController/getSvaPitanjaResenje">Dodavanje resenja</a>
										</div>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="${pageContext.request.contextPath}/logout">Odjava</a>
									</li>
								</ul>
							</div>
						</sec:authorize>
					</sec:authorize>
				</ul>
			</div>
		</div>
	</nav>
</html>