function openchatwin(inchatId,inshopName) {

	var chatId = inchatId;
	var shopName = inshopName;
	var url = '/petbreedding/chat?chatId='+chatId+'&shopName='+shopName;
	window.open(url, '_blank', 'width=555px, height=700px');
}

// 삭제 버튼 누르면 모달창 띄움
$(".cancleM").on("click", function(e) {
	$("#cancel-modal").css("display", "block");
	e.stopPropagation();
});

$("#noCalncle").on("click", function() {
	$("#cancel-modal").css("display", "none");
});

$("#yesCalncle").on("click", function() {
	var bp_Id = $("#bp_Id").val();

	$.ajax({
		url : "bDeleteDo",
		type : "POST",
		data : {
			bp_Id : bp_Id
		},
		success : function(data) {
			if (data > 0) {
			} else {
				alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
			}
		},
		error : function(error) {
			alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
		}
	});
});