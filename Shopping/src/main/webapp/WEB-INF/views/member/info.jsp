<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file = "../include/head.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<div class = "container">
 <div class = "row">
  <div class = "col-lg-5 offset-lg-3 text-center"><br>
   <span>현재 소지 포인트 : ${point}</span><br><br>
  </div>
 </div>
 <div class = "row">
  <div class = "col-lg-2 offset-lg-3">
   <a href = "${path}/member/update/${loginUser}" role = "button" class = "btn btn-info btn-lg btn-block">회원정보 수정</a>
  </div>
  <div class = "col-lg-2 offset-lg-1">
   <a href = "${path}/member/delete/${loginUser}" role = "button" class = "btn btn-info btn-lg btn-block">회원 탈퇴</a>
  </div>
 </div>
</div>
</body>
</html>