<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link type="text/css" rel="stylesheet" href="${path}/resources/css/common/reset.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/common/header.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/common/footer.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/bPartner/bMyPage/bModify.css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css">
</head>
<body>

    <div class="wrapper">
		<jsp:include page="../bheader.jsp" />
        <section class="section">
        <jsp:include page="../bAside.jsp" />
        	<div class="bContent">
        
	           <div class="updBox">
	                  <div class="updBox2">
	                      <form class="bmFrm">
	                          <label>이메일</label>
	                          <input type="text" class="inputBox" id="email"> 
	                          <label>이름</label>
	                          <input type="text" class="inputBox" id="name">
	                          <label>비밀번호</label>
	                          <input type="text" class="inputBox" id="pwd"> 
	                          <label>비밀번호 재확인</label>
	                          <input type="text" class="inputBox" id="pwdCheck"> 
	                          <label>휴대전화</label>
	                          <input type="text" class="hpBox" id="hp"  placeholder="휴대전화"> 
	                          <button type="button" class=" basicBtn" id="hpConfirm">휴대폰 번호 변경</button>
	                          <label>은행명</label>
	                          <select name="" id="selectBank">
	                              <option value="은행선택">은행선택</option>
	                              <option value="카카오뱅크">카카오뱅크</option>
	                              <option value="국민은행">국민은행</option>
	                              <option value="기업은행">기업은행</option>
	                              <option value="농협은행">농협은행</option>
	                              <option value="신한은행">신한은행</option>
	                              <option value="산업은행">산업은행</option>
	                              <option value="우리은행">우리은행</option>
	                              <option value="한국씨티은행">한국씨티은행</option>
	                              <option value="하나은행">하나은행</option>
	                              <option value="SC제일은행">SC제일은행</option>
	                              <option value="우체국">우체국</option>
	                              <option value="수협은행">수협은행</option>
	                              <option value="신협중앙회">신협중앙회</option>
	                              <option value="케이뱅크">케이뱅크</option>
	                              <option value="저축은행">저축은행</option>
	                          </select>
	                          <label>계좌번호</label>
	                          <input type="text" class="inputBox" id="bNum"  placeholder="'-'를 포함해서 입력해주세요">                     
	                          <input type="submit" class="basicBtn" id="submitBtn" value="수정하기">
	                      </form>
	                  </div> 
	              </div>
	              
              </div>
        </section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
	<!-- script -->
	<script src="https://kit.fontawesome.com/6a57affb8e.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>

</body>
</html>