<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/png" href="resources/img/PIcon.png">
<title>airLight</title>
<style>
      /*   #menu-box{ height: auto; margin: 0;padding: 0; border: 1px solid black; border-radius: 5px;}
        #myMenu{background-color: #434343;height: 50px;  }
        #myMenu>span{color: white;width: 33.33%; ;text-align: center;display:block;height: 45px; line-height:  40px; margin-top: 5px;  float: left; }     
       .MenuText{ width: 70%; height: 100%; margin-left: 15%; margin-right: 15%;border-top-right-radius: 5px;border-top-left-radius: 5px;cursor:pointer }
   */
   		#menu-box{ height: auto;padding: 0; border: 1px solid black; border-radius: 5px; border-top:none;width: 110%; maring-right : 30px; margin-left : -100px;}
        #myMenu{background-color: #05224a;height: 50px;margin-top : 20px;}
        #myMenu>span{color: white;width: 33.33%; ;text-align: center;display:block;height: 45px; line-height:  40px; margin-top: 5px;  float: left; }
        .MenuText{ width: 70%; height: 100%; margin-left: 15%; margin-right: 15%;border-top-right-radius: 5px;border-top-left-radius: 5px;cursor:pointer }
         .Content{width:110%;height:auto; margin-top: 50px; display: none;  margin-bottom : 50px;margin-left :-100px;}
     table.type09 {
    	width : 100%;
		border-collapse: collapse;
		text-align: left;
		line-height: 1.5;
		background : white;
		color : white;
	}
	#thead_menu{
		background : #05224a;
	}
	table.type09 thead th {
				padding: 10px;
				font-weight: bold;
				vertical-align: top;
				height :50px;
				color: white;
				backgroud-color :#05224a;
				border-bottom: 3px solid #dfdfdf;
				margin-right : 0;
	}
	table.type09 tbody th {

padding: 10px;
font-weight: bold;
vertical-align: top;
border-bottom: 1px solid #ccc;
background: #05224a;
}
table.type09 td {
padding: 10px;
vertical-align: top;
border-bottom: 1px solid #ccc;
line-height: 50px;
color : #05224a;
font-weight : bold;
}

.type09TotalBox {
	text-align: right;
	border: 0px;
	font-weight : bold;
	font-size : 20px;
	line-height : 20px;
}
.type09TotalBox>strong{
	color : #05224a;
	
}

.mileage_table th{
	background : #05224a;
	line-height : 30px;
}

a{text-decoration: none; color: black;}
.type001{ text-align: center; width: 50px; }
.type003{text-align: center;width: 100px; }
.type002{text-align: right; width: 80px; }
.type004{ text-align: center; }
.type006{ text-align: right; }
.type005{ text-align: center; width: 150px}
.type007{ align-content: center; text-align: center;}
     
