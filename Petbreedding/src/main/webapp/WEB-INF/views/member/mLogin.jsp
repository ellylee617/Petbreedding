<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 관리자</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/member/mLogin.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
        <section class="section">
            <div class="loginBox">
                <img class="IDlogo" src="${pageContext.request.contextPath}/resources/images/logo.png">
                <form>
                    <label>아이디</label>
                    <input type="text" id="bId" class="inputArea" placeholder="아이디를 입력해주세요">
                    <label>비밀번호</label>
                    <input type="password" id="bPwd" class="inputArea"  placeholder="비밀번호를 입력해주세요">
                    <input type="submit" class="basicBtn" id="loginBtn" value="로그인" src="#">
                </form>
            </div>
        </section>
		<jsp:include page="../footer.jsp" />	
</div>

</body>
</html>