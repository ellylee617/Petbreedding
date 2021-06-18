package kh.com.petbreedding.client.model.service;

import kh.com.petbreedding.client.model.vo.Client;

public interface ClientService {
	
	public int insertClient(Client client);	// 이메일 회원가입
	public int checkEmail(String email);	// 이메일 중복 확인 
	public int checkNickName(String nickname); //닉네임 중복 확인
	public int checkHp(String tel); //휴대폰번호 중복 확인
	public void clientAuth(Client cleint);	// 이메일 인증
	
}
