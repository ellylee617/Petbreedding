package kh.com.petbreedding.mypage.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.mypage.model.vo.MyPet;

@Repository("mypetDao")
public class MyPetDaoImpl implements MyPetDao {
 @Autowired
 private SqlSession sqlSession;

@Override
public List<MyPet> selectPetInfo() {
	return sqlSession.selectList("pet.petlist");
}

@Override
public void insertPetInfo(MyPet mypet) {
	 sqlSession.insert("pet.insertMyPet", mypet);
}

@Override
public List<MyPet> eachPetInfo(String cl_num) {
	return sqlSession.selectList("pet.eachpet", cl_num);
}


//@Override
//public void updatePetInfo(MyPet pet_info) {
//	// TODO Auto-generated method stub
//	
//}
//
//@Override
//public void deletePetInfo(String pet_num) {
//	// TODO Auto-generated method stub
//	
//}
 
 
}
