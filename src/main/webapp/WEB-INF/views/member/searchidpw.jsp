<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="resources/img/PIcon.png">
<title>airLight</title>
</head>
<style>
    #main-schidpw{
        width: 100%;
        height : 700px;
    }
    #center-schidpw{
        margin: 0 auto;
        width : 80%;
        margin-top : 120px;
        box-sizing: border-box;
        border : 2px solid black;
        border-radius : 5px;
        background : white;
    }
    #head{
        margin: 0 auto;
        width:60%;
    }
    #head1{
        margin: 0 auto;
        width:60%;
    }
    .top-schidpw{
        width: 60%;
        margin: 0 auto;
        margin-top: 50px;
        height: 10%;
        display: flex;
        justify-content: space-around;
    }
    .sch{
        border: 2px solid black;
        width: 100%;
        text-align: center;
        line-height: 20px;
        color: black;
        height : 40px;
        cursor: pointer;
        font-weight : bold;
        font-size : 18px;
    }
    .sch:first-child{
    	border-right : 2px solid black;
    	border-right-style : dashed;
    }
    .sch:nth-child(2){
    	border-right-style : dashed;
    	border-left-style :  dashed;
    }
    .sch:last-child{
    	border-left-style :  dashed;
    }
    .sectionschidpw{
        box-sizing: border-box;
        width: 60%;
        margin: 0 auto;
        display: none;
    }
    table th{
        text-align: left;
    }
    .sectionschidpw{
    	font-weight : bold;
    	font-size : 20px;	
    }
   #searchinput,#search1input{
    	width : 100%;
    	height :40px;
    	border : 2px solid black;
    	border-radius : 5px;
    }
    #birth11,#birth22,#birth33,#birth111,#birth222,#birth333,#birth1111,#birth2222,#birth3333{
    	widht : 100%;
    	height : 40px;
    	border : 2px solid black;
    	border-radius : 5px;
    }
    .idpwsearchbtn{
    	margin-top : 20px;
    	border-radius : 5px;
    	border : 2px solid black;
    	width  : 100px;
    	height : 40px;
    	background :  #05224a;
    	color :  white;
    	font-size : 18px;
    	font-weight : bold;
    }
    #dbid,#engfirstname{
    	width : 65%;
    	height : 40px;
    	border : 2px solid black;
    	border-radius : 5px;
    }
    #dbeng_first,#engnam{
    	width : 65%;
    	height : 40px;
    	border : 2px solid black;
    	border-radius : 5px;
    }
    @media(max-width:1280px){ /*--------------------------------------------------------------	media 1280px */
    	 #birth11,#birth22,#birth33,#birth111,#birth222,#birth333,#birth1111,#birth2222,#birth3333{
	    	width : 30%;
	    	height : 40px;
	    	border : 2px solid black;
	    	border-radius : 5px;
    	}
    	#dbid,#engfirstname{
	    	width : 50%;
	    	height : 40px;
	    	border : 2px solid black;
	    	border-radius : 5px;
    	}
    	#dbeng_first,#engnam{
	    	width : 50%;
	    	height : 40px;
	    	border : 2px solid black;
	    	border-radius : 5px;
    	}
    	#searchinput,#search1input{
    	width : 90%;
    	height :40px;
    	border : 2px solid black;
    	border-radius : 5px;
    }
    }
