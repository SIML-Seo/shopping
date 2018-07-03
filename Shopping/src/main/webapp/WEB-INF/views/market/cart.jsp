<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니</title>
<%@ include file = "../include/head.jsp" %>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
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
 <div class="container mb-4">
  <div class="row">
   <div class="col-12">
    <div class="table-responsive">
     <form action = "${path}/market/cart/update" method = "post">
      <table class="table table-striped">
       <thead>
        <tr>
         <th scope="col"> </th>
         <th scope="col">제목</th>
         <th scope="col">책 판매등록일</th>
         <th scope="col" class="text-center">가격</th>
         <th> </th>
        </tr>
       </thead>
       <tbody>
        <c:choose>
         <c:when test = "${map.count == 0}">
          <tr>
           <td colspan = "5" class = "text-center">장바구니가 비었습니다.</td>
          </tr>
         </c:when>
         <c:otherwise>
          <c:forEach var = "book" items ="${map.list}">
           <tr>
            <td><img src = "${book.image}"></td>
            <td>${book.title}</td>
            <fmt:formatDate var = "date" value = "${book.sellDate}" pattern = "yyyy-MM-dd"/>
            <td>${date}</td>
            <td>${book.secondPrice} 원</td>
            <td class="text-right"><a href = "${path}/market/cart/delete?seq=${book.seq}" role = "button" class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </a> </td>
           </tr>
          </c:forEach>
         </c:otherwise>
        </c:choose>
        <tr>
         <td></td>
         <td></td>
         <td></td>
         <td>상품가</td>
         <td class="text-right"><c:if test = "${map.count != 0}">${map.sumMoney}</c:if> 원</td>
        </tr>
        <tr>
         <td></td>
         <td></td>
         <td></td>
         <td>배송료</td>
         <td class="text-right"><c:if test = "${map.count != 0}">${map.fee}</c:if> 원</td>
        </tr>
        <tr>
         <td></td>
         <td></td>
         <td></td>
         <td><strong>합계</strong></td>
         <td class="text-right"><strong><c:if test = "${map.count != 0}">${map.sum}</c:if> 원</strong></td>
        </tr>
       </tbody>
      </table>
     </form>
    </div>
   </div>
   <div class="col mb-2">
    <div class="row">
     <br><br>
     <div class="col-lg-4">
      <button type = "button" id = "btnList" class="btn btn-lg btn-block btn-light">상품 페이지</button>
     </div>
     <div class="col-lg-4 text-right">
      <button type = "button" id = "btnDelete" class="btn btn-lg btn-block btn-secondory">장바구니 비우기</button>
     </div>
     <div class="col-lg-4 text-right">
      <button type = "button" id = "btnOrder" class="btn btn-lg btn-block btn-success">주문하기</button>
     </div>
    </div>
   </div>
  </div>
 </div>
</body>
</html>