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
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet"	type="text/css">	
<link href="${path}/resources/css/user/uMyPage/myAskDetail.css" rel="stylesheet"	type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
			<div class="mcontent">
			<table class="asktbl">
				<tr>
					<th colspan="2">${myAskDetail.qnaCont }</th>
				</tr>
				<tr>
					<td>작성자:${myAskDetail.qnaWr }</td>
					<td>작성일:${myAskDetail.qnaDate }</td>
				</tr>
				<tr class="asktblImg">
					<c:choose>
						<c:when test="${myAskDetail.qnaImg eq null}">
							<td colspan="2"><img src="http://placehold.it/500x300"></td>
						</c:when>
						<c:otherwise>
							<td colspan="2"><img src="${path}/resources/uploadFile/myAsk/${myAskDetail.qnaImg }"></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
                <button class="basicBtn">목록</button>
        <br><br><br><br>
        <table class="reponsetbl">
        	<tr>
        		<th>관리자</th>
        		<td>2021-06-04</td>
        	</tr>
        	<tr>
        		<td colspan="2">안녕하세요. 또비언니님<br><br>현재 확인해본 결과, 해당 카드사에서 발생한 문제로 확인되고 있습니다.
        		<br>잠시 후 다시 결제 해보시고, 안되시면 고객센터(1577-0123)로 연락주시면 추가 안내해드리겠습니다.<br><br>
        		감사합니다.</td>
        	</tr>
        </table>
		</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
</body>
</html>