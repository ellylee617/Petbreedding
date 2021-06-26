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
		System.out.println("[세훈] 보유 포인트 다오 진입");
		System.out.println("[세훈] 보유 포인트 다오 clNum : " + clNum);
		return sqlSession.selectOne("MyPoint.CurrPointSelectOne", clNum);
	}
	
	public int myPointInsert(MyPoint myPoint) {
		System.out.println("[세훈] 인서트 포인트 다오 myPoint : " + myPoint.toString());
		return sqlSession.insert("MyPoint.myPointInsert", myPoint);
	}
}
