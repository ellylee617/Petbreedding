package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import kh.com.petbreedding.board.model.vo.CustomerService;

public interface CustomerServiceService {
	public List<CustomerService> CustomerServiceSelectListC();	// 공지사항 리스트 조회 (고객)
	public List<CustomerService> CustomerServiceSelectListB(Map<String, String> paging);	// 공지사항 리스트 조회 (사업자고객)
	public List<CustomerService> CustomerServiceSelectListA();	// 공지사항 리스트 조회 (관리자)
	public CustomerService CustomerServiceSelectOne(String ann_num);	// 공지사항 상세조회
	public int CustomerServiceInsert(CustomerService cs);	// 공지사항 등록
	public int CustomerServiceUpdate(CustomerService cs);	// 공지사항 수정
	public int CustomerServiceDelete(String ann_num);	// 공지사항 삭제
	
	public int ListBCount(); //사업자 공지사항 개수
}
