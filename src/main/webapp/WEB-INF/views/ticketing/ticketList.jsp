<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#ListMain{
		width: 100%;
        height: 1200px;
        box-sizing : borer-box;
        margin : 0 auto;
        margin-top : 20px;
		background-color: transparent;
	}
	#ListMain>h2{
		margin-left : 30px;
		color : black;
	}
	#ListMain>p{
		margin-left : 30px;
		color : black;
	}
	#ticketlist_contant{
		width : 95%;
		margin : 0 auto;
		
	}
	#Listleft,#Listleft01 ,#ListRight,#priceTag{
        display: inline-block;
    }
    #Listleft02, #ListRight02{
    	overflow: auto;
    }
    #Listleft01{
    	width: 500px;
        height: 800px;
        background: white;
        border : 1px solid black;
        border-radius : 5px;
        font-weight : bold;
        
    }
    #Listleft01_div{
    	height : 103px;
    	width : 250px;
    	background-image : url("resources/img/airLight-main-logo-black.jpg");
    	margin-top : 320px;
    	margin-left : 120px;
    }
    #Listleft02{
        width: 500px;
        height: 800px;
        background:white;
        color : black;
        border : 1px solid black;
        border-style : dashed;
        border-radius : 5px;
        font-weight : bold;
        
    }
    #ListRight02{
        width: 500px;
        height: 800px;
        background:white;
    	border-radius : 5px;
    	color : black;
    	border : 1px solid black;
    	border-style : dashed;
    	font-weight : bold;
    }
    .left:first-child, .right:first-child{
    	margin-top : 0;
    }
    .left, .right{
    	border : 1px solid black;
    	border-bottom-style : dashed;
    	border-top : none;
    	border-radius : 5px;
    	padding :5px;
    	border-left : none;
    	border-right : none;
    	cursor : pointer;
    }
    #priceTag{
    	border : 2px solid black;
    	border-style : dashed;
    	vertical-align : top;
    	margin-top: 72px;
    	width: 17%;
    	border-radius : 5px;
    	margin-left : 10px;
    	color : black;
    	text-align : right;
    	background : white;
    }
    #priceTag>p{
    	margin-right : 15px;
    	font-weight : bold;
    }
    .grayLeft, .grayRight{
    	background: #dfdfdf;
    	color :  black;
    }
    .btn_font{
    	text-align : right;
    	font-weight : bold;
    	margin-right : 10px;
    }
    #tex{
    	color : #d60815;
    	font-size : 24px;
    }
    #dotted{
    	border : 2px solid black;
    	border-style: dashed;
    }
    #total{
    	color : #0180a3;
    	font-size : 24px;
    	
    }
    #priceTag_btn{
    	border-radius : 5px;
    	border : 2px solid black;
    	font-weight : bold;
    	font-size : 18px;
    	background : #ece6cc;
    	margin-right : 15px;
    	margin-bottom : 20px;
    }
    .seat_remain{
    	margin-left : 5px;
    	font-size : 14px;
    }
    .st_time{
    	margin-left : 30px;
    }
    .en_time{
    	margin-left : 110px;
    }
    .none_seat{
    	margin-left : 30px;
    }
    .days{
    	margin-left : 30px;
    }
      @media(max-width:1280px){ /*========================================1280px  */
    	#ListMain{
			width: 110%;
	        height: 1200px;
	        box-sizing : borer-box;
	        margin : 0 auto;
	        margin-top : 20px;
			background-color: transparent;
		}
		#ListMain>h2{
		margin-left : 10px;
		color : black;
	}
	#ListMain>p{
		margin-left : 10px;
		color : black;
	}
	#ticketlist_contant{
		width : 95%;
		margin : 0 auto;
		
	}
	#Listleft,#Listleft01 ,#ListRight,#priceTag{
        display: inline-block;
    }
    #Listleft02, #ListRight02{
    	overflow: auto;
    }
    #Listleft01{
    	width: 400px;
        height: 800px;
        background: white;
        border : 1px solid black;
        border-radius : 5px;
        font-weight : bold;
        
    }
    #Listleft01_div{
    	height : 103px;
    	width : 250px;
    	background-image : url("resources/img/airLight-main-logo-black.jpg");
    	margin-top : 320px;
    	margin-left : 60px;
    }
    #Listleft02{
        width: 400px;
        height: 800px;
        background:white;
        color : black;
        border : 1px solid black;
        border-style : dashed;
        border-radius : 5px;
        font-weight : bold;
        
    }
    #ListRight02{
        width: 400px;
        height: 800px;
        background:white;
    	border-radius : 5px;
    	color : black;
    	border : 1px solid black;
    	border-style : dashed;
    	font-weight : bold;
    }
    .left:first-child, .right:first-child{
    	margin-top : 0;
    }
    .left, .right{
    	border : 1px solid black;
    	border-bottom-style : dashed;
    	border-top : none;
    	border-radius : 5px;
    	padding :5px;
    	border-left : none;
    	border-right : none;
    	cursor : pointer;
    	font-size : 16px;
    }
    #priceTag{
    	border : 2px solid black;
    	border-style : dashed;
    	vertical-align : top;
    	margin-top: 72px;
    	width: 17%;
    	border-radius : 5px;
    	margin-left : 10px;
    	color : black;
    	text-align : right;
    	background : white;
    }
    #priceTag>p{
    	margin-right : 15px;
    	font-weight : bold;
    }
    .grayLeft, .grayRight{
    	background: #dfdfdf;
    	color :  black;
    }
    .btn_font{
    	text-align : right;
    	font-weight : bold;
    	margin-right : 10px;
    }
    #tex{
    	color : #d60815;
    	font-size : 24px;
    }
    #dotted{
    	border : 2px solid black;
    	border-style: dashed;
    }
    #total{
    	color : #0180a3;
    	font-size : 24px;
    	
    }
    #priceTag_btn{
    	border-radius : 5px;
    	border : 2px solid black;
    	font-weight : bold;
    	font-size : 18px;
    	background : #ece6cc;
    	margin-right : 15px;
    	margin-bottom : 20px;
    }
    .seat_remain{
    	margin-left : 5px;
    	font-size : 14px;
    }
    .st_time{
    	margin-left : 30px;
    	font-size : 14px;
    }
    .en_time{
    	margin-left : 110px;
    	font-size : 14px;
    }
    .none_seat{
    	margin-left : 30px;
    	font-size : 14px;
    }
    .days{
    	margin-left : 30px;
    	font-size : 14px;
    }
    .days1{
    	font-size : 14px;
    	margin-left : 20px;
    }
    .plane_names{
    	font-size : 14px;
    	font-weight : bold;
    }
    .plane_names1{
    	font-size : 14px;
    	font-weight : bold;
    	margin-left : 20px;
    }
    .seat_remain1{
    	margin-left : 22px;
    	font-size : 14px;
    }
    
    }
