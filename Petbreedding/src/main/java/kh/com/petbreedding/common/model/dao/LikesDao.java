package kh.com.petbreedding.common.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.common.model.vo.Likes;

@Repository("likesDao")
public class LikesDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insertLikes(Likes likes) {
		//TODO
	}
	
	public void delLikes(String like_num) {
		//TODO
	}
	
}
