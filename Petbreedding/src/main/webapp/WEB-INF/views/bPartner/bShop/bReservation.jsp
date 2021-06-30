<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/bPartner/bShop/bReservation.css"
	rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link href="${path}/resources/css/user/uShop/datepicker.css"
	rel="stylesheet" type="text/css">
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
			<jsp:include page="../bAside.jsp" />
			<div class="bContent">
				<div id="calendar_box">
					<div class="calendar" id="calendar">
						<input type="text" name="res_date" id="choDate" value="선택날짜"
							onchange="change()">
					</div>
					<div class="resBox">
						<select id="resselect" onchange="change()">
							<option value="3" name="res_status">전체</option>
							<option value="0" name="res_status">예약완료</option>
							<option value="1" name="res_status">결제완료</option>
							<option value="2" name="res_status">결제취소</option>
						</select>

						<hr>
						<div class="resList">
							<table>
								<!-- tr forEach -->
								<input type="text" value="${bP.bp_Id}" id="bp_id" />
									<table id="revtable">
										<c:forEach var="rev" items="${list }">
											<tr>
												<c:choose>
													<c:when test="${rev.res_status == 0}">
														<td class="status" id ="status">예약완료<span class="noneDis">,</span></td>
													</c:when>
													<c:when test="${rev.res_status == 1}">
														<td class="status">결제완료<span class="noneDis">,</span></td>
													</c:when>
													<c:when test="${rev.res_status == 2}">
														<td class="status">결제취소<span class="noneDis">,</span></td>
													</c:when>
												</c:choose>
												<td class="resTime">${rev.res_date}</td>
												<td class="resName">${rev.name}</td>
												<td class="resInfo"><a href="#">상세보기</a></td>
											</tr>
										</c:forEach>
									</table>
								</div>
						</div>
					</div>
		</section>

		<jsp:include page="../../common/footer.jsp" />
	</div>

	<!-- script -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript"
		src="${path}/resources/js/bPartner/bAside.js"></script>
	<script type="text/javascript"
		src="${path}/resources/js/bPartner/bShop/bReservation.js"></script>
	<script type="text/javascript"
		src="${path}/resources/js/user/uShop/resCalendar.js"></script>
</body>
</body>
</html>