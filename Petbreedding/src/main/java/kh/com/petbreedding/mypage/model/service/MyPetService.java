package kh.com.petbreedding.mypage.model.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.com.petbreedding.mypage.model.vo.MyPet;

public interface MyPetService {
	
	MyPet selectPetInfo(String pet_num);  // 반려동물 정보 보기
	void insertPetInfo(MyPet pet_info);	// 반려동물 등록
	void insertPetIMG(String pet_img, MultipartHttpServletRequest request); // 반려동물 정보 등록 - 이미지 파일 추가
	void deletePetIMG(String pet_img); // 반려동물 정보 등록 - 이미지 파일 삭제
	void updatePetInfo(MyPet pet_info); // 반려동물 정보 수정
	void deletePetInfo(MyPet pet_info); // 반려동물 정보 삭제
}
