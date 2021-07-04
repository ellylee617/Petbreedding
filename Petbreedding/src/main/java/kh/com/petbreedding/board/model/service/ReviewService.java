package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import kh.com.petbreedding.board.model.vo.Review;

public interface ReviewService {
	public List<Review> reviewSelectList(String bpId, int currentPage, int limit);
	public double selectRevVal(String bpId);	// 리뷰 평균 계산
	public String selectCountReview(String bpId);	// 리뷰 건수 계산
	public int insertReview(Review rv, String har_num, String har_name);
}

