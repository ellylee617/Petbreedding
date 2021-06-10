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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findPwd(Client client) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
