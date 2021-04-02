<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="resources/img/PIcon.png">
<title>airLight</title>
</head>
<style>
    #join-container{   /*---------------------------전체 form 박스---------------------*/
        width: 100%;
        height : 1100px;
        margin-top : 20px;
        border : 1px solid black;
        background  : white;
    }
    #join-container:after{
    	display : block;
    	clear : both;
    }
     #container{        /*---------------------------중간 div 박스---------------------*/
        width: 90%;
        clear: both;
        margin: 0 auto;
        
    }
    #customer{        /*---------------------------고객정보css---------------------*/
        background-color: #05224a;
        font-size: 18px;
        font-weight: bold;
        height: 40px;
        line-height: 40px;
        margin-bottom: 20px;
        clear: both;
         color : white;
         text-align : center;
    }
    #engbtn{	/*-------------------------영어이름입력버튼--------------------  */
    	background-color: #05224a;
        border: 1px solid #05224a;
        border-radius: 5px;
        font-weight: bold;
        color : white;
        
        width : 100%;
        height : 40px;
    }
    .join_input{      /*---------------------------생년월일제외 input박스---------------------*/
        width: 100%;
        height: 40px;
        padding: 0;
        margin: 0;
        margin-bottom: 10px;
        box-sizing: border-box;
    }
    .join_input1{    /*---------------------------생년월일 input박스---------------------*/
        margin: 0;
        padding: 0;
        height: 40px;
       box-sizing: border-box;
    }
    #join_table1{    /*---------------------------왼쪽 테이블포함 div 박스---------------------*/
        width: 20%;
        float: left;
        margin: 0;
        padding: 0;
        margin-bottom: 30px;
    }
    #join_table1 table tr{
    	vertical-align: top;
    }
    #join_table1 th{
        text-align: left;
    }
    #join_table2{      /*---------------------------오른쪽 테이블포함 div 박스---------------------*/
        width: 45%;
        float: right;
        margin: 0;
        padding: 0;
    }
    #join_table2 tr{
    	vertical-align: bottom;
    	box-sizing: border-box;
    }
    #join_table2 th{
        text-align: left;
        width: 100%;
    }
    #joion_table2 td{
    	box-sizing: border-box;
    }
    .join_input3{      /*---------------------------오른쪽 선택 박스---------------------*/
        width: 100.7%;
        height: 40px;
        margin-bottom: 20px;
        box-sizing: border-box;
    }
    .join_input4{      /*---------------------------오른쪽 input 박스---------------------*/
        width: 100%;
        height: 40px;
        margin-bottom: 10px;
        box-sizing: border-box;
    }
    #join_input5{      /*---------------------------오른쪽 우편번호검색 박스---------------------*/
        width : 100%;
        height: 40px;
        background-color: #05224a;
        border: 1px solid #05224a;
        font-weight: bold;
        border-radius: 5px;
        color: white;
        box-sizing: border-box;
        
    }
    #postcode{      /*---------------------------오른쪽 우편번호 박스---------------------*/
        width: 100%;
        height: 40px;
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    
    #join_inforContain{      /*---------------------------로그인정보 전체규격---------------------*/
        clear: both;
        width: 100%;
    }
    #join_infor{      /*---------------------------로그인정보 div 박스---------------------*/
      	 background-color: #05224a;
        font-size: 18px;
        font-weight: bold;
        height: 40px;
        line-height: 40px;
        margin-bottom: 20px;
        color : white;
        clear : both;
         text-align : center;
    }
    #join_infor1{      /*---------------------------로그인정보 왼쪽 table---------------------*/
        float: left;
        width: 45%;
        clear : both;
    }
    #join_infor1 table{
        width: 100%;
    }
    #join_id{
        width: 86%;
        height: 40px;
    }
    #id_chk{
        width: 28%;
        height: 44px;
        margin: 0;
        padding: 0;
        
    }
    #join_infor1 th{
        text-align: left;
    }
    
    #join_infor2{      /*---------------------------로그인정보 오른쪽 table---------------------*/
        float: right;
        width: 45%;
        margin-bottom: 50px;
        
    }
    #join_infor2 table{
        width: 100%;
    }
    #join_infor2 th{
        text-align: left;
        width: 100%;
    }
    .join_input7{
        width: 100%;
        margin: 0;
        padding: 0;
        height: 40px;
    }
    #footer_btn{      /*---------------------------footer 버튼---------------------*/
        clear: both;
        width: 80%;
        margin: 0 auto;
        text-align: center;
        margin-bottom: 40px;
    }
    #back_btn{      /*---------------------------뒤로가기 버튼---------------------*/
        width: 10%;
        height: 40px;
        background-color: #329dc9;
        border: 4px solid #329dc9;
        border-radius: 5px;
        margin-right: 25px;
        color: white;
        font-weight: bold;
        font-size: 18px;
        clear : both;
    }
    #reset_btn{      /*---------------------------취소하기 버튼---------------------*/
        width: 10%;
        height: 40px;
        background-color: #f46565;
        border: 3px solid #f46565;
        border-radius: 5px;
        margin-right: 25px;
        color: white;
        font-weight: bold;
        font-size: 18px;
        clear : both;
    }
    #join_btn{      /*---------------------------가입하기 버튼---------------------*/
        width: 10%;
        height: 40px;
        background-color: #05224a;;
        border: 4px solid #05224a;
        border-radius: 5px;
        margin-right: 25px;
        color: white;
        font-weight: bold;
        font-size: 18px;
        clear : both;
    }
     @media(max-width:1280px){  /* =========================================1280px */
   #join-container{   /*---------------------------전체 form 박스---------------------*/
        width: 110%;
        height : 1100px;
        margin-top : 20px;
        margin-left : -50px;
        border : 1px solid black;
        background  : white;
    }
    #join-container:after{
    	display : block;
    	clear : both;
    }
     #container{        /*---------------------------중간 div 박스---------------------*/
        width: 90%;
        clear: both;
        margin: 0 auto;
        
    }
    	#engbtn{	/*-------------------------영어이름입력버튼--------------------  */
    	background-color: #05224a;
        border: 1px solid #05224a;
        border-radius: 5px;
        font-weight: bold;
        color : white;
        width : 100%;
        height : 40px;
    }
    .join_input{      /*---------------------------생년월일제외 input박스---------------------*/
        width: 100%;
        height: 40px;
        padding: 0;
        margin: 0;
        margin-bottom: 10px;
        box-sizing: border-box;
    }
    .join_input1{    /*---------------------------생년월일 input박스---------------------*/
        margin: 0;
        padding: 0;
        height: 40px;
       box-sizing: border-box;

    }
     #back_btn{      /*---------------------------뒤로가기 버튼---------------------*/
        width: 10%;
        height: 40px;
        background-color: #329dc9;
        border: 4px solid #329dc9;
        border-radius: 5px;
        margin-right: 25px;
        color: white;
        font-weight: bold;
        font-size: 16px;
        clear : both;
    }
    #reset_btn{      /*---------------------------취소하기 버튼---------------------*/
        width: 10%;
        height: 40px;
        background-color: #f46565;
        border: 3px solid #f46565;
        border-radius: 5px;
        margin-right: 25px;
        color: white;
        font-weight: bold;
        font-size: 16px;
        clear : both;
    }
    #join_btn{      /*---------------------------가입하기 버튼---------------------*/
        width: 10%;
        height: 40px;
        background-color: #05224a;;
        border: 4px solid #05224a;
        border-radius: 5px;
        margin-right: 25px;
        color: white;
        font-weight: bold;
        font-size: 16px;
        clear : both;
    }
    }
