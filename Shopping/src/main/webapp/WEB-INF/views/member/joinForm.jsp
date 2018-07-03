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
    }else if(id.length < 4){
     alert("ID가 바람직하지 않습니다.")
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
<%@ include file = "../include/menu.jsp" %>
<div class="container">
 <div class="row">
  <div class="col-lg-8 offset-lg-2">
   <h1 class="entry-title"><span>회원가입</span></h1>
   <hr>
   <form:form commandName = "memberDTO" action = "joinResult">        
   <div class="form-group row">
    <label class="col-form-label col-lg-3">이름 <span class="text-danger">*</span></label>
    <div class="col-lg-5">
     <div class="input-group">
      <form:input path = "name" class="form-control" placeholder="이름을 입력해 주세요."/>
      <form:errors path = "name"/>
     </div>
    </div>
   </div>
   <div class="form-group row">
    <label class="col-form-label col-lg-3">아이디 <span class="text-danger">*</span></label>
    <div class="col-lg-7">
     <div class="input-group">
      <form:input path = "id" id = "id" class="form-control" placeholder="영문, 숫자 조합의 4~11자"/>
      &nbsp;&nbsp;
      <button type = "button" id = "idCheck" class="btn ">중복확인</button>
      <form:errors path = "id"/>
     </div>
    </div>
   </div>
   <div class="form-group row">
    <label class="col-form-label col-lg-3">닉네임 <span class="text-danger">*</span></label>
    <div class="col-lg-5">
     <div class="input-group">
      <form:input path = "nickname" class="form-control" />
      <form:errors path = "nickname"/>
     </div>
    </div>
   </div>
   <div class="form-group row">
    <label class="col-form-label col-lg-3">패스워드 <span class="text-danger">*</span></label>
    <div class="col-lg-5">
     <div class="input-group">
      <form:password path="passwd" class="form-control" />
      <form:errors path = "passwd"/>      
     </div>   
    </div>
   </div>
   <div class="form-group row">
    <label class="col-form-label col-lg-3">패스워드확인 <span class="text-danger">*</span></label>
    <div class="col-lg-5">
     <div class="input-group">
      <form:password path="confirmPasswd" class="form-control" />
      <form:errors path = "confirmPasswd"/>      
     </div>  
    </div>
   </div>
   <div class="form-group row">
    <label class="col-form-label col-lg-3">이메일 <span class="text-danger">*</span></label>
    <div class="col-lg-8">
     <div class="input-group">
      <form:input path="email" class="form-control" />
      <form:errors path = "email"/>
     </div>  
     <small id="emailHelp" class="form-text text-muted">가입 정보 확인시 이용됩니다.</small>
    </div>
   </div>
   <div class="form-group row">
    <label class="col-form-label col-lg-3">전화번호 <span class="text-danger">*</span></label>
    <div class="col-lg-8">
     <div class="input-group">
      <form:input path="phone" class="form-control" placeholder= "012-3456-7890의 형식"/>
      <form:errors path = "phone"/>      
     </div>  
    </div>
   </div>
   <div class="form-group row">
    <label class="col-form-label col-lg-3">주소 <span class="text-danger">*</span></label>
    <div class="col-lg-8">
     <div class="input-group row">
      <div class = "col-lg-4">
      <form:input path = "postcode" class="form-control" placeholder="우편번호" id = "postcode"/> 
      </div>
      <div class = "col-lg-3">
      <input type="button" class="btn " onclick="execDaumPostcode()" value="우편번호 찾기"><br>
      </div>
     </div>  
     <div class="input-group">
      <form:input path = "address" class="form-control" placeholder="주소" id = "address"/> 
      <form:errors path = "address"/>
     </div>  
     <div class = "input-group">
      <form:input path = "address2" class="form-control" id="address2" placeholder="상세주소"/>
      <form:errors path = "address2"/>
     </div>
    </div>
   </div>
   <div class="form-group">
    <div class="col-lg-10 offset-lg-5"><br><br>
     <input type = "submit" class="btn btn-primary" value = "가입하기"/>
    </div>
   </div>
  </form:form>
 </div>
</div>
</div>
</body>
</html>