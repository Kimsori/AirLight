<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://kit.fontawesome.com/742b89101d.js" crossorigin="anonymous"></script>
<link rel="icon" type="image/png" href="resources/img/PIcon.png">
<title>airLight</title>
<style>
    /*============================================ 전체 화면 ==============================================*/
     /*============================================ 전체 화면 ==============================================*/
     #TicketMain{
     	margin-top : 50px;
        width: 100%;
        height: 700px;
        background : rgb(102, 156, 178,0.0);
    }
    #titcketMain{
        display: flex;
       border-radius: 5px;
      
        
    }
    #form1{
        display: flex;
        margin : 0 auto;
        justify-content: center;
        
    }
    #ticket01{
        width: 10%;
        background: #05224a;
        border-radius: 5px;
        border-right-style : dashed;
        border-right : 2px solid white;
    }
    #ticket01 p{
        margin-top : 50px;
        padding: 20px;
        background: #05224a;
		
        box-sizing: border-box;
        color: white;
        font-weight: bold;
        text-align: center;
    }
    #ticket01 i{
        color: white;
        line-height : 50px;
        
    }
    #ticket02{
        background-position: 0 0;
        width: 65%;
         background:#05224a;
        border-radius : 5px;
      
    }
    #ticket02 p{
        font-size: 20px;
        margin-left: 30px;
        font-weight: bold;
        color: white;
        
    }
    
    #oneway1,#twoway1{
        display: inline-block;
        margin-bottom: 20px;
        font-weight: bold;
       color: white;
    }
    
    #oneway1{
        margin-left: 30px;
        
    }
    /*============================================ 출발지, 목적지, 출발일 input ==============================================*/
    #goSpot, #endSpot, #goEndTime{
    	display: inline-block;	
    }
    #goSpot{
        border: 2px solid white;
        border-radius: 5px;
        width: 13%;
        background-color: white;
        vertical-align : bottom;
        position: absolute;
        left : 29.7%;
         top : 26.5%;
    }
    #goSpot>input{
        border: none;
        height: 30px;
        width: 90%;
        box-sizing: border-box;
       
    }
    #goSpot>i{
        font-size: 24px;
        position: relative;
        top:4px;
        background-color: white;
        cursor: pointer;
      	color : #05224a;
    }
    #endSpot{
        border: 2px solid white;
        border-radius: 5px;
         width: 13%;
        background-color: white;
         position: absolute;
         left : 43.5%;
         top : 26.5%;
    }
    #endSpot>input{
        border: none;
        height: 30px;
         width: 90%;
        box-sizing: border-box;
    }
    #endSpot>i{
        font-size: 24px;
        position: relative;
        cursor: pointer;
        color : #05224a;
         top:4px;
       
    }
    #goEndTime{
        border: 2px solid white;
        border-radius: 5px;
        width: 13%;
        background-color: white;
         position: absolute;
         left : 57.3%;
         top : 26.5%;
    }
    #goEndTime>input{
        border: none;
        height: 30px;
         width: 90%;
        box-sizing: border-box;
    }
    #goEndTime>i{
        font-size: 24px;
        position: relative;
       	top: 4px;
        background-color: white;
        cursor: pointer;
        color : #05224a;
    }
    .inputBox{
        cursor: pointer;
        outline: none;
    }
    #user-choi{
        margin-left: 35px;
        margin-top: 10px;
        margin-bottom: 10px;
        font-weight: bold;  
       color: white;
    }
    #user-choi>label{
        margin-right: 25px;
        margin-left: 30px;
    }
    
    #user-choi>label>i{
    	font-size: 20px;
    	cursor: pointer;
    	color : white;
    	maring-top : 10px;
    	margin-left : 5px;
    }
    #select_seet{
        margin-left: 30px;
    }
    #seet_one,#seet_two,#seet_three,.seet_chair,#search_air{
        display: inline-block;
        margin-bottom: 20px;
    }
    #seet_one{
        background-color: white;
        height: 30px;
        box-sizing: border-box;
        border-radius: 5px;
    }
    #seet_two{
        background-color: white;
        height: 30px;
        box-sizing: border-box;
        border-radius: 5px;
    }
    #seet_three{
        background-color: white;
        height: 30px;
        box-sizing: border-box;
        border-radius: 5px;
    }
    #seet_one>input{
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        vertical-align: top;
        height: 100%;
        border: none;
        text-align: center;
        width: 30px;
        line-height: 10px;
    }
    #seet_one>.plma{
        background: white;
        height: 100%;
        border-radius: 5px;
        border: 2px solid white;
        width: 30px;
        color: #05224a;
        font-size: 25px;
    }
    #seet_two>input{
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        vertical-align: top;
        height: 100%;
        border: none;
        text-align: center;
        width: 30px;
        line-height: 10px;
    }
    #seet_two>.plma{
          background: white;
        height: 100%;
        border-radius: 5px;
        border: 2px solid white;
        width: 30px;
        color: #05224a;
        font-size: 25px;
    }
     #seet_three>input{
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        vertical-align: top;
        height: 100%;
        border: none;
        text-align: center;
        width: 30px;
        line-height: 10px; 
    }
    #seet_three>.plma{
        background: white;
        vertical-align : top;
        border-radius: 5px;
        border: 2px solid white;
        width: 30px;
        color: #05224a;
        font-size: 25px;
    }
    .seet_chair{
    	border : 2px solid #05224a;
    	border-radius : 5px;
    	height : 30px;
    	box-sizing : border-box;
    	vertical-align : top;
    }
    #search_air{
        height: 30px;
        vertical-align: top;
        border-radius: 5px;
        color : white;
        border: 2px solid white;
        background: #05224a;
        font-weight : bold;
        box-sizing : border-box;
        cursor : pointer;
    }
    /*============================================ 성인, 소아, 유아 ==============================================*/
    #adultNum, #childNum, #babyNum{
        outline: none;
    }
    /*============================================ +-버튼 ==============================================*/
    .plma{
        cursor: pointer;
    }
    /*============================================ 출발지/목적지 ==============================================*/
    #local{
        position: absolute;
    	background: white;
	
        width: 500px;
        height: 430px;
        display: none;
        margin-right : 50p;
        left : 35%;
        top : 20%;
        border-radius: 5px;
        border : 3px solid black;
        margin-bottom : 20px;
        
    }
    #local>h2{
    	text-align : center;
    }
    #local i{
    	margin-left : 20px;
    	vertical-align: bottom;
    	box-sizing : border-box;
    	color : black;
    }
    #local>p{
    	font-weight : bold;
    	margin-left : 65px;
    	font-size : 25px;
    }
    #local #ul01{
    	width : 100px;
    	font-size : 18px;
    	font-weight : bold;
    	padding : 0;
    	margin-left : 30px;
    	text-align : center;
    	width : 150px;
    	height : 254px;
    	line-height : 50px;
    	background : #05224a;
    }
    #local #ul01>li{
    	padding : 0;
    	text-align : left;
    	color : black;
    	border-bottom : white;
    }
    #local>#ul01>li>a{
    	color : white;
    }
    #local #ul01>li, #local .ul02>li{
        position: relative;
       
    }
    #local .ul02{
        position: absolute;
        display: none;
        left : 150px;
        top : 0px;
        width : 240px;
        font-weight : bold;
        padding : 0;
        box-sizing : border-box;
        background : white;
        border-right : 2px solid black;
        border-top : 2px solid black;
        border-bottom : 2px solid black;
    }
    #local #ul01>li:hover .ul02{
        display: block;
    }
    #local li{
        list-style: none;
    }
    #local li a{
        text-decoration: none;
        color: black;
    }
    /*============================================ 출발일, 가는날/오는날 ==============================================*/
    #gocalender{
        display: none;
        position: absolute;
        background: #05224a;
        border-radius : 5px;
        width: 26%;
        text-align : center;
        left : 36%;
        top : 20%;
         z-index : 20;
    }
    #gocalender>h2{
    	color : white;
    }
    #gocalender>h2>label>i{
    	color : white;
    	margin-left : 10px;
    }
    #gocalender2{
     	display: none;
        position: absolute;
        background: #05224a;
        border-radius : 5px;
        width: 55%;
        text-align : center;
        left : 22%;
        top : 20%;
        z-index : 20;
     }
      #gocalender2>h2{
    	color : white;
    }
     #gocalender2>h2>label>i{
    	color : white;
    	margin-left : 10px;
    }
    #gocalender caption, #gocalender2 caption{
        font-weight: bold;
        font-size: 22px;
        vertical-align : top;
        padding: 10px 0;
        margin-bottom : 10px;
        width : 98%;
    }
    #gocalender th, td, #gocalender2 th, td{
        width: 50px;
        height: 35px;
        text-align: center;
    }
    #gocalender td, #gocalender2 td{
        height: 40px;
    }
    #gocalender th, #gocalender2 th{
        background: #05224a;
        color : white;
    }
    #gocalender th:first-of-type, #gocalender2 th:first-of-type{
        background: #ff4242;
        color: white;
    }
    #gocalender th:last-of-type, #gocalender2 th:last-of-type{
        background: #3e3eff;
        color: white;
    }
    #gocalender td:first-of-type, #gocalender2 td:first-of-type{
        color: #ff4242; /* 빨간색 */
        font-weight: bold;
 	}
    #gocalender .td06:last-of-type, #gocalender2 .td06:last-of-type{
        color: #3e3eff; /* 파란색 */
        font-weight: bold;
    }
    #gocalender #btn1, #btn2, #gocalender2 #btn3, #btn4, #btn5, #btn6{
        position: absolute;
        width: 70px;
        padding: 4px 0;
        background: lightgray;
        background: #f1fcff;
        border: none;
        border-radius: 5px;
    }
    .clickTd{
    	background: white;
        font-weight : bold;
    	cursor : pointer
    }
    #gocalender #btn1{
        top: 29%;
        left: 15%;
        background :#05224a;
        color : white;
        border-radius : 5px;
        font-weight : bold;
    }
    #gocalender #btn2{
        top: 29%;
        left: 72%;
        background : #05224a;
        color : white;
        border-radius : 5px;
        font-weight : bold;
    }
    #gocalender2 #btn3{
        top: 32%;
        left: 15%;
        background : #05224a;
        color : white;
        border-radius : 5px;
        font-weight : bold;
    }
    #gocalender2 #btn4{
        top: 32%;
        left: 39%;
        background : #05224a;
        color : white;
        border-radius : 5px;
        font-weight : bold;
    }
    #gocalender2 #btn5{
        top: 32%;
        left: 53%;
        background : #05224a;
        color : white;
        border-radius : 5px;
        font-weight : bold;
    }
    #gocalender2 #btn6{
        top: 32%;
        left: 78%;
        background : #05224a;
        color : white;
        border-radius : 5px;
        font-weight : bold;
    }
    #gocalender #calender, #gocalender2 #calender{
        margin-top: 10px;
    }
    #calen01, #calen02{
        display: inline-block;
    }
    #gocalender2 #calen01{
        width: 400px;
    }
    #gocalender2 #calen02{
        width: 400px;
    }
    .tdGray{
        background: #dfdfdf;
        font-weight : bold;
    }
    #calender{
    	margin-left : 60px;
    	margin-bottom : 50px;
    	border : 2px solid black;
    	background : white;
    	border-radius : 6px;
    	width : 78%;
    }
    #calender1{
    	margin-bottom : 50px;
    	border : 2px solid black;
    	border-radius : 6px;
    	margin-left : 5px;
    	background : white;
    }
    #calender2{
    	margin-bottom : 50px;
    	border : 2px solid black;
    	border-radius : 6px;
    	margin-left : 5px;
    	background : white;
    }
    /*============================================ 소아/유아 안내 ==============================================*/
    #childPop{
        width: 850px;
        position: absolute;
        background: #05224a;
        display: none;
        text-align : center;
        color : white;
        border : 3px solid black;
        border-radius : 5px;
        left : 25%;
        top : 20%;
    }
    #childPop table{
    	margin : 0 auto;
        border-collapse: collapse;
        width: 90%;
        margin-bottom : 20px;
        border : 3px solid black;
        border-radius : 5px;
        background : white;
    }
    #childPop th{
    	background : #05224a;
    	height : 70px;
    	color : white;
    }
    #childPop td:first-child{
    	background : #dfdfdf;
    	font-weight : bold;
    }
    #childPop>h2>i{
    	color : white;
    	margin-left : 30px;
    }
   /* 광고 */
    #advertising_contents{
    	width : 100%;
    	height : 400px;
    	margin : 0 auto;
    	margin-top : 20px;
    	margin-bottom : 20px;
    }
    #advertising_contents>h2{
    	color  : #05224a;
    	width : 75%;
    	margin : 0 auto;
    	margin-bottom : 30px;
    }
     #advertising_contents>h2>label{
     	color :    #cb1c5f;
     	font-size : 30px;
     }
    #adver_center{
    	width : 74%;
    	margin: 0 auto;
    	height : 400px;
    	display : flex;
    	justify-content: space-between;
    }
    #advertising1{
    	width : 17%;
    	height : 292px;
    }
    #adver_img1{
    	width : 11%;
    	height : 260px;
    	position : absolute;
    	border : 2px solid #05224a;
    }
    #adver_img1>img{
    	width : 100%;
    }
     #adver_p1{
    	width  : 110%;
    	height : 50px;
    	color  : white;
    	text-align : center;
    	font-weight : bold;
    	background :rgb(0, 0, 0,0.5);
    	position : relative;
    	top : 72.6%;
    }
   	#adver_p1>label{
   		color : #7ed0e0;
   		font-weight : bold;
   	}
    #advertising2{
    	width : 17%;
    	height : 292px;
    }
     #adver_img2{
    	width : 11%;
    	height : 260px;
    	position : absolute;
    	border : 2px solid #05224a;
    }
    #adver_img2>img{
    	width : 100%;
    }
     #adver_p2{
    	width  : 110%;
    	height : 50px;
    	color  : white;
    	text-align : center;
    	font-weight : bold;
    	background :rgb(0, 0, 0,0.5);
    	position : relative;
    	top : 72.6%;
    }
   	#adver_p2>label{
   		color : #7ed0e0;
   		font-weight : bold;
   	}
    #advertising3{
    	width : 17%;
    	height : 292px;
    }
     #adver_img3{
    	width : 11%;
    	height : 260px;
    	position : absolute;
    	border : 2px solid #05224a;
    }
    #adver_img3>img{
    	width : 100%;
    }
     #adver_p3{
    	width  : 110%;
    	height : 50px;
    	color  : white;
    	text-align : center;
    	font-weight : bold;
    	background :rgb(0, 0, 0,0.5);
    	position : relative;
    	top : 72.6%;
    }
   	#adver_p3>label{
   		color : #7ed0e0;
   		font-weight : bold;
   	}
   	 #advertising4{
    	width : 17%;
    	height : 292px;
    }
     #adver_img4{
    	width : 11%;
    	height : 260px;
    	position : absolute;
    	border : 2px solid #05224a;
    }
    #adver_img4>img{
    	width : 100%;
    }
     #adver_p4{
    	width  : 110%;
    	height : 50px;
    	color  : white;
    	text-align : center;
    	font-weight : bold;
    	background :rgb(0, 0, 0,0.5);
    	position : relative;
    	top : 72.6%;
    }
   	#adver_p4>label{
   		color : #7ed0e0;
   		font-weight : bold;
   	}
    .font_w{
    	color  :white;
    }
     @media (max-width:1280px){   /*========================== ==========================webBrower 1280px */
          #TicketMain{
     	margin-top : 50px;
        width: 100%;
        height: 700px;
        background : rgb(102, 156, 178,0.0);
      
    }
    #titcketMain{
        display: flex;
       border-radius: 5px;
      
        
    }
    #form1{
        display: flex;
        margin : 0 auto;
        justify-content: center;
        
    }
    #ticket01{
        width: 10%;
        background: #05224a;
        border-radius: 5px;
        border-right-style : dashed;
        border-right : 2px solid white;
    }
    #ticket01 p{
        margin-top : 50px;
        padding: 20px;
        background: #05224a;
		
        box-sizing: border-box;
        color: white;
        font-weight: bold;
        text-align: center;
    }
    #ticket01 i{
        color: white;
        line-height : 50px;
        
    }
    #ticket02{
        background-position: 0 0;
        width: 67%;
         background:#05224a;
        border-radius : 5px;
      
    }
    #ticket02 p{
        font-size: 20px;
        margin-left: 30px;
        font-weight: bold;
        color: white;
        
    }
    
    #oneway1,#twoway1{
        display: inline-block;
        margin-bottom: 20px;
        font-weight: bold;
       color: white;
    }
    
    #oneway1{
        margin-left: 30px;
        
    }
    /*============================================ 출발지, 목적지, 출발일 input ==============================================*/
    #goSpot, #endSpot, #goEndTime{
    	display: inline-block;	
    }
    #goSpot{
        border: 2px solid white;
        border-radius: 5px;
        width: 15%;
        background-color: white;
        vertical-align : bottom;
        position: absolute;
        left : 29.7%;
         top : 25%;
    }
    #goSpot>input{
        border: none;
        height: 30px;
        width: 90%;
        box-sizing: border-box;
       
    }
    #goSpot>i{
        font-size: 24px;
        position: relative;
        top:4px;
        background-color: white;
        cursor: pointer;
      	color : #05224a;
    }
    #endSpot{
        border: 2px solid white;
        border-radius: 5px;
         width: 15%;
        background-color: white;
         position: absolute;
         left : 46.5%;
         top : 25%;
    }
    #endSpot>input{
        border: none;
        height: 30px;
         width: 90%;
        box-sizing: border-box;
    }
    #endSpot>i{
        font-size: 24px;
        position: relative;
        cursor: pointer;
        color : #05224a;
         top:4px;
       
    }
    #goEndTime{
        border: 2px solid white;
        border-radius: 5px;
        width: 15%;
        background-color: white;
         position: absolute;
         left : 63.3%;
         top : 25%;
    }
    #goEndTime>input{
        border: none;
        height: 30px;
         width: 85%;
        box-sizing: border-box;
    }
    #goEndTime>i{
        font-size: 24px;
        position: relative;
       	top: 4px;
        background-color: white;
        cursor: pointer;
        color : #05224a;
    }
    .inputBox{
        cursor: pointer;
        outline: none;
    }
    #user-choi{
        margin-left: 35px;
        margin-top: 10px;
        margin-bottom: 10px;
        font-weight: bold;  
        color: white;
    }
    #user-choi>label{
    	margin-top : 5px;
        margin-right: 25px;
        margin-left: 30px;
    }
    
    #user-choi>label>i{
    	font-size: 15px;
    	cursor: pointer;
    	color : white;
    	maring-top : 20px;
    	margin-left : 5px;
    }
    #select_seet{
        margin-left: 30px;
    }
    #seet_one,#seet_two,#seet_three,.seet_chair,#search_air{
        display: inline-block;
        margin-bottom: 20px;
    }
    #seet_one{
        background-color: white;
        height: 30px;
        box-sizing: border-box;
        border-radius: 5px;
    }
    #seet_two{
        background-color: white;
        height: 30px;
        box-sizing: border-box;
        border-radius: 5px;
    }
    #seet_three{
        background-color: white;
        height: 30px;
        box-sizing: border-box;
        border-radius: 5px;
    }
    #seet_one>input{
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        vertical-align: top;
        height: 100%;
        border: none;
        text-align: center;
        width: 30px;
        line-height: 10px;
    }
    #seet_one>.plma{
        background: white;
        height: 100%;
        border-radius: 5px;
        border: 2px solid white;
        width: 30px;
        color: #05224a;
        font-size: 25px;
    }
    #seet_two>input{
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        vertical-align: top;
        height: 100%;
        border: none;
        text-align: center;
        width: 30px;
        line-height: 10px;
    }
    #seet_two>.plma{
          background: white;
        height: 100%;
        border-radius: 5px;
        border: 2px solid white;
        width: 30px;
        color: #05224a;
        font-size: 25px;
    }
     #seet_three>input{
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        vertical-align: top;
        height: 100%;
        border: none;
        text-align: center;
        width: 30px;
        line-height: 10px; 
    }
    #seet_three>.plma{
        background: white;
        vertical-align : top;
        border-radius: 5px;
        border: 2px solid white;
        width: 30px;
        color: #05224a;
        font-size: 25px;
    }
    .seet_chair{
    	border : 2px solid #05224a;
    	border-radius : 5px;
    	height : 30px;
    	box-sizing : border-box;
    	vertical-align : top;
    }
    #search_air{
        height: 30px;
        vertical-align: top;
        border-radius: 5px;
        color : white;
        border: 2px solid white;
        background: #05224a;
        font-weight : bold;
        box-sizing : border-box;
        cursor : pointer;
    }
    /*============================================ 성인, 소아, 유아 ==============================================*/
    #adultNum, #childNum, #babyNum{
        outline: none;
    }
    /*============================================ +-버튼 ==============================================*/
    .plma{
        cursor: pointer;
    }
    /*============================================ 출발지/목적지 ==============================================*/
    #local{
        position: absolute;
    	background: white;
	
        width: 500px;
        height: 430px;
        display: none;
        margin-right : 50p;
        left : 35%;
        top : 20%;
        border-radius: 5px;
        border : 3px solid black;
        margin-bottom : 20px;
        
    }
    #local>h2{
    	text-align : center;
    }
    #local i{
    	margin-left : 20px;
    	vertical-align: bottom;
    	box-sizing : border-box;
    	color : black;
    }
    #local>p{
    	font-weight : bold;
    	margin-left : 65px;
    	font-size : 25px;
    }
    #local #ul01{
    	width : 100px;
    	font-size : 18px;
    	font-weight : bold;
    	padding : 0;
    	margin-left : 30px;
    	text-align : center;
    	width : 150px;
    	height : 254px;
    	line-height : 50px;
    	background : #05224a;
    }
    #local #ul01>li{
    	padding : 0;
    	text-align : left;
    	color : black;
    	border-bottom : white;
    }
    #local>#ul01>li>a{
    	color : white;
    }
    #local #ul01>li, #local .ul02>li{
        position: relative;
       
    }
    #local .ul02{
        position: absolute;
        display: none;
        left : 150px;
        top : 0px;
        width : 240px;
        font-weight : bold;
        padding : 0;
        box-sizing : border-box;
        background : white;
        border-right : 2px solid black;
        border-top : 2px solid black;
        border-bottom : 2px solid black;
    }
    #local #ul01>li:hover .ul02{
        display: block;
    }
    #local li{
        list-style: none;
    }
    #local li a{
        text-decoration: none;
        color: black;
    }
    /*============================================ 출발일, 가는날/오는날 ==============================================*/
    #gocalender{
        display: none;
        position: absolute;
        background: #05224a;
        border-radius : 5px;
        width: 26%;
        text-align : center;
        left : 36%;
        top : 20%;
         z-index : 20;
    }
    #gocalender>h2{
    	color : white;
    }
    #gocalender>h2>label>i{
    	color : white;
    	margin-left : 10px;
    }
    #gocalender2{
     	display: none;
        position: absolute;
        background: #05224a;
        border-radius : 5px;
        width: 80%;
        text-align : center;
        left : 12%;
        top : 20%;
        z-index : 20;
     }
      #gocalender2>h2{
    	color : white;
    }
     #gocalender2>h2>label>i{
    	color : white;
    	margin-left : 10px;
    }
    #gocalender caption, #gocalender2 caption{
        font-weight: bold;
        font-size: 22px;
        vertical-align : top;
        padding: 10px 0;
        margin-bottom : 10px;
        width : 98%;
    }
    #gocalender th, td, #gocalender2 th, td{
        width: 50px;
        height: 35px;
        text-align: center;
    }
    #gocalender td, #gocalender2 td{
        height: 40px;
    }
    #gocalender th, #gocalender2 th{
        background: #05224a;
        color : white;
    }
    #gocalender th:first-of-type, #gocalender2 th:first-of-type{
        background: #ff4242;
        color: white;
    }
    #gocalender th:last-of-type, #gocalender2 th:last-of-type{
        background: #3e3eff;
        color: white;
    }
    #gocalender td:first-of-type, #gocalender2 td:first-of-type{
        color: #ff4242; /* 빨간색 */
        font-weight: bold;
 	}
    #gocalender .td06:last-of-type, #gocalender2 .td06:last-of-type{
        color: #3e3eff; /* 파란색 */
        font-weight: bold;
    }
    #gocalender #btn1, #btn2, #gocalender2 #btn3, #btn4, #btn5, #btn6{
        position: absolute;
        width: 65px;
        padding: 4px 0;
        background: lightgray;
        background: #f1fcff;
        border: none;
        border-radius: 5px;
        font-size : 15px;
    }
    .clickTd{
    	background: white;
        font-weight : bold;
    	cursor : pointer
    }
    #gocalender #btn1{
        top: 29%;
        left: 5%;
        background :#05224a;
        color : white;
        font-size : 14px;
        border-radius : 5px;
        font-weight : bold;
    }
    #gocalender #btn2{
        top: 29%;
        left: 72%;
        background : #05224a;
        color : white;
        border-radius : 5px;
        font-weight : bold;
    }
    #gocalender2 #btn3{
        top: 32%;
        left: 12%;
        background : #05224a;
        color : white;
        border-radius : 5px;
        font-weight : bold;
    }
    #gocalender2 #btn4{
        top: 32%;
        left: 39%;
        background : #05224a;
        color : white;
        border-radius : 5px;
        font-weight : bold;
    }
    #gocalender2 #btn5{
        top: 32%;
        left: 53%;
        background : #05224a;
        color : white;
        border-radius : 5px;
        font-weight : bold;
    }
    #gocalender2 #btn6{
        top: 32%;
        left: 81%;
        background : #05224a;
        color : white;
        border-radius : 5px;
        font-weight : bold;
    }
    #gocalender #calender, #gocalender2 #calender{
        margin-top: 10px;
    }
    #calen01, #calen02{
        display: inline-block;
    }
    #gocalender2 #calen01{
        width: 400px;
    }
    #gocalender2 #calen02{
        width:400px;
    }
    .tdGray{
        background: #dfdfdf;
        font-weight : bold;
    }
    #calender{
    	margin-left : 20px;
    	margin-bottom : 50px;
    	border : 2px solid black;
    	background : white;
    	border-radius : 6px;
    	width : 85%;
    }
    #calender1{
    	margin-bottom : 50px;
    	border : 2px solid black;
    	border-radius : 6px;
    	margin-left : 5px;
    	background : white;

    }
    #calender2{
    	margin-bottom : 50px;
    	border : 2px solid black;
    	border-radius : 6px;
    	margin-left : 5px;
    	background : white;

    }
    /*============================================ 소아/유아 안내 ==============================================*/
    #childPop{
        width: 850px;
        position: absolute;
        background: #05224a;
        display: none;
        text-align : center;
        color : white;
        border : 3px solid black;
        border-radius : 5px;
        left : 25%;
        top : 20%;
    }
    #childPop table{
    	margin : 0 auto;
        border-collapse: collapse;
        width: 90%;
        margin-bottom : 20px;
        border : 3px solid black;
        border-radius : 5px;
        background : white;
    }
    #childPop th{
    	background : #05224a;
    	height : 70px;
    	color : white;
    }
    #childPop td:first-child{
    	background : #dfdfdf;
    	font-weight : bold;
    }
    #childPop>h2>i{
    	color : white;
    	margin-left : 30px;
    }
   /* 광고 */
    #advertising_contents{
    	width : 100%;
    	height : 400px;
    	margin : 0 auto;
    	margin-top : 20px;
    	margin-bottom : 20px;
    }
    #advertising_contents>h2{
    	color  : #05224a;
    	width : 75%;
    	margin : 0 auto;
    	margin-bottom : 30px;
    }
     #advertising_contents>h2>label{
     	color :    #cb1c5f;
     	font-size : 30px;
     }
    #adver_center{
    	width : 74%;
    	margin: 0 auto;
    	height : 400px;
    	display : flex;
    	justify-content: space-between;
    }
    #advertising1{
    	width : 19.5%;
    	height : 292px;
    }
    #adver_img1{
    	width : 15%;
    	height : 235px;
    	position : absolute;
    	border : 2px solid #05224a;
    }
    #adver_img1>img{
    	width : 100%;
    }
     #adver_p1{
    	width  : 130%;
    	height : 50px;
    	color  : white;
    	text-align : center;
    	font-weight : bold;
    	background :rgb(0, 0, 0,0.5);
    	position : relative;
    	top : 64.5%;
    }
   	#adver_p1>label{
   		color : #7ed0e0;
   		font-weight : bold;
   	}
    #advertising2{
    	width : 19.5%;
    	height : 292px;
    }
     #adver_img2{
    	width : 15%;
    	height : 235px;
    	position : absolute;
    	border : 2px solid #05224a;
    }
    #adver_img2>img{
    	width : 100%;
    }
     #adver_p2{
    	width  : 130%;
    	height : 50px;
    	color  : white;
    	text-align : center;
    	font-weight : bold;
    	background :rgb(0, 0, 0,0.5);
    	position : relative;
    	top : 64.5%;
    }
   	#adver_p2>label{
   		color : #7ed0e0;
   		font-weight : bold;
   	}
    #advertising3{
    	width : 19.5%;
    	height : 292px;
    }
     #adver_img3{
    	width : 15%;
    	height : 235px;
    	position : absolute;
    	border : 2px solid #05224a;
    }
    #adver_img3>img{
    	width : 100%;
    }
     #adver_p3{
    	width  : 130%;
    	height : 50px;
    	color  : white;
    	text-align : center;
    	font-weight : bold;
    	background :rgb(0, 0, 0,0.5);
    	position : relative;
    	top : 64.5%;
    }
   	#adver_p3>label{
   		color : #7ed0e0;
   		font-weight : bold;
   	}
   	 #advertising4{
    	width : 19.5%;
    	height : 292px;
    }
     #adver_img4{
    	width : 15%;
    	height : 235px;
    	position : absolute;
    	border : 2px solid #05224a;
    }
    #adver_img4>img{
    	width : 100%;
    }
     #adver_p4{
    	width  : 130%;
    	height : 50px;
    	color  : white;
    	text-align : center;
    	font-weight : bold;
    	background :rgb(0, 0, 0,0.5);
    	position : relative;
    	top : 64.5%;
    }
   	#adver_p4>label{
   		color : #7ed0e0;
   		font-weight : bold;
   	}
    .font_w{
    	color  :white;
    }
        }
