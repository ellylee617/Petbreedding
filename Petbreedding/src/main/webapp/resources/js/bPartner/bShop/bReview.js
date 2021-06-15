var modal = document.getElementById("modalReply");
var modalReWin = document.getElementById("modalReply-Win");
var btnReply = document.querySelectorAll(".btnReply");
for (var i = 0; i < btnReply.length; i++) {
	btnReply[i].addEventListener("click", function() {
		modal.style.display = "flex";
	});
}

var closeBtn = modal.querySelector(".modal_close_btn")
closeBtn.addEventListener("click", function() {
	modal.style.display = "none";
});