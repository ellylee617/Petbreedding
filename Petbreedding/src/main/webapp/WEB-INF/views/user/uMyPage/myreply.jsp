<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uMyPage/myboard.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/paging.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="wrapper">    
  <jsp:include page="../../common/header.jsp" />
  <section class="section">
  <jsp:include page="../myPageAside.jsp"/>
  <div class="myboardhead">
        <h1>내가 쓴 댓글</h1>
        <table class="myboard">
            <thead>
            <tr>
              <th scope="cols" width="250px"><input type="checkbox"  value='selectall'
                onclick='selectAll(this)'>전체선택</th>
              <th scope="cols"  width="1200px">제목</th>
              <th scope="cols" width="600px"></th>
              <th scope="cols" width="200px">작성일</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td><input type="checkbox" name="board"></td>
              <td>살찌면 뒷목살도 접히나요?</td>
              <td><a href="#">원문보기▶</a></td>
              <td>2021-06-11</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="board"></td>
                <td>살찌면 뒷목살도 접히나요?</td>
                <td><a href="#">원문보기▶</a></td>
                <td>2021-06-11</td>
              </tr>
            </tbody>
          </table>
        </div>
      <div class="myboardrow">
            <button class="basicBtn" ><a href="#">삭제</a></button>
        </div>
 		<!-- 페이징 시작-->
		<div class="page_wrap">
			<div class="page_nation">
				<c:if test="${paging.startPage != 1 }">
					<a class="arrow prev" href="${path}/mwaitList?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">이전</a> 
				</c:if>
				<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
					<c:choose>
						<c:when test="${p == paging.nowPage }">
							<b>${p }</b>
						</c:when>
						<c:when test="${p != paging.nowPage }">
							<a href="${path}/mwaitList?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p}</a>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${paging.endPage != paging.lastPage}">
					<a class="arrow next" href="${path}/mwaitList?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">다음</a>
				</c:if>
			</div>
		</div>
		<!-- 페이징 끝! -->
    </section>
   
   <jsp:include page="../../common/footer.jsp" />
    </div>
    
    <script src="${path}/resources/js/user/uBoard/service.js"></script> 
</body>
</html>