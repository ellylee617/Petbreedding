package kh.com.petbreedding.mypage.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.mypage.model.dao.NoticeDao;
import kh.com.petbreedding.mypage.model.vo.Notice;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public List<Notice> getNoticeList(String notReceiver) {
		List<Notice> list = null;

		try {
			list = noticeDao.getNoticeList(notReceiver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int inReservaion(Notice notice) {
		int result = 0;

		try {
			result = noticeDao.inReservaion(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int inPay(Notice notice) {
		int result = 0;

		try {
			result = noticeDao.inPay(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int inUnreadChat(Notice notice) {
		int result = 0;

		try {
			result = noticeDao.inUnreadChat(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int inBoard(Notice notice) {
		int result = 0;

		try {
			result = noticeDao.inBoard(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int inQna(Notice notice) {
		int result = 0;

		try {
			result = noticeDao.inQna(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int inPointSave(Notice notice) {
		int result = 0;

		try {
			result = noticeDao.inPointSave(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int inPointUsing(Notice notice) {
		int result = 0;

		try {
			result = noticeDao.inPointUsing(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int updateReadState(String notNum) {
		int result = 0;

		try {
			result = noticeDao.updateReadState(notNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteNotice(String notNum) {
		int result = 0;

		try {
			result = noticeDao.deleteNotice(notNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
