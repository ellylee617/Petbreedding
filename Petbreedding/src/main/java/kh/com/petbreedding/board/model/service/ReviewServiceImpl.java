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
	public List<Review> revRevcSelectList(String bp_id) {
		List<Review> revRevcList = null;
		try {
			System.out.println("[세훈] @리뷰, 댓글 조회 서비스 bp_id : " + bp_id);
			revRevcList = reviewDao.revRevcSelectList(bp_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[세훈] @리뷰, 댓글 조회 서비스 reviewList : " + revRevcList);
		return revRevcList;
	}
	
	@Override
	public List<Review> reviewSelectList(String bp_id) {
		List<Review> reviewList = null;
		
		try {
			System.out.println("[세훈] @리뷰 조회 서비스 bp_id : " + bp_id);
			reviewList = reviewDao.reviewSelectList(bp_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[세훈] @리뷰 조회 서비스 reviewList : " + reviewList);
		return reviewList;
	}
	
	@Override
	public Review reviewSelectOne(String rev_num) {
		Review review = null;
		try {
			System.out.println("[세훈] @리뷰 조회 서비스 bp_id : " + rev_num);
			review = reviewDao.reviewSelectOne(rev_num);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[세훈] @리뷰 조회 서비스 review : " + review);
		return review;
	}

	@Override
	public int insertReview(Review rv, String har_num, String har_name) {
		int result = -1;
		String clNum = rv.getClNum();
		System.out.println("[세훈] @리뷰 등록 서비스 clNum : " + clNum);
		int reviewPoint = 300;
		
		try {
			System.out.println("[세훈] @리뷰 등록 서비스 har_num : " + har_num);
			String bp_id = reviewDao.searchBpId(har_num); 
			System.out.println("리뷰 등록 가져온 bp_id" + bp_id);
			System.out.println("리뷰 등록 가져온 rv" + rv);
			rv.setBpId(bp_id);
			String rev_num = reviewDao.getRevNumFromSeq();
			rv.setRevNum(rev_num);
			
			
			result = reviewDao.insertReview(rv);
			int currPoint = 0;
			currPoint = myPointDao.CurrPointSelectOne(clNum);
			System.out.println("[세훈] @리뷰 등록 서비스 currPoint : " + currPoint);
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
		System.out.println("[세훈] @리뷰 평균 조회 서비스 bp_id : " + bp_id);
		
		try {
			revAvgResult = reviewDao.getRevValAvg(bp_id);
			System.out.println("[세훈] @리뷰 평균 조회 서비스 revAvgResult : " + revAvgResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return revAvgResult;
	}



}
