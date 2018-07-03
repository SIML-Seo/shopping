<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>판매 리스트</title>
<%@ include file = "../include/head.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<c:forEach var = "book" items = "${list}">
 <div style = "border : 1px solid black; margin : 8px; width : 100px; height: 100px; display: inline-block;">
  <span><img src = "${book.image}"></span><br>
  <span><a href = "${path}/market/info/${book.seq}">${book.title}</a></span>
  <a href = "${path}/market/cart/insert/${book.seq}"><span>장바구니에 넣기</span></a>
 </div>
</c:forEach>
</body>
</html>