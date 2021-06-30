package kh.com.petbreedding.Shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Shop.model.dao.BpReservationDao;
import kh.com.petbreedding.Shop.model.vo.HairShopReservation;

@Service("bprevService")
public class BpReservationServiceImpl implements BpReservationService{

	@Autowired
	private BpReservationDao bprevDao;

	@Override
	public List<HairShopReservation> revList(HairShopReservation vo) throws Exception {
		List<HairShopReservation> list = null;
		try {
			list = bprevDao.revList(vo);
			if(list != null){
				System.out.println("내 예약 리스트 있음");
			}else {
				System.out.println("내 예약 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<HairShopReservation> revAllList(String bp_id) throws Exception {
		List<HairShopReservation> list = null;
		try{
			list =  bprevDao.revAllList(bp_id);
			if(list != null) {
				System.out.println("전체 예약 리스트 있음");
			}else {
				System.out.println("전체 예약 리스트 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	
	
	

}
