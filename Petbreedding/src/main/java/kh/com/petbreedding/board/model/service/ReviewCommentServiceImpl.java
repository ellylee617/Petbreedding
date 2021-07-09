package kh.com.petbreedding.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.ReviewCommentDao;
import kh.com.petbreedding.board.model.vo.ReviewComment;

@Service("reviewCommentService")
public class ReviewCommentServiceImpl implements ReviewCommentService {
	
	@Autowired
	private ReviewCommentDao reviewCommentDao;

	//	리뷰 댓글 등록
	@Override
	public int reviewCommentInsert(ReviewComment revCmnt) {
		int revcResult = -1;
		
		try {
			System.out.println("[세훈] @사업자 리뷰 댓글  등록 서비스 revCmnt : " + revCmnt);
			revcResult = reviewCommentDao.reviewCommentInsert(revCmnt);
			System.out.println("[세훈] @사업자 리뷰 댓글  등록 서비스 revcResult : " + revcResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return revcResult;
	}

}
