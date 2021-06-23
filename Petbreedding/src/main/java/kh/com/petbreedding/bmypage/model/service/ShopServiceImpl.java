package kh.com.petbreedding.bmypage.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.bmypage.model.dao.ShopDao;
import kh.com.petbreedding.bmypage.model.vo.HairDayOff;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.HairSalonImg;
import kh.com.petbreedding.bmypage.model.vo.HosDayOff;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.HospitalImg;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;

	@Override
	public List<HairSalon> selectHarList(int currentPage, int limit) {
		List<HairSalon> salonList = null;
		System.out.println("¼­ºñ½º ¹Ì¿ë½Ç ¸®½ºÆ® ÁøÀÔ");
		try {
			salonList = shopDao.selectHarList(currentPage, limit);
		} catch(Exception e) {
		}
		System.out.println("¼­ºñ½º ¹Ì¿ë½Ç ¸®½ºÆ® ¸®ÅÏ Àü : " + salonList);
		return salonList;
	}
	
	@Override
	public int insertHarInfo(HairSalon vo) {

		int result = -1;

		try {
			result = shopDao.insertHarInfo(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int insertHarDayOff(HairDayOff vo) {
		
		int result = -1;

		try {
			result = shopDao.insertHarDayOff(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public int insertHarImg(HairSalonImg vo) {
		
		int result = -1;
		
		try {
			result = shopDao.insertHarImg(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int insertHosInfo(Hospital vo) {
		int result = -1;
		
		try {
			result = shopDao.insertHosInfo(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int insertHosDayOff(HosDayOff vo) {
		int result = -1;
		
		try {
			result = shopDao.insertHosDayOff(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int insertHosImg(HospitalImg vo) {
		int result = -1;
		
		try {
			result = shopDao.insertHosImg(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int updateHarInfo(HairSalon vo) {
		int result = -1;
		
		try {
			result = shopDao.updateHarInfo(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int deleteHarImg(String harNum) {
		int result = -1;
		
		try {
			result = shopDao.deleteHarImg(harNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteHarDayOff(String harNum) {
		int result = -1;
		
		try {
			result = shopDao.deleteHarDayOff(harNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateHosInfo(Hospital vo) {
		int result = -1;
		
		try {
			result = shopDao.updateHosInfo(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteHosImg(String hosNum) {
		int result = -1;
		
		try {
			result = shopDao.deleteHosImg(hosNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteHosDayOff(String hosNum) {
		int result = -1;
		
		try {
			result = shopDao.deleteHosDayOff(hosNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public HairSalon selectHarInfo(String bpId) {
		
		HairSalon vo = null;
		
		vo = shopDao.selectHarInfo(bpId);
		
		System.out.println("HairSalon vo::"+ vo);
		
		return vo;
	}

	@Override
	public int insertNewHarDayOff(HairDayOff vo) {
	int result = -1;
		
		try {
			result = shopDao.insertNewHarDayOff(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertNewHarImg(HairSalonImg vo) {
	int result = -1;
		
		try {
			result = shopDao.insertNewHarImg(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Hospital selectHosInfo(String bpId) {
		
		Hospital vo = null;
		vo = shopDao.selectHosInfo(bpId);
		
		System.out.println("Hospital vo::"+vo);
		
		return vo;
	}

	@Override
	public int insertNewHosImg(HospitalImg vo) {
		int result = -1;
		
		try {
			result = shopDao.insertNewHosImg(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertNewHosDayOff(HosDayOff vo) {
		int result = -1;
		
		try {
			result = shopDao.insertNewHosDayOff(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



}
