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
            <c:if test="${!empty paging.locCon }">
            <div class="nowLocation">
                <span>${paging.locCon }</span><span>></span><span>${paging.chooseLoc }</span><a href="#" id="Loc"><i class="fas fa-map-marker-alt loc" ></i></a>
            </div>
            </c:if>
            <c:if test="${empty paging.locCon }">
            <div class="nowLocation">
                <span> 위치를 설정해 주세요 </span><a href="#" id="Loc"><i class="fas fa-map-marker-alt loc" ></i></a>
            </div>
            </c:if>
            <hr id="storeLine">
            <div class="selectOpt">
                <input id="newRadio" type="radio" checked name="selectOpt"><label for="newRadio">최신순</label>
                <input id="distanceRadio" type="radio"  name="selectOpt"><label for="distanceRadio">인기순</label>
                <input id="revRadio" type="radio" name="selectOpt"><label for="revRadio">별점순</label>
            </div>
            
            <c:if test="${!empty paging.keyword }">
            	<h1>'<c:out value="${paging.keyword }"/>'에 대한 결과입니다. (CSS 작업 전..~~)</h1>
            </c:if>
            <c:if test="${empty paging.keyword }">
            <div class="ultraS">
                <small id="ultra_ad">울트라콜 광고<i class="fas fa-ad"></i></small>
                <!-- TODO: 울트라콜 몇 개 보여줄지 정해야 됨 -->
                <ul>
                     <c:forEach var="hos" items="${cta2}" varStatus="status">
                     <c:if test="${hos.cta_number > 0}">
                     	   <div class="ultraStore">                     
	                        <li class="ultraList">
	                            <div class="ultraList_inner">
	                                <div class="ultraList_img_area"><a href="#"><img src="${path}/resources/uploadFile/shop/${hos.shopMImg }" width="150px" height="100"></a></div>
	                                <div class="ultraList_title_area"><a href="#">${hos.shopName}</a></div>
	                                <div class="ultraList_info_area"><a href="#">${hos.shopMInfo}</a></div>
	                                <div class="ultraList_etc_area">
	                                    <a href="#">리뷰<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><small>999+</small></a>
	                                    <a href="#">구매건수<small>999+</small></a>
	                                    <a href="#">찜하기 <small> ${count2[status.index]}</small></a>
	                                </div>
	                                <div class="ultraList_button">
	                                    <a href="shopPage?bpId=${hos.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
	                                </div>
	                            </div>                                                            
	                        </li>
	                    </div>
	                    </c:if>
                    </c:forEach>
                </ul>
            </div>
            </c:if>
            
            
            <!-- 동물병원 최신순 정렬 -->
            <div id="newList" class="storeS">
               <c:forEach items="${newHosList}" var="item" varStatus="status">
                <ul>
                    <div class="Store">                     
                        <li class="storeList">
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
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
                                    <a href="shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                             </div>
                        </li>
                     </div>                                                            
                </ul>
                </c:forEach>
                    </div>
                    
              <!-- 동물병원 인기순 정렬 -->
              <div id="distanceList" class="storeS" style="display: none;">
              <h1>동물병원 인기순 정렬 작업중</h1>
              </div>
              
              <!-- 동물병원 별점순 정렬 -->
               <div id="revList" class="storeS" style="display: none;">
               <c:forEach items="${revHosList}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
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
            
            <!--TOPBTN-->
            <a id="MOVE_TOP_BTN" href="#"><i class="fas fa-arrow-up"></i></a>
            
            
            
            
            <!-- 미용실 -->
            <c:if test="${shopType eq 0}">
            <h1>미용실</h1>
            <c:if test="${!empty paging.locCon }">
            <div class="nowLocation">
                <span>${paging.locCon }</span><span>></span><span>${paging.chooseLoc }</span><a href="#" id="Loc"><i class="fas fa-map-marker-alt loc" ></i></a>
            </div>
            </c:if>
            <c:if test="${empty paging.locCon }">
            <div class="nowLocation">
                <span> 위치를 설정해 주세요 </span><a href="#" id="Loc"><i class="fas fa-map-marker-alt loc" ></i></a>
            </div>
            </c:if>
            <hr id="storeLine">
            <div class="selectOpt">
                <input type="radio" checked id="newRadio" name="selectOpt"><label for="newRadio">최신순</label>
                <input type="radio" id="distanceRadio"  name="selectOpt" ><label for="distanceRadio">인기순</label>
                 <input type="radio" id="revRadio" name="selectOpt"><label for="revRadio">별점순</label>
            </div>
            
            <c:if test="${!empty paging.keyword }">
            	<h1>'<c:out value="${paging.keyword }"/>'에 대한 결과입니다. (CSS 작업 전..~~)</h1>
            </c:if>
            <c:if test="${empty paging.keyword }">
      <div class="ultraS">
                <small id="ultra_ad">울트라콜 광고<i class="fas fa-ad"></i></small>
                <!-- TODO: 울트라콜 몇 개 보여줄지 정해야 됨 -->
                <ul>
                   <c:forEach var="cta" items="${cta}" varStatus="status">
                   <c:if test="${cta.cta_number > 0}">
                    <div class="ultraStore">                     
                        <li class="ultraList">
                            <div class="ultraList_inner">
                                <div class="ultraList_img_area"><a href="#"><img src="${path}/resources/uploadFile/shop/${cta.shopMImg }" width="150px" height="100"></a></div>
                                <div class="ultraList_title_area"><a href="#">${cta.shopName}</a></div>
                                <div class="ultraList_info_area"><a href="#">${cta.shopAddr}</a></div>
                                <div class="ultraList_etc_area">
                                     <a href="#">리뷰<small> 
                                     <c:out value="${ctaRevVal }"></c:out>
                                    <c:if test="${cta.avgRevVal ge 0 && cta.avgRevVal lt 1}">
                                            &nbsp;(${cta.avgRevVal})
                                       </c:if>
                                    <c:if test="${cta.avgRevVal ge 1 && cta.avgRevVal lt 2}">
                                            <i class="fas fa-star rate"></i>&nbsp;(${cta.avgRevVal})
                                       </c:if>
                                       <c:if test="${cta.avgRevVal ge 2 && cta.avgRevVal lt 3}">
                                            <i class="fas fa-star rate"></i>
                                            <i class="fas fa-star rate"></i>&nbsp;(${cta.avgRevVal})
                                       </c:if>
                                       <c:if test="${cta.avgRevVal ge 3 && cta.avgRevVal lt 4}">
                                            <i class="fas fa-star rate"></i>
                                            <i class="fas fa-star rate"></i>
                                            <i class="fas fa-star rate"></i>&nbsp;(${cta.avgRevVal})
                                       </c:if>
                                       <c:if test="${cta.avgRevVal ge 4 && cta.avgRevVal lt 5}">
                                            <i class="fas fa-star rate"></i>
                                            <i class="fas fa-star rate"></i>
                                            <i class="fas fa-star rate"></i>
                                            <i class="fas fa-star rate"></i>&nbsp;(${cta.avgRevVal})
                                       </c:if>
                                       <c:if test="${cta.avgRevVal eq 5}">
                                            <i class="fas fa-star rate"></i>
                                            <i class="fas fa-star rate"></i>
                                            <i class="fas fa-star rate"></i>
                                            <i class="fas fa-star rate"></i>
                                            <i class="fas fa-star rate"></i>&nbsp;(${cta.avgRevVal})
                                       </c:if>
                                    <c:if test="${!empty ctaCountRev[status.index] }">
                                       &nbsp;${ctaCountRev[status.index]}개 
                                    </c:if>
                                    <c:if test="${empty ctaCountRev[status.index]}">
                                    &nbsp;0개 
                                    </c:if>
                                    </small>
                                    </a>
                                    <a href="#">구매건수<small>999+</small></a>
                                    <a href="#">찜하기 <small> ${count2[status.index]}</small></a>
                                </div>
                                <div class="ultraList_button">
                                    <a href="shopPage?bpId=${cta.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                            </div>                                                            
                        </li>
                   </div>
                   </c:if>
            </c:forEach>
                </ul>
            </div>
            </c:if>
            
           <!-- 미용실 최신순 정렬 -->
           <!-- 검색 기능 추가 완료  -->
           <div id="newList" class="storeS">
               <c:forEach items="${newHarList}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
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
            
            <!-- 미용실 인기순 정렬 -->
            <div id="likeList" class="storeS" style="display: none;">
               <c:forEach items="${likesHarList}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
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
            
            <!-- 미용실 별점순 정렬 -->
             <div id="revList" class="storeS" style="display: none;">
               <c:forEach items="${revHarList}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
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
       <form action="shopList">
        <div id="my_modal">
            <p>주소 검색</p>
            <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
            <div id="locCon">
                <select name="selectlocCon" class="select"  onchange="categoryChange(this)">
                    <option value="" disabled="disabled" selected>시·도</option>
                    <option value="서울">서울특별시</option>
                    <option value="부산">부산광역시</option>
                    <option value="대구">대구광역시</option>
                    <option value="인천">인천광역시</option>
                    <option value="광주">광주광역시</option>
                    <option value="대전">대전광역시</option>
                    <option value="울산">울산광역시</option>
                    <option value="세종특별자치시">세종특별자치시</option>
                    <option value="경기">경기도</option>
                    <option value="강원도">강원도</option>
                    <option value="충북">충청북도</option>
                    <option value="충남">충청남도</option>
                    <option value="전북">전라북도</option>
                    <option value="전남">전라남도</option>
                    <option value="경북">경상북도</option>
                    <option value="경남">경상남도</option>
                    <option value="제주특별자치도">제주특별자치도</option>
                </select>
                <select name="selectChooseLoc" id="chooseLoc">
                    <option value="" disabled="disabled">시·군·구</option>
                </select>
                <button id="changeLoc">확인</button>
            </div>
        </div>
	        
	        <c:if test="${shopType eq 1}">
	        <input type="hidden" name="shopType" value="1">
	        </c:if>
	        <c:if test="${shopType eq 0}">
	        <input type="hidden" name="shopType" value="0">
	        </c:if>
        
     	</form> 
      
   </div>
   
    <!-- script -->
     <script type="text/javascript" src="${path}/resources/js/user/uShop/shopList.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/map.js"></script>
</body>
</html>