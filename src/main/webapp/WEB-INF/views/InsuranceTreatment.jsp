<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>InsuranceSystem</title>
</head>
<body>
	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />

	<section class="site-section" id="work-section" style = "padding-top : 200px;">
		<div class="container">
			<div class="row mb-5 justify-content-center">
				<div class="col-md-8 text-center">
					<h2 class="text-black h1 site-section-heading text-center">보험처리하기</h2>
					<p class="lead">보험 처리는 사고내용작성하기, 결정보험금 산출하기, 결정보험금 지급하기가 존재</p>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6 col-lg-4">

					<a href="AccidentReception" class="media-1"> <img
						src="images/img_1.jpg" alt="Image" class="img-fluid">
						<div class="media-1-content">
							<h2>사고내용작성하기</h2>
							<span class="category">Web Application</span>
						</div>
					</a>
				</div>
				<div class="col-md-6 col-lg-4">
					<a href="CalculateAccidentFund" class="media-1"> <img
						src="images/img_2.jpg" alt="Image" class="img-fluid">
						<div class="media-1-content">
							<h2>결정보험금 산출하기</h2>
							<span class="category">Branding</span>
						</div>
					</a>
				</div>
				<div class="col-md-6 col-lg-4">
					<a href="PaymentAccidentFund" class="media-1"> <img
						src="images/img_3.jpg" alt="Image" class="img-fluid">
						<div class="media-1-content">
							<h2>결정보험금 지급하기</h2>
							<span class="category">Website</span>
						</div>
					</a>
				</div>

			</div>
		</div>
	</section>

	<jsp:include page="/incl/Footer.jsp" />
		<jsp:include page="/incl/staticFooter.jsp" />
</body>
</html>