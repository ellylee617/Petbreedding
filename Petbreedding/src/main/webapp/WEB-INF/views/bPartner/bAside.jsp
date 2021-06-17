<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<aside class="bAside">
    <div class="bMenu">
        <ul>
            <a href="${pageContext.request.contextPath}/bReservation"><li class="menu" id="res">
                <i class="far fa-calendar-alt"></i>
                <p>예약관리</p>
            </li></a>
            <a href="${pageContext.request.contextPath}/bShop"><li class="menu hs" id="bShop">
                <i class="fas fa-home"></i>
                <p>사업장관리</p>
            </li></a>
            <c:if test = "${bP.bp_type == 0 }">
            <a href="${pageContext.request.contextPath}/bMenu"><li class="menu" id="menuOP">
                <i class="fas fa-bars"></i>
                <p>메뉴관리</p>
            </li></a>
            </c:if>
            <c:if test = "${bP.bp_type == 1 }">
            <li class="menu">
                <i class="fas fa-stethoscope"></i>
                <p>온라인검진</p>
            </li>
            </c:if>
            <li class="menu">
                <i class="fas fa-comments"></i>
                <p>채팅관리</p>
            </li>
            <a href="${pageContext.request.contextPath}/bCalculate"><li class="menu" id="bCal">
                <i class="fas fa-chart-bar"></i>
                <p>매출관리</p>
            </li></a>
            <a href="${pageContext.request.contextPath}/cta/cta"><li class="menu" id="cta">
                <i class="fas fa-phone-alt"></i>
                <p>울트라콜</p>
            </li></a>
            <a href="${pageContext.request.contextPath}/bNotice"><li class="menu hs" id="bMyPage">
                <i class="fas fa-user"></i>
                <p>마이페이지</p>
            </li></a>
        </ul>
        
    </div> 
    <div class="bSideMenu" id="bShopM">
        <div class="bBox">
            <ul>
                <p>사업장 관리</p>
                <c:if test = "${empty bP.bp_bank }">
                	<li class="bs">사업장 등록</li>
                </c:if>
                <c:if test = "${!empty bP.bp_bank }">
                	<li class="bs">사업장 수정</li>
                </c:if>
                <li class="bs">리뷰 관리</li>
            </ul>
        </div>
    </div>  
    <div class="bSideMenu" id="bMyPageM">
        <div class="bBox">
            <ul>
                <div class="bmp"> 
                    <p>마이페이지</p>
                    <li class="bs">내정보 수정</li>
                </div>
                <div class="bmp"> 
                    <p>고객센터</p>
                    <li class="bs">공지사항</li>
                    <li class="bs">자주묻는 질문</li>
                    <li class="bs">내 문의 내역</li>
                    <li class="bs">1:1 문의하기</li>
                </div>
                <div class="bmp"> 
                    <a id="cancel"><li class="bs">제휴취소 신청</li></a>
                </div>
            </ul>
        </div>
    </div>              

<!-- 제휴 취소 모달 -->
<div id="cancel-modal" class="modal">
	<div class="cancel-content">
		<p class="boldtext">제휴를 취소 하시겠습니까?</p> 
		<p class="text">
		<br>
		고객님과 관련된 모든 정보가 삭제됩니다.
		<br>
		정산이 완료 되면 탈퇴 처리됩니다.<br><br></p>
		<div class="btn">
			<button class="yes basicBtn">네</button>
			<button class="no basicBtn">아니오</button>
		</div>
</div>
</aside>

