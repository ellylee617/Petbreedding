package kh.com.petbreedding.common.model.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.dao.LoginDao;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public Client login(Client client) {
		Client result = null;
		
		try {
			result = loginDao.login(client);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int loginKakao(Client client) {
		// TODO Auto-generated method stub
		
		int result = -1;
		
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int loginNaver(Client client) {
		// TODO Auto-generated method stub
		
		int result = -1;
		
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
