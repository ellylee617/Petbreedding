package kh.com.petbreedding.mypage.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.mypage.model.dao.MyPointDao;
import kh.com.petbreedding.mypage.model.vo.MyPoint;

@Service("myPointService")
public class MyPointServiceImpl implements MyPointService {
	
	@Autowired
	private MyPointDao myPointDao;

	//	포인트 조회
	@Override
	public List<MyPoint> myPointSelectList(MyPoint myPoint) {
		List<MyPoint> myPointList = null;
		
		try {
			myPointList = myPointDao.myPointSelectList(myPoint);
		} catch(Exception e) {
			
		}
		return myPointList;
	}

	@Override
	public String CurrPointSelectOne(String clNum) {
		String result = null;
		System.out.println("[세훈] 보유 포인트 서비스 clNum : " + clNum);
		
		try {
			result = myPointDao.CurrPointSelectOne(clNum);
			System.out.println("[세훈] 보유 포인트 서비스 리턴 이후 result : " + result);
		} catch(Exception e) {
			
		}
		
		return result;
	}
	

}
