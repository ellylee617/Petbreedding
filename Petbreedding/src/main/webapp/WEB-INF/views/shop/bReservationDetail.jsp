<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/mypage/bAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/shop/bReservationDetail.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
	        <jsp:include page="../myPage/bAside.jsp" />
	        <div class="bContent">
                                <h1>예약 완료</h1>
                <div class="resInfo infoBox">
                    <table>
                        <tr class="infoTitle">예약 정보</tr>
                        <tr class="info">
                            <td>일정</td>
                            <td>2021-06-10 목요일 오후 4:30</td>
                        </tr>
                        <tr class="info">
                            <td>상품</td>
                            <td>클리퍼 미용 (+)디자인 컷</td>
                        </tr>
                    </table>
                </div>
                <div class="clientInfo infoBox">
                    <table>
                        <tr class="infoTitle">예약자 정보</tr>
                        <tr class="info">
                            <td>예약자명</td>
                            <td>곽서현</td>
                        </tr>
                        <tr class="info">
                            <td>연락처</td>
                            <td>010-1234-1234</td>
                        </tr>
                        <tr class="info">
                            <td>이메일</td>
                            <td>abcd@naver.com</td>
                        </tr>
                    </table>
                </div>
                <div class="dogInfo infoBox">
                    <table>
                        <tr class="infoTitle">반려견 정보</tr>
                        <tr>
                            <td>또비</td>
                            <td>7살</td>
                            <td>5.5kg</td>
                            <td>중성화</td>
                            <td>미용경험 무</td>
                            <td>5차 완료</td>
                            <td>입질 없음</td>
                            <td>입</td>
                            <td>다리</td>
                            <td>슬개골 탈구 2기</td>
                        </tr>
                        <tr>
                            <td>특이사항 없음</td>
                        </tr>
                    </table>
                </div>
                <div class="btnBox">
                    <button class="chatBtn basicBtn">1:1 채팅하기</button>
                    <button class="cancleBtn basicBtn" id="cancleBtn">취소하기</button>
                </div> 
            </div> 	
	    </section>
		<jsp:include page="../footer.jsp" />
		
        <!-- MODAL -->
        <div id="my_modal">
            <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
            <div id="locCon">
                <h1>정말 취소하시겠습니까?</h1>
                <button id="goTOCancle" >네</button>
                <button id="nextTime">아니오</button>
            </div>
        </div>
	</div>
	
	<!-- script -->
    <script type="text/javascript" src="${path}/resources/js/mypage/bAside.js"></script>
    <script type="text/javascript" src="${path}/resources/js/shop/bReservationDetail.js"></script>
</body>
</html>