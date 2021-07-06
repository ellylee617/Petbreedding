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
<link href="${path}/resources/css/common//main.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
	<div class="container">
        <video  class="containerV" width="100%" height="auto" autoplay loop muted controls>
            <source src="${path}/resources/video/dog1.mp4" type="video/mp4">대체 텍스트
        </video>
		
    </div>
	<div class="wrapper">    
		<jsp:include page="header.jsp" />
		<section class="section">
           <div class="tabmenu">
               <ul>
                   <li id="tab1" class="btnCon">
                       <input type="radio" name="tabmenu" checked id="tabmenu1" class="Tmenu">
                       <label for="tabmenu1">동물병원</label>
                        <div class="tabCon">
                            <p class="nowLoc">경기도 고양시 <a href="#"><i class="fas fa-map-marker-alt loc"></i></a></p>
                            <input type="text" class="tabInput" placeholder="찾으시는 동물병원을 입력해주세요.">
                            <button class="searchB"><i class="fas fa-search SRB"></i></button>
                        </div>
                    </li>
                   <li id="tab2" class="btnCon">
                       <input type="radio" name="tabmenu" id="tabmenu2"  class="Tmenu">
                       <label for="tabmenu2">미용실</label>
                        <div class="tabCon">
                             <p class="nowLoc">경기도 고양시 <a href="#"><i class="fas fa-map-marker-alt loc"></i></a></p>
                             <form action="shopList" method="get">
                             <input name="keyword" type="text" class="tabInput" placeholder="찾으시는 미용실을 입력해주세요.">
                             <input name="shopType" type="hidden" value="0"/>
                             <button type="submit" class="searchB"><i class="fas fa-search SRB"></i></button>
                             </form>
                        </div>  
                    </li>
               </ul>
           </div>
        </section>
        <footer class="footer">
		    <div class="footMenu">
		        <ul>
		            <li><a href="Uinfo.html">펫브리띵 소개</a></li>
		            <li><a href="#">이용약관</a></li>
		            <li><a href="#">개인정보취급방침</a></li>
		            <li><a href="business.html">제휴문의</a></li>
		            <li><a href="UcustomerService">공지사항</a></li>
		            <li><a href="UQnA.html">자주묻는질문</a></li>
		        </ul>
	    	</div>
		   <div class="footMenu2">
		        <p>(주)펫브리띵</p>
		        <p>서울특별시 중구 남대문로 120 대일빌딩 2F, 3F</p>
		        <p>사업자등록번호 : 123-01-12345</p>
		        <p>Copyright &COPY; 2021 Petverything Institute All Right Reserved</p>
		    </div>
		</footer>
	</div>
</body>
</html>