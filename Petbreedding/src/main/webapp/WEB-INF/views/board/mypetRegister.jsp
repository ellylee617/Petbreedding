<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/css/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/board/mypetRegister.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/mypage/myPageAside.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<div class="wrapper">
		<jsp:include page="../header.jsp" />

		<section class="section">
		<jsp:include page="../myPage/myPageAside.jsp" />
            <form action="" id="petInfoFrm" class="petInfo_container">

                <table class="petInfo_container">
                    <tr>
                        <td colspan="2">
                            <div class="img_container">
                                <img src="#" alt="강아지 사진" class="m_20">
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <input type="text" placeholder="이름을 입력해주세요" class="basicTextInput m_20">
                            <p class="errorMsg">에이작스 메세지</p>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <select name="selectPet" id="selectPet" class="selectBox m_20">
                                <option value="견종">견종</option>
                                <option value="푸들">푸들</option>
                                <option value="말티즈">말티즈</option>
                                <option value="포메라니언">포메라니언</option>
                                <option value="시츄">시츄</option>
                                <option value="요크셔">요크셔</option>
                                <option value="치와와">치와와</option>
                                <option value="스피츠">스피츠</option>
                                <option value="폼피츠">폼피츠</option>
                                <option value="믹스">믹스</option>
                                <option value="비글">비글</option>
                                <option value="슈나우저">슈나우저</option>
                                <option value="코카스파니엘">코카스파니엘</option>
                                <option value="골든리트리버">골든리트리버</option>
                                <option value="시베리안허스키">시베리안허스키</option>
                                <option value="비숑">비숑</option>
                                <option value="배들링턴테리어">배들링턴테리어</option>
                            </select>
                            <p class="errorMsg">에이작스 메세지</p>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <select name="YEAR" id="YEAR" title="년도" class="selectBox selectTime"></select>
                            <select name="MONTH" id="MONTH" title="월" class="selectBox selectTime"></select>
                            <select name="DATE" id="DATE" title="일" class="selectBox selectTime m_20"></select>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2" class="radioBox">
                            <ul>
                                
                                <li class="genderList">
                                    <input type="radio" id="male" name="gender" value="male">
                                    <label for="male">남아</label><br>
                                </li>
                                <li class="genderList">
                                    <input type="radio" id="female" name="gender" value="female">
                                    <label for="female">여아</label><br>
                                </li>
                                <li class="genderList list_neut m_20">
                                    <input type="radio" id="neutrality" name="gender" value="neutrality">
                                    <label for="neutrality">중성화</label>
                                </li>
                            </ul>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <span>[선택] 미용 경험</span>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <select name="selectBeautyEx" id="selectBeautyEx" class="selectBox m_20">
                                <option value="선택">선택</option>
                                <option value="없음">없음</option>
                                <option value="1회">1회</option>
                                <option value="2회">2회</option>
                                <option value="3회 이상">3회 이상</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <span>[선택] 예방접종 유무</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="selectInjectionEx" id="selectInjectionEx" class="selectBox m_20">
                                <option value="선택">선택</option>
                                <option value="2차 이하">2차 이하</option>
                                <option value="3차 완료">3차 완료</option>
                                <option value="4차 완료">4차 완료</option>
                                <option value="5차 완료">5차 완료</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <span>[선택] 입질 여부</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="selectBite" id="selectBite" class="selectBox m_20">
                                <option value="선택">선택</option>
                                <option value="안해요">안해요</option>
                                <option value="해요">해요</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <span>[선택] 싫어하는 부위</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="radioBox">
                            <ul>
                                <li class="hateList">
                                    <label for="eye">눈</label><br>
                                </li>
                                <li class="hateList">
                                    <label for="nose">코</label><br>
                                </li>
                                <li class="hateList">
                                    <label for="mouth">입</label>
                                </li>
                                <li class="hateList">
                                    <label for="ear">귀</label><br>
                                </li>
                                <li class="hateList hateListL m_20">
                                    <label for="neck">목</label><br>
                                </li>


                                <li class="hateList">
                                    <label for="body">몸통</label>
                                </li>
                                <li class="hateList">
                                    <label for="leg">다리</label><br>
                                </li>
                                <li class="hateList">
                                    <label for="tail">꼬리</label><br>
                                </li>
                                <li class="hateList">
                                    <label for="it">생식기</label>
                                </li>
                                <li class="hateList hateListL m_20">
                                    <label for="none">없음</label>
                                </li>

                            </ul>
                            <input type="radio" id="eye" name="hate" value="eye">
                            <input type="radio" id="nose" name="hate" value="nose">
                            <input type="radio" id="mouth" name="hate" value="mouth">
                            <input type="radio" id="ear" name="hate" value="ear">
                            <input type="radio" id="neck" name="hate" value="neck">
                            <input type="radio" id="body" name="hate" value="body">
                            <input type="radio" id="leg" name="hate" value="leg">
                            <input type="radio" id="tail" name="hate" value="tail">
                            <input type="radio" id="it" name="hate" value="it">
                            <input type="radio" id="none" name="hate" value="none">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <span>[선택] 슬개골 탈구</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="selectKneecap" id="selectKneecap" class="selectBox m_20">
                                <option value="선택">선택</option>
                                <option value="없음">없음</option>
                                <option value="1기">1기</option>
                                <option value="2기">2기</option>
                                <option value="3기">3기</option>
                                <option value="4기">4기</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <span>[선택] 특이사항</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="radioBox">
                            <ul>
                                <li class="otherslist">
                                    <label for="skin">피부병</label><br>
                                </li>
                                <li class="otherslist">
                                    <label for="heart">심장질환</label><br>
                                </li>
                                <li class="otherslist">
                                    <label for="marking">마킹</label>
                                </li>
                                <li class="otherslist otherslistL m_10">
                                    <label for="moutinung">마운팅</label>
                                </li>
                            </ul>
                            <input type="radio" id="skin" name="others" value="skin">
                            <input type="radio" id="heart" name="others" value="heart">
                            <input type="radio" id="marking" name="others" value="marking">
                            <input type="radio" id="moutinung" name="others" value="moutinung">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="text" class="basicTextInput perInfo_text m_20">
                            <p class="errorMsg">에이작스 메세지</p>
                        </td>
                    </tr>


                    <tr>
                        <td colspan="2">
                            <button id="petInfo_register" class="basicBtn" type="button">등록하기</button>
                        </td>
                    </tr>
                </table>
            </form>
		</section>

		<jsp:include page="../footer.jsp" />
	</div>
	<script type="text/javascript" src="${path}/resources/js/board/mypetRegister.js"></script>
</body>
</html>