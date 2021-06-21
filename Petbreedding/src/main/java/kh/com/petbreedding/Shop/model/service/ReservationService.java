package kh.com.petbreedding.Shop.model.service;

import java.util.List;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.mypage.model.vo.MyPet;

public interface ReservationService {
	public List<Style> revList(String har_num);
	public List<MyPet> revList2(String cl_num);
	public List<Style> revList3(String har_num);
	public int insertHairRev(HairShopReservation hrv);
}
