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
<link href="${path}/resources/css/user/uMyPage/myReservationList.css"	rel="stylesheet" type="text/css">
<link	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css"	rel="stylesheet" />
<script src="https://kit.fontawesome.com/aca84cf3fb.js"	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
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
				<br>
				<p class="pageTitle">예약 확인/조회</p>
				<br>
				<hr>
				<table class="rtable">
					<tr>
						<td class="tdstart">기간별 조회</td>
						<td><input type="date">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="date"></td>
						<td class="tdend"><button type="button rbtn" class="rbutton">조회하기</button></td>
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
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- 리뷰 작성 모달창 -->
	<div id="modalRe" class="modalRe-Overlay">
		<div id="modalRe-Win">
			<form id="frm">
				<a class="modal_close_btn"><i class="fas fa-times fa-lg"></i></a> <br><br>
				<div class="select">
					<span class="text">별점을 선택해주세요</span><span class="downArrow"></span>
					<ul class="option-list">
						<li class="option" value="5"><img src="${path}/resources/images/5.png">&nbsp;&nbsp;아주 만족해요</li>
						<li class="option" value="4"><img src="${path}/resources/images/4.png">&nbsp;&nbsp;만족해요</li>
						<li class="option" value="3"><img src="${path}/resources/images/3.png">&nbsp;&nbsp;보통이에요</li>
						<li class="option" value="2"><img src="${path}/resources/images/2.png">&nbsp;&nbsp;조금 아쉬워요</li>
						<li class="option" value="1"><img src="${path}/resources/images/1.png">&nbsp;&nbsp;많이 아쉬워요</li>
					</ul>
						<input type="number" id="selectedVal" name="selectedVal" style="display:none"  readonly>
				</div>
				<br>
				<textarea placeholder="리뷰내용을 작성해주세요" id="revCont" name="revCont" rows="15" cols="37"></textarea>
				<br><br>
				<a class="btnAddFile"><i class="fa fa-camera fa-2x"></i></a>
				<button id="regBtn" class="basicBtn btnReCom">등록하기</button>
				<br>
			</form>
		</div>
	</div>
	<!-- 모달 끝! -->
	<script src="${path}/resources/js/user/uMyPage/myReservationList.js"></script>
</body>
</html>