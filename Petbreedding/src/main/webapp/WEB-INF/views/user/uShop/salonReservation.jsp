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
<link href="${path}/resources/css/user/uShop/shopReservation.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- Swiper -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>

<!-- Calendar -->
<link href="${path}/resources/css/user/uShop/datepicker.css" rel="stylesheet" type="text/css" >


</head>
<body>
<div class="wrapper">    
		<jsp:include page="../../common/header.jsp" />
			<section class="section">
            <p><span><a href="index.html">홈</a>></span><span><a href="salon.html">쿨펫미용실</a>></span>예약하기</p>
            
            <!-- 넘길 정보 -->
            <!-- TODO -->
            <input type="hidden" value="40" id="clNum"/> 
            <input type="hidden" value="1" id="harNum"/>
            
            <div class="swiper-container" id="checkService">
                <p class="rev_text">이용하실 서비스를 선택해주세요</p>
                <div class="swiper-wrapper">
               		<c:forEach items="${style}" var="style">
                		<div class="menu_box swiper-slide">
                			<input type="hidden" value="${style.style_num }" class="styleNum" />
                            <p class="menu_item">${style.style_name}</p>
                            <p class="menu_time">${style.style_time }분 소요</p>
                            <p class="menu_price">${style.price}원</p>
                        </div>
               		</c:forEach>
                </div>
                <div class="swiper-button-next swpBtn"></div>
                <div class="swiper-button-prev swpBtn"></div>
            </div><!--store_menu_article-->
            <div class="selectService " id="secondChoose">
                <p class="rev_text">서비스를 이용할 아이를 선택해주세요</p>
                <div class="store_menues">
                	<c:forEach items="${pet}" var="pet">
                		<div class="dog_box">
                        <div class="dog_img_area">
                            <img src="http://placehold.it/160x100">
                        </div>
                        <input type="hidden" class="petNum" value="${pet.pet_num}" />
                        <p class="dog_name">${pet.pet_name }</p>
                    	</div>
                	</c:forEach>
                    
                    <div id="addDogBox">
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
                        <div class="plus swiper-slide" id="noPlus">
                        	<input type="hidden" value="선택안함" class="styleNum" />
                            <p class="menu_item">선택안함</p>
                            <p class="menu_time">+0분</p>
                            <p class="menu_price">0원</p>
                        </div>
                        <c:forEach items="${style2}" var="style2">
	                        <div class="plus swiper-slide">
	                       		<input type="hidden" value="${style2.style_num }" class="styleNum" />
	                            <p class="menu_item">${style2.style_name}</p>
	                            <p class="menu_time">+${style2.style_time }분</p>
	                            <p class="menu_price">${style2.price}원</p>
	                        </div>
                        </c:forEach>
                    </div>
                    <div class="swiper-button-next swpBtn"></div>
                    <div class="swiper-button-prev swpBtn"></div>
                </div>
                <div class="selectService " id="fourthChoose">
                    <p class="rev_text">예약일 선택</p>
                    <div class="store_menues">
                        <div id="calendar_box">
                            <div class="calendar" id="calendar"></div>
                        </div>
                        <div class="choose_date">
                        	선택날짜 : <span id="choDate"></span>
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
		<jsp:include page="../../common/footer.jsp" />
		
		
		<!-- MODAL -->
         <div id="my_modal">
            <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
            <div id="locCon">
                <h1>바로 결제하시겠습니까?</h1>
                <p>지금 결제 하지 않으셔도 Mypage에서 결제하실 수 있습니다.</p>
                <button id="goTOPay">바로 결제할게요</button>
                <button id="nextTime">다음에 할게요</button>
                <input type="hidden" id="har_rnum">
            </div>
        </div>	
</div>
	
	 <!-- script -->
	 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <script type="text/javascript" src="${path}/resources/js/user/uShop/shopReservation.js"></script>
     <script type="text/javascript" src="${path}/resources/js/user/uShop/resCalendar.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
     
</body>
</html>