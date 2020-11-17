<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); 
 	String cp = request.getContextPath(); %>
<%@ page import="com.example.demo.model.Customer.Car.CarType"%>
<%@ page import="com.example.demo.model.Customer.Car.LicenseType"%>
<%@ page import="com.example.demo.model.Insurance.Insurance"%>
<%@page import="java.util.Vector"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> 기존 고객의 자동차 보험 가입 </title>
</head>
<script type="text/javascript" src="<%=cp%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=cp%>/js/numberOnly.js"></script>
<script type="text/javascript">

	function checkValue() {
	    if(!document.InsInfo.InsuranceID.value){
	        alert("보험 이름을 선택하세요.");
	        return false;
	    }
	    if(!document.InsInfo.carNumber.value){
	        alert("차번호를 입력하세요.");
	        return false;
	    }
	    if(!document.InsInfo.carType.value){
	        alert("차 종류를 선택하세요.");
	        return false;
	    }
	    if(!document.InsInfo.carCareer.value){
	        alert("운전 경력을 입력하세요.");
	        return false;
	    }
	    
	    if(!document.InsInfo.licenseType.value){
	        alert("면허 종류를 입력하세요.");
	        return false;
	    }	
    }

</script>
<body> 
<jsp:include page="/incl/staticHeader.jsp" />
<jsp:include page="/incl/Header.jsp" />

<% 	 Integer CustomerID = Integer.parseInt(request.getParameter("CustomerID")); 
	Vector<Insurance> CarVec = (Vector<Insurance>)request.getAttribute("InsuVec");
	Vector<CarType> carType = (Vector<CarType>)request.getAttribute("carType");
	Vector<LicenseType> licenseType = (Vector<LicenseType>)request.getAttribute("licenseType");%>

<section class="site-section bg-light" id="contact-section" style = "padding-top : 200px;">

      <div class="container">
      
        <div class="row mb-5">
          <div class="col-12 text-center">
            <h2 class="text-black h1 site-section-heading">자동차 보험 가입</h2>
            <p class="lead">자동차 보험에 필요한 고객 정보 입력</p>
          </div>
        </div>
        
         <div>
             <form action= ./PersonalInfInsurance method="post" class="p-5 bg-white" style = "margin:auto; max-width: 700px;" name = "InsInfo" onsubmit="return checkValue()">  
              <h2 class="h4 text-black mb-5" align = "center"> 자동차 보험 </h2> 
				
			 <div class="row form-group">
               <div class="col-md-12">
                  <label class="text-black" for="InsuranceID">자동차 보험 이름 </label> 
   					<select name="InsuranceID"  class="form-control">
              			<%for(Insurance insu : CarVec) {%>
              				<option value = <%= insu.getInsuranceID()%>> <%= insu.getInsuranceName() %></option>
              			<%}%>						
   					</select>
               </div>         
              </div>
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="carNumber"> 차 번호 </label> 
                  <input type="text" name ="carNumber" class="form-control">
                </div>
              </div>

              <div class="row form-group">          
                <div class="col-md-12">
                  <label class="text-black" for="carType">자동차 종류</label> 
                   <select name="carType"  class="form-control">
              			<%for(CarType Type : carType) {%>
              				<option value = <%= Type%>> <%= Type%></option>
              			<%}%>						
   					</select>
                </div>
              </div>
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="carCareer">운전 경력</label> 
                 <input type="Number" name ="carCareer" class="form-control" placeholder="년">
                 </div>
              </div>
              
              <div class="row form-group">          
                <div class="col-md-12">
                  <label class="text-black" for="licenseType">면허 종류</label> 
                   <select name="licenseType"  class="form-control">
              			<%for(LicenseType Type : licenseType) {%>
              				<option value = <%= Type%>> <%= Type %></option>
              			<%}%>						
   					</select>
                </div>
              </div>
              
              <br>    
                     
              <div class="row form-group">
                <div class="col-md-12">
                  <input type="hidden" name="CustomerID" value= <%= CustomerID %>>
                  <input type="hidden" name="InsuranceTypeForInsert" value="Car">
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