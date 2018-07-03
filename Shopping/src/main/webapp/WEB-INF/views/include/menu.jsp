<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var = "path" value = "${pageContext.request.contextPath}"/>
<link href="${path}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style>
body {
  padding-top: 64px;
}

@media (min-width: 992px) {
  body {
    padding-top: 66px;
  }
}
</style>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <div class="container">
    <a class="navbar-brand" href="${path}">Siml's BookShop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="${path}">Home
            <span class="sr-only">(current)</span>
          </a>
        </li>
        <c:choose>
         <c:when test = "${sessionScope.loginUser == null}">
          <li class="nav-item">
            <a class="nav-link" href="${path}/login">로그인</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${path}/member/join">회원가입</a>
          </li>
         </c:when>
         <c:otherwise>
          <li class="nav-item">
           <a class="nav-link" href="${path}/member">나의정보</a>
          </li>
          <li class="nav-item">
           <a class="nav-link" href="${path}/logout">로그아웃</a>
          </li>
         </c:otherwise>
        </c:choose>
        <li class="nav-item">
          <a class="nav-link" href="${path}/market/sell">상품판매</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${path}/market/list">상품리스트</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${path}/market/order/list">주문내역</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${path}/market/cart/list">장바구니</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${path}/board/list">문의게시판</a>
        </li>
      </ul>
    </div>
  </div>
</nav>