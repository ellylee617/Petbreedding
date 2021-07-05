<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="shopType" value="${param.shopType}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uShop/shopList.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>

</head>
<body>
   <div class="wrapper">    
      <jsp:include page="../../common/header.jsp" />
      
      <section class="section">
      <!-- 동물병원 -->
      <c:if test="${shopType eq 1}">
            <h1>동물병원</h1>
            <div class="nowLocation">
                <span>경기</span><span>></span><span>고양</span><a href="#" id="Loc"><i class="fas fa-map-marker-alt loc" ></i></a>
            </div>
            <hr id="storeLine">
            <div class="selectOpt">
                <input type="radio" checked id="popular" name="selectOpt"><label for="popular">최신순</label>
                <input type="radio" id="distance" name="selectOpt"><label for="distance">거리순</label>
                <input type="radio" id="rating" name="selectOpt"><label for="rating"><a href="${pageContext.request.contextPath}/shopList?shopType=1&selectState=rev">별점순</a></label>
            </div>
            <div class="ultraS">
                <small id="ultra_ad">울트라콜 광고<i class="fas fa-ad"></i></small>
                <!-- TODO: 울트라콜 몇 개 보여줄지 정해야 됨 -->
                <ul>
                    <div class="ultraStore">                     
                        <li class="ultraList">
                            <div class="ultraList_inner">
                                <div class="ultraList_img_area"><a href="#"><img src="http://placehold.it/150x100"></a></div>
                                <div class="ultraList_title_area"><a href="#">쿨펫 동물병원</a></div>
                                <div class="ultraList_info_area"><a href="#">슬개골 수술 전문 병원입니다.</a></div>
                                <div class="ultraList_etc_area">
                                    <a href="#">리뷰<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><small>999+</small></a>
                                    <a href="#">구매건수<small>999+</small></a>
                                    <a href="#">찜하기<small>999+</small></a>
                                </div>
                                <div class="ultraList_button">
                                    <a href="shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
            </div>
            
            <div class="storeS">
               <c:forEach items="${shopList}" var="item" varStatus="status">
                <ul>
                    <div class="Store">                     
                        <li class="storeList">
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
	                                <div class="storeList_etc_area">
	                                    <a href="#">리뷰<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><small>999+</small></a>
	                                    <a href="#">구매건수<small>999+</small></a>
	                                    <a href="#">찜하기 <small> ${count[status.index]}</small></a>
	                                </div>
                                    <a href="shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                             </div>
                        </li>
                     </div>                                                            
                </ul>
                </c:forEach>
                    </div>
                    
               <!-- 페이징 시작-->
				<div class="page_wrap">
					<div class="page_nation">
						<c:if test="${paging.startPage != 1 }">
							<a class="arrow prev" href="${path}/shopList?shopType=${shopType}&nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">이전</a> 
						</c:if>
						<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
							<c:choose>
								<c:when test="${p == paging.nowPage }">
									<b>${p }</b>
								</c:when>
								<c:when test="${p != paging.nowPage }">
									<a href="${path}/shopList?shopType=${shopType}&nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p}</a>
								</c:when>
							</c:choose>
						</c:forEach>
						<c:if test="${paging.endPage != paging.lastPage}">
							<a class="arrow next" href="${path}/shopList?shopType=${shopType}&${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">다음</a>
						</c:if>
					</div>
				</div>
				<!-- 페이징 끝! -->
				
            </c:if>
            
            <!--TOPBTN-->
            <a id="MOVE_TOP_BTN" href="#"><i class="fas fa-arrow-up"></i></a>
            
            
            
            
            <!-- 미용실 -->
            <c:if test="${shopType eq 0}">
            <h1>미용실</h1>
            <div class="nowLocation">
                <span>경기</span><span>></span><span>고양</span><a href="#" id="Loc"><i class="fas fa-map-marker-alt loc" ></i></a>
            </div>
            <hr id="storeLine">
            <div class="selectOpt">
                <input type="radio" checked id="newHarRadio" name="selectOpt"><label for="newHarRadio">최신순</label>
                <input type="radio" id="distanceHarRadio"  name="selectOpt" ><label for="distanceHarRadio">거리순</label>
                 <input type="radio" id="revHarRadio" name="selectOpt"><label for="revHarRadio">별점순</label>
            </div>
      <div class="ultraS">
                <small id="ultra_ad">울트라콜 광고<i class="fas fa-ad"></i></small>
                <!-- TODO: 울트라콜 몇 개 보여줄지 정해야 됨 -->
                <ul>
                   <c:forEach var="cta" items="${cta}" varStatus="status">
                    <div class="ultraStore">                     
                        <li class="ultraList">
                            <div class="ultraList_inner">
                                <div class="ultraList_img_area"><a href="#"><img src="${path}/resources/uploadFile/shop/${cta.shopMImg }" width="150px" height="100"></a></div>
                                <div class="ultraList_title_area"><a href="#">${cta.shopName}</a></div>
                                <div class="ultraList_info_area"><a href="#">${cta.shopMInfo}</a></div>
                                <div class="ultraList_etc_area">
                                    <a href="#">리뷰<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><small>999+</small></a>
                                    <a href="#">구매건수<small>999+</small></a>
                                    <a href="#">찜하기 <small> ${count2[status.index]}</small></a>
                                </div>
                                <div class="ultraList_button">
                                    <a href="shopPage?bpId=${cta.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                            </div>                                                            
                        </li>
                   </div>
                </ul>
            </div>
            </c:forEach>
            
           <!-- 미용실 최신순 정렬 -->
           <div id="newHarList" class="storeS">
               <c:forEach items="${newHarList}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopMInfo }</a></div>
                                <div class="storeList_etc_area">
                                    <a href="#">리뷰<small> 
                                    <c:if test="${item.avgRevVal ge 0 && item.avgRevVal lt 1}">
	                                   		&nbsp;(${item.avgRevVal})
	                                    </c:if>
                                    <c:if test="${item.avgRevVal ge 1 && item.avgRevVal lt 2}">
	                                   		<i class="fas fa-star rate"></i>&nbsp;(${item.avgRevVal})
	                                    </c:if>
	                                    <c:if test="${item.avgRevVal ge 2 && item.avgRevVal lt 3}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>&nbsp;(${item.avgRevVal})
	                                    </c:if>
	                                    <c:if test="${item.avgRevVal ge 3 && item.avgRevVal lt 4}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>&nbsp;(${item.avgRevVal})
	                                    </c:if>
	                                    <c:if test="${item.avgRevVal ge 4 && item.avgRevVal lt 5}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>&nbsp;(${item.avgRevVal})
	                                    </c:if>
	                                    <c:if test="${item.avgRevVal eq 5}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>&nbsp;(${item.avgRevVal})
	                                    </c:if>
                                    <c:if test="${!empty countRev[status.index] }">
	                                    &nbsp;${countRev[status.index]}개 
                                    </c:if>
                                    <c:if test="${empty countRev[status.index]}">
                                    &nbsp;0개 
                                    </c:if>
                                    </small>
                                    </a>
                                    <a href="#">구매건수<small>999+</small></a>
		                            <a href="#">찜하기 <small> ${count[status.index]}</small></a>
                                </div>
                                 <form class="frmShopInfo" >
                                 <div class="storeList_button">
                                    <a href="shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                               </form>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
                </c:forEach>
            </div>
            
            <!-- 미용실 거리순 정렬 -->
            <div id="distanceHarList" class="storeS">
            <h1>거리순 정렬 작업 중</h1>
            </div>
            
            <!-- 미용실 별점순 정렬 -->
             <div id="revHarList" class="storeS" style="display: none;">
               <c:forEach items="${revHarList}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopMInfo }</a></div>
                                <div class="storeList_etc_area">
                                    <a href="#">리뷰<small> 
                                    <c:if test="${item.avgRevVal ge 0 && item.avgRevVal lt 1}">
	                                   		&nbsp;(${item.avgRevVal})
	                                    </c:if>
                                    <c:if test="${item.avgRevVal ge 1 && item.avgRevVal lt 2}">
	                                   		<i class="fas fa-star rate"></i>&nbsp;(${item.avgRevVal})
	                                    </c:if>
	                                    <c:if test="${item.avgRevVal ge 2 && item.avgRevVal lt 3}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>&nbsp;(${item.avgRevVal})
	                                    </c:if>
	                                    <c:if test="${item.avgRevVal ge 3 && item.avgRevVal lt 4}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>&nbsp;(${item.avgRevVal})
	                                    </c:if>
	                                    <c:if test="${item.avgRevVal ge 4 && item.avgRevVal lt 5}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>&nbsp;(${item.avgRevVal})
	                                    </c:if>
	                                    <c:if test="${item.avgRevVal eq 5}">
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>
	                                   		<i class="fas fa-star rate"></i>&nbsp;(${item.avgRevVal})
	                                    </c:if>
                                    <c:if test="${!empty countRev[status.index] }">
	                                    &nbsp;${countRev[status.index]}개 
                                    </c:if>
                                    <c:if test="${empty countRev[status.index]}">
                                    &nbsp;0개 
                                    </c:if>
                                    </small>
                                    </a>
                                    <a href="#">구매건수<small>999+</small></a>
		                            <a href="#">찜하기 <small> ${count[status.index]}</small></a>
                                </div>
                                 <form class="frmShopInfo" >
                                 <div class="storeList_button">
                                    <a href="shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                               </form>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
                </c:forEach>
            </div>
            
            
            <!-- 페이징 시작-->
				<div class="page_wrap">
					<div class="page_nation">
						<c:if test="${paging.startPage != 1 }">
							<a class="arrow prev" href="${path}/shopList?shopType=${shopType}&nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">이전</a> 
						</c:if>
						<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
							<c:choose>
								<c:when test="${p == paging.nowPage }">
									<b>${p }</b>
								</c:when>
								<c:when test="${p != paging.nowPage }">
									<a href="${path}/shopList?shopType=${shopType}&nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p}</a>
								</c:when>
							</c:choose>
						</c:forEach>
						<c:if test="${paging.endPage != paging.lastPage}">
							<a class="arrow next" href="${path}/shopList?shopType=${shopType}&${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">다음</a>
						</c:if>
					</div>
				</div>
				<!-- 페이징 끝! -->
            
            
            </c:if>
        </section>
   
      <jsp:include page="../../common/footer.jsp" />   
      
      
      
      
       <!-- MODAL -->
        <div id="my_modal">
            <p>주소 검색</p>
            <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
            <div id="locCon">
                <select name="" class="select"  onchange="categoryChange(this)">
                    <option value="" disabled="disabled" selected>시·도</option>
                    <option value="a">서울특별시</option>
                    <option value="b">부산광역시</option>
                    <option value="c">대구광역시</option>
                    <option value="d">인천광역시</option>
                    <option value="e">광주광역시</option>
                    <option value="f">대전광역시</option>
                    <option value="g">울산광역시</option>
                    <option value="h">세종특별자치시</option>
                    <option value="i">경기도</option>
                    <option value="j">강원도</option>
                    <option value="k">충청북도</option>
                    <option value="l">충청남도</option>
                    <option value="m">전라북도</option>
                    <option value="n">전라남도</option>
                    <option value="o">경상북도</option>
                    <option value="p">경상남도</option>
                    <option value="q">제주특별자치도</option>
                </select>
                <select id="chooseLoc">
                    <option value="" disabled="disabled">시·군·구</option>
                </select>
                <button id="changeLoc">확인</button>
            </div>
        </div>
      
      
   </div>
   
    <!-- script -->
     <script type="text/javascript" src="${path}/resources/js/user/uShop/shopList.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/map.js"></script>
</body>
</html>