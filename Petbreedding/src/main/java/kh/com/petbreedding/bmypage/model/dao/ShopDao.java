package kh.com.petbreedding.bmypage.model.dao;

import java.util.HashMap;
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
import kh.com.petbreedding.bmypage.model.vo.Style;

@Repository("shopDao")
public class ShopDao {

	@Autowired
	private SqlSession sqlSession;
	

	// 사업장 등록 - BP 테이블에서 사업장 등록여부 상태 1로 바꾸기
	public int updateBpReg(String bpId) {
		System.out.println(" !! ShopDao - updateBpReg() 실행 !!");
		return sqlSession.insert("Shop.updateBpReg", bpId);
	}

	
	/* 
	 * 미용실
	 * 
	 * 
	 * */
	
	
	// 미용실 전체 리스트 조회 (shopController)
	public List<HairSalon> selectHarList(int currentPage, int limit) {
		System.out.println("다오 진입");
		int startRow = (currentPage -1) * limit;
		RowBounds row = new RowBounds(startRow, limit);
		System.out.println("다오 끝");
		return sqlSession.selectList("Shop.selectHarList", null, row);
	}
	
	//	TODO
	//	미용실 리스트 : 최신순
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
	
	// 미용실 이미지 리스트 불러오기
	public List<HairSalonImg> selectHarImgList(String harNum){
		System.out.println(" !! ShopDao - selectHarImgList() 실행 !!");
		return  sqlSession.selectList("Shop.selectHarImgList", harNum);
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
	
	// 미용실 주메뉴 추가
	public int insertStyleMAinMenu(Style vo) {
		System.out.println(" !! ShopDao - insertStyleMAinMenu() 실행 !!");
		vo.toString();
		return sqlSession.insert("ShopMenu.insertStyleMAinMenu", vo);
	}
	
	// 미용실 서브메뉴 추가
	public int insertStyleSubMenu(Style vo) {
		System.out.println(" !! ShopDao - insertStyleSubMenu() 실행 !!");
		vo.toString();
		return sqlSession.insert("ShopMenu.insertStyleSubMenu", vo);
	}
	
	// 등록한 미용실 메뉴(메인+서브) 조회
	public List<Style> selectStyleList(String harNum){
		System.out.println(" !! ShopDao - selectStyleList() 실행 !!");
		System.out.println("조회할 미용실 번호"+harNum);
		return sqlSession.selectList("ShopMenu.selectStyleList", harNum);
	}
	
	// 미용실 메뉴 수정
	public int updateStyle(Style vo) {
		System.out.println(" !! ShopDao - updateStyle() 실행 !!");
		System.out.println("수정할 미용실 정보::"+vo);
		return sqlSession.update("ShopMenu.updateStyle", vo);
	}
	
	// 미용실 메뉴 삭제
	public int deleteStyle(String styleNum) {
		System.out.println(" !! ShopDao - deleteStyle() 실행 !!");
		System.out.println("삭제할 스타일 번호:"+styleNum);
		return sqlSession.delete("ShopMenu.deleteStyle", styleNum);		
	}
	
	
	/* 
	 * 동물병원
	 * 
	 * 
	 * */
	
	
	// 동물병원 전체 리스트 조회 (shopController)
	public List<Hospital> selectHosList(int currentPage, int limit) {
		System.out.println("DAO 진입");
		int startRow = (currentPage -1) * limit;
		RowBounds row = new RowBounds(startRow, limit);
		System.out.println("DAO 끝");
		return sqlSession.selectList("Shop.selectHosList", null, row);
	}
	
	//	TODO
	//	동물병원 리스트 : 최신순
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
	
	// 동물병원 이미지 리스트 불러오기
	// TODO
	
	
	
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
