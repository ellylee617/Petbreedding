package kh.com.petbreedding.common.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.client.model.vo.Client;

@Repository("findDao")
public class FindDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 아이디 찾기
	public String findId(Client client) {
		
		// TODO Auto-generated method stub
		return null;
		
	}
	
	// 비밀번호 찾기 
	public String findPwd(Client client) {
		
		// TODO Auto-generated method stub
		return null;
	}
}
