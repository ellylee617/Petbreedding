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

import kh.com.petbreedding.BP.model.vo.BPartner;
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
			@RequestParam(value = "chatId") String chatId, 
			@RequestParam(value = "shopName", required=false) String ShopName, 
			HttpServletRequest req) {
		List<ChatMessage> list = null;
		HttpSession session = req.getSession();
		Client client = (Client) session.getAttribute("client");
		String nickName = "";
		String email="";
		
		if (session != null) {
			nickName = client.getNickname();
			email = client.getEmail();
			list = chService.getMessageList(chatId);
		}
		String user = "user";
		mv.addObject("user", user);
		mv.addObject("email", email);
		mv.addObject("chatlist", list);
		mv.addObject("ShopName", ShopName);
		mv.addObject("nickName", nickName);
		mv.setViewName("/user/uMyPage/myChatRoom");
		return mv;
	}
	
	@RequestMapping("/bchat")
	public ModelAndView bchat(ModelAndView mv,
			@RequestParam(value = "chatId") String chatId, 
			@RequestParam(value = "nickName", required=false) String nickName, 			
			@RequestParam(value = "shopName", required=false) String shopName, 			
			HttpServletRequest req) {
		List<ChatMessage> list = null;
		HttpSession session = req.getSession();
		BPartner bpartner = (BPartner) session.getAttribute("bP");
		String email = "";
		if (session != null) {
			email = bpartner.getBp_email();
			list = chService.getMessageListbp_id(chatId);
		}
		String user = "bPartber";
		mv.addObject("user", user);
		mv.addObject("email", email);
		mv.addObject("chatlist", list);
		mv.addObject("nickName", nickName);
		mv.addObject("shopName", shopName);
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
