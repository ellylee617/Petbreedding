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
			var html = "";
			
			$(".zzimlist").empty();
			if(data != null){
				
				
				for(var i in data){
					if(data.bp_type == 0){
						html += "<a href='shopPage?bpId="+data.hairSalon.bpId+"&shopType="+data.bp_type+"&y="+data.hairSalon.y+"&x="+data.hairSalon.x+"'}>";
					}else if(data.bp_type == 1){
						html += "<a href='shopPage?bpId="+data.hospital.bpId+"&shopType="+data.bp_type+"&y="+data.hospital.y+"&x="+data.hospital.x+"'}>";
					}
					html += "<div class='subdiv'>";	
					html += "<div class='img'>";
					html += "<img src='${path}/resources/uploadFile/shop/${likes.har_img }' style='width:200px; height: 100px;'>";
					html += "</div>";
					html += "<div class='title'>";
					html += "<h1>"+data.hairSalon.shopName+"</h1><br>";
					html += "<p>"+data.hairSalon.shopMInfo+"</p>";
					html += "</div>";
					html += "</div>";
					html += "</a>";
					if(data.bp_type == 0){
						html += "<input type='hidden' class='har_num' value="+data.har_num+">";
					}else if(data.bp_type == 1){
						html += "<input type='hidden' class='hos_num' value="+data.hos_num+">";
					}
					html += "<div class='zzimdel'>";
					html += "<button class='zzimdelBtn basicBtn'>찜 해제</button>";
					html += "</div>";
				}	
				
				$(".zzimlist").append(html);
				html ="";
				
				
			}else{
				html += "<div class='subdiv'>";
				html += "<h1 id='notice'>찜한 매장이 없습니다.</h1>";
				html += "</div>";
				$(".zzimlist").append(html);
				html = "";
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
