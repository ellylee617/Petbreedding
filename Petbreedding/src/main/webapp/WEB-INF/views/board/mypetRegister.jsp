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

</head>
<body>
	<div class="wrapper">
		<jsp:include page="../header.jsp" />

		<section class="section">
		<jsp:include page="../myPage/myPageAside.jsp" />
			<form action="" id="petInfoFrm">
				<div id="petImgBox">
					<img src="${path}/resources/images/logo.png" alt="img" alt="img">
				</div>

				<div class="petInfoBox">
					<table>
						<tr>
							<td colspan="2"><input type="text" placeholder="이름을 입력해주세요">
								<p class="errorMsg">에이작스 메세지</p></td>
						</tr>

						<tr>
							<td colspan="2"><select name="selectPet" id="selectPet"
								title="견종">
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
								<p class="errorMsg">에이작스 메세지</p></td>
						</tr>

						<tr>
							<td colspan="2"><select name="YEAR" id="YEAR" title="년도"
								class="selectTime"></select> <select name="MONTH" id="MONTH"
								title="월" class="selectTime"></select> <select name="DATE"
								id="DATE" title="일" class="selectTime"></select></td>
						</tr>

						<tr>
							<td colspan="2" class="radioBox">
								<ul>
									<li><label for="male" class="genderList">남아</label><br>
									</li>
									<li><label for="female" class="genderList">여아</label><br>
									</li>
									<li><label for="neutrality" class="genderList">중성화</label>
									</li>
								</ul> <input type="radio" id="male" name="gender" value="male">
								<input type="radio" id="female" name="gender" value="female">
								<input type="radio" id="neutrality" name="gender"
								value="neutrality">
							</td>
						</tr>

						<tr>
							<td><span>[선택] 미용 경험</span></td>
						</tr>

						<tr>
							<td colspan="2"><select name="selectBeautyEx"
								id="selectBeautyEx">
									<option value="선택">선택</option>
									<option value="없음">없음</option>
									<option value="1회">1회</option>
									<option value="2회">2회</option>
									<option value="3회 이상">3회 이상</option>
							</select></td>
						</tr>

						<tr>
							<td><span>[선택] 예방접종 유무</span></td>
						</tr>
						<tr>
							<td colspan="2"><select name="selectInjectionEx"
								id="selectInjectionEx">
									<option value="선택">선택</option>
									<option value="2차 이하">2차 이하</option>
									<option value="3차 완료">3차 완료</option>
									<option value="4차 완료">4차 완료</option>
									<option value="5차 완료">5차 완료</option>
							</select></td>
						</tr>

						<tr>
							<td><span>[선택] 입질 여부</span></td>
						</tr>
						<tr>
							<td colspan="2"><select name="selectBite" id="selectBite">
									<option value="선택">선택</option>
									<option value="안해요">안해요</option>
									<option value="해요">해요</option>
							</select></td>
						</tr>

						<tr>
							<td><span>[선택] 싫어하는 부위</span></td>
						</tr>
						<tr>
							<td colspan="2" class="radioBox">
								<ul>
									<li><label for="eye" class="hateList1">눈</label><br>
									</li>
									<li><label for="nose" class="hateList1">코</label><br>
									</li>
									<li><label for="mouth" class="hateList1">입</label></li>
									<li><label for="ear" class="hateList1">귀</label><br>
									</li>
									<li><label for="neck" class="hateList1">목</label><br>
									</li>
									<li><label for="body" class="hateList2">몸통</label></li>
									<li><label for="leg" class="hateList2">다리</label><br>
									</li>
									<li><label for="tail" class="hateList2">꼬리</label><br>
									</li>
									<li><label for="it" class="hateList2">생식기</label></li>
									<li><label for="none" class="hateList2">없음</label></li>
								</ul> <input type="radio" id="eye" name="hate" value="eye"> <input
								type="radio" id="nose" name="hate" value="nose"> <input
								type="radio" id="mouth" name="hate" value="mouth"> <input
								type="radio" id="ear" name="hate" value="ear"> <input
								type="radio" id="neck" name="hate" value="neck"> <input
								type="radio" id="body" name="hate" value="body"> <input
								type="radio" id="leg" name="hate" value="leg"> <input
								type="radio" id="tail" name="hate" value="tail"> <input
								type="radio" id="it" name="hate" value="it"> <input
								type="radio" id="none" name="hate" value="none">
							</td>
						</tr>

						<tr>
							<td><span>[선택] 슬개골 탈구</span></td>
						</tr>
						<tr>
							<td colspan="2"><select name="selectKneecap"
								id="selectKneecap">
									<option value="푸들">푸들</option>
							</select></td>
						</tr>

						<tr>
							<td><span>[선택] 특이사항</span></td>
						</tr>
						<tr>
							<td colspan="2" class="radioBox">
								<div class="container">
									<ul>
										<li><label for="skin" class="otherslist">피부병</label><br>
										</li>
										<li><label for="heart" class="otherslist">심장질환</label><br>
										</li>
										<li><label for="marking" class="otherslist">마킹</label></li>
										<li><label for="moutinung" class="otherslist">마운팅</label>
										</li>
									</ul>
									<input type="radio" id="skin" name="others" value="skin">
									<input type="radio" id="heart" name="others" value="heart">
									<input type="radio" id="marking" name="others" value="marking">
									<input type="radio" id="moutinung" name="others"
										value="moutinung">
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2"><input type="text">
								<p class="errorMsg">에이작스 메세지</p></td>
						</tr>


						<tr>
							<td colspan="2">
								<button class="petInfoRgs" type="button">등록하기</button>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</section>

		<jsp:include page="../footer.jsp" />
	</div>
	<script type="text/javascript" src="${path}/resources/js/board/mypetRegister.js"></script>
</body>
</html>