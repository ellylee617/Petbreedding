<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/introduce.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
</head>
<body>
	<div class="wrapper">    
		<jsp:include page="header.jsp" />
		<section class="section">
           <div id="content">
           		<div class="con" id="petbreedding">
           			<img src="${path}/resources/images/logo.png">
           			<h1>반려동물 병원, 미용실 예약 플랫폼 '펫브리띵'입니다.</h1>
           		</div>
       			<div class="con" id="petIntro">
           			<h1>기획 목적</h1>
           			<p>동물병원, 애견미용샵 등의 서비스를 제공하는 플랫폼들이 파편화되어 있습니다.</p>
           			<p>그로인해, 사용자들이 이곳 저곳 찾아서 예약하고 정보를 찾아야하는 불편함이 있습니다.</p>
           			<p>그래서 자주 이용하는 병원 및 미용서비스를 한 곳에서 예약할 수 있는 플랫폼을 만들고 싶었습니다.</p>
           		</div>
		        <div class="con" id="petIntro">
           			<h1>설계의 주안점</h1>
           			<p>첫번째, </p>
           			<p>두번째, </p>
           			<p>세번째, </p>
           		</div>
           		<div class="con"  id="dev">
           			<h1>만든 이</h1>
           			<div id="mem1">
           				<div class="member">
           					<p>곽서현(조장)</p>
           					<img src="${path}/resources/images/서현.png">
           					<p></p>
           				</div>
           				<div class="member">
           					<p>김세훈</p>
           					<img src="${path}/resources/images/세훈.jpg">
      					</div>
           				<div class="member">
           					<p>유해니</p>
           					<img src="${path}/resources/images/해니.png">
           				</div>
           			</div>
        			<div id="mem2">
           				<div class="member">
           					<p>이승연</p>
           					<img src="${path}/resources/images/승연.png">
           				</div>
           				<div class="member">
           					<p>이은혜</p>
           					<img src="${path}/resources/images/은혜.png">
           				</div>
           			</div>
           		</div>
           </div>
        </section>
        <jsp:include page="footer.jsp" />
	</div>
	<script type="text/javascript">
	var animation = function () {
		  var items, winH;
		 
		  var initModule = function () {
		    items = document.querySelectorAll(".con");
		    winH = window.innerHeight;
		    _addEventHandlers();
		  }
		 
		  var _addEventHandlers = function () {
		    window.addEventListener("scroll", _checkPosition);
		    window.addEventListener("load", _checkPosition);
		    window.addEventListener("resize", initModule);
		  };
		 
		  var _checkPosition = function () {
		    for (var i = 0; i < items.length; i++) {
		      var posFromTop = items[i].getBoundingClientRect().top;
		      if (winH > posFromTop) {
		        items[i].classList.add("active");
		      }
		    }
		  }
		 
		  return {
		    init: initModule
		  }
		}
		 
		animation().init();
	</script>
</body>
</html>