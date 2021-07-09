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

					
					<div class="title">${board.boTitle}</div>
							
					<div class="writer">작성자 : ${board.clNickName}</div>
					<div class="regdate">작성일 : ${board.boDate}</div>
					<div class="count">조회수: ${board.boView}</div>
					
			</div>


			<div class="bcon">
				<div class="con">${board.boCont}</div>
				
				<button class="backbtn basicBtn" onClick="location.href='fboardlist'">목록</button>
				<button id="fboardDelBtn" class="delbtn basicBtn">삭제</button>
				<button id="fboardUpdBtn" class="modifybtn basicBtn">수정</button>
				<input type="hidden" id="boUpdBoNum" value="${board.boNum}">
				<input type="hidden" id="boUpdBoTitle" value="${board.boTitle}">
				
			</div>
			<div class="reply">
				<p>댓글(${board.bocChk})</p>
				
				<form id="bocFrm">
					<div class="replycon">
						<input type="text" id="replyCont" name="getBocCont">
						<input type="button" id="bocSubmitBtn" class="basicBtn" value="등록">
						<input type="button" id="bocUpdateBtn" class="basicBtn" value="수정">
						<input type="hidden" value="${board.boNum}" name="getBoNum">
					</div>
				</form>
				
				<div id="replyContainer"></div>
				
				
			</div>

		</section>
		<jsp:include page="../../common/footer.jsp" />
		
		<!-- MODAL POSTING -->
		 <div id="my_modal">
		    <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
		    <div id="locCon">
		        <h1>삭제하시겠습니까?</h1>
		        <button id="goTODel" name="${board.boNum}">바로 삭제할게요</button>
		        <button id="nextTime">다음에 할게요</button>
		    </div>
		</div>
		
		
		<!-- MODAL COMMENT -->
		<div id="my_modal_comment">
		   <a class="modal_close_btn" id="closeModalBtn"><i class="fas fa-times" id="closeBtnComment"></i></a>
		   <div id="locCon_comment">
		       <h1>삭제하시겠습니까?</h1>
		       <button id="goTOPay_comment">바로 삭제할게요</button>
		        <button id="nextTime_comment">다음에 할게요</button>
		        <input type="hidden" id="coIdVar">
		    </div>
		</div>
		
		<!-- MODAL COMMENT UPDATE -->
		<div id="my_modal_updComment">
			<a class="modal_close_btn" id="closeModalBtn"><i class="fas fa-times" id="closeBtnUpdComment"></i></a>
			<div id="locCon_updComment">
				<h1 class="bocUpdTitle">댓글 수정</h1>
				<input type="text" id="replyUpdCont" name="getBocCont">
				<button id="goTOPay_updComment">수정</button>
				<button id="nextTime_updComment">취소</button>
				<input type="hidden" id="coIdVar">
		    </div>
		</div>

	</div>
	
	<script type="text/javascript" src="${path}/resources/js/user/uBoard/fComment.js"></script>
	<script type="text/javascript" src="${path}/resources/js/user/uBoard/fboardcon.js"></script>
</body>
</html>