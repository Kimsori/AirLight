<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/png" href="resources/img/PIcon.png">
<title>Insert title here</title>
<style>
	#seat{
		width : 95%;
		height : 800px;
		margin : 0 auto;
		margin-top : 40px;
		margin-bottom : 40px;
		border : 2px solid black;
		border-radius : 5px;
		background : white;
	}
	#seat>h2{
		margin-left : 20px;
	}
	#seat_title{
		width : 100%;
		text-align : center;
		font-weight : bold;
		font-size : 20px;
		background : #ece6cc;
		color : black;
		padding : 5px;
		margin-left : 20px;
	}
	#seat_title1{
		margin-left : 60px;
		width : 100%;
		text-align : center;
		font-weight : bold;
		font-size : 20px;
		margin-top :  20px;
		margin-bottom :  20px;
		background : #ece6cc;
		color : black;
		padding : 5px;
		margin-left : 20px;
	}
	#seat_pilot,#seat_pilotbody{
		display : inline-block;
	}
	#seat_contant{
		margin-left : 60px;
		margin-top : 40px;
		margin-right : 40px;
	}
	#seat_pilot{
		
		width : 152px;
		height : 244px;
		margin : 0;
		background : white;
		background-image : url(resources/img/headair.jpg);
		
	}
	#seat_pilotbody{
		margin : 0;
		padding : 10px;
		background : white;
		border-top : 2px solid gray;
		border-bottom : 2px solid gray;
		border-right : 2px solid gray;
		border-radius : 0px 30px 30px 0px;
		vertical-align : top;
		margin-top : 2.5px;
	}
	#seat_pilot1,#seat_pilotbody1{
		display : inline-block;
	}
	#seat_pilot1{
		border-radius : 120px 0px 0px 120px;
		width : 152px;
		height : 244px;
		margin : 0;
		background-image : url(resources/img/headair.jpg);
		margin-left : 60px;
	}
	#seat_pilotbody1{
		margin : 0;
		padding : 10px;
		border-top : 2px solid gray;
		border-bottom : 2px solid gray;
		border-right : 2px solid gray;
		border-radius : 0px 30px 30px 0px;
		vertical-align : top;
		margin-top : 2.5px;
		
	}
	#seat table{
		border-collapse: collapse;
		width: 1200px;
		margin-top : -20px;
	}
	.myseat{
		width: 20px; 
		height: 20px;
		border: 1px solid black;
		display: inline-block;
		cursor: pointer;
	}
	.alpaSeat{
		display: inline-block;
		margin : 0;
		height : 0;
	}
	.alpaSeat>p{
		margin : 0;
		text-align : center;
	}
	#seat_pilotbody>.seat_eng:first-of-type{
		vertical-align : bottom;
		margin-bottom : 4px;
	}
	#seat_pilotbody1>.seat_eng:first-of-type{
		vertical-align : bottom;
		margin-bottom : 4px;
	}
	.seat_eng{
		display : inline-block;
		border : 1px solid black;
		vertical-align : top;
		width: 20px; 
		height: 20px;
		text-align : center;
		line-height :20px;
		vertical-align : top;
	}
	.redseat{
		background-color: #DC143C;
		border: 1px solid #DC143C;
		cursor: auto;
	}
	
	#select01, #select02{
		display: inline-block;
	}
	#select01{
		vertical-align: top;
	}
	#select02{
		height : 700px;
		margin-left : 40px;
	}
	#select03{
		width: 300px;
		height : 450px;
		border: 3px solid black;
		border-radius : 5px;
	}
	#select03>p{
		text-align : right;
		margin-right : 10px;
		font-weight : bold;
	}
	#select04{
		width: 180px;
		height : 150px;
		border: 3px solid black;
		border-radius : 5px;
		margin-top : 20px;
	}
	#box1,#span_box1{display:inline-block;}
	#box2,#span_box2{display:inline-block;}
	#box3,#span_box3{display:inline-block;}
	#box1{width : 20px; height : 20px; border:1px solid black; background:#d3d3d3; margin-left:20px;margin-top:20px; vertical-align:bottom;}
	#box2{width : 20px; height : 20px; border:1px solid black; background:#4169e1;margin-left:20px; margin-top:20px; vertical-align:bottom;}
	#box3{width : 20px; height : 20px; border:1px solid black; background:#DC143C;margin-left:20px; margin-top:20px; vertical-align:bottom;}
	#span_box1{font-weight:bold;line-height:20px;height:20px;margin-left:20px; }
	#span_box2{font-weight:bold;line-height:20px;height:20px;margin-left:20px;}
	#span_box3{font-weight:bold;line-height:20px;height:20px;margin-left:20px;}
	#tex{
		font-size : 20px;
		color : #d60815;
	}
	#total{
		color  : #0180a3;
		font-size : 20px;
	}
	#ticketing_btn{
		text-align : right ; 
		border-radius : 5px;
    	border : 2px solid black;
    	font-weight : bold;
    	font-size : 17px;
    	background : #ece6cc ;
    	float : right;
    	margin-right : 10px;
    	margint-top : 30px;
	}
	.grayseat{
		background-color: lightgray;
		cursor: auto;
	}
	#dashline{
		border-style : dashed;
	}
	/* =========================================================== 블랭크 좌석 =========================================================== */
	.blank{
		width: 20px; 
		height: 20px;
		display: inline-block;
	}
	.numP:nth-of-type(3), .numP:nth-of-type(9), .numP:last-of-type {
		text-align: left;
	}
	#blank0{
		background-image : url(resources/img/tilot.jpg);
		border : 1px solid black;
		box-sizing : border-box;
	}
	#blank2{
		background-image : url(resources/img/tilot.jpg);
		border : 1px solid black;
		box-sizing : border-box;
	}
	#blank11,#blank14,#blank17{
		background-image : url(resources/img/pork.jpg);
		border : 1px solid black;
		box-sizing : border-box;
	}
	.numPP:nth-of-type(3), .numPP:nth-of-type(9), .numPP:last-of-type {
		text-align: left;
	}
	@media(max-width:1280px){	/*=========================================1280px  */
		#seat{
		width : 110%;
		height : 800px;
		margin : 0 auto;
		margin-top : 40px;
		margin-bottom : 40px;
		border : 2px solid black;
		border-radius : 5px;
		background : white;
	}
	#seat>h2{
		margin-left : 20px;
	}
	#seat_title{
		width : 90%;
		text-align : center;
		font-weight : bold;
		font-size : 16px;
		background : #ece6cc;
		color : black;
		padding : 5px;
		margin-left : 20px;
	}
	#seat_title1{
		margin-left : 60px;
		width : 90%;
		text-align : center;
		font-weight : bold;
		font-size : 16px;
		margin-top :  20px;
		margin-bottom :  20px;
		background : #ece6cc;
		color : black;
		padding : 5px;
		margin-left : 20px;
	}
	#seat_pilot,#seat_pilotbody{
		display : inline-block;
	}
	#seat_contant{
		margin-left : 30px;
		margin-top : 40px;
		margin-right : 40px;
	}
	#seat_pilot{
		width : 152px;
		height : 244px;
		margin : 0;
		margin-left: -26px;
		background : white;
		background-image : url(resources/img/headair.jpg);
		
	}
	#seat_pilotbody{
		margin : 0;
		padding : 10px;
		background : white;
		border-top : 2px solid gray;
		border-bottom : 2px solid gray;
		border-right : 2px solid gray;
		border-radius : 0px 30px 30px 0px;
		vertical-align : top;
		margin-top : 2.5px;
	}
	#seat_pilot1,#seat_pilotbody1{
		display : inline-block;
	}
	#seat_pilot1{
		border-radius : 120px 0px 0px 120px;
		width : 152px;
		height : 244px;
		margin : 0;
		background-image : url(resources/img/headair.jpg);
	}
	#seat_pilotbody1{
		margin : 0;
		padding : 10px;
		border-top : 2px solid gray;
		border-bottom : 2px solid gray;
		border-right : 2px solid gray;
		border-radius : 0px 30px 30px 0px;
		vertical-align : top;
		margin-top : 2.5px;
		
	}
	#seat table{
		border-collapse: collapse;
		width: 1200px;
		margin-top : -20px;
	}
	.myseat{
		width: 20px; 
		height: 20px;
		border: 1px solid black;
		display: inline-block;
		cursor: pointer;
	}
	.alpaSeat{
		display: inline-block;
		margin : 0;
		height : 0;
	}
	.alpaSeat>p{
		margin : 0;
		text-align : center;
	}
	#seat_pilotbody>.seat_eng:first-of-type{
		vertical-align : bottom;
		margin-bottom : 4px;
	}
	#seat_pilotbody1>.seat_eng:first-of-type{
		vertical-align : bottom;
		margin-bottom : 4px;
	}
	.seat_eng{
		display : inline-block;
		border : 1px solid black;
		vertical-align : top;
		width: 20px; 
		height: 20px;
		text-align : center;
		line-height :20px;
		vertical-align : top;
	}
	.redseat{
		background-color: #DC143C;
		border: 1px solid #DC143C;
		cursor: auto;
	}
	
	#select01, #select02{
		display: inline-block;
	}
	#select01{
		vertical-align: top;
	}
	#select02{
		height : 700px;
		margin-left : 40px;
	}
	#select03{
		width: 200px;
		height : 500px;
		border: 3px solid black;
		border-radius : 5px;
		margin-left: -50px;
	}
	#select03>p{
		text-align : right;
		margin-right : 10px;
		font-weight : bold;
		font-size : 14px;
	}
	#select04{
		width: 180px;
		height : 150px;
		border: 3px solid black;
		border-radius : 5px;
		margin-top : 20px;
		margin-left: -50px;
	}
	#box1,#span_box1{display:inline-block;}
	#box2,#span_box2{display:inline-block;}
	#box3,#span_box3{display:inline-block;}
	#box1{width : 20px; height : 20px; border:1px solid black; background:#d3d3d3; margin-left:20px;margin-top:20px; vertical-align:bottom;}
	#box2{width : 20px; height : 20px; border:1px solid black; background:#4169e1;margin-left:20px; margin-top:20px; vertical-align:bottom;}
	#box3{width : 20px; height : 20px; border:1px solid black; background:#DC143C;margin-left:20px; margin-top:20px; vertical-align:bottom;}
	#span_box1{font-weight:bold;line-height:20px;height:20px;margin-left:20px; }
	#span_box2{font-weight:bold;line-height:20px;height:20px;margin-left:20px;}
	#span_box3{font-weight:bold;line-height:20px;height:20px;margin-left:20px;}
	#tex{
		font-size : 20px;
		color : #d60815;
	}
	#total{
		color  : #0180a3;
		font-size : 20px;
	}
	#ticketing_btn{
		text-align : right ; 
		border-radius : 5px;
    	border : 2px solid black;
    	font-weight : bold;
    	font-size : 17px;
    	background : #ece6cc ;
    	float : right;
    	margin-right : 10px;
    	margin-bottom : 20px;
	}
	.grayseat{
		background-color: lightgray;
		cursor: auto;
	}
	#dashline{
		border-style : dashed;
	}
	/* =========================================================== 블랭크 좌석 =========================================================== */
	.blank{
		width: 20px; 
		height: 20px;
		display: inline-block;
	}
	.numP:nth-of-type(3), .numP:nth-of-type(9), .numP:last-of-type {
		text-align: left;
	}
	#blank0{
		background-image : url(resources/img/tilot.jpg);
		border : 1px solid black;
		box-sizing : border-box;
	}
	#blank2{
		background-image : url(resources/img/tilot.jpg);
		border : 1px solid black;
		box-sizing : border-box;
	}
	#blank11,#blank14,#blank17{
		background-image : url(resources/img/pork.jpg);
		border : 1px solid black;
		box-sizing : border-box;
	}
	.numPP:nth-of-type(3), .numPP:nth-of-type(9), .numPP:last-of-type {
		text-align: left;
	}   
	}
