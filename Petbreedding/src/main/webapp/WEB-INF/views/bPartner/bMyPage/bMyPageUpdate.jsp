<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css"	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bMyPageAside.css"	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bMyPage/bMyPageUpdate.css"	rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<section class="section">
		<jsp:include page="../bheader.jsp" />
		<jsp:include page="../bAside.jsp" />
			<div class="bContent">
				<form class="updateFrm">
					<label>이메일</label> <input type="text" class="inputBox" id="email">
					<label>이름</label> <input type="text" class="inputBox" id="name">
					<label>비밀번호</label> <input type="text" class="inputBox" id="pwd">
					<label>비밀번호 재확인</label> <input type="text" class="inputBox"
						id="pwdCheck"> <label>휴대전화</label> <input type="text"
						class="hpBox" id="hp">
					<button type="button" class="basicBtn hpBtn">휴대폰번호 변경</button>
					<label>은행명</label> 
					<select class="inputBox" name="bank">
						<option>은행선택</option>
						<option>카카오뱅크</option>
					</select> 
					<label>계좌번호</label> <input type="text" class="inputBox" id="account" placeholder="'-'를 포함해서 입력해주세요.">
				</form>
				<input type="submit" class="basicBtn submitBtn" value="수정하기">
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
</body>
</html>