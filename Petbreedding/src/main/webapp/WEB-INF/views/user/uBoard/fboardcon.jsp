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
					<div class="writer">작성자 : ${board.clNickName}</div>
					<div class="regdate">작성일 : ${board.boDate}</div>
					<div class="count">조회수: ${board.boView}</div>
					
			</div>


			<div class="bcon">

			<!-- 이미지는 bo_cont 안에도 이미 포함되어 있으므로 img를 불러올 필요 없음 -->
						
				<div class="con">
				
					<p>${board.boCont}</p>

					<button class="backbtn basicBtn" onClick="location.href='fboardlist'">목록</button>
					<form id="boUpdFrm">
						<button id="fboardUpdBtn" class="modifybtn basicBtn">수정</button>
						<input type="hidden" name="boUpdBoNum" value="${board.boNum}">
						<input type="hidden" name="boUpdBoTitle" value="${board.boTitle}">
						<!-- board.boCont 안에 html 태그가 있어서 화면에 표시되는듯 -->
						<input type="hidden" name="boUpdBoCont" value="${board.boCont}">
					</form>
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
		
		<!-- MODAL POSTING -->
		 <div id="my_modal">
		    <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
		    <div id="locCon">
		        <h1>삭제하시겠습니까?</h1>
		        <button id="goTOPay" name="${board.boNum}">바로 삭제할게요</button>
		        <button id="nextTime">다음에 할게요</button>
		    </div>
		</div>
		
		
		<!-- MODAL COMMENT -->
		<div id="my_modal_comment">
		   <a class="modal_close_btn" id="closeModalBtn"><i class="fas fa-times" id="closeBtnComment"></i></a>
		   <div id="locCon_comment">
		       <h1>삭제하시겠습니까?</h1>
		       <button id="goTOPay_comment">바로 삭제할게요</button>
		        <button id="nextTime_comment">다음에 할게요</button>
		        <input type="hidden" id="coIdVar">
		    </div>
		</div>
		
		<!-- MODAL COMMENT UPDATE -->
		<div id="my_modal_updComment">
			<a class="modal_close_btn" id="closeModalBtn"><i class="fas fa-times" id="closeBtnUpdComment"></i></a>
			<div id="locCon_updComment">
				<h1 class="bocUpdTitle">수정하시겠습니까?</h1>
				<input type="text" id="replyUpdCont" name="getBocCont">
				<button id="goTOPay_updComment">바로 수정할게요</button>
				<button id="nextTime_updComment">다음에 할게요</button>
				<input type="hidden" id="coIdVar">
		    </div>
		</div>

	</div>
	
	<script type="text/javascript">
		var boNum = '${board.boNum}';
		var closeBtn = $("#closeModalBtn");
		
		//	TODO	세션 고객 번호랑 댓글 고객 번호가 같으면 수정, 삭제 표시 -----------------------------------------------------------------------------------------------   
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
					var bocMoal = "";
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
								+ "<p name='"+item.coNum+"' class='fboCommentUpdBtn'>수정</p>"
								+ "<p id='"+item.coNum+"' class='fboCommentDelBtn'>삭제</p>"
								+ "</div>"
								+ "</div>"
								+ "</div>";
								
						});
						
					} else {
						
					}
					
					$("#replyContainer").html(div);
					
					//	댓글 삭제 버튼 클릭
					$(".fboCommentDelBtn").click(function() {
						console.log("댓글 삭제 클릭 됨")
						var coIdVar = $(this).attr("id");	//	클릭된 행의 id
						$("#goTOPay_comment").attr("name", coIdVar);
						getCommentModal();
					});
					
					//	댓글 수정 버튼 클릭
					$(".fboCommentUpdBtn").click(function() {
						console.log("댓글 수정 클릭 됨")
						var coIdVar = $(this).attr("name");	//	클릭된 행의 id
						console.log(coIdVar);
						$("#goTOPay_updComment").attr("name", coIdVar);
						getUpdCommentModal();
					});
					
					
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
		
		
		$("#goTOPay_comment").bind("click", function() {
			var CoNumVar = $(this).attr("name");
			console.log(CoNumVar);
			
			$.ajax({
				url: "bcdelete"
				,type: "get"
				,data: {co_num : CoNumVar, bo_num : boNum}
				,success: function() {
					commentListInit(boNum);
				}
				,error : function(request, status, error) {
					alert("code: " + request.status + "\n"
							+ "message: "
							+ request.responseText + "\n"
							+ "error: " + error);
				}
			});
			
			// TODO	삭제 버튼 클릭하면 모달창 자동 닫기 기능 해야함 (지금 동작 X)
			closeModal();

		});
		
		
		//	자유 게시판 댓글 수정
		$("#goTOPay_updComment").bind("click", function() {
			var CoNumVar = $(this).attr("name");
			var updContText = $("#replyUpdCont").val();
			console.log(CoNumVar);
			
			$.ajax({
				url: "bcupdate"
				,type: "get"
				,data: {co_num : CoNumVar, contVal : updContText}
				,success: function() {
					$("#replyUpdCont").val("");
					commentListInit(boNum);
					
				}
				,error : function(request, status, error) {
					alert("code: " + request.status + "\n"
							+ "message: "
							+ request.responseText + "\n"
							+ "error: " + error);
				}
			});
			
			// TODO	삭제 버튼 클릭하면 모달창 자동 닫기 기능 해야함 (지금 동작 X)
			closeModal();

		});
		
		// TODO	삭제 버튼 클릭하면 모달창 자동 닫기 기능 해야함 (지금 동작 X)
	    function closeModal() {
	    	console.log("닫기 버튼 함수 들어옴")
	    	closeBtn.click();
	    }
		
	</script>
	
	<script type="text/javascript" src="${path}/resources/js/user/uBoard/fboardcon.js"></script>
</body>
</html>