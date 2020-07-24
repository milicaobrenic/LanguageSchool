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
	<title>Skola jezika "Talk"</title>
	<style type="text/css">
		.contact {
			padding-bottom: 20px !important;
			background: #EFE7BC;
		}
	</style>
</head>
<body>
<!-- 	<footer class="py-5"> -->
<!-- 		<div class="container"> -->
<!-- 			<h2 class="mb-3 display-4 text-center">Kontaktirajte nas</h2> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-12 text-center"> -->
<!-- 					<a href="/Talk/kontakt.jsp"><i class="fab fa-facebook"></i></a> -->
<!-- 					<a href="/Talk/kontakt.jsp"><i class="fab fa-instagram"></i></a> -->
<!-- 					<a href="/Talk/kontakt.jsp"><i class="fab fa-linkedin"></i></a> -->
<!-- 					<h4>&copy; Talk</h4> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</footer> -->

	<footer class="contact py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-4 text-center">
					<i class="fas fa-map-marker-alt"></i>
					<h4>Adresa</h4>
					<p>Bulevar Oslobodjenja 27 <br> Novi sad</p>
				</div>
				<div class="col-md-4 text-center">
					<i class="fas fa-phone"></i>
					<h4>Telefon</h4>
					<p>061/ 123 456 <br> 021/ 123 456</p>
				</div>
				<div class="col-md-4 text-center">
					<i class="fas fa-envelope"></i>
					<h4>E-mail</h4>
					<p>info@talk.rs</p>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>