package kh.com.petbreedding.common.model.service;

import java.util.List;

import kh.com.petbreedding.common.model.vo.Likes;

public interface LikesService {
	
	public int insertLikes(Likes likes);
	public List<Likes> selectLikes(String cl_num);
	public int delLikes(Likes likes);
	public int clickLike(Likes likes);
}
