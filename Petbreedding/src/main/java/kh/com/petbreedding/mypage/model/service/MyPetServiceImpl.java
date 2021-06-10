package kh.com.petbreedding.mypage.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.com.petbreedding.mypage.model.dao.MyPetDao;
import kh.com.petbreedding.mypage.model.vo.MyPet;

@Service("myPetService")
public class MyPetServiceImpl implements MyPetService{

	@Autowired
	private MyPetDao myPetDao;
	
	@Override
	public MyPet selectPetInfo(String pet_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertPetInfo(MyPet pet_info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertPetIMG(String pet_img, MultipartHttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePetIMG(String pet_img) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePetInfo(MyPet pet_info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePetInfo(MyPet pet_info) {
		// TODO Auto-generated method stub
		
	}

}
