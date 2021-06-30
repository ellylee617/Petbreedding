/**
 * 
 */

$(function() {
	var qnaNum = "${qna_num}";
	console.log(qnaNum);
	$(".mTr").click(function() {
		var idVar = $(this).attr("id");
		console.log(idVar);
		goDetail(idVar);
	});
	
	function goDetail(value){
		console.log(value);
		location.href = "/petbreedding/mboardcon?qna_num="+value+"";
	}
});