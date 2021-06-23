<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<header class="Uheader">
    <nav class="UserNav">
        <ul>
        	<c:if test = "${!empty client }">
	            <li class="alertBell"><a href="#"><i class="fas fa-bell"></i><span class="alertCircle"></span></a></li>
	            <li id="userName"><a href="${pageContext.request.contextPath}/uModify">${client.nickname}님</a></li>
	            <li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
            </c:if>
<%--             <c:if test = "${!empty kakaoEmail }">
	            <li class="alertBell"><a href="#"><i class="fas fa-bell"></i><span class="alertCircle"></span></a></li>
	            <li id="userName"><a href="#">${nickname}님</a></li>
	            <li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
            </c:if> --%>
            <c:if test = "${empty client }">
	            <li><a href="${pageContext.request.contextPath}/uLogin">로그인</a></li>
	            <li><a href="${pageContext.request.contextPath}/uJoin">회원가입</a></li>
            </c:if>
            <li><a href="${pageContext.request.contextPath}/mypage?cl_num=${client.cl_num}">예약확인/조회</a></li>
            <li><a href="#">고객센터</a></li>
        </ul>
    </nav>  
    <div class="mainMenu">   
        <a href="/petbreedding"><img class="logo" src="${pageContext.request.contextPath}/resources/images/logo.png" ></a>            
        <nav class="mainMenu1">
			<ul>
                <li><a href="#">소개</a></li>
                <li><a href="${pageContext.request.contextPath}/shopList?shoptype=hos">동물병원</a></li>
                <li><a href="${pageContext.request.contextPath}/shopList?shoptype=hair">미용실</a></li>
                <li><a href="consult.html">1:1수의사 상담</a></li>
            </ul>
        </nav>
        <nav class="mainMenu2">
            <ul>
                <li><a href="fboardlist">자유게시판</a></li>
                <li><a href="/petbreedding/bIndex">제휴문의</a></li>
            </ul>
        </nav>
    </div>
    
    
</header> 