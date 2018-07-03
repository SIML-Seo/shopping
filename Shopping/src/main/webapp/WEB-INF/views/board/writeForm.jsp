<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<%@ include file = "../include/head.jsp" %>
<script>
 $(function(){
	$(".listBtn").click(function(){
		location.href = "${path}/board/list";
	});
 });
</script>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<div class = "container">
 <div class = "col-lg-10 offset-lg-1">
  <form method = "post">
   <div>
    <div>
     <h3>게시글 작성</h3><hr>
    </div>
    <div style = "padding-left : 10px;">
     <div class = "form-group">
      <label for =  "title">제목</label>
      <input type = "text" class = "form-control" name = "title" id = "title" placeholder = "제목 입력"><br>
     </div>
     <div class = "form-group">
      <label for =  "content">내용</label>
      <textarea rows="15" class = "form-control" name = "content" id = "content" placeholder = "내용 입력" style = "resize : none;"></textarea><br>
     </div>
     <div class = "form-group">
      <label>작성자</label>
      <input type = "text" class = "form-control" name = "writer" id = "writer" value = "${userId}" readonly><br>
     </div>
     <div class = "offset-lg-9">
      <button type="button" class="btn listBtn">목록</button>
      <button type="submit" class="btn insertBtn">저장</button>
      <button type="reset" class="btn resetBtn">초기화</button>
     </div>
    </div> 
   </div>
  </form>
  </div>
</div>
</body>
</html>