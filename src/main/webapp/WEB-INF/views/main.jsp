<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	
		<head>
			<meta charset="UTF-8">
			<title>First Page</title>
			<jsp:include page="/incl/staticHeader.jsp" />
		</head>
		
		<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
		
		  <div class="site-wrap">
			<jsp:include page="/incl/Header.jsp" />
			
			<div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
		      <div class="container" style = "margin-top:-100px;">
		        <div class="row align-items-center justify-content-center text-center">
		
		          <div class="col-md-12" data-aos="fade-up" data-aos-delay="400">
		                        
		            <div class="row justify-content-center mb-4">
		              <div class="col-md-12 text-center">
		                <h1>Welcome to our Insurance <span class="typed-words"></span></h1>
		                <br>
		                <p class="lead mb-5">Made by Kim Kyung Hyun, Jeong Seok Woo, Ham Jeong Won </p>
		              </div>
		            </div>
		
		          </div>
		        </div>
		      </div>
		    </div>

			<section class="site-section testimonial-wrap">
		      <div class="container">
		        <div class="row justify-content-center">
		          <div class="col-md-8 text-center" style = "margin-top : 70px;">
		            <h2 class="text-black h1 site-section-heading text-center"> System Description </h2>
		          </div>
		        </div>
		      </div>
		      <div class="slide-one-item home-slider owl-carousel">
		      
		          <div>
		            <div class="testimonial">
		              <blockquote class="mb-5">
		              	<h2 style = "margin:20px;"> 보험 설계 </h2>
		                <p> 이 보험시스템에서는 3가지 타입의 보험을 설계할 수 있다. 그 타입으로는 화재보험, 자동차보험, 실비보험이 존재하는데 같은 타입의 보험이더라도 보장내용과 보험금에 따라 다르게 설계가 가능하다.</p>
		              </blockquote>
		              <figure class="mb-4 d-flex align-items-center justify-content-center">
		                <p><a href="InsuranceDesign" target="_blank">상품 설계하기</a></p>
		              </figure>
		            </div>
		          </div>
		          
		          <div>
		            <div class="testimonial">
		
		              <blockquote class="mb-5">
		              	<h2 style = "margin:20px;"> 인수 정책 수립 </h2>
		                <p> 고객이 보험에 가입을 신청하면 인수를 승인하기 위해 참고되는 인수지침서를 만들거나 확인할 수 있다.</p>
		              </blockquote>
		              <figure class="mb-4 d-flex align-items-center justify-content-center">
		                <p><a href="AcceptanceGuide" target="_blank">인수 정책 수립하기</a></p>
		              </figure>
		              
		            </div>
		          </div>
		
		          <div>
		            <div class="testimonial">
		
		              <blockquote class="mb-5">
		              	<h2 style = "margin:20px;"> 영업 활동 </h2>
		                <p> 보험들의 상품, 판매 메뉴얼들을 확인하여 신규 혹은 기존의 고객들에게 상품을 가입시킬 수 있다.</p>
		              </blockquote>
		              <figure class="mb-4 d-flex align-items-center justify-content-center">
		                <p><a href="SalesActivityDesign" target="_blank">영업 활동하기</a></p>
		              </figure>
		
		              
		            </div>
		          </div>
		
		          <div>
		            <div class="testimonial">
		
		              <blockquote class="mb-5">
		              	<h2 style = "margin:20px;"> 인수 심사하기 </h2>
		                <p> 보험 가입신청을 한 고객의 정보와 인수지침서를 참고하여 인수 승인여부를 판단할 수 있다.</p>
		              </blockquote>
		              <figure class="mb-4 d-flex align-items-center justify-content-center">
		                <p><a href="AcceptInsuranceSubscription?action=showID" target="_blank">인수 심사하기</a></p>
		              </figure>
		
		            </div>
		          </div>
		          
		          <div>
		            <div class="testimonial">
		
		              <blockquote class="mb-5">
		              	<h2 style = "margin:20px;"> 계약 관리 </h2>
		                <p> 보험에 가입을 한 고객들의 계약을 관리할 수 있다. 납부 관리, 만기계약자 관리, 재계약을 할 수 있다.</p>
		              </blockquote>
		              <figure class="mb-4 d-flex align-items-center justify-content-center">
		                <p><a href="ContractControlDesign" target="_blank">계약 관리하기</a></p>
		              </figure>
		
		            </div>
		          </div>
		          
		          <div>
		            <div class="testimonial">
		
		              <blockquote class="mb-5">
		              	<h2 style = "margin:20px;"> 보험 처리 </h2>
		                <p> 고객이 사고가 났을 때 해당 사고를 접수하고 결정보험금을 산출하여 지급할 수 있다.</p>
		              </blockquote>
		              <figure class="mb-4 d-flex align-items-center justify-content-center">
		                <p><a href="InsuranceTreatment" target="_blank">보험 처리하기</a></p>
		              </figure>
		
		            </div>
		          </div>
		
		        </div>

		    </section>  

				<jsp:include page="/incl/Footer.jsp" />
				
			</div> <!-- .site-wrap -->
			
				<jsp:include page="/incl/staticFooter.jsp" />

		</body>
	</html>