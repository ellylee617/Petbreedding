package kh.com.petbreedding.board.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kh.com.petbreedding.board.model.vo.MyAsk;

public interface MyAskService {
	public int listCount();
	public List<MyAsk> MyAskSelectList(String user_num);
	public List<MyAsk> MyAskSelectListM(int currentPage, int limit);
	public MyAsk MyAskSelectDetail(String qna_num);
	public int MyAskInsert(MyAsk myAsk);
	public int MyAskDelete(String qna_num);
}
