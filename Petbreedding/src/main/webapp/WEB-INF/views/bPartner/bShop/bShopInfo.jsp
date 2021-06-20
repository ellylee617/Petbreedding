<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link type="text/css" rel="stylesheet" href="${path}/resources/css/common/reset.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/bPartner/bheader.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/common/footer.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/bPartner/bAside.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/bPartner/bShop/bShopInfo.css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
		<jsp:include page="../bAside.jsp" />
			<div class="bContent">
			<form action="${path}/bShop/write" method="POST" id="bShopInfoFrm" enctype="multipart/form-data">
				<!-- TODO: input type="hidden"으로 사업자 고객번호   -->
				<h2>사업장 등록</h2>
				<br>
				<table class="tblInfo">
					<tr>
						<th>서비스 구분</th>
						<th><input  readonly="readonly" type="radio" name="shop" id="bshop" value="0"><label for ="bshop">&nbsp;&nbsp;미용실</label></th>
						<th><input  readonly="readonly" type="radio" name="shop" id="hshop" value="1"><label for ="hshop">&nbsp;&nbsp;동물병원</label></th>
					</tr>
					<tr>
						<th>매장명</th>
						<td colspan="2"><input id="shopName" type="text" placeholder="사업자 등록증에 명시된 매장명을 입력해주세요." name="shopName"></td>
					</tr>
					<tr>
						<th>매장 주소</th>
						<td colspan="2">
						<input type="text" id="postcode"
							placeholder="우편번호"> <input id="postcodebtn" class="basicBtn" type="button" onclick="exePostCode()" value="우편번호 찾기">
							<br>
							<input type="text" id="shopAddress" placeholder="주소" name="shopAddr">
							<br>
							<input type="text" id="detailAddress" placeholder="상세주소">
							<input type="text" id="extraAddress" placeholder="참고항목">
					</tr>
					<tr>
						<th>매장 전화번호</th>
						<td colspan="2"><input id="shopTel" type="text" placeholder="'-'를 포함해서 입력해주세요" name="shopTel"></td>
					</tr>
					<tr>
						<th>영업시간</th>
						<td colspan="2"><input id="shopTime" type="text" name="shopTime"></td>
					</tr>
					<tr>
						<th>간단소개</th>
						<td colspan="2"><input id="shopMInfo" type="text" name="shopMInfo"></td>
					</tr>
					<tr>
						<th>대표이미지</th>
						<th colspan="2">
							  <div class="imgContainer">
                                <div class="imgBox">
                                    <img src="">
                                </div>
                                <input type="file" id="inputShopImg" name="shopImg" multiple="multiple" accept=".jpg, .jpeg, .png" value="파일선택">
                            </div>
						</th>
					</tr>
					<tr>
						<th>주휴일</th>
						<th colspan="2">
						<div class="wrap"><input type="checkbox" id="mon" name="shopDayOff" value="1"><label for="mon"><div class="dayitem">월</div></label></div>
						<div class="wrap"><input type="checkbox" id="tue" name="shopDayOff" value="2"><label for="tue"><div class="dayitem">화</div></label></div>
						<div class="wrap"><input type="checkbox" id="wed" name="shopDayOff" value="3"><label for="wed"><div class="dayitem">수</div></label></div>
						<div class="wrap"><input type="checkbox" id="thu" name="shopDayOff" value="4"><label for="thu"><div class="dayitem">목</div></label></div>
						<div class="wrap"><input type="checkbox" id="fri" name="shopDayOff" value="5"><label for="fri"><Rdiv class="dayitem">금</div></label></div>
						<div class="wrap"><input type="checkbox" id="sat" name="shopDayOff" value="6"><label for="sat"><div class="dayitem">토</div></label></div>
						<div class="wrap"><input type="checkbox" id="sun" name="shopDayOff" value="7"><label for="sun"><div class="dayitem">일</div></label></div>						
						</th>
					</tr>					
				</table>
				<br><br>
				<button class="basicBtn InfoRegi">등록하기</button>
			</form>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
		<!-- 스크립트 -->
		<script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
		<script type="text/javascript" src="${path}/resources/js/bPartner/bPostcode.js"></script>
		<script type="text/javascript" src="${path}/resources/js/bPartner/bBoard/bShopInfo.js"></script>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		
</body>
</html>