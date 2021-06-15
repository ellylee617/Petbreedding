<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petverything::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uMember/uJoin.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
    <div class="wrapper">
        <jsp:include page="../../common/header.jsp" />

        <section class="section">
            <form action="" id="joinFrm" class="joinFrm">
                <table>
                    <tr>
                        <td>
                            <span>이메일</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="text" class="basicTextInput">
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
                            <input type="text" class="basicTextInput">
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
                            <input type="text" class="basicTextInput">
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
                            <input type="text" class="basicTextInput">
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
                            <input type="text" class="basicTextInput">
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
                            <input type="text" placeholder="전화번호를 입력해주세요" class="getChkMsg_bar basicTextInput">
                        </td>
                        <td>
                            <button type="button" id="getChkMsg_btn" class="basicBtn">인증번호 받기</button>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="text" placeholder="인증번호를 입력하세요" id="chkNumBar" class="basicTextInput">
                            <p class="errorMsg">에이작스 메세지</p>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <button id="joinBtn" class="basicBtn" type="button">가입하기</button>
                        </td>
                    </tr>
                </table>
            </form>
        </section>

        <jsp:include page="../../common/footer.jsp" />
    </div>
</body>
</html>