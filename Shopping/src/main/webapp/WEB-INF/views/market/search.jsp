<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>책 검색</title>
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
		output = "<div class = 'clearfix'><div class = 'float-right'>";
        output += "총 " + jsonObj.total + " 페이지 중 " + pageNum + "페이지 </div></div><br/>";
        output += "<table class = 'table'><tbody>"
        for(var i = 0; i < jsonObj.display; i++){
            var tempUrl = jsonObj.items[i].image;
            if(tempUrl == "") tempUrl = "http://static.naver.net/book/image/noimg5.gif";
            output += "<tr><td><img src='"+tempUrl+"' /></td>";
            output += "<td>" + jsonObj.items[i].title + "</td>"; 
            output += "<td><button type = 'button' onclick = 'passBook(`" + jsonObj.items[i].isbn + "`);'>√</button></td></tr>";
        }
        output += "</tbody></table>";
        output = output.replaceAll("&gt;",">");
        output = output.replaceAll("&lt;","<");
        $("#resultDiv").html(output);
        $("#pageDiv").html("<a href = '#' class = 'btn btn-outline-dark' onclick = 'searchBook(-1);'>이전</a>&nbsp;<a href = '#' class = 'btn btn-outline-dark' onclick = 'searchBook(1);'>이후</a>")
	 }
   })
}

function passBook(isbn){
	$.ajax({
		type : "post",
		url : "${path}/market/passForm?isbn=" + isbn,
		success : function(jsonObj){
			$(opener.document).find("#title").val(jsonObj.items[0].title);
			$(opener.document).find("#title_p").html(jsonObj.items[0].title);
			$(opener.document).find("#link").val(jsonObj.items[0].link);
			if(jsonObj.items[0].image != ""){
				$(opener.document).find("#image").val(jsonObj.items[0].image);
				$(opener.document).find("#img").html("<img src = '" + jsonObj.items[0].image + "' class='rounded mx-auto d-block' style = 'width: 80%; height: 80%;''/>");
			}else{
				$(opener.document).find("#image").val("http://static.naver.net/book/image/noimg5.gif");
				$(opener.document).find("#img").html("<img src = 'http://static.naver.net/book/image/noimg5.gif'/>");
			}
			$(opener.document).find("#author").val(jsonObj.items[0].author);
			$(opener.document).find("#author_p").html(jsonObj.items[0].author);
			$(opener.document).find("#price").val(jsonObj.items[0].price);
			$(opener.document).find("#price_p").html(jsonObj.items[0].price);
			$(opener.document).find("#publisher").val(jsonObj.items[0].publisher);
			$(opener.document).find("#publisher_p").html(jsonObj.items[0].publisher);
			$(opener.document).find("#pubdate").val(jsonObj.items[0].pubdate);
			$(opener.document).find("#pubdate_p").html(jsonObj.items[0].pubdate);
			$(opener.document).find("#isbn").val(isbn);
			$(opener.document).find("#isbn_p").html(isbn);
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
<link href="${path}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class ="form-inline" id = "searchDiv">
   <input type = "text" class = "form-control" id = "title" name = "title"/>
   <button type = "button" id = "search" class="btn btn-outline-secondary" onclick = "searchBook(0);">도서검색</button>
  </div> 
  <div id = "resultDiv">
  </div>
  <br>
  <div id = "pageDiv" class= "text-center">

  </div>
</body>
</html>