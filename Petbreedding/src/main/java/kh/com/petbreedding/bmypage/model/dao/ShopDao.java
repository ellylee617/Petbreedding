package kh.com.petbreedding.bmypage.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.bmypage.model.vo.HairDayOff;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.HairSalonImg;
import kh.com.petbreedding.bmypage.model.vo.HosDayOff;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.HospitalImg;

@Repository("shopDao")
public class ShopDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 미용실 기본 정보 입력 
	public int insertHarInfo(HairSalon vo) {
		
		System.out.println(" !! ShopDao - insertHarInfo() 실행 !!");
		return sqlSession.insert("Shop.insertHarInfo", vo);
		
	}
	
	// 미용실 주휴일 입력
	public int insertHarDayOff(HairDayOff vo) {
		System.out.println(" !! ShopDao - insertHarDayOff() 실행 !!");
		return sqlSession.insert("Shop.insertHarDayOff", vo);
	}
	
	//미용실 이미지 첨부
	public int insertHarImg(HairSalonImg vo) {
		
		System.out.println(" !! ShopDao - insertHarImg() 실행 !!");
		return  sqlSession.insert("Shop.insertHarImg", vo);
	}
	
	// 동물병원 기본 정보 입력
	public int insertHosInfo(Hospital vo) {
		
		System.out.println(" !! ShopDao - insertHosInfo() 실행 !!");
		return sqlSession.insert("Shop.insertHosInfo", vo);
		
	}
	
	// 동물병원 주휴일 입력
	public int insertHosDayOff(HosDayOff vo) {
		System.out.println(" !! ShopDao - insertHosDayOff() 실행 !!");
		return sqlSession.insert("Shop.insertHosDayOff", vo);
	}
	
	
	// 동물병원 이미지 첨부
	public int insertHosImg(HospitalImg vo) {
		
		System.out.println(" !! ShopDao - insertHarImg() 실행 !!");
		return  sqlSession.insert("Shop.insertHosImg", vo);
	}	
	
}
