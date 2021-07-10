package kh.com.petbreedding.Shop.model.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.Shop.model.service.ShopListService;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.board.model.service.ReviewService;
import kh.com.petbreedding.common.model.service.LikesService;
import kh.com.petbreedding.common.model.vo.Pagination;

@Controller
public class ShopListController {

	@Autowired
	private ShopListService shopListService;
	
	@Autowired
	private LikesService likeService;
	
	@Autowired
	private ReviewService reviewService;
	
	
	// 사업장 전체 리스트  정렬
	@RequestMapping(value = "/shopList/all", method = RequestMethod.GET)
	public ModelAndView allShopListNew(
			ModelAndView mv
			,Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			,@RequestParam Long shopType
			, HttpServletRequest request
			) throws Exception {
		
		// shopType 0은 미용실, 1은 동물병원
		
		if (shopType == 0) {
			
			
			// 미용실 전체 리스트 카운팅
			int total = shopListService.countALLHarList();
			
			
			page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			mv.addObject("paging", page);
			
			
			List<HairSalon> allHarListNew = shopListService.selectAllHarListNew(page);
			System.out.println("미용실 전체 리스트 - 최신순 정렬 :: " + allHarListNew);
			mv.addObject("allShopListNew", allHarListNew);
			
			String har_num = null;
			String bpId = null;
			List<String> countList = new ArrayList<String>();
			List<String> avgList = new ArrayList<String>();
			List<String> revCountList = new ArrayList<String>();
			
			for(int i =0; i<allHarListNew.size(); i++) {
	
				// 찜한 숫자 가져오기
				// + 별점 출력 
				
				
				har_num = allHarListNew.get(i).getHarNum();
				bpId = allHarListNew.get(i).getBpId();
				
				String count = likeService.countSalon(har_num); //찜
				countList.add(count);
				mv.addObject("new_count", countList);
				
				String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
				avgList.add(revAvg);
				mv.addObject("new_revAvg", avgList);
				
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				revCountList.add(revCount);
				mv.addObject("new_revCount", revCountList);
				
				
			}
			
			List<HairSalon> allHarListLike = shopListService.selectAllHarListLike(page);
			System.out.println("미용실 전체 리스트 - 인기순 정렬 :: " + allHarListLike);
			mv.addObject("allShopListLike", allHarListLike);
			List<String> countList2 = new ArrayList<String>();
			List<String> avgList2 = new ArrayList<String>();
			List<String> revCountList2 = new ArrayList<String>();
			
			for(int i =0; i<allHarListLike.size(); i++) {
				
				har_num = allHarListLike.get(i).getHarNum();
				bpId = allHarListLike.get(i).getBpId();
				
				String count = likeService.countSalon(har_num); //찜
				countList2.add(count);
				mv.addObject("like_count", countList2);
				
				String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
				avgList2.add(revAvg);
				mv.addObject("like_revAvg", avgList2);
				
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				revCountList2.add(revCount);
				mv.addObject("like_revCount", revCountList2);
				
			}
			
			List<HairSalon> allHarListRev = shopListService.selectAllHarListRev(page);
			System.out.println("미용실 전체 리스트 - 별점순 정렬::"+allHarListRev);
			mv.addObject("allHarListRev", allHarListRev);
			List<String> countList3 = new ArrayList<String>();
			List<String> revCountList3 = new ArrayList<String>();
			
			for(int i=0; i<allHarListRev.size();i++) {
				har_num = allHarListRev.get(i).getHarNum();
				bpId = allHarListRev.get(i).getBpId();
				
				String count = likeService.countSalon(har_num); //찜
				countList3.add(count);
				mv.addObject("rev_count", countList3);
				
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				revCountList3.add(revCount);
				mv.addObject("rev_revCount", revCountList3);
			}
			
			
		}
				mv.setViewName("/user/uShop/shopList");
				
				return mv;
		
	}
	
	
}
