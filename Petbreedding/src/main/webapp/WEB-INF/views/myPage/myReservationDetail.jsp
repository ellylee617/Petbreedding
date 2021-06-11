<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/header.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/footer.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/mypage/myPageAside.css"
	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/mypage/myReservationDetail.css"
	rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../header.jsp" />
		<section class="section">
			<jsp:include page="myPageAside.jsp" />
			<div class="mcontent">
			<div class="rborder r1 rOrderTitle">
                    <i class="far fa-check-circle"></i>&nbsp;결제 대기
                </div>
                <div class="rborder">
                    <span id="rOrderNum">주문번호 202106101234</span>
                    <br><br>
                    <span class="rOrderTitle">쿨펫미용실</span>
                    <br><br>
                    <table>
                        <tr>
                            <td>일정</td>
                            <td>2021-06-10 목요일 오후 4:30</td>
                        </tr>
                        <tr>
                            <td>내역</td>
                            <td>가위컷(+)디자인컷</td>
                        </tr>
                    </table>
                    <br><br>
                    <div class="buttons">
                    <button type="button" class="basicBtn" id="1and1">1:1문의</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" class="basicBtn" id="pay">결제하기</button>
                    </div>
                </div>
                <div class="rborder">
                    <span class="rOrderTitle">예약자 정보</span>
                    <br><br>
                    <table>
                        <tr>
                            <td>예약자명</td>
                            <td>곽서현</td>
                        </tr>
                        <tr>
                            <td>연락처</td>
                            <td>010-1234-5678</td>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td>email@email.com</td>
                        </tr>
                    </table>
                </div>
                <div class="rborder">
                    <span class="rOrderTitle">반려견 정보</span>
                    <br><br>
                    <table>
                        <tr>
                            <td>이름</td>
                            <td>또비</td>
                        </tr>
                        <tr>
                            <td>나이</td>
                            <td>7살</td>
                        </tr>
                        <tr>
                            <td>몸무게</td>
                            <td>5.5kg</td>
                        </tr>
                    </table>
                </div>
                <div class="rborder">
                    <span class="rOrderTitle">결제 금액</span>
                    <span id="rOrderAmount">40,000원</span>
                </div>
                <div class="rborder dmap">
                    <p class="rOrderTitle">오시는 길</p>
                    <br>
                    <div class="map">지도공간~!</div>
                    <div class="rText">
                        <p class="rTextBold">업체명</p>
                        <p>쿨펫미용실</p>
                        <p class="rTextBold">주소</p>
                        <p>경기도 고양시 고양시 고양빌라 101호</p>
                        <p class="rTextBold">전화번호</p>
                        <p>031-123-1234</p>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="../footer.jsp"/>
    </div>
</body>
</html>