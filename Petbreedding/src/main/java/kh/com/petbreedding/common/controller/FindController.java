package kh.com.petbreedding.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.service.FindService;

@Controller
public class FindController {

	@Autowired
	private FindService findService;
	
	
	// 사용자 아이디 찾기
	@RequestMapping("/findId")
	@ResponseBody
	 public String findId(Client client) {
		
		String result = findService.findId(client);
  
		return result;
		
	}
	
	//사용자 비밀번호 찾기
	@RequestMapping("/findPwd")
	@ResponseBody
	public int findPwd(Client client) {

		int result = findService.findPwd(client);		
		return result;
		
	}
	
	//사용자 비밀번호 재설정
	@RequestMapping("/changePwd")
	@ResponseBody
	public int changePwd(Client client) {		
		int result = findService.changePwd(client);	
		return result;
		
	}
}
