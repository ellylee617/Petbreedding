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
		return "/user/uMyPage/myReservationList";
	}

	// 예약 자세히 보기
	@RequestMapping("/mypage/reservationdetail")
	public String myReservationDetail(HttpSession session) {
		return "/user/uMyPage/myReservationDetail";
	}

	// 포인트내역
	@RequestMapping("/mypage/point")
	public String point(HttpSession session) {
		return "/user/uMyPage/point";
	}

	// 1:1 문의 내역
	@RequestMapping("/mypage/ask")
	public String ask(HttpSession session) {
		return "/user/uMyPage/myAsk";
	}

	// 1:1 문의 자세히 보기
	@RequestMapping("/mypage/askdetail")
	public String askDetail(HttpSession session) {
		return "/user/uMyPage/myAskDetail";
	}
	
	// 내 찜 목록
		@RequestMapping("/mypage/myzzim")
		public String myZzim(HttpSession session) {
			return "/user/uMyPage/myzzim";
		}

	// 회원 정보 불러오기
	@RequestMapping("/mypage/selectClienInfo")
	public String selectClientInfo(HttpSession session) {

		return null;

	}

	
	//회원정보 수정 탈퇴는 ClientController
}
