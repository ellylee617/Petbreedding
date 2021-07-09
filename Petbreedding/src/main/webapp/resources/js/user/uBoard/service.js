$(document).ready(function() {
$(".que").click(function() {
    $(this).next(".anw").stop().slideToggle(300);
   $(this).toggleClass('on').siblings().removeClass('on');
   $(this).next(".anw").siblings(".anw").slideUp(300); // 1개씩 펼치기
 });


 $(".que2").click(function() {
    $(this).next(".anw2").stop().slideToggle(300);
   $(this).toggleClass('on').siblings().removeClass('on');
   $(this).next(".anw2").siblings(".anw2").slideUp(300); // 1개씩 펼치기
 });
});

// myboard 전체선택
function selectAll(selectAll)  {
    const checkboxes = document.getElementsByName('board');
    checkboxes.forEach((checkbox) => {
      checkbox.checked = selectAll.checked;
    });
  }

//boardDetail로 이동
$(".goToBoardDetail").on("click",function(){
	var boNum = $(this).find('input').val();
	console.log("boNum : "+ boNum);
	location.href = "fboardcon?boNum="+boNum+"";
});

// bmenu
function tableCreate(){
	  var tc = new Array();
	  var html = '';
	        
	  var menu = $("#menu").val();
	  var price = $("#price").val();
	        
	  html += '<tr>';
	  html += '<td>'+menu+'</td>';
	  html += '<td>'+price+'</td>';
	 
	  html += '</tr>';
	        
	  $("#dynamicTable").append(html);
	        
	  $("#menu").val('');
	  $("#price").val('');
	  }

	  function tableDelete(){
	    $('#dynamicTable tbody tr:last').remove();
	    }