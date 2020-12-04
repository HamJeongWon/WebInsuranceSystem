<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인수 승인된 보험id와 고객id 리스트 출력</title>
</head>
<body>

	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />
	

<section class="site-section bg-light" id="contact-section">
      <div class="container">
   		<div class="row mb-5">
			<div class="col-12 text-center">
				<h2 class="text-black h1 site-section-heading">계약서 작성</h2>
				<p class="lead">해당 리스트는 인수 승인이 완료된 고객의 id와 보험id를 나타내는 리스트이다. 계약서 작성을 원하는 고객을 선택하면 된다.</p>
			</div>
		</div>
				<br>
				<br>
					<table class = "table table-striped">
						<thead>
							<tr>
								<td>보험 id</td>
								<td>고객 id</td>
								<td>계약서 작성하기</td>
							</tr>
						</thead>	   			
						<tbody>
							 <%Vector<Integer> IDVector = (Vector<Integer>) request.getAttribute("IDVector");					
							  	for(int i = 0; i<IDVector.size(); i++) {							 
									if(i%2==0){%>
										<tr><td><%= IDVector.get(i)%></td>								
									<%} else {%>									
										<td><%= IDVector.get(i)%></td>
										<td><form action = "MakeContractMake" method = "post">
											<input type = "hidden" name = "insuranceID" value = <%= IDVector.get(i-1)%>>
											<input type = "hidden" name = "customerID" value = <%= IDVector.get(i)%>>
											<input type= "submit" value = "진행" class="btn btn-primary">
											</form></td></tr>
									<% }
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
	</body>
</html>
	
	
</body>
</html>