package kh.com.petbreedding.board.model.service;

import java.util.HashMap;

import kh.com.petbreedding.board.model.vo.Board;
import kh.com.petbreedding.board.model.vo.BoardPaging;

public interface BoardService {
	
	public int insertBoard(Board board); // 게시글 작성
	public void updateBoard(Board board); // 게시글 수정
	public void deleteBoard(String bo_num); // 게시글 삭제
	public Board selectBoardDetail(String bo_num); // 게시글 하나 읽기
	public BoardPaging selectBoardList(int currentPage, HashMap<String, String> map); // 게시글 목록+페이징
	public int totalCount(HashMap<String, String> map); // 게시글 카운팅
	public void veiwCnt(String bo_num); // 게시글 조회수
}
