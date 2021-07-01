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
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uMyPage/myzzim.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../../common/header.jsp" />
	 <section class="section">
	 <jsp:include page="../myPageAside.jsp"/>
	 <input type="hidden" id="cl_num" value="${client.cl_num}">
	 <div class="myzzimhead">
        <h1>찜 목록</h1>
        <div class="zzimlist">
        	<c:if test="${empty likes}">
        		<div class="subdiv">
        			<h1 id="notice">찜한 매장이 없습니다.</h1>
		        </div>
        	</c:if>
        	<c:if test="${!empty likes}">
        	<c:forEach items="${likes}" var="likes">
        		<c:if test="${likes.bp_type eq 0 }">
        			<input type="hidden" class="har_num" value="${likes.har_num}">
        			<a href="shopPage?bpId=${likes.hairSalon.bpId }&shopType=${likes.bp_type}&y=${likes.hairSalon.y }&x=${likes.hairSalon.x }">
	   	           	<div class="subdiv">
		                <div class="img">
		                	<img src="${path}/resources/uploadFile/shop/${likes.har_img }" style="width:200px; height: 100px;">
		                </div>
		                <div class="title">
			                <h1>${likes.hairSalon.shopName }</h1><br>
			                <p>${likes.hairSalon.shopMInfo }</p> 
			            </div>
		                <div class="zzimdel">
		                    <button id="zzimdelBtn" class="basicBtn" onclick="cutZzim()">찜 해제</button>
		                </div>
		           </div>
		           </a>
	            </c:if>
	            <c:if test="${likes.bp_type eq 1 }">
	            	<input type="hidden" class="hos_num" value="${likes.hos_num}">
        			<a href="shopPage?bpId=${likes.hospital.bpId }&shopType=${likes.bp_type}&y=${likes.hairSalon.y }&x=${likes.hairSalon.x }">
	   	           	<div class="subdiv">
		                <div class="img">
		                	<img src="${path}/resources/uploadFile/shop/${likes.har_img }" style="width:200px; height: 100px;">
		                </div>
		                <div class="title">
			                <h1>${likes.hairSalon.shopName }</h1><br>
			                <p>${likes.hairSalon.shopMInfo }</p> 
			            </div>
		                <div class="zzimdel">
		                    <button id="zzimdelBtn" class="basicBtn" onclick="cutZzim()">찜 해제</button>
		                </div>
		           </div>
		           </a>
	            </c:if>
        	</c:forEach>
        	</c:if>
        </div>
        <div class="myzzimrow">
            <button class="basicBtn" id="moreBtn"> 더보기</button>
        </div>
        </div>
	 </section>
	<jsp:include page="../../common/footer.jsp" />
	<script type="text/javascript">
		console.log("로딩");
		var qnaNum = 'Q10';
		console.log(qnaNum);
		maCommentInit(qnaNum);
		
		function maCommentInit(qnaNum){
			console.log("함수 진입");
		}
	
	</script>
	<!-- script -->
    <script src="${path}/resources/js/user/uMyPage/myzzim.js"></script>
	</div>
</body>
</html>
	
	
	