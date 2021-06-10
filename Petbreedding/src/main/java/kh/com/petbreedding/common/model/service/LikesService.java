package kh.com.petbreedding.common.model.service;

import kh.com.petbreedding.common.model.vo.Likes;

public interface LikesService {
	
	String addLikes(String like_num);
	void cancelLikes(String like_num);
}
