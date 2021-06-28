function openbchatwin(inchatId,innickName, inshopName) {

	var chatId = inchatId;
	var nickName = innickName;
	var shopName = inshopName;
	var url = '/petbreedding/bchat?chatId='+chatId+'&nickName='+nickName
			+'&shopName='+shopName;
	window.open(url, '_blank', 'width=555px, height=700px');
}