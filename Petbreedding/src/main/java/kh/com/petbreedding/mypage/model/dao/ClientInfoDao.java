package kh.com.petbreedding.mypage.model.dao;

import org.springframework.stereotype.Repository;

import kh.com.petbreedding.client.model.vo.Client;

@Repository("clientInfoDao")
public class ClientInfoDao {
	
	// 회원 정보 불러오기
	public Client selectClientInfo(String email) {
		
		// TODO Auto-generated method stub
		return null;
		
	}
	
	// 회원 정보 수정 
	public void updateClientInfo(Client client) {
	
		// TODO Auto-generated method stub
	}
	
	// 회원 탈퇴
	public void deleteClient(String email){
		
		// TODO Auto-generated method stub
	}
	
	
}
