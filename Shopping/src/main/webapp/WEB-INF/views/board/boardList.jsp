<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의게시판</title>
<%@ include file = "../include/head.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<script>
$(function(){
	$("#searchBtn").click(function(){
		location.href = "${path}/board/list?searchOption=" + $("select option:selected").val()
				+ "&searchValue=" + encodeURIComponent($("#searchValue").val());
	})
	$("#writeBtn").click(function(){
		location.href = "${path}/board/write";
	})
});

var result = "${result}";                                        
if (result == "write") {                                 
    alert("게시글 등록이 완료되었습니다.");
} else if (result == "modify") {
    alert("게시글 수정이 완료되었습니다.");
} else if (result == "delete") {
    alert("게시글 삭제가 완료되었습니다.");
}
</script>
<div class = "container">
	<table class="table table-bordered table-hover table-striped">
	 <thead>
	  <tr>
	   <td width = "10%">#</td>
	   <td width = "60%">제목</td>
	   <td width = "15%">작성자</td>
	   <td width = "15%">작성시간</td>
	  </tr>
	 </thead>
	 <tbody>
	  <c:forEach var="article" items="${boardList}">
	   <tr>
	    <td>${article.seq}</td>
	    <td><a href="${path}/board/read${paging.searchQuery(paging.pagingDto.page)}&seq=${article.seq}">${article.title}</a></td>
	    <td>${article.writer}</td>
	    <td><fmt:formatDate value="${article.regDate}" pattern="yyyy-MM-dd hh:mm"/></td>
	   </tr>
	  </c:forEach>
	 </tbody>
	</table>
	<div class = "col-md-6" style = "margin: 0 auto;">
	 <ul class="pagination">
      <c:if test="${paging.prev}">
	      <li class = "page-item"><a href="${path}/board/list?page=${paging.startPage - 1}" class = "page-link">이전</a></li>
	  </c:if>
	  <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="page">
	      <li class = "page-item <c:out value="${paging.pagingDto.page == page ? 'active' : ''}"/> ">
	          <a href="${path}/board/list?page=${page}" class = "page-link">${page}</a>
	      </li>
	  </c:forEach>
 	  <c:if test="${paging.next && paging.endPage > 0}">
 	      <li class = "page-item"><a href="${path}/board/list?page=${paging.endPage + 1}" class = "page-link">다음</a></li> 
      </c:if>
	 </ul>
	</div>
	
	<div class = "row">
	 <div class = "col-lg-4"></div>
	 <div class = "col-lg-2">
	  <select class = "form-control" name = "searchOption" id = "searchOption">
	   <option value = "no" <c:out value = "${paging.pagingDto.searchOption == null or 'no' ? 'selected' : ''}"/>>검색조건</option>
	   <option value = "title" <c:out value = "${paging.pagingDto.searchOption == 'title' ? 'selected' : ''}"/>>제목</option>
	   <option value = "writer" <c:out value = "${paging.pagingDto.searchOption == 'writer' ? 'selected' : ''}"/>>작성자</option>
	  </select>
	 </div>
	 <div class = "col-lg-4">
	  <input type = "text" class = "form-control" name = "searchValue" id = "searchValue" value = "${paging.pagingDto.searchValue}" placeholder = "검색어"/>
	 </div>
	 <div class = "col-lg-2">
	 <button type = "button" class = "btn btn-default" id = "searchBtn">검색</button>&nbsp;&nbsp;
	 <c:if test = "${sessionScope.loginUser != null}">
	  <button type="button" class = "btn btn-default" id="writeBtn">글쓰기</button>
	 </c:if>
	 </div>
	</div>
</div>
</body>
</html>