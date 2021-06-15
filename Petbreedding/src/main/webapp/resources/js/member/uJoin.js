//아이디 유효성 검사 (1 = 중복 / 0 != 중복)
$("#email").blur(function(){
	var email = $("#email").val();
	console.log("email : "+ email);
	$.ajax({
		url : "checkEmail",
		type : "post",
		data : {email : email},
		success : function(data){
			if(data == 1){
				//1: 중복시
				$("#id_check").text("사용중이거나 탈퇴한 이메일입니다.");
				$("#id_check").css("color","red");
			}else{		
				$("#id_check").text("사용가능한 이메일입니다.");
				$("#id_check").css("color","red");
			}
		},
		error : function(){}
	});
});








$("#hpConfirm").on("click",function(){
    if($("#hp").val() == null || $("#hp").val() == ""){
        alert("핸드폰번호를 입력해주세요");
        $("#hp").focus();
        return false;
    }
    alert("인증번호를 발송했습니다.");
    $("#hpConfirm").css("display","none");
    $("#hpConfirm2").css("display","inline-block");
});
$("#hpConfirm2").on("click",function(){
    if($("#hp2").val() == null || $("#hp2").val() == ""){
        alert("인증번호를 입력해주세요");
        $("#hp2").focus();
        return false;
    }
});

$("#submitBtn").on("click",function(){
	
	var dataString = $("#frmJoin").serialize();
	$.ajax({
		url:"doJoin",
		type:"POST",
		data: dataString,
		success: function(data){
			if(data> 0){
				alert("회원가입되었습니다. 로그인페이지로 이동합니다.");
				location.href="uLogin";
			}else{
				alert("회원가입이 실패했습니다. 아이디, 비밀번호를 다시 입력해주세요.");
				$("#memberId").val("").focus();
			}
		},
		error : function(){}
	});
	
    var email = $("#email").val();
    var pwd = $("#pwd").val();
    var pwdCheck = $("#pwdCheck").val();
    var name = $("#name").val();
    var name = $("#nickName").val();
    var hp = $("#hp").val();
    var hp2 = $("#hp2").val();


    if(email == null || email == ""){
        alert("이메일을 입력해주세요");
        $("#email").focus();
        return false;
    }else if(pwd == null || pwdCheck == null || pwd== "" || pwdCheck == ""){
        alert("비밀번호를 입력해주세요");
        $("#pwd").focus();
        return false;
    }else if(pwd != pwdCheck){
        alert("비밀번호가 다릅니다");
        $("#pwdCheck").focus();
        return false;
    }else if(name == null || name == ""){
        alert("이름을 입력해주세요");
        $("#name").focus();
        return false;
    }else if(nickName == null || nickName == ""){
        alert("닉네임을 입력해주세요");
        $("#nickName").focus();
        return false;
    }else if(hp == null || hp == ""){
        alert("핸드폰번호를 입력해주세요");
        $("#hp").focus();
        return false;
    }else if(hp2 == null || hp2 == ""){
        alert("인증번호를 입력해주세요");
        $("#hp2").focus();
        return false;
    }else if(bNum == null || bNum == ""){
        alert("사업자번호를 입력해주세요");
        $("#bNum").focus();
        return false;
    }
});