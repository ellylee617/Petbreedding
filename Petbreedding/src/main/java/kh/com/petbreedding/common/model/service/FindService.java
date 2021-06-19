package kh.com.petbreedding.common.model.service;


import kh.com.petbreedding.client.model.vo.Client;

public interface FindService {

	public String findId(Client client); // 아이디 찾기
	public int findPwd(Client client); // 비밀번호 찾기
	public int changePwd(Client client); //비밀번호 재설정
}
