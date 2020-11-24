<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.example.demo.model.Acceptance.AcceptanceGuide"%>
<%@ page import="com.example.demo.model.Customer.Customer"%>
<%@ page import="com.example.demo.model.Insurance.Insurance"%>
<%@ page import="com.example.demo.model.Customer.Building"%>
<%@ page import="com.example.demo.model.Customer.Car"%>
<%@ page import="com.example.demo.model.Customer.ActualCost"%>
<%@ page import="com.example.demo.model.Customer.PersonalInformation"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>인수심사하기</title>
<jsp:include page="/incl/staticHeader.jsp" />
<jsp:include page="/incl/Header.jsp" />
<%
	int insuranceID = (int) request.getAttribute("insuranceID");
	AcceptanceGuide acceptanceGuide = (AcceptanceGuide) request.getAttribute("acceptanceGuide");
	Customer customer = (Customer) request.getAttribute("customer");
	PersonalInformation personalInformation = (PersonalInformation) request.getAttribute("personalInformation");
%>
</head>
<body>
	<section class="site-section bg-light" id="contact-section" style = "padding-top : 200px;">
		<c>
		<div class="container">
			<div class="row mb-5">
				<div class="col-12 text-center">
					<h2 class="text-black h1 site-section-heading">인수심사하기</h2>
				</div>
			</div>

			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="acceptanceID">인수ID:</label>
					${acceptanceGuide.acceptanceID}
				</div>
			</div>

			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="scamCase">사고사례:</label>
					${acceptanceGuide.scamCase}
				</div>
			</div>

			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="riskEvaluation">위험평가:</label>
					${acceptanceGuide.riskEvaluation}
				</div>
			</div>

			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="customerID">고객ID:</label>
					${customer.customerID }
				</div>
			</div>


			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="customerName">고객이름:</label>
					${customer.customerName }
				</div>
			</div>

			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="phoneNum">고객전화번호:</label>
					${customer.phoneNum }
				</div>
			</div>


			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="accidentHistory">고객과거사고이력:</label>
					${personalInformation.accidentHistory}
				</div>
			</div>


			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="accountNumber">고객계좌번호:</label>
					${personalInformation.accountNumber}
				</div>
			</div>

			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="accidentHistory">고객직업:</label>
					${personalInformation.job}
				</div>
			</div>

			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="accidentHistory">고객재산:</label>
					${personalInformation.property}
				</div>
			</div>

			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="accidentHistory">고객주민등록번호:</label>
					${personalInformation.residentRegistrationNumber}
				</div>
			</div>

			<%
		switch ((Insurance.InsuranceType) request.getAttribute("insuranceType")) {
		case Fire:
			Building building = (Building) request.getAttribute("insurance");%>
			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="buildingAddress">건물주소:</label>
					<%=building.getBuildingAddress()%>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="buildingPrice">건물가격:</label>
					<%=building.getBuildingPrice() %>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="buildingScale">건물규모:</label>
					<%=building.getBuildingScale() %>
				</div>
			</div>
			<%break;
		case Car:
			Car car = (Car) request.getAttribute("insurance");%>
			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="carNumber">차 번호:</label>
					<%= car.getCarNumber() %>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="carType">차 종류:</label>
					<%=car.getCarType() %>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="drivingCareer">운전경력:</label>
					<%=car.getDrivingCareer() %>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="licenseType">면허종류:</label>
					<%=car.getLicenseType() %>
				</div>
			</div>




			<%	break;
		case ActualCost:
			ActualCost actualCost = (ActualCost) request.getAttribute("insurance");%>
			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="diseaseHistory">병력:</label>
					<%=actualCost.getDiseaseHistory() %>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="familyHistory">가족병력:</label>
					<%=actualCost.getFamilyHistory() %>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-12">
					<label class="text-black" for="bloodType">혈액형:</label>
					<%=actualCost.getBloodType() %>
				</div>
			</div>
			<%break;
		}
	%>


			<div class="row form-group">
				<div class="col-md-12">
					<form
						action=AcceptInsuranceSubscription
						method="post">
						<input type="hidden" name="customerID" value=<%=customer.getCustomerID()%>>
						<input type="hidden" name="insuranceID" value=<%=insuranceID%>>
						<input type="submit" value="승인"
							class="btn btn-primary btn-md text-white" style="float: left;">
					</form>
					<form
						action=DeclineInsuranceSubscription
						method="post">
						<input type="hidden" name="customerID" value=<%=customer.getCustomerID()%>>
						<input type="hidden" name="insuranceID" value=<%=insuranceID%>>
						<input type="submit" value="거부"
							class="btn btn-primary btn-md text-white" style="float: left;">
					</form>
				</div>
			</div>

		</div>
		</c>
	</section>

	<jsp:include page="/incl/Footer.jsp" />
		<jsp:include page="/incl/staticFooter.jsp" />
</body>
</html>