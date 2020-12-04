<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만기 계약자 조회</title>
</head>
<body>
	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />
			

<section class="site-section bg-light" id="contact-section">
	<div class="container">
	<div class="row mb-5">
		<div class="col-12 text-center">
		<h2 class="text-black h1 site-section-heading">만기 계약자 조회하기</h2>
			<br>
			<br>
					<table class = "table table-striped">
						<thead>
							<tr>
								<td>계약 id</td>
								<td>고객 id</td>
								<td>고객 이름</td>
								<td>계약 만기 날짜</td>
								<td>개인정보 보유 기간</td>
								<td>재계약 하기</td>
							</tr>
						</thead>	
							<tbody>
							  <% Vector<String> VecFullContract = (Vector<String>)request.getAttribute("VecFullContract");
								int contractID = 0; 
								int customerID = 0; 
							  	for(int i = 0; i<VecFullContract.size(); i++) {							 
									if(i%5==0){
									    contractID = Integer.parseInt(VecFullContract.get(i));
									    customerID = Integer.parseInt(VecFullContract.get(i+1));%>
										<tr>
									<%}%>									
									<td><%= VecFullContract.get(i)%></td>
									<%if((i+1)%5==0){%>
										<td>
										<form action = "RecontractStart" method="post">
											<input type = hidden name = "contractID" value = <%= contractID%>>
											<input type = hidden name = "customerID" value = <%= customerID%>>
											<input type="submit" class="btn btn-primary" value="진행">									
										</form>
										</td>
										</tr>
									<%}
									}%>
							</tbody>
					</table>		 
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