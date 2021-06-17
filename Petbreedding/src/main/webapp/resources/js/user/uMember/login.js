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

