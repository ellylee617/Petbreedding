package kh.com.petbreedding.Shop.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.common.model.vo.Pagination;

@Repository("shopListDao")
public class ShopListDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 사업장 공통
	
		// 사업장별 평균 별점
		public String selectShopRevAvg(String bp_id) {
			System.out.println("~~ ShopListDao 진입 ~~");
			return sqlSession.selectOne("shopList.selectShopRevAvg", bp_id);
		};
		
		// 사업장별 등록된 리뷰 갯수
		public String selectShopRevCount(String bp_id) {
			System.out.println("~~ ShopListDao 진입 ~~");
			return sqlSession.selectOne("shopList.selectShopRevCount", bp_id);
		};
	
	// 미용실 
	
		// 미용실 전체 리스트
		
			// 미용실 전체 리스트 카운팅
			public int countALLHarList() {
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectOne("shopList.countALLHarList");
			};
			
			// 미용실 전체 리스트 최신순 정렬 
			public  List<HairSalon> selectAllHarListNew(Pagination page){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectAllHarListNew", page);
			}
			
			// 미용실 전체 리스트 인기순 정렬
			public List<HairSalon> selectAllHarListLike(Pagination page){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectAllHarListLike", page);
			}
			
			// 미용실 전체 리스트 별점순 정렬
			public List<HairSalon> selectAllHarListRev(Pagination page){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectAllHarListRev", page);
			}
		
		// 미용실 위치(주소) 검색
			
			// 카운팅
				// 미용실 위치 검색 최신순 카운팅
				public  int countHarListLocNew(Map<String,Object> map){
					System.out.println("~~ ShopListDao 진입 ~~");
					return sqlSession.selectOne("shopList.countHarListLocNew", map);
				}
			
			
			// 미용실 위치 검색 최신순 정렬
			public  List<HairSalon> selectHarListLocNew(Map<String,Object> map){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectHarListLocNew", map);
			}
			// 미용실 위치 검색 인기순 정렬
			public  List<HairSalon> selectHarListLocLike(Map<String,Object> map){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectHarListLocLike", map);
			}
		
		
	

}
