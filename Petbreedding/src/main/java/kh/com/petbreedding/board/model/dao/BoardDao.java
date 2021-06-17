package kh.com.petbreedding.board.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.Board;

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
		public Board selectBoardDetail(String boNum) {
			Board board = null;
			board = sqlSession.selectOne("Board.selectOneBoard", boNum);
			return board;
		} 
		
		// 게시글 리스트 조회
		public List<Board> selectBoardList(int currentPage, int limit) {
			int startRow = (currentPage -1) * limit;
			RowBounds row = new RowBounds(startRow, limit);
			return sqlSession.selectList("Board.selectBoardList", null, row);
		}
		
		public int totalCount(HashMap<String, String> map) {
			//TODO
			return 0;
		}
		
		public void veiwCnt(String bo_num) {
			//TODO
		}
}
