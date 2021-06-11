package kh.com.petbreedding.board.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//게시글 목록 + 페이징 + 검색
//	@RequestMapping("/bordlist")
//	public  String listBoard(RedirectAttributes attr, int currentPage, String searchValue) {
//		
//		//TODO
//		return "null"
//	}
	
	@RequestMapping(value = "/fboardlist", method = RequestMethod.GET)
	public String fboardlist(Locale locale, Model model) {
		return "/board/fboardList";
	}
	
	@RequestMapping(value = "/fboardcon", method = RequestMethod.GET)
	public String fboardcon(Locale locale, Model model) {
		return "/board/fboardcon";
	}
	
	@RequestMapping(value = "/UcustomerService", method = RequestMethod.GET)
	public String UcustomerService(Locale locale, Model model) {
		return "/board/UcustomerService";
	}
	@RequestMapping(value = "/bwrite", method = RequestMethod.GET)
	public String bwrite(Locale locale, Model model) {
		return "/board/bwrite";
	}
	@RequestMapping(value = "/oftenqna", method = RequestMethod.GET)
	public String oftenqna(Locale locale, Model model) {
		return "/board/oftenqna";
	}
	@RequestMapping(value = "/mypet", method = RequestMethod.GET)
	public String mypet(Locale locale, Model model) {
		return "/board/mypet";
	}
	@RequestMapping(value = "/mypetRegister", method = RequestMethod.GET)
	public String mypetRegister(Locale locale, Model model) {
		return "/board/mypetRegister";
	}
	
	
	
	
	
	

}
