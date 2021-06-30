package kh.com.petbreedding.common.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.com.petbreedding.common.model.service.LikesService;
import kh.com.petbreedding.common.model.vo.Likes;

@Controller
public class LikesController {
	
	@Autowired
	LikesService likeService;
	
	// 동물병원/미용실 찜하기
	@RequestMapping("/insertLikes")
	public int insertLikes(Likes likes) {
		
		int result = likeService.insertLikes(likes);		
		return result;
		
	}
	
	// 내 찜 목록
	@RequestMapping("/mypage/myzzim")
	public String myZzim(HttpSession session) {
		
		String cl_num = (String) session.getAttribute("cl_num");
		likeService.selectLikce(cl_num);
		
		return "/user/uMyPage/myzzim";
	}
		
	// 동물병원/미용실 찜해제
	@RequestMapping("/delLikes")
	public int delLikes(Likes likes) {
		
		int result = likeService.delLikes(likes);
		
		return result;

		
	}
}
