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
		return "/bPartner/bMyPage/bMyPageUpdate";
	}

	// 사장님 마이 페이지 공지사항
	@RequestMapping(value = "/bNotice", method = RequestMethod.GET)
	public String bNotice(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bBoard/bNotice";
	}

	// 사장님 마이 페이지 자주 묻는 질문
	@RequestMapping(value = "/bFAQ", method = RequestMethod.GET)
	public String bFAQ(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bBoard/bFAQ";
	}

	// 사장님 마이 페이지 1:1문의 내역
	@RequestMapping(value = "/bQna", method = RequestMethod.GET)
	public String bQna(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bBoard/bQna";
	}
	
	// 사장님 마이 페이지 1:1문의하기
	@RequestMapping(value = "/bQna/write", method = RequestMethod.GET)
	public String bQnaWrite(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bBoard/bQnaWrite";
	}

	// 사장님 메뉴관리
	@RequestMapping(value = "/bMenu", method = RequestMethod.GET)
	public String bMenu(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bShop/bmenu_manage";
	}

	// 사장님 매출관리
	@RequestMapping(value = "/bCalculate", method = RequestMethod.GET)
	public String bCalculate(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bSales/bcalculate";
	}

	// 울트라콜 상품 조회
	@RequestMapping(value = "/cta", method = RequestMethod.GET)
	public String cta(Locale locale, Model model) {
		return "/bPartner/bSales/cta";

	}

	// 울트라콜 결제
	@RequestMapping(value = "/ctaPay", method = RequestMethod.GET)
	public String ctaPay(Locale locale, Model model) {
		return "/bPartner/bSales/ctaPay";

	}

	// 사장님 업체 정보 페이지로 이동
	@RequestMapping(value = "/bShop", method = RequestMethod.GET)
	public String bShop(Locale locale, Model model) {
		return "/bPartner/bShop/bShopInfo";
	}

	// 업체 리뷰 관리 페이지로 이동
	@RequestMapping(value = "/bReview", method = RequestMethod.GET)
	public String bReview(Locale locale, Model model) {
		return "/bPartner/bShop/bReview";
	}

}
