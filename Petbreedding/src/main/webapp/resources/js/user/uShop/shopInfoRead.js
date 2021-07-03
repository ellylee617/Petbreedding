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


// 문의하기 버튼 클릭 시 채팅으로 연결
function openchatwin(inbpId,inshopName,inbpType) {

	var bp_id = inbpId;
	var shopName = inshopName;
	var bp_type = inbpType;
	var url = '/petbreedding/chat?shopName='+shopName+'&bp_id='+bp_id+'&bp_type='+bp_type;
	window.open(url, '_blank', 'width=555px, height=700px');
}



