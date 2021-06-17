package kh.com.petbreedding.mypage.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.mypage.model.vo.MyPet;

public interface MyPetDao {
	

	// 반려동물 정보 보기
	public MyPet selectPetInfo(String pet_num);
	
	// 반려동물 정보 등록
	public void insertPetInfo(MyPet mypet);
	
	
	// 반려동물 정보 수정
	public void updatePetInfo(MyPet pet_info);
	
	// 반려동물 정보 삭제
	public void deletePetInfo(String pet_num);
}
