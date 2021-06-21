package kh.com.petbreedding.Chat.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.Chat.model.vo.ChatMessage;
import kh.com.petbreedding.Chat.model.vo.ChatRoom;

@Repository("chDao")
public class ChatDao {

	@Autowired
	private SqlSession sqlSession;

	public void createRoom(ChatRoom cr) throws Exception {
		sqlSession.insert("Chat.createRoom", cr);
	}

	public ChatRoom isRoom(ChatRoom cr) throws Exception {
		ChatRoom room = null;
		room = sqlSession.selectOne("Chat.isRoom", cr);
		System.out.println(room);

		return room;
	}

	public void insertMessage(ChatMessage cm) throws Exception {
		sqlSession.insert("Chat.insertMessage", cm);
	}
//	
//	public String getPartner(ChatRoom vo) throws Exception {
//		List<ChatMessage> mvo = sqlSession.selectList("Chat.getPartner", vo);
//		return mvo.get(0).getClNum();
//	}
//	

	public List<ChatRoom> getRoomList(String clNum) throws Exception {
		return sqlSession.selectList("Chat.getRoomList", clNum);
	}

	public List<ChatRoom> getRoomListBpId(String bpId) throws Exception {
		return sqlSession.selectList("Chat.getRoomList2", bpId);
	}

	public List<ChatMessage> getMessageList(String chatId) throws Exception {
		return sqlSession.selectList("Chat.getMessageList", chatId);
	}

	public List<ChatMessage> getMessageListBpId(String chatId) throws Exception {
		return sqlSession.selectList("Chat.getMessageListBpId", chatId);
	}

	public ChatMessage getRecentMessage(String chatId) throws Exception {
		return sqlSession.selectOne("Chat.getRecentMessage", chatId);
	}
//	
//	public String getId(String str) throws Exception {
//		return sqlSession.selectOne("Chat.getBpId" , str) ;
//	}

	public void updateReadTime(String clNum, String bpId) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bpId", bpId);
		map.put("clNUM", clNum);
		sqlSession.update("Chat.updateReadTime", map);
	}
	
	public void updateReadTimeBpId(String clNum, String bpId) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("clNUM", clNum);
		map.put("bpId", bpId);
		sqlSession.update("Chat.updateReadTimeBpId", map);
	}

	public int getUnReadCount(String clNum, String bpId) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bpId", bpId);
		map.put("clNUM", clNum);
		return sqlSession.selectOne("Chat.getUnreadCount", map);
	}
	
	public int getUnReadCountTutor(String clNum, String bpId) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("clNUM", clNum);
		map.put("bpId", bpId);
		return sqlSession.selectOne("Chat.getUnreadCountBpId", map);
	}

	public int getAllCount(String clNum, String bpId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("clNUM", clNum);
		map.put("bpId", bpId);
		if (sqlSession.selectOne("Chat.getAllCount", map) == null) {
			return 0;
		} else {
			return sqlSession.selectOne("Chat.getAllCount", map);
		}
	}
}