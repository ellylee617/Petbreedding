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
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bShop/bReservation.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
	        <jsp:include page="../bAside.jsp" />
	        <div class="bContent">
                <div class="calendarBox">
                    <div class="calendar"></div>
                </div>
                <div class="resBox">
                    <select>
                        <option>전체</option>
                        <option>예약완료</option>
                        <option>결제완료</option>
                        <option>결제취소</option>
                    </select>
                    
                    <hr>
                    <div class="resList">                    
                        <table>
                            <!-- tr forEach -->
                            <tr>
                                <td class="status">예약완료<span class="noneDis">,</span></td>
                                <td class="resTime">10:00</td>
                                <td class="resName">곽서현</td>
                                <td class="resInfo"><a href="#">상세보기</a></td>
                            </tr>
                            <tr>
                                <td class="status">결제완료<span class="noneDis">,</span></td>
                                <td class="resTime">10:00</td>
                                <td class="resName">곽서현</td>
                                <td class="resInfo"><a href="#">상세보기</a></td>
                            </tr>
                            <tr>
                                <td class="status">결제취소<span class="noneDis">,</span></td>
                                <td class="resTime">10:00</td>
                                <td class="resName">곽서현</td>
                                <td class="resInfo"><a href="#">상세보기</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div> 	
	    </section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
	<!-- script -->
    <script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
    <script type="text/javascript" src="${path}/resources/js/bPartner/bShop/bReservation.js"></script>	
</body>
</html>