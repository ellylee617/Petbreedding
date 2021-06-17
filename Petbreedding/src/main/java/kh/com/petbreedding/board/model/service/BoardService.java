package kh.com.petbreedding.board.model.service;

import java.util.HashMap;
import java.util.List;
import kh.com.petbreedding.board.model.vo.Board;

public interface BoardService {
	
	public int insertBoard(Board board); // 게시글 작성
	public void updateBoard(Board board); // 게시글 수정
	public void deleteBoard(String bo_num); // 게시글 삭제
	public Board selectBoardDetail(String bo_num); // 게시글 하나 읽기
	public List<Board> selectBoardList(int currentPage, int limit);
	public int totalCount(HashMap<String, String> map); // 게시글 카운팅
	public void veiwCnt(String bo_num); // 게시글 조회수
}
