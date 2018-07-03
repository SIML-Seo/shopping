<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정</title>
<%@ include file = "../include/head.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<script>
$(function(){
    var formObj = $("form[role='form']");

    $(".modBtn").click(function(){
        formObj.submit();
    });

    $(".cancelBtn").click(function(){
        history.go(-1);
    });

    $(".listBtn").click(function(){
        location.href = "${path}/board/list"
    });

});
</script>
<div class = "container">
 <div class = "col-lg-10 offset-lg-1">
  <form role="form" method="post">
   <div>
    <div>
     <input type = "hidden" name="seq" value="${article.seq}">
     <h3>게시글 수정</h3><hr>
    </div>
    <div style = "padding-left : 10px;">
     <div class = "form-group">
      <label for =  "title">제목</label>
      <input id="title" class = "form-control" name="title" value="${article.title}"><br>
     </div>
     <div class = "form-group">
      <label for =  "content">내용</label>
      <textarea id="content"class = "form-control"  name="content" rows="15" style="resize: none;">${article.content}</textarea><br>
     </div>
     <div class = "form-group">
      <label>작성자</label>
      <input id="writer" class = "form-control" name="writer" value="${article.writer}" readonly><br>
     </div>
     <div class = "offset-lg-9">
      <button type="button" class="btn listBtn">목록</button>
      <button type="button" class="btn cancelBtn">취소</button>
      <button type="submit" class="btn modBtn">수정 저장</button>
     </div>
    </div>
   </div>
  </form>
 </div>
</div>
</body>
</html>