<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴얼 결과 출력 페이지</title>
</head>
<body>
	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />
	
	<%
	Integer InsuranceID = (Integer)request.getAttribute("InsuranceID");
	String InsuranceName = (String)request.getAttribute("InsuranceName");
	String Content = (String)request.getAttribute("Content");
	%>

<section class="site-section bg-light" id="contact-section" style = "padding-top : 200px;">
	<div class="container">
	<div class="row mb-5">
		<div class="col-12 text-center">
					<h2 class="text-black h1 site-section-heading">메뉴얼 확인</h2>
					<br>
					<br>
			<table class = "table table-striped">
				<thead>
					<tr>
						<td>보험 id</td>
						<td>보험 이름</td>
						<td>메뉴얼</td>
					</tr>
				</thead>
	
				<tbody>
					<tr>
						<td><%= InsuranceID%></td>
						<td><%= InsuranceName%></td>
						<td><%= Content%></td>
					</tr>
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
		<jsp:include page="/incl/staticFooter.jsp" />
	</body>
</html>