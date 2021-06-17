package kh.com.petbreedding.bmypage.model.vo;

import org.springframework.stereotype.Component;

@Component
public class HairSalonImg {
	
	private String harNum;	// 미용실번호
	private String harImg;	// 미용실 메인이미지
	
	@Override
	public String toString() {
		return "HairSalonImg [harNum=" + harNum + ", harImg=" + harImg + "]";
	}

	public String getHarNum() {
		return harNum;
	}

	public void setHarNum(String harNum) {
		this.harNum = harNum;
	}

	public String getHarImg() {
		return harImg;
	}

	public void setHarImg(String harImg) {
		this.harImg = harImg;
	}
	
	
	
}
