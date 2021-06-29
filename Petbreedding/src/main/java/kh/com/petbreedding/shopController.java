package kh.com.petbreedding;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.bmypage.model.service.ShopService;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.board.model.service.ReviewService;
import kh.com.petbreedding.board.model.vo.Review;
import kh.com.petbreedding.cta.model.service.CtaService;

//TODO: !!!!!!!! 경로 수정하고 컨트롤러명 변경하기 !!!!!!!!!!

@Controller
public class shopController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public final int STARTPAGE = 1; 
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ShopService shopService;
	@Autowired
	private CtaService ctaService;

	// 사업장 리스트
	@RequestMapping(value = "/shopList", method = RequestMethod.GET)
	public ModelAndView shopList(ModelAndView mv, @RequestParam Long shopType) throws Exception{
		
		// shopType 0은 미용실, 1은 동물병원
		
		if(shopType==0) {
			
			int harShopType = 0;
			List<HairSalon> salonList = shopService.selectHarList(STARTPAGE, 5);
			System.out.println("컨트롤러 미용실 리스트 : " + salonList);
			List<HairSalon> ultra = ctaService.ctabuylist();
			
			mv.addObject("shopType", harShopType);
			mv.addObject("shopList", salonList);
			mv.addObject("cta", ultra);
			mv.setViewName("/user/uShop/shopList");
			
			
		} else {
			
			int hosShopType = 1;
			List<Hospital> hosList = shopService.selectHosList(STARTPAGE, 5);
			System.out.println("컨트롤러 동물병원 리스트:"+hosList);
			
			mv.addObject("shopType", hosShopType);
			mv.addObject("shopList", hosList);
			mv.setViewName("/user/uShop/shopList");
		}
		
		
		return mv;
		
	}
	

	
	
//	@RequestMapping(value = "/salonList", method = RequestMethod.GET)	// *********** TODO "/shopList"에 합쳐줘야 됨!!*******
//	public ModelAndView salonList(Locale locale, ModelAndView mv) {
//		List<HairSalon> salonList = shopService.selectHarList(STARTPAGE, 5);
//		System.out.println("컨트롤러 미용실 리스트 : " + salonList);
//		
//		mv.addObject("salonList", salonList);
//		mv.setViewName("/user/uShop/salonList");
//		
//		return mv;
//	}
	
	// 사업장 상세 페이지 
	@RequestMapping(value = "/shopPage")
	public ModelAndView shopPage(
			@RequestParam Long shopType
			, Locale locale
			, ModelAndView mv
			, HttpServletRequest request) {
//		System.out.println("[세훈]");
		System.out.println("shopPage 컨트롤러 진입");
		String bpId = request.getParameter("bpId"); 
		
		System.out.println("매장 타입:"+shopType);
		mv.addObject("shopType", shopType);
		
//		try {
//			bpId = Integer.parseInt(request.getParameter("bpId"));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
		// ** 미용실 ** 
		if(shopType==0) {
			
			// 기본 정보 출력 
			HairSalon har = shopService.selectHarInfo(bpId);
			System.out.println("미용실 정보::"+har);
			mv.addObject("harInfo", har);
			
			// 메뉴(스타일) 출력
			String harNum = har.getHarNum();
			System.out.println("미용실 번호:"+harNum);
			List<Style> styleList = shopService.selectStyleList(harNum);
			System.out.println("스타일 리스트:"+styleList);
			mv.addObject("styleList", styleList);
			
		} else {
			
			//TODO:동물병원
			
		}
		
		
		// 리뷰 리스트
		List<Review> reviewList = reviewService.reviewSelectList(bpId, STARTPAGE, 5);
		System.out.println("리뷰 리스트 가져왔다면 보여줘 --> " + reviewList);
		mv.addObject("reviewList", reviewList);
		
		
		
		
		mv.setViewName("/user/uShop/shopInfoRead");
		
		System.out.println("컨트롤러 끝");
		return mv;
	}



	@RequestMapping(value = "/successPay", method = RequestMethod.GET)
	public String successPay(Locale locale, Model model) {
		return "/user/uShop/successPay";
	}
	@RequestMapping(value = "/successRev", method = RequestMethod.GET)
	public String successRev(Locale locale, Model model) {
		return "/user/uShop/successRev";
	}
	
	//사업자 예약관리
	@RequestMapping(value = "/bReservation", method = RequestMethod.GET)
	public String bReservation(Locale locale, Model model) {
		return "/bPartner/bShop/bReservation";
	}

	//사업자 예약확인
	@RequestMapping(value = "/bReservationDetail", method = RequestMethod.GET)
	public String bReservationDetail(Locale locale, Model model) {
		return "/bPartner/bShop/bReservationDetail";
	}

	//사업자 화상채팅하기
	@RequestMapping(value = "/bFaceChat", method = RequestMethod.GET)
	public String bFaceChat(Locale locale, Model model) {
		return "/bPartner/bShop/bFaceChat";
	}
}
