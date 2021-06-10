<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="Uheader">
    <nav class="UserNav">
        <ul>
            <li class="alertBell"><a href="#"><i class="fas fa-bell"></i><span class="alertCircle"></span></a></li>
            <li id="userName"><a href="#">곽서현님</a></li>
            <li><a href="ULogin.html">로그인</a></li>
            <li><a href="USignUp.html">회원가입</a></li>
            <li><a href="UCheckReservation.html">예약확인/조회</a></li>
            <li><a href="UcustomerService">고객센터</a></li>
        </ul>
    </nav>  
    <div class="mainMenu">   
        <img class="logo" src="${pageContext.request.contextPath}/resources/images/logo.png" >            
        <nav class="mainMenu1">                  
            <ul>
                <li><a href="Uinfo.html">소개</a></li>
                <li><a href="hospital.html">동물병원</a></li>
                <li><a href="salon.html">미용실</a></li>
                <li><a href="consult.html">1:1수의사 상담</a></li>
            </ul>
        </nav>
        <nav class="mainMenu2">
            <ul>
                <li><a href="fboardlist">자유게시판</a></li>
                <li><a href="business.html">제휴문의</a></li>
            </ul>
        </nav>
    </div>
</header> 