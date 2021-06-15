<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/mypage/ctaPay.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/mypage/bAside.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />

		<section class="section">
			<jsp:include page="../myPage/bAside.jsp" />

			<div class="bContent">
					<p class="title">울트라콜 결제</p>
				<form action="#" id="cpFrm">
					<div class="container">
						<div class="mb30">
							<span>구매자 정보</span>
						</div>
						<div class="mt15">
							<span>구매자명</span> <span>곽서현</span>
						</div>
						<div class="mt15">
							<span>연락처</span> <span>010-0000-0000</span>
						</div>
					</div>

					<main>
						<div>
							<div class="container spaceBw">
								<span>결제 상품</span> <span>울트라콜30회</span>
							</div>

							<div class="container spaceBw">
								<span>결제 금액</span>
								<div>
									<span class="totalPrice">총 결제 금액</span> <span>20,000원</span>
								</div>
							</div>

							<div class="container">
								<p>결제 방법 선택</p>
								<label for="creditCard">신용카드</label> <input type="radio"
									id="creditCard" class="mr30" name="pay"> <label
									for="noneAccount">무통장 입금</label> <input type="radio"
									id="creditCard" class="mr30" name="pay"> <label
									for="account">계좌 이체</label> <input type="radio" id="account"
									class="mr30" name="pay"> <label for="phone">휴대폰
									결제</label> <input type="radio" id="phone" class="mr30" name="pay">
								<label for="kakao">카카오 페이</label> <input type="radio" id="kakao"
									class="mr30" name="pay"> <label for="naver">네이버
									페이</label> <input type="radio" id="naver" class="mr30" name="pay">
							</div>

							<div class="container">
								<p>이용 동의</p>
								<div>
									<input type="checkbox" id="allAgr" class="mb30"> <label
										for="allAgr">모두 동의</label>
								</div>

								<div>
									<input type="checkbox" id="agr1" class="mb30"> <label
										for="agr1">상기 결제 내역을 확인, 결제 진행에 동의(필수)</label>
								</div>

								<div>
									<input type="checkbox" id="agr2"> <label for="agr2">취소/변경/환불/
										수수료 및 기한을 확인 후 동의(필수)</label>
									<p class="detail">자세히 보기</p>
								</div>

								<div>
									<input type="checkbox" id="agr3"> <label for="agr3">개인
										정보 수집에 동의</label>
									<p class="detail">자세히 보기</p>
								</div>

							</div>
						</div>
					</main>

					<button class="basicBtn payBtn">결제하기</button>
				</form>


			</div>
		</section>
		<jsp:include page="../footer.jsp" />
	</div>
	
	<!-- script -->
	<script src="https://kit.fontawesome.com/6a57affb8e.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="${path}/resources/js/mypage/bAside.js"></script>
</body>
</html>