package kh.com.petbreedding.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.B_comment;

@Repository("bCommentDao")
public class BCommentDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<B_comment> bCommentSelectListA() {
		return sqlSession.selectList("boardComment.bCommentSelectListA");
	}
	
	public List<B_comment> bCommentSelectListC(String bo_num) {
		return sqlSession.selectList("boardComment.bCommentSelectListC", bo_num);
	}
	
	public String getbCommentSeq() {
		return sqlSession.selectOne("boardComment.getbCommentSeq");
	}
	
	public int bCommentInsert(B_comment bComment) {
		return sqlSession.insert("boardComment.bCommentInsert", bComment);
	}
	
	public int bocChkUpdate(String bo_num) {
		return sqlSession.update("boardComment.bocChkUpdate", bo_num);
	}
}
