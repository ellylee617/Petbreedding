<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/mypage/myboard.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/mypage/paging.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="${path}/resources/js/board/service.js"></script>    
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="wrapper">    
  <jsp:include page="../header.jsp" />
  <jsp:include page="aside.jsp"/>
  <section class="section">
  <div class="myboardhead">
        <h1>내가 쓴 글</h1>
        <table class="myboard">
            <thead>
            <tr>
              <th scope="cols" width="200px"><input type="checkbox"  value='selectall'
                onclick='selectAll(this)'>전체선택</th>
              <th scope="cols"  width="1700px">제목</th>
              <th scope="cols" width="200px">작성일</th>
              <th scope="cols" width="200px">조회수</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td><input type="checkbox" name="board"></td>
              <td>살찌면 뒷목살도 접히나요?</td>
              <td>2021-06-10</td>
              <td>3</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="board"></td>
                <td>살찌면 뒷목살도 접히나요?</td>
                <td>2021-06-10</td>
                <td>3</td>
              </tr>
            </tbody>
          </table>
        </div>
      <div class="myboardrow">
            <button class="basicBtn" id="basicBtn2"><a href="#">삭제</a></button>
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
    </section>
   
   <jsp:include page="../footer.jsp" />
    </div>
</body>
</html>