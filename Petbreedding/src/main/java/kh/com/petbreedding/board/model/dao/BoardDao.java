package kh.com.petbreedding.board.model.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.Board;
import kh.com.petbreedding.board.model.vo.BoardPaging;

@Repository("boardDao")
public class BoardDao {
		
	@Autowired
	private SqlSession sqlSession;
	
		// 게시글 작성
		public int insertBoard(Board board) {
			
			//TODO
			return 0;
		}
		
		// 게시글 수정
		public void updateBoard(Board board) {
			//TODO
		}
		
		// 게시글 삭제
		public void deleteBoard(String bo_num) {
			//TODO
		}
		
		// 게시글 보기
		public Board selectBoardDetail(String bo_num) {
			//TODO
			return null;
		} 
		
		public BoardPaging selectBoardList(int currentPage, HashMap<String, String> map) {
			//TODO
			return null;
		}
		
		public int totalCount(HashMap<String, String> map) {
			//TODO
			return 0;
		}
		
		public void veiwCnt(String bo_num) {
			//TODO
		}
}
