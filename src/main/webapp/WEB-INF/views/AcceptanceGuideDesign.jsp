<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인수지침서 설계</title>

<jsp:include page="/incl/staticHeader.jsp" />
<script type="text/javascript">
				function checkValue() {
				    if(!document.AcepInfo.ScamCase.value){
				        alert("위험사례를 입력하세요.");
				        return false;
				    }
			    }
			</script>
</head>
<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">

	<div class="site-wrap">

		<jsp:include page="/incl/Header.jsp" />

		<section class="site-section bg-light" id="contact-section"
			style="padding-top: 200px;">

			<div class="container">

				<div class="row mb-5">
					<div class="col-12 text-center">
						<h2 class="text-black h1 site-section-heading">인수지침서 설계</h2>
						<p class="lead">해당 보험의 위험평가와 사기사례를 입력하여 인수지침서를 설계할 수 있다.</p>
					</div>
				</div>

				<div>
					<form action=./AcceptanceGuideDesign?InsuranceID=<%= request.getParameter("action") %> method="post"
						class="p-5 bg-white" style="margin: auto; max-width: 700px;"
						name="AcepInfo" onsubmit="return checkValue()">

						<h2 class="h4 text-black mb-5" align="center">인수지침서 정보</h2>

						<div class="row form-group">
							<div class="col-md-12">
								<label class="text-black" for="RiskEvaluation">위험
									평가&nbsp; &nbsp; </label> <label> <input type="radio"
									class="option-input radio" value="Low" name="RiskEvaluation"
									checked /> 낮음&nbsp;
								</label> <label> <input type="radio" class="option-input radio"
									value="Middle" name="RiskEvaluation" /> 중간&nbsp;
								</label> <label> <input type="radio" class="option-input radio"
									value="High" name="RiskEvaluation" /> 높음&nbsp;
								</label>
							</div>
						</div>

						<div class="row form-group">
							<div class="col-md-12">
								<label class="text-black" for="ScamCase">위험 사례</label>
								<textarea name="ScamCase" id="ScamCase" cols="30" rows="7"
									class="form-control" placeholder="해당 보험의 위험사례를 입력하여 주십시오."></textarea>
							</div>
						</div>

						<br> <br>

						<div class="row form-group">
							<div class="col-md-12">
								<input type="submit" value="설계 완료"
									class="btn btn-primary btn-md text-white" style="float: right;">
								<input type="reset" value="다시 작성"
									class="btn btn-primary btn-md text-white">
							</div>
						</div>

					</form>
				</div>
			</div>
		</section>

		<a href="main" class="bg-primary py-5 d-block">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md10">
						<h2 class="text-white">메인으로 돌아가기</h2>
					</div>
				</div>
			</div>
		</a>

		<jsp:include page="/incl/Footer.jsp" />

	</div>
	<!-- .site-wrap -->

	<jsp:include page="/incl/staticFooter.jsp" />

</body>
</html>