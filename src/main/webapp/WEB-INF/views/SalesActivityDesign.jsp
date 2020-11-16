<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
              <h2 class="text-primary">메뉴얼 확인</h2>
              <p class="mb-4"></p>
              <ul class="list-unstyled ul-check primary">
                <li>판매 메뉴얼 확인하기</li>
                <li>상품 메뉴얼 확인하기</li>
              </ul>
              <p><a href="Menual">메뉴얼 확인하기</a></p>
            </div>
          </div>
          
           <div class="col-md-6 col-lg-4">
            <div class="p-3 box-with-humber">
              <div class="number-behind">02.</div>
              <h2 class="text-primary">상품 가입 신청</h2>
               <p class="mb-4"></p>
              <ul class="list-unstyled ul-check primary">
                <li>기존 고객 상품 가입하기</li>
                <li>신규 고객 상품 가입하기</li>
              </ul>
			  <p><a href="ProductSubscription">상품 가입 신청하기</a></p>
            </div>
          </div>
        </div>
      </div>
    </section>
          
	<jsp:include page="/incl/Footer.jsp" />
	<jsp:include page="/incl/staticFooter.jsp" />
</body>
</html>