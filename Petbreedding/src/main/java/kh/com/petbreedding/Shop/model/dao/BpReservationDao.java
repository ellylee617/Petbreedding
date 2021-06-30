package kh.com.petbreedding.Shop.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.bmypage.model.vo.Style;

@Repository("bprevDao")
public class BpReservationDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<HairShopReservation> revList() {
		return sqlSession.selectList("bprev.hartRavList");
	}
}
