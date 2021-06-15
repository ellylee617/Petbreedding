var chk1 = $("#agreeInfo2").is(":checked");
var chk2 = $("#agreeInfo3").is(":checked");
var chk3 = $("#agreeInfo4").is(":checked");

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

$("#reservation_btn").on("click",function(){
    var chk = $("#agreeInfo1").is(":checked");
    if(!chk){
        alert("이용동의에 모두 체크해주세요!");
        return false;
    }
});

$("#pointAll").on("click",function(){
    var usingPoint = $("#nowPoint").text();
    $("#pointArea").val(usingPoint);
});
