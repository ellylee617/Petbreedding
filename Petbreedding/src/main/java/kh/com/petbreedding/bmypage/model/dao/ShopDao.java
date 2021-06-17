package kh.com.petbreedding.bmypage.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.bmypage.model.vo.HairSalon;

@Repository("shopDao")
public class ShopDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 미용실 기본 회원정보 입력 
	public int insertHarInfo(HairSalon vo) {
		
		System.out.println(" ShopDao - insertHarInfo() 실행");
		return sqlSession.insert("Shop.insertHarInfo", vo);
		
	}
	
	// TODO: 미용실 이미지 정보 입력 
	
}
