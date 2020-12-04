<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 가입 신청하기</title>
</head>
<body>
	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />

	<section class="site-section" style = "padding-top : 200px;">
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-lg-4">
            <div class="p-3 box-with-humber">
              <div class="number-behind">01.</div>
              <h2 class="text-primary">기존 고객 정보 입력</h2>
              <p class="mb-4">회사 보험 상품 중 이미 하나라도 가입한 고객들은 여기서 상품 가입을 진행한다</p>
              <p><a href="InsertExistingCus">기존 고객 리스트 확인과 정보 입력하기</a></p>
            </div>
          </div>
          
           <div class="col-md-6 col-lg-4">
            <div class="p-3 box-with-humber">
              <div class="number-behind">02.</div>
              <h2 class="text-primary">새로운 고객 정보 입력</h2>
               <p class="mb-4">회사 보험 상품 신규 가입자는 여기서 가입을 진행한다</p>
			  <p><a href="InsertNewCus">신규 가입자 정보 입력하기</a></p>
            </div>
          </div>
        </div>
      </div>
    </section>
          
	<jsp:include page="/incl/Footer.jsp" />
	<jsp:include page="/incl/staticFooter.jsp" />
</body>
</html>