/**
 * 
 */

function cutZzim(){
	var cl_num = $("#cl_num").val();
	var har_num = $(".har_num").val();
	var hos_num = $(".hos_num").val();
	
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
}