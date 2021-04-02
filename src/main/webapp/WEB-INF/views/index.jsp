<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<style>

body {
	margin: 0;
	padding: 0;
background: #FFEFBA;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #FFFFFF, rgb(147, 184, 202));  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #FFFFFF, rgb(147, 184, 202)); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

}	
#contant {
	width: 100%;
	margin: 0;
	padding: 0;
}
#section {
	width: 80%;
	margin: 0 auto;
	clear : both;
}
#footer{
	clear : both;
	margin-top : 10px;
	border-top  : 5px solid black;
}
</style>
<head>
<link rel="icon" type="image/png" href="resources/img/PIcon.png">
<title>airLight</title>
<script src="https://code.jquery.com/jquery-2.2.1.js"></script>
</head>
<body>
	<div id="contant">
		<div id="header">
			<jsp:include page="main/header.jsp"></jsp:include>
			<input type="hidden" id="foot">
		</div>
		<div id="footer">
			<jsp:include page="main/footer.jsp"></jsp:include>
		</div>
		<div id="section">
		<jsp:include page="${center}"></jsp:include>
		</div>
	</div>
<script>
$(document).ready(function(){
	$("#footer").insertAfter("#section");
});
</script>
</body>
</html>
