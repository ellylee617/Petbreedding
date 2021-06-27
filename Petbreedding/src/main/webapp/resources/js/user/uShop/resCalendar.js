/**
 * 
 */
/*var check;
  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
    	left : 'today',
        center: 'title',
        right: 'prev,next'
      },
      navLinks: true, 
      navLinkDayClick: function(date,jsEvent){
         $(".choose_date").css("display","block");
      }    
      dateClick: function(info) {
    	check = info.dateStr;
	  },
      select: function(start, end, allDay) {
	    var today = moment().format('yyyy-MM-DD');
	    console.log("check : "+ check);
	    console.log("today : "+ today);

	    if(check < today || check == today){
	    	$(".choose_date").css("display","block");
	    }else{
	    	alert("선택할 수 없는 날짜입니다.");
	    }
	  },
    });

    
    
    calendar.render();
  });*/


$(function() {
$("#calendar").datepicker({
    dateFormat: 'yy-mm-dd' //Input Display Format 변경         
    ,prevText: '이전 달'
    ,nextText: '다음 달'	
    ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
    ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
    ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
    ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
   	,showMonthAfterYear : true
   	,daysOfWeekDisabled : [0,6]	//선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일
   	,yearSuffix: '년'
	,minDate: new Date() //최소 선택일자(sysdate)
    ,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
	,onSelect: function(dateText, inst) {
        var date = $(this).val();
        $(".choose_date").css("display","block");
        $("#choDate").val(date).change();
   }
});                    

	//초기값을 오늘 날짜로 설정
	$('#calendar').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)            
});



