/**
 * 
 */
$(function() {
	$("#searchIdPw").click(function() {
		$("#modal").show();
	});

	$("#modalExit").click(function() {
		$('#modal').hide();
	});
});

$("#loginBtn").on("click",function(){
	
	console.log("들어옴");
	var dataString = $("#loginFrm").serialize();
	
	$.ajax({
		url:"member/doLoginU",
		type:"POST",
		data: dataString,
		success: function(data){
			location.href= data;	
		},
		error : function(){
			location.href= data;	
		}
	});
	
});