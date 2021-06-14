$(".menu").on("click",function(){
    
    if($(this).hasClass("nowOn") == false){
        $(".menu").removeClass("nowOn");
        $(this).addClass("nowOn");
    }else{
        $(".menu").removeClass("nowOn");
    }

    if($(this).hasClass("hs") && $("#mBoard").hasClass("activeMenu") == false){      
        $(".menu").removeClass("activeMenu");
        $(this).addClass("activeMenu");
    }else{
        $(".menu").removeClass("activeMenu");
    }
    
    if($("#mBoard").hasClass("activeMenu") == false){
        $("#mBoardm").css("display","none");
    }else{
        $("#mBoardm").css("display","block");
    }

    if($(".menu").hasClass("activeMenu") == false){
        $(".mAside").css("width","100px");
        $(".mContent").css("width","950px");
    }else{
        $(".mAside").css("width","320px");
        $(".mContent").css("width","760px");
    }
});


// placing objects inside variables
var content = $('.mContent');
var sidebar = $('.mAside');
var bmenu = $('.mMenu');
var bSideMenu = $('.mSideMenu');

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

