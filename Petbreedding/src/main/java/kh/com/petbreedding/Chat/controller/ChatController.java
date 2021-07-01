package kh.com.petbreedding.Chat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.Chat.model.service.ChatService;
import kh.com.petbreedding.Chat.model.vo.ChatList;
import kh.com.petbreedding.Chat.model.vo.ChatMessage;
import kh.com.petbreedding.Chat.model.vo.ChatRoom;
import kh.com.petbreedding.client.model.vo.Client;

@Controller
public class ChatController {

	@Autowired
	private ChatService chService;

	@RequestMapping("/chat")
	public ModelAndView chat(ModelAndView mv, @RequestParam(value = "chatId", required = false) String chatId,
			@RequestParam(value = "shopName", required = false) String shopName,
			@RequestParam(value = "clNum", required = false) String clNum,			
			@RequestParam(value = "bp_id", required = false) String bp_id, HttpServletRequest req) {
			
		List<ChatMessage> list = null;
		
		HttpSession session = req.getSession();
		Client client = (Client) session.getAttribute("client");
		
		String nickName = "";
		String id = "";
		String cl_num = "";
		
		// 우선 세션이 널이 아니면
		if(session!=null) {
			nickName = client.getNickname();
			id = client.getEmail();
			cl_num = client.getCl_num();
		}
		
		// 채팅방 번호가 없다면
		if (chatId == null) {
			ChatRoom cr = new ChatRoom();
			cr.setCl_num(clNum);
			cr.setBp_id(bp_id);
			
			// 채팅방이 있는지 한번 확인 후
			ChatRoom roomResult = null;
			roomResult = chService.isRoom(cr);
			// 기존의 채팅방이 없다면
			if (roomResult == null) {
				int result = 0;
				// 채팅방 생성
				result = chService.createRoom(cr);
				if(result == 1) {
					System.out.println("채팅방 생성 성공");
				} else {
					System.out.println("채팅방 생성 실패");
				}
			} else {
				//기존의 채팅방이 있다면
				chatId = roomResult.getChatId();
				list = chService.getMessageList(chatId);
			}
		} else if (chatId !=null) {
			list = chService.getMessageList(chatId);
		}
				
		String user = "user";
		mv.addObject("cl_num", cl_num);
		mv.addObject("bp_id", bp_id);
		mv.addObject("user", user);
		mv.addObject("chatlist", list);
		mv.addObject("id", id);
		mv.addObject("chatId", chatId);
		mv.addObject("shopName", shopName);
		mv.addObject("nickName", nickName);
		mv.setViewName("/user/uMyPage/myChatRoom");
		return mv;
	}

	@RequestMapping("/bchat")
	public ModelAndView bchat(ModelAndView mv, @RequestParam(value = "chatId", required = false) String chatId,
			@RequestParam(value = "nickName", required = false) String nickName,
			@RequestParam(value = "shopName", required = false) String shopName,
			@RequestParam(value = "cl_num", required = false) String cl_num, HttpServletRequest req) {
		
		List<ChatMessage> list = null;
		HttpSession session = req.getSession();
		BPartner bpartner = (BPartner) session.getAttribute("bP");
		String id = "";
		String bp_id = "";
		if (session != null) {
			id = bpartner.getBp_email();
			bp_id = bpartner.getBp_Id();
			list = chService.getMessageListbp_id(chatId);
			if (list == null) {
				ChatRoom cr = null;
				cr.setCl_num(cl_num);
				cr.setBp_id(bp_id);
				int result = 0;
				result = chService.createRoom(cr);
				if (result == 1) {
					list = chService.getMessageListbp_id(chatId);
				}
			}
		}
		
		System.out.println("사업자 받은 cl_num " + cl_num);
		
		String user = "bPartber";
		mv.addObject("cl_num", cl_num);
		mv.addObject("bp_id", bp_id);
		mv.addObject("user", user);
		mv.addObject("chatlist", list);
		mv.addObject("id", id);
		mv.addObject("chatId", chatId);
		mv.addObject("shopName", shopName);
		mv.addObject("nickName", nickName);
		mv.setViewName("/user/uMyPage/myChatRoom");
		return mv;
	}

	@RequestMapping("/chatlist")
	public ModelAndView chatlist(ModelAndView mv, HttpServletRequest req) {
		List<ChatList> list = null;
		HttpSession session = req.getSession();
		Client client = (Client) session.getAttribute("client");
		if (session != null) {
			String cl_num = client.getCl_num();
			list = chService.getList(cl_num);
			System.out.println("겟리스트" + list);
		}
		mv.addObject("Roomlist", list);
		mv.setViewName("/user/uMyPage/myChatList");
		return mv;
	}

	@RequestMapping("/bchatlist")
	public ModelAndView bchatlist(ModelAndView mv, HttpServletRequest req) {
		List<ChatList> list = null;
		HttpSession session = req.getSession();
		BPartner bpartner = (BPartner) session.getAttribute("bP");
		System.out.println(bpartner);
		if (session != null) {
			String bpId = bpartner.getBp_Id();
			list = chService.getListbp_id(bpId);
		}
		mv.addObject("Roomlist", list);
		mv.setViewName("/bPartner/bChat/bChatList");
		return mv;
	}
}
