<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 상세 페이지</title>
<%@ include file = "../include/head.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<br>
<div class = "container">
 <form action = "${path}/market/cart/insert">
 <input type = "hidden" name = "seq" value = "${book.seq}"/>
 <div class="card">
  <div class="row">
   <aside class="col-lg-5 border-right">
    <article>
     <div>
      <div>
       <img src="${book.image}" class="rounded mx-auto d-block" style = "width: 80%; height: 80%;">
      </div>
     </div>
    </article>
   </aside>
   <aside class="col-lg-7">
    <article class="card-body p-5">
     <h3 class="title mb-3">${book.title}</h3>
     <p class="price-detail-wrap">
      <span class="price h3 text-warning">
       <span class="currency">중고가 : </span>
       <span class="num">${book.secondPrice}</span>
      </span> 
      <span>원가격 : ${book.price}</span>
     </p>
     <dl class="item-property">
      <dt>저자</dt>
      <dd>
       <p>${book.author}</p>
      </dd>
     </dl>
     <dl class="param param-feature">
      <dt>출판사</dt>
      <dd>${book.publisher}</dd>
     </dl>
     <dl class="param param-feature">
      <fmt:parseDate var = "parDate" value = "${book.pubdate}" pattern = "yyyyMMdd"/>
      <fmt:formatDate var = "date" value = "${parDate}" pattern = "yyyy년 MM월 dd일"/>
      <dt>출판일</dt>
      <dd>${date}</dd>
     </dl>
     <dl class="param param-feature">
      <dt>ISBN</dt>
      <dd>${book.isbn}</dd>
     </dl>
     <hr>
     <c:if test = "${book.status == '재고'}">
      <button type = "submit" class="btn btn-lg btn-primary text-uppercase">장바구니에 넣기</button>
     </c:if> 
     <button type = "button" class="btn btn-lg btn-outline-primary text-uppercase" onclick = "history.go(-1);">뒤로가기</button>
    </article>
   </aside>
  </div>
 </div>
 </form>
</div>
</body>
</html>