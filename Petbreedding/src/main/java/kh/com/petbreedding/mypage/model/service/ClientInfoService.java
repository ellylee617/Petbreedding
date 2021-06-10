package kh.com.petbreedding.mypage.model.service;

import kh.com.petbreedding.client.model.vo.Client;

public interface ClientInfoService {
	
	String selectClientInfo(String email); // 회원 정보 불러오기
	void updateClientInfo(Client client); // 회원 정보 수정 
	void deleteClient(String email); // 회원 탈퇴
}
