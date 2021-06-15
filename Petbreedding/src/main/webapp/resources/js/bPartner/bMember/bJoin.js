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
    var email = $("#email").val();
    var pwd = $("#pwd").val();
    var pwdCheck = $("#pwdCheck").val();
    var name = $("#name").val();
    var hp = $("#hp").val();
    var hp2 = $("#hp2").val();
    var bNum = $("#bNum").val();
    var checkShop = $(".checkShop").is(":checked");


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
    }else if(!checkShop){
        alert("서비스 구분을 선택해주세요");
        return false;
    }

});