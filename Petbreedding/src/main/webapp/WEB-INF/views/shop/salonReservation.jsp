<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petverything::펫브리띵</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/shop/shopReservation.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- Swiper -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
</head>
<body>
<div class="wrapper">    
		<jsp:include page="../header.jsp" />
			<section class="section">
            <p><span><a href="index.html">홈</a>></span><span><a href="salon.html">쿨펫미용실</a>></span>예약하기</p>
            <div class="swiper-container" id="checkService">
                <p class="rev_text">이용하실 서비스를 선택해주세요</p>
                <div class="swiper-wrapper">
                        <div class="menu_box swiper-slide">
                            <p class="menu_item">클리퍼미용</p>
                            <p class="menu_time">60분 소요</p>
                            <p class="menu_price">30,000원</p>
                        </div>
                        <div class="menu_box swiper-slide">
                            <p class="menu_item">가위컷</p>
                            <p class="menu_time">180분 소요</p>
                            <p class="menu_price">50,000원</p>
                        </div>
                        <div class="menu_box swiper-slide" >
                            <p class="menu_item">목욕</p>
                            <p class="menu_time">40분 소요</p>
                            <p class="menu_price">20,000원</p>
                        </div>
                        <div class="menu_box swiper-slide">
                            <p class="menu_item">스파</p>
                            <p class="menu_time">60분 소요</p>
                            <p class="menu_price">40,000원</p>
                        </div>
                        <div class="menu_box swiper-slide">
                            <p class="menu_item">스포팅 미용</p>
                            <p class="menu_time">60분 소요</p>
                            <p class="menu_price">30,000원</p>
                        </div>
                    </ul>
                </div>
                <div class="swiper-button-next swpBtn"></div>
                <div class="swiper-button-prev swpBtn"></div>
            </div><!--store_menu_article-->
            <div class="selectService " id="secondChoose">
                <p class="rev_text">서비스를 이용할 아이를 선택해주세요</p>
                <div class="store_menues">
                    <div class="dog_box">
                        <div class="dog_img_area">
                            <img src="http://placehold.it/160x100">
                        </div>
                        <p class="dog_name">또비</p>
                    </div>
                    <div class="dog_box" id="addDogBox">
                        <div class="dog_img_area">
                            <i class="fas fa-plus addDog"></i>
                        </div>
                        <p class="dog_name">신규등록</p>
                    </div>
                </div>
            </div>
            <div class="swiper-container " id="thirdChoose">
                <p class="rev_text">기타 추가 요금</p>
                <div class="store_menues swiper-wrapper">
                        <div class="menu_box swiper-slide">
                            <p class="menu_item">선택안함</p>
                            <p class="menu_time">+0분</p>
                            <p class="menu_price">0원</p>
                        </div>
                        <div class="menu_box swiper-slide">
                            <p class="menu_item">디자인컷</p>
                            <p class="menu_time">+0분</p>
                            <p class="menu_price">20,000원</p>
                        </div>
                        <div class="menu_box swiper-slide">
                            <p class="menu_item">얼굴컷</p>
                            <p class="menu_time">+0분</p>
                            <p class="menu_price">50,000원</p>
                        </div>
                        <div class="menu_box swiper-slide">
                            <p class="menu_item">탄산스파</p>
                            <p class="menu_time">+30분</p>
                            <p class="menu_price">20,000원</p>
                        </div>
                        <div class="menu_box swiper-slide">
                            <p class="menu_item">귀/발톱만</p>
                            <p class="menu_time">+0분</p>
                            <p class="menu_price">10,000원</p>
                        </div>
                        <div class="menu_box swiper-slide">
                            <p class="menu_item">위생 미용</p>
                            <p class="menu_time">+0분</p>
                            <p class="menu_price">10,000원</p>
                        </div>
                        <div class="menu_box swiper-slide">
                            <p class="menu_item">슬개골 마사지</p>
                            <p class="menu_time">+40분</p>
                            <p class="menu_price">15,000원</p>
                        </div>
                        </ul>  
                    </div>
                    <div class="swiper-button-next swpBtn"></div>
                    <div class="swiper-button-prev swpBtn"></div>
                </div>
                <div class="selectService " id="fourthChoose">
                    <p class="rev_text">예약일 선택</p>
                    <div class="store_menues">
                        <div class="calendar_box">
                            <div class="calendar"></div>
                        </div>
                        <div class="choose_date">
                            <div class="times">
                                <ul>
                                    <li class="time">10:00</li>
                                    <li class="time">10:30</li>
                                    <li class="time">11:00</li>
                                    <li class="time">11:30</li>
                                </ul>
                            </div>
                            <div class="times">
                                <ul>
                                    <li class="time">12:00</li>
                                    <li class="time">12:30</li>
                                    <li class="time">13:00</li>
                                    <li class="time">13:30</li>
                                </ul>
                            </div>
                            <div class="times">
                                <ul>
                                    <li class="time">14:00</li>
                                    <li class="time">14:30</li>
                                    <li class="time">15:00</li>
                                    <li class="time">15:30</li>
                                </ul>
                            </div>
                            <div class="times">
                                <ul>
                                    <li class="time">16:00</li>
                                    <li class="time">16:30</li>
                                    <li class="time">17:00</li>
                                    <li class="time">17:30</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="reservatoin_info " id="fifthChoose">
                    <p class="infoTitle">이용안내</p>
                    <p>* 당일 취소는 불가합니다.</p>
                    <p>* 예약시간에 도착하지 않을시에 취소가 될 수 있으며, 환불 처리는 되지 않습니다. </p>
                </div>
                <div class="btnBox" id="btnBox">
                    <input type="button" id="reservation_btn" value="예약하기">
                </div>
        <!--TOPBTN-->
        <a id="MOVE_TOP_BTN" href="#"><i class="fas fa-arrow-up"></i></a>
        </section>
		<jsp:include page="../footer.jsp" />
		
		
		<!-- MODAL -->
         <div id="my_modal">
            <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
            <div id="locCon">
                <h1>바로 결제하시겠습니까?</h1>
                <p>지금 결제 하지 않으셔도 Mypage에서 결제하실 수 있습니다.</p>
                <button id="goTOPay">바로 결제할게요</button>
                <button id="nextTime">다음에 할게요</button>
            </div>
        </div>	
</div>
	
	 <!-- script -->
     <script type="text/javascript" src="${path}/resources/js/shop/shopReservation.js"></script>
     <script type="text/javascript" src="${path}/resources/js/topBtn.js"></script>
</body>
</html>