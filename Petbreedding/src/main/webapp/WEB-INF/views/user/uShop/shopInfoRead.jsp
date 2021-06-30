<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petverything::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css//user/uShop/shopInfoRead.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- 지도 api -->
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ffd90e8fd83a8d1b7acd8b168a81415f&libraries=services"></script>

<!-- Swiper -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
</head>
<body>
	<div class="wrapper">    
		<jsp:include page="../../common/header.jsp" />
			<section class="section">
            <div class="store_area">
            	<input type="hidden" value="${client.cl_num}" id="cl_num" />
            	<c:if test="${shopType eq 0 }">
            	<input type="hidden" value="${shopInfo.harNum}" id="har_num" />
            	</c:if>
            	<c:if test="${shopType eq 1 }">
            	<input type="hidden" value="${shopInfo.hosNum}" id="hos_num" />
            	</c:if>
            <!-- 매장 타입이 0이면 미용실 -->
            <!-- 매장 타입이 1이면 동물병원 -->

                <div class="store_info_article">
                	<c:forEach var="shopImgList" items="${shopImgList }" varStatus="status">
                    <div class="store_img">
                        <img src="${path}/resources/uploadFile/shop/${shopImgList.shopImg }" style="width:400px; height: 400px">
                    </div>
                    </c:forEach>
                    <div class="store_name">
                        <h1>${shopInfo.shopName }</h1>
                    </div>
                    <div class="store_tel"><i class="fas fa-phone-alt"></i><span>${shopInfo.shopTel }</span></div>
                    <div class="store_info">
                        <p>${shopInfo.shopMInfo }</p>
                    </div>
                    <div class="store_btn">
                        <a href="#" id="goChat" class="sBtn">문의하기</a>
                        <c:if test="${empty client }">
                        	<a href="${path}/uLogin" id="goRev" class="sBtn" >예약하기</a>
                        </c:if>
						<c:if test="${!empty client }">
                        	<c:if test="${shopType eq 0 }">
		                       <a href="${path}/shopReservation?har_num=${shopInfo.harNum}&&cl_num=${client.cl_num}" id="goRev" class="sBtn" >예약하기</a>                                            	
                        	</c:if>
							<c:if test="${shopType eq 1 }">
		                       <a href="${path}/shopReservation?har_num=${shopInfo.hosNum}&&cl_num=${client.cl_num}" id="goRev" class="sBtn" >예약하기</a>                                            	
                        	</c:if>
                        </c:if>
                        <c:if test="${empty client }">
                        	<a id="zzim" onclick="noCLient()">
	                        	<i class="far fa-heart" id="heartOff"></i>
	                        	<i class="fas fa-heart" id="heartOn"></i>
                        	</a>
                        </c:if>
                        <c:if test="${!empty client }">
                        	<c:if test="${shopType eq 0 }">
	                        	<c:forEach items="${zzim }" var="zzim">
	                        		<c:if test="${!empty zzim}">
	                        			<c:if test="${zzim.har_num == shopInfo.harNum && zzim.cl_num == client.cl_num}">
		                        		<a id="zzim">
		                        			<i class="far fa-heart" id="heartOff" style="display : none;"></i>
		                        			<i class="fas fa-heart" id="heartOn" style=" display : inline-block; color : var(--hover-color)"></i>
		                        		</a>
			                        	</c:if>
			                        	<c:if test="${zzim.har_num != shopInfo.harNum && zzim.cl_num != client.cl_num}">
					                        <a id="zzim">
					                        	<i class="far fa-heart" id="heartOff"></i>
					                        	<i class="fas fa-heart" id="heartOn"></i>
					                        </a>
				                        </c:if>
	                        		</c:if>
	                        	</c:forEach>
                        		<c:if test="${empty zzim}">
                        			<a id="zzim">
			                        	<i class="far fa-heart" id="heartOff"></i>
			                        	<i class="fas fa-heart" id="heartOn"></i>
				                    </a>
                        		</c:if>
	                        	
	                        </c:if>
	                        <c:if test="${shopType eq 1 }">
	                        	<c:forEach items="${zzim }" var="zzim">
		                        	<c:if test="${zzim.hos_num eq shopInfo.hosNum and zzim.cl_num eq client.cl_num}">
		                        		<a id="zzim">
		                        			<i class="far fa-heart" id="heartOff" style="display : none;"></i>
		                        			<i class="fas fa-heart" id="heartOn" style=" display : inline-block; color : var(--hover-color)"></i>
		                        		</a>
		                        	</c:if>
		                        	<c:if test="${zzim.hos_num ne shopInfo.hosNum and zzim.cl_num ne client.cl_num}">
				                        <a id="zzim">
				                        	<i class="far fa-heart" id="heartOff"></i>
				                        	<i class="fas fa-heart" id="heartOn"></i>
				                        </a>
			                        </c:if>
			                   </c:forEach>
			                   <c:if test="${empty zzim}">
                        			<a id="zzim">
			                        	<i class="far fa-heart" id="heartOff"></i>
			                        	<i class="fas fa-heart" id="heartOn"></i>
				                    </a>
                        		</c:if>
	                        </c:if>
                        </c:if> 
                        
                    </div>
                </div> <!--store_info_article-->
                <div class="swiper-container store_menu_article ">
                
                <c:if test="${shopType eq 0}">
					<p>스타일<span>(${fn:length(menuList)})</span></p>
                    <div class="swiper-wrapper store_menues">
                     <c:forEach var="menuList " items="${menuList }" varStatus="status">
                            <div class="menu_box swiper-slide">
                                <a href="#">
                                    <p class="menu_item"><c:out value="${menuList[status.index].style_name }"/></p>
                                    <small class="menu_time">${menuList[status.index].style_time }분 소요</small>
                                    <p class="menu_price">${menuList[status.index].price }원</p>
                                </a>
                            </div>
                      </c:forEach>
                    </div>
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>
                </c:if> 
                
               <c:if test="${shopType eq 1}">
					<p>진료<span>(${fn:length(menuList)})</span></p>
                    <div class="swiper-wrapper store_menues">
                     <c:forEach var="menuList " items="${menuList }" varStatus="status">
                            <div class="menu_box swiper-slide">
                                <a href="#">
                                    <p class="menu_item"><c:out value="${menuList[status.index].medName }"/></p>
                                    <small class="menu_time">	</small>
                                    <p class="menu_price">${menuList[status.index].medPrice }원</p>
                                </a>
                            </div>
                      </c:forEach>
                    </div>
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>               
                </c:if>
                
                   
                </div><!--store_menu_article-->
                
                <div class="store_review_article ">
                    <p>예약자 리뷰<span>(5)</span></p>
                    <div class="reviewsBox">
                        <div class="avgStar">
                            <i class="fas fa-star rate"></i>
                            <i class="fas fa-star rate"></i>
                            <i class="fas fa-star rate"></i>
                            <i class="fas fa-star rate"></i>
                            <i class="far fa-star rate"></i>
                            <span class="rateScore">4.42/5.0</span>
                        </div>
                        <div class="reviewOpt">
                            <input type="checkbox" id="checkPhoto"><label for="checkPhoto">사진리뷰만 보기</label>
                            <div class="checkOpts">
                                <span class="checkOpt">최신순</span>
                                <span class="checkOpt">별점 높은 순</span>
                                <span class="checkOpt">별점 낮은 순</span>
                            </div>
                        </div> 
                        <hr> 
                        <div class="reviews">
                            	<c:forEach items="${reviewList }" var="items">
                            <div class="review">
                            
                            
	                                <div class="reviewWord">
	                                    <div class="star_img">
	                                    <c:if test="${items.revVal eq 1}">
	                                   		<i class="fas fa-star rate"></i>
	                                    </c:if>
	                                    <c:if test="${items.revVal eq 2}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                    </c:if>
	                                    <c:if test="${items.revVal eq 3}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                    </c:if>
	                                    <c:if test="${items.revVal eq 4}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                    </c:if>
	                                    <c:if test="${items.revVal eq 5}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                    </c:if>

	                                        <span class="reviewScore">${items.revVal }.0</span>
	                                    </div>
	                                    <div class="reviewCon">
	                                        <p>${items.revCont }</p>
	                                    </div>
	                                    <div class="reviewInfo">
	                                        <span>${items.clNickName }</span>
	                                        <span class="reviewDate">${items.revDate } 방문</span>
	                                    </div>
	                                </div>
	                                
	                                <c:choose>
	                                	<c:when test="${items.revImg eq null}">
		                                	<div class="review_imgBox">
		                                    	<img class="review_img" src="${pageContext.request.contextPath}/resources/images/logo.png">
		                                	</div>
	                                	</c:when>
	                                	<c:otherwise>
			                                <div class="review_imgBox">
			                                    <img class="review_img" src="${path}/resources/uploadFile/review/${items.revImg}">
			                                </div>
		                                </c:otherwise>
		                           	</c:choose>     
                            </div>
                                </c:forEach>
                            <div class="reply">
                                <div class="replyCon">
                                    <p>또비언니님 찾아주셔서 감사합니다.</p>
                                    <p>다음에 더 좋은 서비스로 보답하겠습니다.</p>
                                </div>
                                <div class="replyInfo">
                                    <span>쿨펫미용실</span>
                                    <span class="replyDate">2021-05-31 오전 11:30</span>
                                </div>
                            </div>
                        </div>                                    
                    </div>            
                </div> <!--store_review_article-->
                <div class="store_map_article ">
                    <p>오시는길</p>
                    <div class="storeMapBox">
                        <div class="mapFrame">
                            <div id="map" class="mapBox">
                            </div>
                        </div>
                        <div class="storeInfo">
                            <p>${shopInfo.shopName }</p>
                            <p>전화번호 : ${shopInfo.shopTel }</p>
                            <p>주소 : ${shopInfo.shopAddr }</p>
                        </div>
                    </div>
                </div>
            </div><!--store_area-->
            
            <!--TOPBTN-->
            <a id="MOVE_TOP_BTN" href="#"><i class="fas fa-arrow-up"></i></a>
        
        </section>
	
		
		<jsp:include page="../../common/footer.jsp" />	
	</div>
	
	 <!-- script -->
     <script type="text/javascript" src="${path}/resources/js/user/uShop/shopInfoRead.js"></script>
     <script type="text/javascript" src="${path}/resources/js/user/uMyPage/Likes.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/map.js"></script>
</body>
</html>