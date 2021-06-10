<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/board/service.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="${path}/resources/js/board/service.js"></script>
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../header.jsp" />
		<section class="section">
		 <div class="service">
        <div class="serviceTitle">
            <div class="inside">
            <h2>고객센터</h2>
            <h1>CUSTOMER</h1>
            <h1>SERVICE</h1>
            <H1>CENTER</H1>

            </div>
        </div>
        <div class="serviceNav">
            <div class="inside">
                <a href="UcustomerService.jsp"><p>공지사항</p></a>
                <a href="oftenqna"><p>자주묻는질문</p></a>
                <a href="bwrite"><p>1:1 문의 작성</p></a>
                </div>
        </div>
        </div>
        <div class="serviceMain">
            <h1>서비스 공지사항</h1>
            <hr>
            <div id="Accordion_wrap">
                
                <!--for문으로 나중에 기능 구현하고 돌리기-->
                <div class="que">
                 <span>[발표] 5월 5주차 무료 초대권 당첨자 발표</span>
                </div>
                <div class="anw">
                 <span>
                    <p>2021-05-28</p>
                    <p>
                        안녕하세요, 펫브리띵 팀입니다.<br><br>
                        금주 무료 초대권 당첨자를 발표 합니다.<br>
                        
                        김x지(12****)

                    </p>

                 </span>
                </div>
                 
           </div>
        </div>
		</section>
		<jsp:include page="../footer.jsp" />
	</div>