</style>
</head>
<body>
<form action="rule" method="post" onsubmit="return reserve()">
<div id="ListMain">
	<h2>항공편 선택</h2>
	<p>항공편 일정을 확인하시고 선택하여 주시기 바랍니다.</p>
	<div id="ticketlist_contant">
		<c:set var="type" value="예매종류" />
		<c:set var="ranked" value="" />
		<c:if test="${goway==1}">
			<c:set var="type" value="편도" />
		</c:if>
		<c:if test="${goway==2}">
			<c:set var="type" value="왕복" />
		</c:if>
		<c:if test="${rank==1}">
			<c:set var="ranked" value="일반석" />
		</c:if>
		<c:if test="${rank==2}">
			<c:set var="ranked" value="비지니스석" />
		</c:if>
		<c:if test="${rank==3}">
			<c:set var="ranked" value="일등석" />
		</c:if>
		<!-- ============================================================== 편도 ============================================================== -->
		<div id="Listleft">
			<c:set var="i" value="0" />
			<c:set var="aaa" value="0" />
			<input type="hidden" name="goTimeCode" id="goTimeCode">
			<input type="hidden" name="startPoint" id="startPoint">
			<input type="hidden" name="endPoint" id="endPoint">
			<input type="hidden" name="goDay" id="goDay">
			<input type="hidden" name="goTime" id="goTime">
			<input type="hidden" name="plusHour" id="plusHour">
			<input type="hidden" name="plusMin" id="plusMin">
			<input type="hidden" name="planeName" id="planeName">
			<input type="hidden" name="hour" id="hour">
			<input type="hidden" name="min" id="min">
			<input type="hidden" name="rank" id="rank" value="${ranked}">
			<input type="hidden" name="goway" id="goway" value="${type}">
			<input type="hidden" name="day01" id="day01" value="${day01}">
			<input type="hidden" name="day02" id="day02" value="${day02}">
			<h2><label name="start">${start}</label> -> <label name="end">${end}</label></h2>
			<div id="Listleft02">
			<c:forEach var="everyList" items="${everyList}">
			<c:choose>
				<c:when test="${mycal==everyList.go_day && mycalHour>inHour[i] || mycal==everyList.go_day && mycalHour==inHour[i] && mycalMin>inMin[i] || everyList.remain_seat==0}">
				<!-- ============================================================== 편도(회색)  ============================================================== -->
					<div class="left grayLeft">
						<p class="days1">${everyList.go_day}(${day01}) | ${everyList.go_time}-<c:if test="${plusHour[i]<10}">0</c:if>${plusHour[i]}:${plusMin[i]}<c:if test="${plusMin[i]==0}">0</c:if> | ${hour[i]}시간 ${min[i]}분  | ${type} </p>
						<p>
							<label class="plane_names1">${everyList.plane_name} ${start}/${everyList.start_point} -> ${end}/${everyList.end_point}</label>
						</p>
						<p><label class="seat_remain1">남은좌석: ${everyList.remain_seat}석</label><label class="st_time">${everyList.go_time}</label> <label class="en_time">${plusHour[i]}:${plusMin[i]}<c:if test="${plusMin[i]==0}">0</c:if></label> </p>
						<c:set var="i" value="${i+1}" />
					</div>
				</c:when>
				<c:otherwise>
				<!-- ============================================================== 편도  ============================================================== -->
					<div class="left">
					<p class="days">${everyList.go_day}(${day01}) | ${everyList.go_time}-<c:if test="${plusHour[i]<10}">0</c:if>${plusHour[i]}:${plusMin[i]}<c:if test="${plusMin[i]==0}">0</c:if> | ${hour[i]}시간 ${min[i]}분  | ${type} </p>
					<p>
						<input type="radio" id="chk${i}" name="chk" value="${i}" onclick="price(this.value)">
						<input type="hidden" id="eprice${i}" value="${everyList.e_price}">
						<input type="hidden" id="bprice${i}" value="${everyList.b_price}">
						<input type="hidden" id="fprice${i}" value="${everyList.f_price}">
						<input type="hidden" id="timeCode${i}" value="${everyList.time_code}">
						<input type="hidden" id="startPoint${i}" value="${everyList.start_point}">
						<input type="hidden" id="endPoint${i}" value="${everyList.end_point}">
						<input type="hidden" id="goDay${i}" value="${everyList.go_day}">
						<input type="hidden" id="goTime${i}" value="${everyList.go_time}">
						<c:if test="${plusHour[i]<10}">
								<input type="hidden" id="plusHour${i}" value="0${plusHour[i]}">
							</c:if>
							<c:if test="${plusHour[i]>9}">
								<input type="hidden" id="plusHour${i}" value="${plusHour[i]}">
							</c:if>
						<input type="hidden" id="plusMin${i}" value="${plusMin[i]}">
						<input type="hidden" id="hour${i}" value="${hour[i]}">
						<input type="hidden" id="min${i}" value="${min[i]}">
						<input type="hidden" id="planeName${i}" value="${everyList.plane_name}">
						<label class="plane_names">${everyList.plane_name} ${start}/${everyList.start_point} -> 
						${end}/${everyList.end_point}</label>
					</p>
					<p> <label class="seat_remain none_seat">남은좌석: ${everyList.remain_seat}석</label>
					<label class="st_time">${everyList.go_time}</label> <label class="en_time">${plusHour[i]}:${plusMin[i]}<c:if test="${plusMin[i]==0}">0</c:if></label></p>
					<c:set var="i" value="${i+1}" />
				</div>
				<c:set var="aaa" value="${aaa+1}" />
				</c:otherwise>
			</c:choose>
			</c:forEach>
			</div>
		</div>
		<c:if test="${goway==1}">
					<div id="Listleft01">
						<div id="Listleft01_div"></div>
					</div>
		</c:if>
		<c:if test="${aaa==0 }">
			<script>
		         alert('선택하신 항공편이 존재하지 않습니다.'); 
		         history.go(-1);
     		 </script>
		</c:if>
		<!-- ============================================================== 왕복 ============================================================== -->
		<input type="hidden" name="endTimeCode" id="endTimeCode" value="">
		<input type="hidden" name="twostartPoint" id="twostartPoint" value="">
		<input type="hidden" name="twoendPoint" id="twoendPoint" value="">
		<input type="hidden" name="twogoDay" id="twogoDay" value="">
		<input type="hidden" name="twogoTime" id="twogoTime" value="">
		<input type="hidden" name="twoplusHour" id="twoplusHour" value="">
		<input type="hidden" name="twoplusMin" id="twoplusMin" value="">
		<input type="hidden" name="twoplaneName" id="twoplaneName" value="">
		<input type="hidden" name="twohour" id="twohour" value="">
		<input type="hidden" name="twomin" id="twomin" value="">
		<c:if test="${goway==2}">
			<div id="ListRight">
				<c:set var="j" value="0" />
				<h2>${start2} -> ${end2}</h2>
				<div id="ListRight02">
				<c:forEach var="everyList2" items="${everyList2}">
				<c:choose>
					<c:when test="${mycal==everyList2.go_day && mycalHour>inHour2[j] || mycal==everyList2.go_day && mycalHour==inHour2[j] && mycalMin>inMin2[j] || everyList2.remain_seat==0}">
					<!-- ============================================================== 왕복(회색)  ============================================================== -->
						<div class="right grayRight">
							<p class="days1">${everyList2.go_day}(${day02}) | ${everyList2.go_time}-${plusHour2[j]}:${plusMin2[j]}<c:if test="${plusMin2[j]==0}">0</c:if> | ${hour2[j]}시간 ${min2[j]}분 | ${type} </p>
							<p>
								<label class="plane_names">${everyList2.plane_name} ${start2}/${everyList2.start_point} -> ${end2}/${everyList2.end_point}</label>
							</p>
							<p> <label class="seat_remain">남은좌석: ${everyList2.remain_seat}석</label><label class="st_time">${everyList2.go_time}</label> <label class="en_time">${plusHour2[j]}:${plusMin2[j]}<c:if test="${plusMin2[j]==0}">0</c:if></label></p>
							<c:set var="j" value="${j+1}" />
						</div>
					</c:when>
					<c:otherwise>
					<!-- ============================================================== 왕복  ============================================================== -->
						<div class="right">
							<p class="days">${everyList2.go_day}(${day02}) | ${everyList2.go_time}-${plusHour2[j]}:${plusMin2[j]}<c:if test="${plusMin2[j]==0}">0</c:if> | ${hour2[j]}시간 ${min2[j]}분 | ${type} </p>
							<p>
								<input type="radio" id="chk2${j}" name="chk2" value="${j}" onclick="price2(this.value)">
								<input type="hidden" id="eprice2${j}" value="${everyList2.e_price}">
								<input type="hidden" id="bprice2${j}" value="${everyList2.b_price}">
								<input type="hidden" id="fprice2${j}" value="${everyList2.f_price}">
								<input type="hidden" id="timeCode2${j}" value="${everyList2.time_code}">
								<input type="hidden" id="startPoint2${j}" value="${everyList2.start_point}">
								<input type="hidden" id="endPoint2${j}" value="${everyList2.end_point}">
								<input type="hidden" id="goDay2${j}" value="${everyList2.go_day}">
								<input type="hidden" id="goTime2${j}" value="${everyList2.go_time}">
								<c:if test="${plusHour2[j]<10}">
									<input type="hidden" id="plusHour2${j}" value="0${plusHour2[j]}">
								</c:if>
								<c:if test="${plusHour2[j]>9}">
									<input type="hidden" id="plusHour2${j}" value="${plusHour2[j]}">
								</c:if>
								<input type="hidden" id="plusMin2${j}" value="${plusMin2[j]}">
								<input type="hidden" id="hour2${j}" value="${hour2[j]}">
								<input type="hidden" id="min2${j}" value="${min2[j]}">
								<input type="hidden" id="planeName2${j}" value="${everyList2.plane_name}">
								<label class="plane_names">${everyList2.plane_name} ${start2}/${everyList2.start_point} -> ${end2}/${everyList2.end_point}</label>
							</p>
							<p> <label class="seat_remain  none_seat">남은좌석: ${everyList2.remain_seat}석</label><label class="st_time">${everyList2.go_time}</label> <label class="en_time">${plusHour2[j]}:${plusMin2[j]}<c:if test="${plusMin2[j]==0}">0</c:if></label></p>
							<c:set var="j" value="${j+1}" />
						</div>
					</c:otherwise>
				</c:choose>
				</c:forEach>
				</div>
			</div>
		</c:if>
		<div id="priceTag">
			<p>
				<c:if test="${adultnum!=0}"><label>성인: ${adultnum}</label></c:if>
				<c:if test="${childnum!=0}"><label>소아: ${childnum}</label></c:if>
				<c:if test="${babynum!=0}"><label>유아: ${babynum}</label></c:if>
			</p>
			<p>티켓금액: <label id="ticketPrice">0</label>원</p>
			<p>부가세: <label id="tex">0</label>원</p>
			<hr id="dotted">
			<p>총액: <label id="total">0</label>원</p>
			<input type="submit" value="예매하기" id="priceTag_btn">
			<input type="hidden" name="adult" value="${adultnum}">
			<input type="hidden" name="child" value="${childnum}">
			<input type="hidden" name="baby" value="${babynum}">
			<input type="hidden" id="onlyticketPrice" name="ticketPrice">
			<input type="hidden" id="onlytex" name="tex">
			<input type="hidden" id="onlytotal" name="total">
		</div>
	</div>
