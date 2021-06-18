var getCheck= RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$/);
var getPhone = RegExp(/^[0-9]{2,3}[0-9]{3,4}[0-9]{4}/);


//비밀번호 유효성 체크
$("#pwd").blur(function(){
	var pwd = $("#pwd").val();


	if(pwd == "null" || pwd == ""){
		$("#pw_check").text("필수 정보입니다.");
		$("#pw_check").css("color","red");
	}else if(!getCheck.test(pwd)){
		$("#pw_check").text("비밀번호는 영문,숫자,특수문자(!@$%^&* 만 허용)를 조합하여 8~12자로 구성하세요.");
		$("#pw_check").css("color","red");
	}else{
		$("#pw_check").text("사용가능한 비밀번호입니다.");
		$("#pw_check").css("color","green");
	}	
});

//비밀번호 값 확인
$("#pwdCheck").blur(function(){
	var pwdCheck = $("#pwdCheck").val();
	var pwd = $("#pwd").val();

	if(pwdCheck == "null" || pwdCheck == ""){
		$("#pw_check2").text("필수 정보입니다.");
		$("#pw_check2").css("color","red");
	}else if(pwd != pwdCheck ){
		$("#pw_check2").text("비밀번호가 일치하지 않습니다.");
		$("#pw_check2").css("color","red");
	}else{
		$("#pw_check2").text("비밀번호가 일치합니다.");
		$("#pw_check2").css("color","green");
	}	
});

//닉네임 중복 및 유효성 검사 (1 = 중복 / 0 != 중복)
$("#nickName").blur(function(){
	var nickName = $("#nickName").val();
	$.ajax({
		url : "checkNickName",
		type : "post",
		data : {nickname : nickName},
		success : function(data){
			console.log("다녀왔어용");
			if(data == 1){
				//1: 중복시
				$("#nickName_check").text("사용중인 닉네임입니다.");
				$("#nickName_check").css("color","red");
			}else{	
				if(nickName == "null" || nickName == ""){
					$("#nickName_check").text("필수 정보입니다.");
					$("#nickName_check").css("color","red");
				}else{
					$("#nickName_check").text("멋진 닉네임이네요.");
					$("#nickName_check").css("color","green");
				}	
			}
		},
		error : function(){
			console.log("실패");
		}
	});
});


//휴대폰번호 유효성 체크  중복체크
$("#sendMessage").on("click",function(){
	var tel = $("#hp").val();
	
	$.ajax({
		url : "checkHp",
		type : "post",
		data : {tel: tel},
		success : function(data){
			if(data == 1){
				//1: 중복시
				$("#hp2_check").text("이미 등록된 휴대폰 번호입니다.");
				$("#hp2_check").css("color","red");
			}else{	
				if(tel == "null" || tel == ""){
					$("#hp2_check").text("필수 정보입니다.");
					$("#hp2_check").css("color","red");
				}else if(!getPhone.test(tel)){
					$("#hp2_check").text("형식에 맞게 입력해주세요.");
					$("#hp2_check").css("color","red");
				}else if(tel.length>12){
					$("#hp2_check").text("형식에 맞게 입력해주세요.");
					$("#hp2_check").css("color","red");
				}else{
					$("#hp2_check").text("");
					 alert("인증번호를 발송했습니다.");
				    $("#hpConfirm").css("display","none");
				    $("#hpConfirm2").css("display","inline-block");
				    checkHp();
				}	
			}
		},
		error : function(){
			console.log("실패");
		}
	});
});

//인증번호 전송
function checkHp(){
	var tel = $("#hp").val();
	$.ajax({
		url: "phone",
		type : "post",
		data : {tel : tel},
		success : function(data){
			console.log("인증번호 : "+ data);
			$("#hpConfirm2").on("click",function(){
			    if($("#hp2").val() == null || $("#hp2").val() == ""){
			        $("#hp2_check").text("인증번호를 입력해주세요");
			        $("#hp2_check").css("color","red");
			        $("#hp2").focus();
			        return false;
			    }else if($("#hp2").val() == data){
			    	 $("#hp2_check").text("인증번호가 확인되었습니다");
    			     $("#hp2_check").css("color","green");
			    }
			});						    			
		}
		,error : function(data){
			console.log("error : "+ data);
		}
	
});
}


//회원정보수정
$("#modify").on("click",function(){
	
	var dataString = $("#updFrm").serialize();
	console.log(dataString);
	if($("#pwd").val()!=null || $("#pwd").val() != "" && $("#pwd2").val()!=null || $("#pwd2").val()!=""){
			$.ajax({
				url:"mypage/uModify",
				type:"POST",
				data: dataString,
				success: function(data){
					console.log("data : "+ data);
					if(data > 0){
						alert("회원정보 수정이 완료되었습니다.");
						location.href="/petbreedding/uModify";
					}else {
						location.href="/petbreedding/uModify";
					}
				},
				error : function(error){
					$("#error").text("입력정보를 다시 확인해주세요.");
					$("#error").css("color","red");
				}
			});
	}else{
		$("#error").text("모든 정보를 입력하셔야 수정이 가능합니다.");
		$("#error").css("color","red");
	}
	
	return false;
   
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
    $(".refuse").on("click", function(){
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
    
  //변경된 휴대폰 번호 input에 다시 넣기
    $("#confirm").on("click",function(){
    	
    	var tel = $("#tel").val();
    	
    	if($("#hp2_check").text() == "인증번호가 확인되었습니다"){
    		$("#change").val(tel);
    		bg.remove();
            modal.style.display = 'none';
    	}else{
    		alert("입력 정보를 확인해주세요");
    	}

    });

    //변경된 휴대폰 번호 input에 다시 넣기
    $("#confirm2").on("click",function(){
    	
    	var nickName = $("#nickName").val();
    	
    	if($("#nickName_check").text() == "멋진 닉네임이네요."){
    		$("#changeN").val(nickName);
    		bg.remove();
            modal.style.display = 'none';
    	}else{
    		alert("입력 정보를 확인해주세요");
    	}

    });
}
// Element 에 style 한번에 오브젝트로 설정하는 함수 추가
Element.prototype.setStyle = function (styles) {
    for (var k in styles) this.style[k] = styles[k];
    return this;
};

//휴대폰
document.getElementById('changeTel').addEventListener('click', function () {
    // 모달창 띄우기
    modal('my_modal');
});

//닉네임
document.getElementById('changeNic').addEventListener('click', function () {
    // 모달창 띄우기
    modal('my_modal2');
});


