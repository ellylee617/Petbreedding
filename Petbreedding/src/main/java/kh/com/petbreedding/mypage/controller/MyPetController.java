package kh.com.petbreedding.mypage.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.petbreedding.mypage.model.service.MyPetService;
import kh.com.petbreedding.mypage.model.vo.MyPet;

@Controller
@RequestMapping("/Mypage/*")
public class MyPetController {
	
	@Autowired
	private MyPetService myPetService;
	
	// 마이펫 수첩 메인 페이지 + 정보 불러오기
	@RequestMapping("openMyPet")
	public String openMyPet(HttpSession session) {
		//TODO
		return "user/uMyPage/mypetRegister";
	}
	
	
	// 새 동물 등록하기
	@RequestMapping(value = "addmypet", method = RequestMethod.POST)
	public String addMyPet(
			MultipartHttpServletRequest request
			) throws Exception {
		MyPet mypet = new MyPet();
		mypet.setCl_num(request.getParameter("cl_num"));
		mypet.setDislike(request.getParameter("dislike"));
		mypet.setKneecap(request.getParameter("kneecap"));
		mypet.setPet_birth(request.getParameter("pet_birth"));
		mypet.setPet_bite(request.getParameter("pet_bite"));
		mypet.setPet_exper(request.getParameter("pet_exper"));
		mypet.setPet_gen(request.getParameter("pet_gen"));
		mypet.setPet_kind(request.getParameter("pet_kind"));
		mypet.setPet_name(request.getParameter("pet_name"));
		mypet.setPet_neut(request.getParameter("pet_neut"));
		mypet.setPet_others(request.getParameter("pet_others"));
		mypet.setPet_vaccin(request.getParameter("pet_vaccin"));
		
		//파일업로드 
		MultipartFile mf = request.getFile("pet_img"); //업로드 파라미터
		String path = request.getRealPath("/resources/uploadFile/mypet"); //자징될 위치
		String fileName = mf.getOriginalFilename(); // 업로듶 파일이름
		File uploadFile = new File(path+"//"+fileName); //복사될 위치 
		try {
			mf.transferTo(uploadFile);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		mypet.setPet_img(fileName);
		
		myPetService.insertPetInfo(mypet);
		return "redirect:petlist"; 
		
		
	}
	
	//반려동물 목록 불러오기
	@RequestMapping("petlist")
	public ModelAndView MyPet() throws Exception {
		System.out.println("컨트롤러들어옴");
			List<MyPet> list = myPetService.selectPetInfo();
			//모델앤뷰
			ModelAndView mav = new ModelAndView();
			System.out.println("db들고옴");
			mav.setViewName("user/uMyPage/mypet");
			mav.addObject("list", list);
			return mav;
		
		
	}
	
	// 반려동물 정보 이미지 등록 
	
	@RequestMapping("mypage/insertPetImg")
	public String addPetImg(HttpSession session, MultipartHttpServletRequest req) {
		
		//TODO
		return null;
		
	}
	
	//반려동물 정보 이미지 삭제 
	
	@RequestMapping("mypage/deletePetImg")
	public String deletePetImg( HttpSession session , HttpServletRequest req) {
		
		//TODO
		return null;
		
	}
	
	// 반려동물 정보 수정 페이지 + 정보 불러오기
	@RequestMapping("/mypage/openUpdateMyPet")
	public ModelAndView openUpdateMyPet(HttpSession session) {
		
		//TODO 
		return null;
		
	}
	
	// 반려동물 정보 수정하기
	@RequestMapping("/mypage/updatePet")
	public String reviewupdate(String pet_num, RedirectAttributes attr) {
		
		
		//TODO
		return null;
	}
	
	// 반려동물 정보 삭제
	@RequestMapping("/deletePet")
	public String resvCancel(String pet_num) {
		
		//TODO
		return null;
		
		
	}
	
	
}
