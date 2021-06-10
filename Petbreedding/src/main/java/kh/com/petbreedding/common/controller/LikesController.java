package kh.com.petbreedding.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kh.com.petbreedding.common.model.service.LikesService;

@Controller
public class LikesController {
	
	@Autowired
	LikesService likeService;
	
	// 동물병원/미용실 찜하기
	public Object addLikes(String like_num) {
		
		// TODO Auto-generated method stub
		return like_num;
		
	}
	
	// 동물병원/미용실 찜해제
	public Object cancelLikes(String like_num) {
		
		// TODO Auto-generated method stub
		return like_num;
		
	}
}
