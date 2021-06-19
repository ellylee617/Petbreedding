var modal = document.getElementById("modalRe");
var modalReWin = document.getElementById("modalRe-Win");
var btnReWr = document.getElementById("btnReWr")
var selectedVal = document.getElementById("selectedVal").value;

$(function() {
	
	function onClickSelect (e) {
		const isActive = e.currentTarget.className.indexOf("active") !== -1;
		if (isActive) {
			e.currentTarget.className = "select";
			document.querySelector(".downArrow").innerHTML = "";
		} else {
			e.currentTarget.className = "select active";
			document.querySelector(".downArrow").innerHTML += "&#9660;"
		}
	}
	
	function onClickOption(e) {
		const selectedValue = e.currentTarget.innerHTML;
		document.querySelector(".text").innerHTML = selectedValue;
        selectedVal = e.currentTarget.value;
        console.log(selectedVal);
        console.log(typeof(selectedVal));
	}

    btnReWr.addEventListener("click", function() {
		modal.style.display = "flex";
	});
	
	var closeBtn = modal.querySelector(".modal_close_btn")
	closeBtn.addEventListener("click", function() {
		modal.style.display = "none";
	});

    document.querySelector(".select").addEventListener("click", onClickSelect);
	
	var optionList = document.querySelectorAll(".option");
	for (var i = 0; i < optionList.length; i++) {
		var option = optionList[i];
		option.addEventListener("click", onClickOption);
	}

    $("#regBtn").on("click", function() {
        $("#frm").attr("action", "rwrite");
        $("#frm").attr("method", "POST");
        console.log(selectedVal);
        console.log(typeof(selectedVal));
        $("#frm").submit();
    });
	
//	$("#regBtn").on("click", function(){
//		var dataString = $("#frm").serialize(); 
//		// {memberId: 입력값, memberPwd:입력값.... }
//		$.ajax({
//			url:"rwrite",
//			type:"POST",
//			data:dataString,
//			
//			success: function(data) {
//				if(data > 0) {
//					alert("리뷰 등록이 완료되었습니다.");
//					location.href="mypage";
//				} else {
//					alert("리뷰 등록 실패.");
//					$("#revCont").val("").focus();
//				}
//			},
//			error : function( jqXHR, textStatus, errorThrown ) {
//				alert( jqXHR.status );
//				alert( jqXHR.statusText );
//				alert( jqXHR.responseText );
//				alert( jqXHR.readyState );
//				}
//		});
//	});

});


