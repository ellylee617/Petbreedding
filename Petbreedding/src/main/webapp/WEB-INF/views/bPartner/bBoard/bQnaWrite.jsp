<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/bPartner/bBoard/bQnaWrite.css" rel="stylesheet"
	type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
$(document).ready(function(){
    $("#browseBtn").bind("click", function() {
        insertImg();
    });
    
    function insertImg() {
        $("#realInput").trigger("click");
    }
});    
</script>
</head>
<body>
	<div class="wrapper">
			<jsp:include page="../bheader.jsp" />
		<section class="section">
			<div class="bContent">
			<form action="/petbreedding/maWrite" method="post" enctype="multipart/form-data">
				<input type="hidden" name="user_num" value="${user_num}">
				<input type="hidden" name="userType" value="2">
	            
	                <div class="qnatitle">
	            		<h1 id="h1">제목</h1>
	                   <input id="title" type="text" class="myAskTitle" name="myAskTitle" placeholder="글 제목을 입력해주세요">
	                </div>
	            <div class="qnacontent">
	                <h1 id="h2">내용</h1>
	                <textarea id="content" placeholder="1:1문의내용을 작성해주세요" name="myAskCont"></textarea>
	            </div> 
	            <div class="qanbtn">
					<input type="file" id="realInput" name="myAskImg" accept=".jpg, .png" style='display:none'>
		            <input type="button" value="이미지 등록" id="browseBtn" class="basicBtn">
		            <input type="submit" value="글등록" id="successbtn" class="basicBtn">
	            </div>
			</form>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
</body>
</html>