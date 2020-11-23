<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>InsuranceSystem</title>
			<jsp:include page="/incl/staticHeader.jsp" />
		</head>
		
		<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
		
		  <div class="site-wrap">
		  
			<jsp:include page="/incl/Header.jsp" />
	
		    <section class="site-section" style = "padding-top : 200px;">
		      <div class="container">
		        <div class="row">
		          <div class="col-md-6 col-lg-4">
		            <div class="p-3 box-with-humber">
		              <div class="number-behind">01.</div>
		              <h2 class="text-primary">인수지침서 보기</h2>
		              <p class="mb-4">각 보험별로 위험평가와 사기사례가 작성되있는 지침서로 인수 승인을 할 때 참고한다.</p>
		              <ul class="list-unstyled ul-check primary">
		                <li>화재보험 인수지침서</li>
		                <li>자동차보험 인수지침서</li>
		                <li>실비보험 인시지침서</li>
		              </ul>
		              <p><a href="ShowAcceptanceGuide">인수지침서 보기</a></p>
		            </div>
		          </div>
	
		          <div class="col-md-6 col-lg-4">
		            <div class="p-3 box-with-humber">
		              <div class="number-behind">02.</div>
		              <h2 class="text-primary">인수지침서 설계</h2>
		              <p class="mb-4">새로 설계한 보험의 위험평가나 비슷한 보험의 사기사례를 작성하여 지침서로 만들수 있다.</p>
		              <ul class="list-unstyled ul-check primary">
		                <li>화재보험 인수지침서</li>
		                <li>자동차보험 인수지침서</li>
		                <li>실비보험 인시지침서</li>
		              </ul>
					  <p><a href="SearchNullAcceptanceGuide">인수지침서 설계</a></p>
		            </div>
		          </div>
		        </div>
		      </div>
	   	 	</section>

				<jsp:include page="/incl/Footer.jsp" />
				
			</div> <!-- .site-wrap -->
			
				<jsp:include page="/incl/staticFooter.jsp" />

		</body>
	</html>