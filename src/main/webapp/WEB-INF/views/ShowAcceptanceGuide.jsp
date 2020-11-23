<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.demo.model.Acceptance.AcceptanceGuide"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 화재보험 설계 </title>
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/tabs.css" />
		<link rel="stylesheet" type="text/css" href="css/tabstyles.css" />
  		<script src="js/modernizr.custom.js"></script>
</head>
<body> 
<jsp:include page="/incl/staticHeader.jsp" />
<jsp:include page="/incl/Header.jsp" />

<%Vector<AcceptanceGuide> fireGuides, carGuides, actualCostGuides;
		fireGuides = (Vector<AcceptanceGuide>)request.getAttribute("fireGuide");
		carGuides = (Vector<AcceptanceGuide>)request.getAttribute("carGuide");
		actualCostGuides = (Vector<AcceptanceGuide>)request.getAttribute("actualCostGuide");
	%>

		<svg class="hidden">
			<defs>
				<path id="tabshape" d="M80,60C34,53.5,64.417,0,0,0v60H80z"/>
			</defs>
		</svg>
		<section class="site-section bg-light" id="contact-section">
		
			<div class="container">	
				<div class="row mb-5">
		          <div class="col-12 text-center">
		            <h2 class="text-black h1 site-section-heading">인수지침서 보기</h2>
		            <p class="lead">각 보험의 인수지침서를 확인할 수 있다.</p>
		          </div>
		        </div>
	        </div>
	        
				<div class="tabs tabs-style-shape">
					<nav>
						<ul>
							<li>
								<a href="#section-shape-1">
									<svg viewBox="0 0 80 60" preserveAspectRatio="none"><use xlink:href="#tabshape"></use></svg>
									<span>화재보험 인수지침서</span>
								</a>
							</li>
							<li>
								<a href="#section-shape-2">
									<svg viewBox="0 0 80 60" preserveAspectRatio="none"><use xlink:href="#tabshape"></use></svg>
									<svg viewBox="0 0 80 60" preserveAspectRatio="none"><use xlink:href="#tabshape"></use></svg>
									<span>자동차보험 인수지침서</span>
								</a>
							</li>
							<li>
								<a href="#section-shape-3">
									<svg viewBox="0 0 80 60" preserveAspectRatio="none"><use xlink:href="#tabshape"></use></svg>
									<svg viewBox="0 0 80 60" preserveAspectRatio="none"><use xlink:href="#tabshape"></use></svg>
									<span>실비보험 인수지침서</span>
								</a>
							</li>
						</ul>
					</nav>
					<div class="content-wrap">
						<section id="section-shape-1">
							<%	if(fireGuides != null){
								for(AcceptanceGuide fireGuide : fireGuides){ %>
							<div class="p-5 bg-white" style = "margin:auto; max-width: 800px;">
				              <div class="row form-group">
								<div class="col-md-4 mb-3 mb-md-0" >
				                  <label class="text-black" for="acceptanceGuideID">인수지침서 ID</label>
				                   <p class="text-primary"><%= fireGuide.getAcceptanceID() %><p>
				                </div>
				                <div class="col-md-4">
				                  <label class="text-black" for="insuranceID">보험 ID</label>
				                  <p class="text-primary"><%= fireGuide.getInsuranceID() %><p>
				                </div>
	         			      	<div class="col-md-4">
				                  <label class="text-black" for="riskEvaluation">위험 평가</label>
				                  <p class="text-primary"><%= fireGuide.getRiskEvaluation() %><p>
				                </div>
				                <div class="col-md-12">
				                  <label class="text-black" for="ScamCase"> 위험 사례 </label>
				                  <p class="text-primary"><%= fireGuide.getScamCase() %><p>
				                </div>
				              </div>
			              </div>
			              <% }};%>						
						</section>
						<section id="section-shape-2">
						<%	if(carGuides != null){
							for(AcceptanceGuide carGuide : carGuides){ %>
							<div class="p-5 bg-white" style = "margin:auto; max-width: 800px;">
				              <div class="row form-group">
								<div class="col-md-4 mb-3 mb-md-0" >
				                  <label class="text-black" for="acceptanceGuideID">인수지침서 ID</label>
				                  <p class="text-primary"><%= carGuide.getAcceptanceID() %><p>
				                </div>
				                <div class="col-md-4">
				                  <label class="text-black" for="insuranceID">보험 ID</label>
				                  <p class="text-primary"><%= carGuide.getInsuranceID() %><p>
				                </div>
	         			      	<div class="col-md-4">
				                  <label class="text-black" for="riskEvaluation">위험 평가</label>
				                  <p class="text-primary"><%= carGuide.getRiskEvaluation() %><p>
				                </div>
				                <div class="col-md-12">
				                  <label class="text-black" for="ScamCase"> 위험 사례 </label>
				                  <p class="text-primary"><%= carGuide.getScamCase() %><p>
				                </div>
				              </div>
			                </div>
			            <% }} %>
						</section>
						<section id="section-shape-3">
						<% if(actualCostGuides != null){
							for(AcceptanceGuide actualCostGuide : actualCostGuides){ %>
							<div class="p-5 bg-white" style = "margin:auto; max-width: 800px;">
				              <div class="row form-group">
								<div class="col-md-4 mb-3 mb-md-0" >
				                  <label class="text-black" for="acceptanceGuideID">인수지침서 ID</label>
				                   <p class="text-primary"><%= actualCostGuide.getAcceptanceID() %><p>
				                </div>
				                <div class="col-md-4">
				                  <label class="text-black" for="insuranceID">보험 ID</label>
				                  <p class="text-primary"><%= actualCostGuide.getInsuranceID() %><p>
				                </div>
	         			      	<div class="col-md-4">
				                  <label class="text-black" for="riskEvaluation">위험 평가</label>
				                  <p class="text-primary"><%= actualCostGuide.getRiskEvaluation() %><p>
				                </div>
				                <div class="col-md-12">
				                  <label class="text-black" for="ScamCase"> 위험 사례 </label>
				                  <p class="text-primary"><%= actualCostGuide.getScamCase() %><p>
				                </div>
				              </div>
			              </div>
			              <% }};%>						
						</section>
					</div>
				</div>
		</section>
		<script src="js/cbpFWTabs.js"></script>
		<script>
			(function() {

				[].slice.call( document.querySelectorAll( '.tabs' ) ).forEach( function( el ) {
					new CBPFWTabs( el );
				});

			})();
		</script>

    <a href="main.jsp" class="bg-primary py-5 d-block">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-md10">
          <h2 class="text-white">메인으로 돌아가기</h2>
          </div>
        </div>
      </div>  
    </a>
		<jsp:include page="/incl/Footer.jsp" />
	</body>
</html>