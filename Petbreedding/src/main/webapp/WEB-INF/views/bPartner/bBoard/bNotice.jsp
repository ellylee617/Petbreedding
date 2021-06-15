<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/bPartner/bMyPageAside.css"
	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bBoard/bNotice.css" rel="stylesheet"
	type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<section class="section">
			<jsp:include page="../bheader.jsp" />
			<jsp:include page="../bAside.jsp" />
			<jsp:include page="../bMyPageAside.jsp" />
			<div class="bContent">
				<h1>공지사항</h1>
				<div id="title1" class="title">
					<span id="down1" class="down"><i class="fas fa-angle-down"></i></span>
					<span id="up1" class="up" ><i class="fas fa-angle-up"></i></span>
					<br>
					[안내] 개인정보 처리방침 일부 변경에 관한 안내 <br>
					<br> 2021-06-04
					<hr>
				</div>
				<div id="content1" class="content">
					<br>
					안녕하세요,사장님 효성에프엠에스, 씨티은행 시스템 작업으로 인해 일정 시간동안 결제 관련 서비스 이용이 제한될 예정으로
					안내드립니다. <br>
					<br>
					<br> ■ 효성에프엠스 결제 시스템 점검 <br> - 작업일시 <br> 2021년 6월 5일
					(토) 오전 0시~오전 0시 10분 (약 10분) <br> 2021년 6월 6일 (일) 오전 0시~오전 0시
					10분 (약 10분) <br> - 작업내용: 효성 에프엠에스 정기점검 <br>
					<br> 관련 궁금한 사항은 고객센터 (1577-0123)으로 문의 바랍니다. <br> 감사합니다. <br>
					<br> 펫브리띵 드림
				</div>
					<div id="title2" class="title">
					<span id="down2" class="down"><i class="fas fa-angle-down"></i></span>
					<span id="up2" class="up" ><i class="fas fa-angle-up"></i></span>
					<br>
					[점검] 효성에프엠에스, 씨티은행 결제 시스템 점검 (6월 5일(토) ~ 6월 6일 (일)) <br>
					<br> 2021-06-04
					<hr>
				</div>
				<div id="content2" class="content">
					<br>
					안녕하세요,사장님 효성에프엠에스, 씨티은행 시스템 작업으로 인해 일정 시간동안 결제 관련 서비스 이용이 제한될 예정으로
					안내드립니다. <br>
					<br>
					<br> ■ 효성에프엠스 결제 시스템 점검 <br> - 작업일시 <br> 2021년 6월 5일
					(토) 오전 0시~오전 0시 10분 (약 10분) <br> 2021년 6월 6일 (일) 오전 0시~오전 0시
					10분 (약 10분) <br> - 작업내용: 효성 에프엠에스 정기점검 <br>
					<br> 관련 궁금한 사항은 고객센터 (1577-0123)으로 문의 바랍니다. <br> 감사합니다. <br>
					<br> 펫브리띵 드림
				</div>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/bBoard/bNotice.js"></script>
</body>
</html>