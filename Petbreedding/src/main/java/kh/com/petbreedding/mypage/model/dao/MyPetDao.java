package kh.com.petbreedding.mypage.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.mypage.model.vo.MyPet;

public interface MyPetDao {
	

	// 반려동물 정보 보기
	public List<MyPet> selectPetInfo();
	
	// 반려동물 정보 등록
	public void insertPetInfo(MyPet mypet);
	
	//아이디에 해당하는 반려동물 정보 보기
	public List<MyPet> eachPetInfo(String cl_num);
	
	
//	// 반려동물 정보 수정
//	public void updatePetInfo(MyPet pet_info);
//	
//	// 반려동물 정보 삭제
//	public void deletePetInfo(String pet_num);
}
