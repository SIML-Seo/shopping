<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 내용</title>
<%@ include file = "../include/head.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<script>
$(function () {                  
    listReply2();

    $("#replyBtn").click(function(){
        var replyContent = $("#replyContent").val();
        var boardSeq = "${article.seq}"
        var param="replyContent=" + replyContent + "&boardSeq="+boardSeq;
        $.ajax({                
            type: "post",
            url: "${path}/reply/insert",
            data: param,
            success: function(){
                alert("댓글이 등록되었습니다.");
                $("#replyContent").val("");
                listReply2();
            }
        });
    });
	
    var formObj = $("form[role='form']");                      
    
    $(".modBtn").click(function(){
        formObj.attr("action", "${path}/board/modify");             
        formObj.submit();
    });

    $(".delBtn").click(function(){
    	if(confirm("정말로 삭제하시겠습니까?")){
       formObj.attr("action", "${path}/board/delete");
       formObj.submit();
    	}
    });

    $(".listBtn").click(function(){
       location.href = "${path}/board/list"
    });
});

$(document).on("click", ".replyDelBtn", function(){
   	var $this = $(this);
   	console.log($this);
   	var seq = $this.prev().val();
   	console.log(seq);
   	var param = "seq=" + seq;
   	console.log(param);
    $.ajax({                
		type: "post",
		url: "${path}/reply/delete",
		data: param,
		success: function(){
		    listReply2();
		}
	}); 
})


function listReply2(){
	var output = "";
    $.ajax({
        type: "get",
        url: "${path}/reply/list?boardSeq=${article.seq}",
        success: function(result){
            output = "<table>";
            for(var i in result){
                output += "<tr>";
                output += "<td>" + result[i].replyWriter + "<br>";
                output += result[i].replyContent + "</td>";
                output += "</tr>";
                output += "<tr><td>";
                output += "<input type = 'hidden' name = 'seq' value = '" + result[i].seq + "'>";
                output += "<c:if test = '${sessionScope.master != null}'>";
                output += "<button type = 'button' class = 'replyDelBtn'>X</button>";
                output += "</c:if>";
                output += "</td></tr>";
            }
            output += "</table>";
            $("#replyView").html(output);
        }
    });
}

</script>
<h3 class="box-title">글제목 : ${article.title}</h3>
<div class="box-body" style="height: 700px">
${article.content}
</div>
유저명 : ${article.writer}
<span class="description"><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${article.regDate}"/></span>
<form role="form">
    <input type = "hidden" name="seq" value="${article.seq}">
</form>
<button type="submit" class="listBtn">목록</button>
<c:if test = "${sessionScope.loginUser == article.writer}">
 <button type="submit" class="modBtn">수정</button>
 <button type="submit" class="delBtn">삭제</button>
</c:if>
<c:if test = "${sessionScope.master != null}">
 <textarea rows = "5" cols = "80" id = "replyContent" placeholder = "답변하기"></textarea>
 <br>
 <button type = "button" id = "replyBtn">답변하기</button>
</c:if>
<div id = "replyView"></div>
</body>
</html>