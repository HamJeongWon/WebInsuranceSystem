<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="com.example.demo.model.Accident.Accident"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>결정보험금 지급완료</title>
</head>
<body>

	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />
	<section class="site-section bg-light" id="contact-section">

		<div class="container">
			<div class="row mb-5">
				<div class="col-12 text-center">
					<h2 class="text-black h1 site-section-heading">결정보험금 지급이 완료
						되었습니다.</h2>
					<br>
					<div class="row form-group">
						<div class="col-md-12">
							<form action="main" style="margin: auto; max-width: 700px;">
								<input type="submit" value="메인으로"
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