<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uMyPage/mypet.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../../common/header.jsp" />
	 <section class="section">
	 <jsp:include page="../myPageAside.jsp"/>
	  <div class="pethead">
	  <c:forEach var="list" items="${list}">
            <h1>반려동물 정보</h1>
            <img src="${path}/resources/uploadFile/mypet/${list.pet_img}" width="250" height="150"/>
            <div class="petname"><a href="petdetail">${list.pet_name}</a></div>
            <div class="btnwrap">
            <button class="btn basicBtn"><a href="#">수정</a></button>
            <button class="btn basicBtn"><a href="#">삭제</a></button>
        </div>
        </c:forEach>
        </div>
        <div class="petrow">
                <a href="openMyPet"><i id="plus" class="fas fa-plus-circle"></i>
                <p class="plusp">새 동물 등록</p></a>
            </button>
        </div> 
	 </section>
	<jsp:include page="../../common/footer.jsp" />
	</div>