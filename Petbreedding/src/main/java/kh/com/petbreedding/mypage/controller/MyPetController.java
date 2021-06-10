package kh.com.petbreedding.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.petbreedding.mypage.model.service.MyPetService;
import kh.com.petbreedding.mypage.model.vo.MyPet;

@Controller
public class MyPetController {
	
	@Autowired
	private MyPetService myPetService;
	
	// 마이펫 수첩 메인 페이지 + 정보 불러오기
	@RequestMapping("/mypage/openMyPet")
	public ModelAndView openMyPet(HttpSession session) {
		
		//TODO
		return null;
	}
	
	
	// 새 동물 등록하기
	@RequestMapping("/mypage/addmypet")
	public String addMyPet(MyPet mypet) {
		
		//TODO
		return null;
		
		
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
