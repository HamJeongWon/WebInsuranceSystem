<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.model.Insurance.Insurance"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 매뉴얼 확인하기</title>
</head>
<body>
	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />
		

<section class="site-section bg-light" id="contact-section" style = "padding-top : 200px;"> 
	<div class="container">
	<div class="row mb-5">
		<div class="col-12 text-center">
		<h2 class="text-black h1 site-section-heading">메뉴얼 확인하기</h2>
			<br>
			<br>

					<table class = "table table-striped">
						<thead>
							<tr>
								<td>보험 id</td>
								<td>보험 이름</td>
								<td>판매 매뉴얼</td>
								<td>상품 매뉴얼</td>
							</tr>
						</thead>	
							<tbody>
							<% List<Insurance> VecInsurance = (List<Insurance>)request.getAttribute("InsuranceList");
								for(Insurance insu : VecInsurance) {
								%>
								<tr><td><%=  insu.getInsuranceID()%></td>
								<td><%=  insu.getInsuranceName()%></td>							
								<td> <form action= GetSaleMenual> 
								 	 <input type="hidden" name="InsuranceID" value =<%= insu.getInsuranceID()%>>
								 	 <input type="hidden" name="InsuranceName" value =<%= insu.getInsuranceName()%>>
								 	 <input type="submit" name = "menual"  class="btn btn-primary" value="판매 메뉴얼 조회">
								 	 </form>
								 	 </td>
						 		<td> <form action= GetProductMenual>
						 			 <input type="hidden" name="InsuranceID" value = <%=insu.getInsuranceID() %>>
								 	 <input type="hidden" name="InsuranceName" value = <%=insu.getInsuranceName() %>>
								 	 <input type="submit" name = "menual"  class="btn btn-primary" value="상품 메뉴얼 조회">
								 	 </form>
								 	 </td></tr>
									
									<%	
									}
									%>			
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