</style>
</head>
<body>
<div id="seat">
	<h2>좌석선택</h2>
	<c:set var="x" value="A"/>
	<c:set var="y" value="1" />
	<c:set var="z" value="0" />
	<div id="select01">
	<div id="seat_title">
		<span>${startPoint} -> ${endPoint}</span> <span>${planeName} | ${goDay}(${day01}) | ${goTime}-${plusHour}:${plusMin} | ${hour}시간 ${min}분 | ${goway} | ${rank}</span>
	</div>
	<form action="ticketReserve" method="post" onsubmit="return reserve()">
	<!-- ===================================================== 편도/ 왕복 가는날 좌석 ==================================================  -->
	<div id="seat_contant">
		<div id="seat_pilot"></div><div id="seat_pilotbody">
		<c:set var="pp" value="0" />
	 		<c:forEach var="i" begin="1" end="${seatSize.site_x}">
				<c:if test="${i==1}"><div class="seat_eng">A</div></c:if>
				<c:if test="${i==2}"><div class="seat_eng">B</div></c:if>
				<c:if test="${i==3}"><div class="seat_eng">C</div></c:if>
				<c:if test="${i==4}"><div class="seat_eng">D</div></c:if>
				<c:if test="${i==5}"><div class="seat_eng">E</div></c:if>
				<c:if test="${i==6}"><div class="seat_eng">F</div></c:if>
				<c:forEach var="j" begin="1" end="${seatSize.site_y}">
					<div class="alpaSeat">
						<c:if test="${i==1}">
							<p class="numP">${y}</p>
						</c:if>
						<c:choose>
							<c:when test="${seatList[z].seat_state==1}">
								<c:if test="${rank=='일등석' && j<5 || rank=='비지니스석' && j<11 && j>4 || rank=='일반석' && j>10}">
									<div class="myseat redseat" id="seatBox${z}" onclick="failSeat()"></div>
									<c:set var="z" value="${z+1}"></c:set>
								</c:if>
								<c:if test="${rank=='일등석' && j>4 || rank=='비지니스석' && j>10 || rank=='비지니스석' && j<5 || 
								rank=='일반석' && j<11}">
									<div class="myseat grayseat" id="seatBox${z}" onclick="graygo()"></div>
									<c:set var="z" value="${z+1}"></c:set>
								</c:if>
								<c:if test="${j==4 || j==10 || j==seatSize.site_y}">
									<!-- 0~9까지 -->
									<div class="blank" id="blank${pp}"></div>
									<c:set var="pp" value="${pp+1}" />
								</c:if>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${rank=='일등석' && j>4}">
										<div class="myseat grayseat" id="seatBox${z}" onclick="graygo()"></div>
										<c:set var="z" value="${z+1}"></c:set>
										<c:if test="${j==4 || j==10 || j==seatSize.site_y}">
											<!-- 0~9까지 -->
											<div class="blank" id="blank${pp}"></div>
											<c:set var="pp" value="${pp+1}" />
										</c:if>
									</c:when>
									<c:when test="${rank=='비지니스석' && j>10 || rank=='비지니스석' && j<5}">
										<div class="myseat grayseat" id="seatBox${z}" onclick="graygo()"></div>
										<c:set var="z" value="${z+1}"></c:set>
										<c:if test="${j==4 || j==10 || j==seatSize.site_y}">
											<div class="blank" id="blank${pp}"></div>
											<c:set var="pp" value="${pp+1}" />
										</c:if>
									</c:when>
									<c:when test="${rank=='일반석' && j<11}">
										<div class="myseat grayseat" id="seatBox${z}" onclick="graygo()"></div>
										<c:set var="z" value="${z+1}"></c:set>
										<c:if test="${j==4 || j==10 || j==seatSize.site_y}">
											<div class="blank" id="blank${pp}"></div>
											<c:set var="pp" value="${pp+1}" />
										</c:if>
									</c:when>
									<c:otherwise>
										<div class="myseat" id="seatBox${z}" onclick="go(${z})"></div>
										<input type="hidden" id="seatName${z}" value="${seatList[z].seat_name}">
										<c:set var="z" value="${z+1}"></c:set>
										<c:if test="${j==4 || j==10 || j==seatSize.site_y}">
											<div class="blank" id="blank${pp}"></div>
											<c:set var="pp" value="${pp+1}" />
										</c:if>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
						<c:set var="y" value="${y+1}"></c:set>
					</div>
				</c:forEach>
				<br>
				<c:if test="${i==3}"><br><br></c:if>
			</c:forEach>
		 </div>
	</div>
	<!-- ===================================================== 왕복일때 나오는 오는날 좌석 ==================================================  -->
	
	<c:if test="${goway=='왕복'}">
	<div id="seat_title1">
		<span>${twostartPoint} -> ${twoendPoint}</span> <span>${twoplaneName} | ${twogoDay}(${day02}) | ${twogoTime}-${twoplusHour}:${twoplusMin}<c:if test="${twoplusMin=='0'}">0</c:if> | ${twohour}시간 ${twomin}분 | ${goway} | ${rank} </span>
	</div>
	<c:set var="y" value="1" />
	<c:set var="z" value="0" />
	<c:set var="pp" value="0" />
	<div id="seat_pilot1"></div><div id="seat_pilotbody1">
		<c:forEach var="i" begin="1" end="${twoseatSize.site_x}">
			<c:if test="${i==1}"><div class="seat_eng">A</div></c:if>
			<c:if test="${i==2}"><div class="seat_eng">B</div></c:if>
			<c:if test="${i==3}"><div class="seat_eng">C</div></c:if>
			<c:if test="${i==4}"><div class="seat_eng">D</div></c:if>
			<c:if test="${i==5}"><div class="seat_eng">E</div></c:if>
			<c:if test="${i==6}"><div class="seat_eng">F</div></c:if>
			<c:forEach var="j" begin="1" end="${twoseatSize.site_y}">
				<div class="alpaSeat">
					<c:if test="${i==1}">
						<p class="numPP">${y}</p>
					</c:if>
					<c:choose>
						<c:when test="${twoseatList[z].seat_state==2 || twoseatList[z].seat_state==1}">
							<c:if test="${rank=='일등석' && j<5 || rank=='비지니스석' && j<11 && j>4 || rank=='일반석' && j>10}">
								<div class="myseat redseat" id="twoseatBox${z}" onclick="failSeat()"></div>
								<c:set var="z" value="${z+1}"></c:set>
							</c:if>
							<c:if test="${rank=='일등석' && j>4 || rank=='비지니스석' && j>10 || rank=='비지니스석' && j<5 || rank=='일반석' && j<11}">
								<div class="myseat grayseat" id="twoseatBox${z}" onclick="graygo()"></div>
								<c:set var="z" value="${z+1}"></c:set>
							</c:if>
							<c:if test="${j==4 || j==10 || j==twoseatSize.site_y}">
								<!-- 0~9까지 -->
								<div class="blank" id="blank${pp}"></div>
								<c:set var="pp" value="${pp+1}" />
							</c:if>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${rank=='일등석' && j>4}">
									<div class="myseat grayseat" id="twoseatBox${z}" onclick="graygo()"></div>
									<c:set var="z" value="${z+1}"></c:set>
									<c:if test="${j==4 || j==10 || j==twoseatSize.site_y}">
										<!-- 0~17까지 -->
										<div class="blank" id="blank${pp}"></div>
										<c:set var="pp" value="${pp+1}" />
									</c:if>
								</c:when>
								<c:when test="${rank=='비지니스석' && j>10 || rank=='비지니스석' && j<5}">
									<div class="myseat grayseat" id="twoseatBox${z}" onclick="graygo()"></div>
									<c:set var="z" value="${z+1}"></c:set>
									<c:if test="${j==4 || j==10 || j==twoseatSize.site_y}">
										<!-- 0~17까지 -->
										<div class="blank" id="blank${pp}"></div>
										<c:set var="pp" value="${pp+1}" />
									</c:if>
								</c:when>
								<c:when test="${rank=='일반석' && j<11}">
									<div class="myseat grayseat" id="twoseatBox${z}" onclick="graygo()"></div>
									<c:set var="z" value="${z+1}"></c:set>
									<c:if test="${j==4 || j==10 || j==twoseatSize.site_y}">
										<!-- 0~17까지 -->
										<div class="blank" id="blank${pp}"></div>
										<c:set var="pp" value="${pp+1}" />
									</c:if>
								</c:when>
								<c:otherwise>
									<div class="myseat" id="twoseatBox${z}" onclick="twogo(${z})"></div>
									<input type="hidden" id="twoseatName${z}" value="${twoseatList[z].seat_name}">
									<c:set var="z" value="${z+1}"></c:set>
									<c:if test="${j==4 || j==10 || j==twoseatSize.site_y}">
										<!-- 0~17까지 -->
										<div class="blank" id="blank${pp}"></div>
										<c:set var="pp" value="${pp+1}" />
									</c:if>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
					<c:set var="y" value="${y+1}"></c:set>
				</div>
			</c:forEach>
			<br>
			<c:if test="${i==3}"><br><br></c:if>
		</c:forEach>
		</div>
	</c:if>
	</div>
	<div id="select02">
		<div id="select03">
			<p>
				<c:if test="${adult!=0}"><label>성인: ${adult}명</label></c:if>
				<c:if test="${child!=0}"><label>소아: ${child}명</label></c:if>
				<c:if test="${baby!=0}"><label>유아: ${baby}명</label></c:if>
			</p>
			<p>가는 날 좌석: <input type="text" id="goCon" name="goCon" readonly></p>
			<c:if test="${goway=='왕복'}">
				<p>오는 날 좌석: <input type="text" id="backCon" name="backCon" readonly></p>
			</c:if>
			<p>티켓 가격: <label id="price">${ticketPrice}</label>원</p>
			<p>부가세: <label id="tex">${tex}</label>원</p>
			<hr id="dashline">
				<p>총 마일리지: <fmt:formatNumber type="number" maxFractionDigits="3" value="${mile}" />P</p>
			      <p>사용 마일리지: <input type="text" id="useMileage" name="useMileage" value="0"></p>
			      <p id="ticket_p"><input type="button" value="마일리지 사용" onclick="Mileage()"></p>
			      <hr id="dashline">
				<p>최종 가격: <label id="total">${total}</label>원</p>
			<input type="submit" value="예매하기"  id="ticketing_btn">
		</div>
		<div id="select04">
			<div id="box1"></div><span id="span_box1">좌석선택불가</span>
			<div id="box2"></div><span id="span_box2">좌석선택가능</span>
			<div id="box3"></div><span id="span_box3">좌석예약마감</span>
		</div>
	</div>
	   <input type="hidden" name="mile" id="mile" value="${mile}">
	   <input type="hidden" name="goTimeCode" id="goTimeCode" value="${goTimeCode}">
	   <input type="hidden" name="startPoint" id="startPoint" value="${startPoint}">
	   <input type="hidden" name="endPoint" id="endPoint" value="${endPoint}">
	   <input type="hidden" name="goDay" id="goDay" value="${goDay}">
	   <input type="hidden" name="goTime" id="goTime" value="${goTime}">
	   <input type="hidden" name="plusHour" id="plusHour" value="${plusHour}">
	   <input type="hidden" name="plusMin" id="plusMin" value="${plusMin}">
	   <input type="hidden" name="planeName" id="planeName" value="${planeName}">
	   <input type="hidden" name="hour" id="hour" value="${hour}">
	   <input type="hidden" name="min" id="min" value="${min}">
	   <input type="hidden" name="rank" id="rank" value="${rank}">
	   <input type="hidden" name="goway" id="goway" value="${goway}">
	   <input type="hidden" name="day01" id="day01" value="${day01}">
	   <input type="hidden" name="day02" id="day02" value="${day02}">
	   <input type="hidden" name="endTimeCode" id="endTimeCode" value="${endTimeCode}">
	   <input type="hidden" name="twostartPoint" id="twostartPoint" value="${twostartPoint}">
	   <input type="hidden" name="twoendPoint" id="twoendPoint" value="${twoendPoint}">
	   <input type="hidden" name="twogoDay" id="twogoDay" value="${twogoDay}">
	   <input type="hidden" name="twogoTime" id="twogoTime" value="${twogoTime}">
	   <input type="hidden" name="twoplusHour" id="twoplusHour" value="${twoplusHour}">
	   <input type="hidden" name="twoplusMin" id="twoplusMin" value="${twoplusMin}">
	   <input type="hidden" name="twoplaneName" id="twoplaneName" value="${twoplaneName}">
	   <input type="hidden" name="twohour" id="twohour" value="${twohour}">
	   <input type="hidden" name="twomin" id="twomin" value="${twomin}">
	   <input type="hidden" name="adult" value="${adult}">
	   <input type="hidden" name="child" value="${child}">
	   <input type="hidden" name="baby" value="${baby}">
	   <input type="hidden" name="ticketPrice" value="${ticketPrice}">
	   <input type="hidden" name="tex" value="${tex}">
	   <input type="hidden" id="mineTotal" name="total" value="${total}">
	   <input type="hidden" id="realTotal" name="realTotal" value="${total}">
	</form>
