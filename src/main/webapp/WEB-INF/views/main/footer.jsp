<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="resources/img/PIcon.png">
<title>airLight</title>
</head>
<style>
	body{
		clear: both;
	}
    #footer12{
        background-color: white;
        width:100%;
        color: black;
        font-weight : bold;
        clear : both;
    }
    #flex_zone{
    	display : flex;
    }
    #footer1{
    	width : 700px;
    }
    #footer1>p{
    	font-size : 13px;
    	font-weight : bold;
    	margin-top : 5px;
    	margin-bottom :5px;
    }
    
    #footer-content{
        width: 80%;
        line-height: 40px;
        margin: 0 auto;
    }
    #footer2{
    	display : flex;
        justify-content: center;
    }	
    #footer2 ul{
    	text-align : center;
    	border-left : 2px solid black;
    	width : 290px;
    	padding : 0;
    	margin-right : 10px;
    	margin-left : 20px;
    	box-sizing : border-box;
    }#footer2 li{
    	width : 300px;
    	list-style : none;
    }
    @media (max-width:1280px){ /* =================================1280px */
    #footer12{
        background-color: white;
        width:100%;
        color: black;
        font-weight : bold;
        clear : both;
        height : 200px;
    }

    #footer1{
    	width : 500px;
    	margin-top : 20px;
    	margin-left : 20px;
    }
    #footer1>p{
    	font-size : 13px;
    	font-weight : bold;
    	margin-top : 5px;
    	margin-bottom :5px;
    }
    
    #footer-content{
        width: 100%;
        line-height: 40px;
        margin: 0 auto;
    }
    #footer1,#footer2{
		display : inline-block;
    }
    #footer2{
    	width : 980px;
    	vertical-align : top;
    	margin-top : 40px;
    }
    #footer2 ul{
    	width:230px;
    	padding : 0;
    	font-size : 14px;
    	margin-right : 10px;
    	margin-left : 10px;
    	box-sizing : border-box;
    	display : inline-block;
    }#footer2 li{
    	width : 280px;
    	list-style : none;
    	margin : 0;
    }
  }
</style>
<body>
<div id="footer12">
    <div id="footer-content">
        <div id="flex_zone">
        	<div id="footer1">
        		<p>(주) 에어라이트 | 제작자 : 김소리 외 2명 | 주소 : 서울 종로구 수표로 96 국일관 드림팰리스2층 그린컴퓨터아트학원  | 대표전화 :  02 - 722 - 2111
                제작일 : 2020-10-30 | 저작권보호책임자 : 디지털컨버전스(JAVA기반 응용SW엔지니어링 파이썬) 3조
                © 2020-2020 AIR RIGHT
           		 </p>
        	</div>
            <div id="footer2">
                <ul>
                    <li>제작자 : 김소리</li>
                    <li>메일주소 : noksm2@naver.com</li>
                </ul>
                <ul>
                    <li>제작자 : 김다손</li>
                    <li>메일주소 : spfhht@naver.com</li>
                </ul>
                <ul>
                    <li>제작자 : 김광원</li>
                    <li>메일주소 : rhkddnjs7878@naver.com</li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>