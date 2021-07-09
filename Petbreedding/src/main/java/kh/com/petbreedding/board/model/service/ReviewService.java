package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import kh.com.petbreedding.board.model.vo.Review;

public interface ReviewService {
	public List<Review> reviewSelectList(String bpId);
	public Review reviewSelectOne(String rev_num);
	public int insertReview(Review rv, String har_num, String har_name);
}

