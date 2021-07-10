package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import kh.com.petbreedding.board.model.vo.Review;

public interface ReviewService {
	public List<Review> reviewSelectList(String bpId);
	public List<Review> revRevcSelectList(String bp_id);
	public Review reviewSelectOne(String rev_num);
	public int insertReview(Review rv, String har_num, String har_name);
	public int getRevCount(String bp_id);	//	사업자 리뷰 개수 받아오기
	public String getRevValAvg(String bp_id); // 리뷰 평균 값 조회
}

