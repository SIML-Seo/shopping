<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<style>
.panel-login>.panel-heading a{
	text-decoration: none;
	color: #666;
	font-weight: bold;
	font-size: 15px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}
.panel-login>.panel-heading a.active{
	color: #029f5b;
	font-size: 18px;
}
</style>
<%@ include file = "../include/head.jsp" %>

<script>
$(function(){
 $('#login-form-link').click(function(e) {
  $("#login-form").delay(100).fadeIn(100);
  $("#forgot-form").fadeOut(100);
  $('#forgot-form-link').removeClass('active');
  $(this).addClass('active');
  e.preventDefault();
 });
   
 $('#forgot-form-link').click(function(e) {
  $("#forgot-form").delay(100).fadeIn(100);
  $("#login-form").fadeOut(100);
  $('#login-form-link').removeClass('active');
  $(this).addClass('active');
  e.preventDefault();
 });
	
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
 
 $("#searchPasswd").click(function(){
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
<div class="container" style = "padding-top : 50px;">
 <div class="row">
  <div class="col-lg-6 offset-lg-3">
   <div class="panel panel-login">
    <div class="panel-heading">
     <div class="row">
      <div class="col-lg-6 text-center">
       <a href="#" class="active" id="login-form-link">Login</a>
      </div>
      <div class="col-lg-6 text-center">
       <a href="#" id="forgot-form-link">Forgot</a>
      </div>
     </div>
     <hr>
    </div>
    <div class="panel-body">
     <div class="row">
      <div class="col-lg-12">
       <form:form commandName = "loginDTO" id="login-form" style="display: block;">
        <div class="form-group">
         <form:input path = "id" id="inputId" class="form-control" placeholder="ID"/>
         <form:errors path = "id"/>
        </div>
        <div class="form-group">
         <form:password path = "passwd" id="inputPw" class="form-control" placeholder="Password"/>
         <form:errors path = "passwd"/>
        </div>
        <div class="form-group text-center">
         <form:checkbox path="rememberId" id = "remember"/>
         <label for="remember"> ID 기억하기</label>
        </div>
        <div class="form-group">
         <div class="row">
          <div class="col-lg-6 offset-lg-3">
           <button type="submit" class="form-control btn btn-success">Log In</button>
          </div>
         </div>
        </div>
       </form:form>
       <form id="forgot-form" style="display: none;">
        <div class="form-group">
         <input type = "text" name = "nameForId" id = "nameForId" class="form-control" placeholder = "이름">
        </div>
        <div class="form-group">
         <input type = "text" name = "emailForId" id = "emailForId" class="form-control" placeholder = "이메일">
        </div>
        <div class = "form-group">
         <div class="row">
          <div class="col-lg-6 offset-lg-3">
           <button type = "button" id = "searchId" class = "btn btn-success form-control">아이디 찾기</button>
          </div>
         </div>
        </div>
        <hr><hr>
        <div class="form-group">
          <input type = "text" name = "idForPass" id = "idForPass" class="form-control" placeholder = "ID">
        </div>
        <div class="form-group">
         <input type = "text" name = "nameForPass" id = "nameForPass" class="form-control" placeholder = "이름">
        </div>
        <div class="form-group">
         <input type = "text" name = "emailForPass" id = "emailForPass" class="form-control" placeholder = "이메일">
        </div>
        <div class = "form-group">
         <div class="row">
          <div class="col-lg-6 offset-lg-3">
           <button type = "button" id = "searchPasswd" class = "btn btn-success form-control">비밀번호 찾기</button>
          </div>
         </div>
        </div>
       </form>
      </div>
     </div>
    </div>
   </div>
  </div>
 </div>
</div>
</body>
</html>