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
<link href="${path}/resources/css/bPartner/bBoard/bQnaWrite.css" rel="stylesheet">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
		<section class="section">
		<jsp:include page="../mAside.jsp"/>
			<div class="bContent">
					
			<c:choose>
				<c:when test="${type eq 1}">
				<!-- 글쓰기 -->
					<form action="msRegister" method="post" enctype="multipart/form-data">
						<input type="hidden" name="user_num" value="${type}">
						
		                <div class="msTitle">
		            		<h1 id="h1">제목 </h1>
	                    	<select class="selectBox" name="mServiceSelect">
		                        <option value="0">전체</option>
		                        <option value="1">회원</option>
		                        <option value="2">사업자</option>
	                    	</select>
		                   <input id="mServiceTitle" type="text" name="mServiceTitle" placeholder="공지사항 제목을 입력해주세요">
		                </div>
		                
			            <div class="msContent">
			                <h1 id="h2">내용</h1>
			                <textarea id="content" placeholder="공지사항을 작성해주세요" name="mServiceCont"></textarea>
			            </div> 
			            
			            <div class="msBtn">
				            <input type="reset" value="취소" id="browseBtn" class="basicBtn">
				            <input type="submit" value="글등록" id="successbtn" class="basicBtn">
			            </div>
			            
					</form>
						
				</c:when>
				
				<c:otherwise>
					<!-- 글 수정 -->
					<form action="msModify" method="post">
					<input type="hidden" name="updAnnNum" value="${updAnnNum}">
						
		             <div class="msTitle">
		         		<h1 id="h1">제목</h1>
		                	<select class="selectBox" name="mServiceSelect">
								<option value="0">전체</option>
								<option value="1">회원</option>
								<option value="2">사업자</option>
	                		</select>
		                <input id="mServiceTitle" type="text" name="mServiceTitle" value="${updAnnTitle}">
		             </div>
					             
					<div class="msContent">
					    <h1 id="h2">내용</h1>
					    <textarea id="content" name="mServiceCont">${updAnnCont}</textarea>
					</div> 
					
					<div class="msBtn">
						 <input type="reset" value="취소" id="browseBtn" class="basicBtn">
						 <input type="submit" value="글수정" id="successbtn" class="basicBtn">
					</div>
					          
					</form>
					
				</c:otherwise>
			</c:choose>
		            
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
</body>
</html>