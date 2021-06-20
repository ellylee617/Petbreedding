var totalCheckbox = $("input[name=bP]").length;
var checkedBox = $("input[name=bP]:checked").length;

//전체선택시
$("#checkall").on("click", function(){
	
	if ($("#checkall").prop("checked") == false) {
		$("input[name=bP]").prop("checked", false);		
	} else {
		$("input[name=bP").prop("checked", true);		
	}
});

//하나라도 해지 or 각각 checkbox 눌러서
$(".inputBox").on("click", function(){
	checkedBox = $("input[name=bP]:checked").length;
	if(totalCheckbox>checkedBox){
		$("#checkall").prop("checked", false);	
	}else if(totalCheckbox == checkedBox){
		$("#checkall").prop("checked", true);
	}
});

//tr 눌러도 선택하기 및 하나해지 각각 눌러서 전체선택
/*$(".checkTR").on("click", function(){
	var thisInput = $(this).children(".inputBox").children(".checkBox");
	checkedBox = $("input[name=bP]:checked").length;
	
	if($(thisInput).prop("checked") == false){
		$(thisInput).prop("checked", true);		
	}else {
		$(thisInput).prop("checked", false);
	}	

});*/


//승인버튼 눌렀을때  //사업자번호로 체크
$("#confirmBP").on("click",function(){

	var arr = [];
	$("input[name=bP]:checked").each(function(item){
		arr.push($(this).parent().next().next().next().html());
	});
	console.log("arr : "+ arr );
	var allData = {"bp_num" : arr};
	console.log("allData : "+ allData );
	
	$.ajax({
		url : "confirmBP",
		type : "POST",
		data : {arr : arr},
		success : function(data){
			if(data > 0){
				alert("승인 처리가 완료되었습니다.");
				location.reload();
			}else{
				alert("승인처리 오류");
			}
		},
		error: function(){
			console.log("에러");
		}
		
	});
});