package kh.com.petbreedding.Shop.model.service;

import kh.com.petbreedding.Shop.model.vo.HarPay;

public interface ShopPayService {
	
	public int harPay(HarPay harPay);
	public int harRevUp(String har_rnum);
	
}
