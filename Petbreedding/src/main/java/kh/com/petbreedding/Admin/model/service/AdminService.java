package kh.com.petbreedding.Admin.model.service;

import java.util.List;

import kh.com.petbreedding.BP.model.vo.BPartner;

public interface AdminService {

	public List<BPartner> waitList(); //제휴승인대기
	public int confirmBP(List<String> list);
}
