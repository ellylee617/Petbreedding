<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 관리자</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/mypage/mAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/member/mSales.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
        <section class="section">
        	<jsp:include page="../myPage/mAside.jsp" />
        	<div class="mContent">
                <div class="bbox">
                    <h4>총매출<span>(최근 6개월 기준)</span></h4>
                    <div class="salesBox box">

                    </div>
                </div>
                <div class="bbox">
                    <h4>순매출<span>(최근 6개월 기준)</span></h4>
                    <div class="salesBox box">
    
                    </div>
                </div>
                <div class="tbox">
                    <h4>연간매출액<span>(2020년 6월 ~ 2021년 6월)</span></h4>
                    <div class="yearSalesBox">

                    </div>
                </div>
                
                <div class="bbox">
                    <h4>울트라콜 점유율</h4>
                    <div class="ultra box">
    
                    </div> 
                </div>
                <div class="bbox">
                    <h4>업종별 울트라콜 이용(전체)</h4>
                    <div class="ultra box">

                    </div>
                </div>
            </div>
        </section>
		<jsp:include page="../footer.jsp" />	
</div>

		<!-- script -->
		<script type="text/javascript" src="${path}/resources/js/mypage/mAside.js"></script>
</body>
</html>