#footer_btn{
	width : 100%;
	height : 50px;
	background : white;
}
#footer_btn input{
		border : none;
		background : white;
		width : 60px;
		height : 40px;
		font-size : 18px;
		cursor : pointer;
}
#footer_btn a{
		width : 60px;
		height : 40px;
		font-size : 20px;
		margin-top : 10px;
}
.page{font-weight : bold;font-size : 18px;vertical-align:bottom;cursor:pointer;margin-right : 10px;margin-left : 10px;}  
    .BtnType01{
	height: 30px;
    width: 90px;
    background-color: #f46565;
    border: 1px solid #f46565;
    border-radius: 5px;
    color: white;
    margin-top : 10px;
    font-weight: bold;}
	.BtnType02{
	height: 30px;
    width: 80px;
    background-color: #186686;
    border: 1px solid #186686;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    margin-top : 10px;
    }
    .BtnType03{
	height: 30px;
    width: 90px;
    background-color: #05224a;
    border: 1px solid #05224a;
    margin-top : 10px;
    border-radius: 5px;
    color: white;
    font-weight: bold;}
    #admin_search{
    	width : 99.94%;
    	background : #05224a;
    
    }
    #admin_search>select{
    	height : auto;
    	vertical-align : top;
    	height : 30px;
    	margin-top : 10px;
    	margin-bottom : 5px;
    }
    #admin_search>input{
    	vertical-align : top;
    	height :30px;
    	margin-top : 10px;
    	margin-bottom : 5px;
    }
     #admin_search>input:first-child{
     	margin-left : 20px;
     }
     #admin_serchbtn{
     	width : 100px;
     	border : none;
     	vertical-align : bottom;
     	border-radius : 5px;
     	color : white;
     	font-weight : bold;
     	height :30px;
     	background : #329dc9;
     }
     .adminform{
     	margin-bottom : 0;
     	color : white;
     	font-weight : bold;
     	line-height : 50px;
     }
     .search_2{
     	color : white;
     	font-weight : bold;
     	line-height : 50px;
     }
     .admin_statebtn1,.admin_statebtn2,.admin_statebtn3,.admin_statebtn4,.admin_statebtn5,.admin_statebtn6{
     	margin-top : 5px;
     	border : 1px solid black;
     	height :40px;
     	border-radius : 5px;
     	width : 90px;
     }

     .admin_statebtn2{	/* 결제완료 */
     	background : #05224A;
     	color : white;
     	border : 1px solid #05224A;
     	font-weight : bold;
     }
     .admin_statebtn3{   /* 탑승완료 */
     	background : #62e35d;
     	color : white;
     	border : 1px solid #62e35d;
     	font-weight : bold;
     }
     .admin_statebtn4{	/*환불신청중 */
     	background :   #329dc9;
     	color : white;
     	border : 1px solid   #329dc9;
     	font-weight : bold;
     }
     .admin_statebtn5{	/*환불완료 */
     	background :   #ed698a;
     	color : white;
     	border : 1px solid   #ed698a;
     	font-weight : bold;
     }
       .admin_statebtn6{	/*자동취소 */
     	background : #F46565;
     	color : white;
     	border : 1px solid #F46565;
     	font-weight : bold;
     }
     #noneTicket{
		text-align: center;
	}
			.nosearch{
				width : 100%;
				height : 400px;
				background : white;
				text-align: center;
				font-weight : bold;
			}
     @media(max-width:1280px){  /* =========================================1280px */
			#myMenu{
				width : 110%;
				font-size : 10px;
			}
			#admin_search{
			    width: 110%;
   				font-size: 10px;
			}
			#admin_tab{
				width : 110%;
			}
			.type004{
				font-size : 10px;
			}
			.type005{
				font-size : 10px;
			}
			.type001{
				font-size : 10px;
			}
			#admin_search>select{
		    	height : auto;
		    	vertical-align : top;
		    	height : 23px;
		    	margin-top : 14px;
		    	margin-bottom : 5px;
		    }
    		#admin_search>input{
		    	vertical-align : top;
		    	height :23px;
		    	margin-top : 14px;
		    	margin-bottom : 5px;
		    }
		     .admin_statebtn1,.admin_statebtn2,.admin_statebtn3,.admin_statebtn4,.admin_statebtn5,.admin_statebtn6{
		     	margin-top : 12px;
		     	border : 1px solid black;
		     	height :30px;
		     	border-radius : 5px;
		     	width : 90px;
		     }
		     #footer_btn{
				width : 110%;
				height : 50px;
				background : white;
			}
			  table.type09 {
		    	width : 110%;
				border-collapse: collapse;
				text-align: left;
				line-height: 1.5;
				background : white;
				color : white;
			}
			.nosearch{
				width : 110%;
				height : 400px;
				background : white;
				text-align: center;
				font-weight : bold;
			}
	}
    </style>
