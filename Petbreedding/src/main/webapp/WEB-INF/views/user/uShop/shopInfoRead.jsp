<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
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

<!-- Swiper -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
</head>
<body>
	<div class="wrapper">    
		<jsp:include page="../../common/header.jsp" />
			<section class="section">
            <div class="store_area">
                <div class="store_info_article">
                    <div class="store_img">
                        <img src="http://placehold.it/400x400">
                    </div>
                    <div class="store_name">
                        <h1>쿨펫미용실</h1>
                    </div>
                    <div class="store_tel"><i class="fas fa-phone-alt"></i><span>031-123-1234</span></div>
                    <div class="store_info">
                        <p>가위컷 전문 쿨펫 미용실 입니다.</p>
                        <p>문의 후 예약해 주세요.</p>
                    </div>
                    <div class="store_btn">
                        <a href="#" id="goChat" class="sBtn">문의하기</a>
                        <a href="salonReservation.html" id="goRev" class="sBtn">예약하기</a>
                        <a href="#" id="zzim"><i class="far fa-heart"></i><i class="fas fa-heart"></i></a>
                    </div>
                </div> <!--store_info_article-->
                <div class="swiper-container store_menu_article ">
                    <p>메뉴<span>(5)</span></p>
                    <div class="swiper-wrapper store_menues">
                            <div class="menu_box swiper-slide">
                                <a href="#">
                                    <p class="menu_item">클리퍼미용</p>
                                    <small class="menu_time">60분 소요</small>
                                    <p class="menu_price">30,000원</p>
                                </a>
                            </div>
                            <div class="menu_box swiper-slide">
                                <a href="#">
                                    <p class="menu_item">가위컷</p>
                                    <small class="menu_time">180분 소요</small>
                                    <p class="menu_price">50,000원</p>
                                </a>
                            </div>
                            <div class="menu_box swiper-slide" >
                                <a href="#">
                                    <p class="menu_item">목욕</p>
                                    <small class="menu_time">40분 소요</small>
                                    <p class="menu_price">20,000원</p>
                                </a>
                            </div>
                            <div class="menu_box swiper-slide">
                                <a href="#">
                                    <p class="menu_item">스파</p>
                                    <small class="menu_time">60분 소요</small>
                                    <p class="menu_price">40,000원</p>
                                </a>
                            </div>
                            <div class="menu_box swiper-slide">
                                <a href="#">
                                    <p class="menu_item">스포팅 미용</p>
                                    <small class="menu_time">60분 소요</small>
                                    <p class="menu_price">30,000원</p>
                                </a>
                            </div>
                        </ul>
                    </div>
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>
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
                            	<c:forEach items="${reviewList }" var="reviewList">
                            <div class="review">
                            
                            
	                                <div class="reviewWord">
	                                    <div class="star_img">
	                                    <c:if test="${reviewList.revVal eq 1}">
	                                   		<i class="fas fa-star rate"></i>
	                                    </c:if>
	                                    <c:if test="${reviewList.revVal eq 2}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                    </c:if>
	                                    <c:if test="${reviewList.revVal eq 3}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                    </c:if>
	                                    <c:if test="${reviewList.revVal eq 4}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                    </c:if>
	                                    <c:if test="${reviewList.revVal eq 5}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                    </c:if>

	                                        <span class="reviewScore">${reviewList.revVal }.0</span>
	                                    </div>
	                                    <div class="reviewCon">
	                                        <p>${reviewList.revCont }</p>
	                                    </div>
	                                    <div class="reviewInfo">
	                                        <span>${reviewList.clNickName }</span>
	                                        <span class="reviewDate">${reviewList.revDate } 방문</span>
	                                    </div>
	                                </div>
	                                <div class="review_img">
	                                    <img src="http://placehold.it/150x100">
	                                </div>
                                
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
                            <div class="mapBox"></div>
                        </div>
                        <div class="storeInfo">
                            <p>쿨펫 미용실</p>
                            <p>전화번호 : 031-123-1234</p>
                            <p>주소 : 경기도 고양시 고양동 고양오피스텔 1F 305호</p>
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
     <script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
</body>
</html>