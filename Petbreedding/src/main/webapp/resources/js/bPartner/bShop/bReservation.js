
$(function() {
$("#calendar").datepicker({
    dateFormat: 'yy-mm-dd' //Input Display Format 변경         
    ,prevText: '이전 달'
    ,nextText: '다음 달'	
    ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
    ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
    ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
    ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
   	,showMonthAfterYear : true
   	,daysOfWeekDisabled : [0,6]	//선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일
   	,yearSuffix: '년'
//	,minDate: new Date() //최소 선택일자(sysdate)
    ,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
	,onSelect: function(dateText, inst) {
        var date = $(this).val();
        $(".choose_date").css("display","block");
        $("#choDate").val(date).change();
   }
});                    

	//초기값을 오늘 날짜로 설정
	$('#calendar').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)            
});


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
	$("td:contains('예약완료')").css("background-color","var(--button-color)");
	$("td:contains('결제완료')").css("background-color","var(--hover-color)");
	$("td:contains('결제취소')").css("background-color","var(--trhover-color)").css("color","var(--main-color)");
	currentDay();
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
	        
		        $.each(data,function(i){
		        	
		        	html += "<tr>";
		        	console.log("상테:" + resId);
		        	if (resId == 0){
		        		html += "<td class='status' style='background:#4dbbff'>예약완료<span class='noneDis'>,</span></td>";
		        	
		        	}
		        	 if (resId == 1){
		        		html += "<td class='status' style='background:#ff9914'>결제완료<span class='noneDis'>,</span></td>";
		        	}
		        	 if (resId == 2){
		        		html += "<td class='status' style='background:#a5e6fc; color:#000'>결제취소<span class='noneDis'>,</span></td>";
		        	}
		        	
		        	html += "<td class='resTime'>"+data[i].res_date+"</td>";
		        	html += "<td class='resName'>"+data[i].name+"</td>";
		        	html += "<td class='resInfo'><a href='#'>상세보기</a></td>";
		        	html += "</tr>"
		        		console.log("받아온 상태:"+ data[i].res_status);
		        });
		        $("#revtable").empty();
		        $("#revtable").append(html);
		        html = "";
	        
	    },
	    error:function(jqxhr, textStatus, errorThrown){
	    console.log("ajax 처리 실패");
	    }
	    });
	  }else if(resId == 3){
		  console.log("전체목록조회지롱");
		  $.ajax({
			    url:"bReservationdate",
			    type:"post",
			    data:{
			    	bp_id : bp_id,
			    	res_date : res
			    	
			    	
			    },
			    dataType:"json",
			    success:function(data){
			    	console.log(data);
			    	for(var j=0; j<data.length; j++){
			    		console.log(data[j].res_status);
			    		html += "<tr>";
			        	console.log("상테:" + resId);
			        	if (data[j].res_status == 0){
			        		html += "<td class='status' style='background:#4dbbff'>예약완료<span class='noneDis'>,</span></td>";
			        	
			        	}
			        	 if (data[j].res_status == 1){
			        		html += "<td class='status' style='background:#ff9914'>결제완료<span class='noneDis'>,</span></td>";
			        	}
			        	 if (data[j].res_status == 2){
			        		html += "<td class='status' style='background:#a5e6fc; color:#000'>결제취소<span class='noneDis'>,</span></td>";
			        	}
			        	
			        	html += "<td class='resTime'>"+data[j].res_date+"</td>";
			        	html += "<td class='resName'>"+data[j].name+"</td>";
			        	html += "<td class='resInfo'><a href='#'>상세보기</a></td>";
			        	html += "</tr>"
			        		console.log("받아온 상태:"+ data[j].res_status);
			        };
			        $("#revtable").empty();
			        $("#revtable").append(html);
			        html = "";
			        console.log(resId);
			        console.log(res);
			        console.log(bp_id);
			        console.log(data);
			        console.log("성공2");
			    },
			    error:function(jqxhr, textStatus, errorThrown){
			    console.log("ajax 처리 실패");
			    }
			    });
	  }
}


//병원


function changeHos() {
	var hosselect = document.getElementById("hosselect");
	var hosId = hosselect.options[hosselect.selectedIndex].value;
	console.log(hosId);
	
	var res = $("#choDate").val();
	console.log(res);
	
	if(hosId == 0 || hosId == 1 || hosId == 2){
	$.ajax({
	    url:"bReservationHoskind",
	    data:{hos_status: hosId,
	    	hos_date : res,
	    	bp_id : bp_id
	    },
	    type:"post",
	    dataType:"json",
	    success:function(data){
	    	
	        console.log(hosId);
	        console.log(res);
	        console.log(bp_id);
	        console.log("성공");
	        
		        $.each(data,function(i){
		        	
		        	html += "<tr>";
		        	console.log("상테:" + hosId);
		        	if (hosId == 0){
		        		html += "<td class='status' style='background:#4dbbff'>예약완료<span class='noneDis'>,</span></td>";
		        	
		        	}
		        	 if (hosId == 1){
		        		html += "<td class='status' style='background:#ff9914'>결제완료<span class='noneDis'>,</span></td>";
		        	}
		        	 if (hosId == 2){
		        		html += "<td class='status' style='background:#a5e6fc; color:#000'>결제취소<span class='noneDis'>,</span></td>";
		        	}
		        	
		        	html += "<td class='resTime'>"+data[i].hos_date+"</td>";
		        	html += "<td class='resName'>"+data[i].name+"</td>";
		        	html += "<td class='resInfo'><a href='#'>상세보기</a></td>";
		        	html += "</tr>"
		        		console.log("받아온 상태:"+ data[i].hos_status);
		        });
		        $("#revtable").empty();
		        $("#revtable").append(html);
		        html = "";
	        
	    },
	    error:function(jqxhr, textStatus, errorThrown){
	    console.log("ajax 처리 실패");
	    }
	    });
	  }else if(hosId == 3){
		  console.log("전체목록조회지롱");
		  $.ajax({
			    url:"bHosReservationdate",
			    type:"post",
			    data:{
			    	bp_id : bp_id,
			    	hos_date : res
			    	
			    },
			    dataType:"json",
			    success:function(data){
			    	console.log(data);
			    	for(var j=0; j<data.length; j++){
			    		console.log(data[j].hos_status);
			    		html += "<tr>";
			        	console.log("상태:" + hosId);
			        	if (data[j].hos_status == 0){
			        		html += "<td class='status' style='background:#4dbbff'>예약완료<span class='noneDis'>,</span></td>";
			        	
			        	}
			        	 if (data[j].hos_status == 1){
			        		html += "<td class='status' style='background:#ff9914'>결제완료<span class='noneDis'>,</span></td>";
			        	}
			        	 if (data[j].hos_status == 2){
			        		html += "<td class='status' style='background:#a5e6fc; color:#000'>결제취소<span class='noneDis'>,</span></td>";
			        	}
			        	
			        	html += "<td class='resTime'>"+data[j].hos_date+"</td>";
			        	html += "<td class='resName'>"+data[j].name+"</td>";
			        	html += "<td class='resInfo'><a href='#'>상세보기</a></td>";
			        	html += "</tr>"
			        		console.log("받아온 상태:"+ data[j].hos_status);
			        };
			        $("#revtable").empty();
			        $("#revtable").append(html);
			        html = "";
			        console.log("성공2");
			    },
			    error:function(jqxhr, textStatus, errorThrown){
			    console.log("ajax 처리 실패");
			    }
			    });
	  }
}



