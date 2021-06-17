
// placing objects inside variables
var content = $('.bContent');
var sidebar = $('.bAside');
var bmenu = $('.bMenu');
var bSideMenu = $('.bSideMenu');
// get content and sidebar height in variables
var getContentHeight = content.outerHeight();
var getSidebarHeight = sidebar.outerHeight();

// check if content height is bigger than sidebar
if ( getContentHeight > getSidebarHeight ) {
	sidebar.css('min-height', getContentHeight);
    bmenu.css('min-height', getContentHeight);
    bSideMenu.css('min-height', getContentHeight);
}

// check if sidebar height is bigger than content
if ( getSidebarHeight > getContentHeight ) {
	content.css('min-height', getSidebarHeight);
    bmenu.css('min-height', getSidebarHeight);
    bSideMenu.css('min-height', getSidebarHeight);
}


var modal = document.getElementById("cancel-modal");

//제휴 취소 신청 누르면 모달창 띄움
var cancel = document.getElementById("cancel");

//[네] [아니오] 버튼
var no = document.getElementsByClassName("no")[0];
var yes = document.getElementsByClassName("yes")[0];

cancel.onclick = function() {
modal.style.display = "block";
}

no.onclick = function() {
modal.style.display = "none";
}

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
if (event.target == modal) {
 modal.style.display = "block";
}
}