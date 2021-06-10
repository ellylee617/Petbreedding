package kh.com.petbreedding.client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.petbreedding.client.model.service.ClientService;
import kh.com.petbreedding.client.model.vo.Client;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	//이메일 회원가입 페이지로 이동
	@RequestMapping(value = "/clientregister", method = RequestMethod.GET)
	public String openClientRegister() {
		
		return null;
	}
	
	//이메일 회원가입 처리
	@RequestMapping(value = "/clientregister", method = RequestMethod.POST)
	public String ClientRegister(Client client, HttpSession session) {
		
		return null;
		
	}
	
	
	//회원가입 - 이메일 중복 확인
	@RequestMapping("/checkEmail")
	public String  checkEmail(Client client, HttpSession session, HttpServletResponse response) {
		
		return null;
	}
	
	//휴대전화 인증번호 받기 
	@RequestMapping(value = "/phone", method = RequestMethod.POST)
	public void sendSms(HttpServletRequest request) {
		
	}
	
	@RequestMapping("/sendMail")
	//가입 확인 이메일 전송
	public String sendMail(Client client ,RedirectAttributes rttr) {
		
		
		return null;
	}
}
