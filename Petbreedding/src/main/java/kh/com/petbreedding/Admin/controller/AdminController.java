package kh.com.petbreedding.Admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kh.com.petbreedding.Admin.model.service.AdminService;
import kh.com.petbreedding.Admin.model.vo.Admin;
import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.board.model.service.CustomerServiceService;
import kh.com.petbreedding.board.model.service.MyAskCommentService;
import kh.com.petbreedding.board.model.service.MyAskService;
import kh.com.petbreedding.board.model.vo.Board;
import kh.com.petbreedding.board.model.vo.CustomerService;
import kh.com.petbreedding.board.model.vo.MyAsk;
import kh.com.petbreedding.board.model.vo.MyAskComment;
import kh.com.petbreedding.common.model.vo.Pagination;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerServiceService customerServiceService;
	
	@Autowired
	private MyAskService myAskService;
	
	@Autowired
	private MyAskCommentService myAskCommentService;
	
	public final int LIMIT = 5;
	

	//관리자 회원관리
		@RequestMapping(value = "/mClient", method = RequestMethod.GET)
		public String mClient(Locale locale, Model model) {
			return "/admin/aSales/mClient";
		}
		
	//관리자 매출관리
	@RequestMapping(value = "/mSales", method = RequestMethod.GET)
	public String mSales(Locale locale, Model model) {
		return "/admin/aSales/mSales";
	}

	// 사업장관리 - 제휴 승인 목록조회
	@RequestMapping(value = "/mwaitList", method = RequestMethod.GET)
	public String waitList( Model model,Pagination page,
			@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage) {
		
		int total = adminService.countMwait();
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		List<BPartner> list = adminService.waitList(page);
		model.addAttribute("paging", page);
		model.addAttribute("bP", list);
		
		return "/admin/aShop/mWaitforPartner";
	}
	
	//제휴 승인 처리
	@RequestMapping(value = "/confirmBP", method = RequestMethod.POST)
	@ResponseBody
	public int confirmBP(@RequestParam(value = "arr[]") List<String> list) {
		
		int result = adminService.confirmBP(list);
		
		return result;
	}
	
	//제휴 거절 처리
	@RequestMapping(value = "/refuseBP", method = RequestMethod.POST)
	@ResponseBody
	public int refuseBP(@RequestParam(value = "arr[]") List<String> list) {
		
		int result = adminService.refuseBP(list);
		
		return result;
	}
	
	// 사업장관리 - 제휴 취소 목록 조회
	@RequestMapping(value = "/mcancel", method = RequestMethod.GET)
	public String mCancel( Model model,Pagination page,
			@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage) {

		int total = adminService.countMdelete();
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		List<BPartner> list = adminService.deleteList(page);
		model.addAttribute("paging", page);
		model.addAttribute("bP", list);
		
		return "/admin/aShop/mCancelPartner";
	}

	//제휴 취소 승인
	@RequestMapping(value = "/deleteBP", method = RequestMethod.POST)
	@ResponseBody
	public int deleteBP(@RequestParam(value = "arr[]") List<String> list) {
		
		int result = adminService.deleteBP(list);
		
		return result;
	}
	
	//제휴 취소 취소
	@RequestMapping(value = "/backBP", method = RequestMethod.POST)
	@ResponseBody
	public int backBP(@RequestParam(value = "arr[]") List<String> list) {
		
		int result = adminService.backBP(list);
		
		return result;
	}
	
	// 게시글 관리 (문의게시판 목록)
	@RequestMapping(value = "/mboard", method = RequestMethod.GET)
	public String mboard(
			Model md
			,@RequestParam(name = "page", defaultValue = "1") int page
			) {
		
		int currentPage = page;
		// 한 페이지당 출력할 목록 갯수
		int listCount = myAskService.listCount();
		int maxPage = (int) ((double) listCount / LIMIT + 0.9);
		
		List<MyAsk> myAskList = null;
		myAskList = myAskService.MyAskSelectListM(currentPage, LIMIT);
		md.addAttribute("myAskList", myAskList);
		md.addAttribute("currentPage", currentPage);
		md.addAttribute("listCount", listCount);
		md.addAttribute("maxPage", maxPage);
		
		System.out.println("[세훈] @관리자 문의 사항 리스트 : " + myAskList.toString());
		
		return "/admin/aBoard/mboard";
	}

	// 게시글 관리 (문의게시판 글상세)
	@RequestMapping(value = "/mboardcon")
	public String mboardcon(
			Model md
			,String qna_num
			,@RequestParam(name = "page", defaultValue = "1") int page
			) {
		
		
		int currentPage = page;
		MyAsk mAsk = new MyAsk();
		
		mAsk = myAskService.MyAskSelectDetail(qna_num);
		md.addAttribute("mAsk", mAsk);
		
		
		return "/admin/aBoard/mboardcon";
	}
	
	// 게시글 관리 (문의게시판 댓글)
	@RequestMapping(value = "/macList")
	public void macList(
			Model md
			,String qna_num
			,HttpServletRequest req
			,HttpServletResponse res
			) throws SQLException, IOException {
		
		PrintWriter out = res.getWriter();
		String result = "";
		MyAskComment mAskComment = new MyAskComment();
		
		System.out.println(qna_num);
		mAskComment = myAskCommentService.myAskCommentSelectOne(qna_num);
		
		if(mAskComment != null) {
			Gson jobj = new GsonBuilder().create();
			result = jobj.toJson(mAskComment);
		}
		
//		md.addAttribute("result", result);
		
		System.out.println("[세훈 : result : " + result);
		
		out.println(result);
		out.flush();
		out.close();
	}
	
	// 게시글 관리 (문의 게시판 댓글 달기)
	@RequestMapping(value = "/macWrite")
	public void macWrite(
			Model md
			,HttpServletRequest req
			,HttpServletResponse res
			,HttpSession ses
			,Admin ad
			) throws IOException {
		
		ad = (Admin) ses.getAttribute("admin");
		PrintWriter out = res.getWriter();
		
		String qna_num = req.getParameter("qna_num");
		String maCommentText = req.getParameter("maCommentText");
		
		System.out.println("[세훈] @문의 댓글 달기 컨트롤러 qna_num : " + qna_num);
		System.out.println("[세훈] @문의 댓글 달기 컨트롤러 maCommentText : " + maCommentText);
		
		if(maCommentText != null && qna_num != null) {
			
			MyAskComment maComment = new MyAskComment();
			String admin_id = ad.getAdmin_id();
			System.out.println("[세훈] @문의 댓글 달기 컨트롤러 admin_id : " + admin_id);
			
			maComment.setQnaNum(qna_num);
			maComment.setQnacCont(maCommentText.replaceAll("\n", "<br>"));
			maComment.setAdminId(admin_id);
			
			System.out.println("[세훈] @문의 댓글 달기 컨트롤러 maComment : " + maComment.toString());
			myAskCommentService.myAskCommentInsert(maComment);
			
		}
		
	}
	
	

	// 게시글 관리 (공지사항게시판 목록)
	@RequestMapping(value = "/mservice", method = RequestMethod.GET)
	public String mservice(Model md) {
		
		List<CustomerService> cusList = customerServiceService.CustomerServiceSelectListA();
		
		md.addAttribute("cusList", cusList);
		
		return "/admin/aBoard/mservice";
	}

	// 게시글 관리 (공지사항게시판 내용)
	@RequestMapping(value = "/mservicecon", method = RequestMethod.GET)
	public String mservicecon(Locale locale, Model model) {
		return "/admin/aBoard/mservicecon";
	}
	
	// 게시글 관리 (공지사항게시판 등록 폼)
	@RequestMapping(value = "/mserviceRegisterFrm")
	public String mserviceRegisterFrm(Locale locale, Model model) {
		return "/admin/aBoard/mServiceRegister";
	}
	
	// 게시글 관리 (공지사항게시판 등록)
	@RequestMapping(value = "/mRegister")
	public String mRegister(
			Model md
			,Admin ad
			,HttpSession session
			,MultipartHttpServletRequest req
			,HttpServletResponse res
			) {
		
		res.setContentType("text/html; charset=utf-8");
		
		ad = (Admin) session.getAttribute("admin");
		
		String admin_id = ad.getAdmin_id();
		String ann_type = req.getParameter("mServiceSelect");
		String ann_title = req.getParameter("mServiceTitle");
		String ann_cont = req.getParameter("mServiceCont");
		
		CustomerService cs = new CustomerService();
		
		cs.setAdminId(admin_id);
		cs.setAnnCont(ann_cont);
		cs.setAnnTitle(ann_title);
		cs.setAnnType(ann_type);
		
		int result = 0;
		
//		result = customerServiceService.CustomerServiceInsert(cs);
		
		PrintWriter out = null;
		
		String msg1 = "공지사항등록 완료";
		String msg2 = "공지사항 등록 실패";
		
		try {
			out = res.getWriter();
			if(result == 1) {
				out.println("<script>alert('" + msg1 + "');</script>");
				System.out.println("[세훈] 공지사항 등록 성공");
				
			} else {
				out.println("<script>alert('" + msg2 + "');</script>");
				System.out.println("[세훈] 공지사항 등록 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
		
		return "/admin/aBoard/mservice";
	}

	// 게시글 관리 (자유게시판 목록)
	@RequestMapping(value = "/mfreeboard", method = RequestMethod.GET)
	public String mfreeboard(Locale locale, Model model) {
		return "/admin/aBoard/mfreeboard";
	}

	// 게시글 관리 (자유게시판 내용)
	// ?? 해당 파일이 없어요?
	@RequestMapping(value = "/mfreecon", method = RequestMethod.GET)
	public String mfreecon(Locale locale, Model model) {
		return "/admin/aBoard/mfreecon";
	}

}
