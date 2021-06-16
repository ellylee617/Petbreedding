package kh.com.petbreedding.cta.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.cta.model.service.CtaService;
import kh.com.petbreedding.cta.model.vo.Cta;

@Controller
public class CtaController {
	
	@Autowired
	private CtaService ctaService;
	
	
	//울트라콜 페이지 조회
	@RequestMapping("cta")
	public ModelAndView ctalist() throws Exception {
		System.out.println("ctrl들어옴");
		List<Cta> list = ctaService.listAll();
		System.out.println("db갔다옴");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bPartner/bSales/cta");
		mav.addObject("list", list);
		return mav;
	}
	
}
