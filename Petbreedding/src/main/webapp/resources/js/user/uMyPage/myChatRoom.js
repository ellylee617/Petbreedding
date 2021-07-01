$(document).ready(function() {
	
	// 웹소켓 연결
    connect();
    console.log("enterRoom");
    
    $('html, body').animate({
        scrollTop: $('#chatMessageArea').offset().top
    }, 'fast'); //slow    
    
    // enter 키 이벤트
	$('#message').keyup(function(e) {
         if(e.keyCode == 13 && !e.shiftKey) {
 			sendMessage();
			$('#message').val('');
			event.preventDefault();
         }
    });
	
	$('#sendBtn').click(function() {
		sendMessage();
		$('#message').val('');
	});

});
                
// 웹소켓
let sock;
 
// 입장 버튼을 눌렀을 때 호출되는 함수
function connect() {
    // 웹소켓 주소 및 객체 생성
	sock = new SockJS("http://localhost:8090/petbreedding/chat/");
	// 웹 소켓에 이벤트가 발생했을 때 호출될 함수 등록
	sock.onopen = onOpen;
	sock.onmessage = onMessage;
	sock.onclose = onClose;
 }
     
// 웹 소켓에 연결되었을 때 호출될 함수
function onOpen() {
	var chatId = $("#chatId").val();
	if(chatId==""&&chatId==null){
		chatId = 0;
	}
	// ENTER-CHAT 이라는 메세지를 보내어, Java Map에 session 추가
	message = {};
	message.chatId = chatId;
	message.mContent = "ENTER-CHAT";
	let jsonData = JSON.stringify(message);
	sock.send(jsonData);
};

function onMessage(evt) {
	console.log('온메시지 들어옴');
	var data = evt.data;
	console.log('data' + data);
	console.log(data);
	var obj = JSON.parse(data);
	console.log(obj)
	appendMessage(obj);
};
	
function onClose() {
	// appendMessage("연결을 끊었습니다.");
	console.log('close');
};


function sendMessage() {
	var msg = $("#message").val();
	if (msg != "") {
		message = {};
		message.mContent = $("#message").val();
		message.mSender = $("#sender").val();
		message.mSenderName = $("#senderName").val();
		message.mSenderemail = $("#email").val();
		message.mReceiver = $("#receiver").val();
		message.mSendTime = getTimeStamp();
		message.chatId = $("#chatId").val();
		message.cl_num = $("#cl_num").val();
		message.bp_id = $("#bp_id").val();
	}
	sock.send(JSON.stringify(message));
}

function getTimeStamp() {
	var d = new Date();
	var s = leadingZeros(d.getFullYear(), 4) + '-'
			+ leadingZeros(d.getMonth() + 1, 2) + '-'
			+ leadingZeros(d.getDate(), 2) + ' ' +

			leadingZeros(d.getHours(), 2) + ':'
			+ leadingZeros(d.getMinutes(), 2) + ':'
			+ leadingZeros(d.getSeconds(), 2);

	return s;
}

function leadingZeros(n, digits) {
	var zero = '';
	n = n.toString();

	if (n.length < digits) {
		for (i = 0; i < digits - n.length; i++)
			zero += '0';
	}
	return zero + n;
}

function appendMessage(msg) {
	var id = $("#rid").val();
	
	if (msg.mContent == '') {
		return false;
	} else {
		if(msg.mSenderemail == id){
		$("#chatMessageArea")
				.append(
						"<div class='col-12 row dMessageO'><div class='col-2 dMessage my'><div class='dNick'>"
								+ msg.mSenderName +"</div></div><br><div class='col-10 dConO my'><div class='col-12 dConI mycolor'><span>"
								+ msg.mContent + "</span></div><div class='col-12 dTimeO'><br><div>"
								+ msg.mSendTime + "</div></div></div></div><br><br><br><br>");
		} else {
			$("#chatMessageArea")
			.append(
					"<div class='col-12 row dMessageO'><div class='col-2 dMessage U'><div class='dNick'>"
							+ msg.mSenderName +"</div></div><br><div class='col-10 dConO U'><div class='col-12 dConI Ucolor'><span>"
							+ msg.mContent + "</span></div><div class='col-12 dTimeO'><br><div>"
							+ msg.mSendTime + "</div></div></div></div><br><br><br><br>");
		}
	}
	
}

//스크롤 쭉 내리기
var scHeight = $("#chatArea").prop('scrollHeight');
$("#chatArea").animate({ scrollTop: scHeight }, "slow");

