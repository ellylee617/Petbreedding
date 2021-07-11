<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bBoard/bNotice.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
			<jsp:include page="../bAside.jsp" />
			<div class="bContent">
				<h1>자주 묻는 질문</h1>
				<%-- <c:forEach items="${notice }" var="notice"> --%>
					<div>
						<div class="title">
							<span class="down"><i class="fas fa-angle-down"></i></span>
							<span class="up" ><i class="fas fa-angle-up"></i></span>
							<br>
							제목
						</div>
						<div class="content">
							<br>
							내용
						</div>
					</div>
				<%-- </c:forEach> --%>
				<hr>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/bPartner/bBoard/bNotice.js"></script>
	<script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
</body>
</html>