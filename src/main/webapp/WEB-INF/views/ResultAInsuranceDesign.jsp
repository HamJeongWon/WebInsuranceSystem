<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.model.Insurance.ActualCostInsurance"%>
<% request.setCharacterEncoding("UTF-8");
   String cp = request.getContextPath(); %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title> 실비보험 설계결과 </title>
			
			<jsp:include page="/incl/staticHeader.jsp" />
			
		</head>
		
		<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
		
		  <div class="site-wrap">
		  
			<jsp:include page="/incl/Header.jsp" />
			<%ActualCostInsurance insurance = (ActualCostInsurance)request.getAttribute("AInsurance"); %>

			<section class="site-section bg-light" id="contact-section" style = "padding-top : 200px;">
			
			      <div class="container">
			      
			        <div class="row mb-5">
			          <div class="col-12 text-center">
			            <h2 class="text-black h1 site-section-heading"><%= insurance.getInsuranceName() %>의 상세 정보</h2>
			            <p class="lead">해당 보험의 상세 정보입니다.</p>
			          </div>
			        </div>
			
			            <div class="p-5 bg-white" style = "margin:auto; max-width: 700px;">
			              
			              <h2 class="h4 text-black mb-5" align = "center"> 보험 기본 정보 </h2> 
			              
			              <div class="row form-group">
			                <div class="col-md-12">
			                  <label class="text-black" for="insuranceID"> 보험 ID </label>
			                  <p class="text-primary"><%= insurance.getInsuranceID() %><p>
			                </div>
			              </div>
			
			              <div class="row form-group">
			                <div class="col-md-12">
			                  <label class="text-black" for="insuranceName"> 보험 이름 </label> 
			                   <p class="text-primary"><%= insurance.getInsuranceName() %><p>
			                </div>
			              </div>
			
			              <div class="row form-group">          
			                <div class="col-md-12">
			                  <label class="text-black" for="insuranceFee">보험료</label> 
			                   <p class="text-primary"><%= insurance.getInsuranceFee() %><p>
			                </div>
			              </div>
			              
			              <div class="row form-group">
			                <div class="col-md-12">
			                  <label class="text-black" for="insuranceManual">보험 설명서</label> 
			                  <p class="text-primary"><%= insurance.getInsuranceManual() %><p>
			                </div>
			              </div>
			
			              <div class="row form-group">
			                <div class="col-md-12">
			                  <label class="text-black" for="insuranceSalesManual">판매 메뉴얼</label> 
			                  <p class="text-primary"><%= insurance.getInsuranceSalesManual() %><p>
			                </div>
			              </div>
			
			              <br>
			              <br>
			              
			              <h2 class="h4 text-black mb-5" align = "center"> 보험 상세 정보 </h2> 
			              
			              <p class="lead" align = "center" >상해 입원</p>            
			
			              <div class="row form-group">
			                <div class="col-md-12">
			                  <label class="text-black" for="hospitalizationFee"> 상해 입원 지급 금액 </label> 
			                  <p class="text-primary"><%= insurance.getInjuryHospitalization().getProvisionFee() %><p>
			                </div>
			              </div>
			              
			              <div class="row form-group">
			                <div class="col-md-12">
			                  <label class="text-black" for="hospitalizationReason"> 상해 입원 지급 사유 </label> 
			                   <p class="text-primary"><%= insurance.getInjuryHospitalization().getProvisionReason() %><p>                
			                </div>
			              </div>
			              
			              <br>
			              <p class="lead" align = "center" >상해 통원</p>            
			
			              <div class="row form-group">
			                <div class="col-md-12">
			                  <label class="text-black" for="outpatientFee"> 상해 통원 지급 금액 </label> 
			                  <p class="text-primary"><%= insurance.getInjuryOutpatient().getProvisionFee() %><p>
			                </div>
			              </div>
			              
			              <div class="row form-group">
			                <div class="col-md-12">
			                  <label class="text-black" for="outpatientReason"> 상해 통원 지급 사유 </label> 
			                   <p class="text-primary"><%= insurance.getInjuryOutpatient().getProvisionReason() %><p>    
			                </div>
			              </div>
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
				
			</div> <!-- .site-wrap -->
			
				<jsp:include page="/incl/staticFooter.jsp" />

		</body>
	</html>