package kh.com.petbreedding;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.board.model.service.ReviewService;
import kh.com.petbreedding.board.model.vo.Review;

@Controller
public class shopController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/shopList", method = RequestMethod.GET)
	public String shopList(Locale locale, Model model) {
		return "/user/uShop/shopList";
	}
	
	@Autowired
	private ReviewService reviewService;

	@RequestMapping(value = "/shopPage", method = RequestMethod.GET)
	public ModelAndView shopPage(Locale locale, ModelAndView mv) {
		System.out.println("컨트롤러 진입");
		List<Review> reviewList = reviewService.reviewSelectList(1, 5);
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

	@RequestMapping(value = "/shopPayment", method = RequestMethod.GET)
	public String shopPayment(Locale locale, Model model) {
		return "/user/uShop/shopPayment";
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
