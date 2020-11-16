<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="com.example.demo.model.Accident.Accident"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="EUC-KR">


<div class="row form-group">
	<div class="col-md-12">
		<label class="text-black" for="accidentID">사고ID:</label>
		${accident.accidentID}
	</div>
</div>

<div class="row form-group">
	<div class="col-md-12">
		<label class="text-black" for="customerID">고객ID:</label>
		${accident.customerID}
	</div>
</div>

<div class="row form-group">
	<div class="col-md-12">
		<label class="text-black" for="insuranceID">보험ID:</label>
		${accident.insuranceID}
	</div>
</div>

<div class="row form-group">
	<div class="col-md-12">
		<label class="text-black" for="accidentDate">사고날짜:</label>
		${accident.accidentDate}
	</div>
</div>

<div class="row form-group">
	<div class="col-md-12">
		<label class="text-black" for="accidentTime">사고시간:</label>
		${accident.accidentTime}
	</div>
</div>



<div class="row form-group">
	<div class="col-md-12">
		<label class="text-black" for="accidentCause">사고원인:</label>
		${accident.accidentCause}
	</div>
</div>

<div class="row form-group">
	<div class="col-md-12">
		<label class="text-black" for="accidentLocation">사고장소:</label>
		${accident.accidentLocation}
	</div>
</div>

<div class="row form-group">
	<div class="col-md-12">
		<label class="text-black" for="expertOpinion">전문가 소견서:</label>
		${accident.expertOpinion}
	</div>
</div>