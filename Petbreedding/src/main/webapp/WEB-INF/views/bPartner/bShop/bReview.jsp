<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link type="text/css" rel="stylesheet"	href="${path}/resources/css/common/reset.css">
<link type="text/css" rel="stylesheet"	href="${path}/resources/css/bPartner/bheader.css">
<link type="text/css" rel="stylesheet"	href="${path}/resources/css/common/footer.css">
<link type="text/css" rel="stylesheet"	href="${path}/resources/css/bPartner/bAside.css">
<link type="text/css" rel="stylesheet"	href="${path}/resources/css/bPartner/bShop/bReview.css">
<link	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css"	rel="stylesheet" />
<script src="https://kit.fontawesome.com/aca84cf3fb.js"	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
			<jsp:include page="../bAside.jsp" />
			<div class="bContent">
				<h2>리뷰 목록 (총 32개)</h2>
				<br>
				<table>
				
					<tr class="pointline">
						<th>리뷰 번호</th>
						<th>상품명</th>
						<th>구매자 평점</th>
						<th>리뷰내용</th>
					</tr>
					
					<c:forEach items="${brvList}" var="brItems">
						<tr class="pointline">
							<td>${brItems.revNum}</td>
							<td>가위컷</td>
							<c:choose>
								<c:when test="${brItems.revVal eq 1}">
									<td><img src="${path}/resources/images/1.png"></td>
								</c:when>
								<c:when test="${brItems.revVal eq 2}">
									<td><img src="${path}/resources/images/2.png"></td>
								</c:when>
								<c:when test="${brItems.revVal eq 3}">
									<td><img src="${path}/resources/images/3.png"></td>
								</c:when>
								<c:when test="${brItems.revVal eq 4}">
									<td><img src="${path}/resources/images/4.png"></td>
								</c:when>
								<c:when test="${brItems.revVal eq 5}">
									<td><img src="${path}/resources/images/5.png"></td>
								</c:when>
								<c:otherwise>
									
								</c:otherwise>
							</c:choose>
							
							<td>${brItems.revCont}</td>
							
							<c:if test="${brItems.comntChk eq 0}">
								<td><button class="basicBtn btnReply" name="${brItems.revNum}" id="${brItems.bpId}">답글쓰기</button></td>
							</c:if>
							<c:if test="${brItems.comntChk eq 1}">
								<td><button class="basicBtn btnReCom">작성완료</button></td>
							</c:if>
						</tr>
					</c:forEach>
					
				</table>
				<br> <br>
				<div class="page_wrap">
					<div class="page_nation">
						<a class="arrow prev" href="#">이전</a> <a href="#" class="active">4</a>
						<a href="#">5</a> <a href="#">6</a> <a href="#">7</a> <a href="#">8</a>
						<a class="arrow next" href="#">다음</a>
					</div>
				</div>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
	<!-- 리뷰 답글 작성 모달창 -->
	<div id="modalReply" class="modalRe-Overlay">
		<div id="modalReply-Win">
			<div class="Retitle">
				<div id="modalTitle">리뷰 상세 보기</div>
				<a class="modal_close_btn"><i class="fas fa-times fa-lg"></i></a>
			</div>
			<div class="reviewsection" id="reviewsection">
			</div>
			<div class="wrapbtn">
				<button class="basicBtn">이전 리뷰</button>
				<button class="basicBtn btnnext">다음 리뷰</button>
			</div>
			<br>
		</div>
	</div>
	<!-- 모달 끝! -->
	<script type="text/javascript">
	var modal = document.getElementById("modalReply");
	var modalReWin = document.getElementById("modalReply-Win");
	var btnReply = document.querySelectorAll(".btnReply");
	var closeBtn = modal.querySelector(".modal_close_btn")
	var path = '${pageContext.request.contextPath}';
	
// 	for (var i = 0; i < btnReply.length; i++) {
// 		btnReply[i].addEventListener("click", function() {
// 			var bpId = $(this).attr("id");
// 			console.log(bpId);
// 			console.log(path);
			
// 			modalInit(bpId, path);
			
// 			modal.style.display = "flex";
// 		});
// 	}

	$(".btnReply").on("click", function() {
		var revNum = $(this).attr("name");
		console.log(revNum);
		console.log(path);
		modalInit(revNum, path);
		modal.style.display = "flex";
	});

	
// 	<div id="modalRetxt">
// 		<img class="txtImg" src="${path}/resources/images/5.png">&nbsp;&nbsp;4.0
// 		<br>
// 		<p id="reTitle">잘 잘라줘요</p>
// 		<br>
// 		<p>또비 언니</p>
// 		<p id="reDate">2021-05-31 방문</p>
// 	</div>
// 	<div id="modalReImg">
// 		<img id="modalReImg" src="http://ipsumimage.appspot.com/100x100">
// 	</div>
// 	<br>
// 	<br> <span>판매자 답글 작성</span>
// 	<form id="brevRegFrm">
// 		<div class="replysection">
// 			<div class="wraptextarea">
// 				<textarea name="revcCont" rows="4" cols="35"></textarea>
// 			</div>
// 			<button id="brevRegBtn" class="basicBtn brevRegBtn">답글 작성</button>
// 			<input type="hidden" id="revNumVal" name="revNumVal">
// 			<input type="hidden" id="revBpIdVal" name="revBpIdVal">
// 		</div>
// 	</form>
	
	
	function modalInit(revNum, path) {
		$.ajax({
			url: "brmodal"
			,type: "post"
			,data: {rev_num : revNum}
			,dataType: 'json'
			,success: function(data) {
					console.log(data);
					if(data != null) {
						var div = "";
						
						div += "<div id='modalRetxt'>"
							+ "<img class='txtImg' src='"+path+"/resources/images/5.png'>&nbsp;&nbsp;"+data.revVal+".0"
							+ "<br>"
							+ "<p id='reTitle'>"+data.revCont+"</p>"
							+ "<br>"
							+ "<p>"+data.clNickName+"</p>"
							+ "<p id='reDate'>"+data.revDate+" 방문</p>"
							+ "</div>"
							+ "<div id='modalReImg'>"
							+ "<img id='modalReImg' src='http://ipsumimage.appspot.com/100x100'>"
							+ "</div>"
							+ "<br>"
							+ "<br>"
							+ "<span>판매자 답글 작성</span>"
							+ "<form id='brevRegFrm'>"
							+ "<div class='replysection'>"
							+ "<div class='wraptextarea'>"
							+ "<textarea name='revcCont' rows='4' cols='35'></textarea>"
							+ "</div>"
							+ "<button id='brevRegBtn' class='basicBtn brevRegBtn'>답글 작성</button>"
							+ "<input type='hidden' name='revNumVal' value="+data.revNum+">"
							+ "<input type='hidden' name='revBpIdVal' value="+data.bpId+">"
							+ "</div>"
							+ "</form>";
							
						$("#reviewsection").html(div);
						
					} else {
						
						div += "데이터가 없습니다";
						$("#reviewsection").html(div);
						
					}
			}
			,error : function(request, status, error) {
				alert("code: " + request.status + "\n"
						+ "message: "
						+ request.responseText + "\n"
						+ "error: " + error);
			}
			
		});
	}
	
	closeBtn.addEventListener("click", function() {
		modal.style.display = "none";
	});
	</script>
	
	<script src="${path}/resources/js/bPartner/bShop/bReview.js"></script>
</body>
</html>