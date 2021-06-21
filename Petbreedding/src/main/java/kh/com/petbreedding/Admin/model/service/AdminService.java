package kh.com.petbreedding.Admin.model.service;

import java.util.List;

import kh.com.petbreedding.BP.model.vo.BPartner;

public interface AdminService {

	public List<BPartner> waitList(); //제휴승인대기
	public int confirmBP(List<String> list);
	public int refuseBP(List<String> list);
	
	public List<BPartner> deleteList();
	public int deleteBP(List<String> list);
	public int backBP(List<String> list);
}
