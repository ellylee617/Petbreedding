package kh.com.petbreedding.Shop.model.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.petbreedding.Shop.model.service.ReservationService;
import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.mypage.model.service.ClientInfoService;
import kh.com.petbreedding.mypage.model.vo.MyPet;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService revService;
	
	@Autowired
	private ClientInfoService clientInfoService;
	
	//미용실 예약하기
	@RequestMapping(value = "shopReservation", method = RequestMethod.GET)
	public String revList(Locale locale, String har_num, Model model, String cl_num) {

		List<Style> list = revService.revList(har_num);
		List<MyPet> list2 = revService.revList2(cl_num);
		List<Style> list3 = revService.revList3(har_num);
		model.addAttribute("style", list);
		model.addAttribute("pet", list2);
		model.addAttribute("style2", list3);
		
		return "/user/uShop/salonReservation";
	}
	
	//미용실 예약 처리
	@RequestMapping(value="doReservation")
	@ResponseBody
	public String insertHairRev(HairShopReservation hrv) {
		
		revService.insertHairRev(hrv);
		String result = hrv.getHar_rnum();

		return result;
	}
	
	//미용실 결제화면
	@RequestMapping(value = "/shopPayment", method = RequestMethod.GET)
	public String shopPayment(String har_rnum, Model model) {
		
		List<HairShopReservation> list = revService.shopPayment(har_rnum);
		String result2 = clientInfoService.anotherMenu(har_rnum);
		int getPrice = clientInfoService.getPrice(har_rnum);
			
		model.addAttribute("myRev", list);
		model.addAttribute("another", result2);
		model.addAttribute("totalPrice", getPrice);
		
		return "/user/uShop/shopPayment";
	}
	
	//미용실 시간체크
	@RequestMapping(value="checkTime")
	@ResponseBody
	public List<String> checkTime(HairShopReservation hrv) {
		
		List<String> list = revService.checkTime(hrv);

		return list;
	}
	
	/*************  병원  **************/
	//동물병원 결제화면
	@RequestMapping(value = "/shopHosPayment", method = RequestMethod.GET)
	public String shopHosPayment(String hos_rnum, Model model) {
		
		List<HospitalReservation> list = revService.shopPayment2(hos_rnum);
		model.addAttribute("myRev", list);
		
		return "/user/uShop/HosPayment";
	}
	
	
	//병원 예약하기
	@RequestMapping(value = "shopHosReservation", method = RequestMethod.GET)
	public String revHosList(Locale locale,  Model model, String cl_num) {

		List<MyPet> list2 = revService.revList2(cl_num);
		model.addAttribute("pet", list2);
		
		return "/user/uShop/hosReservation";
	}
	
	
	
	//병원 예약 처리
	@RequestMapping(value="doHosReservation")
	@ResponseBody
	public String insertHosRev(HospitalReservation hos) {
		
		revService.insertHosRev(hos);
		String result = hos.getHos_rnum();
		return result;
	}
	
	/*
	 * //미용실 결제화면
	 * 
	 * @RequestMapping(value = "/shopHosPayment", method = RequestMethod.GET) public
	 * String shopHosPayment(String hos_rnum, Model model) {
	 * 
	 * List<HairShopReservation> list = revService.shopPayment(har_rnum); String
	 * result2 = clientInfoService.anotherMenu(har_rnum); int getPrice =
	 * clientInfoService.getPrice(har_rnum);
	 * 
	 * model.addAttribute("myRev", list); model.addAttribute("another", result2);
	 * model.addAttribute("totalPrice", getPrice);
	 * 
	 * return "/user/uShop/shopPayment"; }
	 */
	
	//병원 시간체크
	@RequestMapping(value="checkTime2")
	@ResponseBody
	public List<String> checkTime2(HospitalReservation hos) {
		
		List<String> list = revService.checkTime2(hos);

		return list;
	}
}
