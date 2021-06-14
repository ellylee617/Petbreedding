$(".menu").on("click",function(){
    

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
        $(".bAside").css("width","100px");
        $(".bContent").css("width","1000px");
    }else{
        $(".bAside").css("width","320px");
        $(".bContent").css("width","780px");
    }
});

