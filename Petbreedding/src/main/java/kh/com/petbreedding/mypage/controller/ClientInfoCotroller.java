package kh.com.petbreedding.mypage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.service.ClientInfoService;

@Controller
public class ClientInfoCotroller {

	@Autowired
	private ClientInfoService clientInfoService;
	
	//	회원 정보 수정 
	@RequestMapping("/updateClientInfo")
	public String updateClientInfo(Client client, HttpSession session) {
		
		//TODO
		return null;
		
	} 
	@RequestMapping("/deleteClient")
	//	회원 탈퇴
	public String deleteClient(String cl_num, HttpSession session) {
		
		//TODO
		return null;
		
	}
}
