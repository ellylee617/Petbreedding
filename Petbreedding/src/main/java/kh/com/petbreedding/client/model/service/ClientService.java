package kh.com.petbreedding.client.model.service;

import kh.com.petbreedding.client.model.vo.Client;

public interface ClientService {
	
	int insertClient(Client client);	// 이메일 회원가입
	int checkEmail(Client client);	// 이메일 중복 확인 
	void clientAuth(Client cleint);	// 이메일 인증
}
