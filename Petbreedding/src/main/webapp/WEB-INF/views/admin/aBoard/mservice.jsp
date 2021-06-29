<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/admin/mAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/admin/aBoard/mservice.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../mheader.jsp" />
	 <section class="section">
	 <jsp:include page="../mAside.jsp"/>
	 <div class="mContent">
	  <div class="mboardhead">
                <h1>공지사항 게시판</h1>
                <div class="select">
                    <select>
                        <option value="1">전체</option>
                        <option value="2">회원</option>
                        <option value="3">사업자</option>
                    </select>

                </div>
                <button class="basicBtn" id="writeBtn">글쓰기</button>

            </div>
            <div class="mboardrow">
                <table class="myboard">
                    <thead>
                    <tr>
                      <th scope="cols" width="200px">구분</th>
                      <th scope="cols"  width="1400px">제목</th>
<!--                       <th scope="cols" width="200px">작성자</th> -->
                      <th scope="cols" width="200px">작성일</th>
                    
                    </tr>
                    </thead>
                    <tbody>
                    
                    <c:forEach items="${cusList}" var="list">
                    
                    <tr>
                    <c:choose>
                    	<c:when test="${list.annType eq 0}">
	                    	<td>[전체]</td>
                    	</c:when>
                    	<c:when test="${list.annType eq 1}">
	                    	<td>[회원]</td>
                    	</c:when>
                    	<c:otherwise>
                    		<td>[사업자]</td>
                    	</c:otherwise>
                    </c:choose>
                      <td>${list.annTitle }</td>
<%--                       <td>${list.annTitle }</td> --%>
                      <td>${list.annDate }</td>
                     
                    </tr>
                    
                    </c:forEach>

                    </tbody>
                  </table>
            </div>
            <div class="page_wrap">
                <div class="page_nation">
                   <a class="arrow prev" href="#">이전</a>
                   <a href="#" class="active">1</a>
                   <a href="#">2</a>
                   <a href="#">3</a>
                   <a href="#">4</a>
                   <a href="#">5</a>
                   <a href="#">6</a>
                   <a href="#">7</a>
                   <a href="#">8</a>
                   <a href="#">9</a>
                   <a href="#">10</a>
                   <a class="arrow next" href="#">다음</a>
                </div>
             </div>
    
    </div>
	   </section>
	<jsp:include page="../../common/footer.jsp" />
	</div>	 
<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
	</body>
	</html>