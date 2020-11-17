<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.model.Subscription.Subscription"%>
<%@ page import="com.example.demo.model.Insurance.Insurance"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기존 고객 가입 </title>
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/tabs.css" />
		<link rel="stylesheet" type="text/css" href="css/tabstyles.css" />
		<link rel="stylesheet" type="text/css" href="css/table.css" />
  		<script src="js/modernizr.custom.js"></script>
</head>
<body>
	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />
	
	<%
	Vector<Subscription> VecSubscription = (Vector<Subscription>)request.getAttribute("VecSubscription");
	Vector<Insurance> VecInsurance = (Vector<Insurance>)request.getAttribute("VecInsurance");
	%>
	
		<svg class="hidden">
			<defs>
				<path id="tabshape" d="M80,60C34,53.5,64.417,0,0,0v60H80z"/>
			</defs>
		</svg>
		<section class="site-section bg-light" id="contact-section" style = "padding-top : 200px;">
		
			<div class="container">	
				<div class="row mb-5">
		          <div class="col-12 text-center">
		            <h2 class="text-black h1 site-section-heading">상품 가입자</h2>
		            <p class="lead">보험사의 상품에 가입한 고객 리스트 출력.</p>
		          </div>
		        </div>
	        </div>
	        
				<div class="tabs tabs-style-shape">
					<nav>
						<ul>
							<li>
								<a href="#section-shape-1">
									<svg viewBox="0 0 80 60" preserveAspectRatio="none"><use xlink:href="#tabshape"></use></svg>
									<span>화재보험 리스트</span>
								</a>
							</li>
							<li>
								<a href="#section-shape-2">
									<svg viewBox="0 0 80 60" preserveAspectRatio="none"><use xlink:href="#tabshape"></use></svg>
									<svg viewBox="0 0 80 60" preserveAspectRatio="none"><use xlink:href="#tabshape"></use></svg>
									<span>자동차보험 리스트</span>
								</a>
							</li>
							<li>
								<a href="#section-shape-3">
									<svg viewBox="0 0 80 60" preserveAspectRatio="none"><use xlink:href="#tabshape"></use></svg>
									<svg viewBox="0 0 80 60" preserveAspectRatio="none"><use xlink:href="#tabshape"></use></svg>
									<span>실비보험 리스트</span>
								</a>
							</li>
						</ul>
					</nav>
					<div class="content-wrap">
						<section id="section-shape-1">	
						<div class="container">
							  <ul class="responsive-table">
							    <li class="table-header">
							      <div class="col col-1">고객 ID</div>
							      <div class="col col-2">보험 ID</div>
							      <div class="col col-3">보험 이름</div>
							      <div class="col col-4">다른 보험 가입버튼</div>
							    </li>
				    	<%			    	
				    	for(Integer i = 0; i<VecInsurance.size(); i++){
				    		if(VecInsurance.get(i).getInsuranceType() == Insurance.InsuranceType.Fire){
				    			if(VecSubscription.get(i).getInsuranceID() == VecInsurance.get(i).getInsuranceID()){%>
							     <li class="table-row">
							      <div class="col col-1" style="margin-top:9px;">
						      		<%= VecSubscription.get(i).getCustomerID() %>					       
							      </div>
							        <div class="col col-2" style="margin-top:9px;">
							      	<%=  VecInsurance.get(i).getInsuranceID() %>
							      </div>
							      <div class="col col-3" style="margin-top:9px;">
							      	<%=  VecInsurance.get(i).getInsuranceName() %>
							      </div>
							      <div class="col col-4" >
							      	<form action= ./ExistingCus>
							      		<input type= hidden name = CustomerID value = <%= VecSubscription.get(i).getCustomerID()%>>
							      		<input type="submit" value="가입하기" class="btn btn-primary btn-md text-white">
							      	</form>
							      </div>
							    </li>
							<%}
							}
				    		}%>
							  </ul>
							</div>	
						</section>
						
						<section id="section-shape-2">	
						<div class="container">
							  <ul class="responsive-table">
							    <li class="table-header">
							      <div class="col col-1">고객 ID</div>
							      <div class="col col-2">보험 ID</div>
							      <div class="col col-3">보험 이름</div>
							      <div class="col col-4">다른 보험 가입버튼</div>
							    </li>
				    	<%			    	
				    	for(Integer i = 0; i<VecInsurance.size(); i++){
				    		if(VecInsurance.get(i).getInsuranceType() == Insurance.InsuranceType.Car){
				    			if(VecSubscription.get(i).getInsuranceID() == VecInsurance.get(i).getInsuranceID()){%>
							     <li class="table-row">
							      <div class="col col-1" style="margin-top:9px;">
						      		<%= VecSubscription.get(i).getCustomerID() %>					       
							      </div>
							        <div class="col col-2" style="margin-top:9px;">
							      	<%=  VecInsurance.get(i).getInsuranceID() %>
							      </div>
							      <div class="col col-3" style="margin-top:9px;">
							      	<%=  VecInsurance.get(i).getInsuranceName() %>
							      </div>
							      <div class="col col-4" > 
							      	<form action= ./ExistingCus>
							      		<input type= hidden name = CustomerID value = <%= VecSubscription.get(i).getCustomerID()%>>
							      		<input type="submit" value="가입하기" class="btn btn-primary btn-md text-white">
							      	</form>
							      </div>
							    </li>
							<%}
							}
				    		}%>
							  </ul>
							</div>	
						</section>
						
						<section id="section-shape-3">	
						<div class="container">
							  <ul class="responsive-table">
							    <li class="table-header">
							      <div class="col col-1">고객 ID</div>
							      <div class="col col-2">보험 ID</div>
							      <div class="col col-3">보험 이름</div>
							      <div class="col col-4">다른 보험 가입버튼</div>
							    </li>
				    	<%			    	
				    	for(Integer i = 0; i<VecInsurance.size(); i++){
				    		if(VecInsurance.get(i).getInsuranceType() == Insurance.InsuranceType.ActualCost){
				    			if(VecSubscription.get(i).getInsuranceID() == VecInsurance.get(i).getInsuranceID()){%>
							     <li class="table-row">
							      <div class="col col-1" style="margin-top:9px;">
						      		<%= VecSubscription.get(i).getCustomerID() %>					       
							      </div>
							        <div class="col col-2" style="margin-top:9px;">
							      	<%=  VecInsurance.get(i).getInsuranceID() %>
							      </div>
							      <div class="col col-3" style="margin-top:9px;">
							      	<%=  VecInsurance.get(i).getInsuranceName() %>
							      </div>
							      <div class="col col-4" >
							      	<form action= ./ExistingCus>
							      		<input type= hidden name = CustomerID value = <%= VecSubscription.get(i).getCustomerID()%>>
							      		<input type="submit" value="가입하기" class="btn btn-primary btn-md text-white">
							      	</form>
							      </div>
							    </li>
							<%}
							}
				    		}%>
							  </ul>
							</div>	
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
	
	
	
	
	
	<jsp:include page="/incl/Footer.jsp" />
		<jsp:include page="/incl/staticFooter.jsp" />
</body>
</html>