/**
 * 
 */
var cl_num = $("#cl_num").val();
var har_num = $("#har_num").val();
var hos_num = $("#hos_num").val();
$("#zzim").on("click",function(){
	if($("#heartOn").css("display") == "none"){
		
		if(har_num != null){
			$.ajax({
				url: "insertLikes",
				type:"GET",
				data:{
					cl_num : cl_num,
					har_num : har_num
				},
				success:function(){
					$("#heartOn").css("display","inline-block");
					$("#heartOn").css("color","var(--hover-color)");
					$("#heartOff").css("display","none");
				}
			});
		}else if(hos_num != null){
			$.ajax({
				url: "insertLikes",
				type:"GET",
				data:{
					cl_num : cl_num,
					hos_num : hos_num
				},
				success:function(){
					$("#heartOn").css("display","inline-block");
					$("#heartOn").css("color","var(--hover-color)");
					$("#heartOff").css("display","none");
				}
			});
		}

	}else {
		$("#heartOn").css("display","none");
		$("#heartOff").css("display","inline-block");
	}
});

