<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서검색</title>
<%@ include file = "../include/head.jsp" %>
<script>
var jsonObj = "";
var pageNum = 1;

function searchBook(paramPageNo) {
  pageNum += paramPageNo; 
  if(pageNum == 0 || paramPageNo == 0) pageNum = 1; 
  var title = $("#title").val();
  if(title == ""){
	  alert('도서명을 입력해주세요');
	  return;
  }
  var output = "";
   $.ajax({
	 type : "post",
	 url : "${path}/market/search?title=" + title + "&pageNum=" + pageNum,
	 success : function(jsonObj){
        output = "totalCount : " + jsonObj.total + " 중 " + pageNum + "페이지 <br />";
        for(var i = 0; i < jsonObj.display; i++){
            var tempUrl = jsonObj.items[i].image;
            if(tempUrl == "") tempUrl = "http://static.naver.net/book/image/noimg5.gif";
            output += "<img src='"+tempUrl+"' />";
            output += jsonObj.items[i].title; 
            output += "<button type = 'button' onclick = 'passBook(`" + jsonObj.items[i].isbn + "`);'>선택</button><br/>";
        }
        output = output.replaceAll("&gt;",">");
        output = output.replaceAll("&lt;","<");
        $("#resultDiv").html(output);
	 }
   })
}

function passBook(isbn){
	$.ajax({
		type : "post",
		url : "${path}/market/passForm?isbn=" + isbn,
		success : function(jsonObj){
			$(opener.document).find("#title").val(jsonObj.items[0].title);
			$(opener.document).find("#link").val(jsonObj.items[0].link);
			if(jsonObj.items[0].image != ""){
				$(opener.document).find("#image").val(jsonObj.items[0].image);
				$(opener.document).find("#img").html("<img src = '" + jsonObj.items[0].image + "'/>");
			}else{
				$(opener.document).find("#image").val("http://static.naver.net/book/image/noimg5.gif");
				$(opener.document).find("#img").html("<img src = 'http://static.naver.net/book/image/noimg5.gif'/>");
			}
			$(opener.document).find("#author").val(jsonObj.items[0].author);
			$(opener.document).find("#price").val(jsonObj.items[0].price);
			$(opener.document).find("#publisher").val(jsonObj.items[0].publisher);
			$(opener.document).find("#pubdate").val(jsonObj.items[0].pubdate);
			$(opener.document).find("#isbn").val(isbn);
			self.close();
		}
	})
}

String.prototype.trim = function() {
     return this.replace(/(^\s*)|(\s*$)/gi, "");
};

String.prototype.replaceAll = function( str1, str2 ) {
    var temp_str = this.trim();
    temp_str = temp_str.replace(eval("/" + str1 + "/gi"), str2);
    return temp_str;
};
</script>
</head>
<body>
 <div id = "searchDiv">
  <input type = "text" id = "title" name = "title"/>
  <button type = "button" id = "search" onclick = "searchBook(0);">도서검색</button>
 </div>
 <div id = "resultDiv">
 </div>
 <div id = "pageDiv">
  <a href = "#" onclick = "searchBook(-1);">이전</a>
  <a href = "#" onclick = "searchBook(1);">이후</a>
 </div>
</body>
</html>