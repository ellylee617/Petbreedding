package kh.com.petbreedding.Admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.com.petbreedding.Admin.model.service.AdminService;
import kh.com.petbreedding.Admin.model.vo.Admin;
import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.board.model.service.CustomerServiceService;
import kh.com.petbreedding.board.model.vo.CustomerService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerServiceService customerServiceService;
	
	

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
	public String waitList( Model model) {
		
		List<BPartner> list = adminService.waitList();
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
	
	// 사업장관리 - 제휴 취소 대기 페이지로 이동
	@RequestMapping(value = "/mcancel", method = RequestMethod.GET)
	public String mCancel(Locale locale, Model model) {
		
		List<BPartner> list = adminService.deleteList();
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
	public String mboard(Locale locale, Model model) {
		return "/admin/aBoard/mboard";
	}

	// 게시글 관리 (문의게시판 글상세)
	@RequestMapping(value = "/mboardcon", method = RequestMethod.GET)
	public String mboardcon(Locale locale, Model model) {
		return "/admin/aBoard/mboardcon";
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
		
		result = customerServiceService.CustomerServiceInsert(cs);
		
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
