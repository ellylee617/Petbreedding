package kh.com.petbreedding.board.model.service;

import java.util.List;

import kh.com.petbreedding.board.model.vo.CustomerService;

public interface CustomerServiceService {
	public List<CustomerService> CustomerServiceSelectListC();
	public List<CustomerService> CustomerServiceSelectListA();
	public CustomerService CustomerServiceSelectOne(String ann_num);
	public int CustomerServiceInsert(CustomerService cs);
	public int CustomerServiceDelete(String ann_num);
}
