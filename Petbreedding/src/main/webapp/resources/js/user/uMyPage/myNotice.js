// 알림 삭제
function deleteNotice(inNotNum) {
	event.stopPropagation();

	var notNum = inNotNum;

	$("#cancel-modal").css("display","block");

	// 취소시 모달 닫기
	$("#noCalncle").on("click",function(){
		$("#cancel-modal").css("display","none");
	});
	
	// 확인 시 알림 삭제 처리
	$("#yesCalncle").on("click",function(){
		$.ajax({
			url: "notdelete.do",
			type : "POST",
			data : { notNum : notNum },
			success : function(data){
				if(data>0){
					alert("해당 알림이 지워졌습니다.");
				}else{
					alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
					
				}
			},
			error : function(error){
				alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
			}
		});
		$("#cancel-modal").css("display", "none");
		setTimeout("location.reload()", 300);
	});
}