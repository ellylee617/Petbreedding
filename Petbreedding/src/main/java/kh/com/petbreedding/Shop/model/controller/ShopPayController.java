package kh.com.petbreedding.Shop.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.petbreedding.Shop.model.service.ShopPayService;
import kh.com.petbreedding.Shop.model.vo.HarPay;

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
	
}
