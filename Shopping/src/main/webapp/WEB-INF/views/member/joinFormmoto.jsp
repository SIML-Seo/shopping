<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<%@ include file = "../include/head.jsp" %>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
 function execDaumPostcode() {
  new daum.Postcode({
   oncomplete: function(data) {
    var fullAddr = '';
    var extraAddr = ''; 

    if (data.userSelectedType === 'R') {
     fullAddr = data.roadAddress;
    } else {
     fullAddr = data.jibunAddress;
    }

    if(data.userSelectedType === 'R'){
     if(data.bname !== ''){
      extraAddr += data.bname;
     }
     if(data.buildingName !== ''){
      extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
     }
     fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
    }

    document.getElementById('postcode').value = data.zonecode;
    document.getElementById('address').value = fullAddr;
    
    document.getElementById('address2').focus();
   }
  }).open();
 }
$(function(){
 $("#idCheck").click(function(){
  var id = $("#id").val();
  $.ajax({
   type: "POST",
   url: "${path}/member/idCheck?id=" + id,
   success: function(result){
    if(result === true){
     alert("존재하는 ID입니다. 다시 입력해주세요.");
    }else{
     alert("가입가능한 ID입니다.");
    }
   }
  })
 });
});
</script>
</head>
<body>
 <form:form commandName = "memberDTO" action = "joinResult">
  <p>
   <label>이름 : </label>
   <form:input path ="name"/>
   <form:errors path = "name"/>
  </p>
  <p>
   <label>아이디 : </label>
   <form:input path ="id" id = "id" placeholder = "영문, 숫자 조합의 4~11자"/>
   <button type = "button" id = "idCheck">중복확인</button>  
   <form:errors path = "id"/>
  </p>
  <p>
   <label>닉네임 : </label>
   <form:input path = "nickname"/>
   <form:errors path = "nickname"/>
  </p>
  <p>
   <label>패스워드 : </label>
   <form:password path = "passwd"/>
   <form:errors path = "passwd"/>
  </p>
  <p>
   <label>패스워드확인 : </label>
   <form:password path = "confirmPasswd"/>
   <form:errors path = "confirmPasswd"/>
  </p>
  <p>
   <label>이메일 : </label>
   <form:input path = "email"/>
   <form:errors path = "email"/>
  </p>
  <p>
   <label>전화번호 : </label>
   <form:input path = "phone" placeholder= "012-3456-7890의 형식"/>
   <form:errors path = "phone"/>
  </p>
  <p>
   <form:input path = "postcode" placeholder="우편번호" id = "postcode"/> 
   <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
   <form:input path = "address" placeholder="주소" id = "address"/>
   <form:input path = "address2" id="address2" placeholder="상세주소"/>
   <form:errors path = "address"/>
   <form:errors path = "address2"/>
  </p>
  <input type = "submit" value = "가입하기"/>
 </form:form>
</body>
</html>