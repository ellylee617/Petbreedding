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
<link href="${path}/resources/css/user/uMember/uModify.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet" type="text/css">
</head>
<body>
	    <div class="wrapper">
        <jsp:include page="../../common/header.jsp" />

        <section class="section">
        <jsp:include page="../myPageAside.jsp" />

            <h1 class="updTitle">회원 정보 수정</h1>

            <form action="" id="updFrm" class="updFrm">
                <table>

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
                            <input type="text" placeholder="전화번호를 입력해주세요" class="getPhone_bar">
                        </td>
                        <td>
                            <button type="button" class="updPhobe_btn">휴대폰 번호 변경</button>
                        </td>
                    </tr>
                    <!-- <tr>
                        <td colspan="2">
                            <input type="text" placeholder="인증번호를 입력하세요" class="chkNumBar">
                            <p class="errorMsg">에이작스 메세지</p>
                        </td>
                    </tr> -->

                    <tr>
                        <td colspan="2">
                            <button class="updBtn" type="button">수정하기</button>
                        </td>
                    </tr>
                </table>
            </form>
        </section>

        <jsp:include page="../../common/footer.jsp" />
    </div>
</body>
</html>