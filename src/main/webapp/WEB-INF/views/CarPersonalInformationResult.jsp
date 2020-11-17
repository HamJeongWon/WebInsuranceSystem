<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");  %>
<%@ page import="com.example.demo.model.Customer.Car"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> 기존 고객의 자동차 보험 가입 </title>
</head>
<body> 
<jsp:include page="/incl/staticHeader.jsp" />
<jsp:include page="/incl/Header.jsp" />

<% 	 Integer CustomerID = (Integer)request.getAttribute("CustomerID"); 
	Integer InsuranceID = (Integer)request.getAttribute("InsuranceID"); 
	Car car = (Car)request.getAttribute("car");%>

<section class="site-section bg-light" id="contact-section">

      <div class="container">
      
       <div class="row mb-5">
          <div class="col-12 text-center">
            <h2 class="text-black h1 site-section-heading">고객 가입 결과</h2>
          </div>
        </div>
        
        <div class="p-5 bg-white" style="margin: auto; max-width: 700px;">
			 <div class="row form-group">
               <div class="col-md-12">
                  <label class="text-black" for="InsuranceID">자동차 보험 id </label><br>
				  <%= InsuranceID %>
               </div>         
              </div>
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="carNumber"> 차 번호 </label> <br>
                  <%= car.getCarNumber() %> 
                </div>
              </div>

              <div class="row form-group">          
                <div class="col-md-12">
                  <label class="text-black" for="carType">자동차 종류</label> <br>
            	   <%= car.getCarType() %>
                </div>
              </div>
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="carCareer">운전 경력</label> <br>
                   <%= car.getDrivingCareer() %>
                 </div>
              </div>
              
              <div class="row form-group">          
                <div class="col-md-12">
                  <label class="text-black" for="licenseType">면허 종류</label> <br>
          			<%= car.getLicenseType() %>
                </div>
              </div>             
             <br>    
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
	</body>
</html>