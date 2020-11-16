<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="com.example.demo.model.Accident.Accident"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사고내용입력완료</title>
</head>
<body>

	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />
	<%
		Accident accident = (Accident) request.getAttribute("accident");
	%>
	<section class="site-section bg-light" id="contact-section">

		<div class="container">
			<div class="row mb-5">
				<div class="col-12 text-center">
					<h2 class="text-black h1 site-section-heading">사고내용 입력이
						완료되었습니다.</h2>
					<br>
					<div class="row form-group">
						<div class="col-md-12">
							<form action="main" style="margin: auto; max-width: 700px;">
								<input type="submit" value="메인으로"
									class="btn btn-primary btn-md text-white"
									style="display: inline-block;">
							</form>
							<br>
							<form action="ResultAccidentReception" method="post"
								style="margin: auto; max-width: 700px;">
								<input type="hidden" name="accidentID"
									value=<%=accident.getAccidentID()%>> <input
									type="submit" value="결과보기"
									class="btn btn-primary btn-md text-white"
									style="display: inline-block;">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<jsp:include page="/incl/Footer.jsp" />
</body>
</html>