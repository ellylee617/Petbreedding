package kh.com.petbreedding.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.CustomerService;

@Repository("customerServiceDao")
public class CustomerServiceDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<CustomerService> CustomerServiceSelectListC() {
		return sqlSession.selectList("CustomerService.CustomerServiceSelectListC");
	}
	public List<CustomerService> CustomerServiceSelectListA() {
		return sqlSession.selectList("CustomerService.CustomerServiceSelectListA");
	}
}
