package kh.com.petbreedding.BP.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BPController {
	
	//  사장님회원가입 페이지로 이동
	@RequestMapping(value = "/bJoin", method = RequestMethod.GET)
	public String bJoin(Locale locale, Model model) {
		
		// TODO Auto-generated method stub
		return "/member/bJoin";
	}
	
	// 사장님 승인 대기 페이지로 이동
	@RequestMapping(value = "/bJoinSuccess", method = RequestMethod.GET)
	public String bjoinSuccess(Locale locale, Model model) {
		return "/member/bJoinSuccess";
		
	}
	
	// 사장님 제휴문의 대기 페이지로 이동
	@RequestMapping(value = "/bWait", method = RequestMethod.GET)
	public String bWait(Locale locale, Model model) {
		return "/member/bWait";
		
	}
	
	// 사장님 제휴문의 대기 페이지로 이동
	@RequestMapping(value = "/bModify", method = RequestMethod.GET)
	public String bModify(Locale locale, Model model) {
		return "/member/bModify";
		
	}
	
	// 울트라콜 상품 조회
	@RequestMapping(value = "/cta", method = RequestMethod.GET)
	public String cta(Locale locale, Model model) {
		return "/member/cta";
		
	}
	
	// 사장님 업체 정보 페이지로 이동
		@RequestMapping(value = "/bShop", method = RequestMethod.GET)
		public String bShop(Locale locale, Model model) {
			return "/myPage/bShopInfo";
			
		}

}
