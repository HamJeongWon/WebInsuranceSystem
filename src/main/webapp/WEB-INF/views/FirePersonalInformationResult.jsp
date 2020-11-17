<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");  %>
<%@ page import="com.example.demo.model.Customer.Building"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> 기존 고객의 화재보험 가입 </title>
</head>
<body> 
<jsp:include page="/incl/staticHeader.jsp" />
<jsp:include page="/incl/Header.jsp" />

<% 	 Integer CustomerID = (Integer)request.getAttribute("CustomerID"); 
	 Integer InsuranceID = (Integer)request.getAttribute("InsuranceID"); 
	 Building building = (Building)request.getAttribute("building");
	%>

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
                  <label class="text-black" for="insuranceName">화재 보험 id </label><br> 
					<%= InsuranceID %>
               </div>         
              </div>
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="buildingAddress"> 주소 </label> <br>
                  <%= building.getBuildingAddress() %>
                </div>
              </div>

              <div class="row form-group">          
                <div class="col-md-12">
                  <label class="text-black" for="buildingPrice">건물 시세</label><br>
                 <%= building.getBuildingPrice() %> 
                </div>
              </div>
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="buildingScale">건물 규모</label> <br>
                  <%= building.getBuildingScale() %> 
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