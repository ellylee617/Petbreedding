package kh.com.petbreedding.board.model.service;

import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.ReviewCommentDao;
import kh.com.petbreedding.board.model.vo.ReviewComment;

@Service("reviewCommentService")
public class ReviewCommentServiceImpl implements ReviewCommentService {
	
	private ReviewCommentDao reviewCommentDao;

	//	리뷰 댓글 등록
	@Override
	public int reviewCommentInsert(ReviewComment revCmnt) {
		int revcResult = -1;
		
		try {
			revcResult = reviewCommentDao.reviewCommentInsert(revCmnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return revcResult;
	}

}
