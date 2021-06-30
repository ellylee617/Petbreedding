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
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/admin/mAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/admin/aBoard/mboard.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../mheader.jsp" />
		<section class="section" id="mboardSection">
			<jsp:include page="../mAside.jsp"/>
			<div class="mContent">
		        <div class="conhead">
			       	<c:choose>
						<c:when test="${mAsk.qnaType eq 1}">
						<p>[회원]</p>
						</c:when>
						<c:otherwise>
						<p>[사업자]</p>
						</c:otherwise>
					</c:choose>
					<p>${mAsk.qnaCont}</p>
					<p>작성자 : ${mAsk.qnaWr}</p>
					<p>작성일 : ${mAsk.qnaDate}</p>
				</div>
				
				<div class="conimg">
					<c:choose>
						<c:when test="${mAsk.qnaImg eq null}">
						    <img src="http://placehold.it/400x300">
						</c:when>
						<c:otherwise>
							<img src="${path}/resources/uploadFile/myAsk/${mAsk.qnaImg}">
						</c:otherwise>
					</c:choose>
				</div>
				<div class="conbtn">
				    <button class="basicBtn" id="listBtn">목록</button>
				    <button class="basicBtn" id="delBtn">삭제</button>
				    <button class="basicBtn" id="updeteBtn">수정</button>
				    
				
				</div>
				<div id="replyArea" class="reply">
<!-- 				<div> -->
<!-- 					안녕하세요. 또비언니님<br><br>현재 확인해본 결과, 해당 카드사에서 발생한 문제로 확인되고 있습니다. -->
<!--         		<br>잠시 후 다시 결제 해보시고, 안되시면 고객센터(1577-0123)로 연락주시면 추가 안내해드리겠습니다.<br><br> -->
<!--         		감사합니다. -->
<!-- 				</div> -->
					<form id="maCommentFrm" class="maCommentFrm">
<!-- 					    <input type="text" name="maCommentText" id="replt"> -->
						<textarea id="maCommentText" name="maCommentText"></textarea>
					    <button class="basicBtn" id="maCommentBtn">등록</button>
						<input type="hidden" name="qna_num" value="${mAsk.qnaNum}">
					</form>				
				</div>
			</div>
		</section>
	<jsp:include page="../../common/footer.jsp" />
	</div>	 
<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
<script type="text/javascript" src="${path}/resources/js/admin/aBoard/mBoardCon.js"></script>
</body>
</html>