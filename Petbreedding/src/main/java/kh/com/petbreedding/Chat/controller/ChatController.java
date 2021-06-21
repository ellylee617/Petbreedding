package kh.com.petbreedding.Chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

	@GetMapping("/chat")
	public String chat() {
		return "/user/uMyPage/myChatRoom";
	}
	
	@GetMapping("/chatlist")
	public String chatlist() {
		return "/user/uMyPage/myChatList";
	}
}