</head>
<body>

    <div id="menu-box">
        <div id="myMenu">
            <!--마이페이지 메뉴 선택-->
            <span class="MenuInfo" > <div class="MenuText" onclick="location.href='AdminPage?num=0'">예매상태</div> </span>
            <span class="MenuInfo"> <div class="MenuText" onclick="location.href='AdminPage?num=1'">회원정보</div> </span>
            <span class="MenuInfo"> <div class="MenuText" onclick="location.href='AdminPage?num=2'">질문 게시판</div> </span>           
        </div>
    </div>
    <!--해당 메뉴에 컨텐츠가 나오는 div-->
   <!-- 소리 시작 ===================================================================-->
    <div class="Content">
    <form action="AdminPage" name="admin" method="post">
    <input type="hidden" id="adminNum" name="adminNum" value="0">
    <input type="hidden" name="num" value="0">
    <input type="hidden" id="chk" name="chk" value="0">
    <input type="hidden" id="code" name="code" value="">
    <input type="hidden" id="seat" name="seat" value="">
    <input type="hidden" id="way" name="way" value="">
    <input type="hidden" id="member" name="member" value="">
    <input type="hidden" id="price" name="price" value="">
    <input type="hidden" id="end" name="end" value="">
    <input type="hidden" id="time" name="time" value="">
    <div id="admin_search" class="search_2">
    <c:set var="i" value="0"/>
		<!-- 검색 -->
		<!-- 예매날짜 -->
		&nbsp;&nbsp;예매날짜 : <c:if test="${startDay!=''}"><input type="date" id="adminStartDay" name="startDay" min="2020-11-11" max="${todays}" value="${startDay}" ></c:if>
		<c:if test="${startDay==''}"><input type="date" id="adminStartDay" name="startDay" min="2020-11-11" max="${todays}"></c:if>
		<!-- 시작 -->
		<c:if test="${endDay!=''}"><input type="date" id="adminEndDay" name="endDay" min="2020-11-11" max="${todays}" value="${endDay}"></c:if>
		<c:if test="${endDay==''}"><input type="date" id="adminEndDay" name="endDay" min="2020-11-11" max="${todays}"></c:if>
		<!-- 끝 -->
		<!-- 0:미입금, 1:결제완료, 2:탑승완료, 3:환불신청중, 4:환불완료, 5:미입금처리(자동취소), 6: 결제완료(환불 불가능상태)) -->
		&nbsp;&nbsp;예매상태 :&nbsp;&nbsp; <c:if test="${state==0}">
			<select id="adminState" name="state" >
				<option value="0" selected>미입금</option>
				<option value="1">결제완료(환불가능)</option>
				<option value="6">결제완료(환불불가능)</option>
				<option value="2">탑승완료</option>
				<option value="3">환불신청중</option>
				<option value="4">환불완료</option>
				<option value="5">자동취소</option>
				<option value="7">전체</option>
			</select>
		</c:if>
		<c:if test="${state==1}">
			<select id="adminState" name="state" >
				<option value="0">미입금</option>
				<option value="1" selected>결제완료(환불가능)</option>
				<option value="6">결제완료(환불불가능)</option>
				<option value="2">탑승완료</option>
				<option value="3">환불신청중</option>
				<option value="4">환불완료</option>
				<option value="5">자동취소</option>
				<option value="7">전체</option>
			</select>
		</c:if>
		<c:if test="${state==2}">
			<select id="adminState" name="state" >
				<option value="0">미입금</option>
				<option value="1">결제완료(환불가능)</option>
				<option value="6">결제완료(환불불가능)</option>
				<option value="2" selected>탑승완료</option>
				<option value="3">환불신청중</option>
				<option value="4">환불완료</option>
				<option value="5">자동취소</option>
				<option value="7">전체</option>
			</select>
		</c:if>
		<c:if test="${state==3}">
			<select id="adminState" name="state" >
				<option value="0">미입금</option>
				<option value="1">결제완료(환불가능)</option>
				<option value="6">결제완료(환불불가능)</option>
				<option value="2">탑승완료</option>
				<option value="3" selected>환불신청중</option>
				<option value="4">환불완료</option>
				<option value="5">자동취소</option>
				<option value="7">전체</option>
			</select>
		</c:if>
		<c:if test="${state==4}">
			<select id="adminState" name="state" >
				<option value="0">미입금</option>
				<option value="1">결제완료(환불가능)</option>
				<option value="6">결제완료(환불불가능)</option>
				<option value="2">탑승완료</option>
				<option value="3">환불신청중</option>
				<option value="4" selected>환불완료</option>
				<option value="5">자동취소</option>
				<option value="7">전체</option>
			</select>
		</c:if>
		<c:if test="${state==5}">
			<select id="adminState" name="state" >
				<option value="0">미입금</option>
				<option value="1">결제완료(환불가능)</option>
				<option value="6">결제완료(환불불가능)</option>
				<option value="2">탑승완료</option>
				<option value="3">환불신청중</option>
				<option value="4">환불완료</option>
				<option value="5" selected>자동취소</option>
				<option value="7">전체</option>
			</select>
		</c:if>
		<c:if test="${state==6}">
			<select id="adminState" name="state" >
				<option value="0">미입금</option>
				<option value="1">결제완료(환불가능)</option>
				<option value="6" selected>결제완료(환불불가능)</option>
				<option value="2">탑승완료</option>
				<option value="3">환불신청중</option>
				<option value="4">환불완료</option>
				<option value="5">자동취소</option>
				<option value="7">전체</option>
			</select>
		</c:if>
		<c:if test="${state==7}">
			<select id="adminState" name="state" >
				<option value="0">미입금</option>
				<option value="1">결제완료(환불가능)</option>
				<option value="6">결제완료(환불불가능)</option>
				<option value="2">탑승완료</option>
				<option value="3">환불신청중</option>
				<option value="4">환불완료</option>
				<option value="5">자동취소</option>
				<option value="7" selected>전체</option>
			</select>
		</c:if>
		&nbsp;&nbsp;맴버코드 :&nbsp;&nbsp; <c:if test="${memberIn!='11111111111111'}"><input type="text" id="adminMember" name="memberCodeIn" value="${memberIn}" placeholder="멤버코드 입력"></c:if>
		<c:if test="${memberIn=='11111111111111'}"><input type="text" id="adminMember" name="memberCodeIn" placeholder="멤버코드 입력"></c:if>
		<input type="submit" value="검색" onclick="adminclick()" id="admin_serchbtn">
		</div>
		<table class="type09" id="admin_tab">
			<tr>
				<th class="type001">번호</th>
				<th class="type004">회원번호</th>
				<th class="type004">예매날짜</th>
				<th class="type004">왕복여부</th>
				<th  class="type004">나라/출발지</th>
        		<th  class="type004">나라/도착지</th>
        		<th class="type004">출발일</th>
        		<th class="type004">출발시간:도착시간</th>
        		<th class="type004">소요시간</th>
        		<th class="type004">티켓 매수</th>
        		<th class="type004">총 금액</th>
        		<th class="type004">예매좌석</th>
        		<th class="type004">예매상태</th>
			</tr>
			<c:set var="a" value="0" />
			<!-- ==================================================================================== -->
			<c:set var="number" value="${number }" />
			<c:forEach var="ticketList" items="${ticketList}">
        		<tr>
        			<td class="type004" >${number }</td>
        			<td class="type004">${ticketList.member_code}</td>
        			<td class="type004">${ticketList.ticket_date}</td>
        			<c:if test="${ticketList.wayType==1}">
        				<td class="type004">편도</td>
        			</c:if>
        			<c:if test="${ticketList.wayType!=1}">
        				<td class="type004">왕복</td>
        			</c:if>
	        		<td  class="type004">${first[i]}/${ticketList.start_point}</td>
	        		<td  class="type004">${end[i]}/${ticketList.end_point}</td>
	        		<td class="type004">${ticketList.go_day}</td>
	        		<td class="type004">${ticketList.go_time}:${ticketList.endTime}</td>
	        		<td class="type004">${ticketList.wayTime}</td>
	        		<td class="type004">${ticketList.adult+ticketList.child+ticketList.baby}장</td>
	        		<td class="type004"><fmt:formatNumber type="number" maxFractionDigits="3" value="${ticketList.price}" />원</td>
	        		<td  class="type004">${ticketList.seat}</td>
	        		<td class="type004">
	        			<input type="hidden" id="mycode${i}" value="${ticketList.ticket_code}">
    					<input type="hidden" id="myseat${i}" value="${ticketList.seat}">
    					<input type="hidden" id="myway${i}" value="${ticketList.wayType}">
    					<input type="hidden" id="mymember${i}" value="${ticketList.member_code}">
    					<input type="hidden" id="myprice${i}" value="${ticketList.price}">
    					<input type="hidden" id="myend${i}" value="${ticketList.end_point}">
    					<input type="hidden" id="mytime${i}" value="${ticketList.time_code}">
	        			<c:if test="${ticketList.ticket_state==0}">
	        				<button class="admin_statebtn1">미입금</button>
	        			</c:if>
	        			<c:if test="${ticketList.ticket_state==1 || ticketList.ticket_state==6}">
	        				<button class="admin_statebtn2">결제완료</button>
	        			</c:if>
	        			<c:if test="${ticketList.ticket_state==2}">
	        				<button class="admin_statebtn3">탑승완료</button>
	        			</c:if>
	        			<c:if test="${ticketList.ticket_state==3}">
	        				<button type="submit" id="btn${i}" onclick="refund(${i})" formaction="AdminPage" class="admin_statebtn4">환불신청중</button>
	        			</c:if>
	        			<c:if test="${ticketList.ticket_state==4}">
	        				<button class="admin_statebtn5">환불 완료</button>
	        			</c:if>
	        			<c:if test="${ticketList.ticket_state==5}">
	        				<button class="admin_statebtn6">자동취소</button>
	        			</c:if>
	        		</td>
	        	</tr>
	        	<c:set var="i" value="${i+1}"/>
	        	<c:set var="a" value="${a+1}" />
	        	<c:set var="number" value="${number-1}" />
        	</c:forEach>
		</table>
		<c:if test="${a==0}">
        		<div class="nosearch">검색 결과가 존재 하지 않습니다.</div>
        </c:if>
		<input type="hidden" id="pageNum" name="pageNum" value="1">
		<input type="hidden" id="testNum" value="${adminNum }">
		 <br>
		 <!-- [이전] 링크를 걸지 파악 -->
		<div id="footer_btn">
		 <center>
				<c:if test="${startPage > 3 }">
					<input type="submit" value="[이전]"onclick="page(${startPage-3 })">
				</c:if>
		
				<!-- 슷자 페이징 [1][2][3]-->
				<c:forEach var="j" begin="${startPage }" end="${endPage }">
						<input type="submit" value="${j}" onclick="page(${j})">
				</c:forEach>
		
				<!-- [다음] 링크를 걸지 파악 -->
				<c:if test="${endPage < pageCount }">
					<input type="submit" value="[다음]" onclick="page(${startPage+3 })">	
				</c:if>
		</center>
		</div>
	</form> 
	
	</div>
	 <!-- 소리 끝 ========================================================================-->
    <!-- 예매박스 -->
    <div class="Content">
		<form action="AdminPage?num=1" method="post" name="memberForm" class="adminform">
			<!-- 검섹 -->
			<div  id="admin_search">
				&nbsp;&nbsp;시작일: <input type="date" name="startDay" min="2020-11-11" value="${endDay }">
				<!-- 시작 -->
				<input type="date" name="endDay" min="2020-11-11" value="${startDay }">
				<!-- 끝 -->
				<c:if test="${state==0}">
				<select name="membar_state">
					<option value="0" selected>정상회원</option>
					<option value="1">탈퇴회원</option>
					<option value="3" >회원전체</option>
				</select>
				</c:if>
				<c:if test="${state==1}">
				<select name="membar_state">
					<option value="0">정상회원</option>
					<option value="1" selected>탈퇴회원</option>
					<option value="3" >회원전체</option>
				</select>
				</c:if>
				<c:if test="${state==3}">
				<select name="membar_state">
					<option value="0">정상회원</option>
					<option value="1">탈퇴회원</option>
					<option value="3" selected>회원전체</option>
				</select>
				</c:if>
				 &nbsp;&nbsp;회원 아이디&nbsp;&nbsp;<input type="text" name="id">
				<input type="button" value="검색" onclick="MemberSelect()" id="admin_serchbtn">
			</div>
			
		</form>

