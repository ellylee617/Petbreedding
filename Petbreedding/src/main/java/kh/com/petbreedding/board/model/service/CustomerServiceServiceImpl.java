package kh.com.petbreedding.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.CustomerServiceDao;
import kh.com.petbreedding.board.model.vo.CustomerService;

@Service("customerServiceService")
public class CustomerServiceServiceImpl implements CustomerServiceService {
	
	@Autowired
	private CustomerServiceDao customerServiceDao;

	@Override
	public List<CustomerService> CustomerServiceSelectListC() {
		List<CustomerService> result = null;
		
		try {
			result = customerServiceDao.CustomerServiceSelectListC();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<CustomerService> CustomerServiceSelectListA() {
		List<CustomerService> result = null;
		
		try {
			result = customerServiceDao.CustomerServiceSelectListA();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int CustomerServiceInsert(CustomerService cs) {
		int result = -1;
		
		try {
			result = customerServiceDao.CustomerServiceInsert(cs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
