package kh.com.petbreedding.Chat.model.dao;

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

	// 채팅방 만들기
	public int createRoom(ChatRoom cr) throws Exception {
		return sqlSession.insert("Chat.createRoom", cr);
	}

	// 채팅방 존재하는지 확인
	public ChatRoom isRoom(ChatRoom cr) throws Exception {
		return sqlSession.selectOne("Chat.isRoom", cr);
	}

	// 메시지 작성시마다 저장
	public int insertMessage(ChatMessage cm) throws Exception {
		return sqlSession.insert("Chat.insertMessage", cm);
	}
	
	// 채팅방 아이디로 채팅방 찾기
	public ChatRoom selectChatRoom(String chatId) throws Exception {
		return sqlSession.selectOne("Chat.selectChatRoom", chatId);
	}
	
	// 채팅방 리스트 찾기(client)
	public List<ChatList> getList(String cl_num) throws Exception {
		return sqlSession.selectList("Chat.getList", cl_num);
	}

	// 채팅방 리스트 찾기(bPartner)
	public List<ChatList> getListbp_id(String bp_id) throws Exception {
		return sqlSession.selectList("Chat.getListbp_id", bp_id);
	}
	
	// 안읽은메시지가 있는 채팅방 리스트 찾기(client)
	public List<ChatList> getUnreadList(String cl_num) throws Exception {
		return sqlSession.selectList("Chat.getUnreadList", cl_num);
	}
	
	// 안읽은메시지가 있는 채팅방 리스트 찾기(bPartner)
	public List<ChatList> getUnreadListbp_id(String bp_id) throws Exception {
		return sqlSession.selectList("Chat.getUnreadListbp_id", bp_id);
	}	

	// 채팅방의 메시지 리스트(client)
	public List<ChatMessage> getMessageList(String chatId) throws Exception {
		return sqlSession.selectList("Chat.getMessageList", chatId);
	}

	// 채팅방의 메시지 리스트(bPartner)
	public List<ChatMessage> getMessageListbp_id(String chatId) throws Exception {
		return sqlSession.selectList("Chat.getMessageListbp_id", chatId);
	}

	// 해당 채팅방의 내가 안 읽은 메시지 리스트(client)
	public List<ChatMessage> getUnreadCount(ChatMessage cm) throws Exception {
		return sqlSession.selectList("Chat.getUnreadCount", cm);
	}
	
	// 해당 채팅방의 내가 안 읽은 메시지 리스트(bPartner)
	public List<ChatMessage> getUnreadCountbp_id(ChatMessage cm) throws Exception {
		return sqlSession.selectList("Chat.getUnreadCountbp_id", cm);
	}
	
	public int updateUnreadCount(String mId) throws Exception {
		return sqlSession.update("Chat.updateUnreadCount", mId);
	}
	
	public int getAllCount(String mReceiver) throws Exception {
		return sqlSession.selectOne("Chat.getAllCount", mReceiver);
	}
}