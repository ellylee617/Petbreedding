<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::로그인</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/member/login.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

    <div class="wrapper">
		<jsp:include page="../header.jsp" />
        <div id="modal" class="searchModal_Container">
            <div class="searchModal_box">
                <div class="searchModal_content">
                    <div class="col-sm-12">
                        <div class="searchModal_content">
                            <div class="col-sm-12">
                                <ul class="searchUl">
                                    <li class="searchLi">아이디 찾기</li>
                                    <li class="searchLi searchLiR">비밀번호 찾기</li>
                                </ul>
                            </div>
                            <form action="">

                                <div class="searchBtn_container">
                                    <input type="text" class="model_idPwBar" placeholder="이메일을 입력해주세요">
                                    <input type="text" class="model_idPwBar" placeholder="등록하신 핸드폰 번호를 입력해주세요">
                                    <button type="button" id="searchBtn" class="basicBtn">찾기</button>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
                <i class="fas fa-times fa-lg" id="modalExit"></i>
            </div>
        </div>

        <section class="section">
            <form id="loginFrm" class="loginFrm">
                <input type="text" placeholder="아이디" class="basicTextInput idPwBar">
                <input type="text" placeholder="비밀번호" class="basicTextInput idPwBar">
                <button id="nomalLogin" class="basicBtn" type="button">로그인</button>
                <p class="txt_or">또는</p>
                <button class="snsLogin" type="button">
                    <img src="${path}/resources/images/KakaoTalk_login.png" alt="img" />
                </button>
                <button class="snsLogin naverLogin" type="button">
                    <img src="${path}/resources/images/naver_login.png" alt="img" />
                </button>
                <div class="searchIdPw_container">
                    <p id="searchIdPw" class="joLoText">아이디/비밀번호 찾기</p>
                    <a href="join" id="join" class="joLoText">회원가입</a>
                </div>
            </form>
        </section>
		<jsp:include page="../footer.jsp" />
    </div>
	
	<!-- 자바스크립트 -->
	<script type="text/javascript" src="${path}/resources/js/member/login.js"></script>
	<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</body>
</html>