package kh.com.petbreedding.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.service.ClientInfoService;
import kh.com.petbreedding.mypage.model.service.MyPointService;
import kh.com.petbreedding.mypage.model.vo.MyPoint;

@Controller
public class ClientInfoCotroller {

	@Autowired
	private ClientInfoService clientInfoService;
	
	@Autowired
	private MyPointService myPointService;

	// 예약조회
	@RequestMapping("/mypage")
	public String myReservationList(String cl_num, Model model) {
		
		List<HairShopReservation> result = clientInfoService.myReservationList(cl_num);
		int status0 = clientInfoService.status0(cl_num);
		int status1 = clientInfoService.status1(cl_num);
		int status2 = clientInfoService.status2(cl_num);
		model.addAttribute("myRev", result);
		model.addAttribute("status0", status0);
		model.addAttribute("status1", status1);
		model.addAttribute("status2", status2);
		
		return "/user/uMyPage/myReservationList";
	}
	
	//리스트 조회 결과
	@RequestMapping("/mypage2")
	@ResponseBody
	public List<HairShopReservation> myRevDateList(HairShopReservation hsr) {
		
		List<HairShopReservation> result = clientInfoService.myRevDateList(hsr);

		return result;
	}
	
	
	// 예약 자세히 보기
	@RequestMapping("/mypage/revdetail")
	public String myReservationDetail(String har_rnum, HttpSession session, Model model) {
		
		List<HairShopReservation> result = clientInfoService.myRevDetail(har_rnum);
		model.addAttribute("myRev", result);
		
		return "/user/uMyPage/myReservationDetail";
	}


	// 포인트내역
	@RequestMapping("/mypage/point")
	public ModelAndView point(
			HttpSession session
			,HttpServletRequest req
			,Client cl
			,ModelAndView mv
			) {
		
		cl = (Client) session.getAttribute("client");
		String clNum = cl.getCl_num();
		MyPoint myPoint = new MyPoint();
		myPoint.setClNum(clNum);
		
		String currPoint = myPointService.CurrPointSelectOne(clNum);
		List<MyPoint> pointList = myPointService.myPointSelectList(myPoint);
		
		System.out.println("[세훈] 컨트롤러 pointList : " + pointList);
		System.out.println("[세훈] 컨트롤러 currPoint : " + currPoint);
		mv.addObject("pointList", pointList);
		mv.addObject("currPoint", currPoint);
		

		//		req.setAttribute("currPoint", currPoint);
		mv.setViewName("/user/uMyPage/point");
		
		return mv;
	}
	

	// 1:1 문의 내역
	@RequestMapping("/mypage/ask")
	public String ask(HttpSession session) {
		return "/user/uMyPage/myAsk";
	}

	// 1:1 문의 자세히 보기
	@RequestMapping("/mypage/askdetail")
	public String askDetail(HttpSession session) {
		return "/user/uMyPage/myAskDetail";
	}
	
	// 내 찜 목록
		@RequestMapping("/mypage/myzzim")
		public String myZzim(HttpSession session) {
			return "/user/uMyPage/myzzim";
		}

	// 회원 정보 불러오기
	@RequestMapping("/mypage/selectClienInfo")
	public String selectClientInfo(HttpSession session) {

		return null;

	}

	
	//회원정보 수정 탈퇴는 ClientController
	
}
