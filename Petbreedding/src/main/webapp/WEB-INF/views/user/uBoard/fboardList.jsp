<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uBoard/freeboard.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
	<div class="wrapper">    
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
           
	    	<div class="bheader">
	        <h1>자유게시판</h1>
	            <div class="search-box">
	            <input type="text" class="search-txt" name="#" placeholder="Type to search">
	            <a class="search-btn" href="#">
	              <i class="fas fa-search"></i>
	            </a>
	        </div><br><br>
	        <!-- <form action="qnalist" method="get">
	            
				<select id="searchType" name="searchType">
					<option value="1">전체</option>
					<option value="2">작성자</option>
					<option value="3">글내용</option>
				</select> <input type='search' id="search" name="search"
					placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp질문을 검색하세요.">
				<button type=submit id="btnsearch"> <i class="fas fa-search"></i></button>
	           
			</form> -->
	        </div>
	        
			<c:if test="${listCount eq 0}">
				<h1>게시글이 없습니다.</h1>
			</c:if>
			
			<c:if test="${listCount ne 0}">
				
				<div class="write">
				   <button class="writebtn basicBtn"><a href="">글쓰기</a></button>
				</div>  
				<c:forEach items="${boardList }" var="blist">
					<div class="boardlist">
		            	<div class="subdiv">
		            		
		            		<c:choose>
		            			<c:when test="${blist.boImg eq null}">
			            	    	<div class="img"><a href="#"><img class="imgSize" src="http://placehold.it/150x100"  alt="boardimg"></a></div>
			            	    </c:when>
		            			<c:otherwise>
			            	    	<div class="img"><a href="#"><img class="imgSize" src="${path}/resources/uploadFile/review/${blist.boImg}"  alt="boardimg"></a></div>
			            	    </c:otherwise>	
			                </c:choose>
			                <div class="title">
			                <a href="fboardcon?boNum=${blist.boNum}">
			                <p>${blist.boCont}(10)</p>
			                </a>
			                </div>
			                <div class="writer"><a href="fboardcon">${blist.clNickName}</a></div>
			                <div class="regdate"><a href="fboardcon">${blist.boDate}</a></div>
			                <div class="count"><a href="fboardcon">${blist.boView}</a></div>
		                </div>
		                
		            </div>
				</c:forEach>
			
			</c:if>
			
			 <!-- 앞 페이지 번호 처리 -->
			 	<div class="page_wrap">
			 		<div class="page_nation">
			 		
			 			<c:set var="firstPage" value=""/>
					 	<c:if test="${currentPage <= 1}">
					 		<span class="arrow prev">이전</span>
					 		<span class="active">1</span>
						</c:if>
						
						<c:if test="${currentPage > 1}">
							<c:url var="blistST" value="fboardlist">
								<c:param name="page" value="${currentPage-1}" />
							</c:url>
							<a class="arrow prev" href="${blistST}">이전</a>
						</c:if>
						
						<!-- 끝 페이지 번호 처리 -->
						<c:set var="endPage" value="${maxPage}" />
						<c:forEach var="p" begin="${startPage+1}" end="${endPage}">
						
							<c:if test="${p eq currentPage}">
								${p}
							</c:if>
							
							<c:if test="${p ne currentPage}">
								<c:url var="blistchk" value="fboardlist">
									<c:param name="page" value="${p}" />
								</c:url>
								<a href="${blistchk}">${p}</a>
							</c:if>
						</c:forEach>
						
						<c:if test="${currentPage >= maxPage}">
							<span class="active">2</span>
							<span class="arrow next">다음</span>
						</c:if>
						
						<c:if test="${currentPage < maxPage}">
							<c:url var="blistEND" value="fboardlist">
								<c:param name="page" value="${currentPage+1}" />
							</c:url>
							<a class="arrow next" href="${blistEND}">다음</a>
						</c:if>
					</div>	
				</div>
			 	
			
	       	
				          
				<!-- 
				<div class="page_wrap">
				    <div class="page_nation">
				       <a class="arrow prev" href="#">이전</a>
				       <a href="#" class="active">1</a>
				       <a href="#">2</a>
				       <a href="#">3</a>
				       <a href="#">4</a>
				       <a href="#">5</a>
				       <a href="#">6</a>
				       <a href="#">7</a>
				       <a href="#">8</a>
				       <a href="#">9</a>
				       <a href="#">10</a>
				       <a class="arrow next" href="#">다음</a>
				    </div>
				 </div>
				  -->
	                
             
			</section>
		<jsp:include page="../../common/footer.jsp" />
    </div>
</body>
</html>