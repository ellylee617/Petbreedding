package kh.com.petbreedding.board.model.service;

import java.util.List;

import kh.com.petbreedding.board.model.vo.MyAsk;

public interface MyAskService {
	public List<MyAsk> MyAskSelectList(String user_num);
	public MyAsk MyAskSelectDetail(String qna_num);
	public int MyAskInsert(MyAsk myAsk);
}
