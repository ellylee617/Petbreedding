/**
 * 
 */

//$(function() {
	console.log("로딩");
	//maCommentInit();
	
	$("#maCommentBtn").click(function() {
		console.log("[세훈] @문의사항 댓글 등록 ajax 들어왔음");
		var queryString = $("#maCommentFrm").serialize();
		console.log(queryString);
		var qnaNum = 0;
		$.ajax({
			url: 'macWrite',
			type: 'post',
			data: queryString,
			success: function() {
				maCommentInit(qnaNum);
			},
			
			error : function(request, status, error) {
				alert("code: " + request.status + "\n"
						+ "message: "
						+ request.responseText + "\n"
						+ "error: " + error);
			}
			
		});
	});	
//});



