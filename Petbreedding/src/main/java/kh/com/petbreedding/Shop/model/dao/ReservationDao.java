package kh.com.petbreedding.Shop.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.mypage.model.vo.MyPet;

@Repository("revDao")
public class ReservationDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public List<Style> revList(String har_num) {
		return sqlSession.selectList("ShopRev.revPage", har_num);
	}
	
	public List<MyPet> revList2(String cl_num) {
		return sqlSession.selectList("ShopRev.revPage2", cl_num);
	}
	
	public List<Style> revList3(String har_num) {
		return sqlSession.selectList("ShopRev.revPage3", har_num);
	}
	
	public int insertHairRev(HairShopReservation hrv) {
		return sqlSession.insert("ShopRev.insertHairRev", hrv);
	}
	
	public List<HairShopReservation> shopPayment(String har_rnum){
		return sqlSession.selectList("shopPay.myRevPay", har_rnum);
	}	
	
}
