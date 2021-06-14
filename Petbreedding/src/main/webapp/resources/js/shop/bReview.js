var modal = document.getElementById("modalReply");
var modalReWin = document.getElementById("modalReply-Win");
var btnReply = document.querySelector(".btnReply")
btnReply.addEventListener("click", function() {
	modal.style.display = "flex";
});

var closeBtn = modal.querySelector(".modal_close_btn")
closeBtn.addEventListener("click", function() {
	modal.style.display = "none";
});