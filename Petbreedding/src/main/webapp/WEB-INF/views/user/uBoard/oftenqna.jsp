<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uBoard/service.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="${path}/resources/js/user/uBoard/service.js"></script>
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../../common/header.jsp" />
	 <section class="section">
        <div class="service">
        <div class="serviceTitle">
            <div class="inside">
            <h2>고객센터</h2>
            <h1>CUSTOMER</h1>
            <h1>SERVICE</h1>
            <H1>CENTER</H1>

            </div>
        </div>
        <div class="serviceNav">
            <div class="inside">
                <a href="UcustomerService"><p>공지사항</p></a>
                <a href="oftenqna"><p>자주묻는질문</p></a>
                <a href="maWriteForm"><p>1:1 문의 작성</p></a>
                </div>
        </div>
        </div>
        <div class="serviceMain">
            <h1>자주 묻는 질문</h1>
            <hr>
            <div id="Accordion_wrap">
                
                <!--for문으로 나중에 기능 구현하고 돌리기-->
                <div class="que2">
                 <span>예약 후 취소는 어떻게 하나요?</span>
                </div>
                <div class="anw2">
                 <span>
                    
                       예약 확정이 된 후에는 해당 업체와 연락 후 취소가 가능합니다. 

                    

                 </span>
                </div>
                 
           </div>
        </div>
        </section>

       
	<jsp:include page="../../common/footer.jsp" />
	</div>