</div>
</form>
<script>

	var ticketPrice = document.getElementById("ticketPrice");
	var tex = document.getElementById("tex");
	var total = document.getElementById("total");
	var remain = 0; // 가는날 총액
	var remain2 = 0; // 오는날 총액
	var chk = 0;
	var fin = 0;
	var goTimeCode = document.getElementById("goTimeCode");
	var endTimeCode = document.getElementById("endTimeCode");

	function price(radio){
		var eprice = document.getElementById("eprice"+radio);
		var bprice = document.getElementById("bprice"+radio);
		var fprice = document.getElementById("fprice"+radio);
		var timeCode = document.getElementById("timeCode"+radio);
		if(chk==2){
			if(parseInt('${rank}')==1){
				ticketPrice.innerHTML = remain2 + parseInt(eprice.value)*parseInt('${adultnum}') + parseInt(eprice.value)*0.5*parseInt('${childnum}') + parseInt(eprice.value)*0.3*parseInt('${babynum}');
				remain = parseInt(parseInt(eprice.value)*parseInt('${adultnum}') + parseInt(eprice.value)*0.5*parseInt('${childnum}') + parseInt(eprice.value)*0.3*parseInt('${babynum}'));
			}else if(parseInt('${rank}')==2){
				ticketPrice.innerHTML = remain2 + parseInt(bprice.value)*parseInt('${adultnum}') + parseInt(bprice.value)*0.5*parseInt('${childnum}') + parseInt(bprice.value)*0.3*parseInt('${babynum}');
				remain = parseInt(parseInt(bprice.value)*parseInt('${adultnum}') + parseInt(bprice.value)*0.5*parseInt('${childnum}') + parseInt(bprice.value)*0.3*parseInt('${babynum}'));
			}else if(parseInt('${rank}')==3){
				ticketPrice.innerHTML = remain2 + parseInt(fprice.value)*parseInt('${adultnum}') + parseInt(fprice.value)*0.5*parseInt('${childnum}') + parseInt(fprice.value)*0.3*parseInt('${babynum}');
				remain = parseInt(parseInt(fprice.value)*parseInt('${adultnum}') + parseInt(fprice.value)*0.5*parseInt('${childnum}') + parseInt(fprice.value)*0.3*parseInt('${babynum}'));
			}
		}else{
			if(parseInt('${rank}')==1){
				ticketPrice.innerHTML = parseInt(eprice.value)*parseInt('${adultnum}') + parseInt(eprice.value)*0.5*parseInt('${childnum}') + parseInt(eprice.value)*0.3*parseInt('${babynum}');
			}else if(parseInt('${rank}')==2){
				ticketPrice.innerHTML = parseInt(bprice.value)*parseInt('${adultnum}') + parseInt(bprice.value)*0.5*parseInt('${childnum}') + parseInt(bprice.value)*0.3*parseInt('${babynum}');
			}else if(parseInt('${rank}')==3){
				ticketPrice.innerHTML = parseInt(fprice.value)*parseInt('${adultnum}') + parseInt(fprice.value)*0.5*parseInt('${childnum}') + parseInt(fprice.value)*0.3*parseInt('${babynum}');
			}
			chk = 1;
			remain = parseInt(ticketPrice.innerHTML);
		}
		tex.innerHTML = parseInt(ticketPrice.innerHTML)*0.08;
		total.innerHTML = (parseInt(tex.innerHTML) + parseInt(ticketPrice.innerHTML)).toLocaleString();
		tex.innerHTML = (parseInt(ticketPrice.innerHTML)*0.08).toLocaleString();
		ticketPrice.innerHTML = parseInt(ticketPrice.innerHTML).toLocaleString();
		goTimeCode.value = timeCode.value;
		document.getElementById("startPoint").value = document.getElementById("startPoint"+radio).value;
		document.getElementById("endPoint").value = document.getElementById("endPoint"+radio).value;
		document.getElementById("goDay").value = document.getElementById("goDay"+radio).value;
		document.getElementById("goTime").value = document.getElementById("goTime"+radio).value;
		document.getElementById("plusHour").value = document.getElementById("plusHour"+radio).value;
		if(document.getElementById("plusMin"+radio).value==0){
			document.getElementById("plusMin").value = document.getElementById("plusMin"+radio).value + "0";
		}else{
			document.getElementById("plusMin").value = document.getElementById("plusMin"+radio).value;
		}
		document.getElementById("planeName").value = document.getElementById("planeName"+radio).value;
		document.getElementById("hour").value = document.getElementById("hour"+radio).value;
		document.getElementById("min").value = document.getElementById("min"+radio).value;
		document.getElementById("onlyticketPrice").value = ticketPrice.innerHTML;
		document.getElementById("onlytex").value = tex.innerHTML;
		document.getElementById("onlytotal").value = total.innerHTML;
	}
	
	function price2(radio){
		if(chk==0){
			var chk2 = document.getElementById("chk2"+radio);
			chk2.checked = false;
			alert("가는 날을 먼저 선택해주세요.");
		}else{
			var eprice = document.getElementById("eprice2"+radio);
			var bprice = document.getElementById("bprice2"+radio);
			var fprice = document.getElementById("fprice2"+radio);
			var timeCode = document.getElementById("timeCode2"+radio);
			if(chk==1){
				if(parseInt('${rank}')==1){
					ticketPrice.innerHTML = remain + parseInt(eprice.value)*parseInt('${adultnum}') + parseInt(eprice.value)*0.5*parseInt('${childnum}') + parseInt(eprice.value)*0.3*parseInt('${babynum}');
					remain2 = parseInt(parseInt(eprice.value)*parseInt('${adultnum}') + parseInt(eprice.value)*0.5*parseInt('${childnum}') + parseInt(eprice.value)*0.3*parseInt('${babynum}'));
				}else if(parseInt('${rank}')==2){
					ticketPrice.innerHTML = remain + parseInt(bprice.value)*parseInt('${adultnum}') + parseInt(bprice.value)*0.5*parseInt('${childnum}') + parseInt(bprice.value)*0.3*parseInt('${babynum}');
					remain2 = parseInt(parseInt(bprice.value)*parseInt('${adultnum}') + parseInt(bprice.value)*0.5*parseInt('${childnum}') + parseInt(bprice.value)*0.3*parseInt('${babynum}'));
				}else if(parseInt('${rank}')==3){
					ticketPrice.innerHTML = remain + parseInt(fprice.value)*parseInt('${adultnum}') + parseInt(fprice.value)*0.5*parseInt('${childnum}') + parseInt(fprice.value)*0.3*parseInt('${babynum}');
					remain2 = parseInt(parseInt(fprice.value)*parseInt('${adultnum}') + parseInt(fprice.value)*0.5*parseInt('${childnum}') + parseInt(fprice.value)*0.3*parseInt('${babynum}'));
				}
				chk=2;
			}else if(chk==2){
				if(parseInt('${rank}')==1){
					ticketPrice.innerHTML = remain + parseInt(eprice.value)*parseInt('${adultnum}') + parseInt(eprice.value)*0.5*parseInt('${childnum}') + parseInt(eprice.value)*0.3*parseInt('${babynum}');
					remain2 = parseInt(parseInt(eprice.value)*parseInt('${adultnum}') + parseInt(eprice.value)*0.5*parseInt('${childnum}') + parseInt(eprice.value)*0.3*parseInt('${babynum}'));
				}else if(parseInt('${rank}')==2){
					ticketPrice.innerHTML = remain + parseInt(bprice.value)*parseInt('${adultnum}') + parseInt(bprice.value)*0.5*parseInt('${childnum}') + parseInt(bprice.value)*0.3*parseInt('${babynum}');
					remain2 = parseInt(parseInt(bprice.value)*parseInt('${adultnum}') + parseInt(bprice.value)*0.5*parseInt('${childnum}') + parseInt(bprice.value)*0.3*parseInt('${babynum}'));
				}else if(parseInt('${rank}')==3){
					ticketPrice.innerHTML = remain + parseInt(fprice.value)*parseInt('${adultnum}') + parseInt(fprice.value)*0.5*parseInt('${childnum}') + parseInt(fprice.value)*0.3*parseInt('${babynum}');
					remain2 = parseInt(parseInt(fprice.value)*parseInt('${adultnum}') + parseInt(fprice.value)*0.5*parseInt('${childnum}') + parseInt(fprice.value)*0.3*parseInt('${babynum}'));
				}
			}
			tex.innerHTML = parseInt(ticketPrice.innerHTML)*0.08;
			total.innerHTML = (parseInt(tex.innerHTML) + parseInt(ticketPrice.innerHTML)).toLocaleString();
			tex.innerHTML = (parseInt(ticketPrice.innerHTML)*0.08).toLocaleString();
			ticketPrice.innerHTML = parseInt(ticketPrice.innerHTML).toLocaleString();
			endTimeCode.value = timeCode.value;
			document.getElementById("twostartPoint").value = document.getElementById("startPoint2"+radio).value;
			document.getElementById("twoendPoint").value = document.getElementById("endPoint2"+radio).value;
			document.getElementById("twogoDay").value = document.getElementById("goDay2"+radio).value;
			document.getElementById("twogoTime").value = document.getElementById("goTime2"+radio).value;
			document.getElementById("twoplusHour").value = document.getElementById("plusHour2"+radio).value;
			if(document.getElementById("plusMin2"+radio).value==0){
				document.getElementById("twoplusMin").value = document.getElementById("plusMin2"+radio).value + "0";
			}else{
				document.getElementById("twoplusMin").value = document.getElementById("plusMin2"+radio).value;
			} 
			document.getElementById("twoplaneName").value = document.getElementById("planeName2"+radio).value;
			document.getElementById("twohour").value = document.getElementById("hour2"+radio).value;
			document.getElementById("twomin").value = document.getElementById("min2"+radio).value;
			document.getElementById("onlyticketPrice").value = ticketPrice.innerHTML;
			document.getElementById("onlytex").value = tex.innerHTML;
			document.getElementById("onlytotal").value = total.innerHTML;
			fin = 1;
		}
	}
	
	function reserve(){
		if(parseInt('${goway}')==1){
			if(chk!=1){
				alert("항공편을 선택해주세요.");
				return false;
			}
		}else if(parseInt('${goway}')==2){
			if(fin!=1){
				alert("항공편을 모두 선택하지 않았습니다.");
				return false;
			}
		}
		return true;
	}
	
</script>
</body>
</html>




























