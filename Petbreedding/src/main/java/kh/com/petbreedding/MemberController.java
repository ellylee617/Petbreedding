package kh.com.petbreedding;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String shopList(Locale locale, Model model) {
		return "/member/login";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String shopPage(Locale locale, Model model) {
		return "/member/join";
	}
}
