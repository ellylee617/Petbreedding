package kh.com.petbreedding.common.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.scribejava.core.model.OAuth2AccessToken;

import kh.com.petbreedding.HomeController;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.service.LoginService;
import kh.com.petbreedding.common.model.vo.NaverLogin;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	/* NaverLoginBO */
	private NaverLogin naverLogin;
	private String apiResult = null;
	
	@Autowired
	private void setNaverLogin(NaverLogin naverLogin) {
		this.naverLogin = naverLogin;
	}

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//  로그인 페이지로 이동
	@RequestMapping(value = "/uLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String openLogin(Locale locale, Model model, HttpSession session) {
		
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLogin클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLogin.getAuthorizationUrl(session);
		
		System.out.println("네이버:" + naverAuthUrl);
		
		//네이버
		model.addAttribute("url", naverAuthUrl);

		return "/user/uMember/uLogin";
	}
	
	//  사장님로그인 페이지로 이동
	@RequestMapping(value = "/bLogin", method = RequestMethod.GET)
	public String openbLogin(Locale locale, Model model) {
		
		// TODO Auto-generated method stub
		return "/bPartner/bMember/bLogin";
	}
	
	//관리자 로그인 페이지로 이동
	@RequestMapping(value = "/mLogin", method = RequestMethod.GET)
	public String openmLogin(Locale locale, Model model) {
		
		// TODO Auto-generated method stub
		return "/admin/aMember/mLogin";
	}
	
	// 유저 로그인 처리
	@RequestMapping( value="/member/doLoginU", method = RequestMethod.POST)
	@ResponseBody
	public String doLoginU(Client client, HttpSession session ,HttpServletRequest req,HttpServletResponse res, RedirectAttributes rttr) {

		Client result = loginService.login(client);
		session = req.getSession();

		if(result == null) {
			System.out.println("로그인 실패");
			session.setAttribute("client", null);
			return "/uLogin";
			
		}else {
			System.out.println("로그인 성공!");
			session.setAttribute("client", result);
			return "/";
		}	
	}
	
	
	// 사업자 로그인 처리
	@RequestMapping("/member/doLoginB")
	public String doLoginB(Client client, HttpSession session ,HttpServletResponse response) {
		
		// TODO Auto-generated method stub
		return null;
		
	}
	
	
	// 카카오 로그인
	@RequestMapping(value = "kakaoLogin", method = RequestMethod.POST)
	public String kakaoLogin(HttpServletRequest request, @RequestBody Map<String, Object> param) {
		
		// TODO Auto-generated method stub
		return null;
		
	}
	
	
	//네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException {
		
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLogin.getAccessToken(session, code, state);
		
		//1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLogin.getUserProfile(oauthToken); //String형식의 json데이터
		System.out.println("apiResult : "+ apiResult);
		/** apiResult json 구조
		{"resultcode":"00",
		"message":"success",
		"response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		**/
		
		//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		
		//3. 데이터 파싱
		//Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		
		//response의 nickname값 파싱
		/*
		 * String nickname = (String)response_obj.get("nickname");
		 * System.out.println(nickname);
		 */
		
		//4.파싱 닉네임 세션으로 저장
		session.setAttribute("client",response_obj); //세션 생성
		model.addAttribute("result", apiResult);
		
		
		return "/common/index";
	}

	
	// 사용자 로그아웃
	@RequestMapping("/logout")
	public String logout(Client client, HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
		
	}
	
	
	
	
}
