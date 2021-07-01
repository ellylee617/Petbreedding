function openbchatwin(inchatId,innickName, inshopName, inclNum) {

	var chatId = inchatId;
	var nickName = innickName;
	var shopName = inshopName;
	var cl_num = inclNum;
	var url = '/petbreedding/bchat?chatId='+chatId+'&nickName='+nickName
			+'&shopName='+shopName+'&cl_num='+cl_num;
	window.open(url, '_blank', 'width=555px, height=700px');
}