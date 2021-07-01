package kh.com.petbreedding.Shop.model.service;

import java.util.List;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;

public interface BpReservationService {
	public List<HairShopReservation> revList(HairShopReservation vo) throws Exception;
	public List<HairShopReservation> revAllList(String bp_id) throws Exception;
	public List<HairShopReservation> revAllListDate(HairShopReservation vo) throws Exception;
}
