<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uMyPage/myzzim.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../../common/header.jsp" />
	 <section class="section">
	 <jsp:include page="../myPageAside.jsp"/>
	 	<div class="myzzimhead">
        <h1>찜 목록</h1>
        <div class="zzimlist">
            <div class="subdiv">
                <div class="img"><a href="#"><img src="http://placehold.it/200x100"></a></div>
                <div class="title">
                <a href="boardcontent.html">
                <h1>플펫 동물병원</h1>
                <h3>슬개골 탈구 수술, 중성화 수술, 건강검진, 스케일링 등...최신장비 보유</h3> </a></div>
                </div>
                <div class="zzimdel">
                    <button id="zzimdelBtn" class="basicBtn">찜 해제</button>

                </div>
                
            </div>
        </div>
        <div class="myzzimrow">
            <button class="basicBtn" id="moreBtn">
                더보기
            </button>

        </div>
	 </section>
	<jsp:include page="../../common/footer.jsp" />
	</div>