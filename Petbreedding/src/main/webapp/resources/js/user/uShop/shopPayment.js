var chk1 = $("#agreeInfo2").is(":checked");
var chk2 = $("#agreeInfo3").is(":checked");
var chk3 = $("#agreeInfo4").is(":checked");
//이용동의 체크여부 확인
$("#agreeInfo1").on("click",function(){
    var chk = $(this).is(":checked");
    if(chk){
        $(".agreeAll").prop('checked', true);
    } else {
        $(".agreeAll").prop('checked', false);
    }
});

$(".agreeAll").on("click", function(){
    var allchk = $("input:checkbox[class=agreeAll]:checked").length;
    if(allchk != 3){
        $("#agreeInfo1").prop('checked',false);
    }else{
        console.log("allchk : " + allchk);
        $("#agreeInfo1").prop('checked',true); 
    }
});

/*$("#reservation_btn").on("click",function(){
    var chk = $("#agreeInfo1").is(":checked");
    if(!chk){
        alert("이용동의에 모두 체크해주세요!");
        return false;
    }
});*/

$("#pointAll").on("click",function(){
    var usingPoint = $("#nowPoint").text();
    $("#pointArea").val(usingPoint).change();   
});

//총결제 금액 뿌리기 
var total = $("#totalPrice").text();
$(function(){
	$("#payMoney").html(total);
});


//포인트 사용시 결제금액 변화
$("#pointArea").on("propertychange change keyup paste input oninput ",function(){
	var using = $("#pointArea").val();	
	
	// 전체 콤마 제거
	const number = total.replace(/,/g, "");
	const number2 = using.replace(/,/g, "");
	
	var pay = 0;
	pay = number - number2;
	pay = pay.toLocaleString();
	$("#payMoney").text(pay);
	
});