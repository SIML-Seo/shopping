<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니</title>
<%@ include file = "../include/head.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<script>
$(function(){
	$("#btnList").click(function(){
        location.href  = "${path}/market/list";
    });
	$("#btnOrder").click(function(){
        location.href  = "${path}/market/cart/order";
    });
    $("#btnDelete").click(function(){
        if(confirm("장바구니를 비우겠습니까?")){
            location.href = "${path}/market/cart/deleteAll";
        }
    });
})

var result = "${result}";
if (result === "insert"){
	alert("장바구니에 책을 넣었습니다.")
}else if (result === "delete"){
	alert("해당 상품을 삭제하였습니다.")
}else if (result === "deleteAll"){
	alert("장바구니를 비웠습니다.")
}else if (result === "lack"){
	alert("소지 포인트가 부족하여 주문에 실패했습니다.")
}
</script>
<c:choose>
 <c:when test = "${map.count == 0}">
  장바구니가 비었습니다.
 </c:when>
 <c:otherwise>
  <form action = "${path}/market/cart/update">
   <table style = "border : 1px solid black;">
    <tr>
     <th>책</th>
     <th>제목</th>
     <th>책 판매등록일</th>
     <th>가격</th>
     <th>&nbsp;</th>
    </tr>
    <c:forEach var = "book" items ="${map.list}">
     <tr>
      <td><img src = "${book.image}"></td>
      <td>${book.title}</td>
      <fmt:formatDate var = "date" value = "${book.sellDate}" pattern = "yyyy-MM-dd"/>
      <td>${date}</td>
      <td>${book.secondPrice}</td>
      <td><a href = "${path}/market/cart/delete?seq=${book.seq}">삭제</a></td>
     </tr>
    </c:forEach>
    <tr>
     <td>
      장바구니 합계 : ${map.sumMoney}<br>
      배송료 : ${map.fee}<br>
      지불료 : ${map.sum}
     </td>
    </tr>
   </table>
  </form>
  <button type = "button" id = "btnOrder">주문하기</button>
  <button type = "button" id = "btnDelete">장바구니 비우기</button>
 </c:otherwise>
</c:choose>
<button type = "button" id = "btnList">상품목록</button>
</body>
</html>