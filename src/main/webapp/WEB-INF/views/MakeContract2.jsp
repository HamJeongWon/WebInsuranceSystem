<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   String cp = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=cp%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=cp%>/js/numberOnly.js"></script>
<script type="text/javascript">

	function checkValue() {
	    if(!document.InsInfo.contractExpirationDate.value){
	        alert("계약 만료일을 입력하세요.");
	        return false;
	    }
	    if(!document.InsInfo.paymentDate.value){
	        alert("납입 날짜를 입력하세요.");
	        return false;
	    }
	    if(!document.InsInfo.paymentPeriod.value){
	        alert("납입 기간을 입력하세요.");
	        return false;
	    }
    }
</script>

<body>
	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />
	

<section class="site-section bg-light" id="contact-section">
      <div class="container">
   		<div class="row mb-5">
			<div class="col-12 text-center">
				<h2 class="text-black h1 site-section-heading">계약서 작성</h2>
			</div>
		</div>
      <div>
         <form action= "MakeContractFinish" method= POST class="p-5 bg-white" style = "margin:auto; max-width: 700px;" name = "InsInfo" onsubmit="return checkValue()">
              <h2 class="h4 text-black mb-5" align = "center"> 계약서 정보 입력 </h2> 
			
			    <% 
			    Integer contractID = (Integer)request.getAttribute("contractID");
			    Integer insuranceID = (Integer)request.getAttribute("insuranceID");
			    Integer customerID = (Integer)request.getAttribute("customerID");
			    Integer paymentAmout = (Integer)request.getAttribute("paymentAmout");    
   				 %>
    
			 <div class="row form-group">
               <div class="col-md-12">
                  <label class="text-black" for="contractID">계약 ID</label> 
         			<%=  contractID%>
               </div>         
              </div>
              
              
              <div class="row form-group">
               <div class="col-md-12">
                  <label class="text-black" for="customerID">고객 ID</label> 
         			<%=  customerID%>
               </div>         
              </div>
              
              
              <div class="row form-group">
               <div class="col-md-12">
                  <label class="text-black" for="insuranceID">보험 ID</label> 
         			<%=  insuranceID%>
               </div>         
              </div>
              
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="contractExpirationDate"> 계약 만료일 </label> 
                  <input type="date" name ="contractExpirationDate" class="form-control">
                </div>
              </div>
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="paymentAmout">월 보험 납입료 </label><br>
              		  <%=  paymentAmout +"원"%>
                </div>
              </div>              
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="paymentDate">납입 날짜</label> 
              		<input type="date" name ="paymentDate" class="form-control">
                </div>
              </div>
                           
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="paymentPeriod">납입 기간</label> 
              		<input type="number" name ="paymentPeriod" class="form-control" placeholder="몇 개월">
                </div>
              </div>
              
              
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="paymentType">납입 방법</label> 
    			  	<select name ="paymentType" class="form-control">
             	  		<option value="creditCard">신용카드</option>
						<option value="e_bancking">인터넷뱅킹</option>
						<option value="accountTransfer">계좌이체</option>
             	  	</select>
                </div>
              </div>
              <input type = hidden name = insuranceID value = <%=  insuranceID%>>
              <input type = hidden name = customerID value = <%=  customerID%>>
              <input type = hidden name = contractID value = <%=  contractID%>>
              <input type = hidden name = paymentAmout value = <%=  paymentAmout%>>
              <input type= "submit" value = "작성 완료" class="btn btn-primary">   
              <input type= "reset" value = "다시 작성하기" class="btn btn-primary">              
           </form>   
                
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
	
	
</body>
</html>