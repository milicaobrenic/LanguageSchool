<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Skola stranih jezika "Talk"</title>
	<link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"/>
	<script type="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<script type="webjars/jquery/3.0.0/js/jquery.min.js"></script>
	<style>
		.main img {
   		 	width: 1200px;
   		 	height: 500px;
   		 	display: block;
 			margin-left: auto;
  			margin-right: auto;
   		 }
   		 @keyframes blink {
    0%   {opacity: 0}
    49%  {opacity: 0}
    50%  {opacity: 1}
    100% {opacity: 1}
}

.blink {
   animation-name: blink;
    animation-duration: 1.5s;
   animation-iteration-count: infinite;
}
	</style>
</head>
<body>

<%@ include file="header.jsp" %>



<div class="blink" style="font-size:25px; text-align:center;">
	<br><i>	Dobrodosli na Skola stranih jezika "Talk" <br/></i>
</div>
	
</body>
</html>