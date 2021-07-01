package kh.com.petbreedding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.Shop.model.service.BpReservationService;
import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;
import kh.com.petbreedding.bmypage.model.service.ShopService;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.HairSalonImg;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.HospitalImg;
import kh.com.petbreedding.bmypage.model.vo.MedicalType;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.board.model.service.ReviewService;
import kh.com.petbreedding.board.model.vo.Review;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.service.LikesService;
import kh.com.petbreedding.common.model.vo.Likes;
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

	@Autowired
	private BpReservationService bprevService;

	@Autowired
	LikesService likeService;
	
	// 사업장 리스트
	@RequestMapping(value = "/shopList", method = RequestMethod.GET)
	public ModelAndView shopList(ModelAndView mv, @RequestParam Long shopType) throws Exception {

		
		// shopType 0은 미용실, 1은 동물병원

		if (shopType == 0) {

			int harShopType = 0;
			
			List<HairSalon> salonList = shopService.selectHarList(STARTPAGE, 5);
			
			System.out.println("컨트롤러 미용실 리스트 : " + salonList);
			
			String har_num = null;
			List<String> list = new ArrayList<String>();
			for(int i =0; i<salonList.size(); i++) {
				har_num = salonList.get(i).getHarNum();
				String count = likeService.countSalon(har_num);
				System.out.println("************count*****"+count);
				list.add(count);
				mv.addObject("count", list);
			}
			
			/*
			 * List<String> list = new ArrayList<String>(); 
			 * System.out.println("~~~~~~~~~~~~~harNum ~~~~~~~~~"+list);
			 * HashMap<String,String> salonCount = likeService.countSalon(list);
			 * System.out.println("!!!!!!!salonList!!!!!!!!! "+ salonCount);
			 */
//			List<HairSalonImg> harImgList = shopService.selectHarImgList();

			List<HairSalon> ultra = ctaService.ctabuylist();

			mv.addObject("shopType", harShopType);
			mv.addObject("shopList", salonList);
			mv.addObject("cta", ultra);
			mv.setViewName("/user/uShop/shopList");

			// 미용실 대표 사진
			// TODO

		} else {

			int hosShopType = 1;
			List<Hospital> hosList = shopService.selectHosList(STARTPAGE, 5);
			System.out.println("컨트롤러 동물병원 리스트:" + hosList);

			mv.addObject("shopType", hosShopType);
			mv.addObject("shopList", hosList);
			mv.setViewName("/user/uShop/shopList");

			// 동물병원 매장 대표 사진 출력
			// TODO

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
			, HttpServletRequest request
			, HttpSession session) throws Exception{
//		System.out.println("[세훈]");
		System.out.println("shopPage 컨트롤러 진입");
		String bpId = request.getParameter("bpId");
		ctaService.delcta(bpId);

		System.out.println("매장 타입:" + shopType);
		mv.addObject("shopType", shopType);

//		try {
//			bpId = Integer.parseInt(request.getParameter("bpId"));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}

		// ** 미용실 **
		if (shopType == 0) {

			// 기본 정보 출력
			HairSalon har = shopService.selectHarInfo(bpId);
			System.out.println("미용실 정보::" + har);
			mv.addObject("shopInfo", har);

			// 해당 미용실 번호 출력하기
			String harNum = har.getHarNum();
			System.out.println("미용실 번호:" + harNum);

			// 메뉴(스타일) 출력
			List<Style> styleList = shopService.selectStyleList(harNum);
			System.out.println("스타일 리스트:" + styleList);
			mv.addObject("menuList", styleList);

			// 미용실 사진 출력
			List<HairSalonImg> harImgList = shopService.selectHarImgList(harNum);
			System.out.println("미용실 사진 리스트:" + harImgList);
			mv.addObject("shopImgList", harImgList);
			
			//로그인한 회원이 이 미용실을 찜했는지?
			Client client = (Client) session.getAttribute("client");
			if(client != null) {
				String cl_num = client.getCl_num();
				List<Likes> likes = likeService.selectLikes(cl_num);
				mv.addObject("zzim", likes);
			}else {
				System.out.println("로그인하지 않았습니다.");
			}

		} else {

			// 동물병원

			// 기본 정보 출력
			Hospital hos = shopService.selectHosInfo(bpId);
			System.out.println("동물병원 정보::" + hos);
			mv.addObject("shopInfo", hos);

			// 해당 동물병원 번호 출력하기
			String hosNum = hos.getHosNum();
			System.out.println("동물병원 번호:" + hosNum);

			// TODO
			// 동물병원 진료 정보 출력
			List<MedicalType> medList = shopService.selectMedList(hosNum);
			System.out.println("동물병원 진료 정보 리스트:" + medList);
			mv.addObject("menuList", medList);

			// 동물병원 사진 출력
			List<HospitalImg> hosImgList = shopService.selectHosImgList(hosNum);
			System.out.println("동물병원 사진 리스트:" + hosImgList);
			mv.addObject("shopImgList", hosImgList);
			
			//로그인한 회원이 이 병원을 찜했는지?
			Client client = (Client) session.getAttribute("client");
			if(client != null) {
				String cl_num = client.getCl_num();
				List<Likes> likes = likeService.selectLikes(cl_num);
				mv.addObject("zzim", likes);
			}else {
				System.out.println("로그인하지 않았습니다.");
			}

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

	// 사업자 예약관리 - 현재 날짜 전체 리스트 (병원, 미용실 포함)
	@RequestMapping(value = "/bReservation")
	public ModelAndView bReservationList(Locale locale, Model model,
			HairShopReservation rev, HttpSession session,
			HttpServletResponse res

	) throws Exception {

		BPartner vo = (BPartner) session.getAttribute("bP");
		String bp_id = vo.getBp_Id();
		System.out.println("사업자 예약조회 들어옴-----------");
		
		
		List<HairShopReservation> list = null;
		List<HospitalReservation> list2 = null;
		ModelAndView mav = new ModelAndView();

		
		if(vo.getBp_type() == 0) {
			list = bprevService.revAllList(bp_id);
			mav.setViewName("bPartner/bShop/bReservation");
			mav.addObject("list", list);
			
		}else {
			list2 = bprevService.revHosAllList(bp_id);
			mav.setViewName("bPartner/bShop/bReservation");
			mav.addObject("list", list2);
		}
		
		

		return mav;
	}
	
	
	//사업자 미용실 날짜별 전체보기 
	@ResponseBody
	@RequestMapping(value = "/bReservationdate")
	public List<HairShopReservation> bReservationDate(Locale locale, Model model, 
			HairShopReservation rev,
			HttpSession session, 
			HttpServletResponse res) throws Exception {
	
		
		System.out.println("선택된 날짜는" + rev.getRes_date());
		List<HairShopReservation> list = bprevService.revAllListDate(rev);
		return list;
	
	}
	

	// 사업자 미용실 예약관리 개별 선택 리스트
	@ResponseBody
	@RequestMapping(value = "/bReservationkind")
	public List<HairShopReservation> bReservation(Model model, HairShopReservation rev,
			HttpSession session, HttpServletResponse res) throws Exception {

		BPartner vo = (BPartner) session.getAttribute("bP");
		String bp_id = vo.getBp_Id();
//			List<HairShopReservation> list = bprevService.revList(res_status);
		System.out.println("사업자 예약조회 개별 들어옴");
		System.out.println("선택된 미용실 날짜는" + rev.getRes_date());
		System.out.println("선택된 미용실 예약 상태는" + rev.getRes_status());
		System.out.println("로그인한 사업장은" + rev.getBp_id());
		System.out.println("이름은 " + rev.getName());
		/*
		 * ModelAndView mav = new ModelAndView(); mav.addObject("list",
		 * bprevService.revList(rev)); mav.setViewName("bPartner/bShop/bReservation");
		 */
			List<HairShopReservation> list = bprevService.revList(rev);
			
			return list;
	}
	
	// 사업자 병원 예약관리 개별 선택 리스트
		@ResponseBody
		@RequestMapping(value = "/bReservationHoskind")
		public List<HospitalReservation> bReservationHos(Model model, 
				HospitalReservation rev,
				HttpSession session, HttpServletResponse res) throws Exception {

			System.out.println("병원 예약조회 개별 들어옴");
			System.out.println("선택된 병원예약 날짜는" + rev.getHos_date());
			System.out.println("선택된 병원 예약 상태는" + rev.getHos_status());
			System.out.println("로그인한 사업장은" + rev.getBp_id());
			System.out.println("이름은 " + rev.getName());
			/*
			 * ModelAndView mav = new ModelAndView(); mav.addObject("list",
			 * bprevService.revList(rev)); mav.setViewName("bPartner/bShop/bReservation");
			 */
				List<HospitalReservation> list = bprevService.revHosList(rev);
				
				return list;
		}
		
		//사업자 병원 날짜별 전체보기 
		@ResponseBody
		@RequestMapping(value = "/bHosReservationdate")
		public List<HospitalReservation> bHosReservationDate(
				Model model, 
				HospitalReservation rev,
				HttpSession session, 
				HttpServletResponse res) throws Exception {
		
			
			System.out.println("병원 선택된 날짜는" + rev.getHos_date());
			List<HospitalReservation> list = bprevService.revAllHosListDate(rev);
			return list;
		
		}
		
		
	

		
	// 사업자 예약확인
	@RequestMapping(value = "/bReservationDetail", method = RequestMethod.GET)
	public String bReservationDetail(Locale locale, Model model) {
		return "/bPartner/bShop/bReservationDetail";
	}

	// 사업자 화상채팅하기
	@RequestMapping(value = "/bFaceChat", method = RequestMethod.GET)
	public String bFaceChat(Locale locale, Model model) {
		return "/bPartner/bShop/bFaceChat";
	}
}
