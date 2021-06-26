$(function(){
	
	$("#addItemBtn").click(function() {
		$(".insert").prepend (
				'<form  id="dynamicTable" action="${path}/bp/bMenu/write" method="POST" >\
				<label><input type="radio" name="style_deep" value="0" >메인</label>\
				<label><input type="radio" name="style_deep" class="next" value="1">서브</label>\
				<input  type="text" placeholder="메뉴" id="menu" name="style_name">\
				<input  type="text" placeholder="가격" id="price" name="price">\
				<input  type="text" placeholder="소요시간" id="time" name="style_time">\
				<button type="submit" class="basicBtn" >완료</button>\
				</form>'
		)
	});
	
});

