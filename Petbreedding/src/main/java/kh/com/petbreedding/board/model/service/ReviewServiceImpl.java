package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.com.petbreedding.bmypage.model.dao.ShopDao;
import kh.com.petbreedding.board.model.dao.ReviewDao;
import kh.com.petbreedding.board.model.vo.Review;
import kh.com.petbreedding.mypage.model.dao.MyPointDao;
import kh.com.petbreedding.mypage.model.vo.MyPoint;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private MyPointDao myPointDao;

	
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
	public int insertReview(Review rv, String har_num, String har_name) {
		System.out.println("리뷰 등록 서비스 진입");
		int result = -1;
		String clNum = rv.getClNum();
		int reviewPoint = 500;
		
		try {
			System.out.println("[shkim]har_num" + har_num);
			String bp_id = reviewDao.searchBpId(har_num); 
			rv.setBpId(bp_id);
			String rev_num = reviewDao.getRevNumFromSeq();
			rv.setRevNum(rev_num);
			
			
			result = reviewDao.insertReview(rv);
			int currPoint = 0;
			currPoint = myPointDao.CurrPointSelectOne(clNum);
			currPoint += reviewPoint;
			
			MyPoint myPoint = new MyPoint();
			myPoint.setClNum(clNum);
			myPoint.setExpFrom(har_name);
			myPoint.setExpId(rev_num);
			myPoint.setExpType("적립");
			myPoint.setPointNum("PO4");
			myPoint.setCurrPoint(currPoint);
			myPoint.setExpPoint(reviewPoint);
			
			myPointDao.myPointInsert(myPoint);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
			
		return result;
	}

	




}
