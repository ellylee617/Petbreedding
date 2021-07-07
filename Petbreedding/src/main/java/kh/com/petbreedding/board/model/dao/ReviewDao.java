package kh.com.petbreedding.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.Review;

@Repository("reviewDao")
public class ReviewDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public String getRevNumFromSeq() {
		return sqlSession.selectOne("Review.getRevNumFromSeq");
	}
	
	public List<Review> reviewSelectList(String bp_Id) {
		System.out.println("[세훈] @리뷰 조회 다오 bp_id : " + bp_Id);
		return sqlSession.selectList("Review.reviewSelectList", bp_Id);
	}
	
	public int insertReview(Review rv) {
		return sqlSession.insert("Review.insertReview", rv);
	}
	
	// 미용실 번호 har_num 을 가지고 사업자 번호 bp_id 읽어오기
	public String searchBpId(String har_num) {
		return sqlSession.selectOne("Shop.searchBpId", har_num);
	}
	
	
}
