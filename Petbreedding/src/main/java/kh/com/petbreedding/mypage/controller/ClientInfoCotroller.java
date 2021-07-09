package kh.com.petbreedding.mypage.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
import kh.com.petbreedding.mypage.model.service.NoticeService;
import kh.com.petbreedding.mypage.model.vo.MyPoint;
import kh.com.petbreedding.mypage.model.vo.Notice;

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
	
	@Autowired
	private NoticeService noticeService;

	// 예약조회
	@RequestMapping("/mypage")
	public String myReservationList(String cl_num, Model model) {
		if(cl_num != null) {
			List<HairShopReservation> result = clientInfoService.myReservationList(cl_num);
			int status0 = clientInfoService.status0(cl_num);
			int status1 = clientInfoService.status1(cl_num);
			int status2 = clientInfoService.status2(cl_num);
			int point = myPointService.CurrPointSelectOne(cl_num);
			model.addAttribute("myRev", result);
			model.addAttribute("status0", status0);
			model.addAttribute("status1", status1);
			model.addAttribute("status2", status2);
			model.addAttribute("point", point);
		}else {
			System.out.println("cl_num이 없음");
		}
	
		return "/user/uMyPage/myReservationList";
	}
	
	//리스트 조회 결과
	@RequestMapping("/mypage2")
	@ResponseBody
	public List<HairShopReservation> myRevDateList(String cl_num, String res_date, String res_date2) {
		
		Map<String, String> list = new HashMap<String, String>();
		list.put("cl_num", cl_num);
		list.put("res_date", res_date);
		list.put("res_date2", res_date2);
		
        List<HairShopReservation> result = clientInfoService.myRevDateList(list);
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
	@RequestMapping("/point")
	public String point(String cl_num,Model md) {
		
		MyPoint myPoint = new MyPoint();
		myPoint.setClNum(cl_num);
		
		int currPoint = myPointService.CurrPointSelectOne(cl_num);
		
		md.addAttribute("currPoint", currPoint);
		
		return "/user/uMyPage/point";
	}
	
	// 포인트 기간별 조회 3개월
	@RequestMapping("/pointDate")
	@ResponseBody
	public List<MyPoint> pointDate(String clNum, Model model) {

		List<MyPoint> pointList = myPointService.myPoint3m(clNum);
				
		model.addAttribute("pointList", pointList);
		
		return pointList;
	}
	// 포인트 기간별 조회 6개월
	@RequestMapping("/pointDate2")
	@ResponseBody
	public List<MyPoint> pointDate2(String clNum, Model model) {

		List<MyPoint> pointList = myPointService.myPoint6m(clNum);
				
		model.addAttribute("pointList", pointList);
		
		return pointList;
	}
	// 포인트 기간별 조회 12개월
	@RequestMapping("/pointDate3")
	@ResponseBody
	public List<MyPoint> pointDate3(String clNum, Model model) {

		List<MyPoint> pointList = myPointService.myPoint12m(clNum);
				
		model.addAttribute("pointList", pointList);
		
		return pointList;
	}

	//포인트 기간 선택 조회
	@RequestMapping("/pointDate4")
	@ResponseBody
	public List<MyPoint> pointDate3(String clNum,String expDate,String expDate2, Model model) {

		Map<String, String> list = new HashMap<String, String>();
		list.put("clNum", clNum);
		list.put("expDate", expDate);
		list.put("expDate2", expDate2);
		List<MyPoint> pointList = myPointService.myPointDate(list);
				
		model.addAttribute("pointList", pointList);
		
		return pointList;
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
		maComment = myAskCommentService.myAskCommentSelectOneCB(qna_num);
		
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
			
			if(result > 0) {
				System.out.println("문의 등록 성공");
				md.addAttribute("msg", "문의 등록 성공");
				md.addAttribute("url","/mypage/ask?user_num="+user_num+"");
			} else {
				System.out.println("문의 등록 실패");
				md.addAttribute("msg", "문의 등록 실패");
				md.addAttribute("url","/mypage/ask?user_num="+user_num+"");
			}
			
			return "common/redirect";
			
	}
	

	//찜목록은 LikesController

	// 회원 정보 불러오기
	@RequestMapping("/mypage/selectClienInfo")
	public String selectClientInfo(HttpSession session) {

		return null;

	}
	
	// 알림 목록
	@RequestMapping("/noticelist")
	public ModelAndView getNoticeList(ModelAndView mv, HttpSession session) {
		List<Notice> list = null;
		
		Client client = (Client) session.getAttribute("client");
		
		if (session != null) {
			String cl_num = client.getCl_num();
			list = noticeService.getNoticeList(cl_num);
		}
		
		mv.addObject("noticeList", list);
		mv.setViewName("/user/uMyPage/myNotice");
		return mv;
	}
	
	// 알림 삭제
	@RequestMapping("/notdelete.do")
	@ResponseBody
	public String noticeDelete(HttpServletRequest req, HttpServletResponse res) {
		
		int result = 0;
		
		String notNum = req.getParameter("notNum");
		System.out.println("notNum" + notNum);
		
		res.setContentType("text/html; charset=UTF-8");
		
		try {
			PrintWriter out = res.getWriter();
			result = noticeService.deleteNotice(notNum);
			
			if(result==1) {
				System.out.println("알림 삭제 완료!");
				out.println("<script>alret('요청하신 알림이 삭제되었습니다!');<script>");
				
			}else {
				System.out.println("알림 삭제 실패!");
				out.println("<script>alret('알림 삭제에 실패했습니다. 관리자에게 문의해주세요.');<script>");
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/noticelist";
	}

	//회원정보 수정 탈퇴는 ClientController
	
}
