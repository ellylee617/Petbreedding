$(function() {
	$("#searchIdPw").click(function() {
		$("#modal").show();
	});

	$("#modalExit").click(function() {
		$('.searchModal_Container').hide();
	});
});


$("#loginBtn").on("click", function() {

	var dataString = $(".blFrm").serialize();
	
	$.ajax({
		url : "member/doLoginB",
		type : "POST",
		data : dataString,
		success : function(data) {
			if (data == "/bLogin") {
				$("#errorText").text("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
			} else if (data == "/bReservation") {
				location.href = "/petbreedding/bReservation";
			} else {
				alert("에러");
			}
		},
		error : function(error) {
			$("#errorText").text("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
		}
	});

	return false;

});