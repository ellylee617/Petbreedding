package kh.com.petbreedding.mypage.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;
import kh.com.petbreedding.board.model.service.MyAskCommentService;
import kh.com.petbreedding.board.model.service.MyAskService;
import kh.com.petbreedding.board.model.vo.MyAsk;
import kh.com.petbreedding.board.model.vo.MyAskComment;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.vo.Pagination;
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
	
	@Autowired
	private MyAskCommentService myAskCommentService;

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
	
	
	// 미용실 예약 자세히 보기
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
	
	// 동물병원 예약 자세히 보기
	@RequestMapping("/revdetail2")
	public String myReservationDetail2(String hos_rnum, Model model) {
		
		List<HospitalReservation> result = clientInfoService.myRevDetail2(hos_rnum);
		model.addAttribute("myRev", result);
		
		return "/user/uMyPage/myHosReservationDetail";
	}

	//동물병원 예약 취소
	@RequestMapping("/cancleRev2")
	@ResponseBody
	public int cancleRev2(String hos_rnum) {	
		int result = clientInfoService.cancleRev2(hos_rnum);
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
		MyAskComment maComment = new MyAskComment();
		
		myAskDetail = myAskService.MyAskSelectDetail(qna_num);
		maComment = myAskCommentService.myAskCommentSelectOne(qna_num);
		
		System.out.println("[세훈] @일대일 문의 상세 컨트롤러 myAskDetail : " + myAskDetail);
		System.out.println("[세훈] @일대일 문의 상세 컨트롤러 maComment : " + maComment);
		
		md.addAttribute("myAskDetail", myAskDetail);
		md.addAttribute("maComment", maComment);
		
		return "/user/uMyPage/myAskDetail";
	}
	
	@RequestMapping(value = "/maWriteForm")
	public String maWriteForm (Model md, String user_num) {
		md.addAttribute("user_num", user_num);
		return "/user/uMyPage/myAskRegister";
	}
	
	@RequestMapping(value = "/maWrite")
	public String maWrite(
			Model md
			,HttpSession session
			,MultipartHttpServletRequest req
			,HttpServletResponse res
			,Client cl
			) throws Exception {
		
		res.setContentType("text/html; charset=utf-8");
		
		String user_num = req.getParameter("user_num");
		String qna_title = req.getParameter("myAskTitle"); 
		String qna_cont = req.getParameter("myAskCont");
		
		System.out.println("myAskTitle" + qna_title);
		System.out.println("myAskCont" + qna_cont);
		System.out.println("user_num" + user_num);
		
		MyAsk myAsk = new MyAsk();
		myAsk.setUserNum(user_num);
		myAsk.setQnaCont(qna_cont);
		myAsk.setQnaTitle(qna_title);
		
		// 파일업로드
		MultipartFile mf = req.getFile("myAskImg"); // 업로드 파라미터
		if(mf != null) {
			
			String path = req.getRealPath("/resources/uploadFile/myAsk"); // 자징될 위치
			UUID uuid = UUID.randomUUID(); // 랜덤 숫자 생성
			String fileName = mf.getOriginalFilename(); // 업로드 파일 원본 이름 저장
			String saveName = uuid.toString() + "_" + fileName; // 저장될 이름
			File uploadFile = new File(path + "//" + saveName); // 복사될 위치
			
			try {
				mf.transferTo(uploadFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			myAsk.setQnaImg(saveName);
			
			System.out.println("[세훈] 리뷰 이미지 경로 : " + saveName);
				}
				
			System.out.println("[세훈 ]" + myAsk.toString());
			int result = myAskService.MyAskInsert(myAsk);
			
			PrintWriter out = null;
			
			String msg1 = "문의 등록 완료";
			String msg2 = "문의 등록 실패";
			
			try {
				out = res.getWriter();
				if(result == 1) {
					out.println("<script>alert('" + msg1 + "');</script>");
					System.out.println("[세훈] 문의 등록 성공");
					
				} else {
					out.println("<script>alert('" + msg2 + "');</script>");
					System.out.println("[세훈] 문의 등록 실패");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				out.flush();
				out.close();
			}

			//TODO 리다이렉트 오류 수정
//			redirect:/board/boardList
		return "redirect:/myAsk";
	}
	

	//찜목록은 LikesController

	// 회원 정보 불러오기
	@RequestMapping("/mypage/selectClienInfo")
	public String selectClientInfo(HttpSession session) {

		return null;

	}

	
	//회원정보 수정 탈퇴는 ClientController
	
}
