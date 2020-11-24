<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>인수승인</title>
</head>
<body>
<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />
	<section class="site-section bg-light" id="contact-section" style = "padding-top : 200px;">
	<form action=DeclineDoneInsuranceSubscription method="post" style = "margin:auto; max-width: 700px;">
		<div class="container">
			<div class="row mb-5">
				<div class="col-12 text-center">
					<h2 class="text-black h1 site-section-heading">인수 승인 거부</h2>
				
					
					<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="declineCause">인수 승인 거부 이유를 작성하시오.</label>
					<textarea name="declineCause" id="declineCause" cols="30"
						rows="7" class="form-control" placeholder="인수 승인 거부 이유를 작성해주세요."></textarea>
				</div>
			</div>
			<br>
		<div class="row form-group">
					<div class="col-md-12">
						
							<input type="submit" value="제출하기"
								class="btn btn-primary btn-md text-white" style="display: inline-block;">
						
						</div>
						</div>
							</div>
			</div>
			</div>
			</form>
			</section>
			
			
<jsp:include page="/incl/Footer.jsp" />
<jsp:include page="/incl/staticFooter.jsp" />
</body>
</html>