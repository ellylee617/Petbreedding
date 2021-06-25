<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uMyPage/myChatRoom.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
</head>
<body>
	<c:set var="profile" value='<%=session.getAttribute("login")%>' />
	<div class="col-12 row justify-content-center align-items-center my-5 ">
		<img src="${path}/resources/images/logo-resize.png" class="img-fluid" />
	</div>
	<div class="col-12">
		<div class="col-2 list">
			<a href="#">목록</a>
		</div>
		<div class="bpid" >${bpId }</div>
		<div class="closebtn">
			<a href="#" onclick="javascript:top.window.close()">닫기</a>
		</div>
	</div>
	<div class="col-12 bInfo">
		<div class="col-10 bInfoinner">
			업체 정보~
		</div>
	</div>
	<!-- 채팅 내용 -->
	<div class="col-12">
		<div class="col-11" id="chatArea">
			<div id="chatMessageArea">
			<c:if test="${not empty chatlist }">
			<c:forEach items="${chatlist }" var="c" varStatus="status">
				<div class='col-12 row' style = 'height : auto; margin-top : 5px;'>
				<c:if test="${c.cl_num eq c.mSender }">
				<div class='col-2' style = 'float:right; padding-right:0px; padding-left : 0px;'>
				<div style='font-size:9px; display:block;'>${nickName}</div></div><br>
					<div class = 'col-10' style = 'overflow : y ; margin-top : 7px; float:right;'>
					<div class = 'col-12' style = ' background-color:#ACF3FF; padding : 10px 5px; float:left; border-radius:10px;'>
					<span style = 'font-size : 12px;'>
					${c.mContent}</span></div>
					<div col-12 style = 'font-size:9px; text-align:right; clear:both;'><br>
					<div style ='font-size:9px; text-align:right; clear:both' >${c.mSendTime }</div></div>
					</div>
					</div><br><br>
				</c:if>
				<c:if test="${c.cl_num ne c.mSender }">
					<div class='col-2' style = 'float:left; padding-right:0px; padding-left : 0px;'>
					<div style='font-size:9px; display:block;'>${ShopName}</div></div><br>
					<div class = 'col-10' style = 'overflow : y ; margin-top : 7px; float:left;'>
					<div class = 'col-12' style = ' background-color:#ACF3FF; padding : 10px 5px; float:left; border-radius:10px;'>
					<span style = 'font-size : 12px;'>
					${c.mContent}</span></div>
					<div col-12 style = 'font-size:9px; text-align:right; clear:both;'><br>
					<div style ='font-size:9px; text-align:right; clear:both;' >${c.mSendTime }</div></div>
					</div>
					</div><br><br>
				</c:if>
			</c:forEach>
			</c:if>
			<c:if test="${empty chatlist }">
			 대화내용이 없어용
			</c:if>
			</div>
		</div>
	</div>
	<!-- 채팅 입력창 -->
	<div class="col-12 inputchatwrap">
		<div class="col-12 textwrap">
			<textarea class="form-control" placeholder="내용을 입력해주세요" id="message" rows="4" cols="35"></textarea>
			<button type="button" id="sendBtn" class="basicBtn">전송</button>
		</div>
	</div>
</body>
<script type="text/javascript" src="${path}/resources/js/user/uMyPage/myChatRoom.js"></script>
</html>