package kh.com.petbreedding.mypage.model.service;

import java.util.List;

import kh.com.petbreedding.mypage.model.vo.MyPoint;

public interface MyPointService {
	public List<MyPoint> myPointSelectList(MyPoint myPoint); // 포인트 조회
}
