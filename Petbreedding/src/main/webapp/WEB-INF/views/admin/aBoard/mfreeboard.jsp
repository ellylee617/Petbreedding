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
<link href="${path}/resources/css/admin/mAside.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/admin/aBoard/mfreeboard.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
		<section class="section">
			<jsp:include page="../mAside.jsp" />
			<div class="mContent">
				<div class="mboardhead">
					<div class="myboardhead">
						<h1>자유게시판</h1>
						<table class="myboard">
							<thead>
								<tr>
									<th scope="cols" width="200px"><input type="checkbox"
										value='selectall' onclick='selectAll(this)'>전체선택</th>
									<th scope="cols" width="1000px">제목</th>
									<th scope="cols" width="1000px">내용</th>
									<th scope="cols" width="200px">조회수</th>
								</tr>
							</thead>
							<tbody>
								<tr class="checkTR">
									<td class="inputBox"><input type="checkbox" name="board"></td>
									<td>살찌면 뒷목살도 접히나요?</td>
									<td>저희 강아지가 뒷목살이 접히는데..</td>
									<td>3</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="myboardrow">
						<button class="basicBtn" id="basicBtn">
							<a href="#">삭제</a>
						</button>
					</div>
					<div class="page_wrap">
						<div class="page_nation">
							<a class="arrow prev" href="#">이전</a> <a href="#" class="active">1</a>
							<a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a>
							<a href="#">6</a> <a href="#">7</a> <a href="#">8</a> <a href="#">9</a>
							<a href="#">10</a> <a class="arrow next" href="#">다음</a>
						</div>
					</div>
				</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
<%-- 	<script src="${path}/resources/js/user/uBoard/service.js"></script> --%>
</body>
</html>
