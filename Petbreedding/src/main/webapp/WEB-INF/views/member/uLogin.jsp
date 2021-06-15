<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petverything::펫브리띵</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/member/uLogin.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

    <div class="wrapper">
		<jsp:include page="../header.jsp" />

        <section class="section">
      		<img class="IDlogo" src="${pageContext.request.contextPath}/resources/images/logo.png">      
             <form  id="loginFrm" class="loginFrm">
             	<div class="loginBox">
	                 <label>아이디</label>
	                 <input type="text" id="bId" class="inputArea" placeholder="아이디를 입력해주세요">
	                 <label>비밀번호</label>
	                 <input type="password" id="bPwd" class="inputArea"  placeholder="비밀번호를 입력해주세요">
	                 <input type="submit" class="basicBtn" id="loginBtn" value="로그인" src="#">
	                 <p class="txt_or">또는</p>
	                <button class="snsLogin" type="button">
	                    <img src="${path}/resources/images/KakaoTalk_login.png" alt="img" />
	                </button>
	                <button class="snsLogin naverLogin" type="button">
	                    <a><img src="${path}/resources/images/naver_login.png" alt="img" /></a>
	                </button>
	                <div class="searchIdPw_container">
	                    <p id="searchIdPw" class="joLoText">아이디/비밀번호 찾기</p>
	                    <p id="join" class="joLoText"><a href="join" >회원가입</a></p>
	                </div>
                 </div> 
             </form>
            
        </section>
		<jsp:include page="../footer.jsp" />
		
		
		<!--MODAL-->
        <div id="modal" class="searchModal_Container">
            <div class="searchModal_box">
                <div class="searchModal_content">
                    <div class="tabmenu">
                        <ul>
                            <li id="tab1" class="btnCon">
                                <input type="radio" name="tabmenu" checked id="tabmenu1" class="Tmenu">
                                <label for="tabmenu1">아이디 찾기</label>
                                 <div class="tabCon">
                                     <input type="text" class="tabInput" placeholder="이름을 입력해주세요.">
                                     <p></p>
                                     <input type="text" class="tabInput" placeholder="등록하신 핸드폰 번호를 입력해주세요.">
                                     <button class="searchB basicBtn">찾기</button>
                                 </div>
                             </li>
                            <li id="tab2" class="btnCon">
                                <input type="radio" name="tabmenu" id="tabmenu2"  class="Tmenu">
                                <label for="tabmenu2">비밀번호 찾기</label>
                                <div class="tabCon">
                                    <input type="text" class="tabInput" placeholder="이메일을 입력해주세요.">
                                    <p></p>
                                    <input type="text" class="tabInput" placeholder="등록하신 핸드폰 번호를 입력해주세요.">
                                    <button class="searchB basicBtn">찾기</button>
                                </div> 
                             </li>
                        </ul>
                    </div>
                </div>
                <i class="fas fa-times fa-lg" id="modalExit"></i>
            </div>
        </div>
    </div>
	
	<!-- 자바스크립트 -->
	<script type="text/javascript" src="${path}/resources/js/member/login.js"></script>
	<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</body>
</html>