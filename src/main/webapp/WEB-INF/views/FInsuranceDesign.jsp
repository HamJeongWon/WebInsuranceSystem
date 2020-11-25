<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   String cp = request.getContextPath(); %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title> 화재보험 설계 </title>
			
			<jsp:include page="/incl/staticHeader.jsp" />

			<script type="text/javascript" src="<%=cp%>/js/jquery-3.3.1.min.js"></script>
			<script type="text/javascript" src="<%=cp%>/js/numberOnly.js"></script>
			<script type="text/javascript">
				function checkValue() {
				    if(!document.InsInfo.insuranceName.value){
				        alert("보험 이름을 입력하세요.");
				        return false;
				    }
				    if(!document.InsInfo.insuranceFee.value){
				        alert("보험료를 입력하세요.");
				        return false;
				    }
				    if(!document.InsInfo.insuranceManual.value){
				        alert("보험 설명서를 입력하세요.");
				        return false;
				    }
				    if(!document.InsInfo.insuranceSalesManual.value){
				        alert("판매메뉴얼을 입력하세요.");
				        return false;
				    }
				    
				    if(!document.InsInfo.directGuaranteedAmount.value){
				        alert("직접손해 보장액을 입력하세요.");
				        return false;
				    }
				    if(!document.InsInfo.directGuaranteedContent.value){
				        alert("직접손해 보장내용을 입력하세요.");
				        return false;
				    }
				    if(!document.InsInfo.fireGuaranteedAmount.value){
				        alert("소방손해 보장액을 입력하세요.");
				        return false;
				    }
				    if(!document.InsInfo.fireGuaranteedContent.value){
				        alert("소방손해 보장내용을 입력하세요.");
				        return false;
				    }
				    if(!document.InsInfo.refugeGuaranteedAmount.value){
				        alert("피난손해 보장액을 입력하세요.");
				        return false;
				    }
				    if(!document.InsInfo.refugeGuaranteedContent.value){
				        alert("피난손해 보장내용을 입력하세요.");
				        return false;
				    }
			    }
				
				$(document).ready(function(){
					$("input[id^='numberOnly']").on("focus", function() {
					    var x = $(this).val();
					    if(x && x.length > 0) {
					        if(!$.isNumeric(x)) {
					            x = x.replace(/[^0-9]/g,"");
					        }
					        x = addCommas(x);
					        $(this).val(x);
					    }
					}).on("focusout", function() {
					    var x = $(this).val();
					    x = removeCommas(x);
					    $(this).val(x);
					}).on("keyup", function() {
						$(this).val(addCommas($(this).val().replace(/[^0-9]/g,"")));
					});
				});
			</script>
		</head>

		<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
		
		  <div class="site-wrap">
		  
			<jsp:include page="/incl/Header.jsp" />

		<section class="site-section bg-light" id="contact-section"
			style="padding-top: 200px;">

			<div class="container">

				<div class="row mb-5">
					<div class="col-12 text-center">
						<h2 class="text-black h1 site-section-heading">화재보험 설계</h2>
						<p class="lead">화재 보험의 기본정보와 상세정보를 입력</p>
					</div>
				</div>

				<form action=./InsuranceDesgin?action=fire method="post"
					class="p-5 bg-white" name="InsInfo"
					style="margin: auto; max-width: 700px;"
					onsubmit="return checkValue()">

					<h2 class="h4 text-black mb-5" align="center">보험 기본 정보</h2>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black" for="insuranceName"> 보험 이름 </label> <input
								type="text" name="insuranceName" class="form-control">
						</div>
					</div>


					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black" for="insuranceFee">보험료</label> <input
								type="text" name="insuranceFee" class="form-control"
								id="numberOnly">
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black" for="insuranceManual">보험 설명서</label>
							<textarea name="insuranceManual" id="insuranceManual" cols="30"
								rows="7" class="form-control"
								placeholder="이 보험에 대한 설명을 작성하여 주십시오."></textarea>
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black" for="insuranceSalesManual">판매
								메뉴얼</label>
							<textarea name="insuranceSalesManual" id="insuranceSalesManual"
								cols="30" rows="7" class="form-control"
								placeholder="이 보험의 판매 tip을 작성하여 주십시오."></textarea>
						</div>
					</div>

					<br> <br>

					<h2 class="h4 text-black mb-5" align="center">보험 상세 정보</h2>

					<p class="lead" align="center">직접 손해</p>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black" for="directGuaranteedAmount">직접
								손해 보장액</label> <input type="text" name="directGuaranteedAmount"
								class="form-control" id="numberOnly">
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black" for="directGuaranteedContent">직접
								손해 보장 내용</label>
							<textarea name="directGuaranteedContent"
								id="directGuaranteedContent" cols="30" rows="7"
								class="form-control" placeholder="직접손해에 대한 보장 내용을 작성하여 주십시오."></textarea>
						</div>
					</div>

					<br>
					<p class="lead" align="center">소방 손해</p>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black" for="fireGuaranteedAmount"> 소방
								손해 보장액</label> <input type="text" name="fireGuaranteedAmount"
								class="form-control" id="numberOnly">
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black" for="fireGuaranteedContent"> 소방
								손해 보장 내용</label>
							<textarea name="fireGuaranteedContent" id="fireGuaranteedContent"
								cols="30" rows="7" class="form-control"
								placeholder="소방손해에 대한 보장 내용을 작성하여 주십시오."></textarea>
						</div>
					</div>

					<br>
					<p class="lead" align="center">피난 손해</p>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black" for="refugeGuaranteedAmount">피난
								손해 보장액</label> <input type="text" name="refugeGuaranteedAmount"
								class="form-control" id="numberOnly">
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black" for="refugeGuaranteedContent">피난
								손해 보장 내용</label>
							<textarea name="refugeGuaranteedContent"
								id="refugeGuaranteedContent" cols="30" rows="7"
								class="form-control" placeholder="피난손해에 대한 보장 내용을 작성하여 주십시오."></textarea>
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
				
			</div> <!-- .site-wrap -->
			
				<jsp:include page="/incl/staticFooter.jsp" />

		</body>
	</html>