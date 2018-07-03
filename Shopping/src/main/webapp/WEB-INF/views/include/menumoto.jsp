<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<a href = "${path}">Home</a> |
<a href = "${path}/member/join">회원가입</a>

<div style = "text-align:right;">
	<c:choose>
		<c:when test = "${sessionScope.loginUser == null}">
			<a href = "${path}/login">로그인</a>
		</c:when>
		<c:otherwise>
			로그인 중 : ${sessionScope.loginUser}
			<a href = "${path}/member">나의 정보</a>
			<a href = "${path}/logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
	<a href = "${path}/market/sell">상품판매</a>
	<a href = "${path}/market/list">상품리스트</a>
	<a href = "${path}/market/order/list">주문내역</a>
	<a href = "${path}/market/cart/list">장바구니</a>
	<a href = "${path}/board/list">문의게시판</a>
</div>