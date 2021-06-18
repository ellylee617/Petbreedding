package kh.com.petbreedding.board.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.BoardDao;
import kh.com.petbreedding.board.model.vo.Board;

@Service("boarService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;

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
	
	//	게시판 리스트 조회
	@Override
	public List<Board> selectBoardList(int currentPage, int limit) {
		List<Board> board = null;
		
		try {
			System.out.println(board);
			System.out.println(currentPage);
			System.out.println(limit);
			board = boardDao.selectBoardList(currentPage, limit);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(board);
		return board;
	}

	@Override
	public Board selectBoardDetail(String boNum) {
		Board board = null;
		try {
			board = boardDao.selectBoardDetail(boNum);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return board;
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
