package kh.com.petbreedding.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.MyAsk;

@Repository("myAskDao")
public class MyAskDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<MyAsk> MyAskSelectList(String user_num) {
		System.out.println("[세훈] @일대일 문의 다오 진입");
		return sqlSession.selectList("MyAsk.MyAskSelectList", user_num);
	}
	
	public MyAsk MyAskSelectOne(String qna_num) {
		return sqlSession.selectOne("MyAsk.MyAskSelectOne", qna_num);
	}
	
	public int MyAskInsert(MyAsk myAsk) {
		System.out.println("[세훈] @MyAsk 다오 myAsk" + myAsk.toString());
		return sqlSession.insert("MyAsk.MyAskInsert", myAsk);
	}
	
	public String getClientNickName(String user_num) {
		return sqlSession.selectOne("MyAsk.getClientNickName", user_num);
	}
}
