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
<link href="${path}/resources/css/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/member/join.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<div></div>
<div></div>
	<div class="wrapper">
	<jsp:include page="../header.jsp" />
	 
	    <div class="joinBox">
	        <form action="" id="joinFrm">
	            <table>
	                <tr>
	                    <td>
	                        <span>이메일</span>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2">
	                        <input type="text">
	                        <p class="errorMsg">에이작스 메세지</p>
	                    </td>
	                </tr>
	
	                <tr>
	                    <td>
	                        <span>비밀번호</span>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2">
	                        <input type="text">
	                        <p class="errorMsg">에이작스 메세지</p>
	                    </td>
	                </tr>
	
	                <tr>
	                    <td>
	                        <span>비밀번호 재확인</span>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2">
	                        <input type="text">
	                        <p class="errorMsg">에이작스 메세지</p>
	                    </td>
	                </tr>
	
	                <tr>
	                    <td>
	                        <span>이름</span>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2">
	                        <input type="text">
	                        <p class="errorMsg">에이작스 메세지</p>
	                    </td>
	                </tr>
	                
	                <tr>
	                    <td>
	                        <span>닉네임</span>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2">
	                        <input type="text">
	                        <p class="errorMsg">에이작스 메세지</p>
	                    </td>
	                </tr>
	                
	                <tr>
	                    <td>
	                        <span>휴대전화</span>
	                    </td>
	                </tr>
	                <tr>
	                    <td>
	                        <input type="text" placeholder="전화번호를 입력해주세요" class="getChkMsg_bar">
	                    </td>
	                    <td>
	                        <button type="button" class="getChkMsg_btn">인증번호 받기</button>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2">
	                        <input type="text" placeholder="인증번호를 입력하세요" class="chkNumBar">
	                        <p class="errorMsg">에이작스 메세지</p>
	                    </td>
	                </tr>
	
	                <tr>
	                    <td colspan="2">
	                        <button class="joinBtn" type="button">가입하기</button>
	                    </td>
	                </tr>
	            </table>
	        </form>
	    </div>
	    
	<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>