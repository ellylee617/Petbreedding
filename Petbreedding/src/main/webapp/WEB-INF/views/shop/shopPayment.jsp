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
<link href="${path}/resources/css/shop/shopPayment.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<div class="wrapper">    
		<jsp:include page="../header.jsp" />
			<section class="section">
			<p><span><a href="index.html">홈</a>></span><span><a href="salon.html">쿨펫미용실</a>></span><span><a href="salonReservation.html">예약하기</a>></span>결제하기</p>
            <div class="payContainer">
                <div class="reservation_info infoBox">
                   <table>
                       <tr>
                           <th>예약 정보</th>
                       </tr>
                       <tr>
                           <td class="infoName">일정</td>
                           <td colspan="2">2021-06-10  목요일   오후 4 : 30</td>
                       </tr>
                       <tr>
                        <td class="infoName">상품</td>
                        <td>클리퍼미용</td>
                        <td>(+)얼굴미용</td>
                    </tr>
                   </table>
                </div>
                <div class="reserveUser_info infoBox">
                    <table>
                        <tr>
                            <th>예약자 정보</th>
                        </tr>
                        <tr>
                            <td class="infoName">예약자명</td>
                            <td colspan="2">곽서현</td>
                        </tr>
                        <tr>
                            <td class="infoName">연락처</td>
                            <td>010-1234-1234</td>                        
                        </tr>
                        <tr>
                            <td class="infoName">이메일</td>
                            <td>abcd@naver.com</td>                        
                        </tr>
                    </table>
                 </div>
                 <div class="usingPoint_info infoBox">
                    <table>
                        <tr>
                            <th class="pointInfo">포인트 사용</th>
                            <td>보유 포인트</td>
                            <td id="nowPoint">1,000</td>
                            <td><input type="text" id="pointArea"><input type="checkbox" id="pointAll"><label for="pointAll">모두 사용</label></td>
                        </tr>                        
                    </table>
                 </div>
                 <div class="totalpay_info infoBox">
                     <h4>결제 금액</h4>
                     <div >
                        <p>총 상품 금액 <span>40,000원</span></p>
                        <p>포인트 사용<span class="usePoint">0원</span></p>
                        <p>총 결제 금액 <span>40,000원</span></p>
                     </div>                              
                 </div>
                 <div class="payMethod infoBox">
                    <table>
                        <tr>
                            <th>결제 방법 선택</th>                   
                        </tr>                
                        <tr>
                            <td>
                                <input type="radio" name="payMethod" id="Deposit1"/><label for="Deposit1">신용카드</label>
                                <input type="radio" name="payMethod" id="Deposit2"/><label for="Deposit2">무통장 입금</label>
                                <input type="radio" name="payMethod" id="Deposit3"/><label for="Deposit3">계좌 이체</label>
                                <input type="radio" name="payMethod" id="Deposit4"/><label for="Deposit4">휴대폰 결제</label>
                                <input type="radio" name="payMethod" id="Deposit5"/><label for="Deposit5">카카오 페이</label>
                                <input type="radio" name="payMethod" id="Deposit6"/><label for="Deposit6">네이버 페이</label>                                
                            </td>
                        </tr>         
                    </table>
                 </div>
                 <div class="agreeInfo infoBox">
                    <table>
                        <tr>
                            <th>이용 동의</th>                   
                        </tr>                
                        <tr>
                            <td>
                                <input type="checkbox" id="agreeInfo1"/><label for="agreeInfo1">모두 동의</label>                                                         
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="checkbox" id="agreeInfo2" class="agreeAll"/>상기 결제 내역을 확인, 결제 진행에 동의 (필수)                                                         
                            </td>
                        </tr> 
                        <tr>
                            <td>
                                <input type="checkbox" id="agreeInfo3"  class="agreeAll"/>개인 정보 수집에 동의(필수)                                                       
                                <br><a href="#" class="detailInfo">자세히 보기</a>
                            </td>
                        </tr> 
                        <tr>
                            <td>
                                <input type="checkbox" id="agreeInfo4"  class="agreeAll"/>개인정보 제 3자 제공에 동의(필수)<br>   
                                <small class="detailInfo">예약서비스 및 커뮤니케이션을 위해 개인 정보를 제공 받는 대상 : 쿨펫 미용실</small>
                                <br><a href="#" class="detailInfo">자세히 보기</a>
                            </td>
                        </tr>          
                    </table>
                 </div>
                 <div class="btnBox" id="btnBox">
                    <input type="button" id="reservation_btn" value="결제하기">
                </div>
            </div>
            <!--TOPBTN-->
            <a id="MOVE_TOP_BTN" href="#"><i class="fas fa-arrow-up"></i></a>
		</section>
		<jsp:include page="../footer.jsp" />
</div>
	
	 <!-- script -->
     <script type="text/javascript" src="${path}/resources/js/shop/shopPayment.js"></script>
     <script type="text/javascript" src="${path}/resources/js/topBtn.js"></script>
</body>
</html>