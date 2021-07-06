package kh.com.petbreedding.board.model.service;

import java.util.HashMap;
import java.util.List;
import kh.com.petbreedding.board.model.vo.Board;

public interface BoardService {
	
	public int insertBoard(Board board); // 게시글 작성
	public int updateBoard(Board board); // 게시글 수정
	public int deleteBoard(String bo_num); // 게시글 삭제
	public int listCount(); //전체 글 수 조회
	public Board selectBoardDetail(int chk, String bo_num); // 게시글 하나 읽기
	public List<Board> selectBoardList(int currentPage, int limit); // 게시글 리스트 조회
	public List<Board> searchList(String keyword); // 게시글 검색 조회
}
