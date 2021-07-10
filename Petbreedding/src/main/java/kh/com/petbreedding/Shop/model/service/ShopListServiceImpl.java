package kh.com.petbreedding.Shop.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Shop.model.dao.ShopListDao;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.common.model.vo.Pagination;

@Service("shopListService")
public class ShopListServiceImpl implements ShopListService {

	@Autowired
	ShopListDao shopListDao;
	
	
	// 사업장 공통
		
		// 사업장별 평균 별점
		@Override
		public String selectShopRevAvg(String bp_id) {
			System.out.println("shopListService selectShopRevVal() 실행");
			String revVal = "";
			revVal = shopListDao.selectShopRevAvg(bp_id);
			return revVal;
		}
		
		// 사업장별 등록된 리뷰 갯수
		@Override
		public String selectShopRevCount(String bp_id) {
			System.out.println("shopListService selectShopRevVal() 실행");
			String revCount = "";
			revCount = shopListDao.selectShopRevCount(bp_id);
			return revCount;
		}
	
	// 미용실 전체 리스트
	
		// 미용실 전체 리스트 카운팅
		@Override
		public int countALLHarList() {
			System.out.println("shopListService countALLHarList() 실행");
			int result = -1;
			try {
				result = shopListDao.countALLHarList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	
		// 미용실 전체 리스트 최신순 정렬 
		@Override
		public List<HairSalon> selectAllHarListNew(Pagination page) {
			System.out.println("shopListService selectAllHarListNew() 실행");
			List<HairSalon> list = null;
			try {
				list = shopListDao.selectAllHarListNew(page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		// 미용실 전체 리스트 인기순 정렬
		@Override
		public List<HairSalon> selectAllHarListLike(Pagination page) {
			System.out.println("shopListService selectAllHarListLike() 실행");
			List<HairSalon> list = null;
			try {
				list = shopListDao.selectAllHarListLike(page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		// 미용실 전체 리스트 별점순 정렬 
		@Override
		public List<HairSalon> selectAllHarListRev(Pagination page) {
			System.out.println("shopListService selectAllHarListRev() 실행");
			List<HairSalon> list = null;
			try {
				list = shopListDao.selectAllHarListRev(page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		
		
	// 미용실 위치 검색
		
		// 미용실 위치 검색 최신순 정렬
		@Override
		public List<HairSalon> selectHarListLocNew(HashMap map) {
			System.out.println("shopListService selectHarListLocNew() 실행");
			List<HairSalon> list = null;
			try {
				list = shopListDao.selectHarListLocNew(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		

		

}
