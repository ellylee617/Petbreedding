package kh.com.petbreedding.common.model.service;


import kh.com.petbreedding.client.model.vo.Client;

public interface FindService {

	String findId(Client client); // 아이디 찾기
	String findPwd(Client client); // 비밀번호 찾기

}
