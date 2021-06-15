$(function(){
    $("td:contains('예약완료')").css("background-color","var(--button-color)");
    $("td:contains('결제완료')").css("background-color","var(--hover-color)");
    $("td:contains('결제취소')").css("background-color","var(--trhover-color)").css("color","var(--main-color)");
});
