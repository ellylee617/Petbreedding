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
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.bmypage.model.service.ShopService;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.board.model.service.ReviewService;
import kh.com.petbreedding.board.model.vo.Review;
import kh.com.petbreedding.cta.model.service.CtaService;

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
	
	@RequestMapping(value = "/shopList", method = RequestMethod.GET)
	public ModelAndView shopList(Locale locale,
			ModelAndView mv,
			HttpSession session,
			HttpServletResponse res
			) throws Exception {
		
		List<HairSalon> salonList = shopService.selectHarList(STARTPAGE, 5);
		List<HairSalon> ultra = ctaService.ctabuylist();
		System.out.println("컨트롤러 미용실 리스트 : " + salonList);
		
		BPartner vo = (BPartner) session.getAttribute("bP");
		System.out.println("울트라 리스트 들어옴");
		
		
		
		
		mv.addObject("salonList", salonList);
		mv.addObject("cta", ultra);
		mv.setViewName("/user/uShop/shopList");
		
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
	
	@RequestMapping(value = "/shopPage")
	public ModelAndView shopPage(Locale locale, ModelAndView mv, HttpServletRequest request) {
		System.out.println("[세훈]");
		System.out.println("shopPage 컨트롤러 진입");
		String bpId = request.getParameter("bpId"); 
//		try {
//			bpId = Integer.parseInt(request.getParameter("bpId"));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		List<Review> reviewList = reviewService.reviewSelectList(bpId, STARTPAGE, 5);
		System.out.println("리뷰 리스트 가져왔다면 보여줘 --> " + reviewList);
		mv.addObject("reviewList", reviewList);
		mv.setViewName("/user/uShop/shopInfoRead");
		
		System.out.println("컨트롤러 끝");
		return mv;
	}

	/*
	 * @RequestMapping(value = "/shopReservation", method = RequestMethod.GET)
	 * public String shopReservation(Locale locale, Model model) { return
	 * "/user/uShop/salonReservation"; }
	 */


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
