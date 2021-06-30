package kh.com.petbreedding.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.media.jfxmedia.logging.Logger;

import kh.com.petbreedding.board.model.vo.Board;
import kh.com.petbreedding.board.model.vo.CustomerService;
import kh.com.petbreedding.board.model.vo.Review;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.board.model.service.BoardService;
import kh.com.petbreedding.board.model.service.CustomerServiceService;
import kh.com.petbreedding.board.model.service.ReviewService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boarService;
	
	@Autowired
	private CustomerServiceService customerServiceService;
	
	public final int LIMIT = 5;

		
	//	게시글 목록 + 페이징 + 검색
	@RequestMapping(value = "/fboardlist")
	// TODO 병원 번호, 미용실 번호 GET 방식으로 들고 들어와서 파라미터로 넣어줘야함 - @RequestParam(name="harNum") String harNum
	public ModelAndView fboardlist(
			ModelAndView mv
			,HttpServletRequest req
			,@RequestParam(name = "page", defaultValue = "1") int page
			,@RequestParam(name = "keyword", required = false) String keyword
			) {
		
		int currentPage = page;
		// 한 페이지당 출력할 목록 갯수
		int listCount = boarService.listCount();
		int maxPage = (int) ((double) listCount / LIMIT + 0.9);
		List<Board> boardList = null;
		
		if(keyword != null && !keyword.equals("")) {
			boardList = boarService.searchList(keyword);
			mv.addObject("boardList", boardList);
		}
		else {
			boardList = boarService.selectBoardList(currentPage, LIMIT);
			mv.addObject("boardList", boardList);
		}
		
		mv.addObject("currentPage", currentPage);
		mv.addObject("maxPage", maxPage);
		mv.addObject("listCount", listCount);
		 
		System.out.println("[세훈] @컨트롤러 boardList : " + boardList.toString());
		mv.setViewName("/user/uBoard/fboardList");
		
		return mv;
	}
	
	// 게시글 상세
	@RequestMapping(value = "/fboardcon", method = RequestMethod.GET)
	public ModelAndView fboardcon(
			ModelAndView mv
			,@RequestParam(name="boNum") String boNum
			,@RequestParam(name = "page", defaultValue = "1") int page
			) {
		
		int currentPage = page;
		Board board = boarService.selectBoardDetail(0, boNum);
		System.out.println("[세훈] @자유 게시글 상세 컨트롤러 board : " + board);
		
		mv.setViewName("/user/uBoard/fboardcon");
		
		mv.addObject("currentPage", currentPage);
		mv.addObject("board", board);
		
		return mv;
	}
	
	// 게시글 작성
	@RequestMapping(value = "/bwrite", method = RequestMethod.GET)
	public String bWrite(Locale locale, Model model) {
		return "/user/uBoard/bwrite";
	}
	
	
	@Autowired
	private ReviewService reviewService;
	
	// 리뷰 작성
	@RequestMapping(value = "/rwrite", method = RequestMethod.POST)
	public String rwrite(
			HttpSession session
			,MultipartHttpServletRequest req
			,HttpServletResponse res
			,Client cl
			,@RequestParam(name="revCont") String revCont
			,@RequestParam(name="selectedVal") int revVal
			) {
		res.setContentType("text/html; charset=utf-8");
		System.out.println("리뷰 등록 컨트롤러 진입");
		cl = (Client) session.getAttribute("client");
		if(cl==null) {
			//TODO: 로그인 안됐다는 경고.또는 이동 위치 변경
			return "redirect:/";
		}
		String clNum = cl.getCl_num();
		String clNickName = cl.getNickname();
		String har_num = req.getParameter("har_num");
		String har_name = req.getParameter("har_name");
		
		System.out.println("리퀘스트 겟 파라메타" + req.getParameter("selectedVal"));
		System.out.println("[세훈] har_num:"+ har_num);
		System.out.println("[세훈] har_name:"+ har_name);
		
		Review rv = new Review();
		
		System.out.println(clNum);
		System.out.println(clNickName);
		System.out.println(revCont);
		
		rv.setClNickName(clNickName.replaceAll("\r\n", "<br>"));
		rv.setClNum(clNum.replaceAll("\r\n", "<br>"));
		rv.setRevCont(revCont);
		rv.setRevVal(revVal);
		
		// 파일업로드
		MultipartFile mf = req.getFile("reviewImg"); // 업로드 파라미터
		if(mf != null) {
			
			String path = req.getRealPath("/resources/uploadFile/review"); // 자징될 위치
			UUID uuid = UUID.randomUUID(); // 랜덤 숫자 생성
			String fileName = mf.getOriginalFilename(); // 업로드 파일 원본 이름 저장
			String saveName = uuid.toString() + "_" + fileName; // 저장될 이름
			File uploadFile = new File(path + "//" + saveName); // 복사될 위치
			
			try {
				mf.transferTo(uploadFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			rv.setRevImg(saveName);
			
			System.out.println("[세훈] 리뷰 이미지 경로 : " + saveName);
		}
		
		System.out.println("[세훈 ]" + rv.toString());
		int result = reviewService.insertReview(rv, har_num, har_name);
		
		PrintWriter out = null;
		
		String msg1 = "리뷰가 등록되었습니다.";
		String msg2 = "리뷰가 등록되지 않았습니다.";
		
		try {
			out = res.getWriter();
			if(result == 1) {
				out.println("<script>alert('" + msg1 + "');</script>");
				System.out.println("[세훈] 리뷰 등록 성공");
				
			} else {
				out.println("<script>alert('" + msg2 + "');</script>");
				System.out.println("[세훈] 리뷰 등록 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
		
		
		return "redirect:/mypage?cl_num=CL1";
	}
	
	
	//	유저 공지사항 리스트 조회
	@RequestMapping(value = "/UcustomerService", method = RequestMethod.GET)
	public String UcustomerService(Model md) {
		
		List<CustomerService> csList = null;
		
		csList = customerServiceService.CustomerServiceSelectListC();
		
		md.addAttribute("csList", csList);
		
		return "/user/uBoard/UcustomerService";
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
