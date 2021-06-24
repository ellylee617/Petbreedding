<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/user/myPageAside.css"	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uMyPage/point.css"	rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js"	crossorigin="anonymous"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
			<div class="mcontent">
		
					,${currPoint},
				
					<div class="point">
<%-- 						<c:forEach items="${pointList}" var="items"> --%>
	                    <p class="ptitle">보유포인트</p>
	                    <br>
	                    <p class="presult">${currPoint}P</p>
<%-- 	                    </c:forEach> --%>
	                </div>
	                <br>
	                <div class="selectOpt">
	                    <input type="radio" checked id="popular" name="selectOpt"><label for="popular">최근 3개월</label>
	                    <input type="radio" id="distance" name="selectOpt"><label for="distance">최근 6개월</label>
	                    <input type="radio" id="rating" name="selectOpt"><label for="rating">최근 1년</label>
	                </div>
	                <div class="timetblP">
	                    <span>기간별 조회</span>&nbsp;&nbsp;&nbsp;
	                    <span><input type="date">&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;<input type="date"></span>
	                    <span>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="basicBtn">조회하기</button></span>
	                </div>
	                <br><br><br><br>
							<c:forEach items="${pointList}" var="items">
	                		<table class="pointtable">
	                    <tr class="pointline">
	                
		                    <c:if test="${items.pointNum eq 'PO1' or 'PO2'}">
		                        <td class="pred"><div class="circlep">${items.expType }</div></td>
		                        <td>${items.expDate }</td>
		                        <td>${items.expFrom }</td>
		                        <td class="pred">${items.expPoint }p</td>
		                    </c:if>
		                    <c:if test="${items.pointNum ne 'PO1' or 'PO2'}">
		                  		<td class="pgreen"><div class="circleg">${items.expType }</div></td>
		                        <td>${items.expDate }</td>
		                        <td>${items.expFrom }</td>
		                        <td class="pgreen">${items.expPoint }p</td>
		                    </c:if>
		                    
	                    </tr>
<!-- 	                    <tr class="pointline">
	                        <td class="pred"><div class="circlep">사용</div></td>
	                        <td>2021-06-10</td>
	                        <td>쿨펫 미용실</td>
	                        <td class="pred">-5300p</td>
	                    </tr>
	                    <tr class="pointline">
	                        <td class="pgreen"><div class="circleg">적립</div></td>
	                        <td>2021-06-10</td>
	                        <td>쿨펫 미용실</td>
	                        <td class="pgreen">+5300p</td>
	                    </tr>
	                    <tr class="pointline">
	                        <td class="pred"><div class="circlep">사용</div></td>
	                        <td>2021-06-10</td>
	                        <td>쿨펫 미용실</td>
	                        <td class="pred">-5300p</td>
	                    </tr> -->
	                </table>
	                </c:forEach>
	                <div class="divmore">
	                <button class="btnmore">더보기</button>
	                </div>
	               
            </div>
        </section>
        <jsp:include page="../../common/footer.jsp"/>
    </div>
</body>
</html>