package kh.com.petbreedding.Admin.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.BP.model.vo.BPartner;


@Repository("aDao")
public class AdminDao {
	
	@Autowired
	SqlSession sqlSession;
	
//	제휴승인대기 목록 조회
	public List<BPartner> waitList() {
		return sqlSession.selectList("mWait.selectMwait");
	}
	
	//제휴승인 대기 승인
	public int confirmBP(List<String> list){
		return sqlSession.update("mWait.confirmBP", list);
	}
	
	//제휴승인 대기 거절
	public int refuseBP(List<String> list){
		return sqlSession.delete("mWait.refuseBP", list);
	}
}
