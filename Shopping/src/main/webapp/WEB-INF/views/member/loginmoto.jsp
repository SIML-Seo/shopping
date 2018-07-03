<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<%@ include file = "../include/head.jsp" %>
<script>
$(function(){
 $("#searchId").click(function(){
  var nameForId = $("#nameForId").val();
  var emailForId = $("#emailForId").val();
  var param = "nameForId=" + nameForId + "&emailForId=" + emailForId;
  $.ajax({
   type: "post",
   url: "${path}/login/searchId",
   data: param,
   success: function(result){
	$("#nameForId").val("");
	$("#emailForId").val("");
    alert(result);
   }
  })
 });
 $("#searchPass").click(function(){
  var nameForPass = $("#nameForPass").val();
  var emailForPass = $("#emailForPass").val();
  var idForPass = $("#idForPass").val();
  var param = "nameForPass=" + nameForPass + "&emailForPass=" + emailForPass + "&idForPass=" + idForPass; 
  $.ajax({
   type: "post",
   url: "${path}/login/searchPass",
   data: param,
   success: function(result){
	$("#nameForPass").val("");
	$("#emailForPass").val("");
	$("#idForPass").val("");
    alert(result);
   }
  })
 });
});
</script>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<div class = "container">
<form:form commandName = "loginDTO" class = "form-horizontal">
  <div class="form-group">
   <label for = "inputId" class = "col-sm-2 control-label">ID</label>
   <div class = "col-sm-10">
    <form:input path = "id" class = "form-control" id = "inputId"/>
    <form:errors path = "id"/>
   </div>
  </div>
  <div class="form-group">
   <label for = "inputPw" class = "col-sm-2 control-label">PASSWORD</label>
   <div class = "col-sm-10">
    <form:password path = "passwd" class = "form-control" id = "inputPw"/>
    <form:errors path = "passwd"/>
   </div>
  </div>
  <div class="form-group">
   <div class="col-sm-offset-2 col-sm-10">
    <div class = "checkbox">
     <label>
      <form:checkbox path="rememberId"/> ID 기억하기
     </label>
    </div>
   </div>
  </div>
  <div class="form-group">
   <div class = "col-sm-offset-2 col-sm-10">
    <button type = "submit" class = "btn btn-default">로그인</button>
   </div>
  </div>
</form:form>

<br><br>
아이디 찾기
<form>
 <input type = "text" name = "nameForId" id = "nameForId" placeholder = "이름">
 <input type = "text" name = "emailForId" id = "emailForId" placeholder = "이메일">
 <button type = "button" id = "searchId">아이디 찾기</button>
</form>

<br><br>
비밀번호 찾기
<form>
 <input type = "text" name = "idForPass" id = "idForPass" placeholder = "ID">
 <input type = "text" name = "nameForPass" id = "nameForPass" placeholder = "이름">
 <input type = "text" name = "emailForPass" id = "emailForPass" placeholder = "이메일">
 <button type = "button" id = "searchPasswd">비밀번호 찾기</button>
</form>
</div>
</body>
</html>