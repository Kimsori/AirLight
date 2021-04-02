<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/png" href="resources/img/PIcon.png">
<title>airLight</title>
</head>
<body>
<h1>영어이름 번역기</h1>
<input type="text" id="nameEng1" value="${english }"><input type="text" id="nameEng2" value="${english2 } ">
<input type="button" value="전달하기" onclick="setParentText()">
<input type="button" value="창닫기" onclick="window.close()">
<script>
var nameEng2 = document.getElementById("nameEng2").value.split("-");
console.log(nameEng2[0]);
console.log(nameEng2[1]);
function setParentText(){
	var eng_check = /^[a-zA-Z\s]+$/;
	if(document.getElementById("nameEng1").value == ""){
		alert("(영어)성을 입력해주세요");
		document.getElementById("nameEng1").focus();
	}else if(document.getElementById("nameEng2").value == ""){
		alert("(영어)이름을 입력해주세요");
		document.getElementById("nameEng2").focus();
	}else if(!eng_check.test(document.getElementById("nameEng1").value) || !eng_check.test(document.getElementById("nameEng2").value)){
		alert("영어만 입력할 수 있습니다.");
	}else{
		// opener.document.getElementById("부모 인풋 ID 이름").value = document.getElementById("자식 인풋 ID 이름").value 
		opener.document.getElementById("engname").value = document.getElementById("nameEng1").value;
		
	    if(nameEng2[1] === undefined){ // === 는 타입이 맞냐 물어보는것이고 == 는 value 값을 비교하는것이다. 
	    	opener.document.getElementById("engname2").value = document.getElementById("nameEng2").value;
		    window.close();
	    }else{
	    	/* opener.document.getElementById("engname2").value = nameEng2[0]+nameEng2[1];  */
	    	opener.document.getElementById("engname2").value = document.getElementById("nameEng2").value;
	    	window.close();
	    }
		
	}
	
}
</script>
</body>
</html>