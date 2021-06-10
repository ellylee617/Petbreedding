<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/board/fboardcont.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
<div class="wrapper">    
  <jsp:include page="../header.jsp" />
	<section class="section">
	 <div class="bheader">
            <div class="title"><p>강아지도 살찌면 뒷목살이 접히나요?</p></div>
             <div class="writer">작성자 : 또비언니 </div>
             <div class="regdate">작성일 : 2021-06-08 </div>
             <div class="count"> 조회수: 22 </div>
        </div>
        <div class="bcon">
            <div class="img"><img src="http://placehold.it/500x300" alt="boardconimg"></div>
            <div class="con">
                <p>
                    저희 집 강아지가 좀 과체중이긴 한데,,,
                    강아지들도 뒷목살이 접히나요?ㅠㅠ

                </p>

                <button class="backbtn">목록</button>
                <button class="modifybtn">수정</button>
                <button class="delbtn">삭제</button>
            </div>
        </div>
        <div class="reply">
            <p>댓글(10)</p>
                <form action="#" method="#"> 
                    <div class="replycon">
               
                 <input type="text" >
                <input type="submit" id="submitbtn" value="등록"> 
                    </div>    
            </form>
                <!--AJAX로 댓글 구현 -->
            </div>
      
	</section>
        <jsp:include page="../footer.jsp" />
    </div>
</body>
</html>