package kh.com.petbreedding.Chat.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Chat.model.dao.ChatDao;
import kh.com.petbreedding.Chat.model.vo.ChatList;
import kh.com.petbreedding.Chat.model.vo.ChatMessage;
import kh.com.petbreedding.Chat.model.vo.ChatRoom;

@Service("chService")
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatDao chDao;

	@Override
	public int createRoom(ChatRoom cr) {
		int result = 0;
		try {
			result = chDao.createRoom(cr);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ChatRoom isRoom(ChatRoom cr) {
		ChatRoom result = null;
		try {
			result = chDao.isRoom(cr);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertMessage(ChatMessage cm) {
		int result = 0;
		try {
			result = chDao.insertMessage(cm);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public ChatRoom selectChatRoom(String chatId) {
		ChatRoom result = null;
		try {
			result = chDao.selectChatRoom(chatId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<ChatList> getList(String cl_num) {
		List<ChatList> result = null;
		try {
			result = chDao.getList(cl_num);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ChatList> getListbp_id(String bp_id) {
		List<ChatList> result = null;
		try {
			result = chDao.getListbp_id(bp_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ChatMessage> getMessageList(String chatId) {
		List<ChatMessage> result = null;
		try {
			result = chDao.getMessageList(chatId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ChatMessage> getMessageListbp_id(String chatId) {
		List<ChatMessage> result = null;
		try {
			result = chDao.getMessageListbp_id(chatId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ChatMessage getRecentMessage(String chatId) {
		ChatMessage result = null;
		try {
			result = chDao.getRecentMessage(chatId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateReadTime(String cl_num, String bp_id) {
		int result = 0;
		try {
			result = chDao.updateReadTime(cl_num, bp_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateReadTimebp_id(String cl_num, String bp_id) {
		int result = 0;
		try {
			result = chDao.updateReadTimebp_id(cl_num, bp_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getUnReadCount(String cl_num, String bp_id) {
		int result = 0;
		try {
			result = chDao.getUnreadCount(cl_num, bp_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getUnreadCountbp_id(String cl_num, String bp_id) {
		int result = 0;
		try {
			result = chDao.getUnreadCountbp_id(cl_num, bp_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getAllCount(String cl_num, String bp_id) {
		int result = 0;
		try {
			result = chDao.getAllCount(cl_num, bp_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
