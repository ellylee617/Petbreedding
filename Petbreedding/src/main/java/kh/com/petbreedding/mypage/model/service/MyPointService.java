package kh.com.petbreedding.mypage.model.service;

import java.util.List;

import kh.com.petbreedding.mypage.model.vo.MyPoint;

public interface MyPointService {
	public List<MyPoint> myPointSelectList(MyPoint myPoint); // 포인트 조회
	
	public int CurrPointSelectOne(String clNum); // 현재 포인트 조회
	
	public int myPointUpdate(MyPoint myPoint);//포인트 사용
}
