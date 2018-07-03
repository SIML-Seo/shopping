<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
<title>주문내역</title>
<%@ include file = "../include/head.jsp" %>
<script>
$(function() {                                
	var formObj = $("form[role='form']");                      

	$(".cancleBtn").click(function() {
		if(confirm("정말로 취소하시겠습니까?")){
			formObj.attr("action", "${path}/market/order/cancle");             
			formObj.submit();
		}
	});

	$(".takeBackBtn").click(function() {
		if(confirm("상품을 반품하시겠습니까?")){
			formObj.attr("action", "${path}/market/order/takeback");
			formObj.submit();
		}
	});
});

var result = "${result}";
if(result === "cancle"){
	alert("주문을 취소하였습니다.")
}else if(result === "takeback"){
	alert("반품 신청을 완료하였습니다.")
};

</script>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<div class = "container">
 <div class = "row">
  <table class = "table">
   <thead class="thead-light">
    <tr>
     <th>주문번호</th>
     <th>책정보</th>
     <th>지불금액</th>
     <th>진행상황</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach var = "order" items = "${orderList}">
     <tr>
      <th>${order.orderNum}</th>
      <th>
       <c:forTokens var = "bookInfo" items = "${order.bookInfo}" delims = ";">
        <c:set var = "bookIn" value = "${bookInfo}"/>
        <c:set var = "book" value = "${fn:split(bookIn, '|')}"/>	
        <a href = "${path}/market/info/${book[0]}"><img src = "${book[1]}"/></a>
       </c:forTokens>
      </th>
      <th>${order.money}</th>
      <th>
       ${order.status}
       <form role = "form" method = "post">
        <input type = "hidden" name = "userId" value = "${order.userId}"/>
        <input type = "hidden" name = "orderNum" value = "${order.orderNum}"/>
        <input type = "hidden" name = "money" value = "${order.money}"/>
        <input type = "hidden" name = "bookInfo" value = "${order.bookInfo}"/>
        <c:if test = "${order.status == '배송준비중'}">
         <button type = "submit" class = "cancleBtn">취소하기</button>
        </c:if>
        <c:if test = "${order.status == '배송중' or '배송완료'}">
         <button type = "submit" class = "takeBackBtn">반품하기</button>
        </c:if>
       </form>
      </th>
     </tr>
    </c:forEach>
   </tbody>
  </table>
 </div>
</div>
</body>
</html>