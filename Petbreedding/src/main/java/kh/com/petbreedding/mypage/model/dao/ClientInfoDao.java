package kh.com.petbreedding.mypage.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.client.model.vo.Client;

@Repository("clientInfoDao")
public class ClientInfoDao {
	
	@Autowired
	SqlSession sqlSession;
	
	// 회원 정보 수정 
	public int updateClientInfo(Client client) {
		return sqlSession.update("Modify.modifyClient", client);
	} 
	
	//예약확인/조회 리스트
	public List<HairShopReservation> myReservationList(String cl_num) {
		return sqlSession.selectList("myRev.myRevList", cl_num);
	}
	
	//예약확인/조회 날짜 검색 리스트
	public List<HairShopReservation> myRevDateList(HairShopReservation hsr) {
		return sqlSession.selectList("myRev.myRevListDate", hsr);
	}
	
	//결제대기 상태 카운트
	public int status0(String cl_num) {
		return sqlSession.selectOne("myRev.status0", cl_num);
	}
	
	//결제완료 상태 카운트
	public int status1(String cl_num) {
		return sqlSession.selectOne("myRev.status1", cl_num);
	}
	
	//이용완료 상태 카운트
	public int status2(String cl_num) {
		return sqlSession.selectOne("myRev.status2", cl_num);
	}
	
	//예약확인 상세조회
	public List<HairShopReservation> myRevDetail(String har_rnum){
		return sqlSession.selectList("myRev.myRevDetail", har_rnum);
	}
	
	
}
