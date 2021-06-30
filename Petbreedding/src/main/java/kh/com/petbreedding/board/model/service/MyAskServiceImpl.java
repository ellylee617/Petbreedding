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
	public int listCount() {
		int result = -1;
		
		try {
			result = myAskDao.listCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

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
	public List<MyAsk> MyAskSelectListM(int currentPage, int limit) {
		List<MyAsk> result = null;
		
		try {
			result = myAskDao.MyAskSelectListM(currentPage, limit);
			System.out.println("[세훈] @일대일 문의 서비스M result : " + result);
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

	@Override
	public int MyAskInsert(MyAsk myAsk) {
		int result = 0;
		String user_num = myAsk.getUserNum();
		if(user_num.contains("CL")) {
			String qna_wr = myAskDao.getClientNickName(user_num);
			myAsk.setQnaWr(qna_wr);
			myAsk.setQnaType(1);
			System.out.println("[세훈] @MyAsk 서비스 qna_wr" + qna_wr);
		} else {
			String qna_wr = myAskDao.getBpNickName(user_num);
			myAsk.setQnaWr(qna_wr);
			myAsk.setQnaType(2);
			System.out.println("[세훈] @MyAsk 사장님 서비스 qna_wr" + qna_wr);
		}
		
		
		
		try {
			result = myAskDao.MyAskInsert(myAsk);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}


}
