/**
 * 
 */

$(function() {
	console.log("로딩");
	maCommentInit();
	
	$("#maCommentBtn").click(function() {
		console.log("[세훈] @문의사항 댓글 등록 ajax 들어왔음");
		var queryString = $("#maCommentFrm").serialize();
		console.log(queryString);
		
		$.ajax({
			url: 'macWrite',
			type: 'post',
			data: queryString,
			success: function() {
				maCommentInit();
			},
			
			error : function(request, status, error) {
				alert("code: " + request.status + "\n"
						+ "message: "
						+ request.responseText + "\n"
						+ "error: " + error);
			}
			
		});
	});	
});


function maCommentInit() {
	console.log("조회 함수 들어옴");
	$.ajax({
		
		url: 'macList',
		type:'get',
		contentType : "application/json; charset:UTF-8",
		data: {qna_num: 'Q1' },
		dataType: 'json',
		success: function(json) {
			var div = "";
			var jsonLength = Object.keys(json).length;
			console.log(json);
			console.log(jsonLength);
			if(jsonLength > 0) {
					$("#maCommentText").hide();
					$("#maCommentBtn").hide();
					
					div +=	"<div>"
							+json.qnacCont
							+"</div>"
							+"<form id='maCommentFrm' class='maCommentFrm'>"
							+"<button class='basicBtn' id='maCommentUpBtn'>수정</button>"
							+"<button class='basicBtn' id='maCommentDelBtn'>삭제</button>"
							+"</form>";
				
			} else {
				div += "<form id='maCommentFrm' class='maCommentFrm'>"
					+"<textarea id='maCommentText' name='maCommentText'></textarea>"
					+"<button class='basicBtn' id='maCommentBtn'>등록</button>";
			}
			
			$("#replyArea").html(div);
			},
			
		error : function(request, status, error) {
			alert("code: " + request.status + "\n" + "message: "
					+ request.responseText + "\n" + "error: "
					+ error);
		}
			
			
	});
}