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
	
	public List<Review> reviewSelectList(String bpId, int currentPage, int limit) {
		System.out.println("다오 진입");
		int startRow = (currentPage -1) * limit;
		RowBounds row = new RowBounds(startRow, limit);
		System.out.println("다오 끝");
		return sqlSession.selectList("Review.reviewSelectList", bpId, row);
	}
	
	public int insertReview(Review rv) {
		System.out.println("리뷰 등록 다오 진입");
		return sqlSession.insert("Review.insertReview", rv);
	}
	
	// 미용실 번호 har_num 을 가지고 사업자 번호 bp_id 읽어오기
	public String searchBpId(String har_num) {
		return sqlSession.selectOne("Shop.searchBpId", har_num);
	}
}
