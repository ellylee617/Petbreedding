$("#down").on("click",function(){
   if($("#content").is(":visible")){ //﻿display 속성이 none이 아닐 경우 true
       $("#content").css("display","none");
       $(this).css("display","block")
   }
   else{  //﻿display 속성이 none일 경우 false
       $("#content").css("display","block");
       $(this).css("display","none")
    }
});

$("#up").on("click",function(){
	   if($("#content").is(":visible")){ //﻿display 속성이 none이 아닐 경우 true
	       $("#content").css("display","none");
	       $("#down").css("display","block")
	       
	   }
	   else{  //﻿display 속성이 none일 경우 false
	       $("#content").css("display","block");
	    }
	});