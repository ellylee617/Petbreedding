<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bMember/bLogin.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
        <section class="section">
            <div class="loginBox">
                <img class="IDlogo" src="${pageContext.request.contextPath}/resources/images/logo.png">
                <form class="blFrm">
                    <label>아이디</label>
                    <input type="text" id="bId" class="inputArea" placeholder="아이디를 입력해주세요" name="bp_email">
                    <label>비밀번호</label>
                    <input type="password" id="bPwd" class="inputArea"  placeholder="비밀번호를 입력해주세요" name="bp_pwd">
                    <div id="errorText"></div>
                    <input type="button" class="basicBtn" id="loginBtn" value="로그인">
		<span id="searchIdPw">아이디/비밀번호 찾기</span>
                </form>
            </div>
        </section>
		<jsp:include page="../../common/footer.jsp" />
		
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
	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/bPartner/bMember/bLogin.js"></script>
</body>
</html>