<table class="type09">
			<thead id="thead_menu">
			<tr >
				<th class="type001" >번호</th>
				<th class="type004">이름</th>
				<th class="type004">회원코드</th>
				<th class="type004">아이디</th>
				<th class="type004">휴대전화</th>
				<th class="type004">유선전호</th>
				<th class="type004">가입일</th>
				<th class="type003">회원상태</th>
			</tr>
			</thead>
			<c:set var="number" value="${number }" />
			<tbody>
			<c:if test="${count!=0 }">
			<c:forEach var="list" items="${list }">
				<tr >
					<td class="type001">${number }</td>
					<td class="type004">${list.first_name }${list.last_name }</td>
					<td class="type004" >
					${list.member_code }
					</td>
					<td class="type004">
					${list.id }
					</td>
					<td class="type004">
					${list.phone }
					</td>
					<td class="type004">
					${list.tel }
					</td>
					<td class="type004">
					${list.joindate }
					</td>
					<c:if test="${list.membar_state == 0 }">
						<td class="type003"><button class="BtnType03">정상 회원</button></td>
					</c:if>
					<c:if test="${list.membar_state == 1 }">
						<td class="type003"><button class="BtnType01" onclick="stateUpdate(${list.member_code})" >탈퇴 회원</button></td>
					</c:if>
				</tr>
				<c:set var="number" value="${number-1}" />
			</c:forEach>
			</c:if>
		</tbody>
		</table>
		<c:if test="${count==0}">
        		<div class="nosearch">검색 결과가 존재 하지 않습니다.</div>
        	</c:if>
		<br>
		<!-- [이전] 링크를 걸지 파악 -->
		<div id="footer_btn">
		<center>
		<c:if test="${count!=0 }">
		<c:if test="${startPage > 3 }">
			<a href="AdminPage?num=1&pageNum=${startPage-3 }"><label class="page">[이전]</label></a>
		</c:if>

		<!-- 슷자 페이징 [1][2][3]-->
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<a class="pageNumBox2" href="AdminPage?num=1&pageNum=${i} ">${i }</a>
		</c:forEach>

		<!-- [다음] 링크를 걸지 파악 -->
		<c:if test="${endPage < pageCount }">
			<a href="AdminPage?num=1&pageNum=${startPage+3 }"><label class="page">[다음]</label></a>
		</c:if>
		</c:if>
		</center>
		</div>
	</div>
	
    <div class="Content">
		<form action="AdminPage?num=2" method="post" name="QnAForm" class="adminform">
			<!-- 검섹 -->
			<div id="admin_search">
				&nbsp;&nbsp;시작일: <input type="date" name="startDay" min="2020-11-11" value="${startDay }" >
				<!-- 시작 -->
				<input type="date" name="endDay" min="2020-11-11" value="${endDay }" >
				<!-- 끝 -->
				<c:if test="${state==2}">
					<select name="state"">
						<option value="0">미답변</option>
						<option value="1">답변완료</option>
						<option value="2" selected>전체</option>
					</select>
				</c:if>
				<c:if test="${state==0}">
					<select name="state"">
						<option value="0" selected>미답변</option>
						<option value="1">답변완료</option>
						<option value="2" >전체</option>
					</select>
				</c:if>
				<c:if test="${state==1}">
					<select name="state"">
						<option value="0">미답변</option>
						<option value="1" selected>답변완료</option>
						<option value="2" >전체</option>
					</select>
				</c:if>
				<input type="button" value="검색"  onclick="boardSelect()" id="admin_serchbtn">
			</div>
			
		</form>
		<table class="type09 ">
			<thead id="thead_menu">
			<tr >
				<th class="type001" >번호</th>
				<th class="type004">작성자</th>
				<th class="type004">아이디</th>
				<th class="type004">제목</th>
				<th class="type005">작성일</th>
				<th class="type005">답변상태</th>
			</tr>
			</thead>
			<c:set var="number1" value="${number1}" />
			<tbody>
			<c:if test="${count!=0 }">
			<c:forEach var="alist" items="${alist }">
				<tr >
					<td class="type001">${number1 }</td>
					<td class="type004">${alist.first_name }${alist.last_name }</td>
					<td class="type004" >
					${alist.id }
					</td>
					<td class="type004">
					<a href="ReWriteForm?no=${alist.board_code}">${alist.title }</a>
					</td>
					<td class="type005">
					${alist.write_date }
					</td>
					<c:if test="${alist.re_state == 0 }">
						<td class="type005"><button class="BtnType01">미답변</button></td>
					</c:if>
					<c:if test="${alist.re_state == 1 }">
						<td class="type005"><button class="BtnType03">답변완료</button> </td>
					</c:if>

				</tr>
				<c:set var="number1" value="${number1 - 1}" />
			</c:forEach>
			</c:if>
		</tbody>
		</table>
		<c:if test="${count==0}">
        		<div class="nosearch">검색 결과가 존재 하지 않습니다.</div>
        	</c:if>
		<br>
		<div id="footer_btn">
		<c:if test="${count!=0 }">
		<center>
			<!-- [이전] 링크를 걸지 파악 -->
			<c:if test="${startPage > 3 }">
				<a href="AdminPage?num=2&pageNum=${startPage-3 }"><label class="page">[이전]</label></a>
			</c:if>

			<!-- 슷자 페이징 [1][2][3]-->
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<a class="pageNumBox3" href="AdminPage?num=2&pageNum=${i } ">${i }</a>
			</c:forEach>

			<!-- [다음] 링크를 걸지 파악 -->
			<c:if test="${endPage < pageCount }">
				<a href="AdminPage?num=2&pageNum=${startPage+3 }"><label class="page1">[다음]</label></a>
			</c:if>
		
		</center>
		</c:if>
