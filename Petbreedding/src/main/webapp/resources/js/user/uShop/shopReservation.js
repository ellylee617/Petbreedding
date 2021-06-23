$("#checkService .menu_box").on("click",function(){
    $("#secondChoose").fadeIn();
});
$("#secondChoose .dog_box").on("click",function(){
    $("#thirdChoose").fadeIn();
});
$("#thirdChoose .plus").on("click",function(){
    $("#fourthChoose").fadeIn();
});
$("#fourthChoose .time").on("click",function(){
    $("#fifthChoose").fadeIn();
    $("#btnBox").fadeIn();
});

//메뉴 클릭
$(".menu_box").on("click",function(){
	if($(this).hasClass("chooseMenu") == false){
		$(".menu_box").removeClass("chooseMenu");
		$(".menu_box").addClass("normalMenu");
		$(this).addClass('chooseMenu');	
		$(this).removeClass('normalMenu');	
	}else{
		$(this).removeClass('chooseMenu');
		$(this).addClass('normalMenu');	
	}
});

//반려견 선택
$(".dog_box").on("click",function(){
	if($(this).hasClass("chooseDog") == false){
		$(".dog_box").removeClass("chooseDog");
		$(".dog_box").addClass("normalDog");
		$(this).addClass('chooseDog');	
		$(this).removeClass('normalDog');	
	}else{
		$(this).removeClass('chooseDog');
		$(this).addClass('normalDog');	
	}
});
$("#addDogBox").on("click", function(){
	location.href = "/petbreedding/Mypage/openMyPet";
});

//기타 추가요금
$(".plus").on("click",function(){
	if($(this).hasClass("choosePlus") == false){
		$(".plus").removeClass("choosePlus");
		$(".plus").addClass("normalPlus");
		$(this).addClass('choosePlus');	
		$(this).removeClass('normalPlus');	
	}else{
		$(this).removeClass('choosePlus');
		$(this).addClass('normalPlus');	
	}
});


//시간 클릭
$(".time").on("click",function(){
	if($(this).hasClass("chooseTime") == false){
		$(".time").removeClass("chooseTime");
		$(".time").addClass("normalTime");
		$(this).addClass('chooseTime');	
		$(this).removeClass('normalTime');	
	}else{
		$(this).removeClass('chooseTime');
		$(this).addClass('normalTime');	
	}
});
var style_num2;
$("#noPlus").on("click", function(){
	style_num2 = $("#noPlus").find(".styleNum").val();
});

//예약하기
$("#reservation_btn").on("click", function(){
	var style_num = $(".chooseMenu").find(".styleNum").val();
	var pet_num = $(".chooseDog").find(".petNum").val();
	style_num2 = $(".choosePlus").find(".styleNum").val();
	var res_date  = $("#choDate").text();  //연월일
	var res_time = $(".chooseTime").text(); //시간
	var cl_num = $("#clNum").val();
	var har_num = $("#harNum").val();

	$.ajax({
		url: "doReservation",
		type: "POST",
		data : {
			cl_num : cl_num,
			pet_num : pet_num,
			style_num : style_num,
			har_num : har_num,
			res_date : res_date,
			res_time : res_time,
			style_num2 : style_num2
		},
		success: function(data){
			var har_rnum = data.har_rnum;
			$("#har_rnum").val(har_rnum);
		}
	});
});

//결제 안해요~~
$("#nextTime").on("click",function(){
	location.href="/petbreedding/successRev";
});

//바로결제!!
$("#goTOPay").on("click",function(){
	var text = $("#har_rnum").val();
	location.href="/petbreedding/shopPayment?har_rnum="+text+"";
});





// 모달

function modal(id) {
    var zIndex = 9999;
    var modal = document.getElementById(id);

    // 모달 div 뒤에 희끄무레한 레이어
    var bg = document.createElement('div');
    bg.setStyle({
        position: 'fixed',
        zIndex: zIndex,
        left: '0px',
        top: '0px',
        width: '100%',
        height: '100%',
        overflow: 'auto',
        // 레이어 색갈은 여기서 바꾸면 됨
        backgroundColor: 'rgba(0,0,0,0.4)'
    });
    document.body.append(bg);

    // 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
    modal.querySelector('.modal_close_btn').addEventListener('click', function () {
        bg.remove();
        modal.style.display = 'none';
    });

    modal.setStyle({
        position: 'fixed',
        display: 'block',
        boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',

        // 시꺼먼 레이어 보다 한칸 위에 보이기
        zIndex: zIndex + 1,

        // div center 정렬
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        msTransform: 'translate(-50%, -50%)',
        webkitTransform: 'translate(-50%, -50%)'
    });
}
// Element 에 style 한번에 오브젝트로 설정하는 함수 추가
Element.prototype.setStyle = function (styles) {
    for (var k in styles) this.style[k] = styles[k];
    return this;
};
document.getElementById('reservation_btn').addEventListener('click', function () {
    // 모달창 띄우기
    modal('my_modal');
});





/*슬라이더*/ 

document.addEventListener("DOMContentLoaded", function() {

    var mySwiper = new Swiper('.swiper-container', {
        slidesPerView: 4,
        slidesPerGroup: 4,
        observer: true,
        observeParents: true,
        spaceBetween: 24,
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        breakpoints: {
            1280: {
                slidesPerView: 3,
                slidesPerGroup: 3,
            },
            720: {
                slidesPerView: 1,
                slidesPerGroup: 1,
            }
        }
    });
    
});



