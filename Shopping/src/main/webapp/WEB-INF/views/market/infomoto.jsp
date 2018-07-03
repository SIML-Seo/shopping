<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제품 상세</title>
<%@ include file = "../include/head.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<form action = "${path}/market/cart/insert/${book.seq}">
 <table style = "border:1px solid black;">
  <tr>
   <td rowspan = "7">
    <img src = "${book.image}"/>
   </td>
   <td>
    <span>제목 : ${book.title}</span>
   </td>
  </tr>
  <tr>
   <td>
    <span>저자 : ${book.author}</span>
   </td>
  </tr>
  <tr>
   <td>
    <span>출판사 : ${book.publisher}</span>
   </td>
  </tr>
  <tr>
   <td>
    <span>출판일 : ${book.pubdate}</span>
   </td>
  </tr>
  <tr>
   <td>
    <span>ISBN : ${book.isbn}</span>
   </td>
  </tr>
  <tr>
   <td>
    <span>원가격 : ${book.price}</span>
   </td>
  </tr>
  <tr>
   <td>
    <span>중고가 : ${book.secondPrice}</span>
   </td>
  </tr>
 </table>
 <input type = "submit" value = "장바구니에 넣기"/>
 <input type = "button" value = "뒤로가기" onclick = "history.go(-1);"/>
</form>	
</body>
</html>