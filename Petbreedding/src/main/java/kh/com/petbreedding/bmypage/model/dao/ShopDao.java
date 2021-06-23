package kh.com.petbreedding.bmypage.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.BP.model.vo.BPartner;
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
	
	// 미용실 전체 리스트 조회 (shopController)
	public List<HairSalon> selectHarList(int currentPage, int limit) {
		System.out.println("다오 진입");
		int startRow = (currentPage -1) * limit;
		RowBounds row = new RowBounds(startRow, limit);
		System.out.println("다오 끝");
		return sqlSession.selectList("Shop.selectHarList", null, row);
	}
	
	//	TODO
	//	미용실 리스트 : 인기순
	//	미용실 리스트 : 거리순
	//	미용실 리스트 : 별점순	
	
	
	// 미용실 기본 정보 입력 
	public int insertHarInfo(HairSalon vo) {
		
		System.out.println(" !! ShopDao - insertHarInfo() 실행 !!");
		return sqlSession.insert("Shop.insertHarInfo", vo);
		
	}
	
	// 미용실 기본 정보 불러오기
	public HairSalon selectHarInfo(String bpId) {
		
		System.out.println(" !! ShopDao - selectHarInfo() 실행 !!");
		System.out.println("bp id:"+bpId);
		
		return sqlSession.selectOne("Shop.selectHarInfo", bpId);
		
		
	}
	
	// 미용실 기본 정보 수정
	public int updateHarInfo(HairSalon vo) {
		System.out.println(" !! ShopDao - updateHarInfo() 실행 !!");
		return sqlSession.insert("Shop.updateHarInfo", vo);
	}
	
	
	//미용실 이미지 첨부
	public int insertHarImg(HairSalonImg vo) {
		System.out.println(" !! ShopDao - insertHarImg() 실행 !!");
		return  sqlSession.insert("Shop.insertHarImg", vo);
	}
	
	// 미용실 이미지 수정 (삭제)
	public int deleteHarImg(String harNum) {
		System.out.println(" !! ShopDao - deleteHarImg() 실행 !!");
		return  sqlSession.insert("Shop.deleteHarImg", harNum);
	}
	
	// 수정된 미용실 이미지 첨부
	public int insertNewHarImg(HairSalonImg vo) {
		System.out.println(" !! ShopDao - insertHarImg() 실행 !!");
		return  sqlSession.insert("Shop.insertNewHarImg", vo);
	}	
	
	// 미용실 주휴일 입력
	public int insertHarDayOff(HairDayOff vo) {
		System.out.println(" !! ShopDao - insertHarDayOff() 실행 !!");
		return sqlSession.insert("Shop.insertHarDayOff", vo);
	}
	
	// 미용실 주휴일 수정 (삭제)
	public int deleteHarDayOff(String harNum) {
		System.out.println(" !! ShopDao - deleteHarDayOff() 실행 !!");
		return sqlSession.insert("Shop.deleteHarDayOff", harNum);		
	}
	
	// 수정된 미용실 주휴일 추가
	public int insertNewHarDayOff(HairDayOff vo) {
		System.out.println(" !! ShopDao - insertNewHarDayOff() 실행 !!");
		vo.toString();
		return sqlSession.insert("Shop.insertNewHarDayOff", vo);	
	}
	
	
	
	
	
	
	// 동물병원 전체 리스트 조회 (shopController)
	public List<Hospital> selectHosList(int currentPage, int limit) {
		System.out.println("DAO 진입");
		int startRow = (currentPage -1) * limit;
		RowBounds row = new RowBounds(startRow, limit);
		System.out.println("DAO 끝");
		return sqlSession.selectList("Shop.selectHosList", null, row);
	}
	
	//	TODO
	//	동물병원 리스트 : 인기순
	//	동물병원 리스트 : 거리순
	//	동물병원 리스트 : 별점순	
	
	
	
	
	// 동물병원 기본 정보 입력
	public int insertHosInfo(Hospital vo) {
		
		System.out.println(" !! ShopDao - insertHosInfo() 실행 !!");
		return sqlSession.insert("Shop.insertHosInfo", vo);
		
	}
	
	// 동물병원 기본 정보 불러오기
	public Hospital selectHosInfo(String bpId){

		System.out.println(" !! ShopDao - selectHosInfo() 실행 !!");
		System.out.println("bp id:"+bpId);
		
		return sqlSession.selectOne("Shop.selectHosInfo", bpId);
		
	}
	
	// 동물병원 기본 정보 수정
	public int updateHosInfo(Hospital vo) {
		System.out.println(" !! ShopDao - updateHosInfo() 실행 !!");
		return sqlSession.insert("Shop.updateHosInfo", vo);		
	}
	

	
	// 동물병원 이미지 첨부
	public int insertHosImg(HospitalImg vo) {
		
		System.out.println(" !! ShopDao - insertHarImg() 실행 !!");
		return  sqlSession.insert("Shop.insertHosImg", vo);
	}	
	// 동물병원 이미지 수정 (삭제) 
	public int deleteHosImg(String hosNum) {
		
		System.out.println(" !! ShopDao - deleteHosImg() 실행 !!");
		return  sqlSession.insert("Shop.deleteHosImg", hosNum);
	}
	
	// 수정된 동물병원 이미지 추가
	public int insertNewHosImg(HospitalImg vo) {
		System.out.println(" !! ShopDao - insertNewHosImg() 실행 !!");
		return  sqlSession.insert("Shop.insertNewHosImg", vo);
	}	
	
	// 동물병원 주휴일 입력
	public int insertHosDayOff(HosDayOff vo) {
		System.out.println(" !! ShopDao - insertHosDayOff() 실행 !!");
		return sqlSession.insert("Shop.insertHosDayOff", vo);
	}
	
	// 동물병원 주휴일 수정 (삭제)
	public int deleteHosDayOff(String hosNum) {
		System.out.println(" !! ShopDao - deleteHosDayOff() 실행 !!");
		return sqlSession.insert("Shop.deleteHosDayOff", hosNum);
	}
	
	// 수정된 동물병원 주휴일 추가
	public int insertNewHosDayOff(HosDayOff vo) {
		System.out.println(" !! ShopDao - insertNewHosDayOff() 실행 !!");
		return  sqlSession.insert("Shop.insertNewHosDayOff", vo);
	}		
	

}
