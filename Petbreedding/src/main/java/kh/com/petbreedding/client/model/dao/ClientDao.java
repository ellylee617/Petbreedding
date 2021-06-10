package kh.com.petbreedding.client.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.client.model.vo.Client;

@Repository
public class ClientDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void insertClient(Client client) { // 이메일 회원가입
		
	}
	
	public int checkEmail(Client client) {				// 이메일 중복 확인
		
		return 0;
		
	}
	
	public void createAuthKey(String email, String authCode) {	// 이메일 인증번호 생성
		
	}
	
	
	
	
	
}
