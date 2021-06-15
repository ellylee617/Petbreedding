<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<aside class="bMyPageAside">
	<div class="divBolder">
		<br>
			<label>마이페이지</label>
		<ul>
			<br>
			<a href="#"><li>내정보 수정</li></a>
			<br>
			<br>
		</ul>
			<label>고객센터</label>
		<ul>
			<br>
			<a href="#"><li>공지사항</li></a>
			<a href="#"><li>자주묻는 질문</li></a>
			<a href="#"><li>내 문의 내역</li></a>
			<a href="#"><li>1:1 문의하기</li></a>
			<br>
			<br>
		</ul>
		<a id="cancel"><label>제휴 취소 신청</label></a>
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
		<span class="btn">
			<button class="yes basicBtn">네</button>
			<button class="no basicBtn">아니오</button>
		</span>
</div>

	<script src="${path}/resources/js/bPartner/bMyPageAside.js"></script>
	
</aside>