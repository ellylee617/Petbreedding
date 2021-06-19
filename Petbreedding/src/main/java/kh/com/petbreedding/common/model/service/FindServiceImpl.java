package kh.com.petbreedding.common.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.dao.FindDao;

@Service("findService")
public class FindServiceImpl implements FindService{
	
	@Autowired
	private FindDao findDao;
	
	@Override
	public String findId(Client client) {
		String result = null;
		try {
			result = findDao.findId(client);
		} catch(Exception e) {
			e.printStackTrace();
		}	
		return result;
	}

	@Override
	public int findPwd(Client client) {
		int result = -1;
		try {
			result = findDao.findPwd(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int changePwd(Client client) {
		int result = -1;
		try {
			result = findDao.changePwd(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
