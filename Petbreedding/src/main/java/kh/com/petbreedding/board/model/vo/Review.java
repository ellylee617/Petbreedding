package kh.com.petbreedding.board.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Review {
	private String revNum;
	private String bpId;
	private String clNum;
	private String clNickName;
	private String revCont;
	private String revImg;
	private String revDate;
	private int revVal;
	private int revView;
	
	@Override
	public String toString() {
		return "Review [revNum=" + revNum + ", bpId=" + bpId + ", clNum=" + clNum + ", clNickName=" + clNickName
				+ ", revCont=" + revCont + ", revImg=" + revImg + ", revDate=" + revDate + ", revVal=" + revVal
				+ ", revView=" + revView + "]";
	}

	public String getRevNum() {
		return revNum;
	}

	public void setRevNum(String revNum) {
		this.revNum = revNum;
	}

	public String getBpId() {
		return bpId;
	}

	public void setBpId(String bpId) {
		this.bpId = bpId;
	}

	public String getClNum() {
		return clNum;
	}

	public void setClNum(String clNum) {
		this.clNum = clNum;
	}

	public String getClNickName() {
		return clNickName;
	}

	public void setClNickName(String clNickName) {
		this.clNickName = clNickName;
	}

	public String getRevCont() {
		return revCont;
	}

	public void setRevCont(String revCont) {
		this.revCont = revCont;
	}

	public String getRevImg() {
		return revImg;
	}

	public void setRevImg(String revImg) {
		this.revImg = revImg;
	}

	public String getRevDate() {
		return revDate;
	}

	public void setRevDate(String revDate) {
		this.revDate = revDate;
	}

	public int getRevVal() {
		return revVal;
	}

	public void setRevVal(int revVal) {
		this.revVal = revVal;
	}

	public int getRevView() {
		return revView;
	}

	public void setRevView(int revView) {
		this.revView = revView;
	}
	
	
}
