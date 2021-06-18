package kh.com.petbreedding.bmypage.model.vo;


import org.springframework.stereotype.Component;

@Component
public class HairSalonImg {
	
	private String imgNum; // 이미지 번호 
	private String harNumImg;	// 미용실번호
	private String shopImg;	// 미용실 매장 이미지 (파일명)
	@Override
	public String toString() {
		return "HairSalonImg [imgNum=" + imgNum + ", harNumImg=" + harNumImg + ", shopImg=" + shopImg + "]";
	}
	public String getImgNum() {
		return imgNum;
	}
	public void setImgNum(String imgNum) {
		this.imgNum = imgNum;
	}
	public String getHarNumImg() {
		return harNumImg;
	}
	public void setHarNumImg(String harNumImg) {
		this.harNumImg = harNumImg;
	}
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	
	
	
	
	
}
