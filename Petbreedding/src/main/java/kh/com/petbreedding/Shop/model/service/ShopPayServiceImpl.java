package kh.com.petbreedding.Shop.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Shop.model.dao.ShopPayDao;
import kh.com.petbreedding.Shop.model.vo.HarPay;
import kh.com.petbreedding.Shop.model.vo.HosPay;


@Service("shopPayService")
public class ShopPayServiceImpl implements ShopPayService{

	
	@Autowired
	private ShopPayDao shopPayDao;
	
	@Override
	public int harPay(HarPay harPay) {
		int result = -1;
		try {
			result = shopPayDao.harPay(harPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int harRevUp(String har_rnum) {
		int result = -1;
		try {
			result = shopPayDao.harRevUp(har_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int hosPay(HosPay hosPay) {
		int result = -1;
		try {
			result = shopPayDao.hosPay(hosPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int hosRevUp(String hos_rnum) {
		int result = -1;
		try {
			result = shopPayDao.hosRevUp(hos_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



}
