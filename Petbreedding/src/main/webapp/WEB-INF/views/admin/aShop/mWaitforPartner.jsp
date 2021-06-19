<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" type="text/css" rel="stylesheet">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css"  type="text/css" rel="stylesheet">
<link href="${path}/resources/css/admin/mAside.css"  type="text/css" rel="stylesheet">
<link href="${path}/resources/css/admin/aShop/mWaitforPartner.css"  type="text/css" rel="stylesheet">
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
		<section class="section">
			<jsp:include page="../mAside.jsp" />
			<div class="mContent">
			<h1>제휴 승인 대기</h1>
				<table>
					<tr>
						<th><input type="checkbox" id="checkall">&nbsp;&nbsp;전체선택</th>
						<th>사업자 분류</th>
						<th>이름</th>
						<th>사업자 번호</th>
						<th>연락처</th>
						<th>상태</th>
					</tr>
					<tr class="checkTR">
						<td class="inputBox"><input type="checkbox"></td>
						<td>미용</td>
						<td>곽서현</td>
						<td>123-12-4567890</td>
						<td>010-111-2345</td>
						<td>대기</td>
					</tr>
					
				</table>
				<br>
				<div class="partnerbtns">
					<button class="basicBtn">승인</button>
					<button class="basicBtn">취소</button>
				</div>
				<br><br><br><br>
				<!-- 페이징 시작-->
				<div class="page_wrap">
					<div class="page_nation">
						<a class="arrow prev" href="#">이전</a> <a href="#" class="active">4</a>
						<a href="#">5</a> <a href="#">6</a> <a href="#">7</a> <a href="#">8</a>
						<a class="arrow next" href="#">다음</a>
					</div>
				</div>
				<!-- 페이징 끝! -->
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
	<script type="text/javascript" src="${path}/resources/js/admin/aShop/mWaitforPartner.js"></script>
</body>
</html>