</style>
</head>
<body>
<div id="TicketMain">
	<form id="form1" action="ticketList" method="post" onsubmit="return reserve()">
	    <div id="ticket01">
	        <p><i class="fas fa-plane-departure"></i><br>항공권</p>
	    </div>
	    <div id="ticket02">
	        <p>예매</p>
	        <div id="oneway1"><input type="radio" name="go" id="oneway" value="1" onclick="Go(1)" checked>편도</div>
	        <div id="twoway1"><input type="radio" name="go" id="twoway" value="2" onclick="Go(2)">왕복</div><br>
	        <div id="goSpot"><input id="startPoint" class="inputBox" type="text" name="startPoint" placeholder="출발지" onclick="goLocal(1)" readonly><i class="fas fa-map-marker-alt icon" onclick="goLocal(1)"></i></div>
	        <div id="endSpot"><input id="endPoint" class="inputBox" type="text" name="endPoint" placeholder="목적지" onclick="goLocal(2)" readonly><i class="fas fa-map-marker-alt icon" onclick="goLocal(2)"></i></div>
	        <div id="goEndTime"><input id="day" class="inputBox" type="text" name="startGo" placeholder="출발일(YYYY-MM-DD)" onclick="gocalen(0)" readonly><i class="fas fa-calendar-alt icon" onclick="gocalen(0)"></i><br></div>
	        <input type="hidden" id="goway" name="goway"><br>
	        <div id="user-choi">
		        <label>성인</label>
		        <label>소아<i class="fas fa-question-circle icon" onclick="childinfo()"></i></label>
		        <label>유아<i class="fas fa-question-circle icon" onclick="childinfo()"></i></label>
		        <label>좌석등급</label>
	        </div>
	        <div id="select_seet">
		        <div id="seet_one">
			        <input class="plma" type="button" value="-" onclick="adultPlma(-1)">
			        <input id="adultNum" type="text" name="adult" value="1" readonly="readonly">
			        <input class="plma" type="button" value="+" onclick="adultPlma(+1)">
		        </div>
		        <div id="seet_two">
			        <input class="plma" type="button" value="-" onclick="childPlma(-1)">
			        <input id="childNum" type="text" name="child" value="0" readonly="readonly">
			        <input class="plma" type="button" value="+" onclick="childPlma(+1)">
		        </div>
		        <div id="seet_three">
			        <input class="plma" type="button" value="-" onclick="babyPlma(-1)">
			        <input id="babyNum" type="text" name="baby" value="0" readonly="readonly">
			        <input class="plma" type="button" value="+" onclick="babyPlma(+1)">
		        </div>
		        <select class="seet_chair"" name="rank" >
		            <option value="1">이코노믹(일반)석</option>
		            <option value="2">비지니스석</option>
		            <option value="3">일등석</option>
		        </select>
		        <input type="submit" value="항공편 조회" id="search_air">
			</div>
	    </div>
    </form>
    <!-- ================================================ 광고 배너 ============================================ -->
	 <div id="advertising_contents">
	 		<h2>AIR Light 만의 항공권 특가  <label>EVENT</label> </h2>
	 		<div id="adver_center">
	 				<div id="advertising1">
	 					<div id="adver_img1"><img alt="" src="resources/img/la.jpg"></div>
	 					<div id="adver_p1">서울/인천 - 로스앤젤레스<br><label>KRW 972,000부터</label></div>
	 				</div>
	 				<div id="advertising2">
	 					<div id="adver_img2"><img alt="" src="resources/img/new-york.jpg"></div>
	 					<div id="adver_p2">서울/인천 - 뉴욕<br><label>KRW 756,000부터</label></div>
	 				</div>
	 				<div id="advertising3">
	 					<div id="adver_img3"><img alt="" src="resources/img/japen.jpg"></div>
	 					<div id="adver_p3">서울/인천 - 도교<br><label>KRW 280,800부터</label></div>
	 				</div>
	 				<div id="advertising4">
	 					<div id="adver_img4"><img alt="" src="resources/img/nago.jpg"></div>
	 					<div id="adver_p4">서울/인천 - 나고야<br><label>KRW 318,600부터</label></div>
	 				</div>
	 		</div>
	 </div>   
    
    <!-- ================================================ 출발지/도착지 선택 ============================================ -->
    <div id="local">
        <h2>지역과 도시를 선택하여 주십시오.<label><i class="fas fa-times icon" onclick="back()"></i></label></h2>
        <p>지역</p>
        <ul id="ul01">
        <c:set var="i" value="1" />
        	<c:forEach var="countryList" items="${countryList}">
        		<li><a href="#">${countryList.country_name}</a>
	                <ul class="ul02">
	                	<li>
	                		<a href="#" id="${i}" onclick="airport(${i})">${countryList.country_name}, 모든 공항</a>
	                	</li>
	                	<c:set var="i" value="${i+1}" />
	                	<c:forEach var="planeList" items="${planeList}">
	                		<c:if test="${countryList.country_code==planeList.country_code}">
	                			<li><a href="#" id="${i}" onclick="airport(${i})">${planeList.port_name}</a></li>
	                			<c:set var="i" value="${i+1}" />
	                		</c:if>
	                    </c:forEach>
	                </ul>
	            </li>
        	</c:forEach>
        </ul>
    </div>
    
    <!-- ================================================ 출발일 선택 ============================================ -->
    <div id="gocalender">
        <h2>날짜를 선택하여 주십시오.<label><i class="fas fa-times icon" onclick="back()"></i></label></h2>
        <h4 class="font_w">출발일</h4>
        <div>
            <button id="btn1" onclick="calend(-1);">&#60 이전 달</button>
            <button id="btn2" onclick="calend(1);">다음 달 &#62</button>
        </div>
        <div id="calender"></div>
    </div>
    <!-- ================================================ 가는날/오는날 선택 ============================================ -->
    <div id="gocalender2">
        <h2>날짜를 선택하여 주십시오.<label><i class="fas fa-times icon" onclick="back()"></i></label></h2>
        <div id="calen01">
            <h4 class="font_w">가는날</h4>
            <div>
                <button id="btn3" onclick="calend1(-1);">&#60 이전 달</button>
                <button id="btn4" onclick="calend1(1);">다음 달 &#62</button>
            </div>
            <div id="calender1"></div>
        </div>
        <div id="calen02">
            <h4 class="font_w">오는날</h4>
            <div>
                <button id="btn5" onclick="calend2(-1);">&#60 이전 달</button>
                <button id="btn6" onclick="calend2(1);">다음 달 &#62</button>
            </div>
            <div id="calender2"></div>
        </div>
    </div>
    
    <!-- ================================================ 소유/유아 안내 ============================================ -->
    <div id="childPop">
       <h2>소아/유아 안내<i class="fas fa-times icon" onclick="back()"></i></h2>
        <table border="1">
            <tr>
                <th></th>
                <th>소아</th>
                <th>유아</th>
            </tr>
            <tr>
                <td>적용대상</td>
                <td>
                    <ul>
                        <li>국제선:만 2세 이상 12세 미만</li>
                        <li>국내선:만 2세 이상 13세 미만</li>
                    </ul>
                </td>
                <td>만 2세(24개월) 미만</td>
            </tr>
            <tr>
                <td>기준</td>
                <td>첫번째 항공편 출발일 기준</td>
                <td>각 항공편 탑승일 기준</td>
            </tr>
            <tr>
                <td>유의사항</td>
                <td>만 18세 이상(국내선은 13세)의 보호자와 동일 클래스 동반 탑승 필요 (불가 시, 비동반 소아 서비스 신청 필수)</td>
                <td>
                    <ul>
                        <li>반드시 성인과 함께 예약 필요</li>
                        <li>별도 좌석 미제공</li>
                        <li>별도 좌석 원하시는 경우 "소아" 선택하여 소아운임으로 예매하여 주시기 바랍니다.</li>
                    </ul>
                </td>
            </tr>
        </table>
    </div>