</style>
<body>

    <div id="main-schidpw">
        <div id="center-schidpw">
            <div id="head">
                <h1>?????????/???????????? ??????</h1>
                <h3>??????????????? ????????? ????????????????????????</h3>
            </div>
            <div class="top-schidpw">
                <button class="sch"    >???????????????</button>
                <button class="sch">??????????????????</button>
                <button class="sch">??????????????????</button>
            </div>
            <!--======================================================???????????????================================================-->
            <div class="sectionschidpw">
                <form action="idsearch" method="post" onsubmit="return searchid()">
                    <table>
                        <tr>
                            <td><input type="radio" value="1" name="search" onclick="chois(this.value)" checked>???????????? ??????</td>

                        </tr>
                        <tr>
                            <td><input type="radio" value="2" name="search" onclick="chois(this.value)">???????????????</td>
                        </tr>
                        <tr>
                            <th><label id="ttxt1">?????? ?????? ??????*</label></th>
                        </tr>
                        <tr>
                            <td><input type="text" id="searchinput" name="searchinput" placeholder="??????)202011120001 12??????"></td>
                        </tr>
                        <tr>
                            <th>????????????*</th>
                        </tr>
                        <tr>
                            <td>
                            	<input type="text" name="birth11" id="birth11" placeholder="ex)1991">
                            	<input type="text" name="birth22" id="birth22" placeholder="ex)02">
                            	<input type="text" name="birth33" id="birth33" placeholder="ex)19)">
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="??????" class="idpwsearchbtn"></td>
                        </tr>
                        <input type="hidden" id="chks" name="chks">
                        <input type="hidden" id="chks" name="chks1">
                    </table>
                </form>
            </div>
            <!--======================================================???????????? ??????================================================-->
            <div class="sectionschidpw">
                <form action="pwsearch" method="post" onsubmit="return searchid1()">
                    <table>
                        <tr>
                            <th>?????? ?????????*</th>
                        </tr>
                        <tr>
                            <td><input type="text" name="dbid" id="dbid"></td>
                        </tr>
                        <tr>
                            <th>?????? ???*</th>
                        </tr>
                        <tr>
                            <td><input type="text" name="dbeng_first" id="dbeng_first"></td>
                        </tr>
                        <tr>
                            <th>????????????*</th>
                        </tr>
                        <tr>
                            <td>
                            	<input type="text" name="birth111" id="birth111" placeholder="ex)1991">
                            	<input type="text" name="birth222" id="birth222" placeholder="ex)02">
                            	<input type="text" name="birth333" id="birth333" placeholder="ex)19)">
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="??????" class="idpwsearchbtn"></td>
                        </tr>
                        <input type="hidden" id="chks3" name="chks3" value = "1">
                    </table>
                </form>
            </div>
            <!--======================================================???????????? ??????================================================-->
             <div class="sectionschidpw">
                <form action="membercodeserch" method="post" onsubmit="return searchid2()">
                    <table>
                        <tr>
                            <td><input type="radio" value="1" name="search1" onclick="chois1(this.value)" checked>????????? ??????</td>

                        </tr>
                        <tr>
                            <td><input type="radio" value="2" name="search1" onclick="chois1(this.value)">???????????????</td>
                        </tr>
                        <tr>
                            <th>?????? ???*</th>
                        </tr>
                        <tr>
                            <td><input type="text" id="engfirstname" name="engfirstname"></td>
                        </tr>
                        <tr>
                            <th>?????? ??????*</th>
                        </tr>
                        <tr>
                            <td><input type="text" id="engnam" name="engnam"></td>
                        </tr>
                         <tr>
                            <th><label id="ttxt2">????????? ??????*</label></th>
                        </tr>
                        <tr>
                            <td><input type="text" id="search1input" name="search1input" placeholder="??????)010-1234-1234"></td>
                        </tr>
                        <tr>
                            <th>????????????*</th>
                        </tr>
                        <tr>
                            <td>
                            	<input type="text" name="birth1111" id="birth1111" placeholder="ex)1991">
                            	<input type="text" name="birth2222" id="birth2222" placeholder="ex)02">
                            	<input type="text" name="birth3333" id="birth3333" placeholder="ex)19)">
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="??????" class="idpwsearchbtn"></td>
                        </tr>
                        <input type="hidden" id="chks1" name="chks1">
                    </table>
                </form>
            </div>
        </div>
    </div>
    <script>
    var chks = document.getElementById("chks"); //  input hidden ???
    var ttxt1 = document.getElementById("ttxt1");
    var searchinput = document.getElementById("searchinput"); // ???????????? ,??????????????? input ?????? ???
    var chk = 1;
    chks.value = chk;
    var y = 0;
    y = chks.value;
    
    var ttxt2 = document.getElementById("ttxt2");
    var chks1 = document.getElementById("chks1"); //  input hidden ???
    var search1input = document.getElementById("search1input"); // ???????????? ,??????????????? input ?????? ???
    var chk1 = 1;
    chks1.value = chk1;
    var x = 0;
    x = chks1.value;
    
    var chks3 = document.getElementById("chks3");
    //====================================================================
    var sectionschidpw = document.querySelectorAll(".sectionschidpw");
    var sch = document.querySelectorAll(".sch");
    
     sch[0].addEventListener('click',function(){
        sectionschidpw[0].style.display="block";
        sectionschidpw[1].style.display="none";
        sectionschidpw[2].style.display="none";
        sch[0].style.fontWeight = "bold";
        sch[0].style.color = "white";
        sch[1].style.fontWeight = "normal";
        sch[1].style.color = "black";
        sch[2].style.fontWeight = "normal";
        sch[2].style.color = "black";
        sch[0].style.background = "#05224a";
        sch[1].style.background = "#EFEFEF";
        sch[2].style.background = "#EFEFEF";
    });
        sch[1].addEventListener('click',function(){
        sectionschidpw[0].style.display="none";
        sectionschidpw[1].style.display="block";
        sectionschidpw[2].style.display="none";
        sch[0].style.fontWeight = "normal";
        sch[0].style.color = "black";
        sch[1].style.fontWeight = "bold";
        sch[1].style.color = "white";
        sch[2].style.fontWeight = "normal";
        sch[2].style.color = "black";
        sch[0].style.background = "#EFEFEF";
        sch[1].style.background = "#05224a";
        sch[2].style.background = "#EFEFEF";
    });
        sch[2].addEventListener('click',function(){
        sectionschidpw[0].style.display="none";
        sectionschidpw[1].style.display="none";
        sectionschidpw[2].style.display="block";
        sch[0].style.fontWeight = "normal";
        sch[0].style.color = "black";
        sch[1].style.fontWeight = "normal";
        sch[1].style.color = "black";
        sch[2].style.fontWeight = "bold";
        sch[2].style.color = "white";
        sch[0].style.background = "#EFEFEF";
        sch[1].style.background = "#EFEFEF";
        sch[2].style.background = "#05224a";
    });
    //====================================????????? ?????? / ???????????? or ?????????????????? 
    function chois(chkplese){
        if(chkplese == 1){
            searchinput.placeholder = "??????)202011120001 12??????";
            searchinput.type = "text";
            ttxt1.innerHTML = "???????????? ??????*";
            chk = 1;
            chks.value = 1;
            y = 1;
           }else{
            searchinput.placeholder = "??????)airLight@naver.com";
            searchinput.type = "email";
            ttxt1.innerHTML = "????????? ??????*"; 
            chk = 2;
            chks.value = 2;
            y = 2;
           }
    }
    //=======================================???????????? / ???????????? or ????????? ??????
    function chois1(chkk){
        if(chkk == 1){
            search1input.placeholder = "??????)010-1234-1234";
            ttxt2.innerHTML = "????????? ??????*";
            search1input.type = "text";
            chk1 = 1;
            chks1.value = 1;
            x = 1
           }else{
            search1input.placeholder = "??????)airLight@naver.com";
            ttxt2.innerHTML = "????????? ??????*";   
            search1input.type = "email";
            chk1 = 2;
            chks1.value = 2;
            x = 2
           }
    }
    //========================================
    var codechk1 = /^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$/;
    var birth11 = document.getElementById("birth11");
    var birth22 = document.getElementById("birth22");
    var birth33 = document.getElementById("birth33");
    var dbeng_first = document.getElementById("dbeng_first");
    var birth11expression = /^(\d{4})$/; 
	var birth22expression = /^(0([1-9])|([1-9][1-2])|10)/;
	var birth33expression = /^((0[1-9])|([1-2][0-9])|30|31)$/;
	var eamilexpression = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	var codechk1 = /^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$/;
	
    function searchid(){
   		if(searchinput.value ==""&&birth11.value==""&&birth22.value==""&&birth33.value==""){
   			alert("????????? ???????????? ???????????????.");
    		return false;
   		}else if(!codechk1.test(searchinput.value) && y == 1){
   			alert("???????????? ????????? ?????????????????????.");
    		return false;
   		}else if(!eamilexpression.test(searchinput.value) && y == 2){
   			alert("????????? ????????? ?????????????????????.");
    		return false;
   		}else if(birth11.value==""){
			alert("???????????? ????????? ?????? ??????????????????");
			birth11.focus();
			return false;
		}else if(birth22.value==""){
			alert("???????????? ????????? ?????? ??????????????????");
			birth22.focus();
			return false;
		}else if(birth33.value==""){
			alert("???????????? ????????? ?????? ??????????????????");
			birth33.focus();
			return false;
		}else if(!birth11expression.test(birth11.value)){
			alert("??????????????? ????????? ?????? ??????????????????");
			birth11.focus();
			return false;
		}else if(!birth22expression.test(birth22.value)){
			alert("???????????? ????????? ?????? ??????????????????");
			birth22.focus();
			return false;
		}else if(!birth33expression.test(birth33.value)){
			alert("???????????? ????????? ?????? ??????????????????");
			birth33.focus();
			return false;
		}
   		
   		return true;
    }
    //==============================================================
		//======== ?????????????????? ????????????
    var birth111 = document.getElementById("birth111");
    var birth222 = document.getElementById("birth222");
    var birth333 = document.getElementById("birth333");
    var engchk = /^[A-Za-z]*$/;
    var phoneexpression = /^(010)-(\d{4})-\d{4}$/;
    function searchid1(){
    	if(dbid.value ==""&&dbeng_first.value ==""&&birth111.value==""&&birth222.value==""&&birth333.value==""){
    		alert("????????? ???????????? ???????????????.");
    		return false;
    	}else if(!engchk.test(dbeng_first.value)){
			alert("????????? ??????????????????");
			dbeng_first.focus();
			return false;
		}else if(!birth11expression.test(birth111.value)){
			alert("??????????????? ????????? ?????? ??????????????????");
			birth111.focus();
			return false;
		}else if(!birth22expression.test(birth222.value)){
			alert("???????????? ????????? ?????? ??????????????????");
			birth222.focus();
			return false;
		}else if(!birth33expression.test(birth333.value)){
			alert("???????????? ????????? ?????? ??????????????????");
			birth333.focus();
			return false;
		}else if(!engchk.test(dbeng_first.value)){
			alert("????????? ??????????????????");
			dbeng_first.focus();
			return false;
		}
   		
   		return true;
    }
    //==============================================================
    	//========
    var engfirstnames =  /^[A-Za-z]*$/;
    var engnams = /^[A-Za-z]*$/;
    var birth1111 = document.getElementById("birth1111");
    var birth2222 = document.getElementById("birth2222");
    var birth3333 = document.getElementById("birth3333");
    
    function searchid2(){
    	if(engnam.value ==""&&engfirstname.value ==""&&engnam.value ==""&&birth1111.value==""&&birth2222.value==""&&birth3333.value==""){
    		alert("????????? ???????????? ???????????????.");
    		return false;
    	}else if(!engfirstnames.test(engfirstname.value)){
			alert("????????? ??????????????????");
			dbeng_first.focus();
			return false;
		}else if(!engnams.test(engnam.value)){
			alert("????????? ??????????????????");
			dbeng_first.focus();
			return false;
		}else if(!phoneexpression.test(search1input.value)&& x == 1){
   			alert("??????????????? ????????? ?????????????????????.(????????? - ??????)");
    		return false;
   		}else if(!eamilexpression.test(search1input.value) && x == 2){
   			alert("????????? ????????? ?????????????????????.");
    		return false;
   		}else if(!birth11expression.test(birth1111.value)){
			alert("??????????????? ????????? ?????? ??????????????????");
			birth1111.focus();
			return false;
		}else if(!birth22expression.test(birth2222.value)){
			alert("???????????? ????????? ?????? ??????????????????");
			birth2222.focus();
			return false;
		}else if(!birth33expression.test(birth3333.value)){
			alert("???????????? ????????? ?????? ??????????????????");
			birth3333.focus();
			return false;
		}else if(!engchk.test(dbeng_first.value)){
			alert("????????? ??????????????????");
			dbeng_first.focus();
			return false;
		}
   		
    }
    </script>
</body>
</html>