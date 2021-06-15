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
<link href="${path}/resources/css/user/uMypage/myAsk.css" rel="stylesheet"	type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js"	crossorigin="anonymous"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
			<div class="mcontent">
				<p class="pageTitle">1:1 문의 내역 <p>
					<button class="basicBtn">1:1문의하기</button>
					<table class="asktable">
					<br><br><br>
					<tr class="pointline">
						<th>글번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>답변여부</th>
					</tr>
					<tr class="pointline">
						<td>3</td>
						<td>결제 관련 문의 드립니다.</td>
						<td>2021-06-11</td>
						<td>N</td>
					</tr>
					<tr class="pointline">
						<td>2</td>
						<td>결제 관련 문의 드립니다.</td>
						<td>2021-06-02</td>
						<td>Y</td>
					</tr>
					<tr class="pointline">
						<td>1</td>
						<td>결제 관련 문의 드립니다.</td>
						<td>2021-06-04</td>
						<td>Y</td>
					</tr>
				</table>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
</body>
</html>