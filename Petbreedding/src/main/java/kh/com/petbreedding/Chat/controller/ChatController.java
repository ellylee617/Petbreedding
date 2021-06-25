package kh.com.petbreedding.Chat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.Chat.model.service.ChatService;
import kh.com.petbreedding.Chat.model.vo.ChatList;
import kh.com.petbreedding.Chat.model.vo.ChatMessage;
import kh.com.petbreedding.Chat.model.vo.ChatRoom;
import kh.com.petbreedding.bmypage.model.service.ShopService;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.client.model.vo.Client;

@Controller
public class ChatController {
	
	@Autowired
	private ChatService chService;
	@Autowired
	private ShopService shopService;

	@RequestMapping("/chat")
	public ModelAndView chat(ModelAndView mv,
			@RequestParam(value = "inbpId") String chatId, 
			@RequestParam(value = "inbname", required=false) String ShopName, 
			HttpServletRequest req) {
		System.out.println("chatId" + chatId);
		List<ChatMessage> list = null;
		HttpSession session = req.getSession();
		Client client = (Client) session.getAttribute("client");
		String nickName = "";
		if (session != null) {
			String cl_num = client.getCl_num();
			nickName = client.getNickname();
			list = chService.getMessageList(chatId);
			System.out.println("list" + list);
		}
		mv.addObject("chatlist", list);
		mv.addObject("ShopName", ShopName);
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
		}
		
		mv.addObject("Roomlist", list);
		mv.setViewName("/user/uMyPage/myChatList");
		return mv;
	}
}
