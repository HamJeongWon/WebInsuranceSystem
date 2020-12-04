<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
   

    <header class="site-navbar py-4 bg-white js-sticky-header site-navbar-target" role="banner">

      <div class="container">
        <div class="row align-items-center">
          
          <div class="col-11 col-xl-2">
            <h1 class="mb-0 site-logo"><a href="main" class="text-black h2 mb-0">보험회사<span class="text-primary">.</span> </a></h1>
          </div>
          <div class="col-12 col-md-10 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right" role="navigation">
				<ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
					<li class="has-children">
						<a href="InsuranceDesign" class="nav-link">상품설계하기</a>
						<ul class="dropdown">
							<li><a href = "InsuranceList"> 보험 리스트 </a></li>
							<li><a href = "FInsuranceDesign"> 화재보험 </a></li>
							<li><a href = "CInsuranceDesign">자동차보험</a></li>
							<li><a href = "AInsuranceDesign">실비보험</a></li>
						</ul>
					</li>
					<li class="has-children">
						<a href="AcceptanceGuide" class="nav-link">인수정책수립하기</a>
						<ul class="dropdown">
							<li><a href="ShowAcceptanceGuide">인수지침서 보기</a></li>
							<li><a href="SearchNullAcceptanceGuide">인수지침서 설계</a></li>
						</ul>
					</li>
					<li class="has-children">
						<a href="SalesActivityDesign" class="nav-link">영업활동</a>
						<ul class="dropdown">
							<li><a href="Menual">메뉴얼 확인하기</a></li>
							<li><a href="ProductSubscription">상품 가입 신청하기</a></li>
						</ul>
					</li>
					
					<li><a href="InsuranceSubscription" class="nav-link">인수심사하기</a></li>	
																	
					<li class="has-children">
						<a href="ContractControlDesign" class="nav-link">계약관리하기</a>
							<ul class="dropdown">
								<li><a href="PaymentControll">납부관리하기</a></li>
								<li><a href="FullContractControll">만기계약관리하기</a></li>
								<li><a href="MakeContractList">계약서작성하기</a></li>
							</ul></li>		
									
					<li class="has-children">
						<a href="InsuranceTreatment" class="nav-link">보험처리하기</a>
						<ul class="dropdown">
							<li><a href="AccidentReception">사고내용작성하기</a></li>
							<li><a href="CalculateAccidentFund">결정보험금 산출하기</a></li>
							<li><a href="PaymentAccidentFund">결정보험금 지급하기</a></li>
						</ul>
					</li>
				</ul>
          	</nav>
          </div>
      <div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3" style="position: relative; top: 3px;">
          	<a href="#" class="site-menu-toggle js-menu-toggle text-black">
          		<span class="icon-menu h3"></span>
       		</a>
		  </div>
        </div>
      </div>
      
    </header>
