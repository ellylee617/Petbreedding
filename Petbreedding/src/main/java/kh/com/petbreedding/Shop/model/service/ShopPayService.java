package kh.com.petbreedding.Shop.model.service;

import kh.com.petbreedding.Shop.model.vo.HarPay;
import kh.com.petbreedding.Shop.model.vo.HosPay;

public interface ShopPayService {
	
	public int harPay(HarPay harPay);
	public int harRevUp(String har_rnum);
	
	public int hosPay(HosPay hosPay);
	public int hosRevUp(String hos_rnum);
}