</style>
<body>
    <form action="join" method="post" id="join-container" onsubmit="return reserve()">
    <!--=====================================================회원가입 상단=======================================================-->
        <div id="container">
        <h1>회원가입</h1>
        <p>영문이름은 여권상의 이름과 동일하게 입력하여 주시기 바랍니다.</p>
        <div id="customer">고객정보</div>
    <!--=====================================================회원가입 왼쪽=======================================================-->
        <div id="join_table1">
            <table>
                <tr>
                    <th>한글 성 *</th>
                </tr>
                <tr>
                    <td colspan="2"><input type="text" class="join_input" name="krname" id="krname"></td>
                    <td colspan="1"><input type="button" value="영문이름입력" onclick="openChgBtn();" id="engbtn"></td>
                </tr>
                <tr>
                    <th>한글 이름 *</th>
                </tr>
                <tr>
                    <td colspan="3"><input type="text" class="join_input" name="krname2" id="krname2"></td>
                </tr>
                <tr>
                    <th>영문 성 *</th>
                </tr>
                 <tr>
                    <td colspan="3"><input type="text" class="join_input" id="engname" name="engname" readonly></td>
                </tr>
                 <tr>
                    <th>영문 이름 *</th>
                </tr>
                 <tr>
                    <td colspan="3"><input type="text" class="join_input" id="engname2" name="engname2" readonly></td>
                </tr>
                 <tr>
                    <th>생년월일 *</th>
                </tr>
                <tr>
                    <td><input type="text" class="join_input1" id="birth1" placeholder="ex)1991" name="birth1"></td>
                    <td><input type="text" class="join_input1" id="birth2" placeholder="ex)02" name="birth2"></td>
                    <td><input type="text" class="join_input1" id="birth3" placeholder="ex)19)" name="birth3"></td>
                </tr>
                <tr>
                    <th>성별 *</th>
                </tr>
                <tr>
                    <td><input type="radio" value="1" name="gender" checked>남</td>
                </tr>
                <tr>
                    <td><input type="radio" value="2" name="gender">여</td>
                </tr>
                <tr>
                    <th>이메일 주소 *</th>
                </tr>
                <tr>
                    <td colspan="3"><input type="email" placeholder="예)airlight@airlight.com" class="join_input" id="email" name="email"></td>
                </tr>
            </table>
        </div>
    <!--=====================================================회원가입 오른쪽=======================================================-->
        <div id="join_table2">
            <table>
               <tr>
                    <th>휴대폰 번호 *</th>
                </tr>
                <tr>
                    <td colspan="3">
                        <select class="join_input3" name="country1">
                            <option value="Korea Requblic Of" checked>Korea Requblic Of</option>
                            <option value="USA / Canada / Puerto Rico">USA / Canada / Puerto Rico</option>
                            <option value="China">China </option>
                            <option value="Japen">Japen </option>
                            <option value="Austrailia">Austrailia </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><input type="text" class="join_input4" id="phone_num" name="phone_num" placeholder="ex)010-1234-5678(반드시-포함)"></td>
                </tr>
                <tr>
                    <th>유선 전화</th>
                </tr>
                <tr>
                    <td colspan="3">
                        <select class="join_input3" name="country2">
                            <option value="Korea Requblic Of" checked>Korea Requblic Of</option>
                            <option value="USA / Canada / Puerto Rico">USA / Canada / Puerto Rico</option>
                            <option value="China">China </option>
                            <option value="Japen">Japen </option>
                            <option value="Austrailia">Austrailia </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><input type="text" class="join_input4" id="wireline"  name="wireline" placeholder="ex)02-1234-5678(반드시-포함)"></td>
                </tr>
                <tr>
                    <th>거주 국가/지역 *</th>
                </tr>
                <tr>
                    <td colspan="3">
                        <select class="join_input3" name="country">
                            <option value="Korea Requblic Of" checked>Korea Requblic Of</option>
                            <option value="USA / Canada / Puerto Rico">USA / Canada / Puerto Rico</option>
                            <option value="China ">China </option>
                            <option value="Japen ">Japen </option>
                            <option value="Austrailia ">Austrailia </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>우편 번호 *</th>
                </tr>
                <tr>
                	<td colspan="2"><input type="text" id="postcode" name="postcode" readonly></td>
                    <td colspan="1"><input type="button" value="우편번호 검색" onclick="DaumPostcode()" id="join_input5"></td>
                	
                </tr>
                <tr>
                    <th>주소 *</th>
                </tr>
                <tr>
                    <td colspan="3"><input type="text" class="join_input4" id="roadAddress" name="roadaddress" readonly></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="text" class="join_input4" id="detailAddress" name="detailaddress" placeholder="상세주소를 입력해주세요"></td>
                </tr>
            </table>
        </div>
        <!--=====================================================회원가입 로그인정보 왼쪽=======================================================-->
			<div id="join_inforContain">    
            <div id="join_infor">로그인 정보</div>
            <div id="join_infor1">
                <table>
                    <tr>
                        <th colspan="2">회원 아이디 *</th>
                    </tr>
                    <tr>
                        <td>
	                        <input type="text" placeholder="6~12자리의 영문으로입력해주세요" id="join_id" name="join_id">
	                        <!-- =====================  onclick="idchkbtn()" 넣기 ================== -->
                        </td>
                    </tr>
                </table>
            </div>
          <!--  =====================================================회원가입 로그인정보 오른쪽======================================================= -->
            <div id="join_infor2">
                <table>
                    <tr>
                        <th colspan="2">비밀번호 *</th>
                    </tr>
                    <tr>
                        <td><input type="password" placeholder="숫자 특수기호(!@#*-) 영문자 8~20자리" class="join_input7" id="pw" name="pw"></td>
                    </tr>
                    <tr>
                        <th colspan="2">비밀번호 확인 *</th>
                    </tr>
                    <tr>
                        <td><input type="password" placeholder="숫자 특수기호(!@#*-) 영문자 8~20자리" class="join_input7" id="pwchk" name="pwchk"><p id="pwtext"></p></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div id="footer_btn">
        <input type="button" value="뒤로가기" onclick="location.href='main.jsp'" id="back_btn">
        <input type="reset" value="취소" id="reset_btn">
        <input type="submit" value="가입하기" id="join_btn">
    </div> 
    </form>
