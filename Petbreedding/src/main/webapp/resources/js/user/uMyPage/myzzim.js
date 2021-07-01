/**
 * 
 */
var cl_num = $("#cl_num").val();
//찜목록 뿌리기
$("#moreBtn").on("click",function(){
	$.ajax({
		url: "myzzimList",
		type:"GET",
		data:{
			cl_num : cl_num
		},
		success:function(data){
			console.log(data);
			for(var i in data){
				
			}
		}
	});
});


//찜 해제
$(".zzimdelBtn").on("click",function(){
	var har_num = $(this).parent().prev('.har_num').val();
	var hos_num = $(this).parent().prev('.hos_num').val();
	
	if(har_num != null){
		$.ajax({
			url: "delLikes",
			type:"GET",
			data:{
				cl_num : cl_num,
				har_num : har_num
			},
			success:function(data){
				console.log("성공!");
				location.reload();
			}
		});
	}else if(hos_num != null){
		$.ajax({
			url: "delLikes",
			type:"GET",
			data:{
				cl_num : cl_num,
				hos_num : hos_num
			},
			success:function(data){
				console.log("성공!");
				location.reload();
			}
		});
	}
		
});
