<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="resources/img/PIcon.png">
<title>airLight</title>
</head>
<style>
   #idpwresult_content{
      margin-top : 10px;
      border : 1px solid black;
      width :100%;
      height : 712px;
      background : white;
   }
   #idpwresult_center{
      margin : 0 auto;
      width : 50%;
      height : 300px;
      border : 2px solid black;
      margin-top : 150px;
      background : white;
      text-align : center;
   }
   #idpwresult_title{
      width : 100%;
      background:#05224a;
      color : white;
      line-height : 80px;
      height : 80px;   
   }
   #idpwresult_title>h1{
      margin-top : 0;
   }
   #idpwresult_text{
      width : 90%;
      margin : 0 auto;
      margin-top  :  80px;
      font-size : 24px;
      font-weight : bold;
   }
   .text_color{
      font-size : 30px;
      color : Red;
   }
</style>
<body>
<div id=idpwresult_content>
   <div id="idpwresult_center">
      <div id="idpwresult_title"><h1>아이디/PW/회원코드 찾기</h1></div>
      <div id="idpwresult_text">
         <c:if test="${chks==1 }">
         <div id="chks1" >${member_code }코드의 아이디는&nbsp;&nbsp;&nbsp;<span class="text_color">${id }</span>&nbsp;&nbsp;&nbsp;입니다</div>
         </c:if>
         <c:if test="${chks==2 }">
         <div id="chks2" >${email }메일의 아이디는&nbsp;&nbsp;&nbsp;<span class="text_color">${myid }</span>&nbsp;&nbsp;&nbsp;입니다</div>
         </c:if>
         
         <c:if test="${chks3==1 }">
         <div id="chks2" >${dbid }아이디의 비밀번호는&nbsp;&nbsp;&nbsp;<span class="text_color">${pw }</span>&nbsp;&nbsp;&nbsp;입니다</div>
         </c:if>
         
         <c:if test="${chks1==1 }">
         <div id="chks2" >[${phone }]휴대폰번호의 회원코드는&nbsp;&nbsp;&nbsp;<span class="text_color">${member_code }</span>&nbsp;&nbsp;&nbsp;입니다</div>
         </c:if>
         <c:if test="${chks1==2 }">
         <div id="chks2" >[${email }]메일의 회원코드는&nbsp;&nbsp;&nbsp;<span class="text_color">${member_code }</span>&nbsp;&nbsp;&nbsp;입니다</div>
         </c:if>
      </div>
   </div>   
</div>
</body>
</html>