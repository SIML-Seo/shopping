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
            output = "";
            for(var i in result){
                output += "<h5 class ='mt-0'>" + result[i].replyWriter;
                output += "<input type = 'hidden' name = 'seq' value = '" + result[i].seq + "'>";
                output += "<c:if test = '${sessionScope.master != null}'>";
                output += "<button type = 'button' class = 'replyDelBtn close' aria-label = 'close'>";
                output += "<span aria-hidden='true'>&times;</span></button>";
                output += "</c:if>";
                output += "</h5>";
                output += result[i].replyContent;
            }
            $("#replyView").html(output);
        }
    });
}

</script>
<div class = "container">
 <div class = "row">
  <div class = "col-lg-12">
   <h3 class="mt-4">${article.title}</h3>
   <p class = "lead">&nbsp;&nbsp; by ${article.writer} | <fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${article.regDate}"/></p>
   <hr>
   ${article.content}
   <hr>
   <form role="form">
    <input type = "hidden" name="seq" value="${article.seq}">
   </form>
   <div class = "row">
    <div class = "offset-lg-10">
     <c:if test = "${sessionScope.loginUser == article.writer or sessionScope.loginUser == 'master'}">
      <button type="submit" class="btn modBtn">수정</button>
      <button type="submit" class="btn delBtn">삭제</button>
     </c:if>
     <button type="submit" class="btn listBtn">목록</button>
    </div>
   </div>
   <c:if test = "${sessionScope.master != null}">
    <div class = "text-center col-lg-6 offset-lg-3">
     <div class = "card my-4">
      <h5 class = "card-header">운영자 답변</h5>
      <div class =  "card-body">
       <div class = "form-group">
        <textarea rows = "3" class = "form-control" id = "replyContent" placeholder = "답변하기"></textarea>
       </div>
       <button type = "button" class = "btn btn-primary" id = "replyBtn">답변하기</button>
      </div>
     </div>
    </div>
   </c:if>
   <div class = "media mb-4">
    <div class = "media-body" id = "replyView"></div>
   </div>
  </div>
 </div>
</div>

</body>
</html>