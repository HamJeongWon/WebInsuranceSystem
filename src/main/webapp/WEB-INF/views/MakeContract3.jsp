<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="com.example.demo.model.Contract.Contract"%>
<%@page import ="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>청약서</title>
</head>
	<% 
	   Contract contract = (Contract)request.getAttribute("contract"); 	 
	   SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	%>

<body>
	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />


<section class="site-section bg-light" id="contact-section">

      <div class="container">
      
        <div class="row mb-5">
          <div class="col-12 text-center">
            <h2 class="text-black h1 site-section-heading">청약서</h2>
          </div>
        </div>
        
         <div>
			<div class="row form-group">
               <div class="col-md-12">
                  <label class="text-black">계약ID </label> 
                  	<%=  contract.getContractID()%>
               </div>         
              </div>
                           
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black">납입 날짜 </label> 
                 	<%= SDF.format(contract.getPaymentDate()) %>
                </div>
              </div>

              <div class="row form-group">          
                <div class="col-md-12">
                  <label class="text-black">납입방식</label>    
           			<%= contract.getPaymentType() %>
                </div>
              </div>
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black">계약만료일</label>
               	  	<%= SDF.format(contract.getContractExpirationDate())%>      
                 </div>                 
               </div>
                             
               <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black">개인정보보호기간</label>
                  	<%= SDF.format(contract.getPersonalInformationRetentionPeriod())%>          
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
	</body>
</html>
