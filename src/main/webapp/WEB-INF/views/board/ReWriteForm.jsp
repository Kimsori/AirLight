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
	width : 100%;
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
.qnabtn{
	width: 60%;
    height: 40px;
    background-color: #05224a;
  	border: 4px solid #05224a;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    font-size: 18px;
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
</style>
</head>
<body>
<div id="Qnawirte">
	<div id="qnatitle"><h2>관리자 답변 페이지</h2></div>
	<!--미답변  -->
	<div id="qnatb">
	<c:if test="${size ==1}">
		<table id="bdwirte_tab">
			<c:forEach var="list" items="${list }">
				<tr>
					<th>제목</th>
					<td>${list.title}</td>
					<th>작성자</th>
					<td>${list.first_name}${list.last_name}</td>
					<th>작성일</th>
					<td>${list.write_date}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="5">${list.content}</td>
				</tr>
				<form action="ReWrite" method="post">
				<tr>
					<th>답변</th>
					<td colspan="4">
					<textarea name='content' rows='10' cols='100'  id="area_baord" placeholder="내용을 입력해주세요" >
					</textarea>
					<input type="hidden" name="bcode" value="${list.board_code}">
					<input type="hidden" name="group" value="${list.re_group}">
						</td>
					<td><input type="submit" value="답변하기" class="boardw_btn qnabtn"></td>
				</tr>
			</form>
			</c:forEach>
			
			<tr>
				<td colspan="6">
					<button onclick="location.href='AdminPage?num=2'" class="boardw_btn">목록보기</button> <input
					type="button" value="뒤로가기" onclick="history.back(-1);" class="boardw_btn">
				</td>
			</tr>
		</table>
	</c:if>
	<!-- 답변 완료 -->
	<c:if test="${size ==2}">
		<table id="bdwirte_tab">
			<c:forEach var="list" items="${list }">
				<c:if test="${list.member_state!=2 }">
					<tr>
						<th>제목</th>
						<td>${list.title}</td>
						<th>작성자</th>
						<td>${list.first_name}${list.last_name}</td>
						<th>작성일</th>
						<td>${list.write_date}</td>
					</tr>
					<tr height="200px">
						<th>내용</th>
						<td colspan="5" >
						${list.content}
						</td>
					</tr>
				</c:if>
				<c:if test="${list.member_state==2 }">
					<tr>
						<th>${list.title}</th>
						<td colspan="3">${list.content}</td>
						<th>${list.last_name}</th>
						<td>${list.write_date}</td>
					</tr>
					<tr>
						<td colspan="6">
							<button onclick="location.href='AdminPage?num=2'" class="boardw_btn">목록보기</button> <input
							type="button" value="뒤로가기" onclick="history.back(-1);" class="boardw_btn">
						</td>
					</tr>
				</c:if>


			</c:forEach>
		</table>

	</c:if>
	</div>
</div>
</body>
</html>