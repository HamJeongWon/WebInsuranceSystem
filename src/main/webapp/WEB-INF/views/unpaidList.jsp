<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>미납자 조회</title>
</head>
<body>
	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />
		

<section class="site-section bg-light" id="contact-section">
	<div class="container">
	<div class="row mb-5">
		<div class="col-12 text-center">
		<h2 class="text-black h1 site-section-heading">미납자 조회하기</h2>
			<br>
			<br>
					<table class = "table table-striped">
						<thead>
							<tr>
								<td>계약 id</td>
								<td>고객 이름</td>
								<td>전화번호</td>
								<td>납입 날짜</td>
								<td>납입 상태</td>
								<td>납입 형태</td>
							</tr>
						</thead>	
							<tbody>
							  <% Vector<String> unpaidVec = (Vector<String>)request.getAttribute("unpaidVec");
								 for(int i = 0; i<unpaidVec.size(); i++) {							 
									if(i%6==0){%>
										<tr>
									<%}%>									
									<td><%= unpaidVec.get(i)%></td>
									<%if((i+1)%6==0){%>
										</tr>
									<%}
									}%>
							</tbody>
					</table>		 
				</div>
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
	</body>
</html>