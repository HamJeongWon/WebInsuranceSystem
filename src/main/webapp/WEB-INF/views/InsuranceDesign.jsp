<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="EUC-KR">
			<title>InsuranceSystem</title>
			<jsp:include page="/incl/staticHeader.jsp" />
		</head>
		
		<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300" >
		
		  <div class="site-wrap">
		  
			<jsp:include page="/incl/Header.jsp" />
			
		    <section class="site-section" style = "padding-top : 200px;">
		      <div class="container">
		        <div class="row">
		          <div class="col-md-6 col-lg-4">
		            <div class="p-3 box-with-humber">
		              <div class="number-behind">01.</div>
		              <h2 class="text-primary">화재 보험</h2>
		              <p class="mb-4">화재나 번개 그리고 이러한 손실의 방지를 위해 취해진 부동산 및 동산의 재산적 손실을 부보하는 손해보험이다. 태풍이나 회오리 바람 또는 도난 등과 같은 손인들이 포함될 수도 있다. 게다가 위와 같은 직접적 손실은 물론 사업 관련 손실의 결과로 입은 수익 및 임차료 그리고 특별 경비 등의 손실도 경우에 따라서 부보받을 수 있다.</p>
		              <ul class="list-unstyled ul-check primary">
		                <li>직접 손해</li>
		                <li>소방 손해</li>
		                <li>피난 손해</li>
		              </ul>
		              <p><a href="FInsuranceDesign">화재보험 설계하기</a></p>
		            </div>
		          </div>
		
		          <div class="col-md-6 col-lg-4">
		            <div class="p-3 box-with-humber">
		              <div class="number-behind">02.</div>
		              <h2 class="text-primary">자동차 보험</h2>
		              <p class="mb-4">자동차를 소유, 운행, 관리하는 동안 발생하는 각종 사고로 인하여 생긴 피해를 담보별로 보상할 것을 목적으로 하는 보상 혜택을 받을 수 있는 보험을 말한다.</p>
		              <ul class="list-unstyled ul-check primary">
		                <li>대인 배상</li>
		                <li>대물 배상</li>
		                <li>자기 차량 손해</li>
		              </ul>
		              <p><a href="CInsuranceDesign">자동차보험 설계하기</a></p>
		            </div>
		          </div>
		
		          <div class="col-md-6 col-lg-4">
		            <div class="p-3 box-with-humber">
		              <div class="number-behind">03.</div>
		              <h2 class="text-primary">실비 보험</h2>
		              <p class="mb-4">보험 가입자가 질병이나 상해를 병원치료를 받을 때 보험약관에 약정한 금액만을 지급하는 정액보상과 달리 실제 부담한 의료비를 지급받는 상품을 말한다.</p>
		              <ul class="list-unstyled ul-check primary">
		                <li>상해 통원</li>
		                <li>상해 입원</li>
		              </ul>
					  <p><a href="AInsuranceDesign">실비보험 설계하기</a></p>
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