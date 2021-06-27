package kh.com.petbreedding.Shop.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.Shop.model.vo.HarPay;

@Repository("shopPayDao")
public class ShopPayDao {

	@Autowired
	private SqlSession sqlSession;
	
	
//	미용실 결제 테이블 저장
	public int harPay(HarPay harPay) {
		return sqlSession.insert("shopPay.harPay", harPay);
	}

//	미용실 예약 상태 변경
	public int harRevUp(String har_rnum) {
		return sqlSession.update("shopPay.harRevUp", har_rnum);
	}
	
}
