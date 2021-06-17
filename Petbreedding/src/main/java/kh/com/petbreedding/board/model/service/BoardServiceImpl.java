package kh.com.petbreedding.board.model.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.vo.Board;
import kh.com.petbreedding.board.model.vo.BoardPaging;

@Service("boarService")
public class BoardServiceImpl implements BoardService{

	@Override
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
		int result = -1;
		
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBoard(String bo_num) {
		// TODO Auto-generated method stub
		
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Board selectBoardDetail(String bo_num) {
		// TODO Auto-generated method stub
		Board board = null;
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}

	@Override
	public BoardPaging selectBoardList(int currentPage, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		BoardPaging boardPaging = null;
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return boardPaging;
	}

	@Override
	public int totalCount(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		int result = -1;
		
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void veiwCnt(String bo_num) {
		// TODO Auto-generated method stub
		
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}


}
