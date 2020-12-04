<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="com.example.demo.model.Contract.Contract"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import ="java.text.SimpleDateFormat"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<% request.setCharacterEncoding("UTF-8");
   String cp = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재계약 하기</title>
</head>
<script type="text/javascript" src="<%=cp%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=cp%>/js/numberOnly.js"></script>
<script type="text/javascript">

	function checkValue() {
	    if(!document.InsInfo.contractExpirationDate.value){
	        alert("계약 만료일을 입력하세요.");
	        return false;
	    }
	    if(!document.InsInfo.paymentDate.value){
	        alert("납입 날짜를 입력하세요.");
	        return false;
	    }
	    if(!document.InsInfo.paymentPeriod.value){
	        alert("납입 기간을 입력하세요.");
	        return false;
	    }
    }
</script>

<body>
	<jsp:include page="/incl/staticHeader.jsp" />
	<jsp:include page="/incl/Header.jsp" />

	<section class="site-section bg-light" id="contact-section">

		<div class="container">

			<div class="row mb-5">
				<div class="col-12 text-center">
					<h2 class="text-black h1 site-section-heading">재계약 진행하기</h2>
					<p class="lead">계약 정보 수정</p>
				</div>
			</div>

			<div>
				<form action= "RecontractFinish" method= POST class="p-5 bg-white" style = "margin:auto; max-width: 700px;" name = "InsInfo" onsubmit="return checkValue()">
	<h2 class="h4 text-black mb-5" align="center">계약 정보 수정</h2>
<% 
	   Contract contract = (Contract)request.getAttribute("contract"); 
	   Integer accountNumber = (Integer)request.getAttribute("accountNumber");
	   SimpleDateFormat format1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
	   SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");	   
	%>
				

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black">계약ID </label>
							<%=  contract.getContractID()%>
							<input type=hidden name="contractID"
								value=<%= contract.getContractID()%>>
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black">고객ID </label>
							<%=  contract.getCustomerID()%>
							<input type=hidden name="customerID"
								value=<%= contract.getCustomerID()%>>
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black">납입 날짜 </label> <input type="date"
								name="paymentDate" id="paymentDate" class="form-control">
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black">납입방식</label> <select name="paymentType"
								class="form-control">
								<option value="creditCard">신용카드</option>
								<option value="e_bancking">인터넷뱅킹</option>
								<option value="accountTransfer">계좌이체</option>
							</select>
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black">계약만료일</label> <input type=date
								name="contractExpirationDate" id="contractExpirationDate"
								class="form-control">
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-12">
							<label class="text-black">계좌번호</label> <input type="Number"
								name="accountNumber" placeholder=<%= accountNumber%>
								value=<%= accountNumber%> class="form-control">
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-12">
							<input type="submit" value="입력 완료"
								class="btn btn-primary btn-md text-white" onclick="check()"
								style="float: right;"> <input type="reset" value="다시 작성"
								class="btn btn-primary btn-md text-white">
						</div>
					</div>

				</form>
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