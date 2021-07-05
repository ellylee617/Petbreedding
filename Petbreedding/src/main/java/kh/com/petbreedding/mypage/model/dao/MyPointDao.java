package kh.com.petbreedding.mypage.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.mypage.model.vo.MyPoint;

@Repository("myPointDao")
public class MyPointDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//	포인트 조회
	public List<MyPoint> myPointSelectList(MyPoint myPoint) {
		return sqlSession.selectList("MyPoint.myPointSelectList", myPoint);
	}
	
	public int CurrPointSelectOne(String clNum) {
		return sqlSession.selectOne("MyPoint.CurrPointSelectOne", clNum);
	}
	
	public int myPointInsert(MyPoint myPoint) {
		return sqlSession.insert("MyPoint.myPointInsert", myPoint);
	}
	
	public int myPointUpdate(MyPoint myPoint) {
		return sqlSession.insert("MyPoint.myPointUpdate", myPoint);
	}
	
	
}
