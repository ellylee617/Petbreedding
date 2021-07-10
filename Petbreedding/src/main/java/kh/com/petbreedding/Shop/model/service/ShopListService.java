package kh.com.petbreedding.Shop.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.common.model.vo.Pagination;

public interface ShopListService {
	
	// 사업장 공통
		
		// 사업장별 평균 별점 
		public String selectShopRevAvg(String bp_id);
		
		// 사업장별 등록된 리뷰 갯수
		public String selectShopRevCount(String bp_id);
		

	// 미용실 전체 리스트
	
		// 미용실 전체 리스트 카운팅
		public int countALLHarList();
		
		// 미용실 전체 리스트  최신순 정렬 
		public  List<HairSalon> selectAllHarListNew(Pagination page);
		
		// 미용실 전체 리스트 인기순 정렬
		public List<HairSalon> selectAllHarListLike(Pagination page);
		
		// 미용실 전체 리스트 별점순 정렬 
		public List<HairSalon> selectAllHarListRev(Pagination page);
		
		
	// 미용실 위치 검색
		
		// 카운팅
			//  미용실 위치 검색 최신순 카운팅
			public  int countHarListLocNew(Map<String,Object> map);
		
		// 미용실 위치 검색 최신순 정렬
		public  List<HairSalon> selectHarListLocNew(Map<String,Object> map);
		// 미용실 위치 검색 최신순 정렬
		public  List<HairSalon> selectHarListLocLike(Map<String,Object> map);
		
		
}
