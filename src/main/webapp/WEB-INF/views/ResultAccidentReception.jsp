<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.example.demo.model.Accident.Accident"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사고내용입력결과</title>
</head>
<body>
	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />
	<%Accident accident = (Accident)request.getAttribute("accident"); %>


	<section class="site-section bg-light" id="contact-section" style = "padding-top : 200px;">
		<c>
		<div class="container">
			<div class="row mb-5">
				<div class="col-12 text-center">
					<h2 class="text-black h1 site-section-heading">사고 내용 입력 결과</h2>
				</div>
			</div>




			<div class="p-5 bg-white" style="margin: auto; max-width: 700px;">


				<h2 class="h4 text-black mb-5">사고 내용 입력 결과</h2>

				<jsp:include page="/incl/showAccidentBasicInformation.jsp" />




				<div class="row form-group">
					<div class="col-md-12">
						<form action="main">
							<input type="submit" value="메인화면으로"
								class="btn btn-primary btn-md text-white" style="float: left;">
						</form>

						<form action=InsertCalculateAccidentFund method="post">
							<input type="hidden" name="accidentID" value= <%=accident.getAccidentID() %>>
							 <input type="submit" value="결정보험금산출하기" class="btn btn-primary btn-md text-white" style="float: right;">
						</form>
					</div>
				</div>
			</div>
		</div>



		</c>
	</section>

	<jsp:include page="/incl/Footer.jsp" />
	<jsp:include page="/incl/staticFooter.jsp" />
</body>
</html>