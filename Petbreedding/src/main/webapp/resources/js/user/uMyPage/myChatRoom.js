let sock;

function connect() {
	sock = new SockJS("http://localhost:8090/petbreedding/chat/");
	sock.onopen = function() {
		console.log('open');
	};
	
	sock.onmessage = function(evt) {
		var data = evt.data;
		console.log(data);
		var obj = JSON.parse(data)
		console.log(obj)
		appendMessage(obj.message_content);
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
		message.message_content = $("#message").val()
		//message.TUTOR_USER_user_id = '${TUTOR_USER_user_id}'
		//message.USER_user_id = '${profile.user_id}'
		//message.CLASS_class_id = '${class_id}'
		//message.message_sender = '${profile.user_id}'
	}
	sock.send(JSON.stringify(message));
	sock.send($("#message").val());
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

	if (msg == '') {
		return false;
	} else {

		var t = getTimeStamp();
		$("#chatMessageArea")
				.append(
						"<div class='col-12 row' style = 'height : auto; margin-top : 5px;'><div class='col-2' style = 'float:left; padding-right:0px; padding-left : 0px;'><div style='font-size:9px; clear:both;'>${user_name}</div></div><div class = 'col-10' style = 'overflow : y ; margin-top : 7px; float:right;'><div class = 'col-12' style = ' background-color:#ACF3FF; padding : 10px 5px; float:left; border-radius:10px;'><span style = 'font-size : 12px;'>"
								+ msg
								+ "</span></div><div col-12 style = 'font-size:9px; text-align:right; float:right;'><span style ='float:right; font-size:9px; text-align:right;' >"
								+ t + "</span></div></div></div>")

		var chatAreaHeight = $("#chatArea").height();
		var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
		$("#chatArea").scrollTop(maxScroll);
	}
}
	$(document).ready(function() {
		connect();
	$('#message').keypress(function(event) {
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if (keycode == '13') {
			sendMessage();
			$('#message').val('');
		}
		event.stopPropagation();
	});

	$('#sendBtn').click(function() {
		sendMessage();
		$('#message').val('');
	});
});