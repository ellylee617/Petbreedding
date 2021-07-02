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
<link href="${path}/resources/css/user/uBoard/fboardcont.css" rel="stylesheet" type="text/css">

<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<div class="bheader">

				<c:if test="${empty board}">
					<h1>정보를 찾을 수 없습니다.</h1>
				</c:if>


					<div class="title">
						<p>${board.boTitle}</p>
					</div>												
					<!-- TODO 세션 받아와서 이름 입력 -->
					<div class="writer">작성자 : ${board.clNickName}</div>
					<div class="regdate">작성일 : ${board.boDate}</div>
					<div class="count">조회수: ${board.boView}</div>
					
			</div>


			<div class="bcon">
				
				<div class="img">
				
					<!-- TODO db에 있는 이미지 입력 -->
					<c:choose>
						<c:when test="${board.boImg eq null}">
							<img src="http://placehold.it/500x300" alt="boardconimg">
						</c:when>
						<c:otherwise>
							<img src="${path}/resources/uploadFile/review/${board.boImg}" alt="boardconimg">
						</c:otherwise>
					</c:choose>
				</div>
				
			
				<div class="con">
				
					<p>${board.boCont}</p>

					<button class="backbtn basicBtn" onClick="location.href='fboardlist'">목록</button>
					<button id="fboardUpdBtn" class="modifybtn basicBtn">수정</button>
					<button id="fboardDelBtn" class="delbtn basicBtn">삭제</button>
				
				</div>
			</div>
			<div class="reply">
				<p>댓글(${board.bocChk})</p>
				
				<form id="bocFrm">
					<div class="replycon">
						<input type="text" id="replyCont" name="getBocCont">
						<input type="button" id="bocSubmitBtn" class="basicBtn" value="등록">
						<input type="hidden" value="${board.boNum}" name="getBoNum">
					</div>
				</form>
				<!--AJAX로 댓글 구현 -->
				
				<div id="replyContainer"></div>
				
			</div>

		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
	<script type="text/javascript">
		var boNum = '${board.boNum}';
		var clSession = "<%=session.getAttribute("client") %>";
		console.log(clSession);
		console.log(boNum);
		commentListInit(boNum);	//	로딩이 되면 해당 보드의 댓글을 한 번 초기화 
	
		function commentListInit(boNum) {
			$.ajax({
				url: 'bocList'
				,type: 'get'
				,contentType : "application/json; charset:UTF-8"
				,data: {boNum: boNum}
				,dataType: 'json'
				,success: function(json) {
					var div = "";
					var jsonLength = Object.keys(json).length;
					console.log(json);
					console.log(jsonLength);
					if(jsonLength > 0) {
						
						$.each(json, function(index, item) {
							div += "<div class='replyArea'>"
								+ "<div class='replyUserInfo'>"
								+ "<p class='replyNickName'>"+item.clNickName+"</p>"
								+ "<p>"+item.coCont+"</p>"
								+ "</div>"
								+ "<div>"
								+ "<p class='replyTime'>"+item.coDate+"</p>"
								+ "<div class='replyUpdDel'>"
								+ "<p>수정</p>"
								+ "<p>삭제</p>"
								+ "</div>"
								+ "</div>"
								+ "</div>";
						});
						
					} else {
						
					}
					
					$("#replyContainer").html(div);
					
				}
				
				,error : function(request, status, error) {
					alert("code: " + request.status + "\n"
							+ "message: "
							+ request.responseText + "\n"
							+ "error: " + error);
				}
				
			});
		}
		
		$("#bocSubmitBtn").click(function() {
			var queryString = $("#bocFrm").serialize();
			console.log(queryString);
			
			$.ajax({
				url: 'bocWrite'
				,type: 'post'
				,data: queryString
				,success: function() {
					commentListInit(boNum);
					$("#replyCont").val("").focus();
				}
				,error : function(request, status, error) {
					alert("code: " + request.status + "\n"
							+ "message: "
							+ request.responseText + "\n"
							+ "error: " + error);
				}
				
			});
		});
	</script>
</body>
</html>