package kh.com.petbreedding.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.com.petbreedding.bmypage.model.dao.ShopDao;
import kh.com.petbreedding.board.model.dao.ReviewDao;
import kh.com.petbreedding.board.model.vo.Review;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;


	@Override
	public List<Review> reviewSelectList(String bpId, int currentPage, int limit) {
		System.out.println("서비스 진입1");
		
		List<Review> reviewList = null;
		System.out.println("서비스 진입2");

		try {
			System.out.println("서비스 진입3");
			reviewList = reviewDao.reviewSelectList(bpId, currentPage, limit);
			System.out.println("다오 다녀왔다면 보여줘 --> " + reviewList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("서비스 끝");
		return reviewList;
	}

	@Override
	public int insertReview(Review rv, String har_num) {
		System.out.println("리뷰 등록 서비스 진입");
		int result = -1;
		
		try {
			System.out.println("[shkim]har_num" + har_num);
			String bp_id = reviewDao.searchBpId(har_num); 
			rv.setBpId(bp_id);
			result = reviewDao.insertReview(rv);
		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
