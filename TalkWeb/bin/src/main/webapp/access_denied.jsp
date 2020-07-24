<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
@import url('https://fonts.googleapis.com/css?family=Press+Start+2P');


$color: #54FE55;
$color2: #1a4f1a;
$glowSize: 10px;

html,body{
   width: 100%;
   height: 100%;
   margin: 0;
}

*{
   font-family: 'Press Start 2P', cursive;
   box-sizing: border-box;
}
#app{
   padding: 1rem;
   background: white;
   display: flex;
   height: 100%;
   justify-content: center; 
   align-items: center;
   color: $color;
   text-shadow: 0px 0px $glowSize ;
   font-size: 6rem;
   flex-direction: column;
   .txt {
      font-size: 1.8rem;
   }
}
@keyframes blink {
    0%   {opacity: 0}
    49%  {opacity: 0}
    50%  {opacity: 1}
    100% {opacity: 1}
}

.blink {
   animation-name: blink;
    animation-duration: 1s;
   animation-iteration-count: infinite;
}
</style>
<title>Skola stranih jezika "Talk"</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<div id="app">
   <div>403</div>
   <div class="txt">
      Nemate pravo pristupa!<span class="blink">_</span>
   </div>
</div>

</body>
</html>