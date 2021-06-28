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
import kh.com.petbreedding.board.model.service.MyAskService;
import kh.com.petbreedding.board.model.vo.MyAsk;
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
	
	@Autowired
	private MyAskService myAskService;

	// 예약조회
	@RequestMapping("/mypage")
	public String myReservationList(String cl_num, Model model) {
		if(cl_num != null) {
			List<HairShopReservation> result = clientInfoService.myReservationList(cl_num);
			int status0 = clientInfoService.status0(cl_num);
			int status1 = clientInfoService.status1(cl_num);
			int status2 = clientInfoService.status2(cl_num);
			model.addAttribute("myRev", result);
			model.addAttribute("status0", status0);
			model.addAttribute("status1", status1);
			model.addAttribute("status2", status2);
		}else {
			System.out.println("cl_num이 없음");
		}
	
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
	@RequestMapping("/revdetail")
	public String myReservationDetail(String har_rnum, Model model) {
		
		List<HairShopReservation> result = clientInfoService.myRevDetail(har_rnum);
		String result2 = clientInfoService.anotherMenu(har_rnum);
		int getPrice = clientInfoService.getPrice(har_rnum);
		model.addAttribute("myRev", result);
		model.addAttribute("another", result2);
		model.addAttribute("totalPrice", getPrice);
		
		return "/user/uMyPage/myReservationDetail";
	}

	//미용실 예약 취소
	@RequestMapping("/cancleRev")
	@ResponseBody
	public int cancleRev(String har_rnum) {	
		int result = clientInfoService.cancleRev(har_rnum);
		return result;
	}

	// 포인트내역
	@RequestMapping("/mypage/point")
	public String point(
//			HttpSession session
			String cl_num
			,HttpServletRequest req
			,Client cl
			,Model md
			) {
		
//		cl = (Client) session.getAttribute("client");
//		String clNum = cl.getCl_num();
		MyPoint myPoint = new MyPoint();
		myPoint.setClNum(cl_num);
		
		int currPoint = myPointService.CurrPointSelectOne(cl_num);
		List<MyPoint> pointList = myPointService.myPointSelectList(myPoint);
		
		System.out.println("[세훈] 컨트롤러 pointList : " + pointList);
		System.out.println("[세훈] 컨트롤러 currPoint : " + currPoint);
		md.addAttribute("pointList", pointList);
		md.addAttribute("currPoint", currPoint);
		

		//		req.setAttribute("currPoint", currPoint);
//		mv.setViewName("/user/uMyPage/point");
		
		return "/user/uMyPage/point";
	}
	

	// 1:1 문의 내역
	@RequestMapping("/mypage/ask")
	public String ask(
			HttpSession session
			,String user_num
			,Model md
			) {
		
		System.out.println("[세훈] @일대일 문의 컨트롤러 user_num : " + user_num);
		List<MyAsk> myAskList = myAskService.MyAskSelectList(user_num);
		md.addAttribute("myAskList", myAskList);
		md.addAttribute("user_num", user_num);
		System.out.println("[세훈] @일대일 문의 컨트롤러 myAskList : " + myAskList);
		
		return "/user/uMyPage/myAsk";
	}

	// 1:1 문의 자세히 보기
	@RequestMapping("/mypage/askdetail")
	public String askDetail(
			HttpSession session
			,String qna_num
			,Model md
			) {
		
		System.out.println("[세훈] @일대일 문의  상세 컨트롤러 qna_num : " + qna_num);
		
		MyAsk myAskDetail = new MyAsk();
		myAskDetail = myAskService.MyAskSelectDetail(qna_num);
		System.out.println("[세훈] @일대일 문의 상세 컨트롤러 myAskDetail : " + myAskDetail);
		md.addAttribute("myAskDetail", myAskDetail);
		
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
