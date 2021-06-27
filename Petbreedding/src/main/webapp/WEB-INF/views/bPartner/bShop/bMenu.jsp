<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bShop/bMenu.css" rel="stylesheet" type="text/css" >
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="${path}/resources/js/bPartner/bShop/bMenu.js"></script>
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../bheader.jsp" />
	 <section class="section">
	 <jsp:include page="../bAside.jsp"/>
	 <div class="bContent">
		    <div class="menucon">
		    <button id="addItemBtn" class="basicBtn">옵션추가</button>
		    </div>
	 	<div class="menuhead">
        	<h1>메뉴관리</h1>
	       <table style="border: 1px;">
	        <thead>
	        <tr>
	        <th width="550">타입</th>
	        <th width="500">메뉴명</th>
	        <th width="500">가격</th>
	        <th width="400">소요시간</th>
	        </tr>
	        </thead>
	        <tbody id="dynamicTbody">
	            
	        </tbody>
	        </table>
	        </div>

				<div class="insert">

					<!-- style_deep (0 : 메인메뉴  1: 서브메뉴) -->

					<c:if test="${empty styleList }">
						<form id="dynamicTable" action="${path}/bp/bMenu/write"
							method="POST">
							<label><input type="radio" name="style_deep" value="0">메인</label>
							<!-- 예약 페이지: 기타 추가요금 -->
							<label><input type="radio" name="style_deep" value="1">서브</label>
							<input type="text" placeholder="메뉴" id="menu" name="style_name">
							<input type="text" placeholder="가격" id="price" name="price">
							<input type="text" placeholder="소요시간" id="time" name="style_time">
							<button type="submit" class="basicBtn okbtn">완료</button>
						</form>
					</c:if>

					<!-- 등록된 스타일 불러오기 -->
					<c:if test="${!empty styleList }">
						<c:forEach var="list" items="${styleList }" varStatus="status">
								<form id="dynamicTable" action="${path}/bp/bMenu/rewrite"
									method="POST">
									<c:if test="${list.style_deep eq 0}">
									<label><input type="radio" name="style_deep" value="0" checked="checked">메인</label>
									<label><input type="radio" name="style_deep" value="1">서브</label>
									</c:if>
									<c:if test="${list.style_deep eq 1}">
									<label><input type="radio" name="style_deep" value="0">메인</label>
									<label><input type="radio" name="style_deep" value="1" checked="checked">서브</label>
									</c:if>
									<input type="hidden" value="${list.style_num }" name="style_num">
									<input type="hidden" value="${list.harNum }" name="harNum">
									<input type="text" placeholder="메뉴" id="menu" name="style_name" value="${list.style_name }"> 
									<input type="text" placeholder="가격" id="price" name="price" value="${list.price }"> 
									<input type="text" placeholder="소요시간" id="time" name="style_time" value="${list.style_time }">
									<button type="submit" class="basicBtn" class="rebtn">수정</button>
									<button type="button" class="basicBtn"  class="rebtn">삭제</button>
								</form>
						</c:forEach>
					</c:if>


				</div>



			</div>
	<!-- TODO:삭제 모달 -->
	 </section>
	<jsp:include page="../../common/footer.jsp" />
	</div>	 