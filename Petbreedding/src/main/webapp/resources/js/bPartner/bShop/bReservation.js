$(function(){
		
	
	
	$("td:contains('예약완료')").css("background-color","var(--button-color)");
    $("td:contains('결제완료')").css("background-color","var(--hover-color)");
    $("td:contains('결제취소')").css("background-color","var(--trhover-color)").css("color","var(--main-color)");
});

var bp_id =  $("#bp_id").val();
var html = "";

function change() {
	var resselect = document.getElementById("resselect");
	var resId = resselect.options[resselect.selectedIndex].value;
	console.log(resId);
	
	var res = $("#choDate").val();
	console.log(res);
	
	$.ajax({
	    url:"bReservationkind",
	    data:{res_status: resId,
	    	res_date : res,
	    	bp_id : bp_id
	    },
	    type:"post",
	    success:function(data){
	        console.log(resId);
	        console.log(res);
	        console.log(bp_id);
	        console.log(name);
	        console.log("성공");
//	        console.log(data);
//	        
//	        for(var i in data){
//	        if(resId == 0) { //0: 예약완료 / 1: 결제완료  /  2: 결제취소  / 3 : 전체보기 
//	        	console.log("0이다");
//	        	html += "<tr>";
//	        	html += "<td class='status'>예약완료";
//	        	html += "<span class=''>";
//	        	html += "<td class='resTime'>"+res[i];
//	        	html += "<td class='resName'>"+name[i]
//	        }
//	        }
	        
//	        location.href = "bReservationkind?res";
	    },
	    error:function(jqxhr, textStatus, errorThrown){
	    console.log("ajax 처리 실패");
	    }
	    });
	
	
}

//날짜 조회
