package kh.com.petbreedding.mypage.model.service;

import org.springframework.stereotype.Service;

import kh.com.petbreedding.client.model.vo.Client;

@Service("clientInfoService")
public class ClientInfoServiceImpl implements ClientInfoService {

	@Override
	public String selectClientInfo(String email) {
		// TODO Auto-generated method stub
		String result = null;
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void updateClientInfo(Client client) {
		// TODO Auto-generated method stub
		
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteClient(String email) {
		// TODO Auto-generated method stub
		
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
