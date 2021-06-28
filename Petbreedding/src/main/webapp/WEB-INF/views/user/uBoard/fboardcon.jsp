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
<link href="${path}/resources/css/user/uBoard/fboardcont.css" rel="stylesheet" type="text/css">

<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<div class="bheader">

				<c:if test="${empty board}">
					<h1>정보를 찾을 수 없습니다.</h1>
				</c:if>


					<div class="title">
						<p>${board.boTitle}</p>
					</div>												
					<!-- TODO 세션 받아와서 이름 입력 -->
					<div class="writer">작성자 : ${board.clNickName}</div>
					<div class="regdate">작성일 : ${board.boDate}</div>
					<div class="count">조회수: ${board.boView}</div>
					
			</div>


			<div class="bcon">
				
				<div class="img">
				
					<!-- TODO db에 있는 이미지 입력 -->
					<c:choose>
						<c:when test="${board.boImg eq null}">
							<img src="http://placehold.it/500x300" alt="boardconimg">
						</c:when>
						<c:otherwise>
							<img src="${path}/resources/uploadFile/review/${board.boImg}" alt="boardconimg">
						</c:otherwise>
					</c:choose>
				</div>
				
			
				<div class="con">
				
					<p>${board.boCont }</p>

					<button class="backbtn basicBtn" onClick="location.href='fboardlist'">목록</button>
					<button id="fboardUpdBtn" class="modifybtn basicBtn">수정</button>
					<button id="fboardDelBtn" class="delbtn basicBtn">삭제</button>
				
				</div>
			</div>
			<div class="reply">
				<p>댓글(10)</p>
				<form action="#" method="#">
					<div class="replycon">

						<input type="text"> <input type="submit" id="submitbtn"
							class="basicBtn" value="등록">
					</div>
				</form>
				<!--AJAX로 댓글 구현 -->
			</div>

		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
</body>
</html>