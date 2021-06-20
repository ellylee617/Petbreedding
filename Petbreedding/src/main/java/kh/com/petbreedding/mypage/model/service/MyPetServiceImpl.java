package kh.com.petbreedding.mypage.model.service;


import java.util.List;

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
	public List<MyPet> eachPetInfo(String cl_num) {
		System.out.println("개별 mypet service들어옴");
		List<MyPet> list = null;
		try {
			list = mypetDao.eachPetInfo(cl_num);
			if(list != null) {
				System.out.println("mypet info 있음");
			}else {
				System.out.println("mypet info 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	@Override
	public List<MyPet> selectPetInfo() {
		System.out.println("mypet service list 들어옴");
		List<MyPet> list = null;
		try {
			list = mypetDao.selectPetInfo();
			System.out.println("select db 갔다옴");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
//	@Override
//	public void updatePetInfo(MyPet pet_info) {
//		
//	}
//
//	@Override
//	public void deletePetInfo(MyPet pet_info) {
//		
//	}


}
