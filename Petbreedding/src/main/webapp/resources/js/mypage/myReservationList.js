var modal = document.getElementById("modalRe");
var modalReWin = document.getElementById("modalRe-Win");
var btnReWr = document.getElementById("btnReWr")
btnReWr.addEventListener("click", function() {
	modal.style.display = "flex";
});

var closeBtn = modal.querySelector(".modal_close_btn")
closeBtn.addEventListener("click", function() {
	modal.style.display = "none";
});

function onClickSelect (e) {
	  const isActive = e.currentTarget.className.indexOf("active") !== -1;
	  if (isActive) {
	    e.currentTarget.className = "select";
	    document.querySelector(".downArrow").innerHTML = "";
	  } else {
	    e.currentTarget.className = "select active";
	    document.querySelector(".downArrow").innerHTML += "&#9660;"
	  }
	}
document.querySelector(".select").addEventListener("click", onClickSelect);

function onClickOption(e) {
	  const selectedValue = e.currentTarget.innerHTML;
	  document.querySelector(".text").innerHTML = selectedValue;
	}

var optionList = document.querySelectorAll(".option");
for (var i = 0; i < optionList.length; i++) {
  var option = optionList[i];
  option.addEventListener("click", onClickOption);
}