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
	window.open("${path}/market/searchForm", "검색", "width=400px, height=500px, resizable=no");
}
</script>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<c:set var = "id" value = "${sessionScope.loginUser}"/>
 <button type = "button" onclick = "searchOpen();">상품검색</button>
 <form id = "formofsell" action = "${path}/market/sellRegist">
  <table style = "border:1px solid black;">
   <tr>
    <td rowspan = "6">
     <div id = "img">
     </div>
    </td>
    <td>
     <input type = "text" name = "title" id = "title" placeholder = "제목" readonly/>
    </td>
   </tr>
   <tr>
    <td>
     <input type = "text" name = "author" id = "author" placeholder = "저자" readonly/>
    </td>
   </tr>
   <tr>
    <td>
     <input type = "text" name = "publisher" id = "publisher" placeholder = "출판사" readonly/>
    </td>
   </tr>
   <tr>
    <td>
     <input type = "text" name = "price" id = "price" placeholder = "가격" readonly/>
    </td>
   </tr>
   <tr>
    <td>
     <input type = "text" name = "pubdate" id = "pubdate" placeholder = "출판일" readonly/>
    </td>
   </tr>
   <tr>
    <td>
     <input type = "text" name = "isbn" id = "isbn" placeholder = "isbn" readonly/>
    </td>
   </tr>
  </table>
  <input type = "hidden" name = "link" id = "link"/>
  <input type = "hidden" name = "image" id = "image"/>
  <input type = "hidden" name = "id" id = "id" value = "${id}"/>
  <input type = "submit" id = "submit" value = "판매"/>
 </form>	
</body>
</html>