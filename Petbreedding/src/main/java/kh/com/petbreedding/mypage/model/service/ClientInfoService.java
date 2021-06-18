package kh.com.petbreedding.mypage.model.service;

import kh.com.petbreedding.client.model.vo.Client;

public interface ClientInfoService {
	
	public String selectClientInfo(String email); // 회원 정보 불러오기
	public int updateClientInfo(Client client); // 회원 정보 수정 
	public void deleteClient(String email); // 회원 탈퇴
}
