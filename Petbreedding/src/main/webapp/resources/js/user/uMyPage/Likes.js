/**
 * 
 */
var cl_num = $("#cl_num").val();
var har_num = $("#har_num").val();
var hos_num = $("#hos_num").val();
$("#zzim").on("click",function(){
	$.ajax({
		
	});
	if($("#heartOn").css("display") == "none"){
		if(har_num != null){
			$.ajax({
				url: "insertLikes",
				type:"GET",
				data:{
					cl_num : cl_num,
					har_num : har_num
				},
				success:function(data){
					console.log("성공!");

				}
			});
			
			$("#heartOn").css("display","inline-block");
			$("#heartOn").css("color","var(--hover-color)");
			$("#heartOff").css("display","none");
		}else if(hos_num != null){
			$.ajax({
				url: "insertLikes",
				type:"GET",
				data:{
					cl_num : cl_num,
					hos_num : hos_num
				},
				success:function(data){
					console.log("성공!");
				}
			});
			$("#heartOn").css("display","inline-block");
			$("#heartOn").css("color","var(--hover-color)");
			$("#heartOff").css("display","none");
		}

	}else {
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

				}
			});
			
			$("#heartOn").css("display","none");
			$("#heartOff").css("display","inline-block");
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
				}
			});
			$("#heartOn").css("display","none");
			$("#heartOff").css("display","inline-block");
		}

	}
});


function noCLient(){
	alert("로그인 후 이용 가능합니다!");
	location.href = "/petbreedding/uLogin";
}
