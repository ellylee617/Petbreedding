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
<link href="${path}/resources/css/board/mypet.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../header.jsp" />
	 <section class="section">
	  <div class="pethead">
            <h1>반려동물 정보</h1>
            <img src="http://placehold.it/250x150"/>
            <div class="petname"><a href="petdetail">또비</a></div>
            <div class="btnwrap">
            <button class="btn basicBtn"><a href="#">수정</a></button>
            <button class="btn basicBtn"><a href="#">삭제</a></button>
        </div>
        </div>
        <div class="petrow">
                <a href="#"><i id="plus" class="fas fa-plus-circle"></i>
                <p class="plusp">새 동물 등록</p></a>
            </button>
        </div> 
	 </section>
	<jsp:include page="../footer.jsp" />
	</div>