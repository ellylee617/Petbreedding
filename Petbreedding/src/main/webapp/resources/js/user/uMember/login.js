/**
 * 
 */
$(function() {
	$("#searchIdPw").click(function() {
		$("#modal").show();
	});

	$("#modalExit").click(function() {
		$('#modal').hide();
	});
});

$("#loginBtn").on("click",function(){
	
	console.log("들어옴");
	var dataString = $("#loginFrm").serialize();
	
	$.ajax({
		url:"member/doLoginU",
		type:"POST",
		data: dataString,
		success: function(data){
			if(data == "/uLogin"){
				$("#errorText").text("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
				
			}else if(data == "/"){
				location.href = "/petbreedding/";
			}else{
				alert("에러");
			}
		},
		error : function(error){
			alert("errorcode : "+error);
		}
	});
	
	return false;
	
});


Kakao.init('b2612abb65e5e0ec8f032250bf0aaa8f'); //아까 카카오개발자홈페이지에서 발급받은 자바스크립트 키를 입력함
//카카오 로그인 버튼을 생성합니다. 
Kakao.Auth.createLoginButton({ 
    container: '#kakao-login-btn', 
    success: function(authObj) { 
           Kakao.API.request({
 
               url: '/v1/user/me',
 
               success: function(res) {
 
                     console.log(res.id);//<---- 콘솔 로그에 id 정보 출력(id는 res안에 있기 때문에  res.id 로 불러온다)
 
                     console.log(res.kaccount_email);//<---- 콘솔 로그에 email 정보 출력 (어딨는지 알겠죠?)
 
                     console.log(res.properties['nickname']);//<---- 콘솔 로그에 닉네임 출력(properties에 있는 nickname 접근 
                             
                 // res.properties.nickname으로도 접근 가능 )
                     console.log(authObj.access_token);//<---- 콘솔 로그에 토큰값 출력
          
          var kakaonickname = res.properties.nickname;    //카카오톡 닉네임을 변수에 저장 (닉네임 값을 다른페이지로 넘겨 출력하기 위해서)
                     
          window.location.replace("http://" + window.location.hostname + ( (location.port==""||location.port==undefined)?"":":" + location.port) + "/hansub_project/home?kakaonickname="+kakaonickname);
          //로그인 결과 페이지로 닉네임 값을 넘겨서 출력시킨다.,
                   }
                 })
               },
               fail: function(error) {
                 alert(JSON.stringify(error));
               }
 });
