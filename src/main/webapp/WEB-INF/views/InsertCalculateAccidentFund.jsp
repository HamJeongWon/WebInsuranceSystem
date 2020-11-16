<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.example.demo.model.Accident.Accident"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>결정보험금 산출하기</title>
</head>
<body>
	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />
	<%
		Accident accident = (Accident) request.getAttribute("accident");
		Float maxInsurancePremium = (Float) request.getAttribute("maxInsurancePremium");
	%>


	<section class="site-section bg-light" id="contact-section" style = "padding-top : 200px;">
		<c>
		<div class="container">
			<div class="row mb-5">
				<div class="col-12 text-center">
					<h2 class="text-black h1 site-section-heading">결정 보험금 산출하기</h2>
				</div>
			</div>

	<form action=ResultCalculateAccidentFund
						 method="post" style = "margin:auto; max-width: 700px;">

			<div class="p-5 bg-white" style="margin: auto; max-width: 700px;">


				<h2 class="h4 text-black mb-5">기본 사고 내용</h2>
				<jsp:include page="/incl/showAccidentBasicInformation.jsp" />

				<br>
				<h2 class="h4 text-black mb-5">결정 보험금 산출하기</h2>
				<div class="row form-group">
					<div class="col-md-12">
						<label class="text-black" for="insurancePremium">최종 금액을 작성하여 주십시오.</label>
						<input type=number name="insurancePremium" id="insurancePremium" max=<%=maxInsurancePremium%> min=10000
						 class="form-control" placeholder="최대 보장액은 <%=maxInsurancePremium%>입니다.">
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-12">
						<label class="text-black" for="insurancePremiumCause">금액 결정 사유를 입력하여 주십시오</label>
						<textarea name="insurancePremiumCause" id="insurancePremiumCause" cols="30"
							rows="7" class="form-control" placeholder="금액 결정 사유를 작성하여 주십시오."></textarea>
					</div>
				</div>

			


				<div class="row form-group">
							<div class="col-md-12">
						
						<input type="hidden" name="accidentID" value= <%=accident.getAccidentID() %>>
						
								<input type="submit" value="등록하기"
									class="btn btn-primary btn-md text-white" style="float: left;">
							
									
									<input type="reset" value="다시쓰기"
									class="btn btn-primary btn-md text-white" style="float: right;">
							</div>
						</div>
			</div>
			</form>
		</div>



		</c>
	</section>

	


	<jsp:include page="/incl/Footer.jsp" />
	<jsp:include page="/incl/staticFooter.jsp" />
</body>
</html>