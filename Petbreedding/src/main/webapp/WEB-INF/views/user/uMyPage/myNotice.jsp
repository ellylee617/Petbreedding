<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uMyPage/myNotice.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
			<div class="mcontent">
			<div class="noticewrap">
				<div class="topWrap">
				<div class="clockWrap"><i class="far fa-clock"></i></div><div class="dateWrap">2021-07-06</div>
				</div>
				<div class="conWrap">
					<div class="imgWrap">
					<img src="${path}/resources/images/logo.png">
					</div>
					<div class="shopNameWrap">쿨펫 동물 병원</div><div class="msgWrap">예약이 확정되었습니다.</div>
					<a class="cancleM"><i class="far fa-times-circle"></i></a>
				</div>
			</div>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>