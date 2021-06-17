package kh.com.petbreedding.board.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.media.jfxmedia.logging.Logger;

import kh.com.petbreedding.board.model.vo.Board;
import kh.com.petbreedding.board.model.service.BoardService;


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
	
	//	게시글 목록 + 페이징 + 검색
	@RequestMapping(value = "/fboardlist", method = RequestMethod.GET)
	public ModelAndView fboardlist(Locale locale, ModelAndView mv) {
		List<Board> boardList = boarService.selectBoardList(1, 10);
		mv.addObject("boardList", boardList);
		mv.setViewName("/user/uBoard/fboardList");
		
		return mv;
	}
	
	@RequestMapping(value = "/fboardcon", method = RequestMethod.GET)
	public ModelAndView fboardcon(
			Locale locale,
			ModelAndView mv,
			@RequestParam(name="boNum") String boNum
			) {
		
		Board board = boarService.selectBoardDetail(boNum);
		System.out.println("컨트롤러 서비스 다녀왔음 : " + board);
		mv.setViewName("/user/uBoard/fboardcon");
		mv.addObject("board", board);
		
		return mv;
	}
	
	@RequestMapping(value = "/UcustomerService", method = RequestMethod.GET)
	public String UcustomerService(Locale locale, Model model) {
		return "/user/uBoard/UcustomerService";
	}
	@RequestMapping(value = "/bwrite", method = RequestMethod.GET)
	public String bwrite(Locale locale, Model model) {
		return "/user/uBoard/bwrite";
	}
	@RequestMapping(value = "/oftenqna", method = RequestMethod.GET)
	public String oftenqna(Locale locale, Model model) {
		return "/user/uBoard/oftenqna";
	}
	@RequestMapping(value = "/mypet", method = RequestMethod.GET)
	public String mypet(Locale locale, Model model) {
		return "/user/uMyPage/mypet";
	}
	@RequestMapping(value = "/mypetRegister", method = RequestMethod.GET)
	public String mypetRegister(Locale locale, Model model) {
		return "/user/uMyPage/mypetRegister";
	}
	
	@RequestMapping(value = "/myboard", method = RequestMethod.GET)
	public String myboard(Locale locale, Model model) {
		return "/user/uMyPage/myboard";
	}
	@RequestMapping(value = "/myreply", method = RequestMethod.GET)
	public String myreply(Locale locale, Model model) {
		return "/user/uMyPage/myreply";
	}
	
	
	
	
	
	
	

}
