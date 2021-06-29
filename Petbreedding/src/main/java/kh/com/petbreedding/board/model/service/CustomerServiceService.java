package kh.com.petbreedding.board.model.service;

import java.util.List;

import kh.com.petbreedding.board.model.vo.CustomerService;

public interface CustomerServiceService {
	public List<CustomerService> CustomerServiceSelectListC();
	public List<CustomerService> CustomerServiceSelectListA();
	public int CustomerServiceInsert(CustomerService cs);
}
