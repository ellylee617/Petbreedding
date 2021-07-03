package kh.com.petbreedding.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.MyAsk;

@Repository("myAskDao")
public class MyAskDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int listCount() {
		return sqlSession.selectOne("MyAsk.listCount");
	}
	
	public List<MyAsk> MyAskSelectList(String user_num) {
		System.out.println("[세훈] @일대일 문의 다오 진입");
		return sqlSession.selectList("MyAsk.MyAskSelectList", user_num);
	}
	
	public List<MyAsk> MyAskSelectListM(int currentPage, int limit) {
		int startRow = (currentPage -1) * limit;
		RowBounds row = new RowBounds(startRow, limit);
		
		return sqlSession.selectList("MyAsk.MyAskSelectListM", null, row);
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
	
	public String getBpNickName(String user_num) {
		return sqlSession.selectOne("MyAsk.getBpNickName", user_num);
	}
	
	public int MyAskDelete(String qna_num) {
		return sqlSession.delete("MyAsk.MyAskDelete", qna_num);
	}
}
