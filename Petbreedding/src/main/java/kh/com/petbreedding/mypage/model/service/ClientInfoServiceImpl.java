package kh.com.petbreedding.mypage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.dao.ClientInfoDao;

@Service("clientInfoService")
public class ClientInfoServiceImpl implements ClientInfoService {

	@Autowired
	private ClientInfoDao clientInfoDao;
	
	
	@Override
	public String selectClientInfo(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateClientInfo(Client client) {
		int result = -1;
		try {
			result = clientInfoDao.updateClientInfo(client);				
		} catch (Exception e) {
			System.out.println("!!!!!!!!!!!!!!error!!!!!!!!!! : "+ e);
		}
		return result;
	}

	@Override
	public void deleteClient(String email) {
		// TODO Auto-generated method stub
		
	}

}
