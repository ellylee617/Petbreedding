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
<link href="${path}/resources/css/admin/aBoard/mboard.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../mheader.jsp" />
		<section class="section" id="mboardSection">
			<jsp:include page="../mAside.jsp"/>
			<div class="mContent">
		        <div class="conhead">
			       	<c:choose>
						<c:when test="${mAsk.qnaType eq 1}">
						<p>[회원]</p>
						</c:when>
						<c:otherwise>
						<p>[사업자]</p>
						</c:otherwise>
					</c:choose>
					<p>${mAsk.qnaCont}</p>
					<p>작성자 : ${mAsk.qnaWr}</p>
					<p>작성일 : ${mAsk.qnaDate}</p>
				</div>
				
				<div class="conimg">
					<c:choose>
						<c:when test="${mAsk.qnaImg eq null}">
						    <img src="http://placehold.it/400x300">
						</c:when>
						<c:otherwise>
							<img src="${path}/resources/uploadFile/myAsk/${mAsk.qnaImg}">
						</c:otherwise>
					</c:choose>
				</div>
				<div class="conbtn">
				    <button class="basicBtn" id="listBtn">목록</button>
				    <button class="basicBtn" id="delBtn">삭제</button>
				    <button class="basicBtn" id="updeteBtn">수정</button>
				    
				
				</div>
				<div id="replyArea" class="reply">
				</div>
			</div>
		</section>
	<jsp:include page="../../common/footer.jsp" />
	</div>	 
	<script type="text/javascript">
		console.log("스크립트 시작");
		var qnaNum= '${mAsk.qnaNum}';
// 		var a = 'Q1';
// 		console.log(a);
// 		console.log(qnaNum);
		maCommentInit(qnaNum);
		
		function maCommentInit(qnaNum) {
			console.log("조회 함수 들어옴");
// 			var qnaNum = '${MyAsk.qnaNum}';
			console.log(qnaNum);
			$.ajax({
				
				url: 'macList',
				type:'get',
				contentType : "application/json; charset:UTF-8",
				data: {qna_num: qnaNum },
				dataType: 'json',
				success: function(json) {
					var div = "";
					var jsonLength = Object.keys(json).length;
					console.log(json);
					console.log(jsonLength);
					if(jsonLength > 0) {
							$("#maCommentText").hide();
							$("#maCommentBtn").hide();
							
						$.each(json, function(index, item) {
							
							div +=	"<div>"
									+item.qnacCont
									+"</div>"
									+"<form id='maCommentFrm' class='maCommentFrm'>"
									+"<button class='basicBtn' id='maCommentUpBtn'>수정</button>"
									+"<button class='basicBtn' id='maCommentDelBtn'>삭제</button>"
									+"</form>";
						})
					} else {
						div += "<form id='maCommentFrm' class='maCommentFrm'>"
							+"<textarea id='maCommentText' name='maCommentText'></textarea>"
							+"<button class='basicBtn' id='maCommentBtn'>등록</button>"
							+"<input type='hidden' value='"+qnaNum+"' name='qna_num'>"
							+"</form>";
							
					}
					
					$("#replyArea").html(div);
					
					$("#maCommentBtn").click(function() {
						console.log("[세훈] @문의사항 댓글 등록 ajax 들어왔음");
						var queryString = $("#maCommentFrm").serialize();
						console.log(queryString);
						$.ajax({
							url: 'macWrite',
							type: 'post',
							data: queryString,
							success: function(queryString) {
								maCommentInit(queryString.qnaNum);
							},
							
							error : function(request, status, error) {
								alert("code: " + request.status + "\n"
										+ "message: "
										+ request.responseText + "\n"
										+ "error: " + error);
							}
							
						});
					});
					
					},
					
				error : function(request, status, error) {
					alert("code: " + request.status + "\n" + "message: "
							+ request.responseText + "\n" + "error: "
							+ error);
				}
					
					
			});
			
			console.log("함수 댓글 조회 끝");
		}
		

		console.log("스크립트 끝");
	</script>
<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
<script type="text/javascript" src="${path}/resources/js/admin/aBoard/mBoardCon.js"></script>
</body>
</html>