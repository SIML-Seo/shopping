<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 탈퇴</title>
<%@ include file = "../include/head.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<script>
$(function(){
	$("#submit").click(function(){
		if(confirm("정말로 삭제하시겠습니까?")){
			del();
		}else{
			location.reload();
		}
	});
	
	$("#cancle").click(function(){
		location.href = "${path}";
	});
});

function del(){
	var passwd = $("#passwd").val();
	$.ajax({
		type: "post",
		url: "${path}/member/delete/${user}?passwd=" + passwd,
		success: function(result){
			if(result === "true"){
				alert("회원탈퇴에 성공했습니다. 감사합니다.");
				location.href = "${path}";
			}else{
				alert("비밀번호가 일치하지 않습니다. 확인해주세요.");
				$("#passwd").focus();
			}
		}
	});
}
</script>
<div class = "container">
 <div class = "row text-center">
  <div class = "col-lg-5 offset-lg-3"><br><br><br>
   ${user}님 정말로 회원 정보를 삭제하시겠습니까?
   <form>
    <div class = "form-group"><br>
     <label class = "col-form-label" for = "passwd">비밀번호 </label>
     <input type = "password" id = "passwd">
    </div>
 <button type = "button" id = "submit" class = "btn">확인</button>
 <button type = "button" id = "cancle" class = "btn">취소</button>
</form>
  
  </div>
 </div>
</div>
</body>
</html>