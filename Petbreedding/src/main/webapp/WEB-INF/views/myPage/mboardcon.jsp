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
<link href="${path}/resources/css/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/mypage/mAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/mypage/mboard.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../bheader.jsp" />
	 <section class="section">
	 <jsp:include page="../myPage/mAside.jsp"/>
	   <div class="mContent">
    
            <div class="conhead">
                <p>[회원]</p>
                <p>결제 문의 드립니다</p>
                <p>작성자 : 또비언니</p>
                <p>작성일 : 2021-06-15</p>
            </div>
            <div class="conimg">
                <img src="http://placehold.it/400x300">
            </div>
            <div class="conbtn">
                <button class="basicBtn" id="listBtn">목록</button>
                <button class="basicBtn" id="updeteBtn">수정</button>
                <button class="basicBtn" id="delBtn">삭제</button>

            </div>
            <div class="reply">
                <input type="text" name="#" id="replt">
                <button class="basicBtn" id="submitbtn">등록</button>
            </div>
        
</div>
	   </section>
	<jsp:include page="../footer.jsp" />
	</div>	 
<script type="text/javascript" src="${path}/resources/js/mypage/mAside.js"></script>
	</body>
	</html>