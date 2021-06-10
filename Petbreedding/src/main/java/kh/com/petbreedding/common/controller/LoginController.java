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

import kh.com.petbreedding.HomeController;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//  로그인 페이지로 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String openLogin(Locale locale, Model model) {
		
		// TODO Auto-generated method stub
		return "/member/login";
	}
	
	// 로그인 처리
	@RequestMapping("/member/login")
	public String login(Client client, HttpSession session ,HttpServletResponse response) {
		
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
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		// TODO Auto-generated method stub
		return null;
		
	}
	
	
	
	
}
