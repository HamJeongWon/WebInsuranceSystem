<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.demo.model.Acceptance.AcceptanceGuide"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인수지침서 리스트</title>

<jsp:include page="/incl/tableCSS.jsp" />
<jsp:include page="/incl/staticHeader.jsp" />
</head>

<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">

	<div class="site-wrap">

		<jsp:include page="/incl/Header.jsp" />

		<%Vector<AcceptanceGuide> fireGuides, carGuides, actualCostGuides;
					fireGuides = (Vector<AcceptanceGuide>)request.getAttribute("fireGuide");
					carGuides = (Vector<AcceptanceGuide>)request.getAttribute("carGuide");
					actualCostGuides = (Vector<AcceptanceGuide>)request.getAttribute("actualCostGuide"); %>

		<svg class="hidden">
				<defs>
					<path id="tabshape" d="M80,60C34,53.5,64.417,0,0,0v60H80z" />
				</defs>
			</svg>

		<section class="site-section bg-light" id="contact-section"
			style="padding-top: 200px;">

			<div class="container">
				<div class="row mb-5">
					<div class="col-12 text-center">
						<h2 class="text-black h1 site-section-heading">인수지침서 리스트</h2>
						<p class="lead">보험사에 존재하는 인수지침서들의 리스트이다.</p>
					</div>
				</div>
			</div>

			<div class="tabs tabs-style-shape">
				<nav>
					<ul>
						<li><a href="#section-shape-1"> <svg viewBox="0 0 80 60"
									preserveAspectRatio="none">
									<use xlink:href="#tabshape"></use></svg> <span>화재보험 인수지침서</span>
						</a></li>
						<li><a href="#section-shape-2"> <svg viewBox="0 0 80 60"
									preserveAspectRatio="none">
									<use xlink:href="#tabshape"></use></svg> <svg viewBox="0 0 80 60"
									preserveAspectRatio="none">
									<use xlink:href="#tabshape"></use></svg> <span>자동차보험 인수지침서</span>
						</a></li>
						<li><a href="#section-shape-3"> <svg viewBox="0 0 80 60"
									preserveAspectRatio="none">
									<use xlink:href="#tabshape"></use></svg> <svg viewBox="0 0 80 60"
									preserveAspectRatio="none">
									<use xlink:href="#tabshape"></use></svg> <span>실비보험 인수지침서</span>
						</a></li>
					</ul>
				</nav>
				<div class="content-wrap">
					<section id="section-shape-1">
						<div class="container">
							<ul class="responsive-table">
								<li class="table-header">
									<div class="col col-1">인수 ID</div>
									<div class="col col-2">보험 ID</div>
									<div class="col col-3">상세 정보 보기</div>
								</li>
								<%
									if (!fireGuides.isEmpty()) {
									for (AcceptanceGuide fireGuide : fireGuides) {
								%>
								<li class="table-row">
									<div class="col col-1" style="margin-top: 9px;">
										<%=fireGuide.getAcceptanceID()%>
									</div>
									<div class="col col-2" style="margin-top: 9px;">
										<%=fireGuide.getInsuranceID()%>
									</div>
									<div class="col col-3">
										<form action=./ResultAcceptanceGuide?action=<%=fireGuide.getAcceptanceID()%> method="post">
											<input type="submit" value="정보보기"
												class="btn btn-primary btn-md text-white">
										</form>
									</div>
								</li>
								<%
									}
								%>
							</ul>
							<%
								} else {
							%>
							인수지침서가 존재하지 않습니다.
							<%
								}
							%>
						</div>
					</section>
					<section id="section-shape-2">
						<div class="container">
							<ul class="responsive-table">
								<li class="table-header">
									<div class="col col-1">인수 ID</div>
									<div class="col col-2">보험 ID</div>
									<div class="col col-3">상세 정보 보기</div>
								</li>
								<%
									if (!fireGuides.isEmpty()) {
									for (AcceptanceGuide carGuide : carGuides) {
								%>
								<li class="table-row">
									<div class="col col-1" style="margin-top: 9px;">
										<%=carGuide.getAcceptanceID()%>
									</div>
									<div class="col col-2" style="margin-top: 9px;">
										<%=carGuide.getInsuranceID()%>
									</div>
									<div class="col col-3">
										<form action=./ResultAcceptanceGuide?action=<%=carGuide.getAcceptanceID()%> method="post">
											<input type="submit" value="정보보기"
												class="btn btn-primary btn-md text-white">
										</form>
									</div>
								</li>
								<%
									}
								%>
							</ul>
							<%
								} else {
							%>
							인수지침서가 존재하지 않습니다.
							<%
								}
							%>
						</div>
					</section>
					<section id="section-shape-3">
						<div class="container">
							<ul class="responsive-table">
								<li class="table-header">
									<div class="col col-1">인수 ID</div>
									<div class="col col-2">보험 ID</div>
									<div class="col col-3">상세 정보 보기</div>
								</li>
								<%
									if (!fireGuides.isEmpty()) {
									for (AcceptanceGuide actualCostGuide : actualCostGuides) {
								%>
								<li class="table-row">
									<div class="col col-1" style="margin-top: 9px;">
										<%=actualCostGuide.getAcceptanceID()%>
									</div>
									<div class="col col-2" style="margin-top: 9px;">
										<%=actualCostGuide.getInsuranceID()%>
									</div>
									<div class="col col-3">
										<form action=./ResultAcceptanceGuide?action=<%=actualCostGuide.getAcceptanceID()%> method="post">
											<input type="submit" value="정보보기"
												class="btn btn-primary btn-md text-white">
										</form>
									</div>
								</li>
								<%
									}
								%>
							</ul>
							<%
								} else {
							%>
							인수지침서가 존재하지 않습니다.
							<%
								}
							%>
						</div>
					</section>
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

		<script src="js/cbpFWTabs.js"></script>
		<script>
				(function() {
	
					[].slice.call( document.querySelectorAll( '.tabs' ) ).forEach( function( el ) {
						new CBPFWTabs( el );
					});
	
				})();
			</script>

		<jsp:include page="/incl/Footer.jsp" />

	</div>
	<!-- .site-wrap -->

	<jsp:include page="/incl/staticFooter.jsp" />

</body>
</html>