<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>약관 동의</title>
<%@ include file = "../include/head.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<script>
$(function(){
 $("#check").click(function(){
  var check = $("#agree").is(":checked");
  if(!check){
   alert("약관에 동의하셔야 가입이 가능합니다.");
  }
  form1.submit();
 });	
});
</script>
<div class = "container">
 <div class = "row">
  <div class="col-lg-8 offset-lg-2">
   <h1 class="entry-title"><span>회원가입 약관</span></h1>
   <hr>
   <textarea rows="5" class = "form-control" style="resize: none;">
    SIML 쇼핑몰 회원 가입 약관 개요
    가나다라마바사아자차카타파하
    가나다라마바사아자차카타파하
    가나다라마바사아자차카타파하
    가나다라마바사아자차카타파하
    가나다라마바사아자차카타파하
    가나다라마바사아자차카타파하
    가나다라마바사아자차카타파하
    가나다라마바사아자차카타파하
   </textarea>
　　 <form action = "joinForm" method = "post" id = "form1">
    <div class = "form-group text-center">
     <label class = "col-form-label col-lg-7" for = "agree">회원가입약관을 읽었으며 내용에 동의합니다.</label>
     <input type = "checkbox" name = "agree" value = "true" id = "agree">
    </div>
    <div class = "form-group">
     <div class = "col-lg-2 offset-lg-5">   
      <button type = "button" id = "check" class = "btn"> 가입하기</button>
     </div>
    </div>
    <div class = "text-center">
     <a href = "<c:url value = '/'/>">돌아가기</a>
    </div>
   </form>
  </div>
 </div>
</div>
</body>
</html>