/**
 * 
 */
/* 전체 CHECK */
window.onload = function() {
	function agree() {
		var chkbox = document.getElementsByName('args');
		var chk = false;
		for (var i = 0; i < chkbox.length; i++) {
			if (chkbox[i].checked) {
				chk = true;
			} else {
				chk = false;
			}
		}
		if (chk) {
			alert("모든 약관에 동의함.");
			return false;
		} else {
			alert("모든 약관에 동의해 주세요.")
		}
	}
	document.getElementById("allAgr").onclick = function() {
		for (var i = 0; i < args.length; i++) {
			if (this.checked) {
				args[i].checked = true;
			} else {
				args[i].checked = false;
			}
		}
		};
};

	var args = document.getElementsByName("args");
	for (var i = 0; i < args.length; i++) {
		args[i].onclick = aClick;
	}

	function aClick() {
		var cnt = 0;
		var args = document.getElementsByName("args");
		for (var i = 0; i < args.length; i++) {
			if (args[i].checked) {
				cnt++
			}
		}
		if (cnt == args.length) {
			allAgr.checked = true;
		} else {
			allAgr.checked = false;
		}
	}

	/* 약관 체크 */

	