</div>
<script>

	var total = '${total}';
	var price = total.split(",");
	var price2 = ""; // 총 가격
	for(var i = 0; i<price.length; i++){
		price2 = price2 + price[i];
	}
	
	var useMileage = document.getElementById("useMileage"); // 사용할 마일리지
	var totalprice = document.getElementById("total");
	var mineTotal = document.getElementById("mineTotal");
	var mile = parseInt('${mile}'); // 총 마일리지
	var regex= /[^0-9]/g;
	console.log(mile);
	var mileChk = 0;
	
	function Mileage(){
		if(useMileage.value=="" || useMileage.value<0 || regex.test(useMileage.value)){
			alert("잘못된 형식입니다.");
			useMileage.value = 0;
		}else if(mile<useMileage.value){
			alert("마일리지가 부족합니다.");
			useMileage.value = 0;
		}else if(useMileage.value>parseInt(price2)){
			alert("가격을 초과한 금액을 입력하였습니다.");
			useMileage.value = 0;
		}else{
			var minePrice = parseInt(price2) - parseInt(useMileage.value);
			totalprice.innerHTML = minePrice.toLocaleString();
			mineTotal.value = minePrice.toLocaleString();
			mileChk = 1;
		}
	}

	// 블라인드 처리된 좌석 클릭시
	function graygo(){
		alert("선택할 수 없는 등급의 좌석입니다.");
	}

	// 이미 예매 완료된 좌석
	function failSeat(){
		alert("이미 예매완료된 좌석입니다.");
	} 
	
	var mySeat = new Array(parseInt('${adult}') + parseInt('${child}') + parseInt('${baby}'));
	var i = 0;
	var max = parseInt('${adult}') + parseInt('${child}') + parseInt('${baby}');
	var twomySeat = new Array(parseInt('${adult}') + parseInt('${child}') + parseInt('${baby}'));
	var twoi = 0;
	var twomax = parseInt('${adult}') + parseInt('${child}') + parseInt('${baby}');
	var goCon = document.getElementById("goCon"); 
	var backCon = document.getElementById("backCon"); 
	
	// 가는날 예매하려는 좌석
	function go(num){
		var seatBox = document.getElementById("seatBox"+num);
		var seatName = document.getElementById("seatName"+num);
		var chk = 0;
		var posi = -1;
		
		for(var z=0; z<i; z++){
			if(seatName.value==mySeat[z]){
				chk = -1;
				posi = z;
			}
		}
		
		if(chk!=0){
			seatBox.style.backgroundColor = 'white';
			mySeat.splice(posi,1);
			posi = -1;
			i--;
		}else{
			if(i>max-1){
				alert("좌석을 모두 선택했습니다.");
			}else{
				mySeat[i] = seatName.value;
				seatBox.style.backgroundColor = '#4169E1';
				i++;
			}
		}
		goCon.value = "";
		for(var j=0; j<i; j++){
			if(j==i-1){
				goCon.value = goCon.value + mySeat[j];
			}else{
				goCon.value = goCon.value + mySeat[j] + ", ";
			}
		}
	}
	
	// 오는날 예매하려는 좌석
	function twogo(num){
		var seatBox = document.getElementById("twoseatBox"+num);
		var seatName = document.getElementById("twoseatName"+num);
		var chk = 0;
		var posi = -1;
		
		for(var z=0; z<twoi; z++){
			if(seatName.value==twomySeat[z]){
				chk = -1;
				posi = z;
			}
		}
		
		if(chk!=0){
			seatBox.style.backgroundColor = 'white';
			twomySeat.splice(posi,1);
			posi = -1;
			twoi--;
		}else{
			if(twoi>twomax-1){
				alert("좌석을 모두 선택했습니다.");
			}else{
				twomySeat[twoi] = seatName.value;
				seatBox.style.backgroundColor = '#4169E1';
				twoi++;
			}
		}
		backCon.value = "";
		for(var j=0; j<twoi; j++){
			if(j==twoi-1){
				backCon.value = backCon.value + twomySeat[j];
			}else{
				backCon.value = backCon.value + twomySeat[j] + ", ";
			}
		}
	}
	
	// 예외처리
	function reserve(){
		if(i<max){
			alert("좌석을 모두 선택해주세요.");
			return false;
		}else if(useMileage.value=="" || useMileage.value<0 || regex.test(useMileage.value)){
			alert("잘못된 형식입니다.");
			useMileage.value = 0;
			return false;
		}else if(mile<useMileage.value){
			alert("마일리지가 부족합니다.");
			useMileage.value = 0;
			return false;
		}else if(useMileage.value>parseInt(price2)){
			alert("가격을 초과한 금액을 입력하였습니다.");
			useMileage.value = 0;
			return false;
		}else if(useMileage.value>0 && mileChk!=1){
			alert("마일리지 사용 버튼을 클릭해주세요.");
			useMileage.value = 0;
			return false;
		}else if('${goway}'=="왕복"){
			if(twoi<twomax){
				alert("좌석을 모두 선택해주세요.");
				return false;
			}
		}
		return true;
	}
	
	
	
	
</script>
</body>
</html>























