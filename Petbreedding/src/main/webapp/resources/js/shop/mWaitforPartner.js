var cnt = 0;
// 체크박스 갯수 체크용
$(document).ready(function() {

	// tr로 check되도록 클릭 이벤트
	$("table tr").click(function() {
		// 클릭된 tr의 td의 체크 박스를 찾아서
		var checkbox = $(this).find('td:first-child :checkbox');
		// td가 아닌 th(전체선택)은 $(this).find('td:first-child :checkbox');에서
		// find 되어지지 않으므로 length==0
		if (checkbox.length == 0) {
			checkAll();
		} else {
			// 체크가 안되어있다면 체크
			if (checkbox.prop("checked") == false) {
				checkbox.prop("checked", true);
				cnt++;
				if (cnt == 10) {
					$("#checkall").prop("checked", true);
				} else {
					$("#checkall").prop("checked", false);
				}
			} else {
				// 체크 되어있는데 클릭했다면 해제
				checkbox.prop("checked", false);
				cnt--;
				if (cnt == 10) {
					$("#checkall").prop("checked", true);
				} else {
					$("#checkall").prop("checked", false);
				}
			}
		}
	});
});

function checkAll() {
	// 전체 선택일때만 진입
	if ($("#checkall").prop("checked") == false) {
		$("input[type=checkbox]").prop("checked", true);
		cnt = 10;
	} else {
		$("input[type=checkbox").prop("checked", false);
		cnt = 0;
	}
}