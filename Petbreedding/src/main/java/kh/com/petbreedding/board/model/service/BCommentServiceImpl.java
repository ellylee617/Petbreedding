package kh.com.petbreedding.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.BCommentDao;
import kh.com.petbreedding.board.model.vo.B_comment;

@Service("bCommentService")
public class BCommentServiceImpl implements BCommentService {
	
	@Autowired
	private BCommentDao bCommentDao;

	@Override
	public List<B_comment> bCommentSelectListA() {
		List<B_comment> bcSeListA = null;
		
		try {
			bcSeListA = bCommentDao.bCommentSelectListA();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bcSeListA;
	}

	@Override
	public List<B_comment> bCommentSelectListC(String bo_num) {
		List<B_comment> bcSeListC = null;
		
		try {
			bcSeListC = bCommentDao.bCommentSelectListC(bo_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bcSeListC;
	}

	@Override
	public String getbCommentSeq() {
		String bcSeq = null;
		
		try {
			bcSeq = bCommentDao.getbCommentSeq();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bcSeq;
	}

	@Override
	public int bCommentInsert(B_comment bComment) {
		int bcInsert = -1;
		
		try {
			bcInsert = bCommentDao.bCommentInsert(bComment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bcInsert;
	}

	@Override
	public int bocChkUpdate(String bo_num) {
		int bocChkUpd = -1;
		
		try {
			bocChkUpd = bCommentDao.bocChkUpdate(bo_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bocChkUpd;
	}

}
