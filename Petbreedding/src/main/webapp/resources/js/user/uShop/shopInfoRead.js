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

$("#upToDate").on("click", function() {
	var type = 0;
	reviewInit(bpId, path, type);
});

$("#ascendingStar").on("click", function() {
	var type = 1;
	
	reviewInit(bpId, path, type);
});
$("#descendingStar").on("click", function() {
	var type = 2;
	
	reviewInit(bpId, path, type);
});



// 문의하기 버튼 클릭 시 채팅으로 연결
function openchatwin(inbpId,inshopName,inbpType) {

	var bp_id = inbpId;
	var shopName = inshopName;
	var bp_type = inbpType;
	var url = '/petbreedding/chat?shopName='+shopName+'&bp_id='+bp_id+'&bp_type='+bp_type;
	window.open(url, '_blank', 'width=555px, height=700px');
}


function reviewInit(bpId, path, type) {
	console.log("리뷰 조회 함수 들어옴")
	console.log(bpId);
	console.log(path);
	
	$.ajax({
		url: "rList"
		,type: "get"
		,contentType : "application/json; charset:UTF-8"
		,data: {bp_id : bpId, type : type}
		,dataType: 'json'
		,success: function(json) {
			var div = "";
			var jsonLength = Object.keys(json).length;
			console.log(jsonLength);
			console.log(json);
			
			if(jsonLength > 0) {
				
				$.each(json, function(index, item) {
					var revVal = item.revVal;
					console.log(item.revImg);
					div += "<div class='review'>"
						+ "<div class='reviewWord'>"
						+ "<div class='star_img'>";
						switch(revVal) {
						case 1:
							div += "<i class='fas fa-star rate'></i>";
							break;
						case 2:
							div += "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>";
							break;
						case 3:
							div += "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>";
							break;
						case 4:
							div += "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>";
							break;
						case 5:
							div += "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>";
							break;
						}
					div += "<span class='reviewScore'>"+item.revVal+".0</span>"
						+ "</div>"
						// 별점 끝
						+ "<div class='reviewCon'>"
						+ "<p>"+item.revCont+"</p>"
						+ "</div>"
						// 리뷰 내용 끝
						+ "<div class='reviewInfo'>"
						+ "<span>"+item.clNickName+"</span>"
						+ "<span class='reviewDate'>"+item.revDate+" 방문</span>"
						+ "</div>"
						// 고객 닉네임, 방문날짜 끝
						+ "</div>";
						// reviewWord 끝
					if(item.revImg == "none") {
					div += "<div class='review_imgBox'>"
						+ "<img class='review_img' src='"+path+"/resources/images/logoForChat.png'>"
						+ "</div>"
						+ "</div>";
					} else {
					div	+= "<div class='review_imgBox'>"
						+ "<img class='review_img' src='"+path+"/resources/uploadFile/review/"+item.revImg+"'>"
						+ "</div>"
						+ "</div>";
					}
						
					if(item.revComment != null) {
						div += "<div class='reply'>"
							+ "<div class='replyCon'>"
							+ "<p>"+item.revComment.revcCont+"</p>"
							+ "</div>"
							+ "<div class='replyInfo'>"
							+ "<span>"+shopName+"</span>"
							+ "<span class='replyDate'>"+item.revComment.revcDate+"</span>"
							+ "</div>"
							+ "</div>";
					} else {
						
					}

//                         <div class="reply">
//                         <div class="replyCon">
//                             <p>또비언니님 찾아주셔서 감사합니다.</p>
//                             <p>다음에 더 좋은 서비스로 보답하겠습니다.</p>
//                         </div>
//                         <div class="replyInfo">
//                             <span>쿨펫미용실</span>
//                             <span class="replyDate">2021-05-31 11:30</span>
//                         </div>
//                     </div>
				});
			} else {
				
			}
			
			$("#reviewArea").html(div);
			
		}
		,error : function(request, status, error) {
			alert("code: " + request.status + "\n" + "message: "
					+ request.responseText + "\n" + "error: "
					+ error);
		}
	});
}



