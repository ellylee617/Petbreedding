<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/bheader.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/footer.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/mypage/bAside.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/mypage/bMyPageAside.css"
	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/mypage/bFAQ.css" rel="stylesheet"
	type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<section class="section">
			<jsp:include page="../bheader.jsp" />
			<jsp:include page="bAside.jsp" />
			<jsp:include page="bMyPageAside.jsp" />
			<div class="bContent">
				<h1>자주 묻는 질문</h1>
				<div id="title1" class="title">
					<span id="down1" class="down"><i class="fas fa-angle-down"></i></span>
					<span id="up1" class="up" ><i class="fas fa-angle-up"></i></span>
					<br>
					결제가 안 됩니다. <br>
					<hr>
				</div>
				<div id="content1" class="content">
					<br>
					~~결제 방법 안내 ~~ 
					<br>
				</div>
					<div id="title2" class="title">
					<span id="down2" class="down"><i class="fas fa-angle-down"></i></span>
					<span id="up2" class="up" ><i class="fas fa-angle-up"></i></span>
					<br>
					예악 후 취소는 어떻게 하나요? <br>
					<hr>
				</div>
				<div id="content2" class="content">
					<br>
					예약 확정이 된 후에는 해당 업체와 연락 후 취소가 가능합니다.
				</div>
			</div>
		</section>
		<jsp:include page="../footer.jsp" />
	</div>
	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/mypage/bFAQ.js"></script>
</body>
</body>
</html>