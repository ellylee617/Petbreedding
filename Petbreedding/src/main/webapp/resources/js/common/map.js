const url = new URL(window.location.href);	
// URLSearchParams 객체
const urlParams = url.searchParams;
	

	
	var y = $("#y").val();
	var x = $("#x").val();
	console.log("y좌표::" + y);
	console.log("x좌표::" + x);
	   
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	
	var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(y, x), //지도의 중심좌표.
			level: 5 //지도의 레벨(확대, 축소 정도)
			
	};
	
//지도 생성 및 객체 리턴
	var map = new kakao.maps.Map(container, options); 
//주소-좌표 변환 객체를 생성
	var geocoder = new daum.maps.services.Geocoder();
	
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(y, x),
        map: map
    });
    
    map.relayout();
    // 지도 중심을 변경한다.
    map.setCenter(y, x);
    // 마커를 결과값으로 받은 위치로 옮긴다.
    marker.setPosition(y, x);
    


