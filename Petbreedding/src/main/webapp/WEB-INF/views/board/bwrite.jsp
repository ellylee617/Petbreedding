<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/board/qna.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../header.jsp" />
		 <center>
        <section class="section">
            	<h1>1:1문의 작성</h1>
            	
                <div class="qnatitle">
               
                    
                   <input type="text" name="#" placeholder="글 제목을 입력해주세요">
                   
                </div>
            <div class="qnacontent">
              
                <textarea placeholder="1:1문의내용을 작성해주세요"></textarea>

            </div> 


            <input type="submit" value="취소" id="successbtn" onclick="#" class="basicBtn">
            <input type="submit" value="글등록" id="successbtn" class="basicBtn">
                
            
        </section>
        </center>   
		<jsp:include page="../footer.jsp" />
		</div>