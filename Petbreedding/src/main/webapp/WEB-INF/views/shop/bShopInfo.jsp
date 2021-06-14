<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link type="text/css" rel="stylesheet" href="${path}/resources/css/reset.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/header.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/footer.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/mypage/bAside.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/shop/bShopInfo.css">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
		<jsp:include page="../myPage/bAside.jsp" />
			<div class="bContent">
				<h2>사업장 등록</h2>
				<br>
				<table class="tblInfo">
					<tr>
						<th>서비스 구분</th>
						<th><input type="radio" name="shop" id="bshop"><label for ="bshop">&nbsp;&nbsp;미용실</label></th>
						<th><input type="radio" name="shop" id="hshop"><label for ="hshop">&nbsp;&nbsp;동물병원</label></th>
					</tr>
					<tr>
						<th>매장명</th>
						<td colspan="2"><input type="text" placeholder="사업자 등록증에 명시된 매장명을 입력해주세요."></td>
					</tr>
					<tr>
						<th>매장 주소</th>
						<td colspan="2"><input type="text" id="sizeMod">&nbsp;&nbsp;<button class="basicBtn">주소 찾기</button></td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2"><input type="text"></td>
					</tr>
					<tr>
						<th>매장 전화번호</th>
						<td colspan="2"><input type="text" placeholder="'-'를 포함해서 입력해주세요"></td>
					</tr>
					<tr>
						<th>영업시간</th>
						<td colspan="2"><input type="text"></td>
					</tr>
					<tr>
						<th>간단소개</th>
						<td colspan="2"><input type="text"></td>
					</tr>
					<tr>
						<th>대표이미지</th>
						<th colspan="2"><button class="basicBtn">첨부하기</button></th>
					</tr>
					<tr>
						<th>주휴일</th>
						<th colspan="2">
						<div class="wrap"><input type="checkbox" id="mon"><label for="mon"><div class="dayitem">월</div></label></div>
						<div class="wrap"><input type="checkbox" id="tue"><label for="tue"><div class="dayitem">화</div></label></div>
						<div class="wrap"><input type="checkbox" id="wed"><label for="wed"><div class="dayitem">수</div></label></div>
						<div class="wrap"><input type="checkbox" id="thu"><label for="thu"><div class="dayitem">목</div></label></div>
						<div class="wrap"><input type="checkbox" id="fri"><label for="fri"><div class="dayitem">금</div></label></div>
						<div class="wrap"><input type="checkbox" id="sat"><label for="sat"><div class="dayitem">토</div></label></div>
						<div class="wrap"><input type="checkbox" id="sun"><label for="sun"><div class="dayitem">일</div></label></div>						
						</th>
					</tr>					
				</table>
				<br><br>
				<button class="basicBtn InfoRegi">등록하기</button>
			</div>
		</section>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>