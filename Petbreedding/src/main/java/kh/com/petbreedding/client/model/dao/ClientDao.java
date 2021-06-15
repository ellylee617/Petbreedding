package kh.com.petbreedding.client.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.client.model.vo.Client;

@Repository("clientDao")
public class ClientDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insertClient(Client client) { // 이메일 회원가입
		return sqlSession.insert("ClientMap.insertClient", client);
	}
	
	public int checkEmail(String email) {	// 이메일 중복 확인	
		System.out.println("dao까지 왔음 "+ email);
		return sqlSession.selectOne("ClientMap.checkEmail", email);	
	}
	
	public int checkNickName(String nickname) {	// 닉네임 중복 확인	
		return sqlSession.selectOne("ClientMap.checkNickName", nickname);	
	}
	
	public void createAuthKey(String email, String authCode) {	// 이메일 인증번호 생성
		
	}
	
	
	
	
	
}
