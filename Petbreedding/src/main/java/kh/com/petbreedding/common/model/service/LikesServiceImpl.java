package kh.com.petbreedding.common.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.common.model.dao.LikesDao;


@Service("likesService")
public class LikesServiceImpl implements LikesService{

	@Autowired
	private LikesDao likesDao;
	
	
	@Override
	public String addLikes(String like_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelLikes(String like_num) {
		// TODO Auto-generated method stub
		
	}
	

}
