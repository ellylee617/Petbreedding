package kh.com.petbreedding.Admin.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	// 사업장관리 - 제휴 승인 대기 페이지로 이동
	@RequestMapping(value = "/mwait", method = RequestMethod.GET)
	public String mWait(Locale locale, Model model) {
		return "/shop/mWaitforPartner";
	}
	
	// 사업장관리 - 제휴 취소 대기 페이지로 이동
		@RequestMapping(value = "/mcancel", method = RequestMethod.GET)
		public String mCancel(Locale locale, Model model) {
			return "/shop/mCancelPartner";
		}
		

}
