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
							<td><img src="${brItems.revImg}"></td>
							<td>${brItems.revCont}</td>
							<td><button class="basicBtn btnReply">답글쓰기</button></td>
						</tr>
					</c:forEach>
					
					<tr class="pointline">
						<td>32</td>
						<td>가위컷</td>
						<td><img src="${path}/resources/images/4.png"></td>
						<td>첨 이용했는데 가볼만한 곳...</td>
						<td><button class="basicBtn btnReply">답글쓰기</button></td>
					</tr>
					<tr class="pointline">
						<td>31</td>
						<td>가위컷</td>
						<td><img src="${path}/resources/images/4.png"></td>
						<td>첨 이용했는데 가볼만한 곳...</td>
						<td><button class="basicBtn btnReply">답글쓰기</button></td>
					</tr>
					<tr class="pointline">
						<td>30</td>
						<td>가위컷</td>
						<td><img src="${path}/resources/images/4.png"></td>
						<td>첨 이용했는데 가볼만한 곳...</td>
						<td><button class="basicBtn btnReply">답글쓰기</button></td>
					</tr>
					<tr class="pointline">
						<td>29</td>
						<td>가위컷</td>
						<td><img src="${path}/resources/images/4.png"></td>
						<td>첨 이용했는데 가볼만한 곳...</td>
						<td><button class="basicBtn btnReply">답글쓰기</button></td>
					</tr>
					<tr class="pointline">
						<td>28</td>
						<td>가위컷</td>
						<td><img src="${path}/resources/images/4.png"></td>
						<td>첨 이용했는데 가볼만한 곳...</td>
						<td><button class="basicBtn btnReCom">작성완료</button></td>
					</tr>
					<tr class="pointline">
						<td>27</td>
						<td>가위컷</td>
						<td><img src="${path}/resources/images/4.png"></td>
						<td>첨 이용했는데 가볼만한 곳...</td>
						<td><button class="basicBtn btnReCom">작성완료</button></td>
					</tr>
					<tr class="pointline">
						<td>26</td>
						<td>가위컷</td>
						<td><img src="${path}/resources/images/4.png"></td>
						<td>첨 이용했는데 가볼만한 곳...</td>
						<td><button class="basicBtn btnReCom">작성완료</button></td>
					</tr>
					<tr class="pointline">
						<td>25</td>
						<td>가위컷</td>
						<td><img src="${path}/resources/images/4.png"></td>
						<td>첨 이용했는데 가볼만한 곳...</td>
						<td><button class="basicBtn btnReCom">작성완료</button></td>
					</tr>
					<tr class="pointline">
						<td>24</td>
						<td>가위컷</td>
						<td><img src="${path}/resources/images/4.png"></td>
						<td>첨 이용했는데 가볼만한 곳...</td>
						<td><button class="basicBtn btnReCom">작성완료</button></td>
					</tr>
					<tr class="pointline">
						<td>23</td>
						<td>가위컷</td>
						<td><img src="${path}/resources/images/4.png"></td>
						<td>첨 이용했는데 가볼만한 곳...</td>
						<td><button class="basicBtn btnReCom">작성완료</button></td>
					</tr>
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
			<div class="reviewsection">
				<div id="modalRetxt">
					<img class="txtImg" src="${path}/resources/images/5.png">&nbsp;&nbsp;4.0
					<br>
					<p id="reTitle">잘 잘라줘요</p>
					<br>
					<p>또비 언니</p>
					<p id="reDate">2021-05-31 방문</p>
				</div>
				<div id="modalReImg">
					<img id="modalReImg" src="http://ipsumimage.appspot.com/100x100">
				</div>
				<br>
				<br> <span>판매자 답글 작성</span>
				<div class="replysection">
					<div class="wraptextarea">
						<textarea name="reply" rows="4" cols="35"></textarea>
					</div>
					<button class="basicBtn btnReply">답글 작성</button>
				</div>
			</div>
			<div class="wrapbtn">
				<button class="basicBtn">이전 리뷰</button>
				<button class="basicBtn btnnext">다음 리뷰</button>
			</div>
			<br>
		</div>
	</div>
	<!-- 모달 끝! -->
	<script src="${path}/resources/js/bPartner/bShop/bReview.js"></script>
</body>
</html>