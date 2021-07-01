let sock;

function connect() {
	sock = new SockJS("http://localhost:8090/petbreedding/chat/");
	sock.onopen = function() {
		console.log('open');
	};
	
	sock.onmessage = function(evt) {
		console.log('온메시지 들어옴');
		var data = evt.data;
		console.log('data' + data);
		console.log(data);
		var obj = JSON.parse(data);
		console.log(obj)
		appendMessage(obj);
	};
	
	sock.onclose = function() {
		//appendMessage("연결을 끊었습니다.");
		console.log('close');
	};
}

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
		var chatAreaHeight = $("#chatArea").height();
		var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
		$("#chatArea").scrollTop(maxScroll);
	}
}

	$(document).ready(function() {
		connect();
	$('#message').keyup(function(event) {
		var keycode = event.keyCode ? event.keyCode : event.which;
		if (keycode == '13') {
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