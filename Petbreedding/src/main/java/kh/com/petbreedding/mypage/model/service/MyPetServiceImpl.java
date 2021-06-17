package kh.com.petbreedding.mypage.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.com.petbreedding.mypage.model.dao.MyPetDao;
import kh.com.petbreedding.mypage.model.vo.MyPet;

@Service("myPetService")
public class MyPetServiceImpl implements MyPetService{

	@Autowired
	private MyPetDao mypetDao;

	@Override
	public MyPet selectPetInfo(String pet_num) {
		return null;
	}

	@Override
	public void insertPetInfo(MyPet mypet) {
		System.out.println("mypet service들어옴");
		try {
		mypetDao.insertPetInfo(mypet);
		System.out.println("mypet service db 갔다옴");
		}catch (Exception e) {
			e.printStackTrace();
		}
		}

	@Override
	public void updatePetInfo(MyPet pet_info) {
		
	}

	@Override
	public void deletePetInfo(MyPet pet_info) {
		
	}
	

}
