<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet"	type="text/css">	
<link href="${path}/resources/css/user/uMyPage/myAskDetail.css" rel="stylesheet"	type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
			<div class="mcontent">
			<table class="asktbl">
				<tr>
					<th colspan="2">${myAskDetail.qnaCont }</th>
				</tr>
				<tr>
					<td>작성자: ${myAskDetail.qnaWr }</td>
					<td>작성일: ${myAskDetail.qnaDate }</td>
				</tr>
				<tr class="asktblImg">
					<c:choose>
						<c:when test="${myAskDetail.qnaImg eq null}">
							<td colspan="2"><img src="http://placehold.it/500x300"></td>
						</c:when>
						<c:otherwise>
							<td colspan="2"><img src="${path}/resources/uploadFile/myAsk/${myAskDetail.qnaImg}" class="myAskImg"></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
                <button id="myAskDelBtn" class="basicBtn" style="margin-right:20px;">삭제</button>
                <button class="basicBtn" style="margin-right:20px;">목록</button>
        <br><br><br><br>
        <table class="reponsetbl">
        	<tr>
        		<c:choose>
        			<c:when test="${maComment ne null}">
		        		<th>관리자</th>
        			</c:when>
        			<c:otherwise>
        				<th></th>
        			</c:otherwise>
        		</c:choose>
        		<td>${maComment.qnacDate}</td>
        	</tr>
        	<tr>
        		<td colspan="2">${maComment.qnacCont}</td>
        	</tr>
        </table>
		</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
		
		<!-- MODAL -->
		 <div id="my_modal">
		    <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
		    <div id="locCon">
		        <h1>삭제하시겠습니까?</h1>
		        <button id="goTOPay">바로 삭제할게요</button>
		        <button id="nextTime">다음에 할게요</button>
		        <input type="hidden" id="har_rnum">
		    </div>
		</div>
	</div>
	
	<script type="text/javascript" src="${path}/resources/js/user/uMyPage/myAskDetail.js"></script>
</body>
</html>