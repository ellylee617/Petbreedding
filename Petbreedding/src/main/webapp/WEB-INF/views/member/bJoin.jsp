<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/member/bJoin.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
        <section class="section">
           <div class="joinBox">
                  <div class="joinBox2">
                      <h1>제휴 및 회원가입</h1>
                      <form class="joinFrm">
                          <label>이메일</label>
                          <input type="text" class="inputBox" id="email"> 
                          <label>비밀번호</label>
                          <input type="text" class="inputBox" id="pwd"> 
                          <label>비밀번호 재확인</label>
                          <input type="text" class="inputBox" id="pwdCheck"> 
                          <label>이름</label>
                          <input type="text" class="inputBox" id="name"> 
                          <label>휴대전화</label>
                          <input type="text" class="hpBox" id="hp"  placeholder="전화번호를 입력해주세요"> 
                          <button type="button" class=" basicBtn" id="hpConfirm">인증번호 받기</button>
                          <button type="button" class=" basicBtn" id="hpConfirm2">인증번호 확인</button>
                          <input type="text" class="inputBox" id="hp2"  placeholder="인증번호를 입력하세요"> 
                          <label>사업자 번호</label>
                          <input type="text" class="inputBox" id="bNum"  placeholder="'-'를 포함해서 입력해주세요"> 
                          <label>서비스 구분</label>
                          <div class="serviceC">
                              <input type="radio" class="checkShop" name="checkShop" id="salon"> 
                              <label for="salon" class="radioL">미용실</label>
                              <input type="radio" class="checkShop" name="checkShop" id="hospital"> 
                              <label for="hospital" class="radioL">동물 병원</label>
                          </div>                       
                      </form>
                      <input type="submit" class="basicBtn" id="submitBtn" value="가입하기">
                  </div> 
              </div>
        </section>
		<jsp:include page="../footer.jsp" />
	</div>
	
	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/member/bJoin.js"></script>
</body>
</html>