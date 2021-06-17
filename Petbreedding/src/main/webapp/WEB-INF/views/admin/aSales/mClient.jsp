<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 관리자</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/admin/mAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/admin/aSales/mClient.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
        <section class="section">
        	<jsp:include page="../mAside.jsp" />
        	<div class="mContent">
                <h1>회원조회</h1>
                <div class="memberBox">
                    <h1>130,267</h1>
                    <span>일반 고객 가입자수</span>
                </div>
                <div class="memberBox">
                    <h1>20,168</h1>
                    <span>사업자 고객 가입자수</span>
                </div>
                <div class="graphBox">

                </div>
                <div class="graphBox">

                </div>
            </div>
        </section>
		<jsp:include page="../../common/footer.jsp" />	
</div>

		<!-- script -->
		<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
</body>
</html>