<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주문하기</title>
<%@ include file = "../include/head.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<form action = "${path}/market/order/result">
 <table>
  <tr>
   <td colspan = "2">책 정보</td>
  </tr>
  <tr>
   <c:forEach var = "book" items = "${map.list}">
    <td><img src = "${book.image}"></td>
    <td>${book.title}</td>
    <input type = "hidden" name = "bookNum" value = "${book.bookNum}"/>
    <input type = "hidden" name = "bookImage" value = "${book.image}"/>
    <br>
   </c:forEach>
  </tr>
  <tr>
   <td>주문금액</td>
   <td>${map.sumMoney}</td>
   <td>배송료</td>
   <td>${map.fee}</td>
  </tr>
 </table>
 배송지 정보 <br>
 <span>받는 이 : ${map.dto.name}</span><br>
 <span>전화번호 : ${map.dto.phone}</span><br>
 <span>주소지 : (${map.dto.postcode}) ${map.dto.address} ${map.dto.address2}</span>
 <br><br>
 소지 포인트 : ${map.dto.point}
 <br><br>
 결제금액 : ${map.sum}
 <input type = "hidden" name = "sumPrice" value = "${map.sum}"/>
 <input type = "submit" value = "결제하기"/>
</form>
</body>
</html>