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

$("#loginBtn").on("click", function() {

	console.log("들어옴");
	var dataString = $("#loginFrm").serialize();

	$.ajax({
		url : "member/doLoginU",
		type : "POST",
		data : dataString,
		success : function(data) {
			if (data == "/uLogin") {
				$("#errorText").text("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");

			} else if (data == "/") {
				location.href = "/petbreedding/";
			} else {
				alert("에러");
			}
		},
		error : function(error) {
			alert("errorcode : " + error);
		}
	});

	return false;

});



const kakao = {
	clientID : "a860c31780498929b7a9fa95ed725bf5", // RESET API 키
	clientSecret : "Osq8t7qXdVClBMeuXl54n8vYlkOR6NUa",
	redirectUri : "http://localhost:8090/petbreedding/kakaoLogin"
};