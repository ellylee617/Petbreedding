function openchatwin(inchatId,inshopName,inbpId,inbpType) {

	var chatId = inchatId;
	var shopName = inshopName;
	var bp_id = inbpId;
	var bp_type = inbpType;
	var url = '/petbreedding/chat?chatId='+chatId+'&shopName='+shopName+'&bp_id='+bp_id+'&bp_type='+bp_type;
	window.open(url, '_blank', 'width=555px, height=700px');

	// 페이지 열면 새로고침 하여 안읽은 메시지 수 확인
	setTimeout("location.reload()", 300);

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

$(document).ready(function() {
	// 1분에 한번씩 새로고침으로 신규 채팅 체크
	setTimeout("location.reload()", 60000);
});