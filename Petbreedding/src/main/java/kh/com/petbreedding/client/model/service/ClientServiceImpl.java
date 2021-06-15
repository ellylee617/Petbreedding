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
		int result = 0;
		try {
			result = clientDao.checkEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void clientAuth(Client cleint) {
		// TODO Auto-generated method stub
		
	}



}
