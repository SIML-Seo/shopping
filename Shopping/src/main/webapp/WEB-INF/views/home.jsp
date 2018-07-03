<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<c:set var = "path" value = "${pageContext.request.contextPath}"/>
<title>메인화면</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style>
body {
  padding-top: 64px;
}

@media (min-width: 992px) {
  body {
    padding-top: 66px;
  }
}
</style>
<script>
 var result = "${result}";
 if(result === "sell"){ 
	 alert("상품 판매를 완료하였습니다. 감사합니다.");
 };
</script>
<title>Insert title here</title>
</head>
<body>
<%@ include file = "include/menu.jsp" %>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-2">
			
           <br><br>
           <div class="list-group">
           	  <a href="#" class="list-group-item list-group-item-warning">책 목록</a>
              <a href="${path}/market/list/가" class="list-group-item">ㄱ-ㄹ</a>
              <a href="${path}/market/list/마" class="list-group-item">ㅁ~ㅇ</a>
              <a href="${path}/market/list/자" class="list-group-item">ㅈ~ㅎ</a>
              <a href="${path}/market/list/a" class="list-group-item">A~0</a>
           </div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-10">
		  <div class="jumbotron" align = "center">
		   <h1>중고서점에 오신걸 환영합니다</h1><br>
		   <p>최근 입고된 책은 다음과 같습니다</p>
		  </div>
          <!-- <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div> -->
          <div class="row">
			<c:forEach var = "book" items = "${list}">
	            <div class="col-lg-4 col-md-6 mb-4">
	              <div class="card h-100">
	                <a href="${path}/market/info/${book.seq}"><img class="card-img-top" src="${book.image}" style = "height: 300px; weight : 150px"></a>
	                <div class="card-body">
	                  <h5 class="card-title">
	                    <a href="${path}/market/info/${book.seq}">${book.title}</a>
	                  </h5>
	                  <%-- <h5>${secondPrice}</h5>
	                  <p class="card-text"></p> --%>
	                </div>
	                <!-- <div class="card-footer">
	                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
	                </div> -->
	              </div>
	            </div>
            </c:forEach>

            
          </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-3 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Siml BookShop 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>