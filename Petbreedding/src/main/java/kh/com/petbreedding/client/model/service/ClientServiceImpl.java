package kh.com.petbreedding.client.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.client.model.dao.ClientDao;
import kh.com.petbreedding.client.model.vo.Client;


@Service("clientService")
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientDao clientDao;
	
	@Override
	public int insertClient(Client client) {
		int result = -1;
		try {
			result = clientDao.insertClient(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int checkEmail(String email) {
		int result = -1;
		try {
			result = clientDao.checkEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int checkNickName(String nickname) {
		int result = -1;
		try {
			result = clientDao.checkNickName(nickname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int checkHp(String tel) {
		int result = -1;
		try {
			result = clientDao.checkHp(tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteClient(String cl_num) {
		int result = -1;
		try {
			result = clientDao.deleteClient(cl_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return result;
	}





}
