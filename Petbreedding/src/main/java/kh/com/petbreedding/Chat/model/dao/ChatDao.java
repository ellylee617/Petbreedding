package kh.com.petbreedding.Chat.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.Chat.model.vo.ChatList;
import kh.com.petbreedding.Chat.model.vo.ChatMessage;
import kh.com.petbreedding.Chat.model.vo.ChatRoom;

@Repository("chDao")
public class ChatDao {

	@Autowired
	private SqlSession sqlSession;

	public int createRoom(ChatRoom cr) throws Exception {
		return sqlSession.insert("Chat.createRoom", cr);
	}

	public ChatRoom isRoom(ChatRoom cr) throws Exception {
		ChatRoom room = null;
		room = sqlSession.selectOne("Chat.isRoom", cr);
		System.out.println(room);

		return room;
	}

	public int insertMessage(ChatMessage cm) throws Exception {
		return sqlSession.insert("Chat.insertMessage", cm);
	}
//	
//	public String getPartner(ChatRoom vo) throws Exception {
//		List<ChatMessage> mvo = sqlSession.selectList("Chat.getPartner", vo);
//		return mvo.get(0).getcl_num();
//	}
//	
	
	public List<ChatList> getList(String cl_num) throws Exception {
		return sqlSession.selectList("Chat.getList", cl_num);
	}

	public List<ChatList> getListbp_id(String bp_id) throws Exception {
		return sqlSession.selectList("Chat.getListbp_id", bp_id);
	}

	public List<ChatMessage> getMessageList(String chatId) throws Exception {
		return sqlSession.selectList("Chat.getMessageList", chatId);
	}

	public List<ChatMessage> getMessageListbp_id(String chatId) throws Exception {
		return sqlSession.selectList("Chat.getMessageListbp_id", chatId);
	}

	public ChatMessage getRecentMessage(String chatId) throws Exception {
		return sqlSession.selectOne("Chat.getRecentMessage", chatId);
	}
//	
//	public String getId(String str) throws Exception {
//		return sqlSession.selectOne("Chat.getbp_id" , str) ;
//	}

	public int updateReadTime(String cl_num, String bp_id) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bp_id", bp_id);
		map.put("cl_num", cl_num);
		return sqlSession.update("Chat.updateReadTime", map);
	}
	
	public int updateReadTimebp_id(String cl_num, String bp_id) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cl_num", cl_num);
		map.put("bp_id", bp_id);
		return sqlSession.update("Chat.updateReadTimebp_id", map);
	}

	public int getUnreadCount(String cl_num, String bp_id) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bp_id", bp_id);
		map.put("cl_num", cl_num);
		return sqlSession.selectOne("Chat.getUnreadCount", map);
	}
	
	public int getUnreadCountbp_id(String cl_num, String bp_id) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cl_num", cl_num);
		map.put("bp_id", bp_id);
		return sqlSession.selectOne("Chat.getUnreadCountbp_id", map);
	}

	public int getAllCount(String cl_num, String bp_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cl_num", cl_num);
		map.put("bp_id", bp_id);
		if (sqlSession.selectOne("Chat.getAllCount", map) == null) {
			return 0;
		} else {
			return sqlSession.selectOne("Chat.getAllCount", map);
		}
	}
}