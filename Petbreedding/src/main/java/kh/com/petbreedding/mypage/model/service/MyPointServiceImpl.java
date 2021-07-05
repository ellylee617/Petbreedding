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
			e.printStackTrace();
		}
		return myPointList;
	}

	
	//현재 포인트 조회
	@Override
	public int CurrPointSelectOne(String clNum) {
		int result = -1;
		try {
			result = myPointDao.CurrPointSelectOne(clNum);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	//현재 포인트 사용
	@Override
	public int myPointUpdate(MyPoint myPoint) {
		int result = -1;
		try {
			result = myPointDao.myPointUpdate(myPoint);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	

}
