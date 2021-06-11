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
<link href="${path}/resources/css/myPage/myPageAside.css"
	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/myPage/point.css"
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
			<div class="point">
                    <p class="ptitle">보유포인트</p>
                    <br>
                    <p class="presult">1000P</p>
                </div>
                <br>
                <div class="selectOpt">
                    <input type="radio" checked id="popular" name="selectOpt"><label for="popular">최근 3개월</label>
                    <input type="radio" id="distance" name="selectOpt"><label for="distance">최근 6개월</label>
                    <input type="radio" id="rating" name="selectOpt"><label for="rating">최근 1년</label>
                </div>
                <div class="timetblP">
                    <span>기간별 조회</span>&nbsp;&nbsp;&nbsp;
                    <span><input type="date">&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;<input type="date"></span>
                    <span>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="basicBtn">조회하기</button></span>
                </div>
                <br><br><br><br>
                <table class="pointtable">
                    <tr class="pointline">
                        <td class="pgreen"><div class="circleg">적립</div></td>
                        <td>2021-06-10</td>
                        <td>쿨펫 미용실</td>
                        <td class="pgreen">+5300p</td>
                    </tr>
                    <tr></tr>
                    <tr class="pointline">
                        <td class="pred"><div class="circlep">사용</div></td>
                        <td>2021-06-10</td>
                        <td>쿨펫 미용실</td>
                        <td class="pred">-5300p</td>
                    </tr>
                    <tr class="pointline">
                        <td class="pgreen"><div class="circleg">적립</div></td>
                        <td>2021-06-10</td>
                        <td>쿨펫 미용실</td>
                        <td class="pgreen">+5300p</td>
                    </tr>
                    <tr class="pointline">
                        <td class="pred"><div class="circlep">사용</div></td>
                        <td>2021-06-10</td>
                        <td>쿨펫 미용실</td>
                        <td class="pred">-5300p</td>
                    </tr>
                </table>
                <div class="divmore">
                <button class="btnmore">더보기</button>
                </div>
            </div>
        </section>
        <jsp:include page="../footer.jsp"/>
    </div>
</body>
</html>