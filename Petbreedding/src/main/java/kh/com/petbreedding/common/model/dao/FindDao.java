package kh.com.petbreedding.common.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.client.model.vo.Client;

@Repository("findDao")
public class FindDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//사용자 아이디 찾기
	public String findId(Client client) {	
		return sqlSession.selectOne("Login.searchId", client);		
	}
	
	//사용자 비밀번호 찾기 
	public int findPwd(Client client) {	
		return sqlSession.selectOne("Login.searchPwd", client);
	}
	
	//사용자 비밀번호 재설정
	public int changePwd(Client client) {	
		int result = sqlSession.update("Login.changePwd", client);
		return result;
	}
}