</div>

	</div>
 
    

   <script>
       
   	// ==================================== 소리 ===============================================
   
   	// 환불 상태
    function refund(myNum){
    	document.getElementById("code").value = document.getElementById("mycode"+myNum).value;
    	document.getElementById("seat").value = document.getElementById("myseat"+myNum).value;
    	document.getElementById("chk").value = 1; 
    	document.getElementById("way").value = document.getElementById("myway"+myNum).value;
    	document.getElementById("member").value = document.getElementById("mymember"+myNum).value;
    	document.getElementById("price").value = document.getElementById("myprice"+myNum).value;
    	document.getElementById("end").value = document.getElementById("myend"+myNum).value;
    	document.getElementById("time").value = document.getElementById("mytime"+myNum).value;
    }
   	// 페이징
    function page(pageNum){
    	document.getElementById("pageNum").value =pageNum;
    	document.getElementById("adminNum").value =document.getElementById("testNum").value ;
    }
 
   	// 관리자 검색
   	function adminclick(){
   		var adminStartDay = document.getElementById("adminStartDay");
   		var adminEndDay = document.getElementById("adminEndDay");
   		if(adminStartDay.value=="" || adminEndDay.value==""){
   			alert("[필수선택]회원의 예매일자 범위를 선택해주세요.");
   			return;
   		}else{
   			document.getElementById("adminNum").value = 1;
   		}
   	}
	// 관리자 검색 페이징

   	
 	// ==================================== 소리 ===============================================
   		
 	
 		
 		   // 환불 상태
    function stateUpdate(num){
    	console.log(num);
 	   location.href = 'updateMember?code=' + num ;
    }
 	//==========================
 				var count =${count}
				var num = ${num};
				var pageTextNum =${pageTextNum };
				var MenuInfo = document.querySelectorAll(".MenuInfo");
				var tab_box = document.querySelectorAll(".tab_box");
				var Content = document.querySelectorAll(".Content");
				var MenuText = document.querySelectorAll(".MenuText");
				var pageNumBox3 =document.querySelectorAll(".pageNumBox3");
				var pageNumBox2 =document.querySelectorAll(".pageNumBox2");
				// 자바스크립트를 java단 변수로 제어
				if (num == 0) {
					console.log("0번 if문 실행");
					MenuText[0].style.background = " white";
					MenuInfo[0].style.color = "black";
					MenuText[1].style.background = " #05224a";
					MenuText[2].style.background = " #05224a";
					MenuInfo[1].style.color = "white";
					MenuInfo[2].style.color = "white";
					Content[0].style.display = "block";
					Content[1].style.display = "none";
					Content[2].style.display = "none";

				} else if (num == 1) {
					console.log("1번 if문 실행");
					MenuText[1].style.background = "white";
					MenuInfo[1].style.color = "black";
					MenuText[0].style.background = " #05224a";
					MenuText[2].style.background = " #05224a";
					MenuInfo[0].style.color = "white"
					MenuInfo[2].style.color = "white"
					Content[0].style.display = "none";
					Content[1].style.display = "block";
					Content[2].style.display = "none";
					if (count!=0) {
						pageNumBox2[pageTextNum].style.color= "red";
					}
					

				} else if (num == 2) {
					console.log("2번 if문 실행");
					MenuText[2].style.background = "white";
					MenuInfo[2].style.color = "black";
					MenuText[1].style.background = " #05224a";
					MenuText[0].style.background = " #05224a";
					MenuInfo[1].style.color = "white"
					MenuInfo[0].style.color = "white"
					Content[0].style.display = "none";
					Content[1].style.display = "none";
					Content[2].style.display = "block";
					if (count!=0) {
						pageNumBox3[pageTextNum].style.color= "red";
					}
					
				}
				// 질문 게시판 예외 처리
				function boardSelect(){
					
					var QnAForm = document.QnAForm;
			   		var StartDay = QnAForm.startDay.value;
			   		var EndDay = QnAForm.endDay.value;
			   		
			   		if(StartDay !="" &&EndDay == ""){
			   			alert("[필수선택]검색 범위를 지정해주세요.")			 
			   		}else if (StartDay >EndDay) {
			   			alert("[필수선택]날짜 검색이 잘못 되었습니다.")
					}else {
						QnAForm.submit();
					}
			   	}
				// 회원 정보 예외 처리
					function MemberSelect(){
					
					var memberForm = document.memberForm;
			   		var StartDay = memberForm.startDay.value;
			   		var EndDay = memberForm.endDay.value;
			   		
			   		if(StartDay !="" &&EndDay == ""){
			   			alert("[필수선택]검색 범위를 지정해주세요.")			 
			   		}else if (StartDay >EndDay) {
			   			alert("[필수선택]날짜 검색이 잘못 되었습니다.")
					}else {
			   			memberForm.submit();
					}
			   	}
			</script>
</body>
</html>