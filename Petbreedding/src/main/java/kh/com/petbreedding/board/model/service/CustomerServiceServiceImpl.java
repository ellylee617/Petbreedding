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
	public List<CustomerService> CustomerServiceSelectList() {
		List<CustomerService> result = null;
		
		try {
			result = customerServiceDao.CustomerServiceSelectList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
