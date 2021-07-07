//x 버튼 누르면 모달창 띄움
$(".cancleM").on("click",function(){
	$("#cancel-modal").css("display","block");
});


$("#noCalncle").on("click",function(){
	$("#cancel-modal").css("display","none");
});


$("#yesCalncle").on("click",function(){
	var bp_Id = $("#bp_Id").val();
	
	$.ajax({
		url: "#",
		type : "POST",
		data : {bp_Id : bp_Id},
		success : function(data){
			if(data >0){
				alert("정상적으로 탈퇴신청처리 되었습니다.");
				location.href = "/petbreedding/bIndex";
			}else{
				alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
				
			}
		},
		error : function(error){
			alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
		}
	});
});