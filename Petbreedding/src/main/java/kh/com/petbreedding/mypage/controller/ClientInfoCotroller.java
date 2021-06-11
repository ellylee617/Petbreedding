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
	
	// 예약조회
	@RequestMapping("/mypage")
	public String myReservationList(HttpSession session) {
		return "myPage/myReservationList";
	}
	
	// 예약 자세히 보기
	@RequestMapping("/mypage/reservationdetail")
	public String myReservationDetail(HttpSession session) {
		return "myPage/myReservationDetail";
	}
	
	// 포인트내역
		@RequestMapping("/mypage/point")
		public String point(HttpSession session) {
			return "myPage/point";
		}
	
	// 회원 정보 불러오기
	@RequestMapping("/mypage/selectClienInfo")
	public String selectClientInfo(HttpSession session) {
		
		return null;
		
	}
	
	//	회원 정보 수정 
	@RequestMapping("mypage/updateClientInfo")
	public String updateClientInfo(Client client, HttpSession session) {
		
		//TODO
		return null;
		
	} 
	@RequestMapping("mypage/deleteClient")
	//	회원 탈퇴
	public String deleteClient(String cl_num, HttpSession session) {
		
		//TODO
		return null;
		
	}
}
