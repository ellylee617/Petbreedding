<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/bheader.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/footer.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/mypage/bAside.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/mypage/bMyPageAside.css"
	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/mypage/bQna.css" rel="stylesheet"
	type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<section class="section">
			<jsp:include page="../bheader.jsp" />
			<jsp:include page="bAside.jsp" />
			<jsp:include page="bMyPageAside.jsp" />
			<div class="bContent">
				<h1>1:1 문의 내역</h1>
					<button class="basicBtn">1:1문의하기</button>
				<table class="asktable">
					<br>
					<br>
					<br>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>답변여부</th>
					</tr>
					<tr class="pointline">
						<td>3</td>
						<td><a>결제 관련 문의 드립니다.</a></td>
						<td>2021-06-11</td>
						<td>N</td>
					</tr>
					<tr class="pointline">
						<td>2</td>
						<td><a>결제 관련 문의 드립니다.</a></td>
						<td>2021-06-02</td>
						<td>Y</td>
					</tr>
					<tr class="pointline">
						<td>1</td>
						<td><a>결제 관련 문의 드립니다.</a></td>
						<td>2021-06-04</td>
						<td>Y</td>
					</tr>
				</table>
			</div>
		</section>
		<jsp:include page="../footer.jsp" />
	</div>

</body>
</html>