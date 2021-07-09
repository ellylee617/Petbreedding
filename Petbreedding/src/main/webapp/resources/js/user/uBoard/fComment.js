var boNum = $("#boUpdBoNum").val();
var closeBtn = $("#closeModalBtn");

function commentListInit(boNum) {
	$.ajax({
		url: 'bocList'
		,type: 'get'
		,contentType : "application/json; charset:UTF-8"
		,data: {boNum: boNum}
		,dataType: 'json'
		,success: function(json) {
			var div = "";
			var bocMoal = "";
			var jsonLength = Object.keys(json).length;
			console.log(json);
			console.log(jsonLength);
			if(jsonLength > 0) {
				
				$.each(json, function(index, item) {
					div += "<div class='replyArea'>"
						+ "<div class='replyUserInfo'>"
						+ "<p class='replyNickName'>"+item.clNickName+"</p>"
						+ "<p class='replyCon'>"+item.coCont+"</p>"
						+ "</div>"
						+ "<div>"
						+ "<p class='replyTime'>"+item.coDate+"</p>"
						+ "<div class='replyUpdDel'>"
						+ "<p name='"+item.coNum+"' class='fboCommentUpdBtn'>수정</p>"
						+ "<p id='"+item.coNum+"' class='fboCommentDelBtn'>삭제</p>"
						+ "</div>"
						+ "</div>"
						+ "</div>";
						
				});
				
			}
			
			$("#replyContainer").html(div);
			
			//	댓글 삭제 버튼 클릭
			$(".fboCommentDelBtn").click(function() {
				console.log("댓글 삭제 클릭 됨");
				var coIdVar = $(this).attr("id");	//	클릭된 행의 id
				$("#goTOPay_comment").attr("name", coIdVar);
				getCommentModal();
			});
			
			//	댓글 수정 버튼 클릭
			$(".fboCommentUpdBtn").click(function() {
				console.log("댓글 수정 클릭 됨")
				var coIdVar = $(this).attr("name");	//	클릭된 행의 id
				var replyCon = $(this).find('.replyCon').val();
				console.log(replyCon);
				$("#goTOPay_updComment").attr("name", coIdVar);
				getUpdCommentModal();
			});
			
			
		}
		
		,error : function(request, status, error) {
			alert("code: " + request.status + "\n"
					+ "message: "
					+ request.responseText + "\n"
					+ "error: " + error);
		}
		
	});
}

$("#bocSubmitBtn").click(function() {
	var queryString = $("#bocFrm").serialize();
	console.log(queryString);
	
	$.ajax({
		url: 'bocWrite'
		,type: 'post'
		,data: queryString
		,success: function() {
			commentListInit(boNum);
			$("#replyCont").val("").focus();
		}
		,error : function(request, status, error) {
			alert("code: " + request.status + "\n"
					+ "message: "
					+ request.responseText + "\n"
					+ "error: " + error);
		}
		
	});
});


$("#goTOPay_comment").bind("click", function() {
	var CoNumVar = $(this).attr("name");
	console.log(CoNumVar);
	
	$.ajax({
		url: "bcdelete"
		,type: "get"
		,data: {co_num : CoNumVar, bo_num : boNum}
		,success: function() {
			commentListInit(boNum);
		}
		,error : function(request, status, error) {
			alert("code: " + request.status + "\n"
					+ "message: "
					+ request.responseText + "\n"
					+ "error: " + error);
		}
	});
	
	// TODO	삭제 버튼 클릭하면 모달창 자동 닫기 기능 해야함 (지금 동작 X)
	closeModal();

});


//	자유 게시판 댓글 수정
$("#goTOPay_updComment").bind("click", function() {
	var CoNumVar = $(this).attr("name");
	var updContText = $("#replyUpdCont").val();
	console.log(CoNumVar);
	
	$.ajax({
		url: "bcupdate"
		,type: "get"
		,data: {co_num : CoNumVar, contVal : updContText}
		,success: function() {
			$("#replyUpdCont").val("");
			commentListInit(boNum);
			
		}
		,error : function(request, status, error) {
			alert("code: " + request.status + "\n"
					+ "message: "
					+ request.responseText + "\n"
					+ "error: " + error);
		}
	});
	
	// TODO	삭제 버튼 클릭하면 모달창 자동 닫기 기능 해야함 (지금 동작 X)
	closeModal();

});

// TODO	삭제 버튼 클릭하면 모달창 자동 닫기 기능 해야함 (지금 동작 X)
function closeModal() {
	console.log("닫기 버튼 함수 들어옴")
	closeBtn.click();
}