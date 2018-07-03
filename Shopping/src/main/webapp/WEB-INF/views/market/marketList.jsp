<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>판매 리스트</title>
<%@ include file = "../include/head.jsp" %>
<script src = "${path}/include/jquery.livequery.js"></script>
<link rel = "stylesheet" href = "${path}/styles/css.css">
<script>
 $(function(){
	 var single_li_offset = 200;
	 var current_opened_box = -1;
	 $("#wrap li").click(function(){
		 var thisID = $(this).attr("id");
		 var $this = $(this);
		 
		 var id = $("#wrap li").index($this);
		 
		 if(current_opened_box == id){
			 $("#wrap .detail-view").slideUp("slow");
			 return false;
		 }
		 $("#wrap .detail-view").slideUp("slow");
		 
		 current_opened_box = id;
		 
		 var targetOffset = 0;
		 
		 if(id <= 3)
			 targetOffset = 0;
		 else if(id <= 7)
			 targetOffset = single_li_offset;
		 else if(id <= 11)
			 targetOffset = single_li_offset*2;
		 else if(id <= 15)
			 targetOffset = single_li_offset*3;
		 
		 $("html:not(:animated), body:not(:animated)").animate({scrollTop: targetOffset}, 800, function(){
			 $("#wrap #detail-"+thisID).slideDown(500);
			 return false;
		 });
	 });
	 
	 $(".close a").click(function(){
		 $("#wrap .detail-view").slideUp("slow");
	 })
 });
 
 var result = "${result}";
 if(result === "insert"){
	alert("장바구니에 넣었습니다.");
 };
</script>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<div class="container">
 <div class="row">
  <div class="col-lg-2">
    <br><br>
     <div class="list-group">
        <a href="#" class="list-group-item list-group-item-warning">책 목록</a>
        <a href="${path}/market/list/가" class="list-group-item">ㄱ-ㄹ</a>
        <a href="${path}/market/list/마" class="list-group-item">ㅁ~ㅇ</a>
        <a href="${path}/market/list/자" class="list-group-item">ㅈ~ㅎ</a>
        <a href="${path}/market/list/a" class="list-group-item">A~0</a>
     </div>
   </div>
   <div class="col-lg-10">
	<div id = "wrap" align = "center">
	 <ul>
	  <c:forEach var = "book" items = "${list}">
	   <li id = "${book.seq}">
	    <img src = "${book.image}" class = "items" height = "100">
	    <br>
	    <div class="text-truncate rounded">${book.title}</div>
	   </li>
	   <div class = "detail-view" id = "detail-${book.seq}">
	    <div class = "close" align = "right">
	     <a href = "#">x</a>
	    </div>
	    <img src = "${book.image}" class = "detail_images" width = "240" height = "310">
	    <div class = "detail_info">
	     <label class = "item_name">${book.title}</label>
	     <br>
	     <p>
	      저자 : ${book.author}<br>
	      출판사 : ${book.publisher}<br>
	      출판일 : ${book.pubdate}<br>
	      ISBN : ${book.isbn}<br>
	      원가격 : ${book.price}<br>
	      중고가 : ${book.secondPrice}
	     </p>
	     <br>
	     <form action = "${path}/market/cart/insert">
	      <input type = "hidden" name = "seq" value = "${book.seq}">
	      <button type = "submit">장바구니에 넣기</button>
	     </form>
	    </div>
	   </div>
	  </c:forEach>
	 </ul>
	</div>
   </div>
  </div>
 </div>
</body>
</html>