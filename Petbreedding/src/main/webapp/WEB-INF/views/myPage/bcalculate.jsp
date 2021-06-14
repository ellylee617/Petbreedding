<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/mypage/bAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/mypage/bcal.css" rel="stylesheet" type="text/css" >
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="./jquery-ui-1.12.1/datepicker-ko.js"></script>
<script src="${path}/resources/js/board/service.js"></script>
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../header.jsp" />
	 <section class="section">
	 <jsp:include page="../myPage/bAside.jsp"/>
	 <div class="calhead">
        <p>6월 총 매출액</p>
        <p>(1일전 영업일 기준)</p><br>
        
    </div>
    <div class="calrow">
    <h1>1,681,111원</h1>
    <div class="calbtn">
        <button class="timeBtn">최근 3개월</button>
        <button class="timeBtn">최근 6개월</button>
        <button class="timeBtn">최근 1년</button>
    </div>
    <div class="timeOption">
        <p>기간별 조회</p>
     <div class="timeOptionRow">  
        <label>&nbsp;<input type="text" id="startDate" name=startDate></label>
		<label><input type="text" id="endDate" name="endDate"></label>			
    </div> 
    </div>
    <button class="basicBtn" id="inquiryBtn">조회</button>
    </div>
    
	 </section>
	<jsp:include page="../footer.jsp" />
	</div>	 