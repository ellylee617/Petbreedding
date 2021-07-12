/**
 * 
 */

$(".mTr").click(function() {
	var idVar = $(this).attr("id");
	console.log(idVar);
	goDetail(idVar);
});


$("#selectQnaType").on("change", function() {
	var qnaType = $(this).val();
	var selectQnaChk = $("#selectQnaChk");
	var qnaChk = selectQnaChk.val();
	
	console.log(qnaType);
	console.log(qnaChk);
	
	mboardInit(qnaType, qnaChk);
});

$("#selectQnaChk").on("change", function() {
	var qnaChk = $(this).val();
	var selectQnaType = $("#selectQnaType");
	var qnaType = selectQnaType.val();
	
	console.log(qnaType);
	console.log(qnaChk);
	
	mboardInit(qnaType, qnaChk);
});


function goDetail(value){
	console.log(value);
	location.href = "/petbreedding/mboardcon?qna_num="+value+"";
}


function mboardInit(qnaType, qnaChk) {
	console.log("ajax 함수 진입")
	console.log(qnaType);
	console.log(qnaChk);
	
	$("#myAskBox").hide();
	$("#page_wrap").hide();
	
	
	$.ajax({
		url: "mboardAjax"
		,type: "get"
		,data: {qnaType: qnaType, qnaChk : qnaChk}
		,dataType: "json"
		,success: function(json) {
			var div = "";
			var page = "";
			var jsonLength = Object.keys(json).length;
			
			console.log(json);
			console.log(jsonLength);
			
//			if(jsonLength > 0) {
				
				
				$.each(json, function(index, item) {
					
					var length = item.length;
					console.log(length);
//					console.log(item[length]);
//					for(var i = 0; i < length; i++) {
						
						div += "<tr id='"+item.qnaNum+"' class='mTr'>";
						
						if(item.qnaType == 1) {
							div += "<td>[회원]</td>";
						} else {
							div += "<td>[사업자]</td>";
						}
						
						div += "<td>"+item.qnaTitle+"</td>"
						+ "<td>"+item.qnaWr+"</td>"
						+ "<td>"+item.qnaDate+"</td>";
						
						if(item.qnaChk == 0) {
							div += "<td><button class='basicBtn' id='waitBtn'>답변대기</button></td>";
						} else {
							div += "<td><button class='basicBtn' id='successBtn'>답변완료</button></td>";
						}
						
//						page += "<div id='page_nation' class='page_nation'>";
//						
//						if(item.paging.startPage != 1) {
//							page += "<a class='arrow prev' href='/petbreedding/mboard?nowPage="+item.paging.startPage+"&cntPerPage="+item.paging.cntPerPage+"'>이전</a>"
//						}
						
						
//					}
						 
				});
				
				$("#myAskBoxAjax").html(div);
//			} else {
//			}
			
		}
	
		,error : function(request, status, error) {
			alert("code: " + request.status + "\n" + "message: "
					+ request.responseText + "\n" + "error: "
					+ error);
		}
		
	});
}
