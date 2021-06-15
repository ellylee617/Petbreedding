package kh.com.petbreedding.Admin.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	// 사업장관리 - 제휴 승인 대기 페이지로 이동
	@RequestMapping(value = "/mwait", method = RequestMethod.GET)
	public String mWait(Locale locale, Model model) {
		return "/shop/mWaitforPartner";
	}
	
	// 사업장관리 - 제휴 취소 대기 페이지로 이동
		@RequestMapping(value = "/mcancel", method = RequestMethod.GET)
		public String mCancel(Locale locale, Model model) {
			return "/shop/mCancelPartner";
		}

		//게시글 관리 (문의게시판 목록)
	@RequestMapping(value = "/mboard", method = RequestMethod.GET)
	public String mboard(Locale locale, Model model) {
		return "/myPage/mboard";
	}
	//게시글 관리 (문의게시판 글상세) 
	@RequestMapping(value = "/mboardcon", method = RequestMethod.GET)
	public String mboardcon(Locale locale, Model model) {
		return "/myPage/mboardcon";
	}
	
	//게시글 관리 (공지사항게시판 목록) 
		@RequestMapping(value = "/mservice", method = RequestMethod.GET)
		public String mservice(Locale locale, Model model) {
			return "/myPage/mservice";
		}

		// 게시글 관리 (공지사항게시판 내용)
		@RequestMapping(value = "/mservicecon", method = RequestMethod.GET)
		public String mservicecon(Locale locale, Model model) {
			return "/myPage/mservicecon";
		}
		
		//게시글 관리 (자유게시판 목록) 
		@RequestMapping(value = "/mfreeboard", method = RequestMethod.GET)
		public String mfreeboard(Locale locale, Model model) {
				return "/myPage/mfreeboard";
			}
		
		//게시글 관리 (자유게시판 내용) 
				@RequestMapping(value = "/mfreecon", method = RequestMethod.GET)
				public String mfreecon(Locale locale, Model model) {
						return "/myPage/mfreecon";
					}
	

}
