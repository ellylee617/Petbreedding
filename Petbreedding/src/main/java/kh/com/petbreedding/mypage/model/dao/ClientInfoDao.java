package kh.com.petbreedding.mypage.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.client.model.vo.Client;

@Repository("clientInfoDao")
public class ClientInfoDao {
	
	@Autowired
	SqlSession sqlSession;
	
	// 회원 정보 불러오기
	public Client selectClientInfo(String email) {
		
		// TODO Auto-generated method stub
		return null;
		
	}
	
	// 회원 정보 수정 
	public int updateClientInfo(Client client) {
		return sqlSession.update("Modify.modifyClient", client);
	} 
	

	// 회원 탈퇴
	public void deleteClient(String email) {
		
	}
	
	
}
