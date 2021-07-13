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

	// 상세페이지 리뷰, 댓글 조회
	@Override
	public List<Review> revRevcSelectListUpToDate(Map<String, String> map) {
		List<Review> revRevcListUpd = null;
		try {
			revRevcListUpd = reviewDao.revRevcSelectListUpToDate(map);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return revRevcListUpd;
	}
	
	//	상세페이지 리뷰, 댓글 평점 높은 순
	@Override
	public List<Review> revRevcSelectListDesc(Map<String, String> map) {
		List<Review> revRevcListDesc = null;
		try {
			revRevcListDesc = reviewDao.revRevcSelectListDesc(map);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return revRevcListDesc;
	}

	//	상세페이지 리뷰, 댓글 평점 낯은 순
	@Override
	public List<Review> revRevcSelectListAsc(Map<String, String> map) {
		List<Review> revRevcListAsc = null;
		try {
			revRevcListAsc = reviewDao.revRevcSelectListAsc(map);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return revRevcListAsc;
	}
	
	@Override
	public List<Review> reviewSelectList(Map<String, String> map) {
		List<Review> reviewList = null;
		
		try {
			reviewList = reviewDao.reviewSelectList(map);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return reviewList;
	}
	
	@Override
	public Review reviewSelectOne(String rev_num) {
		Review review = null;
		try {
			review = reviewDao.reviewSelectOne(rev_num);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return review;
	}

	@Override
	public int insertReview(Review rv, String har_num, String har_name) {
		int result = -1;
		String clNum = rv.getClNum();
		int reviewPoint = 300;
		
		try {
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

	//	사업자 리뷰 개수 받아오기
	@Override
	public int getRevCount(String bp_id) {
		int revcount = -1;
		
		try {
			revcount = reviewDao.getRevCount(bp_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return revcount;
	}

	@Override
	public String getRevValAvg(String bp_id) {
		String revAvgResult = null;
		
		try {
			revAvgResult = reviewDao.getRevValAvg(bp_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return revAvgResult;
	}





}
