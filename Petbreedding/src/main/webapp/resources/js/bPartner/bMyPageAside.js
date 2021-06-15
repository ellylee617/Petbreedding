var modal = document.getElementById("cancel-modal");

// 제휴 취소 신청 누르면 모달창 띄움
var cancel = document.getElementById("cancel");

// [네] [아니오] 버튼
var no = document.getElementsByClassName("no")[0];
var yes = document.getElementsByClassName("yes")[0];

cancel.onclick = function() {
  modal.style.display = "block";
}

no.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "block";
  }
}