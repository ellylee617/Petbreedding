var modal = document.getElementById("modalRe");
var modalReWin = document.getElementById("modalRe-Win");
var btnReWr = document.getElementById("btnReWr")
var selectedEle = document.getElementById("selectedVal");

function onClickSelect (e) {
	const isActive = e.currentTarget.className.indexOf("active") !== -1;
	if (isActive) {
		e.currentTarget.className = "select";
		document.querySelector(".downArrow").innerHTML = "";
	} else {
		e.currentTarget.className = "select active";
		document.querySelector(".downArrow").innerHTML += "&#9660;"
	}
}

function onClickOption(e) {
	const selectedValue = e.currentTarget.innerHTML;
	document.querySelector(".text").innerHTML = selectedValue;
	selectedEle.value = e.currentTarget.value;
    console.log(selectedEle.value);
    console.log(typeof(selectedEle.value));
}

$(".btnReWr").on("click", function(){
	modal.style.display = "flex";
});

var closeBtn = modal.querySelector(".modal_close_btn")
closeBtn.addEventListener("click", function() {
	modal.style.display = "none";
});

document.querySelector(".select").addEventListener("click", onClickSelect);
	
	var optionList = document.querySelectorAll(".option");
	for (var i = 0; i < optionList.length; i++) {
		var option = optionList[i];
		option.addEventListener("click", onClickOption);
}

$("#regBtn").on("click", function() {
    $("#frm").attr("action", "rwrite");
    $("#frm").attr("method", "POST");
    $("#frm").submit();
});


//조회하기 눌렀을떄
$("#searchDate").on("click",function(){
	var cl_num = $("#cl_num").val();
	var res_date = $("#start").val();
	var res_date2 = $("#end").val();
	
	if((res_date == null || res_date =="") && (res_date2 == null || res_date2 =="")){
		alert("조회하실 날짜를 입력해주세요!");
		return false;
	}else{
		$.ajax({
			url:"mypage2",
			type:"POST",
			data :{
				cl_num : cl_num,
				res_date : res_date,
				res_date2 : res_date2
			},
			success: function(data){
				
				$(".rlist").empty();
				
				var tr = "";
				tr += "<tr id='rListHead'>";
				tr += "<td>예약일</td>";
				tr += "<td>예약정보</td>";
				tr += "<td colspan='2'>상태</td>";
				tr += "</tr>";
				
				$(".rlist").append(tr);
				 
 
				if(data.length>0){//데이터가 있으면
					
		          for(var i in data){//데이터를 하나씩 뽑아냄
		          //i번째 data 중 key가 id인 것의 value
		            var $res_date = data[i].res_date;
		          //i번째 data 중 key가 name인 것의 value
		            var $har_name = data[i].har_name; 
		            var $res_status = data[i].res_status;
		            var res_status;
		            if($res_status == 0){
		            	res_status = "결제대기";
		            }else if($res_status == 1){
		            	res_status = "결제완료";
		            }else if($res_status == 2){
		            	res_status = "이용완료";
		            	
		            }else if($res_status == 3){
		            	res_status = "결제취소";
		            }
		            
		            var td = "";
		            td += "<tr>";
		            td += "<td>"+$res_date+"</td>";
		            td += "<td>"+$har_name+"</td>";
		            if(res_status == "이용완료"){
		            	 td += "<td>"+res_status+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
		            	 "<button type='button' class='basicBtn review btnReWr'>리뷰작성</button>"
		            	 +"</td>";
		            }else{
		            	td+= "<td>"+res_status+"</td>";
		            }
		            td += "</tr>";

		            $(".rlist").append(td);

		          }
		          
		         }else{
		        	 var td = "";
		        	 td += "<tr>";
		        	 td += "<td colspan='4'>해당 기간에 예약하신 내역이 없습니다.</td>";
		        	 td += "</tr>";
		        	 $(".rlist").append(td);
		         }   
				
				
				
				
			}
		});
	}
	
	
});

//	$("#regBtn").on("click", function(){
//		var dataString = $("#frm").serialize(); 
//		// {memberId: 입력값, memberPwd:입력값.... }
//		$.ajax({
//			url:"rwrite",
//			type:"POST",
//			data:dataString,
//			
//			success: function(data) {
//				if(data > 0) {
//					alert("리뷰 등록이 완료되었습니다.");
//					location.href="mypage";
//				} else {
//					alert("리뷰 등록 실패.");
//					$("#revCont").val("").focus();
//				}
//			},
//			error : function( jqXHR, textStatus, errorThrown ) {
//				alert( jqXHR.status );
//				alert( jqXHR.statusText );
//				alert( jqXHR.responseText );
//				alert( jqXHR.readyState );
//				}
//		});
//	});



