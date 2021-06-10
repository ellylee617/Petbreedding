package kh.com.petbreedding.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.petbreedding.board.model.service.BoardService;
import kh.com.petbreedding.board.model.vo.Board;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boarService;
	
	// 게시글 작성 등록
	@RequestMapping("/boardwrite")
	public String boardWrite(Board board, RedirectAttributes attr) {
		
		//TODO
		return null;
		
	}
	
	// 게시글 상세
	
	@RequestMapping("/boarddetail")
	public ModelAndView boardModify(String bo_num) {
		
		//TODO
		return null;
		
	}
	
	//게시글 목록 + 페이징 + 검색
	@RequestMapping("/bordlist")
	public  String listBoard(RedirectAttributes attr, int currentPage, String searchValue) {
		
		//TODO
		return null;
		
	}
	
	
	
	

}
