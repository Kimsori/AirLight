<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/png" href="resources/img/PIcon.png">
<title>Insert title here</title>
<style>
	/* 	#rule{
			border-radius : 5px;
		} */
	#ruleform{
		margin : 0 ;
		background : rgb(102, 156, 178,0.0);
		height : 700px;
	}
	#rule_contant{
		margin: 0 auto;
		margin-top : 70px;
		width : 80%;
		height : 700px;
		background : rgb(102, 156, 178,0.0);
		border-radius : 5px;
	}
	#rule_contant>h1{
		text-align : center;
		color : black;
	}
	#rule_contant table{
		margin : 0 auto;
		border-collapse: collapse;
		margin-bottom: 20px;
		width : 70%;
	}
	#rule_contant th{
		border : 1px solid black;
		background : #05224a;
		height : 60px;
		color : white;
	}
	#rule_contant td{
		border : 1px solid black;
		background : white;
	}
	#rule_contant td:first-child{
		background : #dfdfdf;
		font-weight : bold;
		height : 70px;
		text-align : center;
	}
	#ct01{
		margin : 0 auto;
		text-align : center;
	}
	#sub_btn{
		border : 2px solid black;
		border-radius :5px;
		font-weight : bold;
		color : white;
		background : #05224a;
		height : 50px;
		margin : 0 atuo;
		margin-bottom : 20px;
	}
	@media(max-width:1280px){ 	/*==================================1280px  */
		#ruleform{
		margin : 0 ;
		background : rgb(102, 156, 178,0.0);
		height : 700px;
	}
	#rule_contant{
		margin: 0 auto;
		margin-top : 70px;
		width : 90%;
		height : 700px;
		background : rgb(102, 156, 178,0.0);
		border-radius : 5px;
	}
	#rule_contant>h1{
		text-align : center;
		color : black;
	}
	#rule_contant table{
		margin : 0 auto;
		border-collapse: collapse;
		margin-bottom: 20px;
		width : 90%;
	}
	#rule_contant th{
		border : 1px solid black;
		background : #05224a;
		height : 60px;
		color : white;
	}
	#rule_contant td{
		border : 1px solid black;
		background : white;
	}
	#rule_contant td:first-child{
		background : #dfdfdf;
		font-weight : bold;
		height : 70px;
		text-align : center;
	}
	#ct01{
		margin : 0 auto;
		text-align : center;
	}
	#sub_btn{
		border : 2px solid black;
		border-radius :5px;
		font-weight : bold;
		color : white;
		background : #05224a;
		height : 50px;
		margin : 0 atuo;
		margin-bottom : 20px;
	}
	}
</style>
</head>
<body>
<div id="rule">
	<form action="seat" method="post"  id="ruleform">
	<div id="rule_contant">
			<h1>운임규정</h1>
			<table id="tb1">
				<thead>
					<tr>
						<th colspan="2">
							<span>${startPoint} -> ${endPoint}</span> <span>${planeName} | ${goDay}(${day01}) | ${goTime}-${plusHour}:${plusMin} | ${hour}시간 ${min}분 | ${goway} | ${rank} </span> 
						</th>
					</tr>
					<tr>
						<td>여정취소</td>
						<td>
							- 예매 완료 후 24시간 이내에 입금하지 않을 시 미입금(자동취소)처리가 됩니다.<br>
							- 환불신청(결제취소)은 결제 완료 기준, 출발일 -5일까지만 가능합니다.<br>
							- 출발일 -5이 넘은 상태에서는 환불 및 취소가 불가능합니다.
						</td>
					</tr>
					<tr>
						<td>마일리지 적립</td>
						<td>
							- 결제가 완료되면 예매 금액의 5%만큼 마일리지가 적립됩니다.<br>
							- 미입금 상태에서는 마일리지가 적립되지 않습니다.
						</td>
					</tr>
					<tr>
						<td>부과세</td>
						<td>
							- 부과세는 결제금액의 8%만큼 부과됩니다.
						</td>
					</tr>
				</thead>
			</table>
			<c:if test="${goway=='왕복'}">
				<table id="tb2">
					<thead>
						<tr>
							<th colspan="2">
								<span>${twostartPoint} -> ${twoendPoint}</span> <span>${twoplaneName} | ${twogoDay}(${day02}) | ${twogoTime}-${twoplusHour}:${twoplusMin} | ${twohour}시간 ${twomin}분 | ${goway} | ${rank} </span> 
							</th>
						</tr>
						<tr>
							<td>여정취소</td>
							<td>
								- 예매 완료 후 24시간 이내에 입금하지 않을 시 미입금(자동취소)처리가 됩니다.<br>
								- 환불신청(결제취소)은 결제 완료 기준, 출발일 -5일까지만 가능합니다.<br>
								- 출발일 -5이 넘은 상태에서는 환불 및 취소가 불가능합니다.
							</td>
						</tr>
						<tr>
							<td>마일리지 적립</td>
							<td>
								- 결제가 완료되면 예매 금액의 5%만큼 마일리지가 적립됩니다.<br>
								- 미입금 상태에서는 마일리지가 적립되지 않습니다.
							</td>
						</tr>
						<tr>
							<td>부과세</td>
							<td>
								- 부과세는 결제금액의 8%만큼 부과됩니다.
							</td>
						</tr>
					</thead>
				</table>
			</c:if>
			<div id="ct01">
				<input type="submit" value="운임규정확인완료" id="sub_btn">
			</div>
			
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
			<input type="hidden" name="total" value="${total}">
		</div>
	</form>
</div>

</body>
</html>