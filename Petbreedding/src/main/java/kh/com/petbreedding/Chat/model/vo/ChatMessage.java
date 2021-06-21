package kh.com.petbreedding.Chat.model.vo;

import java.sql.Timestamp;

public class ChatMessage {

	 private int mId;
	 private String mSender;
	 private String mReceiver;
	 private String mContent;
	 private Timestamp mSendTime;
	 private int chatId;
	 private String clNum;
	 private String bpId;
	 
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmSender() {
		return mSender;
	}
	public void setmSender(String mSender) {
		this.mSender = mSender;
	}
	public String getmReceiver() {
		return mReceiver;
	}
	public void setmReceiver(String mReceiver) {
		this.mReceiver = mReceiver;
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
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public String getClNum() {
		return clNum;
	}
	public void setClNum(String clNum) {
		this.clNum = clNum;
	}
	public String getBpId() {
		return bpId;
	}
	public void setBpId(String bpId) {
		this.bpId = bpId;
	}
	 
}
