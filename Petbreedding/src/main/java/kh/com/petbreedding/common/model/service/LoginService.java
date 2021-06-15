package kh.com.petbreedding.common.model.service;

import java.util.HashMap;

import kh.com.petbreedding.client.model.vo.Client;

public interface LoginService {
	
	public Client login(Client client); // 이메일 로그인
	public int loginKakao(Client client); // 카카오 로그인
	public int loginNaver(Client client); // 네이버 로그인 
}
