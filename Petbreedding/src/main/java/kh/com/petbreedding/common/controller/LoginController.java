package kh.com.petbreedding.common.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.petbreedding.HomeController;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//  로그인 페이지로 이동
	@RequestMapping(value = "/uLogin", method = RequestMethod.GET)
	public String openLogin(Locale locale, Model model) {
	
		// TODO Auto-generated method stub
		return "/user/uMember/uLogin";
	}
	
	//  사장님로그인 페이지로 이동
	@RequestMapping(value = "/bLogin", method = RequestMethod.GET)
	public String openbLogin(Locale locale, Model model) {
		
		// TODO Auto-generated method stub
		return "/bPartner/bMember/bLogin";
	}
	
	//관리자 로그인 페이지로 이동
	@RequestMapping(value = "/mLogin", method = RequestMethod.GET)
	public String openmLogin(Locale locale, Model model) {
		
		// TODO Auto-generated method stub
		return "/admin/aMember/mLogin";
	}
	
	// 유저 로그인 처리
	@RequestMapping( value="/member/doLoginU", method = RequestMethod.POST)
	@ResponseBody
	public String doLoginU(Client client, HttpSession session ,HttpServletRequest req, RedirectAttributes rttr) {

		Client result = loginService.login(client);
		session = req.getSession();
		
		if(result == null) {
			System.out.println("로그인 실패");
			session.setAttribute("client", null);
			rttr.addFlashAttribute("msg", "아이디와 비밀번호가 맞지 않습니다.");
			return "uLogin";
		}else {
			System.out.println("로그인 성공!");
			session.setAttribute("client", result);
		}
		System.out.println("email : "+ client.getEmail());
		System.out.println("password : "+ client.getPassword());
		System.out.println("result : "+ result);
		
		return "/";
		
	}
	
	
	// 사업자 로그인 처리
	@RequestMapping("/member/doLoginB")
	public String doLoginB(Client client, HttpSession session ,HttpServletResponse response) {
		
		// TODO Auto-generated method stub
		return null;
		
	}
	
	
	// 카카오 로그인
	@RequestMapping(value = "kakaoLogin", method = RequestMethod.POST)
	public String kakaoLogin(HttpServletRequest request, @RequestBody Map<String, Object> param) {
		
		// TODO Auto-generated method stub
		return null;
		
	}
	
	
	// 네이버 로그인 
	@RequestMapping(value = "naverLogin", method = RequestMethod.POST)
	public String naverLogin(HttpServletRequest request, @RequestBody Map<String, Object> param) {
		
		// TODO Auto-generated method stub
		return null;
		
	}
	
	// 사용자 로그아웃
	@RequestMapping("/logout")
	public String logout(Client client, HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
		
	}
	
	
	
	
}
