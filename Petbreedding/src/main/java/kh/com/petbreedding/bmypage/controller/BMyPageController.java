package kh.com.petbreedding.bmypage.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BMyPageController {
	
	// 사장님 마이 페이지 내정보 수정
	@RequestMapping(value = "/bMyPageUpdate", method = RequestMethod.GET)
	public String bMyPageUpdate(Locale locale, Model model) {
		
		// TODO Auto-generated method stub
		return "/myPage/bMyPageUpdate";
}
	@RequestMapping(value = "/bMenu", method = RequestMethod.GET)
	public String bMenu(Locale locale, Model model) {
		
		// TODO Auto-generated method stub
		return "/myPage/bmenu_manage";
}

}
