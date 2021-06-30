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
	public List<HairShopReservation> revList() {
		return bprevDao.revList();
	}


	
	
	

}
