package kh.com.petbreedding.board.model.service;

import java.util.List;
import kh.com.petbreedding.board.model.vo.Review;

public interface ReviewService {
	public List<Review> reviewSelectList(int currentPage, int limit);
	public int insertReview(Review rv);
}

