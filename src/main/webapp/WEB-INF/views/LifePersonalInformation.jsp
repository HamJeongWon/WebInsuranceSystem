<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");  %>
<%@ page import="com.example.demo.model.Insurance.Insurance"%>
<%@page import="java.util.Vector"%>
<%@ page import="com.example.demo.model.Customer.ActualCost.BloodType"%>
<%@ page import="com.example.demo.model.Customer.ActualCost.DiseaseHistory"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> 기존 고객의 실비보험 가입 </title>
</head>
<script type="text/javascript">

	function checkValue() {
	    if(!document.InsInfo.InsuranceID.value){
	        alert("보험 이름을 선택하세요.");
	        return false;
	    }
    }
</script>
<body> 
<jsp:include page="/incl/staticHeader.jsp" />
<jsp:include page="/incl/Header.jsp" />

<% Integer CustomerID = Integer.parseInt(request.getParameter("CustomerID"));
	Vector<Insurance> ActualCostVec = (Vector<Insurance>)request.getAttribute("InsuVec");
	Vector<BloodType> VecBloodType = (Vector<BloodType>)request.getAttribute("VecBloodType");
	Vector<DiseaseHistory> VecDiseaseHistory = (Vector<DiseaseHistory>)request.getAttribute("VecDiseaseHistory");%>

<section class="site-section bg-light" id="contact-section" style = "padding-top : 200px;">

      <div class="container">
      
        <div class="row mb-5">
          <div class="col-12 text-center">
            <h2 class="text-black h1 site-section-heading">실비 보험 가입</h2>
            <p class="lead">실비 보험에 필요한 고객 정보 입력</p>
          </div>
        </div>
        
         <div>
            <form action= ./PersonalInfInsurance method= POST class="p-5 bg-white" style = "margin:auto; max-width: 700px;" name = "InsInfo" onsubmit="return checkValue()">
              
              <h2 class="h4 text-black mb-5" align = "center"> 실비 보험 </h2> 
				
			 <div class="row form-group">
               <div class="col-md-12">
                  <label class="text-black" for="InsuranceID">실비 보험 이름 </label> 
              		<select name="InsuranceID"  class="form-control">
              			<%for(Insurance insu : ActualCostVec) {%>
              				<option value = <%= insu.getInsuranceID()%>> <%= insu.getInsuranceName() %></option>
              			<%}%>						
   					</select>
               </div>         
              </div>
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="bloodType"> 혈액형 타입 </label> 
                	<select name="bloodType"  class="form-control">
              			<%for(BloodType Type : VecBloodType) {%>
              				<option value = <%= Type%>> <%= Type %></option>
              			<%}%>						
   					</select>
                </div>
              </div>

              <div class="row form-group">          
                <div class="col-md-12">
                  <label class="text-black" for="diseaseHistory">질병 이력</label> 
                 	<select name="diseaseHistory"  class="form-control">
              			<%for(DiseaseHistory Type : VecDiseaseHistory) {%>
              				<option value = <%= Type%>> <%= Type %></option>
              			<%}%>						
   					</select>
                </div>
              </div>
              
              <div class="row form-group">
                <div class="col-md-12">
                  <h2>가족 질병 이력</h2><br>                  
                   <label class="text-black">가족 관계</label> 
                  	<select name="familyrelation"  class="form-control">
              			<option value = "부">부</option>
              			<option value = "모">모</option>		
              			<option value = "조부">조부</option>		
              			<option value = "조모">조모</option>							
   					</select>
   					
   					<label class="text-black">가족 질병</label> 
   					 <select name="familyDisease"  class="form-control">
              			<%for(DiseaseHistory Type : VecDiseaseHistory) {%>
              				<option value = <%= Type%>> <%= Type %></option>
              			<%}%>						
   					</select>   					
                 </div>
              </div>
              <br>    
                     
              <div class="row form-group">
                <div class="col-md-12">
                  <input type="hidden" name="CustomerID" value= <%= CustomerID %>>
                  <input type="hidden" name="InsuranceTypeForInsert" value="ActualCost">
                  <input type="submit" value="입력 완료" class="btn btn-primary btn-md text-white" style="float: right;">
                  <input type="reset" value="다시 작성" class="btn btn-primary btn-md text-white">
                </div>
              </div>

            </form>
           </div>   
         </div>
    </section> 
    
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
		<jsp:include page="/incl/staticFooter.jsp" />
	</body>
</html>