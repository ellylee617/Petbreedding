package kh.com.petbreedding.bmypage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.bmypage.model.dao.ShopDao;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;

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

}
