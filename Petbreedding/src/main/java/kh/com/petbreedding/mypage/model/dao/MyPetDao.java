package kh.com.petbreedding.mypage.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.mypage.model.vo.MyPet;

@Repository("myPetDao")
public class MyPetDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 반려동물 정보 보기
	public MyPet selectPetInfo(String pet_num) {
		
		// TODO Auto-generated method stub
		return null;
		
	}
	
	// 반려동물 정보 등록
	public void insertPetInfo(MyPet pet_info) {
		
		// TODO Auto-generated method stub
	} 
	
	// 반려동물 정보 등록 - 이미지 파일 추가
	public String insertPetIMG(String pet_img) {
		
		// TODO Auto-generated method stub
		return pet_img;
	}
	
	// 반려동물 정보 등록 - 이미지 파일 삭제
	public void deletePetIMG(String pet_img) {
		
		// TODO Auto-generated method stub
	} 
	
	// 반려동물 정보 수정
	public void updatePetInfo(MyPet pet_info) {
		
		// TODO Auto-generated method stub
	}
	
	// 반려동물 정보 삭제
	public void deletePetInfo(String pet_num) {
	
		// TODO Auto-generated method stub
	}
}
