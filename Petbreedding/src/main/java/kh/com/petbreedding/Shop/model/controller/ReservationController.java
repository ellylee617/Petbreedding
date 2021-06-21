package kh.com.petbreedding.Shop.model.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.petbreedding.Shop.model.service.ReservationService;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.mypage.model.vo.MyPet;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService revService;
	
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

}