</div>
<script src="https://code.jquery.com/jquery-2.2.1.js"></script>
<script>

	var local = document.getElementById("local");
	var header = document.getElementById("header");
	var footer = document.getElementById("footer");
	var advertising_contents = document.getElementById("advertising_contents");
    var day = document.getElementById("day");
    var childPop = document.getElementById("childPop"); // 소아/유아
    var goway = document.getElementById("goway");
    var way = 1; // 1:편도, 2:왕복
    goway.value = way;
    
    // 편도, 왕복 선택
    function Go(num){
        if(num==1){
            day.placeholder = "출발일(YYYY-MM-DD)";
            day.value="";
            way = 1;
            goway.value = way;
            gocalender.style.display = "none";
            gocalender2.style.display = "none";
            local.style.display = "none";
            childPop.style.display = "none";
            header.style.opacity = "1";
            footer.style.opacity = "1";
            ticket01.style.opacity = "1";
            ticket02.style.opacity = "1";
            advertising_contents.style.opacity = "1";
        }else{
            day.placeholder = "가는 날/오는 날(YYYY-MM-DD)";
            day.value="";
            way = 2;
            goway.value = way;
            gocalender.style.display = "none";
            gocalender2.style.display = "none";
            local.style.display = "none";
            childPop.style.display = "none";
            header.style.opacity = "1";
            footer.style.opacity = "1";
            ticket01.style.opacity = "1";
            ticket02.style.opacity = "1";
            advertising_contents.style.opacity = "1";
        }
    }
    
    // 영역 밖
    /* $('html').click(function(e) { 
    	if(!$(e.target).hasClass("area")) { 
    		local.style.display = "block";
    		gocalender.style.display = "none";
            gocalender2.style.display = "none";
    		header.style.opacity = "1";
            footer.style.opacity = "1";
            ticket01.style.opacity = "1";
            ticket02.style.opacity = "1";
            advertising_contents.style.opacity = "1";
    	} 
    });  */
    
    var ticket01 = document.getElementById("ticket01");
    var ticket02 = document.getElementById("ticket02");
    
    var gocnt = 1; //1: 출발지, 2: 목적지
    
    // 출발지, 목적지 보여주기
    function goLocal(num){
        if(local.style.display == "block"){
           local.style.display = "none";
           header.style.opacity = "1";
           footer.style.opacity = "1";
           ticket01.style.opacity = "1";
           ticket02.style.opacity = "1";
           advertising_contents.style.opacity = "1"
           gocalender.style.display = "none";
           gocalender2.style.display = "none";
           childPop.style.display = "none";
        }else{
            local.style.display = "block";
            header.style.opacity = "0.1";
            footer.style.opacity = "0.1";
            ticket01.style.opacity = "0.1";
            ticket02.style.opacity = "0.1";
            advertising_contents.style.opacity = "0.1";
            gocalender.style.display = "none";
            gocalender2.style.display = "none";
            childPop.style.display = "none";
            
        }
        gocnt = num;
    }
    
    // x누르면 사라짐 
    function back(){
        local.style.display = "none";
        gocalender.style.display = "none";
        gocalender2.style.display = "none";
        childPop.style.display = "none";
        header.style.opacity = "1";
        footer.style.opacity = "1";
        ticket01.style.opacity = "1";
        ticket02.style.opacity = "1";
        advertising_contents.style.opacity = "1";
    }
    
    var startPoint = document.getElementById("startPoint");
    var endPoint = document.getElementById("endPoint");
    
    // 출발지랑 목적지에 값 넣기
    function airport(plane){
        var point = document.getElementById(plane);
        if(gocnt==1){
            startPoint.value = point.innerHTML;
        }else{
            endPoint.value = point.innerHTML;
        }
        local.style.display = "none";
        header.style.opacity = "1";
        footer.style.opacity = "1";
        ticket01.style.opacity = "1";
        ticket02.style.opacity = "1";
        advertising_contents.style.opacity = "1";
    }
    
    // 캘린더
    var gocalender = document.getElementById("gocalender");
    var gocalender2 = document.getElementById("gocalender2");
    
    var mo = new Date().getMonth()+1; // 현재 월
    var ye = new Date().getFullYear(); // 현재 년도
    var mon = new Date().getMonth()+1; // 현재 월
    var yea = new Date().getFullYear(); // 현재 년도
    var monn = new Date().getMonth()+1; // 현재 월
    var yeaa = new Date().getFullYear(); // 현재 년도
    
    var mymon = mon; // 계속 기억되는 현재 월
    var myear = yea; // 계속 기억되는 현재 년
    var myday = new Date().getDate(); // 계속 기억되는 현재 날
    
    var nextYear = myear; // 7일 후의 년도
    var nextMon = mymon; // 7일 후의 달
    var nextDay = myday+6;  // 7일 후의 날 35 
    var lastDay = new Date(yea, mymon, 0); 
    var lastDay01 = lastDay.getDate(); // 현재 달의 마지막 날 30
    if(lastDay01<nextDay){
    	nextDay = nextDay-lastDay01; // 5
    	nextMon = nextMon+1;
    	if(nextMon>12){
    		nextMon = 1;
    		nextYear = nextYear+1;
    	}
    }
    console.log("nextYear: " + nextYear);
    console.log("nextMon: " + nextMon);
    console.log("lastDay01: " + lastDay01);
    console.log("nextDay: " + nextDay); 
    console.log("mymon: " + mymon);
    console.log("myear: " + myear);
    console.log("myday: " + myday);
    
    // 캘린더 클릭
    function gocalen(m){
        console.log(way);
        if(way==1){
            if(gocalender.style.display == "block"){
               gocalender.style.display = "none";
               local.style.display = "none";
               gocalender2.style.display = "none";
               childPop.style.display = "none";
               header.style.opacity = "1";
               footer.style.opacity = "1";
               ticket01.style.opacity = "1";
               ticket02.style.opacity = "1";
               advertising_contents.style.opacity = "1";
            }else{
                gocalender.style.display = "block";
                gocalender2.style.display = "none";
                local.style.display = "none";
                childPop.style.display = "none";
                header.style.opacity = "0.1";
                footer.style.opacity = "0.1";
                ticket01.style.opacity = "0.1";
                ticket02.style.opacity = "0.1";
                advertising_contents.style.opacity = "0.1";
            
                calend(m);
            }
        }else{
            if(gocalender2.style.display == "block"){
               gocalender2.style.display = "none";
               local.style.display = "none";
               gocalender.style.display = "none";
               header.style.opacity = "1";
               footer.style.opacity = "1";
               ticket01.style.opacity = "1";
               ticket02.style.opacity = "1";
               advertising_contents.style.opacity = "1";
            }else{
                gocalender2.style.display = "block";
                local.style.display = "none";
                gocalender.style.display = "none";
                header.style.opacity = "0.1";
                footer.style.opacity = "0.1";
                ticket01.style.opacity = "0.1";
                ticket02.style.opacity = "0.1";
                advertising_contents.style.opacity = "0.1";
                calend1(m);
                calend2(m);
            }
        }
    }
    
    // 출발지 캘린더
    function calend(mon2){
        if(mo==1 && mon2==-1){ //2019년 12월로 가기
            mo=13;
            ye += mon2;
        }else if(mo==12 && mon2==1){ //2021년 1월로 가기
            mo=0;  
            ye += mon2;
        }
        console.log(mon);
        var td = "<table>"
        td += "<caption>" + ye + "년 " + (mo+mon2) + "월</caption>";
        var we = ["일", "월", "화", "수", "목", "금", "토"];
        for(var i=0; i<we.length; i++){
            td += "<th>" + we[i] + "</th>";
        }
        var lastday0 = new Date(ye, (mo+mon2), 0); //현재월의 마지막 날
        var startday0 = new Date(ye, ((mo+mon2)-1)); //현재월의 첫번째 날 요일
        mo = mo + mon2;
        var lastday = lastday0.getDate(); //현재월의 마지막 날
        var startday = startday0.getDay(); //현재월의 첫번째 날 요일
        var cnt = 1; //날짜(1~31)세는 체크키
        var cnt2 = 0; //7일(0~6)세는 체크키
        while(cnt<=lastday){
            td += "<tr>";
            for(var i=0; i<we.length; i++){
                
                if(cnt<=lastday){
                    if(cnt==1){
                        for(var j=0; j<startday; j++){
                            td += "<td></td>";
                            cnt2++;
                        }
                        if(cnt2==6){
                            if(ye<=myear && mo<=mymon && cnt<myday || ye<=myear && mo<mymon && cnt<32 || ye<myear ||  mo>nextMon || ye>nextYear || ye==nextYear && mo==nextMon && cnt>nextDay){
                                td += "<td class='tdGray td06' onclick='goDate(this)'>" + cnt + "</td>";
                                cnt++;    
                                cnt2++;
                            }else{
                                td += "<td class='clickTd td06' onclick='goDate(this)'>" + cnt + "</td>";
                                cnt++;    
                                cnt2++;
                            }       
                        }else{
                            if(ye<=myear && mo<=mymon && cnt<myday || ye<=myear && mo<mymon && cnt<32 || ye<myear ||  mo>nextMon || ye>nextYear || ye==nextYear && mo==nextMon && cnt>nextDay){
                                td += "<td class='tdGray' onclick='goDate(this)'>" + cnt + "</td>";
                                cnt++;    
                                cnt2++; 
                            }else{
                                td += "<td class='clickTd' onclick='goDate(this)'>" + cnt + "</td>";
                                cnt++;    
                                cnt2++; 
                            } 
                        }
                    }else{
                        if(cnt2==7){
                           break;
                        }else{
                            if(cnt2==6){
                                if(ye<=myear && mo<=mymon && cnt<myday || ye<=myear && mo<mymon && cnt<32 || ye<myear || mo>nextMon || ye>nextYear || ye==nextYear && mo==nextMon && cnt>nextDay){
                                    td += "<td class='tdGray td06' onclick='goDate(this)'>" + cnt + "</td>"; 
                                }else{
                                    td += "<td class='clickTd td06' onclick='goDate(this)'>" + cnt + "</td>";
                                } 
                            }else{
                                if(ye<=myear && mo<=mymon && cnt<myday || ye<=myear && mo<mymon && cnt<32 || ye<myear || mo>nextMon || ye>nextYear || ye==nextYear && mo==nextMon && cnt>nextDay){
                                    td += "<td class='tdGray' onclick='goDate(this)'>" + cnt + "</td>";
                                }else{
                                    td += "<td class='clickTd' onclick='goDate(this)'>" + cnt + "</td>";
                                } 
                            }
                            cnt++; 
                            cnt2++;
                        }
                    }
                }else{
                    break;
                }
            } 
            cnt2=0;
            td += "</tr>";
        }
        td += "</table>";
        calender.innerHTML = td;
    }
    
    // 가는날 오는날 왼쪽 캘린더
    function calend1(mon2){
        if(mon==1 && mon2==-1){ //2019년 12월로 가기
            mon=13;
            yea += mon2;
        }else if(mon==12 && mon2==1){ //2021년 1월로 가기
            mon=0;  
            yea += mon2;
        }
        console.log(mon);
        var td = "<table>"
        td += "<caption>" + yea + "년 " + (mon+mon2) + "월</caption>";
        var we = ["일", "월", "화", "수", "목", "금", "토"];
        for(var i=0; i<we.length; i++){
            td += "<th>" + we[i] + "</th>";
        }
        var lastday0 = new Date(yea, (mon+mon2), 0); //현재월의 마지막 날
        var startday0 = new Date(yea, ((mon+mon2)-1)); //현재월의 첫번째 날 요일
        mon = mon + mon2;
        var lastday = lastday0.getDate(); //현재월의 마지막 날
        var startday = startday0.getDay(); //현재월의 첫번째 날 요일
        var cnt = 1; //날짜(1~31)세는 체크키
        var cnt2 = 0; //7일(0~6)세는 체크키
        var checkCon = 0;
        while(cnt<=lastday){
            td += "<tr>";
            for(var i=0; i<we.length; i++){
                
                if(cnt<=lastday){
                    if(cnt==1){
                        for(var j=0; j<startday; j++){
                            td += "<td></td>";
                            cnt2++;
                        }
                        if(cnt2==6){
                            if(yea<=myear && mon<=mymon && cnt<myday || yea<=myear && mon<mymon && cnt<32 || yea<myear || mon>nextMon || yea>nextYear || yea==nextYear && mon==nextMon && cnt>nextDay){
                                td += "<td class='tdGray td06' onclick='goDate1(this)'>" + cnt + "</td>";
                                cnt++;    
                                cnt2++;
                            }else{
                                td += "<td class='clickTd td06' onclick='goDate1(this)'>" + cnt + "</td>";
                                cnt++;    
                                cnt2++;
                            }       
                        }else{
                            if(yea<=myear && mon<=mymon && cnt<myday || yea<=myear && mon<mymon && cnt<32 || yea<myear || mon>nextMon || yea>nextYear || yea==nextYear && mon==nextMon && cnt>nextDay){
                                td += "<td class='tdGray' onclick='goDate1(this)'>" + cnt + "</td>";
                                cnt++;    
                                cnt2++; 
                            }else{
                                td += "<td class='clickTd' onclick='goDate1(this)'>" + cnt + "</td>";
                                cnt++;    
                                cnt2++; 
                            } 
                        }
                    }else{
                        if(cnt2==7){
                           break;
                        }else{
                            if(cnt2==6){
                                if(yea<=myear && mon<=mymon && cnt<myday || yea<=myear && mon<mymon && cnt<32 || yea<myear || mon>nextMon || yea>nextYear || yea==nextYear && mon==nextMon && cnt>nextDay){
                                    td += "<td class='tdGray td06' onclick='goDate1(this)'>" + cnt + "</td>"; 
                                }else{
                                    td += "<td class='clickTd td06' onclick='goDate1(this)'>" + cnt + "</td>";
                                } 
                            }else{
                                if(yea<=myear && mon<=mymon && cnt<myday || yea<=myear && mon<mymon && cnt<32 || yea<myear || mon>nextMon || yea>nextYear || yea==nextYear && mon==nextMon && cnt>nextDay){
                                    td += "<td class='tdGray' onclick='goDate1(this)'>" + cnt + "</td>";
                                }else{
                                    td += "<td class='clickTd' onclick='goDate1(this)'>" + cnt + "</td>";
                                } 
                            }
                            cnt++; 
                            cnt2++;
                        }
                    }
                }else{
                    break;
                }
            } 
            cnt2=0;
            td += "</tr>";
        }
        td += "</table>";
        calender1.innerHTML = td;
    }
    
    var goTime = ""; // 가는날/오는날 출력
    var goYea = 0; // 가는날 년도
    var goMon = 0; // 가는날 달
    var goCnt = 0; // 가는날 날짜
    
    // 가는날 오는날 오른쪽 캘린더
    function calend2(mon2){
        if(monn==1 && mon2==-1){ //2019년 12월로 가기
            monn=13;
            yeaa += mon2;
        }else if(monn==12 && mon2==1){ //2021년 1월로 가기
            monn=0;  
            yeaa += mon2;
        }
        console.log(monn);
        var td = "<table>"
        td += "<caption>" + yeaa + "년 " + (monn+mon2) + "월</caption>";
        var we = ["일", "월", "화", "수", "목", "금", "토"];
        for(var i=0; i<we.length; i++){
            td += "<th>" + we[i] + "</th>";
        }
        var lastday0 = new Date(yeaa, (monn+mon2), 0); //현재월의 마지막 날
        var startday0 = new Date(yeaa, ((monn+mon2)-1)); //현재월의 첫번째 날 요일
        monn = monn + mon2;
        var lastday = lastday0.getDate(); //현재월의 마지막 날
        var startday = startday0.getDay(); //현재월의 첫번째 날 요일
        var cnt = 1; //날짜(1~31)세는 체크키
        var cnt2 = 0; //7일(0~6)세는 체크키
        console.log("goYea: " + goYea);
        console.log("goMon: " + goMon);
        console.log("goCnt: " + goCnt);
        while(cnt<=lastday){
            td += "<tr>";
            for(var i=0; i<we.length; i++){
                
                if(cnt<=lastday){
                    if(cnt==1){
                        for(var j=0; j<startday; j++){
                            td += "<td></td>";
                            cnt2++;
                        }
                        if(cnt2==6){
                            if(yeaa<=myear && monn<=mymon && cnt<myday || yeaa<=myear && monn<mymon && cnt<32 || yeaa<myear || goYea!=0 && goMon!=0 && goCnt!=0 && yeaa<=goYea && monn<=goMon && cnt<goCnt || yeaa<=goYea && monn<goMon && cnt<32 || yeaa<goYea || monn>nextMon || yeaa>nextYear || yeaa==nextYear && monn==nextMon && cnt>nextDay){
                                td += "<td class='tdGray td06' onclick='goDate2(this)'>" + cnt + "</td>";
                                cnt++;    
                                cnt2++;
                            }else{
                                td += "<td class='clickTd td06' onclick='goDate2(this)'>" + cnt + "</td>";
                                cnt++;    
                                cnt2++;
                            }       
                        }else{
                            if(yeaa<=myear && monn<=mymon && cnt<myday || yeaa<=myear && monn<mymon && cnt<32 || yeaa<myear || goYea!=0 && goMon!=0 && goCnt!=0 && yeaa<=goYea && monn<=goMon && cnt<goCnt || yeaa<=goYea && monn<goMon && cnt<32 || yeaa<goYea || monn>nextMon || yeaa>nextYear || yeaa==nextYear && monn==nextMon && cnt>nextDay){
                                td += "<td class='tdGray' onclick='goDate2(this)'>" + cnt + "</td>";
                                cnt++;    
                                cnt2++; 
                            }else{
                                td += "<td class='clickTd' onclick='goDate2(this)'>" + cnt + "</td>";
                                cnt++;    
                                cnt2++; 
                            } 
                        }
                    }else{
                        if(cnt2==7){
                           break;
                        }else{
                            if(cnt2==6){
                                if(yeaa<=myear && monn<=mymon && cnt<myday || yeaa<=myear && monn<mymon && cnt<32 || yeaa<myear || goYea!=0 && goMon!=0 && goCnt!=0 && yeaa<=goYea && monn<=goMon && cnt<goCnt || yeaa<=goYea && monn<goMon && cnt<32 || yeaa<goYea || monn>nextMon || yeaa>nextYear || yeaa==nextYear && monn==nextMon && cnt>nextDay){
                                    td += "<td class='tdGray td06' onclick='goDate2(this)'>" + cnt + "</td>"; 
                                }else{
                                    td += "<td class='clickTd td06' onclick='goDate2(this)'>" + cnt + "</td>";
                                } 
                            }else{
                                if(yeaa<=myear && monn<=mymon && cnt<myday || yeaa<=myear && monn<mymon && cnt<32 || yeaa<myear || goYea!=0 && goMon!=0 && goCnt!=0 && yeaa<=goYea && monn<=goMon && cnt<goCnt || yeaa<=goYea && monn<goMon && cnt<32 || yeaa<goYea || monn>nextMon || yeaa>nextYear || yeaa==nextYear && monn==nextMon && cnt>nextDay){
                                    td += "<td class='tdGray' onclick='goDate2(this)'>" + cnt + "</td>";
                                }else{
                                    td += "<td class='clickTd' onclick='goDate2(this)'>" + cnt + "</td>";
                                } 
                            }
                            cnt++; 
                            cnt2++;
                        }
                    }
                }else{
                    break;
                }
            } 
            cnt2=0;
            td += "</tr>";
        }
        td += "</table>";
        calender2.innerHTML = td;
    }
    
    // 편도 출발일 출력
    function goDate(cnt){
        if(ye<=myear && mo<=mymon && cnt.innerHTML<myday || ye<=myear && mo<mymon && cnt.innerHTML<32 || ye<myear ||  mo>nextMon || ye>nextYear || ye==nextYear && mo==nextMon && cnt.innerHTML>nextDay){
           alert("예매 불가능한 날입니다.");
        }else{
            day.value = ye + "-" + mo + "-" + cnt.innerHTML;
            gocalender.style.display = "none";
            header.style.opacity = "1";
            footer.style.opacity = "1";
            ticket01.style.opacity = "1";
            ticket02.style.opacity = "1";
            advertising_contents.style.opacity = "1";
        }
    }
    
    // 왕복 가는날 출력
    function goDate1(cnt){
    	/* var chkCon = document.getElementById("chkCon"+cnt); */
    	/* console.log(chkCon); */
        goTime = "";
        goYea = 0;
        goMon = 0;
        goCnt = 0;
        
        if(yea<=myear && mon<=mymon && cnt.innerHTML<myday || yea<=myear && mon<mymon && cnt.innerHTML<32 || yea<myear || mon>nextMon || yea>nextYear || yea==nextYear && mon==nextMon && cnt.innerHTML>nextDay){
           alert("예매 불가능한 날입니다.");
        }else{
            goTime = yea + "-" + mon + "-" + cnt.innerHTML;
            goYea = yea;
            goMon = mon;
            goCnt = cnt.innerHTML;
            /* chkCon.style.backgroundColor = "pink"; // 클릭한 날짜 */
            console.log(goTime);
            calend2(0); // 왕복 가는날에서 날짜를 선택하면 오는날에서 이전날짜 블라인드 처리
        }
    }
    
    // 왕복 오는날 출력
    function goDate2(cnt){
        if(yeaa<=myear && monn<=mymon && cnt.innerHTML<myday || yeaa<=myear && monn<mymon && cnt.innerHTML<32 || yeaa<myear || goYea!=0 && goMon!=0 && goCnt!=0 && yeaa<=goYea && monn<=goMon && Number(cnt.innerHTML)<goCnt || yeaa<=goYea && monn<goMon && (cnt.innerHTML)<32 || yeaa<goYea || monn>nextMon || yeaa>nextYear || yeaa==nextYear && monn==nextMon && cnt.innerHTML>nextDay){
           alert("예매 불가능한 날입니다.");
        }else if(goYea==0 && goMon==0 && goCnt==0){
            alert("가는날을 먼저 선택해주세요.");     
        }else{
            goTime = goTime + "/" + yeaa + "-" + monn + "-" + cnt.innerHTML;
            day.value = goTime;
            gocalender2.style.display = "none";
            header.style.opacity = "1";
            footer.style.opacity = "1";
            ticket01.style.opacity = "1";
            ticket02.style.opacity = "1";
            advertising_contents.style.opacity = "1";
            goTime = "";
            goYea = 0;
            goMon = 0;
            goCnt = 0;
        }
    }
    
    // 소아/유아 info
    function childinfo(){
        if(childPop.style.display == "block"){
           childPop.style.display = "none";
           local.style.display = "none";
           gocalender.style.display = "none";
           gocalender2.style.display = "none";
           header.style.opacity = "1";
           footer.style.opacity = "1";
           ticket01.style.opacity = "1";
           ticket02.style.opacity = "1";
           advertising_contents.style.opacity = "1";
        }else{
           childPop.style.display = "block";
           local.style.display = "none";
           gocalender.style.display = "none";
           gocalender2.style.display = "none";
           header.style.opacity = "0.1";
           footer.style.opacity = "0.1";
           ticket01.style.opacity = "0.1";
           ticket02.style.opacity = "0.1";
           advertising_contents.style.opacity = "0.1";
        }
    }
    
    var adultNum = document.getElementById("adultNum");
    var childNum = document.getElementById("childNum");
    var babyNum = document.getElementById("babyNum");
    var totalNum = 1; // 총 예매수
    
    // 성인 +-
    function adultPlma(num){
        if(num == -1 && adultNum.value == 0){
           adultNum.value = 0;
        }else{
            totalNum = totalNum + parseInt(num);
            console.log(totalNum);
            if(totalNum>5){
               alert("5장 이상 구매할 수 없습니다.");
                totalNum = totalNum + -1;
            }else if(totalNum>5 && num=='-1'){
                alert("5장 이상 구매할 수 없습니다.");
                adultNum.value = parseInt(adultNum.value) + parseInt(num);     
            }else{
                adultNum.value = parseInt(adultNum.value) + parseInt(num);
            }
        }
    }
    
    // 소아 +-
    function childPlma(num){
        if(num == -1 && childNum.value == 0){
           childNum.value = 0;
        }else{
            totalNum = totalNum + parseInt(num);
            console.log(totalNum);
            if(totalNum>5){
               alert("5장 이상 구매할 수 없습니다.");
                totalNum = totalNum + -1;
            }else if(totalNum>5 && num=='-1'){
                alert("5장 이상 구매할 수 없습니다.");
                childNum.value = parseInt(childNum.value) + parseInt(num);     
            }else{
                childNum.value = parseInt(childNum.value) + parseInt(num);
            }
        }
    }
    
    // 유아 +-
    function babyPlma(num){
        if(num == -1 && babyNum.value == 0){
            babyNum.value = 0;
        }else{
            totalNum = totalNum + parseInt(num);
            console.log(totalNum);
            if(totalNum>5){
               alert("5장 이상 구매할 수 없습니다.");
                totalNum = totalNum + -1;
            }else if(totalNum>5 && num=='-1'){
                alert("5장 이상 구매할 수 없습니다.");
                babyNum.value = parseInt(babyNum.value) + parseInt(num);     
            }else{
                babyNum.value = parseInt(babyNum.value) + parseInt(num);
            }
        }
    }
    var todaydate = new Date();
	var todayyear = todaydate.getFullYear();
	var todaymonth = ("0" + (1 + todaydate.getMonth())).slice(-2);
	var todayday = ("0" + todaydate.getDate()).slice(-2);
	var todaymain = todayyear + "-" + todaymonth + "-" + todayday;
    
    // 항공편조회 버튼 누르는 순간 예외처리
    function reserve(){
		if(startPoint.value==""){
			alert("출발지를 선택해주세요.");
			return false;
		}else if(endPoint.value==""){
			alert("목적지를 선택해주세요.");
			return false;
		}else if(day.value==""){
			alert("출발날짜를 선택해주세요.");
			return false;
		}else if(adultNum.value + childNum.value + babyNum.value < 1){
			alert("매수를 선택하여 주세요.");
			return false;
		}else if(way==1){
			if(day.value==todaymain) {
				alert("당일 예매는 비행기 출발 2시간 이전까지만 가능하고, 입금역시 비행기 출발 2시간 이전까지만 가능합니다.");
				return "true";
			}
		}else if(way==2){
			var split = day.value.split('/');
			if(split[0]==todaymain) {
				alert("당일 예매는 비행기 출발 2시간 이전까지만 가능하고, 입금역시 비행기 출발 2시간 이전까지만 가능합니다.");
				return "true";
			}
		}
		return true;
	} 
    
    
</script>
</body>
</html>