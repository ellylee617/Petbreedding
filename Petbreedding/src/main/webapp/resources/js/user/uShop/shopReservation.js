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
var style_name2;
$("#noPlus").on("click", function(){
	style_name2 = $("#noPlus").find(".menu_item").text();
});

//예약하기
$("#reservation_btn").on("click", function(){
	var style_name = $(".chooseMenu").find(".menu_item").text();
	var dog_name = $(".chooseDog").find(".dog_name").text();
	style_name2 = $(".choosePlus").find(".menu_item").text();
	var selectDate  = $("#choDate").text();  //연월일
	var revTime = $(".chooseTime").text(); //시간
	var revDate = selectDate +" " + revTime;
	
	console.log("style_name : "+ style_name);
	console.log("dog_name : "+ dog_name);
	console.log("style_name2 : "+ style_name2);
	console.log("selectDate : "+ selectDate);
	console.log("revTime : "+ revTime);
	console.log("revDate : "+ revDate);
	
	$.ajax({
		url: doReservation,
		type: post,
		data : {
		}
	});
	
	
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



