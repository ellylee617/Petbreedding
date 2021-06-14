$(".menu").on("click",function(){
    
    if($(this).hasClass("nowOn") == false){
        $(".menu").removeClass("nowOn");
        $(this).addClass("nowOn");
    }else{
        $(".menu").removeClass("nowOn");
    }

    if($(this).hasClass("hs") && $("#bShop").hasClass("activeMenu") == false){      
        $(".menu").removeClass("activeMenu");
        $(this).addClass("activeMenu");
    }else if($(this).hasClass("hs") && $("#bMyPage").hasClass("activeMenu") == false){
        $(".menu").removeClass("activeMenu");
        $(this).addClass("activeMenu");
    }else{
        $(".menu").removeClass("activeMenu");
    }
    
    if($("#bShop").hasClass("activeMenu") == false){
        $("#bShopM").css("display","none");
    }else{
        $("#bShopM").css("display","block");
    }

    if($("#bMyPage").hasClass("activeMenu") == false){
        $("#bMyPageM").css("display","none");
    }else{
        $("#bMyPageM").css("display","block");
    }

    if($(".menu").hasClass("activeMenu") == false){
        $(".bAside").css("width","110px");
        $(".bContent").css("width","990px");
    }else{
        $(".bAside").css("width","320px");
        $(".bContent").css("width","780px");
    }
});


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

