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
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uBoard/qna.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
		<jsp:include page="../../common/header.jsp" />
		 <center>
        <section class="section">
        	<form action="maWrite" method="post" enctype="multipart/form-data">
        		<input type="hidden" name="user_num" value="${user_num}">
	           	<h1>1:1문의 작성</h1>
	            
				<div class="qnatitle">
				   <input type="text" name="myAskTitle" placeholder="글 제목을 입력해주세요">
				</div>
				
	            <div class="qnacontent">
	                <textarea placeholder="1:1문의내용을 작성해주세요" name="myAskCont"></textarea>
	            </div> 
	            
	            <div>
	            	
				</div>
				
				<div>
					<input type="file" id="realInput" name="myAskImg" accept=".jpg, .png" style='display:none'>
		            <input type="button" value="이미지 등록" id="browseBtn" class="basicBtn">
		            <input type="submit" value="글등록" id="successbtn" class="basicBtn">
                </div>
                
            </form>
        </section>
        </center>   
		<jsp:include page="../../common/footer.jsp" />
		</div>