package kh.com.petbreedding.cta.controller;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*import com.siot.IamportRestClient.response.Payment;*/



import kh.com.petbreedding.cta.model.service.CtaService;
import kh.com.petbreedding.cta.model.vo.Cta;
import kh.com.petbreedding.cta.model.vo.CtaPay;

@Controller
@RequestMapping("/cta/*")
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
	//울트라콜 페이지 조회
	@RequestMapping(value="ctapay", method = RequestMethod.GET)
	public ModelAndView ctapay(
			@RequestParam String CM_TYPE,
			HttpSession session
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("bPartner/bSales/ctaPay");
		mav.addObject("vo", ctaService.read(CM_TYPE));
		return mav;
	}
	//ajax로 결제정보 저장
	@RequestMapping(value="ctapaydata", method = RequestMethod.POST)
	public String ctapaydata(
			CtaPay pay,
			 HttpServletResponse response,
			 HttpServletRequest request
			) throws Exception {
		int result = 0;
		int result2=0;
		int result3=0;
		try {
			result = ctaService.insertpay(pay);
			System.out.println(result);
			if(result==0) {
				result2 = ctaService.insertCta(pay);
				System.out.println("ctapay ctrl들어옴");
			}else if(result > 0) {
				//TODO
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping(value="insertmycta", method = RequestMethod.POST)
	public String updatemycta(
			CtaPay pay,
			 HttpServletResponse response,
			 HttpServletRequest request
			) throws Exception {
		int result = 0;
		try {
			if(pay.getBP_ID() == null) {
			result = ctaService.insertCta(pay);
			System.out.println("mycta ctrl들어옴");
			}else {
				System.out.println("아이디있음");
			}
			}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
