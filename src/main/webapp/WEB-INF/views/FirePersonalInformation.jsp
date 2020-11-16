<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   String cp = request.getContextPath(); %>
<%@ page import="com.example.demo.model.Insurance.Insurance"%>
<%@ page import="com.example.demo.model.Customer.Building"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> 기존 고객의 화재보험 가입 </title>
</head>
<script type="text/javascript" src="<%=cp%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=cp%>/js/numberOnly.js"></script>
<script type="text/javascript">

	function checkValue() {
	    if(!document.InsInfo.InsuranceID.value){
	        alert("보험 이름을 선택하세요.");
	        return false;
	    }
	    if(!document.InsInfo.buildingAddress.value){
	        alert("주소를 입력하세요.");
	        return false;
	    }
	    if(!document.InsInfo.buildingPrice.value){
	        alert("건물 시세를 입력하세요.");
	        return false;
	    }
	    if(!document.InsInfo.buildingScale.value){
	        alert("건물 규모를 입력하세요.");
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

<body> 
<jsp:include page="/incl/staticHeader.jsp" />
<jsp:include page="/incl/Header.jsp" />

<% 	 Integer CustomerID = Integer.parseInt(request.getParameter("CustomerID")); 
	 Vector<Insurance> FireVec = (Vector<Insurance>)request.getAttribute("InsuVec");
	%>

<section class="site-section bg-light" id="contact-section" style = "padding-top : 200px;">

      <div class="container">
      
        <div class="row mb-5">
          <div class="col-12 text-center">
            <h2 class="text-black h1 site-section-heading">화재 보험 가입</h2>
            <p class="lead">화재 보험에 필요한 고객 정보 입력</p>
          </div>
        </div>
        
         <div>
             <form action= ./PersonalInfInsurance method="post" class="p-5 bg-white" style = "margin:auto; max-width: 700px;" name = "InsInfo" onsubmit="return checkValue()">  
              <h2 class="h4 text-black mb-5" align = "center"> 화재 보험 </h2> 
				
			 <div class="row form-group">
               <div class="col-md-12">
                  <label class="text-black" for="insuranceName">화재 보험 이름 </label> 
              		<select name="InsuranceID"  class="form-control">
              			<%for(Insurance insu : FireVec) {%>
              				<option value = <%= insu.getInsuranceID()%>> <%= insu.getInsuranceName() %></option>
              			<%}%>						
   					</select>
               </div>         
              </div>
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="buildingAddress"> 주소 </label> 
                  <input type="text" name ="buildingAddress" class="form-control">
                </div>
              </div>

              <div class="row form-group">          
                <div class="col-md-12">
                  <label class="text-black" for="buildingPrice">건물 시세</label>                   
               	   <input type="text" name ="buildingPrice" class="form-control" placeholder="원" id = "numberOnly">    
                </div>
              </div>
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="buildingScale">건물 규모</label> 
                  <input type="text" name ="buildingScale" class="form-control" placeholder="몇 평.">        
                 </div>
              </div>
              <br>    
                     
              <div class="row form-group">
                <div class="col-md-12">
                  <input type="hidden" name="CustomerID" value= <%= CustomerID %>>
                  <input type="hidden" name="InsuranceTypeForInsert" value="Fire">
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