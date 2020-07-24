<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Skola stranih jezika "Talk"</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<div class="container py-5">
		<form class="text-center p-5" action="/Talk/lkontroler/register" method="post">
		
		    <h2 class="mb-3 display-4 text-center">Napravite nalog</h2>
		
		    <div class="form-row mb-4">
		        <div class="col">
		            <!-- First name -->
		            <input type="text" name="ime" id="defaultRegisterFormFirstName" class="form-control" placeholder="First name">
		        </div>
		        <div class="col">
		            <!-- Last name -->
		            <input type="text" name="prezime" id="defaultRegisterFormLastName" class="form-control" placeholder="Last name">
		        </div>
		    </div>
		
		    <!-- E-mail -->
		    <input type="text" name="korisnickoIme" id="defaultRegisterFormUsername" class="form-control mb-4" placeholder="Username">
		
		    <!-- Password -->
		    <input type="password" name="lozinka" id="defaultRegisterFormPassword" class="form-control" placeholder="Password" aria-describedby="defaultRegisterFormPasswordHelpBlock">
		  
		    <!-- Sign up button -->
		    <button class="btn btn-primary" type="submit">Sign in</button>
		
			<c:if test="${! empty k }">
				Novi korisnik je dodat. ID >> ${k.idKorisnik }
			</c:if>
		</form>
	</div>
</body>
</html>