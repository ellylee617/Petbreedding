package kh.com.petbreedding.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.MyAskDao;
import kh.com.petbreedding.board.model.vo.MyAsk;

@Service("myAskService")
public class MyAskServiceImpl implements MyAskService {
	
	@Autowired
	private MyAskDao myAskDao;

	@Override
	public List<MyAsk> MyAskSelectList(String user_num) {
		List<MyAsk> result = null;
		System.out.println("[세훈] @일대일 문의 서비스 진입");
		
		try {
			result = myAskDao.MyAskSelectList(user_num);
			System.out.println("[세훈] @일대일 문의 서비스 result : " + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public MyAsk MyAskSelectDetail(String qna_num) {
		MyAsk result = null;
		
		try {
			result = myAskDao.MyAskSelectOne(qna_num);
			System.out.println("[세훈] @일대일 문의 상세 서비스 result : " + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	
	
}
