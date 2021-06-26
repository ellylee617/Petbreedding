package kh.com.petbreedding.Chat.model.vo;

import java.sql.Timestamp;

public class ChatList {
	
    private String chatId;
	private String cl_num;
	private String bp_id;
	private String mContent;
	private Timestamp mSendTime;
	private String shopName;
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getCl_num() {
		return cl_num;
	}
	public void setCl_num(String cl_num) {
		this.cl_num = cl_num;
	}
	public String getBp_id() {
		return bp_id;
	}
	public void setBp_id(String bp_id) {
		this.bp_id = bp_id;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	public Timestamp getmSendTime() {
		return mSendTime;
	}
	public void setmSendTime(Timestamp mSendTime) {
		this.mSendTime = mSendTime;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}	
	
}
