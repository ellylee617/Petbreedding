package kh.com.petbreedding.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.petbreedding.client.model.vo.Client;

public class FindController {

	// 사용자 아이디 찾기
	@RequestMapping("/findId")
	 public String findId(Client clinet, RedirectAttributes rttr) {
		// TODO Auto-generated method stub
		return null;
		
	}
	
	//사용자 비밀번호 찾기
	@RequestMapping("/findPwd")
	public String findPwd(Client clinet, RedirectAttributes rttr) {
		// TODO Auto-generated method stub
		return null;
		
	}
}
