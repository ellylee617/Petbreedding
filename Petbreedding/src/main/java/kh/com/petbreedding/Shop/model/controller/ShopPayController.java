package kh.com.petbreedding.Shop.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.petbreedding.Shop.model.service.ShopPayService;
import kh.com.petbreedding.Shop.model.vo.HarPay;
import kh.com.petbreedding.Shop.model.vo.HosPay;

@Controller
public class ShopPayController {

	@Autowired
	private ShopPayService shopPayService;
	
	@RequestMapping("harPay")
	@ResponseBody
	public int harPay(HarPay harPay) {
		
		int result = shopPayService.harPay(harPay);
		
		return result;
	}
	
	@RequestMapping("harRevUp")
	@ResponseBody
	public int harRevUp(String har_rnum) {
		int result = shopPayService.harRevUp(har_rnum);
		return result;
	}
	
	@RequestMapping("hosPay")
	@ResponseBody
	public int hosPay(HosPay hosPay) {
		
		int result = shopPayService.hosPay(hosPay);
		return result;
	}
	
	@RequestMapping("hosRevUp")
	@ResponseBody
	public int hosRevUp(String hos_rnum) {
		int result = shopPayService.hosRevUp(hos_rnum);
		return result;
	}
}
