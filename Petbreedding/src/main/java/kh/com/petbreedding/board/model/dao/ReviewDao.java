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
	
	public List<Review> reviewSelectList(int currentPage, int limit) {
		System.out.println("다오 진입");
		int startRow = (currentPage -1) * limit;
		RowBounds row = new RowBounds(startRow, limit);
		System.out.println("다오 끝");
		return sqlSession.selectList("Review.reviewSelectList", null, row);
	}
}
