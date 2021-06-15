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
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bmenu.css" rel="stylesheet" type="text/css" >
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="${path}/resources/js/user/uBoard/service.js"></script>
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../bheader.jsp" />
	 <section class="section">
	 <jsp:include page="../bAside.jsp"/>
	<div class="menuhead">
        <h1>메뉴관리</h1>
    <div class="menucon">
        <button id="addItemBtn" class="basicBtn" onclick="tableCreate()">옵션추가</button>
        <button id="delItemBtn" class="basicBtn" onclick="tableDelete()">옵션삭제</button>
    
    </div>
       <table style="border: 1px;" id="dynamicTable">
        <thead>
        <tr>
        <th width="400">메뉴명</th>
        <th width="400">가격</th>
        <th width="200"></th>
        <th width="200"></th>
        
        </tr>
        </thead>
        <tbody id="dynamicTbody">
            
        </tbody>
        </table>
        </div>
        <div class="insert">
        <input  type="text" placeholder="메뉴" id="menu">
        <input  type="text" placeholder="가격" id="price"> 
      </div>
	
	 </section>
	<jsp:include page="../../common/footer.jsp" />
	</div>	 