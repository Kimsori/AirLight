<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/png" href="resources/img/PIcon.png">
<title>airLight</title>
<style>
#Qnawirte{
	border : 1px solid black;
	width : 100%;
	height : 620px;
	text-align : center;
	margin-top : 50px;
	margin-bottom : 50px;
}
#qnatb{

}
#qnatb table{
	width : 80%;
	margin : 0 auto;
	margin-top: 40px;
	height : 400px;
	border-collapse: collapse;
	background : white;
}
#qnatb table td{
	border : 1px solid black;
}
#qnatb table td:last-chlid{
	border :none;
}

#qnatb table{
	width : 60%;
	margin : 0 auto;
	margin-top: 40px;
	border-collapse: collapse;
	
}
#qnatitle{
	width : 100%;
	height : 50px;
	background : #05224a;
	line-height :50px;
	color : white;
}
#qnatitle>h2{
	margin-top : 0;
}
#title_board{
	width : 80%;
	height : 30px;
}
#area_baord{
	width : 80%;
	border : none;
}
#area_baord:placeholder-shown{
	text-align : center;
}
#qnatb table td:last-child{
	text-align : center;
}
.boardw_btn{
	width: 13%;
    height: 40px;
    background-color: #05224a;
  	border: 4px solid #05224a;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    font-size: 18px;
    margin-bottom: 10px;
    margin-top: 15px;
    margin-right : 20px;
    margin-left : 30px;
}
#ft_btn{
	background : white;
	margin : 0 auto;
	width : 60%;
}
#bdwirte_tab th{
	background : #05224a;
	color : white;
	width : 100px;
	font-size : 20px;
	font-weight : bold;
	height : 50px;
	text-align : center;
	border : 1px solid black;
}
@media(max-width:1280px){  /* =========================================1280px */
	.boardw_btn{
		width : 13%;
		font-size : 14px;
	}

}	
</style>
</head>
<body>
<div id="Qnawirte">
	<div id="qnatitle"><h2>?????? ??????</h2></div>
	<div id="qnatb">
		<form action="boardWrite" method='post' id="boardform" name="boardform">
			<table id="bdwirte_tab">
				<tr>
					<th >??????</th>
	                <td><input type='text' name='title' id="title_board"></td>
	            </tr>			
				<tr>
					<th>??????</th>
					<td><textarea name='content' rows='20' cols='80'  id="area_baord" placeholder="????????? ??????????????????" ></textarea></td>
				</tr>
			</table>
			<div id="ft_btn">
				<input type="button" value='??????' class="boardw_btn" onclick="boardChk()"><input type="reset" value="??????" class="boardw_btn" ><input
					type="button" value="????????????" onclick="history.back(-1);" class="boardw_btn">
			</div>
			
		</form>
	</div>
</div>
</body>
<script type="text/javascript">
function boardChk() {
	console.log("?????????");
	var boardform = document.boardform;		// form submit??? ?????? ?????? ??????
	var title = boardform.title.value; // ?????? ???????????? ??????
	var content = boardform.content.value; // ?????? ????????????
	
	
	if (title=="") {
		alert("????????? ??????????????????.");
		boardform.title.focus();
	}else if (content=="") {
		alert("????????? ??????????????????.");
		boardform.content.focus();
	}else {
		boardform.submit();
	}
	
}

</script>
</html>