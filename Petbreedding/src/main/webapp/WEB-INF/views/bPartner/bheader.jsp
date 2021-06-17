<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="Bheader">
    <nav class="UserNav">
        <ul>
        <!-- 사업자 ver 변경예쩡 -->
        	<c:if test = "${!empty client }">
	            <li class="alertBell"><a href="#"><i class="fas fa-bell"></i><span class="alertCircle"></span></a></li>
	            <li id="userName"><a href="#">${client.nickname}님</a></li>
	            <li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
            </c:if>
            <c:if test = "${empty client }">
	            <li><a href="${pageContext.request.contextPath}/uLogin">로그인</a></li>
            </c:if>
        </ul>
    </nav>
    <!-- 사업자 ver 변경예쩡 -->
    <a href="/petbreedding"><img class="logo" src="${pageContext.request.contextPath}/resources/images/logo.png" ></a>          
</header>