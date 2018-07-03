<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 등록</title>
<%@ include file = "../include/head.jsp" %>
<script>
$(function(){
	$("#submit").click(function(e){
	 var title = $("#title").val();
		if(title === ""){
			alert("책을 검색하시지 않으셨습니다.");
			return false;
		}
	})
});

function searchOpen(){
	window.open("${path}/market/searchForm", "검색", "width=600px, height=600px, resizable='no'");
}
</script>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<c:set var = "id" value = "${sessionScope.loginUser}"/>
<br>
<div class = "container">
 <form id = "formofsell" action = "${path}/market/sellRegist">
 <div class="card">
  <div class="row">
   <aside class="col-lg-5 border-right">
    <article>
     <div>
      <div id = "img">
      </div>
     </div>
    </article>
   </aside>
   <aside class="col-lg-7">
    <article class="card-body p-5">
     <h3 class="title mb-3" id="title_p"></h3>
     <p class="price-deail-wrap">
      <span class="price h3 text-warning">
       <span class="currency">원가격 : </span>
       <span class="num" id ="price_p"></span>
      </span> 
     </p>
     <dl class="item-property">
      <dt>저자</dt>
      <dd>
       <p id="author_p"></p>
      </dd>
     </dl>
     <dl class="param param-feature">
      <dt>출판사</dt>
      <dd id = "publisher_p"></dd>
     </dl>
     <dl class="param param-feature">
      <dt>출판일</dt>
      <dd id="pubdate_p"></dd>
     </dl>
     <dl class="param param-feature">
      <dt>ISBN</dt>
      <dd id="isbn_p"></dd>
     </dl>
     <hr>
     <button type = "button" class="btn btn-lg btn-primary text-uppercase" onclick = "searchOpen();">상품검색</button>
     <button type = "submit" id = "submit" class="btn btn-lg btn-primary text-uppercase">판매</button>
     <button type = "button" class="btn btn-lg btn-outline-primary text-uppercase" onclick = "history.go(-1);">뒤로가기</button>
    </article>
   </aside>
  </div>
 </div>
 <input type = "hidden" name = "title" id = "title"/>
 <input type = "hidden" name = "author" id = "author"/>
 <input type = "hidden" name = "publisher" id = "publisher"/>
 <input type = "hidden" name = "price" id = "price"/>
 <input type = "hidden" name = "pubdate" id = "pubdate"/>
 <input type = "hidden" name = "isbn" id = "isbn"/>
 <input type = "hidden" name = "link" id = "link"/>
 <input type = "hidden" name = "image" id = "image"/>
 <input type = "hidden" name = "id" id = "id" value = "${id}"/>
 </form>
</div>
</body>
</html>