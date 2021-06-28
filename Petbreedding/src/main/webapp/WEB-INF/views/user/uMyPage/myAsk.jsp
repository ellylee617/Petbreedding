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
<link href="${path}/resources/css/user/myPageAside.css"	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uMyPage/myAsk.css" rel="stylesheet"	type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js"	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		var userNum = ${user_num};
		$(".pointline").click(function() {
			var idVar = $(this).attr("id");
			console.log(idVar);
			goDetail(idVar);
		});
		
		$("#myAskBtn").click(function() {
			location.href = "/petbreedding/bwrite";
		});
		
		function goDetail(value){
			console.log(value);
			location.href = "/petbreedding//mypage/askdetail?qna_num="+value+"";
		}
	});
</script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
			<div class="mcontent">
				<p class="pageTitle">1:1 문의 내역 <p>
					<button id="myAskBtn" class="basicBtn">1:1문의하기</button>
					<table class="asktable">
					<br><br><br>
					<tr class="pointline">
						<th>글번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>답변여부 </th>
					</tr>
					
					<c:forEach items="${myAskList}" var="list">
					<tr id="${list.qnaNum}" class="pointline">
						<td>${list.qnaNum}</td>
						<td>${list.qnaTitle}</td>
						<td>${list.qnaDate}</td>
						<c:choose>
							<c:when test="${list.qnaChk eq 0}">
								<td>N</td>
							</c:when>
							<c:otherwise>
								<td>Y</td>
							</c:otherwise>					
						</c:choose>
					</tr>
					</c:forEach>

				</table>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
</body>
</html>