<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/header.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/footer.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/mypage/myPageAside.css"
	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/mypage/myReservationList.css"
	rel="stylesheet" type="text/css">
	
<script src="https://kit.fontawesome.com/aca84cf3fb.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../header.jsp" />
		<section class="section">
			<jsp:include page="myPageAside.jsp" />
			<div class="mcontent">
				<div class="point">
					<p class="ptitle">보유포인트</p>
					<p class="ptitle">결제대기</p>
					<p class="ptitle">예약확정</p>
					<p class="ptitle">이용완료</p>
					<br>
					<p class="presult">1000P</p>
					<p class="presult">1</p>
					<p class="presult presultth">0</p>
					<p class="presult presultend">4</p>
				</div>
				<p class="pageTitle">예약 확인/조회</p>
				<hr>
				<table class="rtable">
					<tr>
						<td class="tdstart">기간별 조회</td>
						<td><input type="date">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="date"></td>
						<td class="tdend"><button type="button" class="rbutton">조회하기</button></td>
					</tr>
				</table>
				<hr>
				<br> <br>
				<table class="rtable rlist">
					<tr onclick="location.href='#'">
						<td>예약일</td>
						<td>예약정보</td>
						<td colspan="2">상태</td>
					</tr>
					<tr onclick="location.href='#'">
						<td>2021-06-04</td>
						<td>쿨펫 미용실</a></td>
						<td>결제대기</td>
					</tr>
					<tr onclick="location.href='#'">
						<td>2021-06-03</td>
						<td>쿨펫 동물병원</a></td>
						<td>결제취소</td>
					</tr>
					<tr onclick="location.href='#'">
						<td>2021-06-03</td>
						<td>쿨펫 미용실</td>
						<td>이용완료&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="basicBtn review" id="btnReWr">리뷰작성</button>
						</td>
					</tr>
					<tr onclick="location.href='#'">
						<td>2021-06-01</td>
						<td>쿨펫 동물병원</td>
						<td>이용완료&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="basicBtn rbuttoncom">작성완료</button>
						</td>
					</tr>
				</table>
		</section>
		<jsp:include page="../footer.jsp" />
		<!-- 리뷰 작성 모달창 -->
		<div id="ModalRe">
			<a class="modal_close_btn"><i class="fas fa-times"></i></a> <br>
			<form class="frmreview">
				<select name="score">
					<option value="1">아주 만족해요</option>
					<option value="2">만족해요</option>
					<option value="3">보통이에요</option>
					<option value="4">아쉬워요</option>
					<option value="5">많이 아쉬워요</option>
				</select> <br>
				<textarea placeholder="리뷰내용을 작성해주세요" name="id"></textarea>
				<br> <i class="fa fa-camera"></i>
				<button class="rbutton">등록하기</button>
				<br>
			</form>
		</div>
		<!-- 모달 끝! -->
	</div>
</body>
</html>