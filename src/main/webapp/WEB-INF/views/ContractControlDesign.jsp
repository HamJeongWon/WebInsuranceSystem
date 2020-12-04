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
              <h2 class="text-primary">납부관리하기</h2>
              <p class="mb-4"></p>
              <p><a href="PaymentControll">납부관리하기</a></p>
            </div>
          </div>
          
           <div class="col-md-6 col-lg-4">
            <div class="p-3 box-with-humber">
              <div class="number-behind">02.</div>
              <h2 class="text-primary">만기계약관리하기</h2>
               <p class="mb-4"></p>
			  <p><a href="FullContractControll">만기계약관리하기</a></p>
            </div>
          </div>
          
             <div class="col-md-6 col-lg-4">
            <div class="p-3 box-with-humber">
              <div class="number-behind">03.</div>
              <h2 class="text-primary">계약서작성하기</h2>
               <p class="mb-4"></p>
			  <p><a href="MakeContractList">계약서작성하기</a></p>
            </div>
          </div>
        </div>
      </div>
    </section>
          
	<jsp:include page="/incl/Footer.jsp" />
	<jsp:include page="/incl/staticFooter.jsp" />
</body>
</html>