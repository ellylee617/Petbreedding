package kh.com.petbreedding.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.MyAskComment;

@Repository("myAskCommentDao")
public class MyAskCommentDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// <!-- 해당 문의 사항의 댓글 조회 -->
	public List<MyAskComment> myAskCommentSelectOne(String qna_num) {
		System.out.println("문의사항 번호!" + qna_num);
		return sqlSession.selectList("MyAskComment.myAskCommentSelectOne", qna_num);
	}
	
	// <!-- 문의 사항 댓글 시퀀스 더미 테이블을 이용해 가져오기 -->
	public String getMyAskCommentSeq() {
		
		System.out.println("다오는 진입하니?");
		return sqlSession.selectOne("MyAskComment.getMyAskCommentSeq");
	}
	
	// <!-- 문의 사항 댓글 등록 -->
	public int myAskCommentInsert(MyAskComment maComment) {
		return sqlSession.insert("MyAskComment.myAskCommentInsert", maComment);
	}
	
	// <!-- 문의 사항 답변 여부 등록  -->
	public int myAskChkUpdate(String qna_num) {
		return sqlSession.update("MyAskComment.myAskChkUpdate", qna_num);
	}
}
