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
    #header_contain{
    	width:100%;
        background: white; /* airLigt 대표 컬러 */
        border-bottom : 5px solid black;
        border-top : 5px solid black;
    }
    #header{
        width: 100%;
        display: flex;
        background: white;
    }
    #header1{
        width: 40%;
    }
    #header2{
        width: 20%;
        display: flex;
    }
    #header2 a{
        margin-top : 10px;
        margin-bottom: 10px;
    }
    #header2 a img{
        width: 100%;
    }
    #header3{
        width: 40%;
        display: flex;
    }
    #header3 ul{
        width: 100%;
        box-sizing: border-box;
        display: flex;
        vertical-align : bottom;
        margin : 0;
        
    }
    #header3 ul li{
        list-style: none;
        padding: 10px;
        border-radius: 10px;
        margin-right : 30px;
        color : black;
        font-weight: bold;
        font-size : 20px;
        margin-top : 30px;
        cursor : pointer;
    }
    #header3 a{
        width: 100%;
        text-decoration: none;
        color: black;
        font-weight: bold;
    }
    #loginpage{
        position: fixed;
        width: 100%;
        height: 970px;
        background-color: rgb(0, 0, 0,0.8);
        display: none;
        z-index : 30;
        
    }
    #logstate{
    	display : none;
    }
    #login-main{
        height: 80%;
        width: 50%;
        margin: 0 auto;
        
    }
    #login{
        background: white;
        font-weight: bold;
        margin-top: 100px;
        height: 500px;
        border : 3px solid #ece6cc;
        border-radius : 5px;
        text-align : center;
    }
    #login_1{
       border : 3px solid #05224a;
        border-radius : 5px;
        width: 80%;
        height: 80%;
        margin: 0 auto;
        margin-top: 40px;
    }
    #login-div{
    	width : 90%;
    	margin : 0 auto;
    	margin-bottom: 30px;
    }
    #login-div> table{
       margin : 0 auto; 
       width: 80%;
       text-align: left;
    }
    .chois{
    	margin : 0;
    	border : 2px solid black;
    	marign-right : 20px;
    }
    #login_1 p{
    	font-size : 23px;
    	color : #05224a;
    }
    i{
        color: #05224a;
        font-size: 30px;
        
    }
    #close{
        margin-top: 10px;
        margin-right : 10px;
        width: 6%;
        float: right;
        cursor : pointer;
    }
    #form2{
    	margin = 0;
    	padding = 0;
    }
    #logoin_btn{
    	border : 2px solid #05224a;
    	border-radius : 5px;
    	background : #05224a;
    	color : white;
    	width : 120px;
    	height : 40px;
    	font-weight : bold;
    	font-size : 20px;
    	margin-left : 15px;
    	cursor : pointer;
    }
    #input1{
    	width :190px;
    	height : 40px;
    	border : 2px solid black;
    	border-radius : 5px;
    	margin-right : 15px;
    }
    #pw123{
    	width :190px;
    	height : 40px;
    	border : 2px solid black;
    	border-radius : 5px;
    }
    #foot_loginchk{
    	margin : 0 auto;
    	width : 80%;
    	text-align : left;
    }
     #foot_loginchk>p{
     	color  : red;
     	font-size : 16px;
     }
     #foot_loginchk>a{
     	text-decoration : none;
     	font-size : 21px;
     	color : #05224a;
     }
     #foot_loginchk>p>a{
     	margin-top : 5px;
     	text-decoration : none;
     	font-size : 21px;
     	color : #05224a;
     }
     @media(max-width:1280px){ /*----------------------------------------------------------- media 1280px */
     	#header3 ul li{
        list-style: none;
        padding: 10px;
        border-radius: 10px;
        margin-right : 30px;
        color : black;
        font-weight: bold;
        font-size : 14px;
        margin-top : 30px;
        cursor : pointer;
    }
     	 #input1{
    	width :160px;
    	height : 40px;
    	border : 2px solid black;
    	border-radius : 5px;
    	margin-right : 15px;
    }
    #pw123{
    	width :160px;
    	height : 40px;
    	border : 2px solid black;
    	border-radius : 5px;
    }
    #logoin_btn{
    	border : 2px solid #05224a;
    	border-radius : 5px;
    	background : #05224a;
    	color : white;
    	width : 100px;
    	height : 40px;
    	font-weight : bold;
    	font-size : 17px;
    	margin-left : 15px;
    	cursor : pointer;
    }
    #foot_loginchk{
    	margin : 0 auto;
    	width : 80%;
    	text-align : left;
    }
     #foot_loginchk>p{
     	color  : red;
     	font-size : 14px;
     }
     #foot_loginchk>a{
     	text-decoration : none;
     	font-size : 21px;
     	color : #05224a;
     }
     #foot_loginchk>p>a{
     	margin-top : 5px;
     	text-decoration : none;
     	font-size : 17px;
     	color : #05224a;
     }
     }
