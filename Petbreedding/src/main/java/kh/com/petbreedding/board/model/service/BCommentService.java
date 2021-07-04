package kh.com.petbreedding.board.model.service;

import java.util.List;

import kh.com.petbreedding.board.model.vo.B_comment;

public interface BCommentService {
	public List<B_comment> bCommentSelectListA();
	
	public List<B_comment> bCommentSelectListC(String bo_num);
	
	public String getbCommentSeq();
	
	public int bCommentInsert(B_comment bComment);
	
	public int bCommentDelete(String co_num, String bo_num);
	
}