</body>
<script src="https://code.jquery.com/jquery-2.2.1.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script>
	var openWin;
	//=========================정규식=========================
	var idexpression = /^\w{6,12}$/;
	var pwexpression = /^(?=.*[a-zA-Z])(?=.*[!@#*-])(?=.*[0-9]).{8,20}$/; 
	var eamilexpression = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	var phoneexpression = /^(010)-(\d{4})-\d{4}$/;
	var wirelineexpression = /^(02)-(\d{3}|\d{4})-\d{4}$/;
	var birth1expression = /^(\d{4})$/; 
	var birth2expression = /^(0([1-9])|([1-9][1-2])|10)/;
	var birth3expression = /^((0[1-9])|([1-2][0-9])|30|31)$/;
	//=========================각 input 박스 아이디값=========================
	var id = document.getElementById("join_id");
	var pw = document.getElementById("pw");
	var pwchk = document.getElementById("pwchk");
	var email = document.getElementById("email");
	
	var krnam = document.getElementById("krname");
	var krnam2 = document.getElementById("krname2");
	var engnam = document.getElementById("engname");
	var engnam2 = document.getElementById("engname2");
	var birth1 = document.getElementById("birth1");
	var birth2 = document.getElementById("birth2");
	var birth3 = document.getElementById("birth3");
	var phone_num = document.getElementById("phone_num");
	var wireline = document.getElementById("wireline");
	var postcode = document.getElementById("postcode");
	var roadaddress = document.getElementById("roadAddress");
	var detailaddress = document.getElementById("detailAddress");
	var join_input3 = document.querySelector(".join_input3");
	
	var x = '${x}';
	
    function DaumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            var roadAddr = data.roadAddress; // 도로명 주소 변수
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('postcode').value = data.zonecode;
	            document.getElementById("roadAddress").value = roadAddr;
	        }
	    }).open();
	}
    //==============================================================
    //한글 이름 영어로 변환 스크립트
    function openChgBtn(){
    	var kor_check = /([^가-힣ㄱ-ㅎㅏ-ㅣ\x20])/i;
    	console.log("1");
    	var krname = document.getElementById("krname").value  // 한국이름 성
    	var krname2 = document.getElementById("krname2").value // 한국이름 이름
	    if(krname == ""){
	    	alert("성을 입력해주세요");
	    }else if(krname2 == ""){
	    	alert("이름을 입력해주세요");
	    }else if(kor_check.test(krname) || kor_check.test(krname2)){
	    	alert("한글만 입력할 수 있습니다.");
	    }else{
	    	/* window.krname = "engChangeNameForm"; */
	    	// window.open("open할 window", "자식창 이름", "팝업창 옵션");
		    //get방식 "Child?n성="+krname+"&이름2="+krname2,
	    	//    openWin = window.open("Child?name="+name+"&name2="+name2,
	        //    "childForm", "width=570, height=350, resizable = no, scrollbars = no");  
		    		openWin = window.open("engChange?krname="+krname+"&krname2="+krname2,    			
	    			"engChangeNameForm","width=570, height=350, resizable = no, scrollbars = no");
	    }
    }
    
    //==============================================================
    	//비밀번호 확인 예외처리 
    	join_infor2.addEventListener("focusout", function() {
		var pw = document.querySelector("#pw");
		var pwchk = document.querySelector("#pwchk");
		console.log("pw")
		console.log("pwchk");
		if(pw.value == "" && pwchk.value == "") {
			pwtext.innerHTML = "<span>비밀번호를 입력해주세요.</span>";
			pw.style.border="1px solid black";
			pwchk.style.border="1px solid black";
			pwtext.style.color="red"; 	
		}else if(pw.value == "" || pwchk.value == "") {
			pwtext.innerHTML = "<span>비밀번호를 입력해주세요.</span>";
		}else if(pw.value == pwchk.value) {
			pwtext.innerHTML = "비밀번호가 일치합니다.";
			pw.style.border="2px solid green";
			pwchk.style.border="2px solid green";
			pwtext.style.color="green";
			pwtext.style.fontWeight="bold";
		}else {
			pwtext.innerHTML = "<p id='nopwchk'>비밀번호가 일치하지 않습니다.</p>";
			pw.style.border="2px solid black";
			pwchk.style.border="2px solid red";
			nopwchk.style.color="red";
			nopwchk.style.fontWeight="bold";
		}
	});
   	//===========================================================
    	//===========id 중복확인 체크
		
		/* var join_id = document.getElementById("join_id");
		var id_chk = document.getElementById("id_chk");
		
		function idchkbtn(){
			location.href="idchk"	
		
		} */
    //===========================================================
    	// 가입하기누 버튼 누르는 순간 예외처리
		function reserve(){
			/* if(x == 1){
				alert("ID중복체크를 해주세요");
				join_id.focus;
				return false;
			} */if(id.value==""){
				alert("아이디를 입력해주세요");
				id.focus();
				return false;
			}else if(!idexpression.test(id.value)){
				alert("아이디 양식을 맞게 작성해주세요");
				id.focus();
				return false;
			}else if(pw.value == ""){
				alert("비밀번호를 입력해주세요");
				pw.focus();
				return false;
			}else if(!pwexpression.test(pw.value)){
				alert("비밀번호 양식을 맞게 작성해주세요");
				pw.focus();
				return false;
			}else if(!pwexpression.test(pwchk.value)){
				alert("비밀번호확인 양식을 맞게 작성해주세요");
				pwchk.focus();
				return false;
			}else if(pw.value != pwchk.value){
				alert("비밀번호 와 비밀번호확인란이 일치하지않습니다.");
				pw.focus();
				return false;
			}else if(krnam.value==""){
				alert("한글 성을 입력해주세요");
				krnam.focus();
				return false;
			}else if(krnam2.value==""){
				alert("한글 이름을 입력해주세요");
				krnam2.focus();
				return false;
			}else if(engnam.value==""){
				alert("영어이름변환을 해주세요");
				engnam.focus();
				return false;
			}else if(engnam2.value==""){
				alert("영어이름변환을 해주세요");
				engnam2.focus();
				return false;
			}else if(birth1.value==""){
				alert("생년월일 첫번째 칸을 작성해주세요");
				birth1.focus();
				return false;
			}else if(birth2.value==""){
				alert("생년월일 두번째 칸을 작성해주세요");
				birth2.focus();
				return false;
			}else if(birth3.value==""){
				alert("생년월일 셋번째 칸을 작성해주세요");
				birth3.focus();
				return false;
			}else if(email.value==""){
				alert("이메일을 입력 해주세요");
				email.focus();
				return false;
			}else if(phone_num.value==""){
				alert("휴대폰번호를 입력 해주세요");
				phone_num.focus();
				return false;
			}else if(wireline.value==""){
				alert("유선전화를 입력 해주세요");
				wireline.focus();
				return false;
			}else if(postcode.value==""){
				alert("우편번호를 입력 해주세요");
				postcode.focus();
				return false;
			}else if(roadaddress.value==""){
				alert("주소를 입력 해주세요");
				roadaddress.focus();
				return false;
			}else if(detailaddress.value==""){
				alert("상세주소를 입력 해주세요");
				detailaddress.focus();
				return false;
			}else if(!phoneexpression.test(phone_num.value)){
				alert("휴대폰번호 양식을 맞게작성해주세요(반드시-포함)");
				phone_num.focus();
				return false;
			}else if(!wirelineexpression.test(wireline.value)){
				alert("유선번호 양식을 맞게작성해주세요(반드시-포함,반드시 (02) 로시작)");
				wireline.focus();
				return false;
			}else if(!birth1expression.test(birth1.value)){
				alert("출생년도를 양식에 맞게 작성해주세요");
				birth1.focus();
				return false;
			}else if(!birth2expression.test(birth2.value)){
				alert("출생월을 양식에 맞게 작성해주세요");
				birth2.focus();
				return false;
			}else if(!birth3expression.test(birth3.value)){
				alert("출생일을 양식에 맞게 작성해주세요");
				birth3.focus();
				return false;
			}
			return true;
			}
    	
</script>
</html>