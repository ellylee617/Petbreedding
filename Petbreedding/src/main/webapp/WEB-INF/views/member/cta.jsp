<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/member/cta.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/mypage/bAside.css" rel="stylesheet" type="text/css" >
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
    <div class="wrapper">
    <jsp:include page="../bheader.jsp" />
        <section class="section">
        <jsp:include page="../myPage/bAside.jsp" />
        	
        	<div class="bContent">
        	<form class="ctaFrm">
	            <div class="viewBox">
		            <p class="viewText fs20">울트라콜</p>
	                <span class="viewText views fs20">잔여 조회수</span>
	                <span class="viewText views fs24">0회</span>
	            </div>
		
	            <article class="aContainer">
	                <div class="aBox">
	                    <div>
	                        <p class="fs20">울트라콜 30회권</p>
	                        <ul>
	                            <li class="CTA_inst mt10">
	                                <span>최상단 노출</span>
	                            </li>
	                            <li class="CTA_inst mt10">
	                                <span>울트라콜은 차감 방식으로 진행됩니다.</span>
	                            </li>
	                            <li class="CTA_inst mt10">
	                                <span>고객에 따라, 때에 따라 내 점포가 보일 수도 있고 안보일 수도 있습니다.</span>
	                            </li>
	                        </ul>
	                    </div>
	    
	                    <div>
	                        <p class=" price fs20">20,000원</p>
	                        <button class="basicBtn CTAPayBtn">결제하기</button>
	                    </div>
	                </div>
	
	                <div class="aBox">
	                    <div>
	                        <p class="fs20">울트라콜 50회권</p>
	                        <ul>
	                            <li class="CTA_inst mt10">
	                                <span>최상단 노출</span>
	                            </li>
	                            <li class="CTA_inst mt10">
	                                <span>울트라콜은 차감 방식으로 진행됩니다.</span>
	                            </li>
	                            <li class="CTA_inst mt10">
	                                <span>고객에 따라, 때에 따라 내 점포가 보일 수도 있고 안보일 수도 있습니다.</span>
	                            </li>
	                        </ul>
	                    </div>
	    
	                    <div>
	                        <p class=" price fs20">35,000원</p>
	                        <button class="basicBtn CTAPayBtn">결제하기</button>
	                    </div>
	                </div>
	
	                <div class="aBox">
	                    <div>
	                        <p class="fs20">울트라콜 100회권</p>
	                        <ul>
	                            <li class="CTA_inst mt10">
	                                <span>최상단 노출</span>
	                            </li>
	                            <li class="CTA_inst mt10">
	                                <span>울트라콜은 차감 방식으로 진행됩니다.</span>
	                            </li>
	                            <li class="CTA_inst mt10">
	                                <span>고객에 따라, 때에 따라 내 점포가 보일 수도 있고 안보일 수도 있습니다.</span>
	                            </li>
	                        </ul>
	                    </div>
	    
	                    <div>
	                        <p class=" price fs20">50,000원</p>
	                        <button class="basicBtn CTAPayBtn">결제하기</button>
	                    </div>
	                </div>
	            </article>
        	</form>
        	</div>
        </section>
        <jsp:include page="../footer.jsp" />
    </div>
    
    <!-- script -->
    <script src="https://kit.fontawesome.com/6a57affb8e.js"></script>
    <script type="text/javascript" src="${path}/resources/js/mypage/bAside.js"></script>
</body>
</html>