package kh.com.petbreedding.bmypage.model.service;

import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.HairSalonImg;

public interface ShopService {
	
	public int insertHarInfo(HairSalon vo);	// 미용실 기본 정보 입력 
	public int insertHarImg(HairSalonImg vo); // 미용실 이미지 첨부
}
