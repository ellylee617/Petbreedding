package kh.com.petbreedding.bmypage.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.bmypage.model.service.BInfoService;
import kh.com.petbreedding.bmypage.model.service.ShopService;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;

@Controller
public class BMyPageController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private BInfoService bInfoService;

	// 사장님 마이 페이지 내정보 수정
	@RequestMapping(value = "/bMyPageUpdate", method = RequestMethod.GET)
	public String bMyPageUpdate(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bMyPage/bMyPageUpdate";
	}
	
	// 사장님 마이 페이지 내정보 수정 처리
	@RequestMapping(value = "bP/bMyPageUpdate", method = RequestMethod.POST)
	@ResponseBody
	public int bMyPageUpdateDo(BPartner bP, HttpSession session) {

		int result = bInfoService.updateBPInfo(bP);
		if(result>0) {
			session.setAttribute("bP", bP);
		}
		return result;
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


	// 사장님 사업장 관리 - 사업자 등록 페이지 이동
	@RequestMapping(value = "/bShop", method = RequestMethod.GET)
	public String bShop() {
		return "/bPartner/bShop/bShopInfo";
	}
	
	// 사장님 사업장 관리 - 사업자 등록 기능 (미용실) 
	@RequestMapping(value = "/bShop/write", method = RequestMethod.GET)
	public String bShopWrite(HairSalon vo) {
		
		
		System.out.println(vo.toString());
		shopService.insertHarInfo(vo);
		
		
		return "/bPartner/bIndex";	//TODO:수정해야됨!!!!
	}
	

	// 업체 리뷰 관리 페이지로 이동
	@RequestMapping(value = "/bReview", method = RequestMethod.GET)
	public String bReview(Locale locale, Model model) {
		return "/bPartner/bShop/bReview";
	}

}
