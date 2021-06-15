$(document).ready(function(){
    setDateBox();
    
    $("#browseBtn").bind("click", function() {
        insertImg();
    });
});    

// select box 연도 , 월 표시
function setDateBox(){
    var dt = new Date();
    var year = "";
    var com_year = dt.getFullYear();
    // 발행 뿌려주기
    $("#YEAR").append("<option value=''>년도</option>");
    // 올해 기준으로 -1년부터 +5년을 보여준다.
    for(var y = (com_year-20); y <= (com_year); y++){
        $("#YEAR").append("<option value='"+ y +"'>"+ y + "년" +"</option>");
    }
    // 월 뿌려주기(1월부터 12월)
    var month;
    $("#MONTH").append("<option value=''>월</option>");
    for(var i = 1; i <= 12; i++){
        $("#MONTH").append("<option value='"+ i +"'>"+ i + "월" +"</option>");
    }
    //  일 뿌려주기()
    $("#DATE").append("<option value=''>일</option>")
    for(var i = 1; i <= 31; i++) {
        $("#DATE").append("<option value='일'>" + i + "일" + "</option>");
    }
}

function insertImg() {
    $("#realInput").trigger("click");
}