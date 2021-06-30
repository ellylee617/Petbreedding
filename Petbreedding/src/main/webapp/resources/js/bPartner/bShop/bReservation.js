
function currentDay(){
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;    //1월이 0으로 되기때문에 +1을 함.
    var date = now.getDate();

    month = month >=10 ? month : "0" + month;
    date  = date  >= 10 ? date : "0" + date;
     // ""을 빼면 year + month (숫자+숫자) 됨.. ex) 2018 + 12 = 2030이 리턴됨.

    var today = ""+year+"-" + month+"-" + date;
    
    $("#choDate").val(today);
}

$(function(){
		
	currentDay();
	
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
	
	if(resId == 0 || resId == 1 || resId == 2){
	$.ajax({
	    url:"bReservationkind",
	    data:{res_status: resId,
	    	res_date : res,
	    	bp_id : bp_id
	    },
	    type:"post",
	    dataType:"json",
	    success:function(data){
	    	
	        console.log(resId);
	        console.log(res);
	        console.log(bp_id);
	        console.log("성공");
	        
	        $("#revtable").empty();
	        
	        
		        $.each(data,function(i){
		        	html += "<tr>";
		        	if (data[i].res_staus == 0){
		        		html += "<td class='status'>예약완료<span class='noneDis'>,</span></td>";
		        	}
		        	if (data[i].res_staus == 1){
		        		html += "<td class='status'>결제완료<span class='noneDis'>,</span></td>";
		        	}
		        	if (data[i].res_staus == 2){
		        		html += "<td class='status'>결제취소<span class='noneDis'>,</span></td>";
		        	}
		        	html += "<td class='resTime'>"+data[i].res_date+"</td>";
		        	html += "<td class='resName'>"+data[i].name+"</td>";
		        	html += "<td class='resInfo'><a href='#'>상세보기</a></td>";
		        });
		        $("#revtable").empty();
		        $("#revtable").append(html);
		        html = "";
	      

	        
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
	  }else{
		  console.log("전체목록조회지롱");
	  }
}


