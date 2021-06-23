package kh.com.petbreedding.Shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Shop.model.dao.ReservationDao;
import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.mypage.model.vo.MyPet;

@Service("revService")
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDao revDao;
	
	@Override
	public List<Style> revList(String har_num) {
		List<Style> result = null;
		try {
			result = revDao.revList(har_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<MyPet> revList2(String cl_num) {
		List<MyPet> result = null;
		try {
			result = revDao.revList2(cl_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Style> revList3(String har_num) {
		List<Style> result = null;
		try {
			result = revDao.revList3(har_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertHairRev(HairShopReservation hrv) {
		int result = -1;
		try {
			result = revDao.insertHairRev(hrv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<HairShopReservation> shopPayment(String har_rnum) {
		List<HairShopReservation> result = null;
		try {
			result = revDao.shopPayment(har_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
