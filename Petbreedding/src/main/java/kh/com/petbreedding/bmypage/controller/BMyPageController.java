package kh.com.petbreedding.bmypage.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.bmypage.model.service.ShopService;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.HairSalonImg;

@Controller
public class BMyPageController {
	
	@Autowired
	private ShopService shopService;

	// 사장님 마이 페이지 내정보 수정
	@RequestMapping(value = "/bMyPageUpdate", method = RequestMethod.GET)
	public String bMyPageUpdate(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bMyPage/bMyPageUpdate";
	}

	// 사장님 마이 페이지 공지사항
	@RequestMapping(value = "/bNotice", method = RequestMethod.GET)
	public String bNotice(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bBoard/bNotice";
	}

	// 사장님 마이 페이지 자주 묻는 질문
	@RequestMapping(value = "/bFAQ", method = RequestMethod.GET)
	public String bFAQ(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bBoard/bFAQ";
	}

	// 사장님 마이 페이지 1:1문의 내역
	@RequestMapping(value = "/bQna", method = RequestMethod.GET)
	public String bQna(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bBoard/bQna";
	}
	
	// 사장님 마이 페이지 1:1문의하기
	@RequestMapping(value = "/bQna/write", method = RequestMethod.GET)
	public String bQnaWrite(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bBoard/bQnaWrite";
	}

	// 사장님 메뉴관리
	@RequestMapping(value = "/bMenu", method = RequestMethod.GET)
	public String bMenu(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bShop/bmenu_manage";
	}

	// 사장님 매출관리
	@RequestMapping(value = "/bCalculate", method = RequestMethod.GET)
	public String bCalculate(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bSales/bcalculate";
	}


	
	
	// 사장님 사업장 관리 - 사업자 등록 페이지 이동
	@RequestMapping(value = "/bShop", method = RequestMethod.GET)
	public String bShop() {
		return "/bPartner/bShop/bShopInfo";
	}
	
	// 사장님 사업장 관리 - 사업자 등록 기능 (미용실) + 이미지 
	@RequestMapping(value = "/bShop/write", method = RequestMethod.POST)
	public ModelAndView bShopWrite(HairSalon vo, MultipartHttpServletRequest request) {
		
		
		System.out.println(vo.toString());
		
		// 미용실 기본 정보 등록
		shopService.insertHarInfo(vo);
		
		
		// 미용실  매장 사진 등록
		
		// 파일 업로드
		
		String savePath = request.getRealPath("resources/uploadFile/hairsalon"); //파일이 저장될 위치

		// 넘어온 파일을 리스트로 저장
        List<MultipartFile> mf = request.getFiles("shopImg");//업로드 파라미터 
		
		if(mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for(int i = 0; i < mf.size(); i++) {
				
				//TODO: 파일 중복 처리 
				
                
                String originalfileName = mf.get(i).getOriginalFilename(); // 본래 파일명
                File uploadFile = new File(savePath+"//"+originalfileName); //복사될 위치 
                
             // 파일 저장
                try {
					
                	mf.get(i).transferTo(uploadFile);
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 

                System.out.println("파일명:"+originalfileName);
                
                HairSalonImg vo2 = new HairSalonImg();
                vo2.setShopImg(originalfileName);	// HAIR_SALON_IMG 테이블 HAR_IMG 컬럼에 파일명 삽입 
                shopService.insertHarImg(vo2);
                
                System.out.println(vo2.toString());
                
			}
		}
		
		
		return new ModelAndView("redirect:"); //TODO:수정해야됨!!!!
	}
	
	
	
	

	// 업체 리뷰 관리 페이지로 이동
	@RequestMapping(value = "/bReview", method = RequestMethod.GET)
	public String bReview(Locale locale, Model model) {
		return "/bPartner/bShop/bReview";
	}

}
