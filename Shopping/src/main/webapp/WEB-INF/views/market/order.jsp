<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file = "../include/head.jsp" %>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
<title>주문하기</title>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
 <div class="container">
  <form action = "${path}/market/order/result">
  <div class="row">
   <br>
   <div class="col-lg-12">
    <div class="card border-primary">
     <div class="card-header text-center">
      <h4>주문 상품</h4>
     </div>
     <div class="card-body">
      <ul class="list-group list-group-flush">
       <c:forEach var = "book" items = "${map.list}">
        <li class="list-group-item text-center">
         <img class="pull-left" src="${book.image}" style="width: 10%; height: 10%;"><span class="align-middle">${book.title}</span>
        </li>
        <input type = "hidden" name = "bookNum" value = "${book.bookNum}"/>
        <input type = "hidden" name = "bookImage" value = "${book.image}"/>
       </c:forEach>
      </ul>
     </div>
    </div>
    <br>
   </div>
   <div class = "row col-lg-12" style = "padding-left:50px; margin-bottom: 10px;">
    <div class = "col-lg-8">
     <div class = "card border-info" style = "height: 20rem;">
      <div class = "card-header text-center">
       <h4>배송지 정보</h4>
       </div>
      <div class = "card-body">
       <div class="col-md-12">
        <strong>받는 이</strong>
        <div class="pull-right">
         <span>${map.dto.name}</span>
        </div>
       </div>
      </div>
      <div class = "card-body">
       <div class="col-md-12">
        <strong>전화번호</strong>
        <div class="pull-right">
         <span>${map.dto.phone}</span>
        </div>
       </div>
      </div>
      <div class = "card-body">
       <div class="col-md-12">
        <strong>주소지</strong>
        <div class="pull-right">
         <span>(${map.dto.postcode}) ${map.dto.address} ${map.dto.address2}</span>
        </div>
       </div>
      </div>
     </div>
    </div>
    <div class="col-lg-4">
     <div class="card border-success" style = "height: 20rem;">
      <div class="card-header text-center">
       <h4>총 주문 금액</h4>
      </div>
     <div class="card-body">
      <div class="col-md-12">
       <strong>주문금액</strong>
       <div class="pull-right">
        <span>${map.sumMoney}</span>
       </div>
      </div>
      <div class="col-md-12">
       <strong>배송료</strong>
       <div class="pull-right">
        <span>${map.fee}</span>
       </div>
      </div>
      <div class="col-md-12">
       <strong>결제금액</strong>
       <div class="pull-right">
        <span>${map.sum}</span>
       </div>
       <hr>
      </div>
      <div class="col-md-12">
       <strong>소지 포인트</strong>
       <div class="pull-right">
        <span>${map.dto.point}</span>
       </div>
       <hr>
      </div>
      <input type = "hidden" name = "sumPrice" value = "${map.sum}"/>
      <button type="submit" class="btn btn-success btn-lg btn-block">결제하기</button>
     </div>
    </div>
   </div>
   <br>
  </div>
 </div>
 </form>
</div>
</body>
</html>