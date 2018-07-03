<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결제성공</title>
<%@ include file = "../include/head.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<div class = "container">
 <div class = "row">
  <div class = "col-lg-5 offset-lg-3 text-center">
   <br><br><br>
   <h3>결제에 성공하였습니다.</h3><br><br>
   <table class = "table">
    <thead>
     <tr>
      <td>원 포인트</td>
      <td>결제 금액</td>
      <td>현 포인트</td>
     </tr>
    </thead>
    <tbody>
     <tr>
      <td>${currentPoint}</td>
      <td>${sumPrice}</td>
      <td>${deductPoint}</td>
     </tr>
    </tbody>
   </table>
   <br>
   <a href = "${path}"><span>메인화면으로</span></a>
  </div>
 </div>
</div>
</body>
</html>