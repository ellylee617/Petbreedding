/**
 * 
 */

$(".goDetailRow").click(function() {
	var idVar = $(this).attr("id");
	console.log(idVar);
	
	goDetail(idVar);

});

function goDetail(value){
	console.log(value);
	location.href = "/petbreedding/mserviceDetail?ann_num="+value+"";
}