</style>
<script src="https://kit.fontawesome.com/742b89101d.js" crossorigin="anonymous"></script>
<body>
    <div id="header_contain">
        <div id="header">
           <div id="header1">
				
           </div>
           <div id="header2"><a href="index"><img src="resources/img/airLight-main-logo.jpg" alt=""></a></div>
            <div id="header3">
               <nav>
                    <ul>
                    	<c:if test="${log == '손님'}">
                        <li id="logstate">기능활성화</li>
                        <li><a href="joingo">회원가입</a></li>
                        <li onclick="loginbtn()">로그인</li>
                        </c:if>
                        <c:if test="${log == '관리자'}">
                        	<li>${log }님 로그인</li>
                        	<li><a href="AdminPage?num=0">마이페이지</a></li>
                        	<li><a href="logout">로그아웃</a></li>
                        </c:if>
                        <c:if test="${log == '회원'}">
                        	<li>환영합니다 ${name}님 로그인</li>
                        	<li><a href="MyPage?num=0">마이페이지</a></li>
                        	<li><a href="logout">로그아웃</a></li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    
     <div id="loginpage">
        <div id="login-main">
            <div id="login">
              <div id="close">
                          <i class="fas fa-times" onclick="closebtn();"></i>   
                </div>
                
               <div id="login_1">
               		<form action="login" method="post" id="form2" onsubmit="return reservet()">
	                    <h1>로그인</h1>
	                    <p>아이디 또는 회원코드로 로그인이 가능합니다.</p>
	                    <br>
	                    <div id="login-div">
		                    <table>
		                        <tr>
		                            <th><input type="radio" value="1" class="chois" name="logchoi" onclick="choi(this.value)"checked>회원 아이디</th>
		                        </tr>
		                        <tr>
		                            <th><input type="radio" value="2"  class="chois" name="logchoi" onclick="choi(this.value)">회원코드 번호</th>
		                            <th>비밀번호</th>
		                        </tr>
		                        <tr>
		                            <td><input type="text" name="id" id="input1" placeholder="아이디를 입력해주세요"></td>
		                            <td><input type="password" name="pw"  id="pw123"></td>
		                            <td><input type="submit" value="로그인"  id="logoin_btn"></td>
		                        </tr>
		                    </table>
		                </div>   
	                    <hr>
	                    <div id="foot_loginchk">
	                        <a href="searchidpw">아이디/회원코드/비밀번호 찾기</a><br>
	                        <p>회원으로 가입하지 않으신분들은 지금 가입하세요.&nbsp&nbsp<a href="joingo">회원가입</a></p>
	                    </div>
	                    <input type="hidden" id="ask" name="chk01">
                    </form>
                </div>
            </div>
        </div>
    </div>
<script>
    var loginpage = document.getElementById("loginpage");
    var close = document.getElementsByClassName("fas fa-times")[0];
    var header_contain = document.getElementById("header_contain");
    var input1 = document.getElementById("input1");
    var ask = document.getElementById("ask");
    var codechk = /^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$/;
    var chk = 1;
    var y = 0;
    ask.value = chk;
    y = ask.value;
    
    function loginbtn(){
        loginpage.style.display = "block";
    }
    function closebtn(){
        loginpage.style.display = "none";
    }
   
    function choi(x){
    	if(x == 1){
    		input1.placeholder = "아이디를 입력해주세요";
    		chk = 1;
    		ask.value = 1;
    		y = 1;
    	}else{
    		input1.placeholder = "회원번호를 입력해주세요";
    		chk = 2;
    		ask.value = 2;
    		y = 2;
    	}
    }
    
    function reservet(){
    	if(!codechk.test(input1.value) && y == 2){
    		alert("회원코드 양식이 잘못되었습니다.");
    		return false;
    	}
    	return true;
    }
</script>
</body>
</html>